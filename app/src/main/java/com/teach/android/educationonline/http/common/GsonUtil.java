package com.teach.android.educationonline.http.common;

import com.google.gson.Gson;

/**
 * Gson单例操作
 * Created by zheng on 2017/11/1.
 */

public class GsonUtil {
    private static Gson gson;

    public static Gson gson() {
        if (gson == null) {
            synchronized (Gson.class) {
                if (gson == null) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }
}
