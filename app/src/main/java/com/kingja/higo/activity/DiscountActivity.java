package com.kingja.higo.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.DiscountAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:TODO
 * Create Time:2018/2/26 10:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DiscountActivity extends BaseTitleActivity {
    @BindView(R.id.lv_discount)
    ListView lvDiscount;

    @Override
    public void initData() {

    }

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "我的优惠券";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_mine_discount;
    }

    @Override
    protected void initView() {
        DiscountAdapter mDiscountAdapter = new DiscountAdapter(this, new ArrayList<String>());
        lvDiscount.setAdapter(mDiscountAdapter);
    }

    @Override
    protected void initNet() {

    }
}
