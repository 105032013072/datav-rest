 package com.bosssoft.platform.datav.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.constant.BasicConstant;
import com.bosssoft.platform.datav.domain.DataSourceInfo;
import com.bosssoft.platform.datav.handler.SupportDataSourceHandler;
import com.bosssoft.platform.datav.mapper.infra.DataSourceInfoMapper;
import com.bosssoft.platform.datav.model.DataSourceElement;
import com.bosssoft.platform.datav.service.DataSourceService;
import com.bosssoft.platform.datav.util.DatavUtil;
import com.bosssoft.platform.datav.util.SecurityUtils;
import com.bosssoft.platform.datav.vo.BasicPageInfo;
import com.bosssoft.platform.datav.vo.DBConnectionTestResult;
import com.bosssoft.platform.datav.vo.ResultPageData;
import com.bosssoft.platform.microservice.framework.common.data.Page;
import com.bosssoft.platform.microservice.framework.dal.pagination.PageHelper;


@Service
public class DataSourceServiceImpl implements DataSourceService{

    private static Logger log = LoggerFactory.getLogger(DataSourceServiceImpl.class);

    
    @Autowired
    private DataSourceInfoMapper dataSourceMapper;
    
    @Override
    public DataSourceInfo getDataSourceInfoById(String dataSourceInfoId) {
        
         return dataSourceMapper.selectByPrimaryKey(dataSourceInfoId);
    }

    @Override
    public ResultPageData<DataSourceInfo> pageDataSourceInfo(DataSourceInfo search, Integer pageNum, Integer pageSize) {
      
        if (pageNum == null)
            pageNum = BasicPageInfo.DEFAULE_CURRENTPAGE;
        if (pageSize == null)
            pageSize = BasicPageInfo.DEFAULE_PAGESIZE;
        if (search == null)
            search = new DataSourceInfo();

        Page<DataSourceInfo> page = PageHelper.startPage(pageNum, pageSize);
        dataSourceMapper.selectDataSourceByCondition(search);
        return new ResultPageData<>(page);
    }

    @Override
    public List<DataSourceInfo> getDataSourceList(DataSourceInfo search) {
        if (search == null) {
            search = new DataSourceInfo();
        }
        List<DataSourceInfo> result = dataSourceMapper.selectDataSourceByCondition(search);
        return result;
    }

    @Override
    public void deleteDataSourceInfoById(String dataSourceId) {
        dataSourceMapper.deleteByPrimaryKey(dataSourceId);
         
    }

    @Override
    public DataSourceInfo modifyDataSourceInfo(DataSourceInfo dataSource) {
        dataSource.setModifyTime(new Date());
        dataSource.setModifyUser(BasicConstant.DEFAULT_OPERATOR);
        dataSourceMapper.updateByPrimaryKeySelective(dataSource);
        return dataSource;
    }

    @Override
    public DataSourceInfo saveDataSourceInfo(DataSourceInfo dataSource) {
        dataSource.setId(DatavUtil.getUUID32());
        dataSource.setCreateTime(new Date());
        dataSource.setCreateUser(BasicConstant.DEFAULT_OPERATOR);

        dataSourceMapper.insertSelective(dataSource);

        return dataSource;
    }

    @Override
    public List<DataSourceElement> getSupportDataSources() {
        List<DataSourceElement> result = new ArrayList<>();
        result.addAll(SupportDataSourceHandler.getSupportDataSources().values());

        return result;
    }

    @Override
    public DBConnectionTestResult dataSourceConnectionTest(DataSourceInfo dataSourceInfo) {
     // 连接测试
        DBConnectionTestResult connectionTestResult = new DBConnectionTestResult();
        Connection connection = null;
        try {
            Class.forName(dataSourceInfo.getDbDriver());
            String jdbcUrl =getJDBCUrl(dataSourceInfo.getDbType(),
                dataSourceInfo.getHostIp(), dataSourceInfo.getDbPort(), dataSourceInfo.getDbInstance());

            Connection conn = DriverManager.getConnection(jdbcUrl, dataSourceInfo.getDbUsername(),
                SecurityUtils.desEncrypt(dataSourceInfo.getDbPassword()));

            connectionTestResult.setSuccess(true);
        } catch (Exception e) {
            connectionTestResult.setSuccess(false);
            connectionTestResult.setErrorMessage(e.toString());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.error("Exception while closing the Database connection", e);
            }
        }
        return connectionTestResult;
    }
    
    public  String getJDBCUrl(String dataSourceMateKey, String ip, String port, String instanceName) {
        DataSourceElement dataSourceElement = SupportDataSourceHandler.getSupportDataSourceByMateKey(dataSourceMateKey);
        String jdbcUrl = MessageFormat.format(dataSourceElement.getUrlTemplate(), ip, port, instanceName);
        return jdbcUrl;
    }

    @Override
    public boolean existReferenceAboutDataSource(String dataSourceId) {
        // TODO 数据源引用校验 
         return false;
    }
}
