package com.example.webtest.controller.model;

import lombok.Data;

@Data
public class Datas {
    private String head;
    private String data;
    private Integer id;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
         this.id = id;
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
