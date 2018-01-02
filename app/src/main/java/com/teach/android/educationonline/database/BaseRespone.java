package com.teach.android.educationonline.database;

/**
 * File description.
 *
 * @author 作者:lyc
 * @date 2017/12/14 0014
 */


public class BaseRespone {
    public int status;
    public String msg;

    public int getStatus() {
        return status;
    }

    public boolean isSucess() {
        return 1 == status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
