package com.bosssoft.platform.datav.mapper.infra;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bosssoft.platform.datav.domain.Slider;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.microservice.framework.dal.common.Mapper;


public interface SliderMapper extends Mapper<Slider> {
    
    List<Slider> selectSliderByCondition(@Param("search") DataViewSearchDTO sliderSearch);
}