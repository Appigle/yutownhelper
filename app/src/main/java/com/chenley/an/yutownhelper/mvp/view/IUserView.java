package com.chenley.an.yutownhelper.mvp.view;

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
public interface IUserView {
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
    void showProgressBar();
    void hideProgressBar();
    void toManiActivity(LoginDataBean loginDataBean);
    void showFailedError();
}
