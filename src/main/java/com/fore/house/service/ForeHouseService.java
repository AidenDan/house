package com.fore.house.service;

import com.condition.UsersCondition;
import com.github.pagehelper.PageInfo;
import com.pojo.House;
import com.pojo.HouseMoreInfo;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-27 15:36:19
 */
public interface ForeHouseService {

    /**
     *
     *
     * @description: 插入house信息
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-27 15:36:42
     */
    boolean addHouseInfo(House house);

    /**
     *
     *
     * @description: 分页查询当前登录用户的所有房屋信息展示到主页
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-29 14:29:03
     */
     PageInfo<HouseMoreInfo> showHouse(Integer pageNum, Integer pageSize, Integer userId);

     /**
      *
      *
      * @description: 根据房屋id查出房屋的具体信息用于修改回显
      * @param null
      * @return:
      * @author: Aiden
      * @time: 2019-12-30 19:34:12
      */
     HouseMoreInfo getHouseByHouseId(String houseId);

     /**
      *
      *
      * @description: 更新房屋信息
      * @param null
      * @return:
      * @author: Aiden
      * @time: 2019-12-30 21:21:01
      */
      boolean upHouseInfo(House house);

      /**
       *
       *
       * @description: 下架该房源，把isdel设为1
       * @param null
       * @return:
       * @author: Aiden
       * @time: 2019-12-31 16:06:45
       */
      Integer downHouseService(String houseId);

    /**
     *
     *
     * @description: 显示房屋详细信息
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-31 16:06:45
     */
    HouseMoreInfo detailsHouseService(String houseId);

    /**
     *
     *
     * @description: 分页动态查询所有房屋信息展示到主页
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-29 14:29:03
     */
    PageInfo<HouseMoreInfo> showHouse5(Integer pageNum, Integer pageSize, UsersCondition condition);



}
