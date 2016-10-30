package com.chenley.an.yutownhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.chenley.an.yutownhelper.adapter.SuperViewAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity==";

    @Bind(R.id.super_view)
    SuperRecyclerView superView;
    private SuperViewAdapter mAdapter;//适配器
    private List<String> itemList = new ArrayList<>();//列表数据集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 初始化View数据
     */
    private void initView() {
        mAdapter = new SuperViewAdapter(this);
        superView.setLayoutManager(new LinearLayoutManager(this));
        superView.setAdapter(mAdapter);
    }

    /**
     * 初始化列表数据
     */
    private void initData() {
        itemList.add("进入到下一个MainActivity");
        itemList.add("测试菜单显示Activity");
        itemList.add("Fragment测试Activity");
        itemList.add("FragmentWithViewPagerActivity");
        itemList.add("正则表达式Test");
        itemList.add("横竖屏切换生命周期展示");
        itemList.add("ActionBarApiActivity");
        itemList.add("NotificationDemosActivity");
        itemList.add("垂直滚动循环消息");
        itemList.add("ScrollView嵌套RecyclerView的显示及滑动");
        itemList.add("RxJava知识点");
        itemList.add("基础算法知识");
        itemList.add("MVP IN ANDROID");
        itemList.add("一个类调用继承父类和实现接口中的同名方法问题");
        itemList.add("AIDLsample");
        itemList.add("WebViewDemo");
        itemList.add("CoordinatorLayoutSample");
        mAdapter.addItems(itemList);
    }
}
