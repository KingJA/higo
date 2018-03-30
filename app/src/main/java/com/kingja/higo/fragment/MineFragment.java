package com.kingja.higo.fragment;

import android.view.View;
import android.widget.ImageView;

import com.kingja.higo.R;
import com.kingja.higo.activity.DiscountActivity;
import com.kingja.higo.activity.FriendsActivity;
import com.kingja.higo.activity.LoginActivity;
import com.kingja.higo.activity.MsgActivity;
import com.kingja.higo.activity.OrderActivity;
import com.kingja.higo.activity.PersonalActivity;
import com.kingja.higo.activity.SettingActivity;
import com.kingja.higo.activity.WalletActivity;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_mine_setting)
    ImageView ivMineSetting;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_mine;
    }


    @OnClick({R.id.iv_mine_setting, R.id.rl_mine_wallet, R.id.rl_mine_discount, R.id.rl_mine_frined, R.id
            .rl_mine_order, R.id.rl_mine_msg, R.id.ll_mine_personal, R.id.iv_mine_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_mine_setting:
                GoUtil.goActivity(getActivity(), SettingActivity.class);
                break;
            case R.id.rl_mine_wallet:
                GoUtil.goActivity(getActivity(), WalletActivity.class);
                break;
            case R.id.rl_mine_discount:
                GoUtil.goActivity(getActivity(), DiscountActivity.class);
                break;
            case R.id.rl_mine_frined:
                GoUtil.goActivity(getActivity(), FriendsActivity.class);
                break;
            case R.id.rl_mine_order:
                GoUtil.goActivity(getActivity(), OrderActivity.class);
                break;
            case R.id.rl_mine_msg:
                GoUtil.goActivity(getActivity(), MsgActivity.class);
                break;
            case R.id.ll_mine_personal:
                GoUtil.goActivity(getActivity(), LoginActivity.class);
                break;
            case R.id.iv_mine_head:
                GoUtil.goActivity(getActivity(), PersonalActivity.class);
                break;
            default:
                break;
        }
    }

}
