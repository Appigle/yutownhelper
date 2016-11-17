package com.chenley.an.yutownhelper.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.chenley.an.yutownhelper.R;
import java.util.ArrayList;
import java.util.List;

public class StackOverFlowErrorSampleActivity extends AppCompatActivity {
  private static final String TAG = "StackOverFlowError@@";
  private int memerySize;
  private String info;
  private TextView stackoverflowerror, oom_show;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.stack_over_flow_sample_layout);
    TextView get_app_allowed_memery = (TextView) findViewById(R.id.get_app_allowed_memery);
    stackoverflowerror = (TextView) findViewById(R.id.stackoverflowerror);
    oom_show = (TextView) findViewById(R.id.oom_show);
    ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
    memerySize = am.getMemoryClass();
    info = "M--Product Model= "
        + android.os.Build.MODEL
        + ",SDK="
        + android.os.Build.VERSION.SDK
        + ",Version="
        + android.os.Build.VERSION.RELEASE
        + ",品牌="
        + Build.BRAND;
    get_app_allowed_memery.setText(String.valueOf(memerySize + info));
    stackoverflowerror.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        try {
          recursivePrint(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    oom_show.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        oomMethod();
      }
    });
  }

  /**
   * StackOverflowErrorMethod
   */
  public void recursivePrint(int num) throws InterruptedException {
    Thread.sleep(10);
    System.out.println("Number: " + num);
    stackoverflowerror.setText(String.valueOf(num));
    if (num == 0) {
      return;
    } else {
      recursivePrint(++num);
    }
  }

  /**
   * OOMmethod
   */
  public void oomMethod() {
    int[] i = new int[1111111];
    List<int[]> l = new ArrayList<>();
    int num = 0;
    for (; ; ) {
      l.add(i);
      ++num;
      Log.d(TAG, "oomMethod() called = " + num);
      oom_show.setText(String.valueOf(num));
    }
  }
}
