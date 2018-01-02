package com.teach.android.educationonline.http.permission;

/**
 * 申请回调权限
 * Created by zheng on 2017/11/2.
 */

public interface OnPermissionCallback {
    //允许
    void onRequestAllow(String permissionName);
    //拒绝
    void onRequestRefuse(String permissionName);
    //不再询问
    void onRequestNoAsk(String permissionName);
}
