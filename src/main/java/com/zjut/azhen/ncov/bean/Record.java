package com.zjut.azhen.ncov.bean;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {

    private String id;
    private Integer pid;
    private String dateId;
    private Integer confirmedCount;
    private Integer currentConfirmedCount;
    public Integer getCurrentCount() {
        return currentConfirmedCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentConfirmedCount = currentCount;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }


    public String getId() {
        return id;
    }

    public Integer getPid() {
        return pid;
    }

    public String getDateId() {
        return dateId;
    }

    public Integer getConfirmedCount() {
        return confirmedCount;
    }




}
