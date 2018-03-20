package com.kingja.higo.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kingja.higo.R;
import com.kingja.higo.activity.PayActivity;
import com.kingja.higo.activity.ShopCartActivity;
import com.kingja.higo.adapter.SpinerAdapter;
import com.kingja.higo.adapter.XigoPageAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;
import com.kingja.popsir.ListPop;

import java.lang.reflect.Field;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R.id.ll_spinner_root)
    LinearLayout llSpinnerRoot;
    private String[] items = {"直营", "代购"};
    private Fragment mFragmentArr[] = new Fragment[2];
    private int[] icons = {R.mipmap.ic_owner_sell, R.mipmap.ic_agency};
    private String[] showTypes = {"演唱会", "话剧戏剧", "戏曲艺术", "音乐会", "体育赛事", "亲自演出", "休闲展览"};
    private String[] showPlaces = {"温州大剧院", "东南剧院", "鹿城文化中心", "温州体院馆"};


    @OnClick({R.id.ll_spiner_show_type, R.id.ll_spiner_place, R.id.iv_shopCart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_spiner_show_type:
                new ListPop.Builder(getActivity())
                        .setPopAdapter(new SpinerAdapter(getActivity(), Arrays.asList("演唱会", "话剧戏剧", "戏曲艺术", "音乐会",
                                "体育赛事", "亲自演出", "休闲展览")))
                        .build()
                        .showAsDropDown(llSpinnerRoot);
                break;
            case R.id.ll_spiner_place:
                new ListPop.Builder(getActivity())
                        .setPopAdapter(new SpinerAdapter(getActivity(), Arrays.asList("温州大剧院", "东南剧院", "鹿城文化中心",
                                "温州体院馆")))
                        .build()
                        .showAsDropDown(llSpinnerRoot);
                break;
            case R.id.iv_shopCart:
//                GoUtil.goActivity(getActivity(), ShopCartActivity.class);
                GoUtil.goActivity(getActivity(), PayActivity.class);
                break;
            default:
                break;
        }
    }

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
                setIndicator(tabXigo, 60, 60);
            }
        });

        mFragmentArr[0] = new DirectgoFragment();
        mFragmentArr[1] = new DirectgoFragment();
        XigoPageAdapter mHigoPageAdapter = new XigoPageAdapter(getActivity(), getChildFragmentManager(), mFragmentArr,
                items, icons);
        vpContentXigo.setAdapter(mHigoPageAdapter);
        vpContentXigo.setOffscreenPageLimit(2);
        tabXigo.setupWithViewPager(vpContentXigo);

        for (int i = 0; i < tabXigo.getTabCount(); i++) {
            TabLayout.Tab tab = tabXigo.getTabAt(i);
            tab.setCustomView(mHigoPageAdapter.getTabView(i));
        }
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

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem()
                .getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem()
                .getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams
                    .MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }

    }


}