package com.kotarou.devicemanage.common;


import androidx.annotation.Nullable;

public class HttpException extends Exception {

    private Integer code;
    private String message;

    public HttpException() {

    }

    public HttpException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
