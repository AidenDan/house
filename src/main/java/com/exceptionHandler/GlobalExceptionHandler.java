package com.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description 全局异常处理
 * @date 2020-6-21 16:32:40
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 专门捕获控制器中的MyExceptionHandler异常
     *
     * @param ex 捕获的异常
     * @return 返回json数据到页面
     */
    @ResponseBody
    @ExceptionHandler(MyExceptionHandler.class)
    public Map<String, Object> exceptionHandler(MyExceptionHandler ex){
        Map<String, Object> map = new HashMap<>();
        String code = ex.getCode();
        if("500".equals(code)){
            map.put("code", code);
            map.put("msg", ex.getMsg());
            map.put("status", "fail");
        }
        if("400".equals(code)){
            map.put("code", code);
            map.put("msg", ex.getMsg());
            map.put("status", "fail");
        }
        return map;
    }

    /**
     * 专门捕获控制器中未知的异常
     *
     * @param ex 捕获的异常
     * @return 返回json数据到页面
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> exceptionHandlerUnExcepted(Exception ex){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "未知的错误类型");
        return map;
    }
}
