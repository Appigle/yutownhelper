package com.chenley.an.yutownhelper;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenley.an.yutownhelper.Activity.PopwinUIActivity;
import com.chenley.an.yutownhelper.Activity.ReboundActivity;
import com.chenley.an.yutownhelper.Activity.ScreenPrintActivity;
import com.chenley.an.yutownhelper.Activity.ShowHuaDongHongbaoActivity;
import com.chenley.an.yutownhelper.Activity.ShowTextViewActivity;
import com.chenley.an.yutownhelper.Activity.SlideImageActivity;
import com.chenley.an.yutownhelper.bean.PayId_bean;
import com.google.gson.Gson;

import java.math.BigDecimal;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity==";
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;
    @Bind(R.id.button6)
    Button button6;
    @Bind(R.id.button7)
    Button button7;
    @Bind(R.id.btn_pb)
    Button button8;
    @Bind(R.id.button9)
    Button button9;
    @Bind(R.id.button10)
    Button button10;
    @Bind(R.id.button11)
    Button button11;
    @Bind(R.id.button12)
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.textView, R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.btn_pb, R.id.button9, R.id.button10, R.id.button11, R.id.button12})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.button:
                startActivity(new Intent(MainActivity.this, PopwinUIActivity.class));
                finish();
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, SlideImageActivity.class));
                finish();
                break;
            case R.id.button3:
                startActivity(new Intent(MainActivity.this, ShowTextViewActivity.class));
                finish();
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this, ShowHuaDongHongbaoActivity.class));
                finish();
                break;
            case R.id.button5:
                Gson gson = new Gson();
                String json = "{\"success\":true,\"data\":{\"return_code\":\"SUCCESS\",\"" +
                        "return_msg\":\"OK\",\"appid\":\"wxb2f356b839e48470\",\"mch_id\":\"" +
                        "1342847001\",\"nonce_str\":\"l3YDFbU10dtOhuXn\",\"sign\":\"9140F0" +
                        "D9C1B14F05EA41159906C859B2\",\"result_code\":\"SUCCESS\",\"prepay_id\":" +
                        "\"wx20160523201311d36bf9d88c0905327340\",\"trade_type\":\"APP\",\"o" +
                        "rder_no\":\"YT201605232013102748\"}}";
                PayId_bean pd = gson.fromJson(json, PayId_bean.class);
                Log.i(TAG, "onClick: pd=" + pd.toString());

                break;
            case R.id.button6:
                String d1 = "111.00011112";
                String d2 = "119.0002";
                String d3 = "1.2";
                String d4 = "11.002";
                BigDecimal b1 = new BigDecimal(d1);
                BigDecimal b2 = new BigDecimal(d2);
                BigDecimal b3 = new BigDecimal(d3);
                BigDecimal b4 = new BigDecimal(d4);
                int i = 5;
                String r = b1.add(b2) + "";
                Log.i(TAG, "onClick: r=" + r);
                String r2 = b1.add(new BigDecimal(i)) + "";
                Log.i(TAG, "onClick: r=" + r2);
                break;
            case R.id.button7: //获取屏幕截图
                startActivity(new Intent(MainActivity.this, ScreenPrintActivity.class));
                break;
            case R.id.btn_pb:
                break;
            case R.id.button9:
                PackageManager packManager = getPackageManager();
                Intent resolveIntent = packManager.getLaunchIntentForPackage("air.tv.douyu.android");// 这里的packname就是从上面得到的目标apk的包名
                resolveIntent.putExtra("douyutv", "494066");
                Log.i(TAG, "onClick: resolveIntent=" + (resolveIntent == null));
                // 启动目标应用
                startActivity(resolveIntent);
                break;
            case R.id.button10:
                startActivity(new Intent(MainActivity.this,ReboundActivity.class));
                break;
            case R.id.button11:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            case R.id.button12:
                break;
        }
    }
}
