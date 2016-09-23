package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestMenuActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {
    private static final String TAG = "TestMenuActivity==";
    @Bind(R.id.btn_test)
    Button btnTest;
    @Bind(R.id.btn_context_menu)
    Button btnContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);
        ButterKnife.bind(this);
        initListener();
    }

    /**
     * 设置监听时间
     */
    private void initListener() {
        btnTest.setOnCreateContextMenuListener(this);
        registerForContextMenu(btnContextMenu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d(TAG, "onContextItemSelected() called with: " + "item = [" + item + "]");
        Toast.makeText(TestMenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo am = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(0, 1, 0, "上下文菜单1");
        menu.add(0, 2, 0, "上下文菜单2");
    }

    @OnClick(R.id.btn_context_menu)
    public void onClick() {
        btnContextMenu.showContextMenu();
    }
}
