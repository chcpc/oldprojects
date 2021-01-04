package com.woniuxy.redisproject.pojo;

import java.io.Serializable;

public class ProductParam implements Serializable {
    private Integer id;

    private String productParamName;

    private String productParamValue;

    private Integer productId;

    private Integer sort;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductParamName() {
        return productParamName;
    }

    public void setProductParamName(String productParamName) {
        this.productParamName = productParamName;
    }

    public String getProductParamValue() {
        return productParamValue;
    }

    public void setProductParamValue(String productParamValue) {
        this.productParamValue = productParamValue;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductParam{" +
                "id=" + id +
                ", productParamName='" + productParamName + '\'' +
                ", productParamValue='" + productParamValue + '\'' +
                ", productId=" + productId +
                ", sort=" + sort +
                ", type='" + type + '\'' +
                '}';
    }
}