package com.example.administrator.ttc.bean;

import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/22/022.
 */

public class BdTestBean implements Serializable {
    private String id;
    private String time;
    private String money;
    private String type;

    public BdTestBean(String id, String time, String money, String type) {
        this.id = id;
        this.time = time;
        this.money = money;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
