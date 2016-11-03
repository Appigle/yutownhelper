package com.chenley.an.yutownhelper.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * 实现京东淘宝详情的阻尼效果，实现上下两个frameLayout拖动切换
 */
@SuppressLint("NewApi") public class DragLayout extends ViewGroup {
  private final ViewDragHelper mDragHelper;  //系统滑动帮助类
  private GestureDetectorCompat gestureDetector; //手势检测类

  /* 上下两个frameLayout，在Activity中注入fragment */
  private View frameView1, frameView2;
  private int viewHeight;//高度
  private static final int VEL_THRESHOLD = 100; // 滑动速度的阈值，超过这个绝对值认为是上下
  private static final int DISTANCE_THRESHOLD = 100; // 单位是像素，当上下滑动速度不够时，通过这个阈值来判定是应该粘到顶部还是底部
  private int downTop1; // 手指按下的时候，frameView1的getTop值
  private ShowNextPageDrag nextPageListener; // 手指松开是否加载下一页的notifier

  public DragLayout(Context context) {
    this(context, null);
  }

  public DragLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public DragLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    mDragHelper = ViewDragHelper.create(this, 10f, new DragHelperCallback());
    mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_BOTTOM);
    gestureDetector = new GestureDetectorCompat(context, new YScrollDetector());
  }

  /**
   * View视图加载完成
   */
  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    frameView1 = getChildAt(0); //为上下View赋值
    frameView2 = getChildAt(1);//为上下View赋值
  }

  /**
   * Y方向滑动距离检测类
   */
  class YScrollDetector extends SimpleOnGestureListener {

    @Override public boolean onScroll(MotionEvent e1, MotionEvent e2, float dx, float dy) {
      // 垂直滑动时dy>dx，才被认定是上下拖动
      return Math.abs(dy) > Math.abs(dx);
    }
  }

  /**
   * 计算滚动
   */
  @Override public void computeScroll() {
    if (mDragHelper.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  /**
   * 拖动回调
   */
  private class DragHelperCallback extends ViewDragHelper.Callback {

    @Override
    public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
      int childIndex = 1;
      if (changedView == frameView2) {
        childIndex = 2;
      }
      // 一个view位置改变，另一个view的位置要跟进
      onViewPosChanged(childIndex, top);
    }

    @Override public boolean tryCaptureView(View child, int pointerId) {
      // 两个子View都需要跟踪，返回true
      return true;
    }

    @Override public int getViewVerticalDragRange(View child) {
      // 这个用来控制拖拽过程中松手后，自动滑行的速度，暂时给一个随意的数值
      return 1;
    }

    @Override public void onViewReleased(View releasedChild, float xvel, float yvel) {
      // 滑动松开后，需要向上或者乡下粘到特定的位置
      animTopOrBottom(releasedChild, yvel);
    }

    @Override public int clampViewPositionVertical(View child, int top, int dy) {
      int finalTop = top;
      if (child == frameView1) {
        // 拖动的时第一个view
        if (top > 0) {
          // 不让第一个view往下拖，因为顶部会白板
          finalTop = 0;
        }
      } else if (child == frameView2) {
        // 拖动的时第二个view
        if (top < 0) {
          finalTop = 0;
        }
      }

      // finalTop代表的是理论上应该拖动到的位置。此处计算拖动的距离除以一个参数(3)，是让滑动的速度变慢。数值越大，滑动的越慢
      return child.getTop() + (finalTop - child.getTop()) / 3;
    }
  }

  /**
   * 当View位置发生变化时，刷新View显示
   */
  private void onViewPosChanged(int viewIndex, int posTop) {
    if (viewIndex == 1) {
      int offsetTopBottom = viewHeight + frameView1.getTop() - frameView2.getTop();
      frameView2.offsetTopAndBottom(offsetTopBottom);
    } else if (viewIndex == 2) {
      int offsetTopBottom = frameView2.getTop() - viewHeight - frameView1.getTop();
      frameView1.offsetTopAndBottom(offsetTopBottom);
    }
    // 有的时候会默认白板，这个很恶心。后面有时间再优化
    invalidate();
  }

  /**
   * 滑动松开后，需要向上或者乡下粘到特定的位置
   */
  private void animTopOrBottom(View releasedChild, float yvel) {
    int finalTop = 0;
    if (releasedChild == frameView1) {
      if (yvel < -VEL_THRESHOLD || (downTop1 == 0 && frameView1.getTop() < -DISTANCE_THRESHOLD)) {
        finalTop = -viewHeight;
        if (null != nextPageListener) {
          nextPageListener.onDragNext();
        }
      }
    } else {
      if (yvel > VEL_THRESHOLD || (downTop1 == -viewHeight
          && releasedChild.getTop() > DISTANCE_THRESHOLD)) {
        finalTop = viewHeight;
      }
    }
    //缓慢滑动到指定位置
    if (mDragHelper.smoothSlideViewTo(releasedChild, 0, finalTop)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  /**
   * 是否拦截触摸事件
   */
  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {

    if (frameView1.getBottom() > 0 && frameView1.getTop() < 0) {
      return false;//返回false不拦截事件
    }

    boolean yScroll = gestureDetector.onTouchEvent(ev);  //返回true，表示消费事件
    boolean shouldIntercept = mDragHelper.shouldInterceptTouchEvent(ev); //是否消费事件
    int action = ev.getActionMasked();

    if (action == MotionEvent.ACTION_DOWN) {
      mDragHelper.processTouchEvent(ev);
      downTop1 = frameView1.getTop();
    }

    return shouldIntercept && yScroll;//是否拦截事件
  }

  @Override public boolean onTouchEvent(MotionEvent e) {
    mDragHelper.processTouchEvent(e); // 该行代码可能会抛异常，正式发布时请将这行代码加上try catch
    return true;
  }

  /**
   * 计算布局
   */
  @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
    if (null == frameView1 || null == frameView2) return;
    if (frameView1.getTop() == 0) {
      frameView1.layout(l, 0, r, b - t);
      frameView2.layout(l, 0, r, b - t);

      viewHeight = frameView1.getMeasuredHeight();
      frameView2.offsetTopAndBottom(viewHeight);
    } else {
      frameView1.layout(l, frameView1.getTop(), r, frameView1.getBottom());
      frameView2.layout(l, frameView2.getTop(), r, frameView2.getBottom());
    }
  }

  /**
   * 测量
   */
  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    measureChildren(widthMeasureSpec, heightMeasureSpec);

    int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
    int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
    setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
        resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
  }

  /**
   * 获取测量策略
   * @param size
   * @param measureSpec
   * @param childMeasuredState
   * @return
   */
  public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
    int result = size;
    int specMode = MeasureSpec.getMode(measureSpec);
    int specSize = MeasureSpec.getSize(measureSpec);
    switch (specMode) {
      case MeasureSpec.UNSPECIFIED:
        result = size;
        break;
      case MeasureSpec.AT_MOST:
        if (specSize < size) {
          result = specSize | MEASURED_STATE_TOO_SMALL;
        } else {
          result = size;
        }
        break;
      case MeasureSpec.EXACTLY:
        result = specSize;
        break;
    }
    return result | (childMeasuredState & MEASURED_STATE_MASK);
  }

  /**
   * 设置下一页监听
   */
  public void setNextPageListener(ShowNextPageDrag nextPageListener) {
    this.nextPageListener = nextPageListener;
  }

  /**
   * 显示下一页接口
   */
  public interface ShowNextPageDrag {
    void onDragNext();
  }
}
