package com.example.demo.entity;

import java.util.List;

public class MyEntity {

    /**
     * mailNo : 9862120028917
     * expSpellName : pingyou
     * ord : ASC
     * data : [{"context":"在沧州市公司分部 进行揽件扫描","time":"2020-08-21 07:32"},{"context":"在沧州市进行下级地点扫描，将发往：广州市","time":"2020-08-21 09:40"},{"context":"已发往广州市分拔中心","time":"2020-08-21 14:52"},{"context":"已发往广州市分拔中心","time":"2020-08-22 07:40"},{"context":"已到达广州市公司，上一站是沧州市中心","time":"2020-08-22 21:10"},{"context":"已到达广州市公司，上一站是沧州市中心","time":"2020-08-23 10:42"},{"context":"已发往广州市分拔中心","time":"2020-08-23 22:24"},{"context":"在沧州市进行下级地点扫描，将发往：广州市","time":"2020-08-24 06:54"},{"context":"在沧州市进行下级地点扫描，将发往：广州市","time":"2020-08-24 09:18"},{"context":"在大同市进行派件扫描","time":"2020-08-24 10:30"},{"context":"快递签收扫描，签收人是：，签收网点是大同市分公司","time":"2020-08-25 00:23"}]
     * errCode : 0
     * expTextName : 中国邮政
     * html :
     * tel : 11185
     * message :
     * status : 3
     */
    private String mailNo;
    private String expSpellName;
    private String ord;
    private List<DataEntity> data;
    private int errCode;
    private String expTextName;
    private String html;
    private String tel;
    private String message;
    private int status;

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public void setExpSpellName(String expSpellName) {
        this.expSpellName = expSpellName;
    }

    public void setOrd(String ord) {
        this.ord = ord;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public void setExpTextName(String expTextName) {
        this.expTextName = expTextName;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMailNo() {
        return mailNo;
    }

    public String getExpSpellName() {
        return expSpellName;
    }

    public String getOrd() {
        return ord;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getExpTextName() {
        return expTextName;
    }

    public String getHtml() {
        return html;
    }

    public String getTel() {
        return tel;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public class DataEntity {
        /**
         * context : 在沧州市公司分部 进行揽件扫描
         * time : 2020-08-21 07:32
         */
        private String context;
        private String time;

        public void setContext(String context) {
            this.context = context;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContext() {
            return context;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "context='" + context + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "mailNo='" + mailNo + '\'' +
                ", expSpellName='" + expSpellName + '\'' +
                ", ord='" + ord + '\'' +
                ", data=" + data +
                ", errCode=" + errCode +
                ", expTextName='" + expTextName + '\'' +
                ", html='" + html + '\'' +
                ", tel='" + tel + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
