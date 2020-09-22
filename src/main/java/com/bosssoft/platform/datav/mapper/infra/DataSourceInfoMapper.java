package com.bosssoft.platform.datav.mapper.infra;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bosssoft.platform.datav.domain.DataSourceInfo;
import com.bosssoft.platform.microservice.framework.dal.common.Mapper;

public interface DataSourceInfoMapper extends Mapper<DataSourceInfo> {
    List<DataSourceInfo> selectDataSourceByCondition(@Param("search") DataSourceInfo search);
}