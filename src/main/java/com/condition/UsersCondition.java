package com.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aiden
 * @version 1.0
 * @description 封装了动态查询的参数
 * @date 2019-12-24 18:05:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersCondition {
    private String cname;
    private String ctelephone;
    /*封装房屋动态查询的查询条件*/
    private Integer ctypeId;
    //private String ctypeName;
    private Integer cdistrictId;
    //private String cdistrictName;
    private Integer cstreetId;
    //private String cstreetName;
    private Integer cispass;
    private String cprice1;
    private String cprice;
    private String ctitle;

    private Integer cfloorage1;
    private Integer cfloorage;

}
