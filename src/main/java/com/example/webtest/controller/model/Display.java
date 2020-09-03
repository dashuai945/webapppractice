//package com.example.webtest.controller.model;
//
//
//import com.example.webtest.mapper.DataMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Display {
//
//    private String dataclass  = null;
//    private String headvalue  = null;
//    private String datavalue  = null;
//    private String titlevalue = null;
//
//
//
//    @Autowired
//    private DataMapper dataMapper;
//
//    List<String> alltitle = dataMapper.getall();
//    int size =  alltitle.size();
//    String[] Display_Data = new String[size];
//    String[] Display_Head = new String[size];
//    String[] Display_Title = new String[size];
//    int idvalue = 1;
//    int tmp = 1;
//    Map<String, Datas> allMembers = new HashMap<String, Datas>();
//
//    public String[] Display_Data(String dataclass) {
//
//        for (int x = 1;x <= size; x = x +1) {
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
//            if (titlevalue.equals(dataclass)) {
//                Display_Data[tmp] = datavalue;
//                Display_Head[tmp] = headvalue;
//                Display_Title[tmp] = titlevalue;
////                System.out.println(titlevalue);
//                idvalue++;
//                tmp++;
//
//            } else {
//                idvalue++;
//                continue;
//            }
//
//        }
//      return Display_Data;
//    }
//
//    public String[] Display_Head(String dataclass) {
//
//        for (int x = 1;x <= size; x = x +1) {
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
//            if (titlevalue.equals(dataclass)) {
//                Display_Data[tmp] = datavalue;
//                Display_Head[tmp] = headvalue;
//                Display_Title[tmp] = titlevalue;
////                System.out.println(titlevalue);
//                idvalue++;
//                tmp++;
//
//            } else {
//                idvalue++;
//                continue;
//            }
//
//        }
//        return Display_Head;
//    }
//
//    public String[] Display_Title(String dataclass) {
//
//        for (int x = 1;x <= size; x = x +1) {
//            headvalue = dataMapper.gethead(idvalue);
//            datavalue = dataMapper.getdatas(idvalue);
//            titlevalue = dataMapper.gettitle(idvalue);
//            if (titlevalue.equals(dataclass)) {
//                Display_Data[tmp] = datavalue;
//                Display_Head[tmp] = headvalue;
//                Display_Title[tmp] = titlevalue;
////                System.out.println(titlevalue);
//                idvalue++;
//                tmp++;
//
//            } else {
//                idvalue++;
//                continue;
//            }
//
//        }
//        return Display_Title;
//    }
//
//}
