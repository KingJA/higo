package com.kingja.higo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.DirectgoAdapter;
import com.kingja.higo.adapter.GiftAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:TODO
 * Create Time:2018/1/22 13:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class GiftFragment extends BaseFragment {
    @BindView(R.id.gv_gift)
    GridView gvGift;

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        GiftAdapter mDirectgoAdapter = new GiftAdapter(getActivity(), new ArrayList<String>());
        gvGift.setAdapter(mDirectgoAdapter);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_gift;
    }
}
