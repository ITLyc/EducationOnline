package com.teach.android.educationonline.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teach.android.educationonline.R;
import com.teach.android.educationonline.ui.activity.MainActivity;

/**
 * Created by chen on 2017/11/10.
 */

public class FragmentAttention extends Fragment {


    public void initBiaoTiTitles(final MainActivity mainActivity){
        mainActivity.setTitle("关注");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention,container,false);
        return view;
    }
}
