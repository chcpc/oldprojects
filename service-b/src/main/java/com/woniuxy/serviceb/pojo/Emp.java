package com.woniuxy.serviceb.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/9
 */
public class Emp implements Serializable {

    private Integer empno;
    private String ename;
    private Date hiredate;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
