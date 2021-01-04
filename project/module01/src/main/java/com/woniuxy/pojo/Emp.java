package com.woniuxy.pojo;

import java.util.Date;
import java.util.List;

public class Emp {
    private String ename;
    private String job;
    private Date hiredate;

    public Emp(String ename, String job, Date hiredate) {
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }

    public Emp(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }
}
