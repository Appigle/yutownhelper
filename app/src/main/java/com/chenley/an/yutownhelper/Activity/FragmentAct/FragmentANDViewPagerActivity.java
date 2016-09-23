package com.chenley.an.yutownhelper.activity.FragmentAct;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chenley.an.yutownhelper.Fragment.Content2Fragment;
import com.chenley.an.yutownhelper.Fragment.Content3Fragment;
import com.chenley.an.yutownhelper.Fragment.Content4Fragment;
import com.chenley.an.yutownhelper.Fragment.ContentFragment;
import com.chenley.an.yutownhelper.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentANDViewPagerActivity extends AppCompatActivity {
    @Bind(R.id.pager)
    ViewPager mViewPager;
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
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    private int currentIndex;
    private ContentFragment mContentFragment;
    private Content2Fragment mContent2Fragment;
    private Content3Fragment mContent3Fragment;
    private Content4Fragment mContent4Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_andview_pager);
        ButterKnife.bind(this);
        initFragmentList();
        initViewPage();
    }

    private void initFragmentList() {
        mContentFragment = new ContentFragment();
        mContent2Fragment = new Content2Fragment();
        mContent3Fragment = new Content3Fragment();
        mContent4Fragment = new Content4Fragment();
        fragments.add(mContentFragment);
        fragments.add(mContent2Fragment);
        fragments.add(mContent3Fragment);
        fragments.add(mContent4Fragment);
    }

    private void initViewPage() {
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                Toast.makeText(FragmentANDViewPagerActivity.this, "currentIndex ="+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @OnClick({R.id.btn_btn1, R.id.btn_btn2, R.id.btn_btn3, R.id.btn_btn4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_btn1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.btn_btn2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.btn_btn3:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.btn_btn4:
                mViewPager.setCurrentItem(3);
                break;
        }
    }
}
