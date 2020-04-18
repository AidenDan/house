package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/vw").setViewName("success2");
        //super.addViewControllers(registry);
    }

    @Bean //添加@Bean注解，将组建添加到容器中，进行路径映射
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
               // registry.addViewController("/").setViewName("/h/listHouse");
                //registry.addViewController("/index.html").setViewName("login");
                //添加一个试图映射，来重定向防止表单重复提交
                //registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
        return adapter;
    }

    //注册拦截器，可以给它添加要拦截的路径
    //被拦截就会到LoginHandlerInterceptor
    //静态资源也不能被拦截，否则没有样式
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(loginInterceptor)
               .addPathPatterns("/**")
               .excludePathPatterns("/", "/fore/css/**", "/fore/images/**", "/fore/js/**", "/fore/scripts"
                       ,"/admin/easyUI/**", "/admin/images/**", "/admin/js/**", "/h/listHouse", "/adminCheck","/u/check","/fore/login.html", "/fore/login2.html","/fore/regs.html"
                       , "/admin/adminlogin.html", "/admin/regs.html", "/h/detailsHouse", "/t/getType", "/d/getAllDistrict", "/s/getStreet");
         super.addInterceptors(registry);
    }
}

