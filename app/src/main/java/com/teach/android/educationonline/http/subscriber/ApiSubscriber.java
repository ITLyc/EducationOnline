package com.teach.android.educationonline.http.subscriber;

import com.teach.android.educationonline.http.exception.ApiException;
import com.teach.android.educationonline.http.mode.ApiCode;

import io.reactivex.observers.DisposableObserver;

/**
 * API统一订阅者
 * Created by zheng on 2017/11/3.
 */

abstract class ApiSubscriber<T> extends DisposableObserver<T> {

    ApiSubscriber() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, ApiCode.Request.UNKNOWN));
        }
    }

    protected abstract void onError(ApiException e);
}
