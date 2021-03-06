package com.fore.house.service.impl;

import com.condition.UsersCondition;
import com.fore.house.service.ForeHouseService;
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
public class ForeHouseServiceImpl implements ForeHouseService {
    @Autowired
    HouseMapper houseMapper;

    @Override
    public boolean addHouseInfo(House house) {
        int i = houseMapper.insertSelective(house);
        return i>0;
    }

    //分页查询所有的房屋信息
    @Override
    public PageInfo<HouseMoreInfo> showHouse(Integer pageNum, Integer pageSize, Integer userId) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse(userId);
        return new PageInfo<>(houseList);
    }

    //根据houseId查询house
    @Override
    public HouseMoreInfo getHouseByHouseId(String houseId) {
        return houseMapper.selectHouseByHouseId(houseId);
    }

    //修改房子信息
    @Override
    public boolean upHouseInfo(House house) {
        int i = houseMapper.updateByPrimaryKeySelective(house);
        return i>0;
    }

    //下架房源
    @Override
    public Integer downHouseService(String houseId) {
        return houseMapper.downHouseByHouseId(houseId);
    }

    //显示房屋信息。插单条
    @Override
    public HouseMoreInfo detailsHouseService(String houseId) {
        return houseMapper.selectSingleHouse(houseId);
    }

    /**
     *
     *
     * @description: 分页动态查询所有的房屋信息
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2020-1-2 15:40:31
     */
    @Override
    public PageInfo<HouseMoreInfo> showHouse5(Integer pageNum, Integer pageSize, UsersCondition condition) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的房屋记录信息
        List<HouseMoreInfo> houseList = houseMapper.selectAllHouse5(condition);
        return new PageInfo<>(houseList);
    }

}
