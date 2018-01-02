package com.teach.android.educationonline.http.mode;

/**
 * Response响应码（根据服务器提供文档进行定义）
 * Created by zheng on 2017/11/3.
 */

public class ResponseCode {
    //HTTP请求成功状态码
    public static final int HTTP_SUCCESS = 1;
    //HTTP请求失败状态码
    public static final int REQUEST_FAILURE=0;
    //参数不完整
    public static final int ACCESS_TOKEN_EXPIRED = 1001;
    //参数不合法
    public static final int REFRESH_TOKEN_EXPIRED = 1002;
    //密码错误
    public static final int OTHER_PHONE_LOGIN = 1003;
    //尚未登录
    public static final int TIMESTAMP_ERROR = 1004;
    //    登录失败
    public static final int NO_ACCESS_TOKEN = 1005;
    //登录成功
    public static final int SIGN_ERROR = 1006;
    //用户不存在
    public static final int USER_NOT_EXIST=1007;
    //用户已存在
    public static final int USER_EXIST=1008;
}

