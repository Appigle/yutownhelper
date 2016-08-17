package com.chenley.an.yutownhelper.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/7/20
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/7/20         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class CustomGradeView extends LinearLayout {
    private String gradeValue = null; //具体等级值
    private TextView tv_grade_value; //等级值

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
        tv_grade_value.setText(gradeValue);
    }

    public CustomGradeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attrss = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomGradeView, defStyleAttr, 0);
        int n = attrss.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = attrss.getIndex(i);
            switch (attr) {
                case R.styleable.CustomGradeView_grade_value:
                    gradeValue = attrss.getString(attr);
                    break;
                default:
                    break;
            }
        }
        attrss.recycle();
        View view = LayoutInflater.from(context).inflate(R.layout.customtextview, this, true);
        tv_grade_value= (TextView) view.findViewById(R.id.tv_grade_value);
        tv_grade_value.setText(gradeValue);
    }

    public CustomGradeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomGradeView(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}