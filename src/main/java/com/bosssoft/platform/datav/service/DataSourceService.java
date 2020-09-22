package com.bosssoft.platform.datav.service;

import java.util.List;

import com.bosssoft.platform.datav.domain.DataSourceInfo;
import com.bosssoft.platform.datav.model.DataSourceElement;
import com.bosssoft.platform.datav.vo.DBConnectionTestResult;
import com.bosssoft.platform.datav.vo.ResultPageData;


public interface DataSourceService {

    /**
     * 根据数据源ID查询
     * 
     * @param dataSourceInfoById
     * @return
     */
    public DataSourceInfo getDataSourceInfoById(String dataSourceInfoId);

    /**
     * 分页查询数据源
     * 
     * @param search
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ResultPageData<DataSourceInfo> pageDataSourceInfo(DataSourceInfo search, Integer pageNum, Integer pageSize);

    /**
     * 获取数据源列表
     * @return 查询条件
     */
    public List<DataSourceInfo> getDataSourceList(DataSourceInfo search);
    

    /**
     * 根据Id 删除数据源
     * 
     * @param dataSourceId
     */
    public void deleteDataSourceInfoById(String dataSourceId);

    /**
     * 修改数据源配置信息
     * 
     * @param dataSource
     * @return 修改后的对象
     */
    public DataSourceInfo modifyDataSourceInfo(DataSourceInfo dataSource);

    /**
     * 新增数据源信息
     * 
     * @param dataSource
     * @return 新增的对象
     */
    public DataSourceInfo saveDataSourceInfo(DataSourceInfo dataSource);

    /**
     * 获取支持的数据源类型信息
     * 
     * @return
     */
    public List<DataSourceElement> getSupportDataSources();

    /**
     * 数据源连接测试
     * 
     * @param dataSource
     * @return
     */
    public DBConnectionTestResult dataSourceConnectionTest(DataSourceInfo dataSource);

    /**
     * 判断对应的数据源是否存在引用
     * @param dataSourceId
     * @return
     */
    public boolean existReferenceAboutDataSource(String dataSourceId);
}
