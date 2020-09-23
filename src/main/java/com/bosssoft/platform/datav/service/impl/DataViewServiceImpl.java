 package com.bosssoft.platform.datav.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import com.bosssoft.platform.datav.constant.BasicConstant;
import com.bosssoft.platform.datav.constant.ShareState;
import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.domain.SystemConfig;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.datav.dto.ShareProperties;
import com.bosssoft.platform.datav.exception.DatavException;
import com.bosssoft.platform.datav.mapper.DataViewMapper;
import com.bosssoft.platform.datav.service.DataViewService;
import com.bosssoft.platform.datav.service.SystemConfigService;
import com.bosssoft.platform.datav.util.DatavUtil;
import com.bosssoft.platform.datav.vo.BasicPageInfo;
import com.bosssoft.platform.datav.vo.ResultPageData;
import com.bosssoft.platform.microservice.framework.common.data.Page;
import com.bosssoft.platform.microservice.framework.dal.pagination.PageHelper;

public  abstract class DataViewServiceImpl implements DataViewService{

    @Autowired
    @Lazy
    protected SystemConfigService systemConfigService;
    
    protected DataViewMapper dataViewMapper;
    
    private static Logger log = LoggerFactory.getLogger(DataViewServiceImpl.class);
    
    @Override
    public DataView createDataView(DataView dataView) {
        //设置默认配置
        String defaultConfigKey=getDefaultConfigKey();
        if(StringUtils.isNotEmpty(defaultConfigKey)){
            SystemConfig  defaultConfig =systemConfigService.getSystemConfigByKey(defaultConfigKey);
            if(defaultConfig!=null){
                dataView.setConfiguration(defaultConfig.getConfigValue());
            }
        }
        
        dataView.setShareState(ShareState.PROHIBIT.toString());
        
        dataView.setDataViewId(DatavUtil.getUUID32());
        dataView.setCreateTime(new Date());
        dataView.setCreateUser(BasicConstant.DEFAULT_OPERATOR);
        
        dataViewMapper.insertSelective(dataView);
         return dataView;
    }

    @Override
    public DataView getDataViewById(String Id) {
       
         return (DataView)dataViewMapper.selectByPrimaryKey(Id);
    }

    @Override
    @Transactional
    public void deleteDataViewById(String Id) {
        //删除数据视图
        dataViewMapper.deleteByPrimaryKey(Id);
        
        //TODO 删除数据视图下的图表
         
    }

    @Override
    public DataView editedDataView(String Id, DataView dataView) {
        dataView.setDataViewId(Id);
        
        dataView.setModifyTime(new Date());
        dataView.setModifyUser(BasicConstant.DEFAULT_OPERATOR);
        dataViewMapper.updateByPrimaryKeySelective(dataView);
        
        return dataView;
    }

    @Override
    public ResultPageData<DataView> pageDataView(DataViewSearchDTO dataViewSearch, Integer pageNum, Integer pageSize) {
        if (pageNum == null)
            pageNum = BasicPageInfo.DEFAULE_CURRENTPAGE;
        if (pageSize == null)
            pageSize = BasicPageInfo.DEFAULE_PAGESIZE;
        if (dataViewSearch == null)
            dataViewSearch = new DataViewSearchDTO();

        Page<DataView> page = PageHelper.startPage(pageNum, pageSize);
        dataViewMapper.selectDataViewByCondition(dataViewSearch);
        return new ResultPageData<>(page);
    }

    @Override
    public DataView setupShareState(ShareProperties shareProperties) throws DatavException {
        DataView dataView=getDataViewById(shareProperties.getDataViewId());
        if(dataView==null){
            String errorMsg=String.format("can't find dataView object by id=%s", shareProperties.getDataViewId());
            log.error(errorMsg);
            throw new DatavException(errorMsg);
        }
        
        switch (shareProperties.getShareState()) {
            case PROHIBIT:
                dataView.setSharePassword(null);
                dataView.setShareToken(null);
                dataView.setShareState(ShareState.PROHIBIT.toString());
                break;
            case PUBLIC:
                dataView.setSharePassword(null);
                dataView.setShareToken(DatavUtil.createShareToken(shareProperties.getDataViewId()));
                dataView.setShareState(ShareState.PUBLIC.toString());
                break;
            case SECRET:
                dataView.setSharePassword(shareProperties.getSharePassword());
                dataView.setShareToken(DatavUtil.createShareToken(shareProperties.getDataViewId()));
                dataView.setShareState(ShareState.SECRET.toString());
                break;
            default:
                log.error("分享状态不合法");
                throw new DatavException("分享状态不合法");
        }
        
        dataView.setModifyTime(new Date());
        dataView.setModifyUser(BasicConstant.DEFAULT_OPERATOR);
        dataViewMapper.updateByPrimaryKey(dataView);
         
         return dataView;
    }
    
    
    /**
     * 获取默认配置的key
     * @return
     */
    public abstract String getDefaultConfigKey();

}
