package com.zjut.azhen.ncov.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class Region {


    private int id;
    private String name;
    private int  confirmed;


    private boolean selected=false;


    @JSONField(name="selected")
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

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
