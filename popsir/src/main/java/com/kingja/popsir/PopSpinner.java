package com.kingja.popsir;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Description:TODO
 * Create Time:2018/3/21 9:59
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopSpinner extends View {

    private static final String TAG = "PopSpinner";
    private float textSize;
    private int textNorColor;
    private int indicatorSelColor;
    private float indicatorSzie;
    private float marginIndicator;
    private String indicatorText;
    private Paint indicatorPaint;
    private Paint textPaint;
    private int width;
    private int height;
    private int textHeight;
    private int textWidth;
    private float textBaseY;
    private float textBaseX;
    private PointF pointF1;
    private PointF pointF2;
    private PointF pointF3;
    private  int DEFAULT_TOP_BOTTOM=dp2px(4);
    private  int DEFAULT_RIGHT_LEFT=dp2px(8);


    private boolean spinnerOpened;
    private int indicatorNorColor;
    private int textSelColor;
    private OnSpinnerStatusChangedListener onSpinnerStatusChangedListener;

    public PopSpinner(Context context) {
        this(context, null);
    }

    public PopSpinner(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopSpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPopSpinner(attrs);
        initPaint();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                spinnerOpened = !spinnerOpened;
                if (onSpinnerStatusChangedListener != null) {
                    onSpinnerStatusChangedListener.setOnSpinnerStatusChanged(spinnerOpened);
                }
                invalidate();
                break;
            default:
                break;
        }

        return true;
    }

    private void initPaint() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textNorColor);
        textPaint.setTextSize(textSize);
        indicatorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        indicatorPaint.setColor(indicatorNorColor);
        indicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        indicatorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    private void initPopSpinner(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PopSpinner);
        textSize = a.getDimension(R.styleable.PopSpinner_spinner_textSize, sp2px(12));
        textNorColor = a.getColor(R.styleable.PopSpinner_spinner_textNorColor, 0xff000000);
        textSelColor = a.getColor(R.styleable.PopSpinner_spinner_textSelColor, 0xff000000);
        indicatorSelColor = a.getColor(R.styleable.PopSpinner_spinner_indicatorSelColor, 0xffff0000);
        indicatorNorColor = a.getColor(R.styleable.PopSpinner_spinner_indicatorNorColor, 0xffff0000);
        indicatorSzie = a.getDimension(R.styleable.PopSpinner_spinner_indicatorSzie, dp2px(36));
        marginIndicator = a.getDimension(R.styleable.PopSpinner_spinner_marginIndicator, dp2px(12));
        indicatorText = a.getString(R.styleable.PopSpinner_spinner_indicatorText);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        textHeight = (int) (textPaint.getFontMetrics().bottom - textPaint.getFontMetrics().top);
        textWidth = (int) textPaint.measureText(indicatorText);
        int expectWidth = (int) (textWidth + marginIndicator + indicatorSzie * 2 + getPaddingLeft() + getPaddingRight()+DEFAULT_RIGHT_LEFT*2);
        int expectHeight = (int) (Math.max(indicatorSzie, textHeight) + getPaddingTop() + getPaddingBottom()+DEFAULT_TOP_BOTTOM*2);
        setMeasuredDimension(getExpectSize(expectWidth, widthMeasureSpec), getExpectSize(expectHeight,
                heightMeasureSpec));
    }

    private int getExpectSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(size, specSize);
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        Log.e(TAG, "width: " + width + " height: " + height);
//        textBaseX = width * 0.5f - textWidth * 0.5f;
        textBaseX = getPaddingLeft()+DEFAULT_RIGHT_LEFT;
        textBaseY = height * 0.5f + (textHeight) * 0.5f - textPaint.getFontMetrics().bottom;
        Log.e(TAG, "textBaseY: " + textBaseY + " textBaseX: " + textBaseX);


    }

    public Path getIndicatorPath() {
        Path path = new Path();
        float pY;
        float pX;
        if (!spinnerOpened) {
            pY = 0.5f * height - 0.5f * indicatorSzie;
            pX = 0.5f * height + 0.5f * indicatorSzie;
            indicatorPaint.setColor(indicatorNorColor);
            textPaint.setColor(textNorColor);
        } else {
            pY = 0.5f * height + 0.5f * indicatorSzie;
            pX = 0.5f * height - 0.5f * indicatorSzie;
            indicatorPaint.setColor(indicatorSelColor);
            textPaint.setColor(textSelColor);
        }
        pointF1 = new PointF(width-getPaddingRight()-DEFAULT_RIGHT_LEFT-indicatorSzie*2, pY);
        pointF2 = new PointF(width-getPaddingRight()-DEFAULT_RIGHT_LEFT, pY);
        pointF3 = new PointF(width-getPaddingRight()-DEFAULT_RIGHT_LEFT-indicatorSzie, pX);
        path.moveTo(pointF1.x, pointF1.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(pointF3.x, pointF3.y);
        path.close();
        return path;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(getIndicatorPath(), indicatorPaint);
        canvas.drawText(indicatorText, textBaseX, textBaseY, textPaint);
    }

    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources()
                .getDisplayMetrics());
    }

    private int sp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dp, getContext().getResources()
                .getDisplayMetrics());
    }


    public void setOnSpinnerStatusChangedListener(OnSpinnerStatusChangedListener onSpinnerStatusChangedListener) {
        this.onSpinnerStatusChangedListener = onSpinnerStatusChangedListener;
    }

    public interface OnSpinnerStatusChangedListener {
        void setOnSpinnerStatusChanged(boolean opened);
    }

    public void setSelectText(String selectedText) {
        indicatorText=selectedText;
        spinnerOpened=false;
        invalidate();
    }
}
