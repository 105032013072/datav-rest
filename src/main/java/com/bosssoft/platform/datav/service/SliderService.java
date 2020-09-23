 package com.bosssoft.platform.datav.service;

import com.bosssoft.platform.datav.domain.Slider;
import com.bosssoft.platform.datav.dto.DataViewSearchDTO;
import com.bosssoft.platform.datav.dto.ShareProperties;
import com.bosssoft.platform.datav.exception.DatavException;
import com.bosssoft.platform.datav.vo.ResultPageData;

public interface SliderService {
    
    //TODO 获取处于分享状态的大屏和报表

     /**
      * 创建轮播
      * @param Slider
      * @return
      */
       public Slider  createSlider(Slider slider);
       
       /**
        * 根据Id获取轮播
        * @param Id
        * @return
        */
       public Slider  getSliderById(String Id);
       
       /**
        * 根据Id删除轮播
        * @param Id
        */
       public void deleteSliderById(String Id);
       
       /**
        * 编辑轮播
        * @param Id
        * @param Slider
        * @return
        */
       public Slider editedSlider(String Id,Slider slider);
       
       /**
        * 分页查询轮播
        * @param SliderSearch
        * @param pageNum
        * @param pageSize
        * @return
        */
       public ResultPageData<Slider> pageSlider(DataViewSearchDTO sliderSearch,Integer pageNum, Integer pageSize);
       
       /**
        * 设置分享状态
        * @param shareProperties
        * @return
        */
       public Slider setupShareState(ShareProperties shareProperties)throws DatavException;
}
