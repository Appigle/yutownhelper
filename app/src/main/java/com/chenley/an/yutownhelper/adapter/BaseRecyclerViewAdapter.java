package com.chenley.an.yutownhelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/5/19
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/5/19         Chenley             2.0                2.0
 * Why & What is modified:
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final String TAG = getClass().getSimpleName() + "==";
    public Context mContext;  //上下文
    protected final LayoutInflater mLayoutInflater;//布局填充类
    protected List<T> mDataList = new ArrayList<>();//数据数组管理

    public BaseRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);//实例化布局填充类
    }

    public List<T> getDataList() {
        return mDataList;
    }  //获取当前数据集合

    public T getItemData(int pos) {//获取对应下标的数据
        return pos < mDataList.size() ? mDataList.get(pos) : null;
    }

    /**
     * 移除某一条记录
     *
     * @param position 移除数据的position
     */
    public void removeItem(int position) {
        if (position < mDataList.size()) {
            mDataList.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * 在具体的位置添加一条记录
     *
     * @param data     需要加入的数据结构
     * @param position 插入位置
     */
    public void addItem(T data, int position) {
        if (position <= mDataList.size()) {
            mDataList.add(position, data);
            notifyItemInserted(position);
        }
    }

    /**
     * 添加一条数据到末尾
     *
     * @param data
     */
    public void addItem(T data) {
        addItem(data, mDataList.size());
    }

    /**
     * 清除所有数据
     */
    public void clearAllItems() {
        int size = mDataList.size();
        if (mDataList.size() > 0) {
            mDataList.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    /**
     * 添加批量数据
     *
     * @param data
     * @param postionStart
     */
    public void addItems(List<T> data, int postionStart) {
        Log.i(TAG, "addItems:"+data.toString()+"postionStart="+postionStart);
        if (postionStart <= mDataList.size() && data != null && data.size() > 0) {
            mDataList.addAll(data);
            notifyItemRangeInserted(postionStart, data.size());
        }
    }

    /**
     * 末尾批量添加数据
     *
     * @param data
     */
    public void addItems(List<T> data) {
        addItems(data, mDataList.size());
    }


    /**
     * 获取item的数量
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

}
