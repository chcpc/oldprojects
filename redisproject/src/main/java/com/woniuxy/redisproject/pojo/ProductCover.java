package com.woniuxy.redisproject.pojo;

import java.io.Serializable;

public class ProductCover implements Serializable {
    private Integer id;

    private Integer productId;

    private String picUrl;

    private String thumbUrl;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ProductCover{" +
                "id=" + id +
                ", productId=" + productId +
                ", picUrl='" + picUrl + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}