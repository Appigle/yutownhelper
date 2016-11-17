package com.chenley.an.yutownhelper.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenley.an.yutownhelper.R;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/8/11
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/8/11         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class ModelFragment extends Fragment {
    private static final String TAG = "ModelFragment==";
    //传参TAG
    public static final String PARAM1 = "param1";
    public static final String PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    //生命周期展示
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListenr = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implements OnFragmentInteractionListener");
        }
        Log.d(TAG, "onAttach() called with: " + "context = [" + context + "]");
    }

    //onCreate方法中获取参数
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(PARAM1);
            mParam2 = getArguments().getString(PARAM2);
        }
    }

    //重写填充视图View的方法  填充布局文件
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called with: " + "");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called with: " + "");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called with: " + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView() called with: " + "");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called with: " + "");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //释放监听
        onFragmentInteractionListenr = null;
        Log.d(TAG, "onDetach() called with: " + "");
    }

    //构造函数
    public ModelFragment() {
    }

    //静态实例化方法
    public static ModelFragment newInstance(String param1, String param2) {
        ModelFragment modelFragment = new ModelFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM1, param1);
        bundle.putString(PARAM2, param2);
        modelFragment.setArguments(bundle);
        return modelFragment;
    }

    //回调方法
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    //声明接口变量
    private OnFragmentInteractionListener onFragmentInteractionListenr;

    //提供回调的设置方法
    public void setOnFragmentInteractionLister(OnFragmentInteractionListener onFragmentInteractionListenr) {
        this.onFragmentInteractionListenr = onFragmentInteractionListenr;
    }

    //事件触发  用来跟Activity之间通信
    public void onEventAction(Uri uri) {
        if (onFragmentInteractionListenr != null) {
            onFragmentInteractionListenr.onFragmentInteraction(uri);
        }
    }
}