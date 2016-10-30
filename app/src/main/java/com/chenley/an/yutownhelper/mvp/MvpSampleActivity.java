package com.chenley.an.yutownhelper.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.mvp.bean.LoginDataBean;
import com.chenley.an.yutownhelper.mvp.presenter.UserLoginPresenter;
import com.chenley.an.yutownhelper.mvp.view.IUserView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpSampleActivity extends AppCompatActivity implements IUserView {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_clear)
    Button btnClear;
    @Bind(R.id.tv_pwd)
    TextView tvPwd;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.progressBar2)
    ProgressBar progressBar2;

    /**
     * 用户登录Presenter
     */
    private UserLoginPresenter mUserLoginPresenter;
    /**
     * 用户是否可登录flag
     */
    private boolean isLoginable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_sample);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 初始化部分参数
     */
    private void initData() {
        mUserLoginPresenter = new UserLoginPresenter(this);
        progressBar2.setVisibility(View.INVISIBLE);
    }

    /**
     * 点击事件
     * @param view
     */
    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                onLogin();
                break;
            case R.id.btn_clear:
                onClear();
                break;
        }
    }

    /**
     * 清除编辑框内容
     */
    private void onClear() {
        mUserLoginPresenter.clear();
    }

    /**
     * 登录操作
     */
    private void onLogin() {
        if (isLoginable) {
            mUserLoginPresenter.login();
        } else {
            Toast.makeText(this, "用户名或者密码不能为空！", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 获取用户名
     * @return
     */
    @Override
    public String getUsername() {
        String username = etUsername.getText().toString().trim();
        checkEmpty(username);
        return username;
    }

    /**
     * 获取用户密码
     * @return
     */
    @Override
    public String getPassword() {
        String pwd = etPwd.getText().toString().trim();
        checkEmpty(pwd);
        return pwd;
    }

    /**
     * 验证用户名和密码是否为空
     * @param username
     * @return
     */
    private boolean checkEmpty(String username) {
        boolean isEmpty = username == null || username.equals("");
        if (isEmpty) {
            isLoginable = false;
        } else {
            isLoginable = true;
        }
        return isEmpty;
    }

    /**
     * 清除编辑框用户名
     */
    @Override
    public void clearUsername() {
        etUsername.setText("");
    }

    /**
     * 清除编辑框用户密码
     */
    @Override
    public void clearPassword() {
        etPwd.setText("");
    }

    /**
     * 显示进度条
     */
    @Override
    public void showProgressBar() {
        progressBar2.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏进度条
     */
    @Override
    public void hideProgressBar() {
        progressBar2.setVisibility(View.INVISIBLE);
    }

    /**
     * 登录成功后跳转到MainActivity
     * @param loginDataBean
     */
    @Override
    public void toManiActivity(LoginDataBean loginDataBean) {
        Toast.makeText(this, "UserInfo=" + loginDataBean.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 登录失败，显示失败信息
     */
    @Override
    public void showFailedError() {
        Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
    }
}
