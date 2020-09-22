package com.bosssoft.platform.datav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.OK, reason = "No such Order")
public class DatavException extends Exception {
    
    private static final long serialVersionUID = -7640793404157007568L;
    
    /**
     * 错误码
     */
    private Error error;
    
    private Throwable throwable;

    public DatavException(String errMsg) {
        // 不生成堆栈跟踪信息
        super(errMsg, null, false, false);

    }

    public DatavException(String errMsg, Throwable throwable) {
        super(errMsg, throwable);
 
        this.throwable = throwable;
    }
    
    public DatavException(Error error, Throwable throwable) {
        super(error.getErrMsg(), throwable);
        this.error = error;
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {

        return this;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
    
    

}
