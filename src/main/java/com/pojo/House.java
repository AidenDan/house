package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class House {

    //主键 我忘了
    @Id
    private String id;

    private Integer userId;

    private Integer typeId;

    private String title;

    private String description;

    private Long price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;

    private Integer floorage;

    private String contact;

    private Integer streetId;

    private Integer ispass;

    private Integer isdel;

    private String path;

    //不参与持久化操作
    @Transient
    private Integer districtId;

}