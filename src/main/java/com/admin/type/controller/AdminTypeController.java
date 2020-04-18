package com.admin.type.controller;

import com.admin.type.service.AdminTypeService;
import com.github.pagehelper.PageInfo;
import com.pojo.Type;
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
@RequestMapping("/Type")
public class AdminTypeController {

    @Autowired
    private AdminTypeService adminTypeService;

    @RequestMapping("/getAllTypeByPage")
    public Map<String, Object> getAllTypeByPage(PageUtils pageUtils){
        Map<String, Object> map = new HashMap<>();
        PageInfo<Type> pageInfo = adminTypeService.findAllType(pageUtils);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        System.out.println("操蛋"+map);
        return map;
    }

    //添加区域信息
    @RequestMapping("/addType")
    public Map<String, Object> addType(Type Type){
        Map<String, Object> map = new HashMap<>();
        Integer returnKey = adminTypeService.addTypeService(Type);
        map.put("returnKey", returnKey);
        return map;
    }

    //根据id查询区域信息
    @RequestMapping("/getTypeById")
    public Type getTypeById(Integer id){
        return adminTypeService.findTypeById(id);
    }

    //修改区域信息
    @RequestMapping("/upType")
    public Map<String, Object> upType(Type Type){
        Integer returnKey = adminTypeService.upType(Type);
        Map<String, Object> map = new HashMap<>();
        map.put("returnKey", returnKey);
        return  map;
    }

    //删除区域信息
    @RequestMapping("/delTypeById")
    public Map<String, Object> delTypeById(Integer id){
        Map<String, Object> map = new HashMap<>();
        try {
            //删除失败的话就把异常信息try cath起来
            Integer returnKey = adminTypeService.removeTypeById(id);
            map.put("returnKey", returnKey);
        } catch (Exception e) {
            map.put("returnKey", -1);
        }
        return  map;
    }

    //批量删除区域信息
    @RequestMapping("/delTypeByBatch")
    public Map<String, Object> delTypeByBatch(String ids){
        Map<String, Object> map = new HashMap<>();
        String[] split = ids.split(",");
        Integer[] arr = new Integer[split.length];
        for (int i = 0; i <split.length ; i++) {
            arr[i] = new Integer(split[i] );
        }
        Integer returnKey = adminTypeService.removeTypeByBatch(arr);
        map.put("returnKey", returnKey);
        return map;
    }
}
















