package com.teach.android.educationonline.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 作者:Lyc
 *         Created by Administrator on 2017/12/1 0001.
 *         com.teach.android.educationonline.ui.bese
 *         EducationOnline
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;

    /**
     * 获得全局的，防止使用getActivity()为空
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mActivity).inflate(getLayoutId(), container, false);
        initView(view);
        return view;

    }

    protected abstract int getLayoutId();

    protected abstract void initView(View rootView);


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
