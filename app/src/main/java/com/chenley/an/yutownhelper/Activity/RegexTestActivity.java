package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegexTestActivity extends AppCompatActivity {
    private static final String TAG = "RegexTestActivity==";
    @Bind(R.id.et_regex_)
    EditText etRegex;
    @Bind(R.id.et_result)
    EditText etResult;
    @Bind(R.id.btn_checkregex)
    Button btnCheckregex;
    @Bind(R.id.et_check_str)
    EditText etCheckStr;
    private String checkStr;
    private String regexStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_checkregex)
    public void onClick() {
        String re ="(^[A-Za-z0-9]{4,24}$)|(^[\\u4E00-\\u9FA5]{2,12}$)";
        String res ="(^[a-zA-Z0-9\\u4e00-\\u9fa5]{4,10}$)";
        checkStr = etCheckStr.getText().toString();
        regexStr = etRegex.getText().toString();
        try {
            boolean result = Pattern.matches(res, checkStr);
            etResult.setText(res+"--"+checkStr+"\n--对比结果："+result);
        } catch (Exception e) {
            Toast.makeText(RegexTestActivity.this, "regexStr=" + regexStr + ":请输入正确的正则表达式！", Toast.LENGTH_SHORT).show();
        }

    }
}
