package com.chenley.an.yutownhelper.assist;

import android.util.Log;

import com.chenley.an.yutownhelper.iinterface.ISameNameInterface;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/9/24
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/9/24         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class SameNameQuestion extends SameNameSuperClass implements ISameNameInterface {
    private static final String TAG = "SameNameQuestion==";

    @Override
    public void outPut() {
        super.outPut();
        Log.i(TAG, "outPut: extends SameNameSuperClass implements ISameNameInterface");
    }
}