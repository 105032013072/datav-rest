package com.bosssoft.platform.datav.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.datav.dto.ShareProperties;
import com.bosssoft.platform.datav.exception.DatavException;
import com.bosssoft.platform.datav.service.DataViewService;
import com.bosssoft.platform.datav.vo.ResultPageData;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public abstract class DataViewController {

    protected DataViewService dataViewService;

    @PostMapping("")
    @ApiOperation(value = "新增数据视图")
    public DataView createDataView(@RequestBody DataView dataView) {
        return dataViewService.createDataView(dataView);
    }

    @GetMapping("/{Id}")
    @ApiOperation(value = "根据Id获取数据视图")
    public DataView getDataViewById(@PathVariable("Id") String Id) {
        return dataViewService.getDataViewById(Id);
    }

    @DeleteMapping("/{Id}")
    @ApiOperation(value = "根据Id删除数据视图")
    public void deleteDataViewById(@PathVariable("Id") String Id) {
        dataViewService.deleteDataViewById(Id);
    }

    @PostMapping("/batch-delete")
    @ApiOperation(value = "根据Id批量删除数据视图")
    public void batchDeleteDataViewById(@RequestBody List<String> dataViewIds) {
        for (String dataViewId : dataViewIds) {
            dataViewService.deleteDataViewById(dataViewId);
        }
    }

    @PutMapping("/{Id}")
    @ApiOperation(value = "编辑数据视图基本属性")
    public DataView editedDataView(@PathVariable("Id") String Id, @RequestBody DataView dataView) {
        return dataViewService.editedDataView(Id, dataView);
    }

    @PostMapping("/page")
    @ApiOperation(value = "分页查询")
    public ResultPageData<DataView> pageDataView(@RequestBody(required = false) DataViewSearchDTO dataViewSearch,
        @ApiParam("当前页") @RequestParam(required = false) Integer pageNum, 
        @ApiParam("每页记录数") @RequestParam(required = false) Integer pageSize) {
        return dataViewService.pageDataView(dataViewSearch, pageNum, pageSize);
    }

    @PostMapping("share-state")
    @ApiOperation(value = "设置分享状态")
    public DataView setupShareState(@RequestBody ShareProperties shareProperties) throws DatavException {
        return dataViewService.setupShareState(shareProperties);
    }
}
