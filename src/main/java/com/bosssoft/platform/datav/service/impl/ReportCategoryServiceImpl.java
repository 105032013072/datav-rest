 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.domain.Report;
import com.bosssoft.platform.datav.domain.ReportCategory;
import com.bosssoft.platform.datav.mapper.CategoryMapper;
import com.bosssoft.platform.datav.mapper.DataViewMapper;
import com.bosssoft.platform.datav.mapper.infra.ReportCategoryMapper;
import com.bosssoft.platform.datav.mapper.infra.ReportMapper;

@Service("reportCategoryService")
public class ReportCategoryServiceImpl extends CategoryServiceImpl{

    @Autowired
    private ReportCategoryMapper reportCategoryMapper;
    
    @Autowired
    private ReportMapper reportMapper;
    
    @Override
    public CategoryMapper getCategoryMapper() {
         return reportCategoryMapper;
    }

    @Override
    public DataViewMapper getBelongingDataViewMapper() {
        
         return reportMapper;
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
