package com.teach.android.educationonline.http.event;

import com.teach.android.educationonline.http.event.inner.ThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接收事件注解，必须在接收事件地方定制该注解
 * Created by zheng on 2017/11/2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    ThreadMode threadMode() default ThreadMode.MAIN_THREAD;
}
