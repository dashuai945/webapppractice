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
    @RequestMapping("/register")
    public String register(HttpServletRequest request, Map<String,Object> map ){

        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        System.out.println(username);
        System.out.println(password);

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.adduser(user);
        map.put("mag",user);



        return "register";

    }
}
