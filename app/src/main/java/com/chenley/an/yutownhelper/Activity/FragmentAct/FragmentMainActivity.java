package com.chenley.an.yutownhelper.Activity.FragmentAct;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chenley.an.yutownhelper.Fragment.FragmentOne;
import com.chenley.an.yutownhelper.Fragment.FragmentThree;
import com.chenley.an.yutownhelper.Fragment.FragmentTwo;
import com.chenley.an.yutownhelper.Fragment.ModelFragment;
import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentMainActivity extends AppCompatActivity implements ModelFragment.OnFragmentInteractionListener,
FragmentOne.FOneBtnClickListener,FragmentTwo.FTwoBtnClickListener,FragmentThree.FTwoBtnClickListener{

    @Bind(R.id.fl_container)
    FrameLayout flContainer;
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

    private FragmentOne mFOne;
    private FragmentTwo mFTwo;
    private FragmentThree mFThree;
    private ModelFragment modelFragment;
    private FragmentManager mFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        ButterKnife.bind(this);
        mFm = getSupportFragmentManager();
        setSelectTab(0);
    }

    /**
     * 设置选中Tab按钮
     *
     * @param i
     */
    private void setSelectTab(int i) {
        FragmentTransaction mFt = mFm.beginTransaction();
        hideFragment(mFt);
        switch (i) {
            case 0:
                if (mFOne == null) {
                    mFOne = new FragmentOne();
                    mFt.add(R.id.fl_container,mFOne, "one");
                } else {
                    mFt.show(mFOne);
                }
                break;
            case 1:
                if (mFTwo == null) {
                    mFTwo = new FragmentTwo();
                    mFt.add(R.id.fl_container,mFTwo, "one");
                } else {
                    mFt.show(mFTwo);
                }
                break;
            case 2:
                if (mFThree == null) {
                    mFThree = new FragmentThree();
                    mFt.add(R.id.fl_container,mFThree, "one");
                } else {
                    mFt.show(mFThree);
                }
                break;
            case 3:
                if (modelFragment == null) {
                    modelFragment = new ModelFragment();
                    mFt.add(R.id.fl_container,modelFragment, "one");
                } else {
                    mFt.show(modelFragment);
                }
                break;
            default:
                break;
        }
        mFt.commit();
    }

    /**
     * 隐藏显示的Fragment
     * @param mFt
     */
    private void hideFragment(FragmentTransaction mFt) {
        if (mFOne != null && mFOne.isVisible()) {
            mFt.hide(mFOne);
        } if (mFTwo != null && mFTwo.isVisible()) {
            mFt.hide(mFTwo);
        } if (mFThree != null && mFThree.isVisible()) {
            mFt.hide(mFThree);
        } if (modelFragment != null && modelFragment.isVisible()) {
            mFt.hide(modelFragment);
        }
    }

    @OnClick({R.id.btn_btn1, R.id.btn_btn2, R.id.btn_btn3, R.id.btn_btn4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_btn1:
                setSelectTab(0);
                break;
            case R.id.btn_btn2:
                setSelectTab(1);
                break;
            case R.id.btn_btn3:
                setSelectTab(2);
                break;
            case R.id.btn_btn4:
                setSelectTab(3);
                break;
        }
    }

    @Override
    public void onFOneBtnClick() {
        Toast.makeText(FragmentMainActivity.this, "onFOneBtnClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTwoBtnClick() {
        Toast.makeText(FragmentMainActivity.this, "onTwoBtnClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(FragmentMainActivity.this, "onFragmentInteraction", Toast.LENGTH_SHORT).show();
    }
}
