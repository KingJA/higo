package com.kingja.higo.page.register;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.login.LoginPresenter;
import com.kingja.higo.util.CheckUtil;
import com.kingja.higo.util.CountTimer;
import com.kingja.supershapeview.view.SuperShapeTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Description:TODO
 * Create Time:2018/3/8 13:43
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RegisterActivity extends BaseTitleActivity {
    @BindView(R.id.et_register_mobile)
    EditText etRegisterMobile;
    @BindView(R.id.et_register_code)
    EditText etRegisterCode;
    @BindView(R.id.stv_register_getCode)
    SuperShapeTextView stvRegisterGetCode;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.iv_register_showPassword)
    ImageView ivRegisterShowPassword;
    @BindView(R.id.tv_register_confirm)
    TextView tvRegisterConfirm;
    private CountTimer countTimer;
    private boolean isShow;
    @Inject
    RegisterPresenter registerPresenter;

    @OnClick({R.id.stv_register_getCode, R.id.iv_register_showPassword, R.id.tv_register_confirm})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.stv_register_getCode:
                String mobile = etRegisterMobile.getText().toString().trim();
                if (CheckUtil.checkPhoneFormat(mobile)) {
                    getCode(mobile);
                }
                break;
            case R.id.iv_register_showPassword:
                switchPasswrodShowd();

                break;
            case R.id.tv_register_confirm:
                break;
            default:
                break;

        }

    }

    private void switchPasswrodShowd() {
        isShow = !isShow;
        if (isShow) {
            etRegisterPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            etRegisterPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        etRegisterPassword.setSelection(etRegisterPassword.getText().length());
    }

    private void getCode(String mobile) {
        countTimer = new CountTimer(10, stvRegisterGetCode);
        stvRegisterGetCode.setClickable(false);
        countTimer.start();

    }

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "注册";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
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
