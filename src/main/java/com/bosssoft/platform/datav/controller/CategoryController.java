 package com.bosssoft.platform.datav.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.service.CategoryService;
import com.bosssoft.platform.datav.vo.CategoryTreeNode;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public abstract class CategoryController<T extends Category> {

    protected CategoryService categoryService; 
    
     @GetMapping(value = "/{categoryId}")
     @ApiOperation(value = "根据Id获取分类")
     public Category getCategoryById(@PathVariable(name = "categoryId") String categoryId) {
         return categoryService.getCategoryById(categoryId);
     }

     @PostMapping(value = "")
     @ApiOperation(value = "保存分类")
     public Category saveCategory(@ApiParam("分类实体对象") @RequestBody T category) {
         return categoryService.saveCategory(category);
     }

     

     @DeleteMapping(value = "/{categoryId}")
     @ApiOperation(value = "根据ID删除分类")
     public void deleteCategory(@PathVariable(name = "categoryId") String categoryId) {
         categoryService.deleteCategory(categoryId);
     }

     @PutMapping(value = "")
     @ApiOperation(value = "修改分类")
     public Category modifyCategory(@ApiParam("分类实体对象") @RequestBody T category) {
         return categoryService.modifyCategory(category);
     }

     @GetMapping(value = "/tree")
     @ApiOperation(value = "获取分类树", notes = "获取完整的分类树或者根据条件搜索分类树")
     public List<CategoryTreeNode> getCategoryTree(@ApiParam("分类名称模糊查询的字符串") @RequestParam(required = false) String categoryNameLike) {
         return categoryService.getCategoryTree(categoryNameLike);
     }
     
}
