package com.bosssoft.platform.datav.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dv_report_chart")
public class ReportChart {
    @Id
    private String chartId;

    private String reportId;

    private String location;

    private String configuration;

    private String dataBindingType;

    private Date createTime;

    private String createUser;

    private Date modifyTime;

    private String modifyUser;

    /**
     * @return CHART_ID
     */
    public String getChartId() {
        return chartId;
    }

    /**
     * @param chartId
     */
    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    /**
     * @return REPORT_ID
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     */
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    /**
     * @return LOCATION
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return CONFIGURATION
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration
     */
    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    /**
     * @return DATA_BINDING_TYPE
     */
    public String getDataBindingType() {
        return dataBindingType;
    }

    /**
     * @param dataBindingType
     */
    public void setDataBindingType(String dataBindingType) {
        this.dataBindingType = dataBindingType;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return CREATE_USER
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return MODIFY_TIME
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return MODIFY_USER
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * @param modifyUser
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
}