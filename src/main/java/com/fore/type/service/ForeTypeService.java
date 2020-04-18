package com.fore.type.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Type;
import com.utils.PageUtils;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:25:47
 */
public interface ForeTypeService {

     /**
      *
      *
      * @description:
      * @param
      * @return: 所有的房屋类型
      * @author: Aiden
      * @time: 2019-12-27 14:08:31
      */
      List<Type> findAllTypeForPub();

}






















