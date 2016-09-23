package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TranslusentActivity extends AppCompatActivity {

    @Bind(R.id.iv_img)
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translusent);
        ButterKnife.bind(this);

        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
