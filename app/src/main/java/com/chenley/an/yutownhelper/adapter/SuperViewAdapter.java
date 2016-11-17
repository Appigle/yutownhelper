package com.chenley.an.yutownhelper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenley.an.yutownhelper.MainActivity;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.activity.ActionBarApiActivity;
import com.chenley.an.yutownhelper.activity.AlgorithmActivity;
import com.chenley.an.yutownhelper.activity.CircleShowInfoActivity;
import com.chenley.an.yutownhelper.activity.CoordinatorLayoutSampleActivity;
import com.chenley.an.yutownhelper.activity.CountDownViewActivity;
import com.chenley.an.yutownhelper.activity.DragLayoutActivity;
import com.chenley.an.yutownhelper.activity.FragmentAct.FragmentTestActivity;
import com.chenley.an.yutownhelper.activity.FragmentAct.FragmentWithViewPagerActivity;
import com.chenley.an.yutownhelper.activity.KeyIntJsonPaseActivity;
import com.chenley.an.yutownhelper.activity.NotificationDemosActivity;
import com.chenley.an.yutownhelper.activity.RegexTestActivity;
import com.chenley.an.yutownhelper.activity.RxJavaKnowledgeActivity;
import com.chenley.an.yutownhelper.activity.RxJavaWithMvpSampleActivity;
import com.chenley.an.yutownhelper.activity.SameNameQuestionActivity;
import com.chenley.an.yutownhelper.activity.ScreenChangeActivity;
import com.chenley.an.yutownhelper.activity.ScrollViewAndRecyclerViewQuestionActivity;
import com.chenley.an.yutownhelper.activity.StackOverFlowErrorSampleActivity;
import com.chenley.an.yutownhelper.activity.TestMenuActivity;
import com.chenley.an.yutownhelper.activity.WebViewDemo;
import com.chenley.an.yutownhelper.mvp.MvpSampleActivity;
import java.lang.ref.WeakReference;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/8/5
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/8/5         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class SuperViewAdapter extends BaseRecyclerViewAdapter<String> {
    private static final String TAG = "SuperViewAdapter==";

    public SuperViewAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_action_list, parent, false);
        SuperItemViewHolder mSuperItemViewHolder = new SuperItemViewHolder(view,mContext);
        return mSuperItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SuperItemViewHolder) {
            ((SuperItemViewHolder) holder).bindViewData(getItemData(position));
        }
    }

    static class SuperItemViewHolder extends RecyclerView.ViewHolder  {
        @Bind(R.id.tv_item)
        TextView tvItem;

        private WeakReference<Context> weakContext;

        SuperItemViewHolder(View view,Context mContext) {
            super(view);
            ButterKnife.bind(this, view);
            weakContext = new WeakReference<Context>(mContext);
        }

        public void bindViewData(final String itemData) {
            tvItem.setText(itemData);
            if (weakContext.get() != null) {
                final Context mContext = weakContext.get();
                tvItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i(TAG, "onClick: itemData-->"+itemData);
                        if (itemData.equals("测试菜单显示Activity")) {
                            mContext.startActivity(new Intent(mContext, TestMenuActivity.class));
                        }else if(itemData.equals("RxJavaWithMvpSampleActivity")){
                            mContext.startActivity(new Intent(mContext, RxJavaWithMvpSampleActivity.class));
                        }else if(itemData.equals("CountDownViewActivity倒计时自定义View")){
                            mContext.startActivity(new Intent(mContext, CountDownViewActivity.class));
                        }else if(itemData.equals("StackOverFlowErrorSampleActivity")){
                            mContext.startActivity(new Intent(mContext, StackOverFlowErrorSampleActivity.class));
                        }else if(itemData.equals("KeyIntJsonBean异形JSON解析")){
                            mContext.startActivity(new Intent(mContext, KeyIntJsonPaseActivity.class));
                        }else if(itemData.equals("进入到下一个MainActivity")){
                            mContext.startActivity(new Intent(mContext, MainActivity.class));
                        }else if(itemData.equals("Fragment测试Activity")){
                            mContext.startActivity(new Intent(mContext, FragmentTestActivity.class));
                        }else if(itemData.equals("FragmentWithViewPagerActivity")){
                            mContext.startActivity(new Intent(mContext, FragmentWithViewPagerActivity.class));
                        }else if(itemData.equals("正则表达式Test")){
                            mContext.startActivity(new Intent(mContext, RegexTestActivity.class));
                        }else if(itemData.equals("横竖屏切换生命周期展示")){
                            mContext.startActivity(new Intent(mContext, ScreenChangeActivity.class));
                        }else if(itemData.equals("ActionBarApiActivity")){
                            mContext.startActivity(new Intent(mContext, ActionBarApiActivity.class));
                        }else if(itemData.equals("NotificationDemosActivity")){
                            mContext.startActivity(new Intent(mContext, NotificationDemosActivity.class));
                        }else if(itemData.equals("垂直滚动循环消息")){
                            mContext.startActivity(new Intent(mContext, CircleShowInfoActivity.class));
                        }else if(itemData.equals("ScrollView嵌套RecyclerView的显示及滑动")){
                            mContext.startActivity(new Intent(mContext, ScrollViewAndRecyclerViewQuestionActivity.class));
                        }else if(itemData.equals("RxJava知识点")){
                            mContext.startActivity(new Intent(mContext, RxJavaKnowledgeActivity.class));
                        }else if(itemData.equals("基础算法知识")){
                            mContext.startActivity(new Intent(mContext, AlgorithmActivity.class));
                        }else if(itemData.equals("MVP IN ANDROID")){
                            mContext.startActivity(new Intent(mContext, MvpSampleActivity.class));
                        }else if(itemData.equals("一个类调用继承父类和实现接口中的同名方法问题")){
                            mContext.startActivity(new Intent(mContext, SameNameQuestionActivity.class));
                        }else if(itemData.equals("WebViewDemo")){
                            mContext.startActivity(new Intent(mContext, WebViewDemo.class));
                        }else if(itemData.equals("CoordinatorLayoutSample")){
                            mContext.startActivity(new Intent(mContext, CoordinatorLayoutSampleActivity.class));
                        }else if(itemData.equals("DragLayoutActivity模仿京东阻尼滑动效果")){
                            mContext.startActivity(new Intent(mContext, DragLayoutActivity.class));
                        }
                    }
                });

            }
        }
    }
}