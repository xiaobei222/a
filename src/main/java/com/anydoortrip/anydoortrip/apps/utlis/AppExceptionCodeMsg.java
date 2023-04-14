package com.anydoortrip.anydoortrip.apps.utlis;

//这个枚举类中定义的都是跟业务有关的异常
public enum AppExceptionCodeMsg {
    USER_CREDIT_NOT(1, "Authentication failed"),
    //    认证失败
    USER_CREDIT_NOT_NULL(2, "frequent requests"),
    //    请求频繁"
    USERNAME_NOT_EXISTS(3, "request expired"),
    //    诗求过期
    USER_CREDIT_NOT_ENOUTH(4, "resource exists"),
    //   资源存在
    COUNTRY_CREDIT_NOT_ENOUTH(5, "resource does not exist"),
    //    参数错误
    USER_CREDIT_NOT_JIE(6, "Parameter error"),
    //   权限不足
    USER_CREDIT_NOT_JING(7, "Insufficient permissions"),
    //  没有此数据
    USER_CREDIT_NOT_LU(8, "Insufficient permissions");


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    AppExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}