package com.anydoortrip.anydoortrip.apps.utlis;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Exception extends Throwable {

    @ExceptionHandler(AnyDoorException.class)
    @ResponseBody
    public ResUtils error (ArithmeticException e){
        e.printStackTrace();
        return ResUtils
    }
}
