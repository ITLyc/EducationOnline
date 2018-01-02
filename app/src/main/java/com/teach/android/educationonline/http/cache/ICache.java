package com.teach.android.educationonline.http.cache;

/**
 * 缓存接口
 * Created by zheng on 2017/10/25.
 */

public interface ICache {
    void put(String key,Object value);

    Object get(String key);

    boolean contains(String key);

    void remove(String key);

    void clear();

}
