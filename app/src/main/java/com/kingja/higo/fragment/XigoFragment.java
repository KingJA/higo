package com.kingja.higo.fragment;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.kingja.higo.R;
import com.kingja.higo.adapter.XigoPageAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import java.lang.reflect.Field;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class XigoFragment extends BaseFragment {
    @BindView(R.id.tab_xigo)
    TabLayout tabXigo;
    @BindView(R.id.vp_content_xigo)
    ViewPager vpContentXigo;
    private String[] items = {"直营", "代购"};
    private Fragment mFragmentArr[] = new Fragment[2];

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        tabXigo.setTabMode(TabLayout.MODE_FIXED);
        tabXigo.addTab(tabXigo.newTab().setText(items[0]));
        tabXigo.addTab(tabXigo.newTab().setText(items[1]));
        tabXigo.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabXigo,60,60);
            }
        });

        mFragmentArr[0] = new DirectgoFragment();
        mFragmentArr[1] = new DirectgoFragment();
        XigoPageAdapter mHigoPageAdapter = new XigoPageAdapter(getChildFragmentManager(), mFragmentArr,
                items);
        vpContentXigo.setAdapter(mHigoPageAdapter);
        vpContentXigo.setOffscreenPageLimit(2);
        tabXigo.setupWithViewPager(vpContentXigo);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_xigo;
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }

    }
}