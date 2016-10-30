package com.chenley.an.yutownhelper.mvp.biz;

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
public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}