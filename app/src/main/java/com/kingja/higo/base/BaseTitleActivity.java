package com.kingja.higo.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingja.higo.R;
import com.kingja.higo.injector.component.AppComponent;

import butterknife.ButterKnife;

/**
 * Description：TODO
 * Create Time：2017/3/20 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseTitleActivity extends BaseActivity {

    protected View rootView;


    @Override
    public View getContentId() {
        rootView = View.inflate(this, R.layout.activity_title, null);
        FrameLayout flContent = rootView.findViewById(R.id.fl_content);
        TextView tvTitleTitle = rootView.findViewById(R.id.tv_title_title);
        LinearLayout llTitleBack = rootView.findViewById(R.id.ll_title_back);
        tvTitleTitle.setText(getContentTitle() == null ? "" : getContentTitle());
        llTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        View content = View.inflate(this, getContentView(), null);
        if (content != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            flContent.addView(content, params);
            ButterKnife.bind(this, rootView);
            // register after ButterKnife.bind()

        }
        return rootView;
    }

    public void setMenuRes(int resId, View.OnClickListener onClickListener) {
        LinearLayout llTitleMenu = rootView.findViewById(R.id.ll_title_menu);
        llTitleMenu.setVisibility(View.VISIBLE);
        llTitleMenu.setOnClickListener(onClickListener);
        ImageView ivMenu = rootView.findViewById(R.id.iv_menu);
        ivMenu.setBackgroundResource(resId);
    }

    @Override
    public abstract void initVariable();

    @Override
    protected abstract void initComponent(AppComponent appComponent);


    protected abstract String getContentTitle();

    protected abstract int getContentView();

    @Override
    protected abstract void initView();

    @Override
    protected abstract void initData();

    @Override
    protected abstract void initNet();


}
