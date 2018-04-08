package com.kingja.higo.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.kingja.higo.R;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

import butterknife.BindView;
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
                selectPhoto();
                break;
            case R.id.rl_personal_nickanme:
                GoUtil.goActivity(this, ModifyNicknameActivity.class);
                break;
            default:
                break;
        }

    }

    private static final int REQUEST_CODE_CHOOSE = 0;

    private void selectPhoto() {
        Matisse.from(this)
                .choose(MimeType.allOf())
                .countable(true)
//                .capture(true)
                .theme(R.style.PhotoTheme)//主题  暗色主题 R.style.Matisse_Dracula
                .maxSelectable(1) // 图片选择的最多数量
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f) // 缩略图的比例
                .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                .forResult(REQUEST_CODE_CHOOSE); // 设置作为标记的请求码
    }
    List<Uri> mSelected;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Glide.with(this)
                    .load(mSelected.get(0))
                    .centerCrop()
                    .crossFade()
                    .into(ivPersonalHead);
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
