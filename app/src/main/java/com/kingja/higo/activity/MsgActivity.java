package com.kingja.higo.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.FriendsAdapter;
import com.kingja.higo.adapter.MsgAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:TODO
 * Create Time:2018/2/26 14:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MsgActivity extends BaseTitleActivity {
    @BindView(R.id.lv_msg)
    ListView lvMsg;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "我的消息";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_mine_msg;
    }

    @Override
    protected void initView() {
        MsgAdapter mMsgAdapter = new MsgAdapter(this, new ArrayList<String>());
        lvMsg.setAdapter(mMsgAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
