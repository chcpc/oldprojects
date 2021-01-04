package com.example.demo.pojo;

import java.util.Date;

public class Standard {
    private Integer id;

    private String stdnum;

    private String zhname;

    private String version;

    private String stdkeys;

    private Date releasedate;

    private Date impldate;

    private String packagepath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdnum() {
        return stdnum;
    }

    public void setStdnum(String stdnum) {
        this.stdnum = stdnum;
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStdkeys() {
        return stdkeys;
    }

    public void setStdkeys(String stdkeys) {
        this.stdkeys = stdkeys;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getImpldate() {
        return impldate;
    }

    public void setImpldate(Date impldate) {
        this.impldate = impldate;
    }

    public String getPackagepath() {
        return packagepath;
    }

    public void setPackagepath(String packagepath) {
        this.packagepath = packagepath;
    }
}