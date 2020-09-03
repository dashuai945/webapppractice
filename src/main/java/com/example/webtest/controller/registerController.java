package com.example.webtest.controller;

import com.example.webtest.controller.model.User;
import com.example.webtest.controller.model.Datas;

import com.example.webtest.mapper.DataMapper;
import com.example.webtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class registerController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataMapper dataMapper;


    @GetMapping("/register")             //指定路径
    public String reg(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(HttpServletRequest request, Map<String,Object> map) {

        String username = request.getParameter( "username"); //一种取参数的方法。把jsp文件中的数据读取到出来。然后就可以封装利用起来。
        String password = request.getParameter( "password");
        System.out.println(username);
        System.out.println(password);

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = userMapper.getuser(username);
        if (user1!=null) {
            map.put("msg", "the user has been used,pls register again");
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
            map.put("msg1", "the user has been registered!");
            return "register";
        } else {
            map.put("msg1", "the user has not been used");
            return "register";

        }
    }

    @GetMapping("/login")             //指定路径
    public String log(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
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


    @RequestMapping("/main_tab")
    public String main_tab(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user1 = userMapper.login(username, password);
        System.out.println(user1);
        if (user1 != null) {
            map.put("msg2","the   "+username+" login");
            return "main_tab";
        }else {
            return "main_tab";
        }

    }


    @RequestMapping("/Tree")
    public String Tree(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
//        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("树")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
//                idvalue++;
                tmp++;

            } else {
//                idvalue++;
                continue;
            }

        }

//        while (datas0 != null) {
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
//
////        System.out.println(titlevalue);
//            if (titlevalue.equals("表")){
//                Display_Data[tmp] = datavalue;
//                Display_Head[tmp] = headvalue;
//                Display_Title[tmp] = titlevalue;
////                System.out.println(titlevalue);
////                map.put("msg22", headvalue + "1");
////                map.put("msg23", datavalue + "2");
////                System.out.println(idvalue);
////                System.out.println(headvalue);
////                System.out.println(datavalue);
////                System.out.println(datas0);
////              System.out.println(size);
////            System.out.println(Display_Head[idvalue]);
////            System.out.println(Display_Data[idvalue]);
//
////            map.put("msg22", Display_Head[idvalue]);
////            map.put("msg23", Display_Data[idvalue]);
////            map.put("msg23", headvalue +  datavalue);
//                idvalue++;
//                size++;
//                tmp++;
//                datas0 = dataMapper.getid(idvalue);
//
//            }
//            else {
//                idvalue++;
//                datas0 = dataMapper.getid(idvalue);
//                continue;
//            }
//
//        }
        for (int x = 1;x < tmp; x = x +1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
//        map.put("msg[x]", Display_Head[x]);
//        map.put("mag[x]", Display_Data[x]);
            allMembers.put("index-" + x, vo);
//        System.out.println(x);
//        System.out.println(allMembers.put("index-" + x, vo));

        }
        map.put("msg_tree",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//    System.out.println(model.addAttribute("allDatas",allMembers));
        return "main_tab";
    }


    @RequestMapping("/Map")
    public String Map(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("图")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_map",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }



        @RequestMapping("/Linear_table")
    public String Linear_table(Model model,HttpServletRequest request, Map<String,Object> map) {
            String headvalue  = null;
            String datavalue  = null;
            String titlevalue = null;
            List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
            int size =  alltitle.size();
            String[] Display_Data = new String[size];
            String[] Display_Head = new String[size];
            String[] Display_Title = new String[size];
            int idvalue = 1;
            int tmp = 1;
            Map<String, Datas> allMembers = new HashMap<String, Datas>();
            for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
                if (titlevalue.equals("线性表")) {
                    Display_Data[tmp] = datavalue;
                    Display_Head[tmp] = headvalue;
                    Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                    idvalue++;
                    tmp++;

                } else {
                    idvalue++;
                    continue;
                }

            }
            for (int x = 1; x < tmp; x = x + 1) {
                Datas vo = new Datas();
                vo.setId(x);
                vo.setTitle(Display_Title[x]);
                vo.setHead(Display_Head[x]);
                vo.setData(Display_Data[x]);
                allMembers.put("index-" + x, vo);
            }
            map.put("msg_Linear_table",Display_Title[tmp-1]);
            model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
            return "main_tab";
    }
    @RequestMapping("/Array")
    public String Array(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("数组")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_Array",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }
    @RequestMapping("/Linked_list")
    public String Linked_list(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("链表")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_Linked_list",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }
    @RequestMapping("/Queue")
    public String Queue(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("队列")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_Queue",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }
    @RequestMapping("/Stack")
    public String Stack(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("栈")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_Stack",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }
    @RequestMapping("/Other")
    public String Other(Model model,HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle();
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x-1);
            headvalue = allhead.get(x-1);
            datavalue = alldata.get(x-1);
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
            if (titlevalue.equals("其他")) {
                Display_Data[tmp] = datavalue;
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
//                System.out.println(titlevalue);
                idvalue++;
                tmp++;

            } else {
                idvalue++;
                continue;
            }

        }
        for (int x = 1; x < tmp; x = x + 1) {
            Datas vo = new Datas();
            vo.setId(x);
            vo.setTitle(Display_Title[x]);
            vo.setHead(Display_Head[x]);
            vo.setData(Display_Data[x]);
            allMembers.put("index-" + x, vo);
        }
        map.put("msg_Other",Display_Title[tmp-1]);
        model.addAttribute("allDatas", allMembers);
//        System.out.println(model.addAttribute("title_main", title_main));
        return "main_tab";
    }



}
