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
public interface OnLoginListener {
    void loginSuccess(LoginDataBean loginDataBean);
    void loginFailed();
}
