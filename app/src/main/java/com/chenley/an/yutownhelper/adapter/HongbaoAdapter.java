package com.chenley.an.yutownhelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.viewholder.HongbaoViewHolder;
import com.orhanobut.logger.Logger;

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
public class HongbaoAdapter extends BaseRecyclerViewAdapter<String> {
    private List<String> strs = new ArrayList<>();


    public HongbaoAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Logger.i(TAG, "onCreateViewHolder: ---" + parent.toString());
        View v = mLayoutInflater.inflate(R.layout.qianghongbao_layout, parent, false);
        HongbaoViewHolder mHongbaoViewHolder = new HongbaoViewHolder(v);
        return mHongbaoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Logger.i(TAG, "onBindViewHolder: pos=" + position);
        ((HongbaoViewHolder) holder).bindViewData(getItemData(position));
        holder.getLayoutPosition();
    }
}
