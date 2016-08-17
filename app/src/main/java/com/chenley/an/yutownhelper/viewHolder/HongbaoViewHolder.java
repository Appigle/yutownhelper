package com.chenley.an.yutownhelper.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chenley.an.yutownhelper.R;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

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
public class HongbaoViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "HongbaoViewHolder";
    @Bind(R.id.rv_avatar)
    RoundedImageView rvAvatar;
    @Bind(R.id.cd_up)
    CardView cdUp;

    public HongbaoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindViewData(String str){
        Log.i(TAG, "bindViewData: ---"+str);
    }

}
