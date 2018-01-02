package com.teach.android.educationonline.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.teach.android.educationonline.R;
import com.teach.android.educationonline.common.Constants;
import com.teach.android.educationonline.ui.Myapplication;
import com.teach.android.educationonline.ui.entity.LiveUserModel;
import com.teach.android.educationonline.ui.util.SpUtils;

/**
 * File description.
 *
 * @author 作者:lyc
 * @date 2017/12/18 0018
 */


public class SplashActivity extends Activity {
    private static final long WELCOME_DELAY_MILLIS = 1000;
    boolean isFirstOpen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        isFirstOpen= SpUtils.getBoolean(this,Constants.FileName.FIRST_OPEN);
        if (!isFirstOpen) {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity();
            }
        },WELCOME_DELAY_MILLIS);
    }

    private void enterHomeActivity() {
        LiveUserModel userInfo= Constants.getUserInfo();
        if (userInfo!=null){
            startActivity(new Intent(Myapplication.getMyContext(),MainActivity.class));
            finish();
        }else {
            startActivity(new Intent(Myapplication.getMyContext(), LoginActivity.class));
            finish();
        }
    }
}
