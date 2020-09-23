 package com.bosssoft.platform.datav.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.microservice.framework.dal.common.Mapper;

public interface DataViewMapper<T> extends Mapper<T>{

    List<DataViewMapper> selectDataViewByCondition(@Param("search") DataViewSearchDTO dataViewSearch);
    
}
