package com.admin.house.service.impl;

import com.admin.house.service.AdminHouseService;
import com.condition.UsersCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.HouseMapper;
import com.pojo.House;
import com.pojo.HouseMoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-27 15:37:42
 */
@Service
public class AdminHouseServiceImpl implements AdminHouseService{
    @Autowired
    HouseMapper houseMapper;

    //分页查询所有的房屋信息
    @Override
    public PageInfo<HouseMoreInfo> showHouse(Integer pageNum, Integer pageSize, Integer userId) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse(userId);
        return new PageInfo<>(houseList);
    }

    @Override
    public PageInfo<HouseMoreInfo> showHouse2(Integer pageNum, Integer pageSize, UsersCondition condition) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse2( condition);
        return new PageInfo<>(houseList);
    }

    @Override
    public PageInfo<HouseMoreInfo> showHouse3(Integer pageNum, Integer pageSize, UsersCondition condition) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse3(condition);
        return new PageInfo<>(houseList);
    }

    @Override
    public PageInfo<HouseMoreInfo> showHouse4(Integer pageNum, Integer pageSize, UsersCondition condition) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse4(condition);
        return new PageInfo<>(houseList);
    }

    /**
     *
     *
     * @description: 批量审核房屋
     * @param null
     * @param arr
     * @return:
     * @author: Aiden
     * @time: 2020-1-2 13:01:58
     */
    @Override
    public Integer verifyHouseServiceByBatch(String[] arr) {
        return houseMapper.verifyHouseDaoByBatch(arr);
    }

}
