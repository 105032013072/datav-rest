 package com.bosssoft.platform.datav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.domain.DashboardCategory;
import com.bosssoft.platform.datav.service.CategoryService;

import io.swagger.annotations.Api;


 @RestController
 @RequestMapping(value="/v1/dashboard-category",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 @Api(tags = "大屏分类管理")
 public class DashboardCategoryController extends CategoryController<DashboardCategory>{

     @Autowired     
     public DashboardCategoryController(CategoryService dashboardCategoryService){
         super.categoryService=dashboardCategoryService;
     }


}
