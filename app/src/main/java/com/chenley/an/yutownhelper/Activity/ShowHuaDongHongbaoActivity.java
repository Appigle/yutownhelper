package com.chenley.an.yutownhelper.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.adapter.HongbaoAdapter;
import com.chenley.an.yutownhelper.tanmu.AnimationHelper;
import com.chenley.an.yutownhelper.tanmu.ScreenUtils;
import com.chenley.an.yutownhelper.tanmu.TanmuBean;
import com.chenley.an.yutownhelper.views.DanmuView;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowHuaDongHongbaoActivity extends AppCompatActivity {
    @Bind(R.id.recycle_view)
    SuperRecyclerView recycleView;
    private static final String TAG = "ShowHongbaoActivity=";

    private HongbaoAdapter mHongbaoAdapter;
    private GridLayoutManager mGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;

    private MyHandler handler;
    private Handler handler2 = new Handler();


    //弹幕内容
    private TanmuBean tanmuBean;
    //放置弹幕内容的父组件
    private RelativeLayout containerVG;

    //父组件的高度
    private int validHeightSpace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hua_dong_hongbao);
        ButterKnife.bind(this);
//        recycleView = (SuperRecyclerView) findViewById(R.id.recycle_view);
        mGridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mHongbaoAdapter = new HongbaoAdapter(this);
        recycleView.setLayoutManager(mGridLayoutManager);
        recycleView.setAdapter(mHongbaoAdapter);
        recycleView.getSwipeToRefresh().setRefreshing(true);
        List<String> add = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            add.add("xx" + i);
        }
        mHongbaoAdapter.addItems(add);
        recycleView.setOnMoreListener(new OnMoreListener() { //滚动监听（触发滚动就回调）
            @Override
            public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                Log.d(TAG, "onMoreAsked() called with: " + "overallItemsCount = [" + overallItemsCount + "], itemsBeforeMore = [" + itemsBeforeMore + "], maxLastVisiblePosition = [" + maxLastVisiblePosition + "]");
            }
        });
        recycleView.setupMoreListener(new OnMoreListener() {//滚动到最后触发监听
            @Override
            public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                onDataMore();
            }
        }, 1);
        recycleView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {//刷新监听
            @Override
            public void onRefresh() {
                onDataRefresh();
            }
        });
        recycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(TAG, "onScrollStateChanged() called with: " + "recyclerView = [" + recyclerView + "], newState = [" + newState + "]");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.d(TAG, "onScrolled() called with: " + "recyclerView = [" + recyclerView + "], dx = [" + dx + "], dy = [" + dy + "]");
            }
        });

        containerVG = (RelativeLayout) findViewById(R.id.tanmu_container);
        tanmuBean = new TanmuBean();
        final String[] strs = new String[]{"测试一下", "弹幕这东西真不好做啊", "总是出现各种问题~~", "也不知道都是为什么？麻烦！", "哪位大神可以帮帮我啊？", "I need your help.",
                "测试一下", "弹幕这东西真不好做啊", "总是出现各种问题~~", "也不知道都是为什么？麻烦！", "哪位大神可以帮帮我啊？", "I need your help.",
                "测试一下", "弹幕这东西真不好做啊", "总是出现各种问题~~", "也不知道都是为什么？麻烦！", "哪位大神可以帮帮我啊？", "I need your help."};

        tanmuBean.setItems(strs);
        handler = new MyHandler(this);
        new Thread(new CreateTanmuThread()).start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new Thread(new CreateTanmuThread()).start();
                handler.postDelayed(this, strs.length*2000);
                Log.i(TAG, "run: 运行了");
            }
        }, strs.length*2000);

        //开始弹幕
        View startTanmuView = findViewById(R.id.startTanmu);
        startTanmuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (containerVG.getChildCount() > 0) {
                    return;
                }

                existMarginValues.clear();
                new Thread(new CreateTanmuThread()).start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Thread(new CreateTanmuThread()).start();
                        handler.postDelayed(this, 2000);
                        Log.i(TAG, "run: 运行了");
                    }
                }, 2000);
            }
        });
    }

    private void onDataRefresh() {
        mHongbaoAdapter.clearAllItems();
        List<String> add = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            add.add("c" + i);
        }
        mHongbaoAdapter.addItems(add);

    }

    private void onDataMore() {
        List<String> add = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            add.add("b" + i);
        }
        mHongbaoAdapter.addItems(add);
        recycleView.setLoadingMore(false);
       /* runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    recycleView.setLoadingMore(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });*/
    }

    //每2s自动添加一条弹幕
    private class CreateTanmuThread implements Runnable {
        @Override
        public void run() {
            int N = tanmuBean.getItems().length;
            for (int i = 0; i < N; i++) {
                handler.obtainMessage(1, i, 0).sendToTarget();
                SystemClock.sleep(2000);
            }
        }
    }

    //需要在主线城中添加组件
    private static class MyHandler extends Handler {
        private WeakReference<ShowHuaDongHongbaoActivity> ref;

        MyHandler(ShowHuaDongHongbaoActivity ac) {
            ref = new WeakReference<>(ac);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                ShowHuaDongHongbaoActivity ac = ref.get();
                if (ac != null && ac.tanmuBean != null) {
                    int index = msg.arg1;
                    String content = ac.tanmuBean.getItems()[index];
                    float textSize = (float) (ac.tanmuBean.getMinTextSize() * (1 + Math.random() * ac.tanmuBean.getRange()));
                    int textColor = ac.tanmuBean.getColor();
                    ac.showTanmu2(content, textSize, textColor);
                }
            }
        }
    }

    private void showTanmu(String content, float textSize, int textColor) {
        final TextView textView = new TextView(this);
        textView.setTextSize(textSize);
        textView.setText(content);
        textView.setSingleLine();
        textView.setTextColor(textColor);

        int leftMargin = containerVG.getRight() - containerVG.getLeft() - containerVG.getPaddingLeft();
        //计算本条弹幕的topMargin(随机值，但是与屏幕中已有的不重复)
        int verticalMargin = getRandomTopMargin();
        textView.setTag(verticalMargin);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.topMargin = verticalMargin;
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);

        Animation anim = AnimationHelper.createTranslateAnim(this, leftMargin, -ScreenUtils.getScreenW(this));
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //移除该组件
                containerVG.removeView(textView);
                //移除占位
                int verticalMargin = (int) textView.getTag();
                existMarginValues.remove(verticalMargin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(anim);

        containerVG.addView(textView);
    }

    private void showTanmu2(String content, float textSize, int textColor) {

        final DanmuView dv = new DanmuView(this);

        int leftMargin = containerVG.getRight() - containerVG.getLeft() - containerVG.getPaddingLeft();
        //计算本条弹幕的topMargin(随机值，但是与屏幕中已有的不重复)
        int verticalMargin = getRandomTopMargin();
        dv.setTag(verticalMargin);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.topMargin = verticalMargin;
        dv.setLayoutParams(params);

        Animation anim = AnimationHelper.createTranslateAnim(this, leftMargin, -ScreenUtils.getScreenW(this));
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //移除该组件
                containerVG.removeView(dv);
                //移除占位
                int verticalMargin = (int) dv.getTag();
                existMarginValues.remove(verticalMargin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        dv.startAnimation(anim);

        containerVG.addView(dv);
    }

    //记录当前仍在显示状态的弹幕的位置（避免重复）
    private Set<Integer> existMarginValues = new HashSet<>();
    private int linesCount;

    private int getRandomTopMargin() {
        //计算用于弹幕显示的空间高度
        if (validHeightSpace == 0) {
            validHeightSpace = containerVG.getBottom() - containerVG.getTop()
                    - containerVG.getPaddingTop() - containerVG.getPaddingBottom();
        }

        //计算可用的行数
        if (linesCount == 0) {
            linesCount = validHeightSpace / ScreenUtils.dp2px(this, tanmuBean.getMinTextSize() * (1 + tanmuBean.getRange()));
            if (linesCount == 0) {
                throw new RuntimeException("Not enough space to show text.");
            }
        }

        //检查重叠
        while (true) {
            int randomIndex = (int) (Math.random() * linesCount);
            int marginValue = randomIndex * (validHeightSpace / linesCount);

            if (!existMarginValues.contains(marginValue)) {
                existMarginValues.add(marginValue);
                return marginValue;
            }
        }
    }
}
