package com.teach.android.educationonline.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.teach.android.educationonline.R;
import com.teach.android.educationonline.http.ViseHttp;
import com.teach.android.educationonline.http.callback.ACallback;
import com.teach.android.educationonline.log.MyLog;
import com.teach.android.educationonline.ui.base.BaseActivity;
import com.teach.android.educationonline.ui.entity.BannerModel;
import com.teach.android.educationonline.ui.fragments.FragmentAttention;
import com.teach.android.educationonline.ui.fragments.FragmentChannel;
import com.teach.android.educationonline.ui.fragments.FragmentHome;
import com.teach.android.educationonline.ui.fragments.FragmentLive;
import com.teach.android.educationonline.ui.fragments.FragmentMe;
import com.teach.android.educationonline.util.ToastUtil;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.logout)
        Button logout;

    BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    //    Fragment fragmentHome,fragmentAttention,fragmentLive,fragmentChannel,fragmentMe;
    FragmentHome fragmentHome;
    FragmentAttention fragmentAttention;
    FragmentLive fragmentLive;
    FragmentChannel fragmentChannel;
    FragmentMe fragmentMe;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSteepStatusBar(true);//沉浸状态栏,默认是开启的true,
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setBackGone();
        initViewAndData();
    }

    @Override
    protected void processClick(View v) {

    }

    private void initViewAndData() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        fragmentHome = new FragmentHome();
        fragmentAttention = new FragmentAttention();
        fragmentLive = new FragmentLive();
        fragmentChannel = new FragmentChannel();
        fragmentMe = new FragmentMe();
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "主页").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "频道").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "直播").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "关注").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "我的").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setFragmentContent(lastSelectedPosition);
    }

    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
        setFragmentContent(position);
    }


    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void setFragmentContent(int position) {
        transaction = getFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (fragmentHome != null) {
                    fragmentHome.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentHome).commitAllowingStateLoss();
                }
                break;
            case 1:
                if (fragmentChannel != null) {
                    fragmentChannel.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentChannel).commitAllowingStateLoss();
                }
                break;
            case 2:
                if (fragmentLive != null) {
                    fragmentLive.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentLive).commitAllowingStateLoss();
                }
                break;

            case 3:
                if (fragmentAttention != null) {
                    fragmentAttention.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentAttention).commitAllowingStateLoss();
                }
                break;
            case 4:
                if (fragmentMe != null) {
                    fragmentMe.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentMe).commitAllowingStateLoss();
                }

                break;
            default:
                if (fragmentHome != null) {
                    fragmentHome.initBiaoTiTitles(MainActivity.this);
                    transaction.replace(R.id.layFrame, fragmentHome).commitAllowingStateLoss();
                }
                break;
        }
    }

    /**
     * 注销
     * @param view
     */

    public void onLogout(View view){


        ViseHttp.GET(getString(R.string.logout))
        .tag(getString(R.string.logout))
                .addParam("user_id","10007")
        .request(new ACallback<List<BannerModel>>(){

            @Override
            public void onSuccess(List<BannerModel> data) {
                if (data == null) {
                    return;
                }
                ToastUtil.showLong(data.toString().trim());
            }

            @Override
            public void onFail(int errCode, String errMsg) {
                MyLog.e("注销失败" + errCode + ",errorMsg:" + errMsg);
                ToastUtil.showShort(errMsg);
                dismissLoading(getContext());
            }
        });
    }

}
