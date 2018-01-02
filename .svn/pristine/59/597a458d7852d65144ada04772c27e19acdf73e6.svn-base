package com.teach.android.educationonline.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.teach.android.educationonline.R;
import com.teach.android.educationonline.common.Constants;
import com.teach.android.educationonline.ui.entity.LiveUserModel;
import com.teach.android.educationonline.ui.util.TextUtil;

import java.util.Stack;

import butterknife.ButterKnife;

/**
 * @author 作者:Lyc
 *         Created by Administrator on 2017/12/1 0001.
 *         com.teach.android.educationonline.ui.bese
 *         EducationOnline
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 用来保存所有已打开的Activity
     */
    private static Stack<Activity> listActivity = new Stack<Activity>();
    /**
     * 记录上次点击按钮的时间
     **/
    private long lastClickTime;
    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    /**
     * 按钮连续点击最低间隔时间 单位：毫秒
     **/
    public final static int CLICK_TIME = 500;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        // 将activity推入栈中
        listActivity.push(this);
        initView();
        initListener();
        if (isSetStatusBar) {
            steepStatusBar();
        }

    }
    public Context getContext() {
        return this.mContext;
    }
    /**
     * 是否设置沉浸状态栏
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /**
     * 保存activity状态
     **/
    protected void saveInstanceState(Bundle outState) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onBack() {
        finish();
    }

    @Override
    public void onClick(View v) {
        processClick(v);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从栈中移除当前activity
        if (listActivity.contains(this)) {
            listActivity.remove(this);
        }

    }


    /**
     * @return 布局文件
     */
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected void runOnMain(Runnable runnable) {
        runOnUiThread(runnable);
    }

    /**
     * 点击事件
     *
     * @param v
     */
    protected abstract void processClick(View v);

    private Toast toast;
    protected final static String NULL = "";


    public void toast(final Object obj) {
        try {
            runOnMain(new Runnable() {

                @Override
                public void run() {
                    if (toast == null)
                        toast = Toast.makeText(BaseActivity.this, NULL, Toast.LENGTH_SHORT);
                    toast.setText(obj.toString());
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 带有bundle跳转
     *
     * @param targetActivityClass
     * @param bundle
     */
    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 不带bundel跳转
     *
     * @param targetActivityClass
     */
    public void openActivity(Class<?> targetActivityClass) {
        openActivity(targetActivityClass, null);
    }

    /**
     * 含有Bundle通过Class打开编辑界面
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    /**
     * 用户名、密码合法校验
     */
    protected String checkUsers(String username, String password) {

        if (TextUtil.isMobileNO(username)) {
            if (password.length() < 6) {
                return "密码位数不足，请重新输入";
            }

            if (TextUtil.isContainAll(password)) {
                return "success";
            } else {
                return "密码不合法，请包含大小写字母以及数字";
            }
        } else {
            return "输入的用户名不是电话号码，请重新输入";
        }

    }


    /**
     * 验证上次点击按钮时间间隔，防止重复点击
     */
    public boolean verifyClickTime() {
        if (System.currentTimeMillis() - lastClickTime <= CLICK_TIME) {
            return false;
        }
        lastClickTime = System.currentTimeMillis();
        return true;
    }

    /**
     * 收起键盘
     */
    public void closeInputMethod() {
        // 收起键盘
        View view = getWindow().peekDecorView();// 用于判断虚拟软键盘是否是显示的
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 关闭所有(前台、后台)Activity,注意：请已BaseActivity为父类
     */
    protected static void finishAll() {
        int len = listActivity.size();
        for (int i = 0; i < len; i++) {
            Activity activity = listActivity.pop();
            activity.finish();
        }
    }


    public void saveUserInfoOnDisk(LiveUserModel user, String cookie) {
        Constants.saveUserInfo(user);
        Constants.saveCookie(cookie);

        Constants.initValue(getApplicationContext());
    }

    /***************** 双击退出程序 ************************************************/
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (KeyEvent.KEYCODE_BACK == keyCode) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                finishAll();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private Dialog progressDialog;

    public Dialog showLoading(Context mContext) {
        progressDialog = new Dialog(mContext, R.style.progress_dialog);
        progressDialog.setContentView(R.layout.loading);
        progressDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissLoading(Context mContext) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /****************************共享头文件*********************************/
    /**
     * @param title
     */
    public void setTitle(String title) {
        TextView tv = (TextView) findViewById(R.id.nv_tv_title);
        if (tv != null) {
            tv.setText(title);
        }
    }

    /**
     * 返回
     */
    private void initListener() {
        View back = findViewById(R.id.nv_back);
        if (back != null) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /**
     * 隐藏返回控件
     */
    public void setBackGone() {
        View back = findViewById(R.id.nv_back);
        if (back != null) {
            back.setVisibility(View.GONE);
        }
    }
}
