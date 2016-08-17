package com.chenley.an.yutownhelper.Activity.FragmentAct;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TraditionalViewPagerAcvitity extends AppCompatActivity {
    private static final String TAG = "TraditionalViewPager==";
    @Bind(R.id.btn_btn1)
    Button btnBtn1;
    @Bind(R.id.btn_btn2)
    Button btnBtn2;
    @Bind(R.id.btn_btn3)
    Button btnBtn3;
    @Bind(R.id.btn_btn4)
    Button btnBtn4;
    @Bind(R.id.ll_bottom_btn)
    LinearLayout llBottomBtn;
    @Bind(R.id.pager)
    ViewPager pager;
    private ViewPager mViewPager;//veiwPager类
    private PagerAdapter mPagerAdapter;//Pager适配器
    private List<View> mViews;//View集合
    private LayoutInflater inflater;//布局填充
    private int currentIndex;//当前Index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_view_pager_acvitity);
        ButterKnife.bind(this);
        initView();
        pager.setAdapter(mPagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "onPageScrolled() called with: " + "position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected() called with: " + "position = [" + position + "]");
                currentIndex = position;
                Toast.makeText(TraditionalViewPagerAcvitity.this, "当前页码：" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged() called with: " + "state = [" + state + "]");
            }
        });
    }

    private void initView() {
        mViews = new ArrayList<>();
        inflater = LayoutInflater.from(this);
        mViews.add(inflater.inflate(R.layout.fragment_content, null));
        mViews.add(inflater.inflate(R.layout.fragment_content2, null));
        mViews.add(inflater.inflate(R.layout.fragment_content3, null));
        mViews.add(inflater.inflate(R.layout.fragment_content4, null));
        mPagerAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViews.get(position));
                return mViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
    }

    @OnClick({R.id.btn_btn1, R.id.btn_btn2, R.id.btn_btn3, R.id.btn_btn4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_btn1:
                break;
            case R.id.btn_btn2:
                break;
            case R.id.btn_btn3:
                break;
            case R.id.btn_btn4:
                break;
        }
    }
}
