package com.fore.district.service.impl;

import com.admin.district.service.AdminDistrictService;
import com.fore.district.service.ForeDistrictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DistrictMapper;
import com.mapper.StreetMapper;
import com.pojo.District;
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
@Service("foreDistrictServiceImpl")
public class ForeDistrictServiceImpl implements ForeDistrictService {

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    District district;

    //查询所有的区域用于发布
    @Override
    public List<District> findAllDistrictForPub() {
        Example example = new Example(District.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(district);
        return districtMapper.selectByExample(example);
    }
}
