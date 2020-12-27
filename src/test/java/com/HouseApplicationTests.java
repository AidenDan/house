package com;

import com.mapper.JpaTestMapper;
import com.pojo.JpaORM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-6-14 14:55:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseApplicationTests {
    @Autowired
    JpaTestMapper jpaTestMapper;

@Test
    public void test01(){
        JpaORM jpaORM = new JpaORM();
        int i = jpaTestMapper.insertSelective(jpaORM);
        System.out.println(i);
    }

    @Test
    public void test02(){
        JpaORM jpaORM = new JpaORM();
        jpaORM.setJpaName1("黄鱼");
        int i = jpaTestMapper.insertSelective(jpaORM);
        System.out.println(i);
    }
}
