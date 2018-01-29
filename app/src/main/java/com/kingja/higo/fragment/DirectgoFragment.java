package com.kingja.higo.fragment;

import android.os.Handler;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.DirectgoAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.util.ToastUtil;
import com.kingja.higo.view.LottieHeadView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DirectgoFragment extends BaseFragment {
    @BindView(R.id.lv_direct)
    ListView lvDirect;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        DirectgoAdapter mDirectgoAdapter = new DirectgoAdapter(getActivity(), new ArrayList<String>());
        lvDirect.setAdapter(mDirectgoAdapter);
        refreshLayout.setHeaderView(new LottieHeadView(getActivity()));
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onPullDownReleasing(final TwinklingRefreshLayout refreshLayout, float fraction) {
                ToastUtil.showText("加载网络");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                        ToastUtil.showText("结束");
                    }
                },2000);
            }
        });

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_xigo_direct;
    }

}
