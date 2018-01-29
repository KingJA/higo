package com.kingja.higo.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.kingja.higo.R;
import com.kingja.higo.adapter.XigoPageAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class OrderFragment extends BaseFragment {
    @BindView(R.id.tab_order)
    TabLayout tabOrder;
    @BindView(R.id.vp_content_order)
    ViewPager vpContentOrder;
    private String[] items = {"全部", "待付款", "待使用", "已送产品"};
    private Fragment mFragmentArr[] = new Fragment[4];


    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        tabOrder.setTabMode(TabLayout.MODE_FIXED);
        tabOrder.addTab(tabOrder.newTab().setText(items[0]));
        tabOrder.addTab(tabOrder.newTab().setText(items[1]));
        tabOrder.addTab(tabOrder.newTab().setText(items[2]));
        tabOrder.addTab(tabOrder.newTab().setText(items[3]));
        mFragmentArr[0] = new GiftFragment();
        mFragmentArr[1] = new GiftFragment();
        mFragmentArr[2] = new GiftFragment();
        mFragmentArr[3] = new GiftFragment();
        XigoPageAdapter mHigoPageAdapter = new XigoPageAdapter(getChildFragmentManager(), mFragmentArr,
                items);
        vpContentOrder.setAdapter(mHigoPageAdapter);
        vpContentOrder.setOffscreenPageLimit(2);
        tabOrder.setupWithViewPager(vpContentOrder);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_order;
    }

}
