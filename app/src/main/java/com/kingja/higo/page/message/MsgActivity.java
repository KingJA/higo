package com.kingja.higo.page.message;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.activity.MsgDetailActivity;
import com.kingja.higo.adapter.MsgAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.callback.EmptyCallback;
import com.kingja.higo.callback.EmptyMsgCallback;
import com.kingja.higo.callback.LoadingCallback;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.model.entiy.Message;
import com.kingja.higo.util.GoUtil;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnItemClick;

/**
 * Description:TODO
 * Create Time:2018/2/26 14:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MsgActivity extends BaseTitleActivity implements MessageContract.View {
    @BindView(R.id.lv_msg)
    ListView lvMsg;
    @Inject
    MessagePresenter messagePresenter;
    private MsgAdapter mMsgAdapter;
    private List<Message> messages = new ArrayList<>();
    private LoadService loadService;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {
        DaggerMessageCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
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
        messagePresenter.attachView(this);
        mMsgAdapter = new MsgAdapter(this, messages);
        lvMsg.setAdapter(mMsgAdapter);
        loadService = LoadSir.getDefault().register(lvMsg, (Callback.OnReloadListener) v -> initNet());
    }

    @OnItemClick(R.id.lv_msg)
    public void itemClick(AdapterView<?> parent, View view, int position, long id) {
        GoUtil.goActivity(MsgActivity.this, MsgDetailActivity.class);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {
//        messagePresenter.getMessage();
        loadService.showCallback(EmptyMsgCallback.class);
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
    public void onGetMessageSuccess(List<Message> messages) {
        Logger.e("消息数" + messages.size());
        if (messages.size() == 0) {
            loadService.showCallback(EmptyMsgCallback.class);
        } else {
            loadService.showSuccess();
            mMsgAdapter.setData(messages);
        }
    }
}
