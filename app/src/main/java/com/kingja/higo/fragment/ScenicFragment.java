package com.kingja.higo.fragment;

import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.ScenicAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ScenicFragment extends BaseFragment {
    @BindView(R.id.lv_scenic)
    ListView lvScenic;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        ScenicAdapter mScenicAdapter = new ScenicAdapter(getActivity(), new ArrayList<String>());
        lvScenic.setAdapter(mScenicAdapter);

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_scenic;
    }

}
