package com.example.webtest.mapper;

import com.example.webtest.controller.model.Datas;
import org.apache.ibatis.annotations.*;//ibatis是mybatis的前身,MyBatis可以利用SQL映射文件来配置，也可以利用Annotation来设置。
import java.util.List;

@Mapper
public interface DataMapper {

//    方法@Insert<insert>
//       @Update<update>
//       @Delete<delete>
// 这些注解中的每一个代表了执行的真实 SQL。它们每一个都使用字符串数组（或单独的字符串）。如果传递的是字符串数组，
// 它们由每个分隔它们的单独空间串联起来。属性：value，这是字符串数组用来组成单独的SQL语句


    //注意这里只有3个参数，则#{}中的标识符可以任意取
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

    //根据数据库id获取内容
    @Select("select * from datas where id=#{id}")
    Datas getid(Integer id);
    @Select("select title from datas where id = #{id}")
    String gettitle(Integer id);
    @Select("select head from datas where id = #{id}")
    String gethead(Integer id);
    @Select("select data from datas where id = #{id}")
    String getdatas(Integer id);

    //根据数据获取标题和类
    @Select("select title from datas where data=#{data}")
    String gettitle1(String data);
    @Select("select head from datas where data=#{data}")
    String gethead1(String data);

    //以列表形式获取所有信息
    @Select("select title from datas")
    List<String> getalltitle();
    @Select("select head from datas")
    List<String> getallhead();
    @Select("select data from datas")
    List<String> getalldata();





    
}
