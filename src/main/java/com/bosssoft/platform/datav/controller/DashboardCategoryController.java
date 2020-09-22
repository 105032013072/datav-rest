 package com.bosssoft.platform.datav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.domain.DashboardCategory;
import com.bosssoft.platform.datav.service.CategoryService;

import io.swagger.annotations.Api;


 @RestController
 @RequestMapping("/v1/dashboard-category")
 @Api(tags = "大屏分类管理")
 public class DashboardCategoryController extends CategoryController<DashboardCategory>{

     @Autowired
     private CategoryService dashboardCategoryService;
     
    @Override
    public CategoryService getCategoryService() {
         return dashboardCategoryService;
    }

}
