 package com.bosssoft.platform.datav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.service.DataViewService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/v1/report",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "报表管理")
public class ReportController extends DataViewController{

     @Autowired
     public ReportController(DataViewService reportService){
         super.dataViewService=reportService;
     }
}
