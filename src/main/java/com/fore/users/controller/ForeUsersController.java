package com.fore.users.controller;

import com.fore.users.service.ForeUsersService;
import com.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Aiden
 * @version 1.0
 * @description 处理房东请求的控制器
 * @date 2019-12-26 13:43:17
 */
@Controller
@RequestMapping("/u")
public class ForeUsersController {
    @Autowired
    ForeUsersService foreUsersService;

    //注册时的时候要先判断次用户名是否已经存在
    @RequestMapping("/isexist")
    @ResponseBody
    public boolean isUsersExist(String name) {
        return foreUsersService.findUsersByName(name);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertUsers(Users users, Model model) {
        boolean b = foreUsersService.regsUsers(users);
        if (b) {
            return "fore/login";
        } else {
            model.addAttribute("msg01", "用户名已经存在！");
            return "fore/regs";
        }
    }

    @RequestMapping("/check")
    public String checkUsersByNameByPassword(String name, String password, HttpSession session, HttpServletRequest request) {
        Users users = foreUsersService.checkUsers(name, password);
        if (users != null) {
            session.setAttribute("fusers", users);
            session.setMaxInactiveInterval(60 * 30);
            /*当登录成功的时候，就要去查询到当前用户的房屋信息，然后在显示到管理页面的主页上*/
            return "redirect:/h/showHouse";
        } else {
            session.invalidate();
            request.setAttribute("msg02", "fail");
            return "fore/login";
        }
    }

    //退出操作
    @RequestMapping("/out")
    public String loginOut(HttpSession session) {
        if (session.getAttribute("fusers") != null) {
            session.invalidate();
            return "fore/login";
        } else
            return "fore/err";
    }
}
