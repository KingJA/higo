package com.kingja.popsir;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Description:TODO
 * Create Time:2018/3/17 14:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListPop extends BasePop {

    public ListPop(PopConfig popConfig) {
        super(popConfig);
    }

    @Override
    protected void initPop() {
        if (popConfig.animationStyle == -1) {
            setAnimationStyle(R.style.PopupTopAnimation);
        }
    }

    @Override
    public void initView(View contentView) {
        contentView.setBackgroundColor(0xffffffff);
    }

    public <T> ListPop setOnItemClickListener(final OnItemClickListener<T> onItemClickListener) {
        ((ListView) getContentView()).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T item = (T) parent.getItemAtPosition(position);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item, position);
                }
                dismiss();
            }
        });
        return this;
    }

    public interface OnItemClickListener<T> {
        public void onItemClick(T item, int position);
    }

    public ListPop setAdapter(BaseAdapter adapter) {
        ((ListView) getContentView()).setAdapter(adapter);
        ((ListView) getContentView()).setDividerHeight(1);
        return this;
    }

    @Override
    public View getLayoutView() {

        return new ListView(context);
    }
}
