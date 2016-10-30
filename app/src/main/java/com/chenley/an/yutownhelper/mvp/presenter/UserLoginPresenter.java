package com.chenley.an.yutownhelper.mvp.presenter;

import android.os.Handler;

import com.chenley.an.yutownhelper.mvp.bean.LoginDataBean;
import com.chenley.an.yutownhelper.mvp.biz.IUserBiz;
import com.chenley.an.yutownhelper.mvp.biz.OnLoginListener;
import com.chenley.an.yutownhelper.mvp.biz.UserBizImpl;
import com.chenley.an.yutownhelper.mvp.view.IUserView;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/9/23
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/9/23         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class UserLoginPresenter {
    private IUserBiz mUserBiz; //用户业务类
    private IUserView mUserView;//用户视图类
    private Handler mHandler = new Handler();//handler发送信息类

    public UserLoginPresenter(IUserView mUserView) {
        this.mUserBiz = new UserBizImpl();//实例化用户业务类的实现实例
        this.mUserView = mUserView;
    }

    /**
     * 具体的登录操作实现方法
     */
    public void login() {
        mUserView.showProgressBar();
        mUserBiz.login(mUserView.getUsername(), mUserView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final LoginDataBean loginDataBean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserView.toManiActivity(loginDataBean);
                        mUserView.hideProgressBar();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserView.showFailedError();
                        mUserView.hideProgressBar();
                    }
                });
            }
        });
    }

    public void clear() {
        mUserView.clearPassword();
        mUserView.clearUsername();
    }
}