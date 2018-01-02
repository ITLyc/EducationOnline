package com.teach.android.educationonline.http.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.teach.android.educationonline.http.common.GsonUtil;
import com.teach.android.educationonline.http.mode.ApiResult;
import com.teach.android.educationonline.http.mode.ResponseCode;
import com.teach.android.educationonline.log.MyLog;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Http响应拦截
 * Created by zheng on 2017/11/3.
 */

public abstract class HttpResponseInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return process(chain);
    }

    private Response process(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            return response;
        }
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        if (charset == null) {
            return response;
        }
        String bodyString = buffer.clone().readString(charset);
        MyLog.i("<-- HTTP Interceptor:" + bodyString + " host:" + request.url().toString());
        boolean isText = isText(contentType);
        if (!isText) {
            return response;
        }

        if (!TextUtils.isEmpty(bodyString)) {
            ApiResult apiResult = GsonUtil.gson().fromJson(bodyString, ApiResult.class);
            if (apiResult != null) {
                switch (apiResult.getStatus()) {
                    case ResponseCode.ACCESS_TOKEN_EXPIRED: //参数不完整
                        return processAccessTokenExpired(chain, request);
                    case ResponseCode.REFRESH_TOKEN_EXPIRED://参数不合法
                        return processRefreshTokenExpired(chain, request);
                    case ResponseCode.OTHER_PHONE_LOGIN://密码错误
                        return processOtherPhoneLogin(chain, request);
                    case ResponseCode.SIGN_ERROR://登录成功
                        return processSignError(chain, request);
                    case ResponseCode.TIMESTAMP_ERROR://尚未登录
                        return processTimestampError(chain, request);
                    case ResponseCode.NO_ACCESS_TOKEN://登录失败
                        return processNoAccessToken(chain, request);
                    case ResponseCode.USER_NOT_EXIST://用户不存在
                        return processNoAccessToken(chain, request);
                    case ResponseCode.USER_EXIST://用户已存在
                        return processNoAccessToken(chain, request);
                    default:
                        break;
                }
            }
        }
        return response;
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        return mediaType.subtype() != null && mediaType.subtype().equals("json");
    }

    /**
     * AccessToken错误或已过期
     * @param chain
     * @param request
     * @return
     */
    abstract Response processAccessTokenExpired(Chain chain, Request request);

    /**
     * RefreshToken错误或已过期
     * @param chain
     * @param request
     * @return
     */
    abstract Response processRefreshTokenExpired(Chain chain, Request request);

    /**
     * 帐号在其它手机已登录
     * @param chain
     * @param request
     * @return
     */
    abstract Response processOtherPhoneLogin(Chain chain, Request request);

    /**
     * 签名错误
     * @param chain
     * @param request
     * @return
     */
    abstract Response processSignError(Chain chain, Request request);

    /**
     * timestamp过期
     * @param chain
     * @param request
     * @return
     */
    abstract Response processTimestampError(Chain chain, Request request);

    /**
     * 缺少授权信息
     * @param chain
     * @param request
     * @return
     */
    abstract Response processNoAccessToken(Chain chain, Request request);

}

