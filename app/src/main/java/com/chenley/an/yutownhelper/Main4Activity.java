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

public class Main4Activity extends AppCompatActivity {
    private static final String TAG = "Main4Activity==";


    @Bind(R.id.super_view)
    SuperRecyclerView superView;
    private SuperViewAdapter mAdapter;//适配器
    private List<String> itemList = new ArrayList<>();//列表数据集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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
        itemList.add("测试乐视手机上下文菜单显示Activity");
        mAdapter.addItems(itemList);
    }

}
