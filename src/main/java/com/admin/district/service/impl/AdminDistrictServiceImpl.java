package com.admin.district.service.impl;

import com.admin.district.service.AdminDistrictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DistrictMapper;
import com.mapper.StreetMapper;
import com.pojo.District;
import com.pojo.Street;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:26:05
 */
@Service("adminDistrictServiceImpl")
public class AdminDistrictServiceImpl implements AdminDistrictService {
    @Autowired
    DistrictMapper districtMapper;
    @Autowired
    StreetMapper streetMapper;
    @Autowired
    District district;

    @Override
    public PageInfo<District> findAllDistrict(PageUtils pageUtils) {
        Example example = new Example(District.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(district);
        //开启分页
        PageHelper.startPage(pageUtils.getPage(), pageUtils.getRows());
        //查询所有的区域
        List<District> districtList = districtMapper.selectByExample(example);
        //封装区域信息到PageInfo
        return new PageInfo<>(districtList);
    }

    @Override
    public Integer addDistrictService(District district) {
        //动态插入，有这个条件就插入这个条件
        return districtMapper.insertSelective(district);
    }

    //根据区域id查询区域，用于回显
    @Override
    public District findDistrictById(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    //更新区域
    @Override
    public Integer upDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    //删除区域的同时要把区域对应的街道给删除，执行了2个SQL，开启事物
    @Transactional
    @Override
    public Integer removeDistrictById(Integer id) {
        //删除区域
        Integer i1 = districtMapper.deleteByPrimaryKey(id);
        //删除街道
        Example example = new Example(Street.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("district_id", id);
        Integer i2 = streetMapper.deleteByExample(example);
        return 1;
    }

    /**
     *
     *
     * @description: 根据id批量删除
     * @param null
     * @return:
     * @author: Aiden
     * @time: 2020-2-2 11:24:17
     */

    @Override
    public Integer removeDistrictByBatch(Integer[] ids) {
        Example example = new Example(District.class);
        Example.Criteria criteria = example.createCriteria();
        List<Integer> list = Arrays.asList(ids);
        criteria.andIn("id", list);
        return districtMapper.deleteByExample(example);
    }

    //查询所有的区域用于发布
    @Override
    public List<District> findAllDistrictForPub() {
        Example example = new Example(District.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(example);
        return districtMapper.selectByExample(example);
    }
}
