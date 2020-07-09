//package com.example.webtest.controller;
//
//import com.example.webtest.controller.model.User;
//import com.example.webtest.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@Controller
//public class loginController {
//    @Autowired
//    private UserMapper userMapper;
//    @GetMapping("/login")
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String,Object> map){
//        String username = request.getParameter( "username");
//        String password = request.getParameter( "password");
//        User loginuser = userMapper.login(username, password);
//        System.out.println(loginuser);
//        map.put("msg2","the user  "+loginuser+"login");
//        return "login";
//    }
//
//}
