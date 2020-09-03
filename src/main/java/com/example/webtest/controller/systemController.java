package com.example.webtest.controller;

import com.example.webtest.controller.model.Datas;
import com.example.webtest.controller.model.User;
import com.example.webtest.mapper.DataMapper;
import com.example.webtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;//实用包（Utilities）,提供了各种不同实用功能的类
import java.util.List;
import java.util.Map;

@Controller
public class systemController {

    @Autowired      //自动导入依赖的bean 自动导入依赖的bean。byType方式。把配置好的Bean拿来用，完成属性、方法的组装，
    // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    //接口实例化；将 usermapper的数据导入进来
    private UserMapper userMapper;

    @Autowired
    private DataMapper dataMapper;

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
    public String Tree(Model model, HttpServletRequest request, Map<String,Object> map) {
        String headvalue  = null;
        String datavalue  = null;
        String titlevalue = null;
        List<String> alltitle = dataMapper.getalltitle(); //List是一个接口，是Collection接口的一个子接口，是一个有序的集合。
        // 数组的容量是固定的，您只能一次获取或设置一个元素的值，而List<T>的容量可根据需要自动扩充、修改、删除或插入数据。
        List<String> allhead = dataMapper.getallhead();
        List<String> alldata = dataMapper.getalldata();
        int size =  alltitle.size();
        String[] Display_Data = new String[size];
        String[] Display_Head = new String[size];
        String[] Display_Title = new String[size];
//        int idvalue = 1;
        int tmp = 1;
        Map<String, Datas> allMembers = new HashMap<String, Datas>();
        //是基于哈希表的Map接口实现。此实现提供所有可选的映射操作，并允许 空值和空键。这个类不保证地图的顺序; 特别是，
        // 它不保证该顺序会随着时间的推移保持不变。 HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。
        // 即HashMap 底层就是一个数组结构，数组中的每一项又是一个链表。当新建一个 HashMap 的时候，就会初始化一个数组。
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
            titlevalue = alltitle.get(x-1);//get (int index)返回指定位置的元素
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
        model.addAttribute("allDatas", allMembers);//往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到，
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
