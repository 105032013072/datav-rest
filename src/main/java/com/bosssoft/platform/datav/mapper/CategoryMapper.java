 package com.bosssoft.platform.datav.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bosssoft.platform.datav.domain.Category;
import com.bosssoft.platform.microservice.framework.dal.common.Mapper;

public interface CategoryMapper<T> extends Mapper<T>{
    List<Category> selectCategoryByNameLike(@Param("nameLike") String nameLike);
}
