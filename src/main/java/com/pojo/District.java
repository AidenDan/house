package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class District {
//    @Id
    private Integer id;

    private String name;


}