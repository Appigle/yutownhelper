package com.chenley.an.yutownhelper.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/7/13
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/7/13         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class SignInDayCountProgressBar extends ProgressBar {
    public SignInDayCountProgressBar(Context context) {
        super(context);
    }

    public SignInDayCountProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SignInDayCountProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}