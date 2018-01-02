package com.teach.android.educationonline.ui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.teach.android.educationonline.R;
import com.teach.android.educationonline.common.Constants;
import com.teach.android.educationonline.ui.adapter.GuideViewPagerAdapter;
import com.teach.android.educationonline.ui.base.BaseActivity;
import com.teach.android.educationonline.ui.util.SpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * File description.
 *
 * @author 作者:lyc
 * @date 2017/12/18 0018
 * 欢迎页
 */


public class WelcomeActivity extends BaseActivity {
    private ViewPager vp;
    private GuideViewPagerAdapter adapter;
    private List<View> views;
    private Button startBtn;
    //引导页资源图片
    private static final int[] pice = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4};
    // 底部小点图片
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        views = new ArrayList<View>();
        //初始化引导页视图列表
        for (int i = 0; i < pice.length; i++) {
            View view = LayoutInflater.from(this).inflate(pice[i], null);

            if (i == pice.length - 1) {
                startBtn= (Button) view.findViewById(R.id.btn_ok);
                startBtn.setTag("OK");
                startBtn.setOnClickListener(this);
            }
            views.add(view);
        }
        vp = (ViewPager) findViewById(R.id.vp_guide);
        adapter = new GuideViewPagerAdapter(views);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new PageChangeListener());
        initDots();
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pice.length];

        //循环获取小圆点
        for (int i = 0; i < pice.length; i++) {
            //得到一个LinearLayout下面的每一个子元素
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(false);// 都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true); // 设置为白色，即选中状态

    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pice.length) {
            return;
        }
        vp.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pice.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("OK")) {
            enterMainActivity();
            return;
        }
        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    @Override
    protected void processClick(View v) {

    }

    private void enterMainActivity() {
        Intent intent = new Intent(WelcomeActivity.this,
                LoginActivity.class);
        startActivity(intent);
        SpUtils.putBoolean(WelcomeActivity.this, Constants.FileName.FIRST_OPEN, true);
        finish();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int state) {

        }

        // 当前页面被滑动时调用
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        // 当新的页面被选中时调用
        @Override
        public void onPageSelected(int position) {
        // 设置底部小点选中状态
            setCurDot(position);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        // 如果切换到后台，就设置下次不进入功能引导页
        SpUtils.putBoolean(WelcomeActivity.this, Constants.FileName.FIRST_OPEN, true);
        finish();
    }
}
