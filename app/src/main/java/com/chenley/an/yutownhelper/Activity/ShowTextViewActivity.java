package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowTextViewActivity extends AppCompatActivity {
    @Bind(R.id.txt_ceshiduowenben)
    TextView txtCeshiduowenben;
    @Bind(R.id.button21)
    Button button21;
    String longTxt = "我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n" +
            "我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n" +
            "我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n" +
            "我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。" +
            "\n" +
            "我是长文本。。。我是长文本。。。我是长文本。。。我是长文本。。。";
    String shortTxt = "我是短文本。。。\n我是短文本。。。\n我是短文本。。。\n";
    @Bind(R.id.rl_txt)
    RelativeLayout rlTxt;
    @Bind(R.id.sv_view)
    ScrollView svView;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text_view);
        ButterKnife.bind(this);
        ViewTreeObserver vto = txtCeshiduowenben.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int w = txtCeshiduowenben.getWidth();
                int h = txtCeshiduowenben.getHeight();
                Log.i(TAG, "onClick oncreate: w:" + w + "---h:" + h);
                txtCeshiduowenben.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

    }

    private static final String TAG = "ShowTextView==";

    @OnClick(R.id.button21)
    public void onClick() {
        if (count % 2 == 0) {
            txtCeshiduowenben.setText(longTxt);
            int w = txtCeshiduowenben.getWidth();
            int h = txtCeshiduowenben.getHeight();
            Log.i(TAG, "onClick长文本000没000长文本监听: w:" + w + "---h:" + h);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(Utils.dip2px(this, 200),
                    Utils.dip2px(this, 200));
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
           /* ScrollView.LayoutParams lp = new ScrollView.LayoutParams(Utils.dip2px(this, 200),
                    Utils.dip2px(this, 200));*/
            svView.setLayoutParams(lp);
            ViewTreeObserver vto = txtCeshiduowenben.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int w = txtCeshiduowenben.getWidth();
                    int h = txtCeshiduowenben.getHeight();
                    Log.i(TAG, "onClick长文本监听: w:" + w + "---h:" + h);
                    txtCeshiduowenben.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });

        } else {
            txtCeshiduowenben.setText(shortTxt);
            int w = txtCeshiduowenben.getWidth();
            int h = txtCeshiduowenben.getHeight();
            Log.i(TAG, "onClick短文本000没000短文本监听: w:" + w + "---h:" + h);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
            svView.setLayoutParams(lp);
            ViewTreeObserver vto = txtCeshiduowenben.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int w = txtCeshiduowenben.getWidth();
                    int h = txtCeshiduowenben.getHeight();
                    Log.i(TAG, "onClick短文本监听: w:" + w + "---h:" + h);
                    txtCeshiduowenben.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });

        }
        count++;
    }
}
