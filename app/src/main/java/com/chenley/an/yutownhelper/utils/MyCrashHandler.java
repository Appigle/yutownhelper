package com.chenley.an.yutownhelper.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

import de.greenrobot.event.EventBus;

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
public class MyCrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "MyCrashHandler==";
    private static final String CRASHAPP = "APP is Crashed...";
    private Context context;
    private static MyCrashHandler myCrashHandler;
    //设备硬件和Exception信息
    private String phoneAndExceptionInfo;

    private MyCrashHandler() {

    }
    //单例设计模式
    public synchronized static MyCrashHandler getInstance() {
        if (myCrashHandler == null) {
            myCrashHandler = new MyCrashHandler();
        }
        return myCrashHandler;
    }

    //对其进行初始化，后面获取应用相关信息需要使用到上下文
    public void init(Context context) {
        this.context = context;
        //获取到当前线程，设置未捕获异常的处理
        Thread.currentThread().setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        handleException(ex);//处理异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                EventBus.getDefault().post(CRASHAPP);
                Looper.loop();
            }
        }.start();
    }


    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private void handleException(Throwable ex) {
        phoneAndExceptionInfo = getPhoneAndExcepitonInfo(ex);
        Log.i(TAG, "handleException: "+phoneAndExceptionInfo);
        upload(ex);
        store(ex);
    }

    /**
     * 获取硬件和异常信息
     * @param ex
     * @return
     */
    private String getPhoneAndExcepitonInfo(Throwable ex){
        //1.获取应用程序版本信息
        StringBuilder sb = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            String versionName = info.versionName;
            sb.append("程序版本号为:" + versionName);
            sb.append("\n");
            //2.获取手机硬件信息
            Build build = new Build();//手机硬件信息封装在Builde中，通过反射获取其字段，包括私有 暴力破解
            Field[] fields = build.getClass().getDeclaredFields();
            for (int i = 1; i < fields.length; i++) {
                //暴力访问
                fields[i].setAccessible(true);
                String name = fields[i].getName();
                String value = fields[i].get(null).toString();
                sb.append(name + " = " + value);
                sb.append("\n");
            }
            //3.获取异常报错信息
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String errorInfo = sw.toString();
            sb.append(errorInfo);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 本地保存错误信息
     * @param ex
     */
    private void store(Throwable ex) {
    }

    /**
     * 上传错误信息到服务器
     * @param ex
     */
    private void upload(Throwable ex) {

    }
}
