package com.fore.type.service.impl;

import com.fore.type.service.ForeTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StreetMapper;
import com.mapper.TypeMapper;
import com.pojo.Type;
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
public class ForeTypeServiceImpl implements ForeTypeService {

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    Type type;

    //查询所有的房屋类型
    @Override
    public List<Type> findAllTypeForPub() {
        Example example = new Example(Type.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(type);        
        return typeMapper.selectByExample(example);
    }
}
