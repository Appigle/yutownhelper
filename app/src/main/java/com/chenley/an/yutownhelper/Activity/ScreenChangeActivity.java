package com.chenley.an.yutownhelper.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.base.BaseActionBarActivity;

/**
 * 实际表明：在targetSDKVersion 23的时候不设置ConfigChanged属性的时候，横竖屏切换都只执行一次生命周期方法
 */
public class ScreenChangeActivity extends BaseActionBarActivity {
    private static final String TAG = "ScreenChangeActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_change);
        Log.i(TAG, "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called with: " + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called with: " + "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called with: " + "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called with: " + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called with: " + "");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged() called with: " + "newConfig = [" + newConfig + "]");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState() called with: " + "outState = [" + outState + "], outPersistentState = [" + outPersistentState + "]");
    }
}
