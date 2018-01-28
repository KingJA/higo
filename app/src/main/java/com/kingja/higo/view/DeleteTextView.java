package com.kingja.higo.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Description:TODO
 * Create Time:2018/1/27 20:18
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class DeleteTextView extends AppCompatTextView {

    private int mAdditionalPadding;

    public DeleteTextView(Context context) {
        super(context);
        init();
    }

    public DeleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPaintFlags(getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}