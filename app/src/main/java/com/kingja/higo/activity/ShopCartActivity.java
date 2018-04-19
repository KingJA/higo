package com.kingja.higo.activity;

import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.ShopcartAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.callback.EmptyCartCallback;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import java.util.ArrayList;

import butterknife.BindView;

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
    private LoadService loadService;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "购物车(0)";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_shopcart;
    }

    @Override
    protected void initView() {
        mShopcartAdapter = new ShopcartAdapter(this, new ArrayList<String>());
        lvShopcart.setAdapter(mShopcartAdapter);
        loadService = LoadSir.getDefault().register(lvShopcart);
    }

    @Override
    protected void initData() {
        setContentTitle("购物车(" + mShopcartAdapter.getCount() + ")");
        setRightClick("管理", v -> {

        });
    }

    @Override
    protected void initNet() {
        loadService.showCallback(EmptyCartCallback.class);
    }
}
