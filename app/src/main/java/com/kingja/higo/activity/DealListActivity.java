package com.kingja.higo.activity;

import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.DealAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.callback.ErrorNetworkCallback;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/3/10 10:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DealListActivity extends BaseTitleActivity {
    @BindView(R.id.lv_deals)
    ListView lvDeals;
    private LoadService loadService;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "交易明细";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_deals;
    }

    @Override
    protected void initView() {
        DealAdapter mDealAdapter = new DealAdapter(this, new ArrayList<String>());
        lvDeals.setAdapter(mDealAdapter);
        loadService = LoadSir.getDefault().register(lvDeals);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {
        loadService.showCallback(ErrorNetworkCallback.class);
    }

}
