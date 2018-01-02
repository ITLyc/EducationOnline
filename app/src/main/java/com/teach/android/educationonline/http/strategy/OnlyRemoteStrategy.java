package com.teach.android.educationonline.http.strategy;

import com.teach.android.educationonline.http.core.ApiCache;
import com.teach.android.educationonline.http.mode.CacheResult;

import java.lang.reflect.Type;

import io.reactivex.Observable;

/**
 * 缓存策略--只取网络
 * Created by zheng on 2017/11/3.
 */

public class OnlyRemoteStrategy<T> extends CacheStrategy<T> {
    @Override
    public <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Type type) {
        return loadRemote(apiCache, cacheKey, source);
    }
}
