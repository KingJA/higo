package com.kingja.higo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kingja.higo.R;
import com.kingja.higo.adapter.TicketPriceAdapter;
import com.kingja.higo.base.BaseFragment;
import com.kingja.higo.injector.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description:TODO
 * Create Time:2018/3/29 10:49
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class TicketPriceFragment extends BaseFragment {
    @BindView(R.id.lv_ticket_price)
    ListView lvTicketPrice;
    Unbinder unbinder;

    public static TicketPriceFragment getInstance(String date) {
        Bundle args = new Bundle();
        args.putString("date", date);
        TicketPriceFragment fragment = new TicketPriceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initVariable() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String date = bundle.get("date").toString();
            Log.d(TAG, date);
        }
    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViewAndListener() {
        TicketPriceAdapter mTicketPriceAdapter = new TicketPriceAdapter(getActivity(), new ArrayList<String>());
        lvTicketPrice.setAdapter(mTicketPriceAdapter);
//        View listItem = mTicketPriceAdapter.getView(0, null, lvTicketPrice);
//        listItem.measure(0, 0);
//        int itemHeight = listItem.getMeasuredHeight();
//        ViewGroup.LayoutParams lp = lvTicketPrice.getLayoutParams();
//        lp.height = itemHeight * 3;
//        lvTicketPrice.setLayoutParams(lp);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected int getContentId() {
        return R.layout.frag_ticket_price;
    }

}
