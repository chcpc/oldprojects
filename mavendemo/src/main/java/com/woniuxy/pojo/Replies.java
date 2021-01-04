package com.woniuxy.pojo;

import java.util.Date;

public class Replies {
    private Integer id;

    private String content;

    private Date replytime;

    private Integer infold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public Integer getInfold() {
        return infold;
    }

    public void setInfold(Integer infold) {
        this.infold = infold;
    }

    @Override
    public String toString() {
        return "Replies{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", replytime=" + replytime +
                ", infold=" + infold +
                '}';
    }
}