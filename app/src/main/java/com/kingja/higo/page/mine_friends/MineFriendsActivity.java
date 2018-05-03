package com.kingja.higo.page.mine_friends;

import android.view.View;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.activity.ContactsActivity;
import com.kingja.higo.adapter.FriendsAdapter;
import com.kingja.higo.adapter.MsgAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.callback.EmptyMsgCallback;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.model.entiy.Friend;
import com.kingja.higo.model.entiy.Message;
import com.kingja.higo.page.message.DaggerMessageCompnent;
import com.kingja.higo.page.message.MessagePresenter;
import com.kingja.higo.util.GoUtil;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/2/26 10:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MineFriendsActivity extends BaseTitleActivity implements MineFriendsContract.View {
    @BindView(R.id.lv_friends)
    ListView lvFriends;

    @Inject
   MineFriendsPresenter mineFriendsPresenter;
    private FriendsAdapter friendsAdapter;
    private List<Friend> friends = new ArrayList<>();
    private LoadService loadService;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {
        DaggerMineFriendsCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
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
        mineFriendsPresenter.attachView(this);
        friendsAdapter = new FriendsAdapter(this, friends);
        lvFriends.setAdapter(friendsAdapter);
        loadService = LoadSir.getDefault().register(lvFriends, (Callback.OnReloadListener) v -> initNet());
    }

    @Override
    public void initData() {
        setMenuRes(R.mipmap.bg_add, v -> GoUtil.goActivity(MineFriendsActivity.this,ContactsActivity.class));
    }

    @Override
    protected void initNet() {
        mineFriendsPresenter.getMineFriends();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGetMineFriendsSuccess(List<Friend> friends) {
        if (friends.size() == 0) {
            loadService.showCallback(EmptyMsgCallback.class);
        } else {
            loadService.showSuccess();
            friendsAdapter.setData(friends);
        }
    }
}
