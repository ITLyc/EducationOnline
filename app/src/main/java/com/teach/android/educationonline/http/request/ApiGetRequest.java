package com.teach.android.educationonline.http.request;

import com.teach.android.educationonline.http.ViseHttp;
import com.teach.android.educationonline.http.callback.ACallback;
import com.teach.android.educationonline.http.core.ApiManager;
import com.teach.android.educationonline.http.func.ApiResultFunc;
import com.teach.android.educationonline.http.mode.CacheResult;
import com.teach.android.educationonline.http.subscriber.ApiCallbackSubscriber;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * 返回APIResult的GET请求类
 * Created by zheng on 2017/11/3.
 */

public class ApiGetRequest extends ApiBaseRequest {
    public ApiGetRequest(String suffixUrl) {
        super(suffixUrl);
    }

    @Override
    protected <T> Observable<T> execute(Type type) {
        return apiService.get(suffixUrl, params).map(new ApiResultFunc<T>(type)).compose(this.<T>apiTransformer());
    }

    @Override
    protected <T> Observable<CacheResult<T>> cacheExecute(Type type) {
        return this.<T>execute(type).compose(ViseHttp.getApiCache().<T>transformer(cacheMode, type));
    }

    @Override
    protected <T> void execute(ACallback<T> callback) {
        DisposableObserver disposableObserver = new ApiCallbackSubscriber(callback);
        if (super.tag != null) {
            ApiManager.get().add(super.tag, disposableObserver);
        }
        if (isLocalCache) {
            this.cacheExecute(getSubType(callback)).subscribe(disposableObserver);
        }
        this.execute(getType(callback)).subscribe(disposableObserver);
    }
}
