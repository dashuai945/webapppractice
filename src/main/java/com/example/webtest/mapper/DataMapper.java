package com.example.webtest.mapper;

import com.example.webtest.controller.model.Datas;
import org.apache.ibatis.annotations.*;


@Mapper
public interface DataMapper {
    @Insert("insert into datas (head,data) values (#{head},#{data})")
    void adddata(Datas datas);
    @Select("select * from datas where head=#{head}")
    Datas getdata(String head);
    @Delete("delete from datas where head=#{head}")
    void deletedata(String head);
    @Update("update datas set data=#{data} where head=#{head}")
    void updatedata(String head,String data);
    @Select("select * from datas where head=#{head} and data=#{data}")
    Datas getdata1(String head, String data);

    @Select("select * from datas where id=#{id}")
    Datas getid(Integer id);

    @Select("select head from datas where id = #{id}")
    String gethead(Integer id);
    @Select("select data from datas where id = #{id}")
    String getdatas(Integer id);
    @Select("select data from datas where head=#{head}")
    String getdata2(String head);






    
}
