package com.chenley.an.yutownhelper.mvp.biz;

import com.chenley.an.yutownhelper.mvp.bean.LoginDataBean;

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
public class UserBizImpl implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        if (loginListener == null) {
            throw new IllegalArgumentException("必须设置登录监听");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("abc".equals(username) && "123".equals(password)) {
                    LoginDataBean loginDataBean = new LoginDataBean(username, password);
                    loginListener.loginSuccess(loginDataBean);
                } else {
                    loginListener.loginFailed();
                }
            }
        }).start();
    }
}