 package com.bosssoft.platform.datav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.domain.ReportCategory;
import com.bosssoft.platform.datav.service.CategoryService;

import io.swagger.annotations.Api;

@RestController
 @RequestMapping("/v1/report-category")
 @Api(tags = "报表分类管理")
 public class ReportCategoryController extends CategoryController<ReportCategory>{

    @Autowired
    private CategoryService reportCategoryService;
    
    @Override
    public CategoryService getCategoryService() {
        
         return reportCategoryService;
    }

}
