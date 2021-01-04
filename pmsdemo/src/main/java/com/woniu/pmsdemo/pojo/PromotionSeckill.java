package com.woniu.pmsdemo.pojo;

import java.io.Serializable;
import java.util.Date;

public class PromotionSeckill implements Serializable {
    private Long id;

    private Integer productId;

    private Integer psCount;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Float currentPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPsCount() {
        return psCount;
    }

    public void setPsCount(Integer psCount) {
        this.psCount = psCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }
}