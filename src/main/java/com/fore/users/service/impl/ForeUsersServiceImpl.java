package com.fore.users.service.impl;

import com.fore.users.service.ForeUsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UsersMapper;
import com.pojo.Users;
import com.utils.MD5Utils;
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
public class ForeUsersServiceImpl implements ForeUsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    Users users;

    //处理房东登录请求的控制器
    @Override
    public boolean findUsersByName(String name) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        List<Users> usersList = usersMapper.selectByExample(example);
        return usersList != null && usersList.size() > 0;
    }

    //房东注册功能
    @Override
    public boolean regsUsers(Users users) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", users.getName());
        List<Users> usersList = usersMapper.selectByExample(example);
        if(usersList != null && usersList.size() > 0){
            return false;
        }else {
            //用户有管理员与非管理员，非管理员就是房东
            users.setIsadmin(0);
            //MD5对密码进行加密
            String s = MD5Utils.md5Encrypt(users.getPassword());
            users.setPassword(s);
            int i = usersMapper.insertSelective(users);
            return i>0;
        }
    }

    //根据用户名和密码进行登录验证，若验证成功，那么必须返回Users用于展示用户信息
    @Override
    public Users checkUsers(String name, String password){

        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        String pwd = MD5Utils.md5Encrypt(password);
        criteria.andEqualTo("password", pwd);
        criteria.andEqualTo("isadmin", 0);
        List<Users> usersList = usersMapper.selectByExample(example);
        if  (usersList !=null && usersList.size()>0)
        return usersList.get(0);
        else
            return null;
    }

}





















