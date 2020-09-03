package com.example.webtest.controller;

import com.example.webtest.controller.model.Datas;
import com.example.webtest.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class datamanagerController {


    @Autowired
    private DataMapper dataMapper;


    @RequestMapping("/Getdata")
    public String Getdata(HttpServletRequest request, Map<String,Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter("head");
        Datas datas1 = dataMapper.getdata0(title,head);
        String datas = dataMapper.getdata(title,head);
//        System.out.println(datas1 + "11");
        if (datas1 != null) {
            map.put("msg10", "the head has been existed!");
            map.put("msg11", "the "+title+"'s"+ head +"'s contents are "+ datas );
            return "main_tab";
        } else {
            map.put("msg10", "the head has not been added");
            return "main_tab";

        }
    }

    @RequestMapping("/Getdata1")
    public String Getdata1(HttpServletRequest request, Map<String,Object> map) {
        String data = request.getParameter("data");
        String title1 = dataMapper.gettitle1(data);
        String head1 = dataMapper.gethead1(data);

        if (title1 != null) {
            map.put("msg12", "the head has been existed!");
            map.put("msg13", "the "+title1+"'s"+ head1 +"'s contents are "+ data );
            return "main_tab";
        } else {
            map.put("msg12", "the head has not been added");
            return "main_tab";

        }
    }


    @RequestMapping("/Adddata")
    public String Adddata(HttpServletRequest request, Map<String,Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter( "head"); //一种取参数的方法。把jsp文件中的数据读取到出来。然后就可以封装利用起来。
        String data = request.getParameter( "data");
//        System.out.println(head);
//        System.out.println(data);

        Datas datas=new Datas();
        datas.setTitle(title);
        datas.setHead(head);
        datas.setData(data);

        Datas datas1 = dataMapper.getdata0(title,head);
        if (datas1 != null) {
            map.put("msg7", "the head has been used,pls Updatedata it or try other head name");
            return "main_tab";
        } else {
            dataMapper.adddata(datas);
            map.put("msg7", "the head added successfully");
            return "main_tab";
        }
    }
    @RequestMapping("/Detedata")
    public String Detedata(HttpServletRequest request, Map<String,Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter("head");
        Datas getdatas = dataMapper.getdata0(title,head);
        if (getdatas != null) {
            dataMapper.deletedata(title,head);
            map.put("msg8", "the head has been deleted!");
            return "main_tab";
        } else {
            map.put("msg8", "the head is not a legal head");
            return "main_tab";
        }
    }
    @RequestMapping("/Updatedata")
    public String Updatedata(HttpServletRequest request, Map<String,Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter("head");
//        String data = request.getParameter("data");
        String newdata = request.getParameter("newdata");
        Datas getdata = dataMapper.getdata0(title,head);
        if (getdata != null) {
            dataMapper.updatedata(title,head,newdata);
            map.put("msg9", "the head has been updated!");
            return "main_tab";
        } else {
            map.put("msg9", "the head is not a legal head");
            return "main_tab";
        }
    }



}
