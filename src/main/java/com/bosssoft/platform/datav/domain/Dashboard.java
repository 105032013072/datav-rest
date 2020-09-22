package com.bosssoft.platform.datav.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dv_dashboard")
public class Dashboard extends DataView{
    @Id
    private String dashboardId;

    private String dashboardName;

    /**
     * @return DASHBOARD_ID
     */
    public String getDashboardId() {
        return dashboardId;
    }

    /**
     * @param dashboardId
     */
    public void setDashboardId(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    /**
     * @return DASHBOARD_NAME
     */
    public String getDashboardName() {
        return dashboardName;
    }

    /**
     * @param dashboardName
     */
    public void setDashboardName(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    @Override
    public String getDataViewId() {
        
         return getDashboardId();
    }

    @Override
    public void setDataViewId(String dataViewId) {
        setDashboardId(dataViewId);
    }

    @Override
    public String getDataViewName() {
         return getDashboardName();
    }

    @Override
    public void setDataViewName(String dataViewName) {
        setDashboardName(dataViewName);
    }
}