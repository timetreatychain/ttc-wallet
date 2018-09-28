package com.example.administrator.ttc.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class FindIdOneBean implements Serializable {

    /**
     * state : {"code":"20000","msg":"success"}
     * data : {"blockId":"763615","blockAddress":null,"totalPrice":null,"account":null,"token":"eyJhbGciOiJIUzI1NiIsImtpZCI6InBjIn0.eyJpc3MiOiJMaVl1SmlhWnUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1MzYwNDU5ODksImV4cCI6MTUzNzI1NTU4OSwiaW5mbyI6eyJ1c2VySWQiOjQ1fX0.6A0d7oX0q7gyURNkDzmbCQfpkHnXXlHhviCBDNtFheY","picUrl":null,"status":null}
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
         * blockId : 763615
         * blockAddress : null
         * totalPrice : null
         * account : null
         * token : eyJhbGciOiJIUzI1NiIsImtpZCI6InBjIn0.eyJpc3MiOiJMaVl1SmlhWnUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1MzYwNDU5ODksImV4cCI6MTUzNzI1NTU4OSwiaW5mbyI6eyJ1c2VySWQiOjQ1fX0.6A0d7oX0q7gyURNkDzmbCQfpkHnXXlHhviCBDNtFheY
         * picUrl : null
         * status : null
         */

        private String blockId;
        private Object blockAddress;
        private Object totalPrice;
        private Object account;
        private String token;
        private Object picUrl;
        private Object status;

        public String getBlockId() {
            return blockId;
        }

        public void setBlockId(String blockId) {
            this.blockId = blockId;
        }

        public Object getBlockAddress() {
            return blockAddress;
        }

        public void setBlockAddress(Object blockAddress) {
            this.blockAddress = blockAddress;
        }

        public Object getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Object totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Object getAccount() {
            return account;
        }

        public void setAccount(Object account) {
            this.account = account;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(Object picUrl) {
            this.picUrl = picUrl;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }
    }
}
