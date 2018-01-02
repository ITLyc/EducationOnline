package com.teach.android.educationonline.http.request;

import com.teach.android.educationonline.http.func.ApiDataFunc;
import com.teach.android.educationonline.http.func.ApiRetryFunc;
import com.teach.android.educationonline.http.mode.ApiResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 返回APIResult的基础请求类
 * Created by zheng on 2017/11/3.
 */

public abstract class ApiBaseRequest extends BaseHttpRequest<ApiBaseRequest> {
    public ApiBaseRequest(String suffixUrl) {
        super(suffixUrl);
    }

    protected <T> ObservableTransformer<ApiResult<T>, T> apiTransformer() {
        return new ObservableTransformer<ApiResult<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<ApiResult<T>> apiResultObservable) {
                return apiResultObservable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new ApiDataFunc<T>())
                        .retryWhen(new ApiRetryFunc(retryCount, retryDelayMillis));
            }
        };
    }
}
