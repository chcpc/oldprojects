package com.woniuxy.jqgriddemo.po;

import java.util.List;

/**
 * 模型类
 */
public class JqGridResquest {
    /**ID*/
    private Integer id;
    /**行数*/
    private Integer rows;
    /**页数*/
    private Integer page;
    /**排序字段升序降序说法*/
    private String sord;
    /**排序名称*/
    private String sidx;
    /**查询值*/

    private List<String> whereValue;
    /**查询字段名称*/
    private String whereName;
    /**状态*/
    private String status;
    //其他
    private String other;

    //-------------------------分割线-------------------------------------------


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public List<String> getWhereValue() {
        return whereValue;
    }

    public void setWhereValue(List<String> whereValue) {
        this.whereValue = whereValue;
    }

    public String getWhereName() {
        return whereName;
    }

    public void setWhereName(String whereName) {
        this.whereName = whereName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "JqGridResquest{" +
                "id=" + id +
                ", rows=" + rows +
                ", page=" + page +
                ", sord='" + sord + '\'' +
                ", sidx='" + sidx + '\'' +
                ", whereValue=" + whereValue +
                ", whereName='" + whereName + '\'' +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public JqGridResquest(Integer id, Integer rows, Integer page, String sord, String sidx, List<String> whereValue, String whereName, String status, String other) {
        this.id = id;
        this.rows = rows;
        this.page = page;
        this.sord = sord;
        this.sidx = sidx;
        this.whereValue = whereValue;
        this.whereName = whereName;
        this.status = status;
        this.other = other;
    }
}
