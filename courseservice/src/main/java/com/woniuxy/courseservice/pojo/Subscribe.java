package com.woniuxy.courseservice.pojo;

import java.util.Date;

public class Subscribe {
    private Integer sid;
    private Integer cid;
    private Integer mid;
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "Subscribe{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", mid=" + mid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public Subscribe() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Subscribe(Integer sid, Integer cid, Integer mid, Date startTime, Date endTime) {
        this.sid = sid;
        this.cid = cid;
        this.mid = mid;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
