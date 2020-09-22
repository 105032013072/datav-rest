 package com.bosssoft.platform.datav.domain;

import java.util.Date;

import javax.persistence.Id;

public abstract class Category {
     @Id
     private String categoryId;

     private String categoryName;

     private String parentId;

     private Date createTime;

     private String createUser;

     private Date modifyTime;

     private String modifyUser;
     
     

     /**
      * @return CATEGORY_ID
      */
     public String getCategoryId() {
         return categoryId;
     }

     /**
      * @param categoryId
      */
     public void setCategoryId(String categoryId) {
         this.categoryId = categoryId;
     }

     /**
      * @return CATEGORY_NAME
      */
     public String getCategoryName() {
         return categoryName;
     }

     /**
      * @param categoryName
      */
     public void setCategoryName(String categoryName) {
         this.categoryName = categoryName;
     }

     /**
      * @return PARENT_ID
      */
     public String getParentId() {
         return parentId;
     }

     /**
      * @param parentId
      */
     public void setParentId(String parentId) {
         this.parentId = parentId;
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
