 package com.bosssoft.platform.datav.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.platform.datav.constant.BasicConstant;
import com.bosssoft.platform.datav.constant.ShareState;
import com.bosssoft.platform.datav.domain.Slider;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.datav.dto.ShareProperties;
import com.bosssoft.platform.datav.exception.DatavException;
import com.bosssoft.platform.datav.mapper.infra.SliderMapper;
import com.bosssoft.platform.datav.service.SliderService;
import com.bosssoft.platform.datav.util.DatavUtil;
import com.bosssoft.platform.datav.vo.BasicPageInfo;
import com.bosssoft.platform.datav.vo.ResultPageData;
import com.bosssoft.platform.microservice.framework.common.data.Page;
import com.bosssoft.platform.microservice.framework.dal.pagination.PageHelper;

@Service
public class SliderServiceImpl implements SliderService{

    @Autowired
    private SliderMapper sliderMapper;
    
    private static Logger log = LoggerFactory.getLogger(SliderServiceImpl.class);
    
    @Override
    public Slider createSlider(Slider slider) {
        slider.setShareState(ShareState.PROHIBIT.toString());
        
        slider.setSliderId(DatavUtil.getUUID32());
        slider.setCreateTime(new Date());
        slider.setCreateUser(BasicConstant.DEFAULT_OPERATOR);
        sliderMapper.insertSelective(slider);
        return slider;
    }

    @Override
    public Slider getSliderById(String Id) {
       
         return sliderMapper.selectByPrimaryKey(Id);
    }

    @Override
    public void deleteSliderById(String Id) {
        sliderMapper.deleteByPrimaryKey(Id);
         
    }

    @Override
    public Slider editedSlider(String Id, Slider slider) {
        slider.setSliderId(Id);
        
        slider.setModifyTime(new Date());
        slider.setModifyUser(BasicConstant.DEFAULT_OPERATOR);
        sliderMapper.updateByPrimaryKeySelective(slider);
        
        return slider;
    }

    @Override
    public ResultPageData<Slider> pageSlider(DataViewSearchDTO sliderSearch, Integer pageNum, Integer pageSize) {
        if (pageNum == null)
            pageNum = BasicPageInfo.DEFAULE_CURRENTPAGE;
        if (pageSize == null)
            pageSize = BasicPageInfo.DEFAULE_PAGESIZE;
        if (sliderSearch == null)
            sliderSearch = new DataViewSearchDTO();

        Page<Slider> page = PageHelper.startPage(pageNum, pageSize);
        sliderMapper.selectSliderByCondition(sliderSearch);
        return new ResultPageData<>(page);

    }

    @Override
    public Slider setupShareState(ShareProperties shareProperties) throws DatavException {
        Slider slider=getSliderById(shareProperties.getDataViewId());
        if(slider==null){
            String errorMsg=String.format("can't find slider object by id=%s", shareProperties.getDataViewId());
            log.error(errorMsg);
            throw new DatavException(errorMsg);
        }
        
        switch (shareProperties.getShareState()) {
            case PROHIBIT:
                slider.setSharePassword(null);
                slider.setShareToken(null);
                slider.setShareState(ShareState.PROHIBIT.toString());
                break;
            case PUBLIC:
                slider.setSharePassword(null);
                slider.setShareToken(DatavUtil.createShareToken(shareProperties.getDataViewId()));
                slider.setShareState(ShareState.PUBLIC.toString());
                break;
            case SECRET:
                slider.setSharePassword(shareProperties.getSharePassword());
                slider.setShareToken(DatavUtil.createShareToken(shareProperties.getDataViewId()));
                slider.setShareState(ShareState.SECRET.toString());
                break;
            default:
                log.error("分享状态不合法");
                throw new DatavException("分享状态不合法");
        }
        
        slider.setModifyTime(new Date());
        slider.setModifyUser(BasicConstant.DEFAULT_OPERATOR);
        sliderMapper.updateByPrimaryKey(slider);
         
         return slider;
    }
    
    

}
