package com.fore.users.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Users;
import com.utils.PageUtils;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:25:47
 */
public interface ForeUsersService {

      /**
       *
       *
       * @description: 登录时根据用户名判断用户是否存在
       * @param name
       * @return:
       * @author: Aiden
       * @time: 2019-12-26 13:57:24
       */
        boolean findUsersByName(String name);

      /**
       *
       *
       * @description:
       * @param users 用于封装房东注册信息
       * @return:
       * @author: Aiden
       * @time: 2019-12-26 13:46:05
       */
       boolean regsUsers(Users users);

    /**
        *
        *
        * @description: 根据用户名和密码进行登录验证，若验证成功，那么必须返回Users用于展示用户信息
        * @param name
        * @param password
        * @return: Users
        * @author: Aiden
        * @time: 2019-12-26 21:08:30
        */
       Users checkUsers(String name, String password);

}






















