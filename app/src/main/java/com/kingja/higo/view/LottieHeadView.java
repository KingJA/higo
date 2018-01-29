package com.kingja.higo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.kingja.higo.R;
import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;

/**
 * Description:TODO
 * Create Time:2018/1/29 17:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LottieHeadView extends LinearLayout implements IHeaderView {

    private LottieAnimationView animation_view;

    public LottieHeadView(Context context) {
        this(context, null);
    }

    public LottieHeadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LottieHeadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View rootView = View.inflate(getContext(), R.layout.pull_head, null);
        animation_view = rootView.findViewById(R.id.animation_view);
        addView(rootView);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        animation_view.setProgress(fraction);

    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {
        animEndListener.onAnimEnd();
    }

    @Override
    public void reset() {

    }
}
