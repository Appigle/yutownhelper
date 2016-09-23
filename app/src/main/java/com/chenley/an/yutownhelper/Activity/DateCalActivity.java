package com.chenley.an.yutownhelper.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DateCalActivity extends AppCompatActivity {
    private static final String TAG = "DateCalActivity==";
    String SPKEY_DATE = "CACHE_DATE";
    String spValue_Date = null;
    @Bind(R.id.calDate)
    Button calDate;
    @Bind(R.id.lastDate)
    TextView lastDate;
    @Bind(R.id.curTime)
    TextView curTime;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_cal);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        spValue_Date = mSharedPreferences.getString(SPKEY_DATE, "");
        if (!TextUtils.isEmpty(spValue_Date)) {
            Toast.makeText(DateCalActivity.this, "显示弹窗 ", Toast.LENGTH_SHORT).show();
        }
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    String today;
    String lastDay;
    Date cacheDate;
    public static final String CACHEDATE = "cacheDate";
    Calendar cal = Calendar.getInstance();

    public void getToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = cal.getTime();
        today = sdf0.format(date);
        String cacheDate_str = mSharedPreferences.getString(CACHEDATE, today);
        try {
            cacheDate= sdf0.parse(cacheDate_str);
            Log.i(TAG, "getToday: cacheDate:"+cacheDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.add(cal.DATE, -1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = cal.getTime();
        lastDay = sdf1.format(date1);
//        an {@code int < 0} if this {@code Date} is less than the specified {@code Date}, {@code 0} if
//          they are equal, and an {@code int > 0} if this {@code Date} is greater.
       int compareToday =  cacheDate.compareTo(date);
       int compareLastday =  cacheDate.compareTo(date1);
        Log.i(TAG, "保存日期vs今天: compareToday:"+compareToday);
        Log.i(TAG, "保存日期vs昨天: compareLastday:"+compareLastday);
    }


    public void calValue() {
        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = cal.getTime();
        today = sdf0.format(date);
        cal.add(cal.DATE, -1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = cal.getTime();
        lastDay = sdf1.format(date1);
        lastDate.setText("上一次保存时间：" + lastDay);
        curTime.setText("当前时间：" + today);
    }

    @OnClick({R.id.calDate, R.id.lastDate, R.id.curTime})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calDate:
                calValue();
                break;
            case R.id.lastDate:
                getToday();
                break;
            case R.id.curTime:

                break;
        }
    }
}
