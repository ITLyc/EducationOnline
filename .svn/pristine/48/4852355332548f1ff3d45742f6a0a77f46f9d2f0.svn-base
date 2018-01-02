package com.teach.android.educationonline.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.teach.android.educationonline.ui.Myapplication;

/**
 * Created by Administrator on 2015/6/29.
 */
public class ToastUtil {

    private ToastUtil() {}

    private static void show(Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    private static void show(Context context, String message, int duration) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Toast.makeText(context, message, duration).show();
    }

    public static void showShort(int resId) {
        Toast.makeText(Myapplication.getMyContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Toast.makeText(Myapplication.getMyContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resId) {
        Toast.makeText(Myapplication.getMyContext(), resId, Toast.LENGTH_LONG).show();
    }

    public static void showLong(String message) {
        Toast.makeText(Myapplication.getMyContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示toast
     * @param ctx
     * @param message
     */
    public static void showTaost(final Activity ctx,final String message){
        if (TextUtils.isEmpty(message)) {
            return;
        }
        if("main".equals(Thread.currentThread().getName())){ // 判断 当前是否是在主线程
            Toast.makeText(ctx.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }else{
            // 不是主线程
            ctx.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
