package com.chenley.an.yutownhelper.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.views.CustomGradeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomTextViewActivity extends AppCompatActivity {

    @Bind(R.id.btn_changegrade)
    Button btnChangegrade;
    @Bind(R.id.cs_grade)
    CustomGradeView csGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_text_view);
        ButterKnife.bind(this);
        csGrade.setGradeValue("22");
    }

    @OnClick(R.id.btn_changegrade)
    public void onClick() {
        csGrade.setGradeValue((int)(Math.random()*10+9) + "");
    }
}
