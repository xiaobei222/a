package com.anydoortrip.anydoortrip.apps.utlis;

import lombok.Data;

@Data

public class resp<T> {
    private int code = 200;
    private String msg = "success";
    private T data;

    public resp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T>resp success(T data){
        new resp(200,"success")
    }
}
