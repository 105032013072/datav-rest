package com.bosssoft.platform.datav.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "dv_data_source")
public class DataSourceInfo {
    @Id
    private String id;

    private String dataSourceName;

    private String hostIp;

    private String dbPort;


    private String dbType;


    private String dbDriver;


    private String dbInstance;


    private String dbUsername;


    private String dbPassword;


    private Date createTime;

    private Date modifyTime;

    private String createUser;

    private String modifyUser;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return DATA_SOURCE_NAME
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * @param dataSourceName
     */
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    /**
     * @return HOST_IP
     */
    public String getHostIp() {
        return hostIp;
    }

    /**
     * @param hostIp
     */
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    /**
     * @return DB_PORT
     */
    public String getDbPort() {
        return dbPort;
    }

    /**
     * @param dbPort
     */
    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    /**
     * @return DB_TYPE
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * @param dbType
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * @return DB_DRIVER
     */
    public String getDbDriver() {
        return dbDriver;
    }

    /**
     * @param dbDriver
     */
    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    /**
     * @return DB_INSTANCE
     */
    public String getDbInstance() {
        return dbInstance;
    }

    /**
     * @param dbInstance
     */
    public void setDbInstance(String dbInstance) {
        this.dbInstance = dbInstance;
    }

    /**
     * @return DB_USERNAME
     */
    public String getDbUsername() {
        return dbUsername;
    }

    /**
     * @param dbUsername
     */
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    /**
     * @return DB_PASSWORD
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * @param dbPassword
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
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