package com.kingja.higo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.kingja.higo.R;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2018/1/22 16:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class UnusedAdapter extends BaseLvAdapter<String> {
    public UnusedAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View simpleGetView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View
                    .inflate(context, R.layout.item_unused, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return 27;
    }

    public class ViewHolder {
        public final View root;

        public ViewHolder(View root) {
            this.root = root;
        }
    }
}
