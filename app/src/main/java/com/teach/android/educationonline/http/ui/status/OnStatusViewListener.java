package com.teach.android.educationonline.http.ui.status;

import android.view.View;

/**
 * 状态视图显示监听
 * Created by zheng on 2017/11/3.
 */

public interface OnStatusViewListener {
    void onShowView(View view, int id);

    void onHideView(View view, int id);
}
