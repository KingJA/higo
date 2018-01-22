package com.kingja.higo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingja.higo.base.BaseActivity;
import com.kingja.higo.constant.NavConstant;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.FragmentUtil;
import com.kingja.higo.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_nav_higo)
    ImageView ivNavHigo;
    @BindView(R.id.tv_nav_higo)
    TextView tvNavHigo;
    @BindView(R.id.ll_nav_higo)
    LinearLayout llNavHigo;
    @BindView(R.id.iv_nav_lovego)
    ImageView ivNavLovego;
    @BindView(R.id.tv_nav_lovego)
    TextView tvNavLovego;
    @BindView(R.id.ll_nav_lovego)
    LinearLayout llNavLovego;
    @BindView(R.id.iv_nav_walkgo)
    ImageView ivNavWalkgo;
    @BindView(R.id.tv_nav_walkgo)
    TextView tvNavWalkgo;
    @BindView(R.id.ll_nav_walkgo)
    LinearLayout llNavWalkgo;
    @BindView(R.id.iv_nav_journey)
    ImageView ivNavJourney;
    @BindView(R.id.tv_nav_journey)
    TextView tvNavJourney;
    @BindView(R.id.ll_nav_journey)
    LinearLayout llNavJourney;
    @BindView(R.id.iv_nav_mine)
    ImageView ivNavMine;
    @BindView(R.id.tv_nav_mine)
    TextView tvNavMine;
    @BindView(R.id.ll_nav_mine)
    LinearLayout llNavMine;

    private Fragment mCurrentFragment;
    private int nCurrentPosition = -1;
    private int mSelectedPosition = -1;

    @Override
    public void initVariable() {

    }

    @Override
    public int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        mCurrentFragment = FragmentUtil.getFragment(0);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, mCurrentFragment).commit();
    }

    @Override
    protected void initNet() {

    }

    @OnClick({R.id.ll_nav_higo, R.id.ll_nav_lovego, R.id.ll_nav_walkgo, R.id.ll_nav_journey, R.id.ll_nav_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_nav_higo:
                selectTab(NavConstant.NAV_HIGO);
                break;
            case R.id.ll_nav_lovego:
                selectTab(NavConstant.NAV_LOVEGO);
                break;
            case R.id.ll_nav_walkgo:
                selectTab(NavConstant.NAV_WALKGO);
                break;
            case R.id.ll_nav_journey:
                selectTab(NavConstant.NAV_JOURNEY);
                break;
            case R.id.ll_nav_mine:
                selectTab(NavConstant.NAV_MINE);
                break;
            default:
                break;
        }
    }

    //防止Fragment重生重叠
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    private long mLastTime;

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastTime < 500) {
            finish();
        } else {
            ToastUtil.showText("连续点击退出");
            mLastTime = currentTime;

        }
    }

    private void setStatus(int index) {
        resetBottom();
        switch (index) {
            case 0:
                ivNavHigo.setBackgroundResource(R.mipmap.ic_nav_higo);
                tvNavHigo.setTextColor(getResources().getColor(R.color.orange_hi));
                break;
            case 1:
                ivNavLovego.setBackgroundResource(R.mipmap.ic_nav_lovego);
                tvNavLovego.setTextColor(getResources().getColor(R.color.orange_hi));
                break;
            case 2:
                ivNavWalkgo.setBackgroundResource(R.mipmap.ic_nav_walkgo);
                tvNavWalkgo.setTextColor(getResources().getColor(R.color.orange_hi));
                break;
            case 3:
                ivNavJourney.setBackgroundResource(R.mipmap.ic_nav_journey);
                tvNavJourney.setTextColor(getResources().getColor(R.color.orange_hi));
                break;
            case 4:
                ivNavMine.setBackgroundResource(R.mipmap.ic_nav_mine);
                tvNavMine.setTextColor(getResources().getColor(R.color.orange_hi));
                break;
            default:
                break;

        }
    }

    private void resetBottom() {
        tvNavHigo.setTextColor(getResources().getColor(R.color.gray_hi));
        tvNavLovego.setTextColor(getResources().getColor(R.color.gray_hi));
        tvNavWalkgo.setTextColor(getResources().getColor(R.color.gray_hi));
        tvNavJourney.setTextColor(getResources().getColor(R.color.gray_hi));
        tvNavMine.setTextColor(getResources().getColor(R.color.gray_hi));
    }

    private void selectTab(int position) {
        mSelectedPosition = position;
        if (mSelectedPosition == nCurrentPosition) {
            return;
        }
        mCurrentFragment = FragmentUtil.switchFragment(getSupportFragmentManager(), mCurrentFragment, FragmentUtil
                .getFragment(position));
        nCurrentPosition = mSelectedPosition;
        setStatus(position);
    }
}
