package com.fore.district.service;

import com.github.pagehelper.PageInfo;
import com.pojo.District;
import com.utils.PageUtils;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:25:47
 */
public interface ForeDistrictService {

      /**
       *
       *
       * @description:
       * @param null
       * @return: 查询所有的区域用于发布
       * @author: Aiden
       * @time: 2019-12-27 14:30:44
       */
       List<District> findAllDistrictForPub();

}






















