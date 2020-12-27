package com.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-6-14 14:47:11
 */

@Data
@Entity
@Table(name = "jpa_test")
public class JpaORM {

    @Id
    @Column(name = "jpa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jpaId1;

    @Column(name = "jpa_name")
    private String jpaName1;
}
