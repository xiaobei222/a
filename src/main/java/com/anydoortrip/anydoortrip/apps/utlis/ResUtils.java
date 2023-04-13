package com.anydoortrip.anydoortrip.apps.utlis;

import lombok.Data;

import java.util.HashMap;

@Data
public class ResUtils<T> {


    // 响应码
    private Integer code;
    // 响应描述
    private String message;
    // 响应数据
    private T data;

    public ResUtils(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResUtils(Integer code) {
        this.code = code;
        this.message = "OK";
        this.data = null;
    }

    public ResUtils(T data) {
        this.code = 0;
        this.message = "OK";
        this.data = data;
    }

    public ResUtils() {
        this.code = 0;
        this.message = "OK";
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

}

