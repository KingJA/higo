package com.kingja.higo.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.modifypassword.ModifyPasswordActivity;
import com.kingja.higo.util.GoUtil;
import com.kingja.higo.util.ToastUtil;
import com.kingja.supershapeview.view.SuperShapeTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/3/8 13:43
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FindPasswordActivity extends BaseTitleActivity {
    @BindView(R.id.et_findPassword_phone)
    EditText etFindPasswordPhone;
    @BindView(R.id.et_findPassword_code)
    EditText etFindPasswordCode;
    @BindView(R.id.stv_findPassword_getCode)
    SuperShapeTextView stvFindPasswordGetCode;
    @BindView(R.id.et_findPassword_password)
    EditText etFindPasswordPassword;
    @BindView(R.id.iv_findPassword_showPassword)
    ImageView ivFindPasswordShowPassword;
    @BindView(R.id.tv_findPassword_confirm)
    TextView tvFindPasswordConfirm;


    @OnClick({R.id.stv_findPassword_getCode, R.id.tv_findPassword_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stv_findPassword_getCode:
                ToastUtil.showText("获取验证码");
                break;
            case R.id.tv_findPassword_confirm:
                GoUtil.goActivity(this, ModifyPasswordActivity.class);
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
        return "找回密码";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_find_password;
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
