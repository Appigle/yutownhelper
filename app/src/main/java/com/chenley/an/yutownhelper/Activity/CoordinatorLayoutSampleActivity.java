package com.chenley.an.yutownhelper.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.chenley.an.yutownhelper.R;

public class CoordinatorLayoutSampleActivity extends AppCompatActivity {

  @Bind(R.id.fab) FloatingActionButton fab;
  @Bind(R.id.col_activity_coordinator_layout_sample) CoordinatorLayout
      colActivityCoordinatorLayoutSample;
  @Bind(R.id.toolbar) Toolbar toolbar;
  private ActionBar mActionBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏ActionBar方式一
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    setContentView(R.layout.activity_coordinator_layout_sample);
    ButterKnife.bind(this);
    initBar();
    //initIntent();
    initView();
    //initViewData();
  }

  /**
   * 使用ToolBar替代ActionBar
   */
  private void initBar() {
    //mActionBar = getSupportActionBar();
    //mActionBar.hide();//隐藏ActionBar方式二
    toolbar.setLogo(R.mipmap.ic_launcher);
    toolbar.setTitle("ToolbarTitle");
    toolbar.setSubtitle(" 我是副标题");
    toolbar.setTitleTextColor(Color.BLUE);
    setSupportActionBar(toolbar);
  }

  private void initView() {

  }

  @OnClick(R.id.fab) void fabOnClick() {
    Snackbar.make(colActivityCoordinatorLayoutSample, "我是提示内容！", Snackbar.LENGTH_LONG)
        .setAction("确定", new View.OnClickListener() {
          @Override public void onClick(View v) {
            Toast.makeText(CoordinatorLayoutSampleActivity.this, "我点击了确定", Toast.LENGTH_SHORT)
                .show();
          }
        })
        .show();
  }
}
