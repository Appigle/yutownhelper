package com.chenley.an.yutownhelper.mvp.bean;

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
public class LoginDataBean {
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "LoginDataBean{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public LoginDataBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LoginDataBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}