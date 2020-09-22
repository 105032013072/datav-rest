 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.domain.Dashboard;
import com.bosssoft.platform.datav.domain.DashboardCategory;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.mapper.CategoryMapper;
import com.bosssoft.platform.datav.mapper.DataViewMapper;
import com.bosssoft.platform.datav.mapper.infra.DashboardCategoryMapper;
import com.bosssoft.platform.datav.mapper.infra.DashboardMapper;

@Service("dashboardCategoryService")
public class DashboardCategoryServiceImpl extends CategoryServiceImpl{

    @Autowired
    private DashboardCategoryMapper dashboardCategoryMapper;
    
    @Autowired
    private DashboardMapper dashboardMapper;
    
    @Override
    public CategoryMapper getCategoryMapper() {
         return dashboardCategoryMapper;
    }

    @Override
    public DataViewMapper getBelongingDataViewMapper() {
         return dashboardMapper;
    }

    @Override
    public Category createCategory() {
       
         return new DashboardCategory();
    }

    @Override
    public DataView creatBelongingDataView() {
       
         return new Dashboard();
    }

}
