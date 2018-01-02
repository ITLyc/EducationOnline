package com.teach.android.educationonline.http.subscriber;

import com.teach.android.educationonline.http.callback.ACallback;

/**
 * 包含下载进度回调的订阅者
 * Created by zheng on 2017/11/3.
 */

public class DownCallbackSubscriber<T> extends ApiCallbackSubscriber<T> {
    public DownCallbackSubscriber(ACallback<T> callBack) {
        super(callBack);
    }

    @Override
    public void onComplete() {
        super.onComplete();
        callBack.onSuccess(super.data);
    }
}
