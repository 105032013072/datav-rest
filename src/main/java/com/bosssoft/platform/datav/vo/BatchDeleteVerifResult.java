 package com.bosssoft.platform.datav.vo;

import java.util.ArrayList;
import java.util.List;

public class BatchDeleteVerifResult<T> {

     /**
      * 验证结果：true：所有记录都通过验证   false：存在某条非法记录
      */
     private boolean result;
     
     /**
      * 非法记录对应的的对象信息
      */
     private List<T> illegalObjects=new ArrayList<>();
     
     public BatchDeleteVerifResult(){
         
     }
     
     public BatchDeleteVerifResult(boolean result){
         this.result=result;
     }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<T> getIllegalObjects() {
        return illegalObjects;
    }

    public void setIllegalObjects(List<T> illegalObjects) {
        this.illegalObjects = illegalObjects;
    }
    
     
     
     
}
