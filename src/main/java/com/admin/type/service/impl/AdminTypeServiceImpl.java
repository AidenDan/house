package com.admin.type.service.impl;

import com.admin.type.service.AdminTypeService;
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

import java.util.Arrays;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:26:05
 */
@Service
public class AdminTypeServiceImpl implements AdminTypeService {

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    StreetMapper streetMapper;

    @Autowired
    Type type;

    @Override
    public PageInfo<Type> findAllType(PageUtils pageUtils) {
        Example example = new Example(Type.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(type);
        //开启分页
        PageHelper.startPage(pageUtils.getPage(), pageUtils.getRows());
        //查询所有的区域
        List<Type> typeList = typeMapper.selectByExample(example);
        //封装区域信息到PageInfo
        return new PageInfo<>(typeList);
    }

    @Override
    public Integer addTypeService(Type type) {
        //动态插入，有这个条件就插入这个条件
        return typeMapper.insertSelective(type);
    }

    //根据区域id查询区域，用于回显
    @Override
    public Type findTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    //更新区域
    @Override
    public Integer upType(Type Type) {
        return typeMapper.updateByPrimaryKeySelective(Type);
    }

    //删除区域的同时要把区域对应的街道给删除，执行了2个SQL，开启事物
    @Transactional
    @Override
    public Integer removeTypeById(Integer id) {
        Integer i1 = typeMapper.deleteByPrimaryKey(id);
      /*  int i =10;
        int j =0;
        i = i/j;*/
       // Integer i2 = streetMapper.delStreetByType_Id(id);
        return 1;
    }

    @Override
    public Integer removeTypeByBatch(Integer[] ids) {
        Example example = new Example(Type.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        return typeMapper.deleteByExample(example);
    }

    //查询所有的房屋类型
    @Override
    public List<Type> findAllTypeForPub() {
        Example example = new Example(Type.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(type);
        return typeMapper.selectByExample(type);
    }
}
