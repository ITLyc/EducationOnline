package com.teach.android.educationonline.http.strategy;

import com.teach.android.educationonline.http.core.ApiCache;
import com.teach.android.educationonline.http.mode.CacheResult;

import java.lang.reflect.Type;
import java.util.Observable;

/**
 * 缓存策略接口
 * Created by zheng on 2017/11/3.
 */

public interface ICacheStrategy<T> {
    <T> io.reactivex.Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, io.reactivex.Observable<T> source, Type type);
}
