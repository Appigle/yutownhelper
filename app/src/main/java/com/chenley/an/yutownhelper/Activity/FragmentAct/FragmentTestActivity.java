package com.chenley.an.yutownhelper.Activity.FragmentAct;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chenley.an.yutownhelper.Fragment.Content2Fragment;
import com.chenley.an.yutownhelper.Fragment.Content3Fragment;
import com.chenley.an.yutownhelper.Fragment.Content4Fragment;
import com.chenley.an.yutownhelper.Fragment.ContentFragment;
import com.chenley.an.yutownhelper.Fragment.DialogFragmentShow;
import com.chenley.an.yutownhelper.Fragment.FragmentOne;
import com.chenley.an.yutownhelper.Fragment.FragmentOne.FOneBtnClickListener;
import com.chenley.an.yutownhelper.Fragment.FragmentThree;
import com.chenley.an.yutownhelper.Fragment.FragmentThree.FTwoBtnClickListener;
import com.chenley.an.yutownhelper.Fragment.FragmentTwo;
import com.chenley.an.yutownhelper.Fragment.ModelFragment;
import com.chenley.an.yutownhelper.Fragment.ModelFragment.OnFragmentInteractionListener;
import com.chenley.an.yutownhelper.Fragment.TitleFragment;
import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTestActivity extends AppCompatActivity implements TitleFragment.OnFragmentInteractionListener,
        ContentFragment.OnFragmentInteractionListener
        , FTwoBtnClickListener
        , FOneBtnClickListener
        , OnFragmentInteractionListener
,DialogFragmentShow.OnNameCompletedListener{
    private static final String TAG = "FragmentTestActivity==";
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;
    @Bind(R.id.btn4)
    Button btn4;
    @Bind(R.id.id_container)
    FrameLayout idContent;
    @Bind(R.id.btnback)
    Button btnback;
    @Bind(R.id.btnjump)
    Button btnjump;
    @Bind(R.id.btnjump2)
    Button btnjump2;
    @Bind(R.id.DialogFragmentshow)
    Button DialogFragmentshow;

    private Fragment mTitleFragment;
    private ContentFragment mContentFragment;
    private Content2Fragment mContent2Fragment;
    private Content3Fragment mContent3Fragment;
    private Content4Fragment mContent4Fragment;
    private FragmentOne mFOne;
    private FragmentTwo mFTwo;
    private FragmentThree mFThree;
    private ModelFragment modelFragment;
    final FragmentManager fm = getSupportFragmentManager();
    ;
    private FragmentTransaction ft;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_test);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        // 设置默认的Fragment
        setDefaultFragment();
        registerForContextMenu(btnjump2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        Log.d(TAG, "onCreateContextMenu() called with: " + "menu = [" + menu + "], v = [" + v + "], menuInfo = [" + menuInfo + "]");
    }

    /**
     * 设置默认的Fragment
     */
    private void setDefaultFragment() {
        ft = fm.beginTransaction();
        initFragment();
        ft.replace(R.id.id_container, mContent2Fragment);
        ft.commit();
    }

    private void initFragment() {
        mTitleFragment = new TitleFragment();
        mContentFragment = new ContentFragment();
        mContent2Fragment = new Content2Fragment();
        mFOne = FragmentOne.newInstance();
        mFTwo = FragmentTwo.newInstance();
        mFThree = FragmentThree.newInstance();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "onFragmentInteraction() called with: " + "uri = [" + uri + "]");
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onClick(View view) {
        ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.btn1:
                if (mContentFragment == null) {
                    mContentFragment = ContentFragment.newInstance(null, null);
                }
                ft.replace(R.id.id_container, mContentFragment);
                ft.addToBackStack(mContentFragment.getClass().getName());
                break;
            case R.id.btn2:
                if (mContent2Fragment == null) {
                    mContent2Fragment = Content2Fragment.newInstance(null, null);
                }
                ft.replace(R.id.id_container, mContent2Fragment);
                ft.addToBackStack(mContentFragment.getClass().getName());
                break;
            case R.id.btn3:
                if (mContent3Fragment == null) {
                    mContent3Fragment = Content3Fragment.newInstance(null, null);
                }
                ft.replace(R.id.id_container, mContent3Fragment);
                ft.addToBackStack(mContentFragment.getClass().getName());
                break;
            case R.id.btn4:
                if (mContent4Fragment == null) {
                    mContent4Fragment = Content4Fragment.newInstance(null, null);
                }
                ft.replace(R.id.id_container, mContent4Fragment);
                ft.addToBackStack(mContentFragment.getClass().getName());
                break;
        }
        ft.commit();
    }

    @OnClick(R.id.btnback)
    public void onBackAction() {
        onBackPressed();
    }

    @Override
    public void onTwoBtnClick() {
        if (mFThree == null) {
            mFThree = FragmentThree.newInstance();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.id_container, mFThree);
        ft.commit();
    }


    @Override
    public void onFOneBtnClick() {
        //FragmentTwo 与Activity之间的回调通信
        //让容器显示FragmentTwo
        if (mFTwo == null) {
            mFTwo = FragmentTwo.newInstance();
            mFTwo.setFTwoBtnClickListener(new FragmentTwo.FTwoBtnClickListener() {
                @Override
                public void onTwoBtnClick() {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.id_container, mFTwo);
                    ft.commit();
                }
            });
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.id_container, mFTwo);
        ft.commit();
    }

    @OnClick(R.id.btnjump)
    public void btn_Jump() {
        setFragment();
    }

    /**
     * 设置Fragment
     */
    private void setFragment() {
        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();
        if (!mFOne.isAdded()) {
            ft2.add(R.id.id_container, mFOne);
            ft2.show(mFOne);
            ft2.commit();
        } else {
            ft2.remove(mFOne);
            ft2.add(mFOne, null).show(mFOne).commit();
        }
    }

    @OnClick(R.id.btnjump2)
    public void btn_jump2() {
        ft = fm.beginTransaction();
        if (modelFragment == null) {
            modelFragment = ModelFragment.newInstance("参数1", "参数2");
        }
        if (modelFragment.isAdded()) {
            ft.replace(R.id.id_container, modelFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected() called with: " + "item = [" + item + "]");
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.DialogFragmentshow)
    public void dialogFragmentshow() {
        DialogFragmentShow mDialogFragmentShow = DialogFragmentShow.newInstance();
        mDialogFragmentShow.setOnNameCompletedListener(this);
        mDialogFragmentShow.show(getSupportFragmentManager(), DialogFragmentshow.getClass().getName());
    }

    @Override
    public void onNameCompleted(String name) {
        Toast.makeText(FragmentTestActivity.this, "name=" + name, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onNameCompleted() called with: " + "name = [" + name + "]");
    }
}
