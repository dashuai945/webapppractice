package com.example.webtest.mapper;

import com.example.webtest.controller.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Select("select * from user where username=#{username}")
    User getuser(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);
    @Delete("delete from user where username=#{username}")
    void deleteuser(String username);
    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username,String password);
    @Select("select * from user where username=#{username} and password=#{password}")
    User getuser1(String username,String password);


}
