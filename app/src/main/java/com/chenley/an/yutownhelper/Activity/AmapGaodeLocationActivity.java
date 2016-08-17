package com.chenley.an.yutownhelper.Activity;

import android.app.ProgressDialog;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AmapGaodeLocationActivity extends AppCompatActivity implements AMapLocationListener {
    private static final String TAG = "AmapGaodeLocationActivity==";
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_current_location)
    TextView tvCurrentLocation;
    @Bind(R.id.tv_show_current_location)
    TextView tvShowCurrentLocation;
    @Bind(R.id.btn_refresh_location)
    Button btnRefreshLocation;
    private LocationManager mLocationManager = null;
    private AMapLocationClient locationClient;
    private AMapLocationClientOption locationOption;
    private ProgressDialog mProgressDialog =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amap_gaode_location);
        ButterKnife.bind(this);
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        // 设置定位监听
        locationClient.setLocationListener(this);
        mProgressDialog = new ProgressDialog(this);
    }

    Handler mHandler = new Handler() {
        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                //开始定位
                case Utils.MSG_LOCATION_START:
                    tvShowCurrentLocation.setText("正在定位...");
                    break;
                // 定位完成
                case Utils.MSG_LOCATION_FINISH:
                    mProgressDialog.dismiss();
                    AMapLocation loc = (AMapLocation) msg.obj;
                    String result = Utils.getLocationStr(loc);
                    tvShowCurrentLocation.setText(result);
                    btnRefreshLocation.setText("开始定位");
                    btnRefreshLocation.setEnabled(true);
                    break;
                //停止定位
                case Utils.MSG_LOCATION_STOP:
                    btnRefreshLocation.setText("定位停止");
                    break;
                default:
                    break;
            }
        }

        ;
    };

    // 定位监听
    @Override
    public void onLocationChanged(AMapLocation loc) {
        if (null != loc) {
            Message msg = mHandler.obtainMessage();
            msg.obj = loc;
            msg.what = Utils.MSG_LOCATION_FINISH;
            mHandler.sendMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }


    @OnClick(R.id.btn_refresh_location)
    public void onClick() {
            if (btnRefreshLocation.getText().equals(("开始定位"))) {
                btnRefreshLocation.setEnabled(false);
                initOption();
                btnRefreshLocation.setText("停止定位");
                // 设置定位参数
                locationClient.setLocationOption(locationOption);
                // 启动定位
                locationClient.startLocation();
                mProgressDialog.show();
                mHandler.sendEmptyMessage(Utils.MSG_LOCATION_START);
            } else {
                btnRefreshLocation.setEnabled(true);
                btnRefreshLocation.setText("开始定位");
                // 停止定位
                locationClient.stopLocation();
                mHandler.sendEmptyMessage(Utils.MSG_LOCATION_STOP);
            }
    }

    // 根据控件的选择，重新设置定位参数
    private void initOption() {
        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(true);
        //时候单次定位
        locationOption.setOnceLocation(true);
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        locationOption.setGpsFirst(true);
        // 设置是否开启缓存
        locationOption.setLocationCacheEnable(true);
        //设置是否等待设备wifi刷新，如果设置为true,会自动变为单次定位，持续定位时不要使用
        locationOption.setOnceLocationLatest(true);
        String strInterval = "1000";
        if (!TextUtils.isEmpty(strInterval)) {
            // 设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
            locationOption.setInterval(Long.valueOf(strInterval));
        }

    }
}
