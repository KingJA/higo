package com.kingja.higo.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;
import com.kingja.higo.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/3/8 13:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LoginActivity extends BaseTitleActivity {
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.tv_login_confirm)
    TextView tvLoginConfirm;
    @BindView(R.id.tv_login_register)
    TextView etLoginRegister;
    @BindView(R.id.tv_login_findPassword)
    TextView etLoginFindPassword;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "登录";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
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

    @OnClick({R.id.tv_login_findPassword, R.id.tv_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_findPassword:
                GoUtil.goActivity(this,FindPasswordActivity.class);
                break;
            case R.id.tv_login_register:
                GoUtil.goActivity(this,RegisterActivity.class);
                break;
            default:
                break;
        }

    }
}