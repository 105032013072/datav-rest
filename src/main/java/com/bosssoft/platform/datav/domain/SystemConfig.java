package com.bosssoft.platform.datav.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dv_system_config")
public class SystemConfig {
    @Id
    private String configKey;

    private String configName;

    private String configValue;

    /**
     * @return CONFIG_KEY
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * @param configKey
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * @return CONFIG_NAME
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * @param configName
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * @return CONFIG_VALUE
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * @param configValue
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}