package com.goebuy.params;

/**
 * Created by luodejin on 2018/9/29.
 */
public class UploadData {
    private int code;//状态码：200 成功，1500 失败
    private String message;//提示信息
    private String url;//图片、音频、视频等链接

    public UploadData() {
    }

    public UploadData(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
