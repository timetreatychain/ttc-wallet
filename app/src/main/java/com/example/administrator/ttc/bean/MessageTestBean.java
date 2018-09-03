package com.example.administrator.ttc.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/23/023.
 */

public class MessageTestBean implements Serializable {
    String title;
    String time;
    String content;
    String id;
    String type;//0代表转入，1代表转出
    String islook;//0代表未查看，1代表已查看

    public MessageTestBean(String title, String time, String content, String id, String type, String islook) {
        this.title = title;
        this.time = time;
        this.content = content;
        this.id = id;
        this.type = type;
        this.islook = islook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIslook() {
        return islook;
    }

    public void setIslook(String islook) {
        this.islook = islook;
    }
}
