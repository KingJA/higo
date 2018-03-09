package com.kingja.higo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/2/26 16:07
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PersonalActivity extends BaseTitleActivity {
    @BindView(R.id.iv_personal_head)
    ImageView ivPersonalHead;
    @BindView(R.id.rl_personal_head)
    RelativeLayout rlPersonalHead;
    @BindView(R.id.rl_personal_nickanme)
    RelativeLayout rlPersonalNickanme;

    @OnClick({R.id.rl_personal_head, R.id.rl_personal_nickanme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_personal_head:
                GoUtil.goActivity(this,FindPasswordActivity.class);
                break;
            case R.id.rl_personal_nickanme:
                GoUtil.goActivity(this,ModifyNicknameActivity.class);
                break;
            default:
                break;
        }

    }

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "个人信息";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_personal;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {

    }

}
