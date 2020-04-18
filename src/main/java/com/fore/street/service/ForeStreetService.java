package com.fore.street.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Street;
import com.utils.PageUtils;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:25:47
 */
public interface ForeStreetService {

     /**
      *
      *
      * @description: 根据区域id查询所有的街区用于发布
      * @param null
      * @return: List<Street>
      * @author: Aiden
      * @time: 2019-12-27 15:05:25
      */
     List<Street> findAllStreetForPub(Integer districtId);
}






















