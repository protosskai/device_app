package com.kotarou.devicemanage.entity;

import com.google.common.base.MoreObjects;

public class HttpResult<T> {
    private int status;
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("message", message)
                .add("data", data)
                .toString();
    }
}
