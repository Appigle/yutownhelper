package com.chenley.an.yutownhelper.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetPackageInfoActivity extends AppCompatActivity {
    private static final String TAG = "GetPackage==";
    @Bind(R.id.get_version_code)
    Button getVersionCode;
    @Bind(R.id.tv_versionCode)
    TextView tvVersionCode;

    PackageInfo info = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_package_info);
        ButterKnife.bind(this);
        getPackageInfo();
    }

    private void getPackageInfo() {
        PackageManager mPackageManager = getPackageManager();

        try {
            info = mPackageManager.getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "getPackageInfo: " + info.versionCode);
    }

    @OnClick({R.id.get_version_code, R.id.tv_versionCode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_version_code:
                tvVersionCode.setText(info.versionCode);
                break;
        }
    }
}
