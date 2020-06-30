package com.example.webtest.controller;

import com.example.webtest.controller.model.User;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class registerController {
    @GetMapping("/register")
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request, Map<String,Object> map ){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        map.put("mag",user);

        System.out.println(username);
        System.out.println(password);
        return "register";

    }
}
