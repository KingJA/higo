package com.kingja.higo.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingja.higo.R;
import com.kingja.higo.adapter.HigoPageAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HigoFragment extends BaseFragment {
    @BindView(R.id.tab_higo)
    TabLayout tabHigo;
    @BindView(R.id.vp_content_higo)
    ViewPager vpContentHigo;
    private Fragment mFragmentArr[] = new Fragment[2];
    private String[] items = {"景区购", "酒店购"};
    private int[] icons = {R.mipmap.ic_scenic, R.mipmap.ic_hotel};

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        tabHigo.setTabMode(TabLayout.MODE_FIXED);
        tabHigo.addTab(tabHigo.newTab().setText(items[0]));
        tabHigo.addTab(tabHigo.newTab().setText(items[1]));

        mFragmentArr[0] = new ScenicFragment();
        mFragmentArr[1] = new HotelFragment();
        HigoPageAdapter mHigoPageAdapter = new HigoPageAdapter(getActivity(), getFragmentManager(), mFragmentArr,
                items, icons);
        vpContentHigo.setAdapter(mHigoPageAdapter);
        vpContentHigo.setOffscreenPageLimit(2);
        tabHigo.setupWithViewPager(vpContentHigo);

        for (int i = 0; i < tabHigo.getTabCount(); i++) {
            TabLayout.Tab tab = tabHigo.getTabAt(i);
            tab.setCustomView(mHigoPageAdapter.getTabView(i));
        }

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_higo;
    }


}
