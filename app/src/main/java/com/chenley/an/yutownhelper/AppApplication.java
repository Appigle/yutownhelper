package com.chenley.an.yutownhelper;

import android.support.multidex.MultiDexApplication;

import com.chenley.an.yutownhelper.utils.MyCrashHandler;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/7/10
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/7/10         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class AppApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MyCrashHandler crashHandler = MyCrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}