package com.chenley.an.yutownhelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.chenley.an.yutownhelper.R;
import de.greenrobot.event.EventBus;

public class EventBusActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_bus);
    //在onCreate（）方法中注册
    EventBus.getDefault().register(this);
  }

  /**
   * 同线程接收Event事件
   * @param param
   */
  public void onEvent(Object param) {

  }

  /**
   * 主线程接收Event事件处理
   * @param param
   */
  public void onEventMainThread(Object param){

  }

  /**
   * 子线程接收Event事件处理
   * @param param
   */
  public void onEventPostThread(Object param){

  }

  /**
   * 后台接收Event事件处理
   * @param param
   */
  public void onEventBackgroundThread(Object param){

  }

  /**
   * 异步接收Event事件处理
   * @param param
   */
  public void onEventAsync(Object param){

  }

  @Override protected void onDestroy() {
    //在onDestory（）方法中注销EventBus
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }
}
