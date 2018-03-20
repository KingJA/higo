package com.kingja.higo.activity;

import android.view.View;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.DiscountAdapter;
import com.kingja.higo.adapter.FriendsAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.GoUtil;
import com.kingja.higo.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/2/26 10:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FriendsActivity extends BaseTitleActivity {
    @BindView(R.id.lv_friends)
    ListView lvFriends;


    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "我的好友";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_mine_friends;
    }

    @Override
    protected void initView() {
        FriendsAdapter mFriendsAdapter = new FriendsAdapter(this, new ArrayList<String>());
        lvFriends.setAdapter(mFriendsAdapter);
    }

    @Override
    public void initData() {
        setMenuRes(R.mipmap.bg_add, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoUtil.goActivity(FriendsActivity.this,ContactsActivity.class);
            }
        });
    }

    @Override
    protected void initNet() {

    }
}
