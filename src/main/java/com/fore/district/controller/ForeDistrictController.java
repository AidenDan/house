package com.fore.district.controller;

import com.fore.district.service.ForeDistrictService;
import com.pojo.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-21 11:24:08
 */
@RestController(value = "foreDistrictController")
@RequestMapping("/d")
public class ForeDistrictController {

    @Autowired
    private ForeDistrictService foreDistrictService;

    @RequestMapping("/getAllDistrict")
    public List<District> getAllDistrict(){
        return foreDistrictService.findAllDistrictForPub();
    }


}
















