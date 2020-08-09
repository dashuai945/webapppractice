package com.example.webtest.controller;

import com.example.webtest.controller.model.User;

import com.example.webtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class registerController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register")
    public String reg(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(HttpServletRequest request, Map<String,Object> map) {

        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        System.out.println(username);
        System.out.println(password);

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = userMapper.getuser(username);
        if (user1!=null) {
            map.put("msg1", "the user has been used,pls register again");
            return "register";
        } else {
           userMapper.adduser(user);
           map.put("mag",user);
           return "login";
        }
    }
    @RequestMapping("/getuser")
    public  String getuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if (user != null) {
            map.put("msg", "the user has been registered!");
            return "register";
        } else {
            map.put("msg", "the user has not been used");
            return "register";

        }
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        map.put("msg2","the user  "+loginuser+" login");
        return "login";
    }
    @RequestMapping("/deleteuser")
    public String deleteuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        User getuser = userMapper.getuser(username);
        if (getuser != null) {
            userMapper.deleteuser(username);
            map.put("msg3", "the user has been deleted!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/Update")
    public String Update(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        User getuser = userMapper.getuser1(username, password);
        if (getuser != null) {
            userMapper.updateuser(username,newpassword);
            map.put("msg3", "the user has been updated!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }
    @RequestMapping("/main_tab")
    public String main_tab(HttpServletRequest request, Map<String,Object> map) {
        return "main_tab";
    }
    @RequestMapping("/Tree")
    public String Tree(HttpServletRequest request, Map<String,Object> map) {
        return "Tree";
    }

    @RequestMapping("/Map")
    public String Map(HttpServletRequest request, Map<String,Object> map) {
        return "Map";
    }
    @RequestMapping("/Linear_table")
    public String Linear_table(HttpServletRequest request, Map<String,Object> map) {
        return "Linear_table";
    }
    @RequestMapping("/Array")
    public String Array(HttpServletRequest request, Map<String,Object> map) {
        return "Array";
    }
    @RequestMapping("/Linked_list")
    public String Linked_list(HttpServletRequest request, Map<String,Object> map) {
        return "Linked_list";
    }
    @RequestMapping("/Queue")
    public String Queue(HttpServletRequest request, Map<String,Object> map) {
        return "Queue";
    }
    @RequestMapping("/Stack")
    public String Stack(HttpServletRequest request, Map<String,Object> map) {
        return "Stack";
    }
    @RequestMapping("/Other")
    public String Other(HttpServletRequest request, Map<String,Object> map) {
        return "Other";
    }






}
