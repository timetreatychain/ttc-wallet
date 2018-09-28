package com.example.administrator.ttc.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class FindPwdBean implements Serializable {

    /**
     * state : {"code":"20000","msg":"success"}
     * data : 176****2157
     * count : null
     */

    private StateBean state;
    private String data;
    private Object count;

    public StateBean getState() {
        return state;
    }

    public void setState(StateBean state) {
        this.state = state;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public static class StateBean implements Serializable {
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
}
