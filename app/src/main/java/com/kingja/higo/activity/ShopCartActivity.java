package com.kingja.higo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.FriendsAdapter;
import com.kingja.higo.adapter.ShopcartAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:TODO
 * Create Time:2018/3/20 9:29
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ShopCartActivity extends BaseTitleActivity {
    @BindView(R.id.lv_shopcart)
    ListView lvShopcart;
    private ShopcartAdapter mShopcartAdapter;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "购物车(5)";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_shopcart;
    }

    @Override
    protected void initView() {
        mShopcartAdapter = new ShopcartAdapter(this, new ArrayList<String>());
        lvShopcart.setAdapter(mShopcartAdapter);
    }

    @Override
    protected void initData() {
        setContentTitle("购物车(" + mShopcartAdapter.getCount() + ")");
        setRightClick("管理", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initNet() {

    }
}
