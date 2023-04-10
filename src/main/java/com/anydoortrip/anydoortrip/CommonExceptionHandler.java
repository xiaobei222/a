package com.anydoortrip.anydoortrip;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return new Result(msg, 400);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return new Result(ex.getMessage().split(": ")[1], 400);
    }
}

class Result {

    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Result(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}
