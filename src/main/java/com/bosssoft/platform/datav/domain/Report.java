package com.bosssoft.platform.datav.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dv_report")
public class Report extends DataView{
    @Id
    private String reportId;

    private String reportName;


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
     * @return REPORT_NAME
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * @param reportName
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String getDataViewId() {
        
         return getReportId();
    }

    @Override
    public void setDataViewId(String dataViewId) {
        setReportId(dataViewId);
         
    }

    @Override
    public String getDataViewName() {
       
         return getReportName();
    }

    @Override
    public void setDataViewName(String dataViewName) {
        setReportName(dataViewName);
         
    }

}