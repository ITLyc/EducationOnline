package com.teach.android.educationonline.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.teach.android.educationonline.R;
import com.teach.android.educationonline.database.LoginRespone;
import com.teach.android.educationonline.http.ViseHttp;
import com.teach.android.educationonline.http.callback.ACallback;
import com.teach.android.educationonline.log.MyLog;
import com.teach.android.educationonline.ui.base.BaseActivity;
import com.teach.android.educationonline.util.ToastUtil;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.edit_login_userword)
    EditText et_userName;
    @BindView(R.id.edit_login_password)
    EditText et_password;
    private String loginUserName, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected void initView() {
        setTitle("登录");//设置title
        setBackGone();//隐藏返回控件
    }

    @Override
    protected void processClick(View v) {

    }

    public void login(View v) {

        if (TextUtils.isEmpty(et_userName.getText()) || TextUtils.isEmpty(et_password.getText())) {
            ToastUtil.showShort("用户名或密码为空");
        } else {
            showLoading(getContext());
            ViseHttp.GET(getString(R.string.login))
                    .tag(getString(R.string.login))
                    .addParam("user_model", et_userName.getText().toString())
                    .addParam("user_pwd", et_password.getText().toString())
                    .request(new ACallback<LoginRespone>() {
                        @Override
                        public void onSuccess(LoginRespone success) {
                            if (success == null) {
                                return;
                            }
                            if (success.isSucess() || success.getStatus() == 1006) {
                                if (success.getStatus() == 1006) {
//                                    LiveUserModel info = success.getData();
//                                    saveUserInfoOnDisk(info, success.getCookie());
//                                    Constants.getUserInfo().getUser_id() 获取用户Id
//                                Constants.logout();退出登录时直接调用这个话
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            } else {
                                toast(success.getMsg());
                            }
                            dismissLoading(getContext());
                        }

                        @Override
                        public void onFail(int errCode, String errMsg) {
                            MyLog.i("request errorCode:" + errCode + ",errorMsg:" + errMsg);
                            ToastUtil.showShort(errMsg);
                            dismissLoading(getContext());
                        }
                    });
        }
    }

}
