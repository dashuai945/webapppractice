package com.example.webtest.controller;

import com.example.webtest.controller.model.User;
import com.example.webtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;



@Controller  //用于定义控制器类，在spring项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），
            // 一般这个注解在类中，通常方法需要配合注解   //对htm页面的控制或者开发
public class registerController {
    @Autowired      //自动导入依赖的bean 自动导入依赖的bean。byType方式。把配置好的Bean拿来用，完成属性、方法的组装，
                    // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
                 //接口实例化；将 usermapper的数据导入进来
    private UserMapper userMapper;

    @GetMapping("/register")             //指定路径  //做一种请求映射的，映射输入的地址，8081/register
    public String reg(){return "register";}

    @RequestMapping("/register")    //提供路由信息，负责URL到Controller中的具体函数的映射。//该注解和方法一起使用，
    public String register(HttpServletRequest request, Map<String,Object> map) {
             //httpservletrequest request接收前端发起的请求数据，页面到服务器
        //Map是一个接口，它的每个元素包含一个key对象和一个value对象（这两个对象的类型可以不一样）且在这两个对象之间存在一种映射的对应关系，
        // 所以从Map集合中访问元素时，只要指定了key就可以找到对应的value，因此key必须是唯一的不能重复，当key相同时，后面的value值会覆盖
        // 之前的value值;
        String username = request.getParameter( "username"); //一种取参数的方法。把jsp文件中的数据读取到出来。然后就可以封装利用起来。
        String password = request.getParameter( "password");////获取前端数据get set
//        System.out.println(username);
//        System.out.println(password);

        User user=new User();  //定义一个User类的数据类型
        user.setUsername(username);//设置该数据类型的username属性
        user.setPassword(password);//设置该数据类型的password属性

        User user1 = userMapper.getuser(username);  //接口映射
        if (user1!=null) {
            map.put("msg", "the user " +username+ " has been used, ple select another nameQ!");
            return "register";
        } else {
           userMapper.adduser(user);
           map.put("mag",user);     //map.put输出到前端
           return "login";
        }
    }
    @RequestMapping("/getuser")
    public  String getuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if (user != null) {
            map.put("msg1", "the user has been registered!");
            return "register";
        } else {
            map.put("msg1", "the user has not been used");
            return "register";

        }
    }

    @GetMapping("/login")             //指定路径
    public String log(){return "login";}

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);
//        System.out.println(loginuser);
//        map.put("msg2","the user  "+loginuser+" login");
        if (loginuser != null) {
            map.put("msg2","the   "+username+" login");
            return "main_tab";
        } else {
            map.put("msg2","the user is not a legal user");
            return "login";
        }

//        map.put("msg1","the   "+loginuser+" login");
//        return "login";
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
            map.put("msg4", "the user has been updated!");
            return "login";
        } else {
            map.put("msg4", "the user is not a legal user");
            return "login";
        }
    }






}
