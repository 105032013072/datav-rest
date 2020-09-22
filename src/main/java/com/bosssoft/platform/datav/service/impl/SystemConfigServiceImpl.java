 package com.bosssoft.platform.datav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.domain.SystemConfig;
import com.bosssoft.platform.datav.mapper.infra.SystemConfigMapper;
import com.bosssoft.platform.datav.service.SystemConfigService;

@Service
public class SystemConfigServiceImpl implements SystemConfigService{

    @Autowired
    private SystemConfigMapper systemConfigMapper;
    
    @Override
    public SystemConfig getSystemConfigByKey(String configKey) {
       
         return systemConfigMapper.selectByPrimaryKey(configKey);
    }

}
