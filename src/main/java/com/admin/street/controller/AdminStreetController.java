package com.admin.street.controller;

import com.admin.street.service.AdminStreetService;
import com.github.pagehelper.PageInfo;
import com.pojo.Street;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:24:08
 */
@RestController
@RequestMapping("/Street")
public class AdminStreetController {

    @Autowired
    private AdminStreetService adminStreetService;

    @RequestMapping("/getAllStreetByPage")
    public Map<String, Object> getAllStreetByPage(PageUtils pageUtils){
        Map<String, Object> map = new HashMap<>();
        PageInfo<Street> pageInfo = adminStreetService.findAllStreet(pageUtils);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        System.out.println("操蛋"+map);
        return map;
    }

    //添加区域信息
    @RequestMapping("/addStreet")
    public Map<String, Object> addStreet(Street Street){
        Map<String, Object> map = new HashMap<>();
        Integer returnKey = adminStreetService.addStreetService(Street);
        map.put("returnKey", returnKey);
        return map;
    }

    //根据id查询区域信息
    @RequestMapping("/getStreetById")
    public Street getStreetById(Integer id){
        return adminStreetService.findStreetById(id);
    }

    //修改区域信息
    @RequestMapping("/upStreet")
    public Map<String, Object> upStreet(Street Street){
        Integer returnKey = adminStreetService.upStreet(Street);
        Map<String, Object> map = new HashMap<>();
        map.put("returnKey", returnKey);
        return  map;
    }

    //删除区域信息
    @RequestMapping("/delStreetById")
    public Map<String, Object> delStreetById(Integer id){
        Map<String, Object> map = new HashMap<>();
        try {
            //删除失败的话就把异常信息try cath起来
            Integer returnKey = adminStreetService.removeStreetById(id);
            map.put("returnKey", returnKey);
        } catch (Exception e) {
            map.put("returnKey", -1);
        }
        return  map;
    }

    //批量删除区域信息
    @RequestMapping("/delStreetByBatch")
    public HashMap<String, Object> delStreetByBatch(String ids){
        HashMap<String, Object> map = new HashMap<>();
        String[] split = ids.split(",");
        Integer[] arr = new Integer[split.length];
        for (int i = 0; i <split.length ; i++) {
            arr[i] = new Integer(split[i] );
        }
        Integer returnKey = adminStreetService.removeStreetByBatch(arr);
        map.put("returnKey", returnKey);
        return map;
    }
}
















