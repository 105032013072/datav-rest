 package com.bosssoft.platform.datav.dto;

import com.bosssoft.platform.datav.constant.ShareState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 分享属性
  * @author huangxw
  * @date 2020/09/22
  */
@ApiModel("分享属性")
 public class ShareProperties {
     
     public String dataViewId;

     @ApiModelProperty(value="分享类型",allowableValues="PROHIBIT,PUBLIC,SECRET")
     public ShareState shareState;
     
     @ApiModelProperty("秘密分享的密码")
     public String sharePassword;
     
     public String token;

    public ShareState getShareState() {
        return shareState;
    }

    public void setShareState(ShareState shareState) {
        this.shareState = shareState;
    }

    public String getSharePassword() {
        return sharePassword;
    }

    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword;
    }

    public String getDataViewId() {
        return dataViewId;
    }

    public void setDataViewId(String dataViewId) {
        this.dataViewId = dataViewId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
     
    
     
}
