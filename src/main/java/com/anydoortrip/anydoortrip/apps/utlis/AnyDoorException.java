package com.anydoortrip.anydoortrip.apps.utlis;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;

@RestControllerAdvice
public class AnyDoorException {

    @ExceptionHandler(Exception.class)

    public <T> Resp<T> exceptionHandler(Exception e) {
        System.out.println(e);
        //这里先判断拦截到的Exception是不是我们自定义的异常类型
        if (e instanceof AppException) {
            AppException appException = (AppException) e;
            return Resp.error(appException.getCode(), appException.getMsg());
        }

        //如果拦截的异常不是我们自定义的异常(例如：数据库主键冲突)

        return Resp.error(100, "服务器端异常");
    }
}
