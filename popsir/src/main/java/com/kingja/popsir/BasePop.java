package com.kingja.popsir;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BasePop extends PopupWindow implements PopupWindow.OnDismissListener {
    protected Context context;
    protected PopConfig popConfig;

    public BasePop(PopConfig popConfig) {
        super(popConfig.context);
        this.context = popConfig.context;
        this.popConfig = popConfig;
        this.setWidth(popConfig.width);
        this.setHeight(popConfig.height);
        this.setBackgroundDrawable(new ColorDrawable());
        this.setOutsideTouchable(popConfig.touchable);
        this.setAnimationStyle(popConfig.animationStyle);
        this.setOnDismissListener(this);
        this.setFocusable(true);
        setContentView(getLayoutView());
        initView(getContentView());
        initPop();
    }

    protected abstract void initPop();

    protected abstract void initView(View contentView);

    protected abstract View getLayoutView();

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

}
