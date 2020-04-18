package com;

import com.admin.users.service.AdminUsersService;
import com.mapper.DistrictMapper;
import com.mapper.HouseMapper;
import com.mapper.UsersMapper;
import com.pojo.District;
import com.pojo.House;
import com.pojo.Users;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class HouseApplicationTests {

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    District district;

    @Autowired
    Users users;

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    House house;
    @Autowired
    AdminUsersService adminUsersService;

    @Test
    void contextLoads() {
        Example example = new Example(District.class);
        List<District> districtList = districtMapper.selectByExample(example);
        districtList.forEach(temp-> System.out.println(temp));

    }

    @Test
    void contextLoads01() {
        Example example = new Example(Users.class);
        List<Users> usersList = usersMapper.selectByExample(example);
        usersList.forEach(temp-> System.out.println(temp));

    }

    @Test
    void contextLoads02() {
        Example example = new Example(House.class);
        List<House> houseList = houseMapper.selectByExample(example);
        houseList.forEach(temp-> System.out.println(temp));
    }

    /*@Test
    void contextLoads03() {
        Users users = new Users();
        for (int i = 0; i <1000000 ; i++) {
            users.setId(null);
            users.setPassword(UUID.randomUUID().toString().replace("-", ""));
            users.setIsadmin(1);
            users.setAge(28);
            users.setName("曹操"+UUID.randomUUID().toString().replace("-", ""));
            users.setTelephone("138"+new Random().nextInt(99999999));
            Boolean bo = adminUsersService.insertAdmin(users);
        }
    }*/
}



































