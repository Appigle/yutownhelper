package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.chenley.an.yutownhelper.assist.SameNameQuestion;
import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SameNameQuestionActivity extends AppCompatActivity {

    @Bind(R.id.btn_show_result)
    Button btnShowResult;
    private SameNameQuestion mSameNameQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_name_question);
        ButterKnife.bind(this);
        mSameNameQuestion = new SameNameQuestion();
    }

    @OnClick(R.id.btn_show_result)
    public void onClick() {
        mSameNameQuestion.outPut();
    }
}
