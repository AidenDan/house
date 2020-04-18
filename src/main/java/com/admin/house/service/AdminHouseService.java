package com.admin.house.service;

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
public interface AdminHouseService {

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
     * @description: 在运营商分页查询当前登录用户的所有房屋信息展示到主页
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-29 14:29:03
     */
    PageInfo<HouseMoreInfo> showHouse2(Integer pageNum, Integer pageSize, UsersCondition condition);

    /**
     *
     *
     * @description: 在运营商分页查询当前登录用户的所有已经审核通过房屋信息展示到主页
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-29 14:29:03
     */
    PageInfo<HouseMoreInfo> showHouse3(Integer pageNum, Integer pageSize, UsersCondition condition);

    /**
     *
     *
     * @description: 在运营商分页查询当前登录用户的所有未审核通过房屋信息展示到主页
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2019-12-29 14:29:03
     */
    PageInfo<HouseMoreInfo> showHouse4(Integer pageNum, Integer pageSize, UsersCondition condition);

    /**
     *
     *
     * @description: 批量审核房屋
     * @param null
     * @param arr
     * @return:
     * @author: Aiden
     * @time: 2020-1-2 12:58:37
     */
    Integer verifyHouseServiceByBatch(String[] arr);

}
