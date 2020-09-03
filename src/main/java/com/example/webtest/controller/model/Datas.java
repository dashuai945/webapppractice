package com.example.webtest.controller.model;  //指定存放路径

import lombok.Data;   //导入依赖

@Data   //加了@Data注解，所有Java代码中不需要生成getters and setters，而在编译的时候会自动生成getters and setters
public class Datas {
    private String head;  //private作为一种权限修饰符可以修饰类、属性和方法；用private修饰的类、属性、方法，只能自己使用，
                          // 别的类是不能访问的，也就是说对于别的类来说是隐藏不可见的，private一般不修饰类，但是可以修饰内部类。
    private String data;
    private String title;
    private Integer id;


    public Integer getId() {  //Java 中，可以将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类。
        return this.id;         //public 成员内部类是最普通的内部类，它的定义为位于另一个类的内部
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return this.head;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return this.data;
    }









}
