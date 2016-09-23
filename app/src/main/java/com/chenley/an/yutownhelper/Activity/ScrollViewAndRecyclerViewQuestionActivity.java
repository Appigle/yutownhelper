package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.chenley.an.yutownhelper.Fragment.FullyExpandedFragment;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.base.BaseActionBarActivity;

public class ScrollViewAndRecyclerViewQuestionActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_and_recycler_view_question);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,getFragment()).commit();
        }
    }

    public Fragment getFragment() {
        return  FullyExpandedFragment.newInstance(2);
    }
}
