package com.woniuxy.springbootredis.pojo;

import java.util.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private Date hiredate;

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Emp(Integer empno, String ename, Date hiredate) {
        this.empno = empno;
        this.ename = ename;
        this.hiredate = hiredate;
    }

    public Emp() {
    }
}
