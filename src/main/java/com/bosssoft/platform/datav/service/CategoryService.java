package com.bosssoft.platform.datav.service;

import java.util.List;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.vo.CategoryTreeNode;


public interface CategoryService {

    /**
     * 根据Id获取分类
     * 
     * @param CategoryId
     * @return
     */
    public Category getCategoryById(String categoryId);

    /**
     * 新增分类
     * 
     * @param Category
     * @return
     */
    public Category saveCategory(Category category);


    /**
     * 删除分类
     * 
     * @param CategoryId
     */
    public void deleteCategory(String categoryId);

    /**
     * 修改分类
     * 
     * @param Category
     */
    public Category modifyCategory(Category category);

    /**
     * 获取分类树
     * 
     * @param categoryNameLike
     * @return
     */
    public List<CategoryTreeNode> getCategoryTree(String categoryNameLike);
}
