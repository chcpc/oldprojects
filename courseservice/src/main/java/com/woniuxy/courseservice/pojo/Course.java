package com.woniuxy.courseservice.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer cid;
    private String cname;
    private String coach;
    private Float price;
    private String type;
    private Integer stock;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Course(Integer cid, String cname, String coach, Float price, String type, Integer stock) {
        this.cid = cid;
        this.cname = cname;
        this.coach = coach;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", coach='" + coach + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                '}';
    }
}
