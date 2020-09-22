package com.bosssoft.platform.datav.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosssoft.platform.datav.domain.DataSourceInfo;
import com.bosssoft.platform.datav.model.DataSourceElement;
import com.bosssoft.platform.datav.service.DataSourceService;
import com.bosssoft.platform.datav.vo.BatchDeleteVerifResult;
import com.bosssoft.platform.datav.vo.DBConnectionTestResult;
import com.bosssoft.platform.datav.vo.ResultPageData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 数据源管理器
 * 
 * @author huangxw
 */
@RestController
@RequestMapping("/v1/data-source")
@Api(tags = "数据源管理")
public class DataSourceController {

    private static Logger log = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping(value = "/{dataSourceInfoId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据数据源ID查询数据源对象")
    public DataSourceInfo getDataSourceInfoById(@PathVariable(name = "dataSourceInfoId") String dataSourceInfoId) {
        return dataSourceService.getDataSourceInfoById(dataSourceInfoId);
    }

    /**
     * 分页查询数据源信息
     * 
     * @param dataSourcePageDTO
     * @return
     * @throws DynamicFormException
     */
    @PostMapping(value = "/page-query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询数据源信息")
    public ResultPageData<DataSourceInfo> pageDataSource(
        @ApiParam("数据源实体类") @RequestBody(required = false) DataSourceInfo dataSourceInfo,
        @ApiParam("当前页") @RequestParam(required = false) Integer pageNum,
        @ApiParam("每页记录数") @RequestParam(required = false) Integer pageSize) {
        return dataSourceService.pageDataSourceInfo(dataSourceInfo, pageNum, pageSize);
    }

    @PostMapping(value = "/dataSourceInfos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询数据源列表")
    public List<DataSourceInfo>
        getDataSourceList(@ApiParam("数据源实体类") @RequestBody(required = false) DataSourceInfo dataSourceInfo) {
        return dataSourceService.getDataSourceList(dataSourceInfo);
    }

    /**
     * 新增数据源信息
     * 
     * @param dataSourceInfo
     * @return
     */
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增数据源信息")
    public DataSourceInfo saveDataSourceInfo(@ApiParam("数据源实体类") @RequestBody DataSourceInfo dataSourceInfo) {
        return dataSourceService.saveDataSourceInfo(dataSourceInfo);

    }

    @GetMapping(value = "/delete-verification/{dataSourceInfoId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "数据源删除前校验", notes = "删除数据源之前校验是否有关于数据源的引用")
    public boolean deleteVerif(@PathVariable(name = "dataSourceInfoId") String dataSourceInfoId) {
        return !dataSourceService.existReferenceAboutDataSource(dataSourceInfoId);
    }

    @PostMapping(value = "/batch-verification", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量验证数据源")
    public BatchDeleteVerifResult<DataSourceInfo> batchDeleteVerif(@RequestBody List<String> dataSourceInfoIds) {
        List<DataSourceInfo> illegalObjects = new ArrayList<DataSourceInfo>();
        for (String dataSourceInfoId : dataSourceInfoIds) {
            if (dataSourceService.existReferenceAboutDataSource(dataSourceInfoId)) {
                DataSourceInfo obj = dataSourceService.getDataSourceInfoById(dataSourceInfoId);
                illegalObjects.add(obj);
            }
        }

        if (illegalObjects.isEmpty()) {
            return new BatchDeleteVerifResult<DataSourceInfo>(true);
        } else {
            BatchDeleteVerifResult<DataSourceInfo> result = new BatchDeleteVerifResult<DataSourceInfo>(false);
            result.setIllegalObjects(illegalObjects);
            return result;
        }

    }

    /**
     * 删除单个数据源信息
     */
    @DeleteMapping(value = "/{dataSourceInfoId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除单个数据源信息")
    public String deleteDataSourceInfo(@PathVariable(name = "dataSourceInfoId") String dataSourceInfoId) {
        dataSourceService.deleteDataSourceInfoById(dataSourceInfoId);
        return dataSourceInfoId;
    }

    /**
     * 批量删除数据源信息
     * 
     * @return
     */
    @PostMapping(value = "/batch-delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除数据源信息")
    public List<String> batchDeleteDataSourceInfo(@RequestBody List<String> dataSourceInfoIds) {
        for (String id : dataSourceInfoIds) {
            dataSourceService.deleteDataSourceInfoById(id);
        }
        return dataSourceInfoIds;
    }

    /**
     * 修改数据源信息
     * 
     * @param dataSourceInfo
     * @return
     */
    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "编辑数据源信息")
    public DataSourceInfo modifyDataSourceInfo(@RequestBody DataSourceInfo dataSourceInfo) {
        return dataSourceService.modifyDataSourceInfo(dataSourceInfo);

    }

    /**
     * 获取支持的数据源类型信息
     * 
     * @return
     */
    @GetMapping(value = "/supported", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取支持的数据源类型信息", notes = "在新增数据源选择数据源类型时获取所有可选择的数据库类型")
    public List<DataSourceElement> getSupportDataSources() {
        return dataSourceService.getSupportDataSources();
    }

    /**
     * 数据源连接测试
     * 
     * @return
     */
    @PostMapping(value = "/connection-test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "数据源连接测试")
    public DBConnectionTestResult
        dataSourceConnectionTest(@ApiParam("数据源实体类") @RequestBody DataSourceInfo dataSourceInfo) {
        return dataSourceService.dataSourceConnectionTest(dataSourceInfo);
    }
}