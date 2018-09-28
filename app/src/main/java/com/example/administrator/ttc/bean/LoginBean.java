package com.example.administrator.ttc.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class LoginBean implements Serializable {

    /**
     * state : {"code":"20000","msg":"success"}
     * data : {"picUrl":"http://123.207.158.196:8099/pictures/6fd31824.png","id":"763615","token":"eyJhbGciOiJIUzI1NiIsImtpZCI6InBjIn0.eyJpc3MiOiJMaVl1SmlhWnUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1MzYwNDI1NzAsImV4cCI6MTUzNzI1MjE3MCwiaW5mbyI6eyJ1c2VySWQiOjQ1fX0.klX4EJuGrYgsyoypne_JgEWcjUchhU75FP5_o3iWnIk","blockId":null,"blockAddress":null,"identityCard":null,"account":null,"status":null}
     * count : null
     */

    private StateBean state;
    private DataBean data;
    private Object count;

    public StateBean getState() {
        return state;
    }

    public void setState(StateBean state) {
        this.state = state;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public static class StateBean implements Serializable{
        /**
         * code : 20000
         * msg : success
         */

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class DataBean implements Serializable{
        /**
         * picUrl : http://123.207.158.196:8099/pictures/6fd31824.png
         * id : 763615
         * token : eyJhbGciOiJIUzI1NiIsImtpZCI6InBjIn0.eyJpc3MiOiJMaVl1SmlhWnUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1MzYwNDI1NzAsImV4cCI6MTUzNzI1MjE3MCwiaW5mbyI6eyJ1c2VySWQiOjQ1fX0.klX4EJuGrYgsyoypne_JgEWcjUchhU75FP5_o3iWnIk
         * blockId : null
         * blockAddress : null
         * identityCard : null
         * account : null
         * status : null
         */

        private String picUrl;
        private String id;
        private String token;
        private Object blockId;
        private Object blockAddress;
        private Object identityCard;
        private Object account;
        private Object status;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getBlockId() {
            return blockId;
        }

        public void setBlockId(Object blockId) {
            this.blockId = blockId;
        }

        public Object getBlockAddress() {
            return blockAddress;
        }

        public void setBlockAddress(Object blockAddress) {
            this.blockAddress = blockAddress;
        }

        public Object getIdentityCard() {
            return identityCard;
        }

        public void setIdentityCard(Object identityCard) {
            this.identityCard = identityCard;
        }

        public Object getAccount() {
            return account;
        }

        public void setAccount(Object account) {
            this.account = account;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }
    }
}
