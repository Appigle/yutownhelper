package com.chenley.an.yutownhelper.bean;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/8/5
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/8/5         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class Toast_Bean {
    public Toast_Bean() {
    }

    public Toast_Bean(String tag, String msg) {
        this.tag = tag;
        this.msg = msg;
    }

    private String tag;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}