package com.kingja.higo.page.modify_nickname;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.forgetpassword.DaggerForgetPasswordCompnent;
import com.kingja.higo.page.forgetpassword.ForgetPasswordPresenter;
import com.kingja.higo.util.CheckUtil;
import com.kingja.higo.util.ToastUtil;
import com.kingja.supershapeview.view.SuperShapeEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/3/8 14:57
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ModifyNicknameActivity extends BaseTitleActivity implements View.OnClickListener, ModifyNicknameContract
        .View {
    @BindView(R.id.set_nickname)
    SuperShapeEditText setNickname;
    @BindView(R.id.iv_nickname_clear)
    ImageView ivNicknameClear;

    @Inject
    ModifyNicknamePresenter modifyNicknamePresenter;

    @OnClick({R.id.iv_nickname_clear})
    public void click(View view) {
        setNickname.setText("");
    }

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {
        DaggerModifyNicknameCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected String getContentTitle() {
        return "修改昵称";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_modify_nickname;
    }

    @Override
    protected void initView() {
        modifyNicknamePresenter.attachView(this);
    }

    @Override
    protected void initData() {
        setRightClick("确定", this);
        setNickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ivNicknameClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
        });

    }

    @Override
    protected void initNet() {

    }

    @Override
    public void onClick(View v) {
        String nickname = setNickname.getText().toString().trim();
        if (CheckUtil.checkEmpty(nickname, "请输入昵称")) {
            modifyNicknamePresenter.modifyNickname(nickname);
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
    public void onModifyNicknameSuccess() {
        ToastUtil.showText("昵称修改成功");
        finish();
    }
}
