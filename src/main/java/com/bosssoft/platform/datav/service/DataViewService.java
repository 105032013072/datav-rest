 package com.bosssoft.platform.datav.service;

import com.bosssoft.platform.datav.domain.DataView;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.datav.dto.ShareProperties;
import com.bosssoft.platform.datav.exception.DatavException;
import com.bosssoft.platform.datav.vo.ResultPageData;

public interface DataViewService {

    /**
     * 创建数据视图
     * @param dataView
     * @return
     */
      public DataView  createDataView(DataView dataView);
      
      /**
       * 根据Id获取数据视图
       * @param Id
       * @return
       */
      public DataView  getDataViewById(String Id);
      
      /**
       * 根据Id删除数据视图
       * @param Id
       */
      public void deleteDataViewById(String Id);
      
      /**
       * 编辑数据视图
       * @param Id
       * @param dataView
       * @return
       */
      public DataView editedDataView(String Id,DataView dataView);
      
      /**
       * 分页查询数据视图
       * @param dataViewSearch
       * @param pageNum
       * @param pageSize
       * @return
       */
      public ResultPageData<DataView> pageDataView(DataViewSearchDTO dataViewSearch,Integer pageNum, Integer pageSize);
      
      /**
       * 设置分享状态
       * @param shareProperties
       * @return
       */
      public DataView setupShareState(ShareProperties shareProperties)throws DatavException;
}
