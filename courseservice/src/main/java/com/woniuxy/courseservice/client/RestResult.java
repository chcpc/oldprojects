package com.woniuxy.courseservice.client;

public class RestResult {
    private String code;
    private MemberDTO data;
    private String message;

    @Override
    public String toString() {
        return "RestResult{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MemberDTO getData() {
        return data;
    }

    public void setData(MemberDTO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestResult(String code, MemberDTO data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
