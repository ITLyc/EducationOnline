package com.teach.android.educationonline.http.cache;

import android.text.TextUtils;
import android.util.LruCache;

import com.teach.android.educationonline.log.MyLog;

import org.w3c.dom.Text;

/**
 * 内存缓存
 * Created by zheng on 2017/11/2.
 */

public class MemoryCache implements ICache{

    private LruCache<String,Object> cache;
    private static MemoryCache instance;

    private MemoryCache(){
        int maxMemory = (int)Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        cache = new LruCache(cacheSize);
    }
    public static MemoryCache getInstance(){
        if (instance == null){
            synchronized (MemoryCache.class){
                if (instance == null){
                    instance = new MemoryCache();
                }
            }
        }
        return instance;
    }
    @Override
    public synchronized void put(String key, Object value) {
        if (TextUtils.isEmpty(key))return;

        if (cache.get(key) != null){
            cache.remove(key);
        }
        cache.put(key,value);
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    public synchronized <T> T get(String key, Class<T> clazz) {
        try {
            return (T) cache.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            MyLog.e(e);
        }
        return null;
    }

    @Override
    public boolean contains(String key) {

        return cache.get(key) != null;
    }

    @Override
    public void remove(String key) {
        if (cache.get(key) != null){
            cache.remove(key);
        }
    }

    @Override
    public void clear() {
        cache.evictAll();
    }
}
