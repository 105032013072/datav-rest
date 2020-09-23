 package com.bosssoft.platform.datav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.service.DataViewService;

import io.swagger.annotations.Api;

@RestController
 @RequestMapping(value="/v1/dashboard",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 @Api(tags = "大屏管理")
 public class DashboardController extends DataViewController{

    @Autowired
    public DashboardController(DataViewService dashboardService){
        super.dataViewService=dashboardService;
    }
}
