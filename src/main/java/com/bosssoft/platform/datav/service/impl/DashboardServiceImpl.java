package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.mapper.infra.DashboardMapper;
import com.bosssoft.platform.datav.service.SystemConfigService;

@Service("dashboardService")
public class DashboardServiceImpl extends DataViewServiceImpl {

    @Autowired
    public DashboardServiceImpl(DashboardMapper dashboardMapper) {
        super.dataViewMapper = dashboardMapper;
    }

    @Override
    public String getDefaultConfigKey() {

        return SystemConfigService.DASHBOARD_DEFAULT_CFG_KEY;
    }

}
