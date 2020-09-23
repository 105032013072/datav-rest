 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.domain.Report;
import com.bosssoft.platform.datav.domain.ReportCategory;
import com.bosssoft.platform.datav.mapper.infra.ReportCategoryMapper;
import com.bosssoft.platform.datav.mapper.infra.ReportMapper;

@Service("reportCategoryService")
public class ReportCategoryServiceImpl extends CategoryServiceImpl{

    @Autowired   
    public ReportCategoryServiceImpl(ReportCategoryMapper reportCategoryMapper,ReportMapper reportMapper){
        super.categoryMapper=reportCategoryMapper;
        super.dataViewMapper=reportMapper;
    }
   
    @Override
    public Category createCategory() {
        
         return  new ReportCategory();
    }

    @Override
    public DataView creatBelongingDataView() {

         return new Report();
    }

}
