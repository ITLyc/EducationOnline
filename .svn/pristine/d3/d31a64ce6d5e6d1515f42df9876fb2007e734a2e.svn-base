package com.teach.android.educationonline.http.mode;

/**
 * 封装的通用服务器返回对象，可自行定义
 * Created by zheng on 2017/11/3.
 */

public class ApiResult<T> {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public ApiResult setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ApiResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResult setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

