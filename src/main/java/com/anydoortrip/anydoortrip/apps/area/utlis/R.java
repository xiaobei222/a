package com.anydoortrip.anydoortrip.apps.area.utlis;

import lombok.Data;

import java.util.List;

@Data
public class R<T> {
    private Boolean flag;
    private Object data;
    private String msg;



    public R(){}

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
}