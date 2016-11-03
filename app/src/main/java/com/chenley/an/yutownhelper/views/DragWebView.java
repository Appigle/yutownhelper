package com.chenley.an.yutownhelper.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class DragWebView extends WebView {

    private boolean allowDragTop = true; // 如果是true，则允许拖动至底部的下一页
    private float downY = 0; //ACTION_DWON的Y位置
    private boolean needConsumeTouch = true;//是否消费触摸事件

    public DragWebView(Context arg0) {
        this(arg0, null);
    }

    public DragWebView(Context arg0, AttributeSet arg1) {
        this(arg0, arg1, 0);
    }

    public DragWebView(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downY = ev.getRawY();//获取初始触摸Y位置
            needConsumeTouch = true;
            allowDragTop = isAtTop();//判断View是否处在屏幕顶部
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (!needConsumeTouch) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            } else if (allowDragTop) {
                if (ev.getRawY() - downY > 2) {
                    needConsumeTouch = false;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            }
        }
        getParent().requestDisallowInterceptTouchEvent(needConsumeTouch);
        return super.dispatchTouchEvent(ev);
    }

  /**
   * 根据滚动的距离判断View顶部时候在屏幕的顶部
   * @return
   */
    private boolean isAtTop() {
        return getScrollY() == 0;
    }
}
