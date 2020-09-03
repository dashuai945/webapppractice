package com.example.webtest.mapper;

import com.example.webtest.controller.model.Datas;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DataMapper {
    @Insert("insert into datas (title,head,data) values (#{title},#{head},#{data})")
    void adddata(Datas datas);
    @Select("select * from datas where title=#{title} and head=#{head}")
    Datas getdata0(String title,String head);

    @Select("select data from datas where title=#{title} and head=#{head}")
    String getdata(String title,String head);
    @Delete("delete from datas where title=#{title} and head=#{head}")
    void deletedata(String title,String head);
    @Update("update datas set data=#{data} where title=#{title} and head=#{head}")
    void updatedata(String title,String head,String data);


    @Select("select * from datas where id=#{id}")
    Datas getid(Integer id);

    @Select("select title from datas where id = #{id}")
    String gettitle(Integer id);
    @Select("select head from datas where id = #{id}")
    String gethead(Integer id);
    @Select("select data from datas where id = #{id}")
    String getdatas(Integer id);

    @Select("select title from datas where data=#{data}")
    String gettitle1(String data);
    @Select("select head from datas where data=#{data}")
    String gethead1(String data);


    @Select("select title from datas")
    List<String> getalltitle();
    @Select("select head from datas")
    List<String> getallhead();
    @Select("select data from datas")
    List<String> getalldata();





    
}
