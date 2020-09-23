 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.datav.domain.Dashboard;
import com.bosssoft.platform.datav.domain.DashboardCategory;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.mapper.infra.DashboardCategoryMapper;
import com.bosssoft.platform.datav.mapper.infra.DashboardMapper;

@Service("dashboardCategoryService")
public class DashboardCategoryServiceImpl extends CategoryServiceImpl{
    
    @Autowired
    public DashboardCategoryServiceImpl(DashboardCategoryMapper dashboardCategoryMapper,DashboardMapper dashboardMapper){
        super.categoryMapper=dashboardCategoryMapper;
        super.dataViewMapper=dashboardMapper;
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
