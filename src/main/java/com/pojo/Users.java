package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Users {
    private Integer id;

    private String name;

    private String password;

    private String telephone;

    private Integer isadmin;

    private Integer age;


}