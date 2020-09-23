 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.mapper.infra.ReportMapper;
import com.bosssoft.platform.datav.service.SystemConfigService;

@Service("reportService")
 public class ReportServiceImpl extends DataViewServiceImpl {

     @Autowired
     public ReportServiceImpl(ReportMapper reportMapper) {
         super.dataViewMapper = reportMapper;
     }

     @Override
     public String getDefaultConfigKey() {

         return SystemConfigService.REPORT_DEFAULT_CFG_KEY;
     }
}
