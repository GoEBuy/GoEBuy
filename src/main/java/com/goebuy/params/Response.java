package com.goebuy.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luodejin on 2018/9/28.
 */
@ApiModel
public class Response<T> {

    @ApiModelProperty(value = "状态码", example = "200", position = 1)
    private int code;

    @ApiModelProperty(value = "提示信息", example = "success", position = 2)
    private String message;

    @ApiModelProperty(value = "响应结果", example = "null", position = 3)
    private T data;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 成功
    public static final Response SUCCESS = new Response(200, "success", null);

    // 参数不对
    public static final Response BAD_PARAMETER = new Response(401, "bad parameter", null);
    // 参数值不对
    public static final Response BAD_PARAMETER_VALUE = new Response(402, "bad parameter value", null);
    // 未登录
    public static final Response UN_LOGIN = new Response(501, "please login", null);
    // 系统内部错误
    public static final Response SYSTEM_INTERNAL_ERROR = new Response(502, "system internal error", null);
    // 业务不支持
    public static final Response UN_SPPORT = new Response(503, "unsupport", null);
    // 超出访问次数限制
    public static final Response OVER_MAX_ACCESS_LIMIT = new Response(503, "over max access limit", null);
}
