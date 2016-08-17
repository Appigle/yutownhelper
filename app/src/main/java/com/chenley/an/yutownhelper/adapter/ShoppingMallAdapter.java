package com.chenley.an.yutownhelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.viewHolder.ShoppingMallViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/7/6
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/7/6         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class ShoppingMallAdapter extends BaseRecyclerViewAdapter<String> {

    public ShoppingMallAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.shopping_product_item, parent, false);
        ShoppingMallViewHolder mShoppingMallViewHolder = new ShoppingMallViewHolder(view);
        return mShoppingMallViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ShoppingMallViewHolder) {
            List<String> data = new ArrayList<String>();
            ((ShoppingMallViewHolder) (holder)).bindViewData(data);
        }
    }
}