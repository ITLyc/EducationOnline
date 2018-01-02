package com.teach.android.educationonline.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import com.google.gson.Gson;
import com.teach.android.educationonline.log.MyLog;
import com.teach.android.educationonline.ui.Myapplication;
import com.teach.android.educationonline.ui.entity.LiveUserModel;
import com.teach.android.educationonline.util.AppInfoUtil;
import com.teach.android.educationonline.util.ResponseUtil;
import com.teach.android.educationonline.util.file.FileUtils;

/**
 * @author 作者:Lyc
 *         Created by Administrator on 2017/12/1 0001.
 *         com.teach.android.educationonline.common
 *         EducationOnline
 */

public class Constants {
    private static String sCookieInfo;
    private static String sOpen;
    public static int screenWidth, screenHeight;
    private static final int BASE_SCREEN_WIDTH = 480;
    private static final int BASE_SCREEN_HEIGHT = 800;
    private static LiveUserModel sUserInfo;
    private static final String APP_CHANNEL_KEY = "APP_CHANNEL";

    public class FileName {
        public static final String USER_INFO_TWO = "user_info_two";
        public static final String USER_INFO = "user_info2";
        public static final String COOKIE_INFO = "cookie_info2";
        public static final String FIRST_OPEN = "first_open";

    }

    public static void initValue(Context context) {
        initScreenSize(context);
        initUserInfo();
        initCookieInfo();
//        AppInfo.init(context);
    }

    public static void initScreenSize(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        if (screenWidth == 0) {
            screenWidth = BASE_SCREEN_WIDTH;
        }
        if (screenHeight == 0) {
            screenHeight = BASE_SCREEN_HEIGHT;
        }
    }

    /**
     * 保存用户数据
     */
    public static void saveUserInfo(LiveUserModel userInfo) {
        try {
            FileUtils.writeFile(Myapplication.getMyContext(),
                    FileName.USER_INFO, new Gson().toJson(userInfo));
        } catch (Exception e) {
            MyLog.w(e);
        }
        Constants.initUserInfo();
    }

    /**
     * 保存cookie数据
     */
    public static void saveCookie(String cookieInfo) {
        try {
            FileUtils.writeFile(Myapplication.getMyContext(), FileName.COOKIE_INFO, cookieInfo);
            sCookieInfo = cookieInfo;
        } catch (Exception e) {
            MyLog.w(e);
        }
        Constants.initCookieInfo();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        FileUtils.writeFile(Myapplication.getMyContext(), FileName.USER_INFO, "");
        FileUtils.writeFile(Myapplication.getMyContext(), FileName.COOKIE_INFO, "");
        initUserInfo();
        initCookieInfo();
    }

    /**
     * 获得用户信息
     */
    public static LiveUserModel getUserInfo() {
        if (sUserInfo == null) {

            return null;

        }
        return sUserInfo;
    }

    public static void setUserInfo(LiveUserModel user) {
        sUserInfo = user;
    }

    /**
     * 获得Cookie信息
     */
    public static String getCookieInfo() {
        return sCookieInfo;
    }

    /**
     * 判断是否登录
     */
    public static boolean hashLogin() {

        return (sUserInfo != null);
    }

    /**
     * 初始化用户信息
     */
    public static void initUserInfo() {
        String userInfoText = FileUtils.readFile(Myapplication.getMyContext(),
                FileName.USER_INFO);
        if (!TextUtils.isEmpty(userInfoText)) {
            try {
                ResponseUtil.checkResponse(userInfoText);
                sUserInfo = new Gson().fromJson(userInfoText, LiveUserModel.class);

            } catch (Exception e) {
                MyLog.w(e);
                sUserInfo = null;
            }
        } else {
            sUserInfo = null;
        }
    }

    /**
     * 初始化Cookie
     */
    public static void initCookieInfo() {
        try {
            sCookieInfo = FileUtils.readFile(Myapplication.getMyContext(), FileName.COOKIE_INFO);
        } catch (Exception e) {
            Log.e("initCookieInfo", "initCookieInfo: " + e.getMessage());
        }

    }


    public static class AppInfo {
        // 应用信息详情，在app中初始化

        private static String _versionName; // 当前版本名
        private static long _vsersionCode; // 当前版本号
        private static String _platform; // 发布平台

        /**
         * 获得版本名
         */
        public static String getVersionName() {
            return _versionName;
        }

        /**
         * 获得版本号
         */
        public static long getVsersionCode() {
            return _vsersionCode;
        }

        /**
         * 获得发布平台
         */
        public static String getPlatform() {
            return _platform;
        }

        private static void init(Context context) {
            _versionName = AppInfoUtil.getVsersionName(context);
            _vsersionCode = AppInfoUtil.getVersionCode(context);
            try {
                _platform = AppInfoUtil.getMetaDate(context, APP_CHANNEL_KEY);
                MyLog.d("app 渠道:", _platform);
            } catch (Exception e) {
                MyLog.e("Manifeast文件获得应用渠道失败！！！ error:", e.toString());
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取手机型号
     */
    public static String getmodel() {
        Build bd = new Build();
        String model = bd.MODEL;
        return model;
    }
}
