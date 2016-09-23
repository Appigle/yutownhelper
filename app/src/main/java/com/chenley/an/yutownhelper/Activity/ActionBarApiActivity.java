package com.chenley.an.yutownhelper.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.base.BaseActionBarActivity;

public class ActionBarApiActivity extends BaseActionBarActivity {
    private static final String TAG = "ActionBarApiActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_api);
    }

    /**
     * 计算ActionBar高度
     */
    private void calActionBarHeight(Context mContext) {
        // Calculate ActionBar height
        TypedValue tv = new TypedValue();
        if (mContext.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            int actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, mContext.getResources().getDisplayMetrics());
            Log.i(TAG, "calActionBarHeight: actionBarHeight=" + actionBarHeight);
        }
        Log.i(TAG, "calActionBarHeight: ");
    }

    @Override
    protected void initActionBar() {
        super.initActionBar();
        calActionBarHeight(this);
        if (mActionBar != null) {
            mActionBar.setDisplayShowHomeEnabled(isHomeUp());//是否显示左上角返回图标
            mActionBar.setDisplayHomeAsUpEnabled(isHomeUp());//左上角图标是否可以点击
            mActionBar.setDisplayShowCustomEnabled(true);//显示自定义View
            mActionBar.setCustomView(R.layout.actionbar_custom_view01);//自定义View
            mActionBar.setTitle("我是ActionBar标题");
        }
    }
}
