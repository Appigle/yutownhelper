package com.chenley.an.yutownhelper.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

public class BaseActionBarActivity extends AppCompatActivity {
    private static final String TAG = "BaseActionBarActivity==";
    protected ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    /**
     * 设置是否显示ActionBar左上角返回按钮
     * @return
     */
    protected boolean isHomeUp() {
        return true;
    }
    /**
     * ActionBar设置
     */
    protected void initActionBar() {
        mActionBar = getSupportActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Toast.makeText(BaseActionBarActivity.this, "menu item="+item.toString()+"\n menu id = "+id, Toast.LENGTH_SHORT).show();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
