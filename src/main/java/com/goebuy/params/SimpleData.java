package com.goebuy.params;

/**
 * Created by luodejin on 2018/9/28.
 */
public class SimpleData {
    private int code;//状态码：200 成功，1500 失败
    private String message;//提示信息

    public SimpleData() {
    }

    public SimpleData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
