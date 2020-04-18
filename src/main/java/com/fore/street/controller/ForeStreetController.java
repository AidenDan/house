package com.fore.street.controller;

import com.fore.street.service.ForeStreetService;
import com.pojo.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-27 15:07:39
 */
@RestController
@RequestMapping("/s")
public class ForeStreetController {
    @Autowired
    ForeStreetService foreStreetService;

    /**
     * 查询数据库，把查询得到的每一条结果封装到一个street对象中
     * 把street对象把存到list中，返回到前端就是一个json数组
     * */

    @RequestMapping("/getStreet")
    public List<Street> getAllStreetForPub(Integer districtId){
        return foreStreetService.findAllStreetForPub(districtId);
    }
}
