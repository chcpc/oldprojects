package com.woniuxy.courseservice.client;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/10
 */
public class MemberDTO implements Serializable {
    private Integer id;
    private String name;
    private String idCard;
    private String mobile;
    private Date regdate;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
