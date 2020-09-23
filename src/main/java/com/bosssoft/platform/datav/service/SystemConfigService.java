 package com.bosssoft.platform.datav.service;

import com.bosssoft.platform.datav.domain.SystemConfig;

public interface SystemConfigService {
    
    public static final String DASHBOARD_DEFAULT_CFG_KEY="dashboard_default_cfg";
    
    public static final String REPORT_DEFAULT_CFG_KEY="report_default_cfg";

     public SystemConfig getSystemConfigByKey(String configKey);
}
