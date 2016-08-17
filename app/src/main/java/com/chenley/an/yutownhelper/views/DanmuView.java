package com.chenley.an.yutownhelper.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/5/20
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/5/20         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class DanmuView extends LinearLayout {
    RoundedImageView mImageView;
    TextView mTextView;

    public DanmuView(Context context) {
        this(context, null);
    }

    public DanmuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DanmuView(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.hongbao_tanmu_item, this, true);
        mImageView = (RoundedImageView) findViewById(R.id.rv_avatar);
        mTextView = (TextView) findViewById(R.id.txt_content);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
