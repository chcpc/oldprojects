package com.woniuxy.servicea.client;

import java.io.Serializable;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/9
 */
public class RestResult implements Serializable {
    private String code;
    private String msg;
    private EmpDTO data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EmpDTO getData() {
        return data;
    }

    public void setData(EmpDTO data) {
        this.data = data;
    }
}
