package com.chenley.an.yutownhelper.utils.c_utils;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:11
 * Description: APP SharedPreferences KEY 常量工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class AppSpContact {
    public static final String SP_KEY_LOGIN_ID = "loginId";//用户登陆ID
    public static final String SP_KEY_USER_TYPE = "userType";//用户登陆类型--新版本依靠usertype判断是否是主播用户
    public static final String SP_KEY_LOGIN_NAME = "loginName";//用户登陆名
    public static final String SP_KEY_LOGIN_PWD = "loginPassword";//用户密码
    public static final String SP_KEY_PHONE = "phone";//用户手机号码
    public static final String SP_KEY_COOKIES = "cookies";//登录信息
    public static final String SP_KEY_IS_REMEMBER_PWD = "isRememberPwd";//是否记住密码
    public static final String SP_KEY_USER_AVATAR = "userAvatar";//用户头像
    public static final String SP_KEY_USER_NICK_NAME = "userNickName";//用户昵称
    public static final String SP_KEY_USER_TOKEN = "userToken";//用户凭证
    public static final String SP_KEY_USER_GENDER = "1";//性别
    public static final String SP_KEY_USER_TIME_CHECK = "timeCheck";//登录信息 时间戳
    public static final String SP_KEY_USER_DESCRIPTION = "userDescription";//用户简介
    public static final String SP_KEY_FIRST_LAUNCHER = "isFirstLauncher";//第一次启动
    public static final String SP_SHARE_URL = "http://www.doyutown.com/";//默认分享url
    public static final String SP_KEY_INSTALLATION_ID = "installationId";//推送设备ID
    public static final String SP_KEY_VIEW_X = "recycle_x";//保存x数据点
    public static final String SP_KEY_VIEW_Y = "recycle_y";//保存y数据点
    public static final String SP_KEY_VIEW_POSITION = "positionfirst";//保存第一条数据位置

    public static final String SP_SHARE_DEFAULT_TITLE = "【发现“渔塘昵称”的微博很赞，快来和我一起围观吧~】";
    public static final String SP_KEY_USER_RONGCLOUD_TOKEN ="rongcloudtoken" ;
    public static final String SP_KEY_USER_RONGCLOUD_TOKEN_IS_SUCCESS ="getrongcloudtokenfailed" ;
}
