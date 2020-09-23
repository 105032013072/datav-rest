package com.bosssoft.platform.datav.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.bosssoft.platform.datav.constant.BasicConstant;
import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.mapper.CategoryMapper;
import com.bosssoft.platform.datav.mapper.DataViewMapper;
import com.bosssoft.platform.datav.service.CategoryService;
import com.bosssoft.platform.datav.util.DatavUtil;
import com.bosssoft.platform.datav.vo.CategoryTreeNode;


public  abstract class CategoryServiceImpl implements CategoryService {

    protected CategoryMapper categoryMapper;
    
    protected DataViewMapper dataViewMapper;
    
    @Override
    public Category getCategoryById(String categoryId) {
        return (Category)categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public Category saveCategory(Category category) {
        category.setCategoryId(DatavUtil.getUUID32());
        category.setCreateTime(new Date());
        category.setCreateUser(BasicConstant.DEFAULT_OPERATOR);

        categoryMapper.insertSelective(category);

        return category;
    }

    @Override
    @Transactional
    public void deleteCategory(String categoryId) {
        //删除该分类下的数据视图
        DataView condition=creatBelongingDataView();
        condition.setCategoryId(categoryId);
        dataViewMapper.delete(condition);
        
        //删除分类
        categoryMapper.deleteByPrimaryKey(categoryId);
        
        //获取子分类
        Category categoryCondition=createCategory();
        categoryCondition.setParentId(categoryId);
        List<Category> childrenCategory=categoryMapper.select(categoryCondition);
        
        //删除子分类
        for (Category category : childrenCategory) {
            deleteCategory(category.getCategoryId());
        }
    }

    @Override
    public Category modifyCategory(Category category) {
        category.setModifyTime(new Date());
        category.setModifyUser(BasicConstant.DEFAULT_OPERATOR);

        categoryMapper.updateByPrimaryKeySelective(category);
        return category;
    }

    @Override
    public List<CategoryTreeNode> getCategoryTree(String categoryNameLike) {
        List<CategoryTreeNode> tree = new ArrayList<CategoryTreeNode>();
        List<Category> formCategorys = new ArrayList<Category>();
        if (StringUtils.isEmpty(categoryNameLike)) {
            // 获取所有分类
            formCategorys = categoryMapper.selectAll();
            return createCategoryTreeHasParent(formCategorys);
        } else {
            // 根据条件查询
            formCategorys = categoryMapper.selectCategoryByNameLike(categoryNameLike);
            return createCategoryTreeAllLeaf(formCategorys);
        }
    }
    
    /**
     * 带有父子层级关系
     * 
     * @param categories
     * @return
     */
    private List<CategoryTreeNode> createCategoryTreeHasParent(List<Category> categories) {
        List<CategoryTreeNode> result = new ArrayList<>();
        // 保存父亲节点ID及其对应的孩子节点
        Map<String, List<Category>> parentChildsMap = new HashMap<>();
        List<Category> rootNodes = new ArrayList<>();

        for (Category category : categories) {
            String parentId = category.getParentId();
            if (parentId != null) {
                if (parentChildsMap.containsKey(parentId)) {
                    parentChildsMap.get(parentId).add(category);
                } else {
                    List<Category> list = new ArrayList<>();
                    list.add(category);
                    parentChildsMap.put(parentId, list);
                }
            } else {
                rootNodes.add(category);
            }
        }

        // 构造树节点对象
        for (Category category : rootNodes) {
            result.add(createTreeNode(category, parentChildsMap));
        }
        return result;
    }

    private CategoryTreeNode createTreeNode(Category category,
        Map<String, List<Category>> parentChildsMap) {
        CategoryTreeNode node = new CategoryTreeNode();
        node.setData(category);
        node.setId(category.getCategoryId());
        node.setLabel(category.getCategoryName());
        if (parentChildsMap.containsKey(category.getCategoryId())) {
            node.setLeaf(false);
            for (Category childFormCategory : parentChildsMap.get(category.getCategoryId())) {
                node.addChild(createTreeNode(childFormCategory, parentChildsMap));
            }
        } else {
            // 虽然没有孩子节点，但是也没有父节点，说明是根节点
            if (category.getParentId() == null)
                node.setLeaf(false);
            // 有父节点但是没有孩子节点，即为叶子节点
            else
                node.setLeaf(true);
        }
        return node;
    }

    /**
     * 所有均为叶子节点
     * 
     * @param categories
     * @return
     */
    private List<CategoryTreeNode> createCategoryTreeAllLeaf(List<Category> categories) {
        List<CategoryTreeNode> result = new ArrayList<>();
        for (Category category : categories) {
            CategoryTreeNode node = new CategoryTreeNode();
            node.setData(category);
            node.setId(category.getCategoryId());
            node.setLabel(category.getCategoryName());
            node.setLeaf(true);
            result.add(node);
        }
        return result;
    }
    
    
    public abstract Category createCategory();
    /**
     * 创建分类归属的数据视图类
     * @return
     */
    public abstract DataView creatBelongingDataView();
}
