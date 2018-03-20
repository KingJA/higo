package com.kingja.popsir;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListPop extends PopupWindow implements PopupWindow.OnDismissListener {
    private Context context;

    public ListPop(Builder builder) {
        super(builder.context);
        this.context = builder.context;
        setWidth(builder.width);
        setHeight(builder.height);
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(builder.touchable);
        setAnimationStyle(builder.animationStyle);
        View view = View.inflate(builder.context, R.layout.pop, null);
        ListView lv_pop = view.findViewById(R.id.lv_pop);
        lv_pop.setAdapter(builder.adapter);
        setContentView(view);
        setOnDismissListener(this);
    }

    @Override
    public void onDismiss() {
        setAlpha(1f);
    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
        setAlpha(0.7f);
    }

    private void setAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) context).getWindow().setAttributes(lp);

    }

    public static class Builder {
        private int width = ViewGroup.LayoutParams.MATCH_PARENT;
        private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        private int animationStyle = R.style.PopupTopAnimation;
        private boolean touchable = true;
        private BaseAdapter adapter;
        private Context context;
        private int maxHeight;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setPopWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setPopHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setPopAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public Builder setPopAdapter(BaseAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public Builder setPopOutsideTouchable(boolean touchable) {
            this.touchable = touchable;
            return this;
        }

        public Builder setPopMaxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }


        public ListPop build() {
            return new ListPop(this);
        }


    }
}
