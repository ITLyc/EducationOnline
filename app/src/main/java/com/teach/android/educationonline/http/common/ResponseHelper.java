package com.teach.android.educationonline.http.common;

import com.teach.android.educationonline.http.mode.ApiResult;
import com.teach.android.educationonline.http.mode.ResponseCode;

/**
 * 响应处理帮助类
 * Created by zheng on 2017/11/3.
 */

public class ResponseHelper {

    public static boolean isSuccess(ApiResult apiResult) {
        if (apiResult == null) {
            return false;
        }
        return apiResult.getStatus() == ResponseCode.HTTP_SUCCESS || ignoreSomeIssue(apiResult.getStatus());
    }

    private static boolean ignoreSomeIssue(int code) {
        switch (code) {
            case ResponseCode.TIMESTAMP_ERROR://尚未登录
            case ResponseCode.ACCESS_TOKEN_EXPIRED://参数不完整
            case ResponseCode.REFRESH_TOKEN_EXPIRED://参数不合法
            case ResponseCode.OTHER_PHONE_LOGIN://密码错误
            case ResponseCode.NO_ACCESS_TOKEN://登录失败
            case ResponseCode.SIGN_ERROR://登录成功
            case ResponseCode.USER_NOT_EXIST://用户不存在
            case ResponseCode.USER_EXIST://用户已存在
            case ResponseCode.REQUEST_FAILURE://HTTP请求失败状态码
                return true;
            default:
                return false;
        }
    }
}

