package com.chenley.an.yutownhelper.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.utils.TimeUtil;
import com.chenley.an.yutownhelper.utils.Utils;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 有天倒计时的View
 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class CountDownView extends LinearLayout {


  @Bind(R.id.tv_day) TextView tvDay;
  @Bind(R.id.day) TextView day;
  @Bind(R.id.tv_hour) TextView tvHour;
  @Bind(R.id.hour) TextView hour;
  @Bind(R.id.tv_minute) TextView tvMinute;
  @Bind(R.id.minute) TextView minute;
  @Bind(R.id.tv_second) TextView tvSecond;

  private Context context;

  private int cellBgColor;//倒计时的背景
  private boolean cellBg;//倒计时cell，false为灰色背景，true位红色背景
  private int cellTextColor;//文字颜色
  private int textColor;//外部：等颜色
  private int textSize = 14;//外部文字大小
  private int cellTextSize = 12;//cell文字大小

  private Timer timer = null;

  private Handler handler = new Handler() {

    public void handleMessage(Message msg) {
      countDown();
    }
  };

  public CountDownView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
    this.context = context;
  }

  public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context = context;
    initAttrs(attrs, defStyleAttr);
    initView(context);
  }

  private void initAttrs(AttributeSet attrs, int defStyle) {
    TypedArray typedArray =
        getContext().obtainStyledAttributes(attrs, R.styleable.CountDownView, defStyle, 0);
    cellBgColor =
        typedArray.getColor(R.styleable.CountDownView_cellBgColor, Color.parseColor("#FF988E87"));

    cellTextColor =
        typedArray.getColor(R.styleable.CountDownView_cellTextColor, Color.parseColor("#646464"));
    textColor =
        typedArray.getColor(R.styleable.CountDownView_TextColor, Color.parseColor("#B3B3B3"));
    textSize = (int) typedArray.getDimension(R.styleable.CountDownView_TextSize,
        Utils.dip2px(getContext(), 14));
    cellTextSize = (int) typedArray.getDimension(R.styleable.CountDownView_cellTextSize,
        Utils.dip2px(getContext(), 12));
    typedArray.recycle();
  }

  private void initView(Context context) {
    LayoutInflater inflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.layout_countdown_layout, this);
    ButterKnife.bind(view);
    initProperty();
  }

  private void initProperty() {

    tvDay.setBackgroundColor(cellBgColor);
    tvHour.setBackgroundColor(cellBgColor);
    tvMinute.setBackgroundColor(cellBgColor);
    tvSecond.setBackgroundColor(cellBgColor);

    tvDay.setTextColor(cellTextColor);
    tvHour.setTextColor(cellTextColor);
    tvMinute.setTextColor(cellTextColor);
    tvSecond.setTextColor(cellTextColor);

    day.setTextColor(textColor);
    hour.setTextColor(textColor);
    minute.setTextColor(textColor);
  }

  public void setLeftTime(long leftTime) {
    if (leftTime <= 0) return;
    //        long time = leftTime / 1000;
    long day = leftTime / (3600 * 24);
    long hours = (leftTime - day * 3600 * 24) / 3600;
    long minutes = (leftTime - day * 3600 * 24 - hours * 3600) / 60;
    long seconds = leftTime - day * 3600 * 24 - hours * 3600 - minutes * 60;

    setTextTime(leftTime);
  }

  public void start() {
    if (timer == null) {
      timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override public void run() {
          handler.sendEmptyMessage(0);
        }
      }, 0, 1000);
    }
  }

  /**
   * 即时结束，重置显示时间
   */
  public void stop() {
    setTextTime(0L);
    if (timer != null) {
      timer.cancel();
      timer = null;
    }
  }

  //保证天，时，分，秒都两位显示，不足的补0
  private void setTextTime(long time) {
    String[] s = TimeUtil.formatTimer(time);
    tvDay.setText(s[0]);
    tvHour.setText(s[1]);
    tvMinute.setText(s[2]);
    tvSecond.setText(s[3]);
  }

  private void countDown() {
    if (isCarry4Unit(tvSecond)) {
      if (isCarry4Unit(tvMinute)) {
        if (isCarry4Unit(tvHour)) {
          if (isCarry4Unit(tvDay)) {
            //ToastUtils.showToast("倒计时结束了");
            stop();
          }
        }
      }
    }
  }

  private boolean isCarry4Unit(TextView tv) {
    int time = Integer.valueOf(tv.getText().toString());
    time = time - 1;
    if (time < 0) {
      time = 59;
      tv.setText(time + "");
      return true;
    } else if (time < 10) {
      tv.setText("0" + time);
      return false;
    } else {
      tv.setText(time + "");
      return false;
    }
  }
}
