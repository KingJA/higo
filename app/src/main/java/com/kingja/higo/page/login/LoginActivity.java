package com.kingja.higo.page.login;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kingja.higo.R;
import com.kingja.higo.page.forgetpassword.ForgetPasswordActivity;
import com.kingja.higo.page.register.RegisterActivity;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.model.entiy.Login;
import com.kingja.higo.util.CheckUtil;
import com.kingja.higo.util.GoUtil;
import com.kingja.higo.util.SpManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/3/8 13:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LoginActivity extends BaseTitleActivity implements LoginContract.View {
    @Inject
    LoginPresenter mLoginPresenter;
    @Inject
    SpManager mSpManager;
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
        DaggerLoginCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected String getContentTitle() {
        return getString(R.string.title_login);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mLoginPresenter.attachView(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {

    }

    @OnClick({R.id.tv_login_findPassword, R.id.tv_login_register, R.id.tv_login_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_findPassword:
                GoUtil.goActivity(this, ForgetPasswordActivity.class);
                break;
            case R.id.tv_login_register:
                GoUtil.goActivity(this, RegisterActivity.class);
                break;
            case R.id.tv_login_confirm:
                String username = etLoginName.getText().toString().trim();
                String password = etLoginPassword.getText().toString().trim();
                if (CheckUtil.checkEmpty(username, "请输入用户名") && CheckUtil.checkEmpty(password, "请输入密码")) {
                    mLoginPresenter.login(username, password);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {
        setProgressShow(true);
    }

    @Override
    public void hideLoading() {
        setProgressShow(false);
    }

    @Override
    public void onLoginSuccess(Login login) {
        Log.e(TAG, "getToken: "+ login.getToken() );
        mSpManager.putToken(login.getToken());
        mSpManager.putUID(login.getUid()+"");
        finish();
    }

}