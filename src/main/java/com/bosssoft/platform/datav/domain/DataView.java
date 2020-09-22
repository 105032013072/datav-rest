 package com.bosssoft.platform.datav.domain;

import java.util.Date;

import javax.persistence.Transient;

public abstract class DataView {
    
     private String remark;

     private String categoryId;
     
     @Transient
     private String categoryName;

     private String shareState;

     private String shareToken;

     private String sharePassword;

     private String configuration;

     private Date createTime;

     private String createUser;

     private Date modifyTime;

     private String modifyUser;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getShareState() {
        return shareState;
    }

    public void setShareState(String shareState) {
        this.shareState = shareState;
    }

    public String getShareToken() {
        return shareToken;
    }

    public void setShareToken(String shareToken) {
        this.shareToken = shareToken;
    }

    public String getSharePassword() {
        return sharePassword;
    }

    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public abstract String getDataViewId() ;

    public abstract void setDataViewId(String dataViewId) ;

    public abstract String getDataViewName() ;

    public abstract void setDataViewName(String dataViewName) ;
     
    
}
