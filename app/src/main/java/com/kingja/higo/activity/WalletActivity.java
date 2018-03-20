package com.kingja.higo.activity;

import android.os.Bundle;
import android.view.View;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;
import com.kingja.supershapeview.view.SuperShapeTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/2/26 9:45
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class WalletActivity extends BaseActivity {
    @BindView(R.id.stv_recharge)
    SuperShapeTextView stvRecharge;
    @BindView(R.id.stv_deal)
    SuperShapeTextView stvDeal;

    @OnClick({R.id.stv_recharge, R.id.stv_deal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stv_recharge:
                GoUtil.goActivity(this, PersonalActivity.class);
                break;
            case R.id.stv_deal:
                GoUtil.goActivity(this, DealListActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void initVariable() {

    }
    @Override
    public void initData() {

    }

    @Override
    public View getContentId() {
        return View.inflate(this, R.layout.activity_mine_wallet, null);
    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initNet() {

    }

}
