package com.example.administrator.ttc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class PropertyBean implements Serializable {

    /**
     * state : {"code":"20000","msg":"success"}
     * data : {"list":[{"appName":"1","money":"2000.32","account":null,"conversion":"90.01"}],"total":"2000.32","totalCny":"90.01"}
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

    public static class DataBean implements Serializable {
        /**
         * list : [{"appName":"1","money":"2000.32","account":null,"conversion":"90.01"}]
         * total : 2000.32
         * totalCny : 90.01
         */

        private String total;
        private String totalCny;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotalCny() {
            return totalCny;
        }

        public void setTotalCny(String totalCny) {
            this.totalCny = totalCny;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * appName : 1
             * money : 2000.32
             * account : null
             * conversion : 90.01
             */

            private String appName;
            private String money;
            private Object account;
            private String conversion;

            public String getAppName() {
                return appName;
            }

            public void setAppName(String appName) {
                this.appName = appName;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public Object getAccount() {
                return account;
            }

            public void setAccount(Object account) {
                this.account = account;
            }

            public String getConversion() {
                return conversion;
            }

            public void setConversion(String conversion) {
                this.conversion = conversion;
            }
        }
    }
}
