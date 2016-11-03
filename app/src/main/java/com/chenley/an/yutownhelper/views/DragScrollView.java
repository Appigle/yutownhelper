package com.chenley.an.yutownhelper.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class DragScrollView extends ScrollView {
  private static final String TAG = "DragScrollView@@";

  private boolean allowDragBottom = true; //时候允许滑动到底部
  private float downY = 0; //开始触摸点的Y位置
  private boolean needConsumeTouch = true; //时候消费触摸事件
  private int maxScroll = -1; // 最大滑动距离

  public DragScrollView(Context arg0) {
    this(arg0, null);
  }

  public DragScrollView(Context arg0, AttributeSet arg1) {
    this(arg0, arg1, 0);
  }

  public DragScrollView(Context arg0, AttributeSet arg1, int arg2) {
    super(arg0, arg1, arg2);
  }

  @Override protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    if (maxScroll < 0) {
      maxScroll = computeVerticalScrollRange(); //滚动的时候计算View的整体高度，并且只计算一次
    }
    Log.i(TAG, "onScrollChanged: maxScroll=" + maxScroll);
    super.onScrollChanged(l, t, oldl, oldt);
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
      downY = ev.getRawY();
      needConsumeTouch = true;

      //是都可以滑动到View的底部判断条件：1、View的高度不为0；2、view的滚动距离+显示的高度大于等于view的最大高度-2
      if (maxScroll > 0 && getScrollY() + getMeasuredHeight() >= maxScroll - 2) {
        allowDragBottom = true;
      } else {
        allowDragBottom = false;
      }
      Log.i(TAG, "MotionEvent.ACTION_DOWN: maxScroll=" + maxScroll);
    } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
      if (!needConsumeTouch) {
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      } else if (allowDragBottom) {
        if (downY - ev.getRawY() > 2) {
          needConsumeTouch = false;
          /**
           *  @param disallowIntercept True if the child does not want the parent to
           *            intercept touch events.
           */
          getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
      Log.i(TAG, "MotionEvent.ACTION_MOVE: maxScroll=" + maxScroll);
    }
    getParent().requestDisallowInterceptTouchEvent(needConsumeTouch);
    Log.i(TAG, "dispatchTouchEvent: maxScroll=" + maxScroll);
    return super.dispatchTouchEvent(ev);
  }
}
