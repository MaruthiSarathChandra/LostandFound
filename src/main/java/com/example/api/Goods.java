package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Goods {

    private int id;
    private String name;
    private int barcod;
    @Autowired
    private Orders order;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBarcod() {
        return barcod;
    }

    public void setBarcod(int barcod) {
        this.barcod = barcod;
    }

    public void show() { System.out.println("to the spring boot....."); order.show();}

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
