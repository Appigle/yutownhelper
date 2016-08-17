package com.chenley.an.yutownhelper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chenley.an.yutownhelper.Activity.AmapGaodeLocationActivity;
import com.chenley.an.yutownhelper.Activity.AnimationActivity;
import com.chenley.an.yutownhelper.Activity.CustomTextViewActivity;
import com.chenley.an.yutownhelper.Activity.DateCalActivity;
import com.chenley.an.yutownhelper.Activity.PbAct;
import com.chenley.an.yutownhelper.Activity.ShoppingMallPageActivity;
import com.chenley.an.yutownhelper.Activity.TranslusentActivity;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class Main2Activity extends Activity {
    private static final String TAG = "Main2Activity==";
    private static final String CRASHAPP = "APP is Crashed...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.textView, R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.btn_pb, R.id.button9, R.id.button10, R.id.button11, R.id.button12})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.button:
                startActivityForResult(new Intent(Main2Activity.this, TranslusentActivity.class), 2);
//                startActivity(new Intent(Main2Activity.this, ActivityTranslusent.class));
                Log.i(TAG, "onClick: --startActivityForResult");
                Logger.t(TAG).i("什么？", view);
                break;
            case R.id.button2:
                startActivity(new Intent(Main2Activity.this, ShoppingMallPageActivity.class));
                break;
            case R.id.button3:
                String abc = null;
                abc.equals("abc");
                break;
            case R.id.button4:
                startActivity(new Intent(Main2Activity.this, AmapGaodeLocationActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(Main2Activity.this, DateCalActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(Main2Activity.this,AnimationActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(Main2Activity.this,CustomTextViewActivity.class));
                break;
            case R.id.btn_pb:
                startActivity(new Intent(Main2Activity.this,PbAct.class));
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
            case R.id.button11:
                break;
            case R.id.button12:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(Main2Activity.this, "resultCode:" + resultCode, Toast.LENGTH_SHORT).show();
    }

    public void onEvent(String event){
        if (event.equals(CRASHAPP)) {
            new AlertDialog.Builder(this).setTitle("提示").setCancelable(false)
                        .setMessage("程序崩溃了...").setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Logger.e("退出app",TAG);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);//1:非正常退出，0：正常退出
                    }
                }).create().show();
        }
    }

}
