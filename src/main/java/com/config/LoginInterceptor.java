package com.config;

import com.pojo.Users;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 * 登录验证拦截
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object users = request.getSession().getAttribute("users");
        Object fusers = request.getSession().getAttribute("fusers");
        //username不为空就放行，当不经过登录直接输入后台的地址就必须拦截
        //不经过登录的话用户名就肯定为空了，此时就不能让它登录，可以用户名来做一个判断
        // if(users == null && fusers!=null){
        //返回登录页面
        // logger.info( "后台用户没有权限，请先登录！");
        // request.getRequestDispatcher("/fore/login.html").forward(request, response);
        //response.sendRedirect("/admin/adminlogin.html");
        //return true;
        //把所有的前台url装到list集合
        List<String> foreUrlList =
                Arrays.asList("/d/getAllDistrict", "/h/getHouse", "/h/showHouse", "/h//upHouse/{houseId}", "/h/finalUpHouse",
                        "/h/downHouse", "/h/detailsHouse", "/h/listHouse", "/s/getStreet", "/t/getType", "/u/isexist", "/u/check", "/u/out",
                        "/fore/details.html", "/fore/err.html", "/fore/fabu.html", "/fore/fabu2.html", "/fore/guanli.html", "/fore/list.html", "/fore/timeout.html");
        List<String> adminUrlList =
                Arrays.asList("/district/getAllDistrictByPage", "/district/addDistrict", "/district/getDistrictById", "/district/upDistrict", "/district/delDistrictById",
                        "/district/delDistrictByBatch", "/house/getAllHouse", "/house/getAllHouse1", "/house/getAllHouse2", "/house/verifyByBatch",
                        "/Street/getAllStreetByPage", "/Street/addStreet", "/Street/getStreetById", "/Street/upStreet", "/Street/delStreetById", "/Street/delStreetByBatch",
                        "/Type/getAllTypeByPage", "/Type/addType", "/Type/getTypeById", "/Type/upType", "/Type/delTypeById", "/Type/delTypeByBatch",
                        "/getAllUsersByPage", "/addUsers", "/getUsersById", "/upUsers", "/delUsersById", "/delUsersByBatch", "/getUsersById1", "/getUsersById2",
                        "/adminCheck", "/insertAdmin", "/out", "/editAdminPassword/{id}/{NewPass}/{RePass}", "/admin/admin.html", "/admin/district.html", "/admin/err.html", "/admin/street.html", "/admin/type.html",
                        "/admin/unverified.html", "/admin/user.html", "/admin/verified.html", "/admin/verify.html");
        if (users == null && fusers == null) {
            logger.info("未检测到用户登录！");
            request.getRequestDispatcher("/h/listHouse").forward(request, response);
            return false;
            //后台用户登录时
        } else if (users != null && fusers == null) {
            String servletPath = request.getServletPath();
            if (!adminUrlList.contains(servletPath)) {
                logger.info("无权限访问");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                response.sendRedirect("/admin/err.html");
                return false;
            }
        } else if (fusers != null && users == null) {
            String servletPath = request.getServletPath();
            if (!foreUrlList.contains(servletPath)) {
                logger.info("无权限访问");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                response.sendRedirect("/fore/err.html");
                return false;
            }
            //return super.preHandle(request,response,handler);
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
