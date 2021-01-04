package com.woniuxy.jqgriddemo.po;

import java.util.Date;

public class Base {
    private Integer id;

    private String basic;

    private Integer status;

    private Date time;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", basic='" + basic + '\'' +
                ", status=" + status +
                ", time=" + time +
                ", flag=" + flag +
                '}';
    }

    public Base(Integer id, String basic, Integer status, Date time, Integer flag) {
        this.id = id;
        this.basic = basic;
        this.status = status;
        this.time = time;
        this.flag = flag;
    }
}