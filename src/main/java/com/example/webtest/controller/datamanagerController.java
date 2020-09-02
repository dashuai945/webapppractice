package com.example.webtest.controller;

import com.example.webtest.controller.model.Datas;
import com.example.webtest.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class datamanagerController {


    @Autowired
    private DataMapper dataMapper;


    @RequestMapping("/Getdata")
    public String Getdata(HttpServletRequest request, Map<String,Object> map) {
        String head = request.getParameter("head");
        String datas = dataMapper.getdata2(head);
        if (datas != null) {
            map.put("msg10", "the head has been existed!");
            map.put("msg11", "the "+ head +"'s contents are "+ datas );
            return "Tree";
        } else {
            map.put("msg10", "the head has not been added");
            return "Tree";

        }
    }
    @RequestMapping("/Adddata")
    public String Adddata(HttpServletRequest request, Map<String,Object> map) {
        String head = request.getParameter( "head"); //一种取参数的方法。把jsp文件中的数据读取到出来。然后就可以封装利用起来。
        String data = request.getParameter( "data");
        System.out.println(head);
        System.out.println(data);

        Datas datas=new Datas();
        datas.setHead(head);
        datas.setData(data);

        Datas datas1 = dataMapper.getdata(head);
        if (datas1 != null) {
            map.put("msg7", "the head has been used,pls Updatedata it or try other head name");
            return "Tree";
        } else {
            dataMapper.adddata(datas);
            map.put("msg7", "the head added successfully");
            return "Tree";
        }
    }
    @RequestMapping("/Detedata")
    public String Detedata(HttpServletRequest request, Map<String,Object> map) {
        String head = request.getParameter("head");
        Datas getdatas = dataMapper.getdata(head);
        if (getdatas != null) {
            dataMapper.deletedata(head);
            map.put("msg8", "the head has been deleted!");
            return "Tree";
        } else {
            map.put("msg8", "the head is not a legal head");
            return "Tree";
        }
    }
    @RequestMapping("/Updatedata")
    public String Updatedata(HttpServletRequest request, Map<String,Object> map) {
        String head = request.getParameter("head");
//        String data = request.getParameter("data");
        String newdata = request.getParameter("newdata");
        Datas getdata = dataMapper.getdata(head);
        if (getdata != null) {
            dataMapper.updatedata(head,newdata);
            map.put("msg9", "the head has been updated!");
            return "Tree";
        } else {
            map.put("msg9", "the head is not a legal head");
            return "Tree";
        }
    }







//    @RequestMapping("/main_tab")
//    public String main_tab(HttpServletRequest request, Map<String,Object> map) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        User user1 = userMapper.login(username, password);
//        System.out.println(user1);
//        if (user1 != null) {
//            map.put("msg2","the   "+username+" login");
//            return "main_tab";
//        }else {
//            return "main_tab";
//        }
//
//
//
//    }
//
//    @GetMapping("/Tree")             //指定路径
//    public String tree(){
//        return "Tree";
//    }
//    @RequestMapping("/Tree")
//    public String Tree(HttpServletRequest request, Map<String,Object> map) {
//        return "Tree";
//    }
//
//    @RequestMapping("/Map")
//    public String Map(HttpServletRequest request, Map<String,Object> map) {
//        return "Map";
//    }
//    @RequestMapping("/Linear_table")
//    public String Linear_table(HttpServletRequest request, Map<String,Object> map) {
//        return "Linear_table";
//    }
//    @RequestMapping("/Array")
//    public String Array(HttpServletRequest request, Map<String,Object> map) {
//        return "Array";
//    }
//    @RequestMapping("/Linked_list")
//    public String Linked_list(HttpServletRequest request, Map<String,Object> map) {
//        return "Linked_list";
//    }
//    @RequestMapping("/Queue")
//    public String Queue(HttpServletRequest request, Map<String,Object> map) {
//        return "Queue";
//    }
//    @RequestMapping("/Stack")
//    public String Stack(HttpServletRequest request, Map<String,Object> map) {
//        return "Stack";
//    }
//    @RequestMapping("/Other")
//    public String Other(HttpServletRequest request, Map<String,Object> map) {
//        return "Other";
//    }






}
