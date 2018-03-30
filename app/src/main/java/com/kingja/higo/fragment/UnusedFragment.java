package com.kingja.higo.fragment;

import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.UnusedAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/2/4 15:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class UnusedFragment extends BaseFragment {
    @BindView(R.id.lv_unused)
    ListView lv_unused;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        UnusedAdapter mUnusedAdapter = new UnusedAdapter(getActivity(), new ArrayList<String>());
        lv_unused.setAdapter(mUnusedAdapter);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_unused;
    }
}
