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
        map.put("msg2","the user  "+loginuser+"login");
        return "login";
    }


}
