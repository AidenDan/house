package com.mapper;

import com.pojo.Users;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;



public interface UsersMapper extends Mapper<Users> {

    //房屋审核功能，把ispass设为1
    @Update("update house set ispass ='1' where id = #{houseId}")
    Integer makePass(@Param("houseId") String houseId);

    //取消房屋审核通过，把ispass设为0
    @Update("update house set ispass ='0' where id = #{houseId}")
    Integer makeNoPass(@Param("houseId") String houseId);

    //修改管理员密码
    @Update("update users set password=#{NewPass} where id =#{id}")
    Integer updateAdminPassword(@Param("id") String id, @Param("NewPass") String NewPass);
}





















