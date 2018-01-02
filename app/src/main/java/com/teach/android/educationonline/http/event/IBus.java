package com.teach.android.educationonline.http.event;

/**
 * 事件总线接口
 * Created by zheng on 2017/11/2.
 */

public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);
}
