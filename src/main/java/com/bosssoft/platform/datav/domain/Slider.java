package com.bosssoft.platform.datav.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dv_slider")
public class Slider {
    @Id
    private String sliderId;

    private String sliderName;

    private String remark;

    private String shareState;

    private String shareToken;

    private String sharePassword;

    private String configuration;

    private Date createTime;

    private String createUser;

    private Date modifyTime;

    private String modifyUser;

    /**
     * @return SLIDER_ID
     */
    public String getSliderId() {
        return sliderId;
    }

    /**
     * @param sliderId
     */
    public void setSliderId(String sliderId) {
        this.sliderId = sliderId;
    }

    /**
     * @return SLIDER_NAME
     */
    public String getSliderName() {
        return sliderName;
    }

    /**
     * @param sliderName
     */
    public void setSliderName(String sliderName) {
        this.sliderName = sliderName;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return SHARE_STATE
     */
    public String getShareState() {
        return shareState;
    }

    /**
     * @param shareState
     */
    public void setShareState(String shareState) {
        this.shareState = shareState;
    }

    /**
     * @return SHARE_TOKEN
     */
    public String getShareToken() {
        return shareToken;
    }

    /**
     * @param shareToken
     */
    public void setShareToken(String shareToken) {
        this.shareToken = shareToken;
    }

    /**
     * @return SHARE_PASSWORD
     */
    public String getSharePassword() {
        return sharePassword;
    }

    /**
     * @param sharePassword
     */
    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword;
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