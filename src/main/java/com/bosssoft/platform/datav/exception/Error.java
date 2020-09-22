package com.bosssoft.platform.datav.exception;

public class Error {

    /**
     * 错误码
     */
    private String code="dv_01";
    /**
     * 错误的概要描述
     */
    private String errMsg;

    public Error() {}
    
    public Error(String errMsg){
        this.errMsg = errMsg;
    }

    public Error(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
