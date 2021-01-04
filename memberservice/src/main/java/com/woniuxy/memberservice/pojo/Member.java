package com.woniuxy.memberservice.pojo;

import java.util.Date;

public class Member {
    private Integer id;
    private String name;
    private String mobile;
    private String idCard;
    private Date regdate;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                ", regdate=" + regdate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Member(Integer id, String name, String mobile, String idCard, Date regdate) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.idCard = idCard;
        this.regdate = regdate;
    }
}
