package com.zjut.azhen.ncov.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author alex
 */
public class Region implements Serializable {


    private int id;
    private String name;
    private int  confirmed;


    @JSONField(name="value")
    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    @JSONField(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
