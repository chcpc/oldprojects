package com.woniuxy.springbootrabbitmqproducer.pojo;

import java.io.Serializable;
import java.util.Date;

public class Msg implements Serializable {
    private Integer id;
    private String title;
    private Date createTime;

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
