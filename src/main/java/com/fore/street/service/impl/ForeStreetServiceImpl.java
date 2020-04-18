package com.fore.street.service.impl;

import com.fore.street.service.ForeStreetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StreetMapper;
import com.pojo.Street;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:26:05
 */
@Service
public class ForeStreetServiceImpl implements ForeStreetService {
    @Autowired
    StreetMapper streetMapper;

    @Autowired
    Street street;

    //查询当前区域对应的所有街道用于发布
    @Override
    public List<Street> findAllStreetForPub(Integer districtId) {
        Example example = new Example(Street.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("districtId",districtId);
        return streetMapper.selectByExample(example);
    }
}
