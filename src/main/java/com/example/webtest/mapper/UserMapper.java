package com.example.webtest.mapper;

import com.example.webtest.controller.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Select("select * from user where username=#{username}")
    User getuser(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);
}
