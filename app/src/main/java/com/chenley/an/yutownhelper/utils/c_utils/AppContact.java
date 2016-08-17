package com.chenley.an.yutownhelper.utils.c_utils;

import android.os.Environment;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:10
 * Description: APP常量工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class AppContact {
    public static final long APP_SEND_CODE_TIMER = 60 * 1000;//验证码发送间隔时间60S
    public static final int APP_PASSWORD_LIMIT_LENGTH = 6;//密码最小长度为6位
    public static final int APP_REQUEST_CODE_PICK_PHOTO = 1;//图片选择
    public static final int APP_REQUEST_CODE_PICK_OLD_PHOTO = 2;//图片选择
    public static final int APP_REQUEST_CODE_CROP_PHOTO = 3;//裁剪图片
    public static final int APP_REQUEST_CODE_TAKE_PHOTO = 4;//拍照
    public static final int APP_REQUEST_CODE_RECORD_VIDEO = 5;//录制视频

    public static final String APP_WEB_START_PREFIX = "http://";//网址开始前缀
    public static final String APP_LOCAL_PICTURE_START_PREFIX = "file://";//网址开始前缀

    public static final String FILE_DATA_ROOT_PATH = Environment.getExternalStorageDirectory().getPath() + "/FishPond/";
    public static final String FILE_DATA_PICTURE_PATH = FILE_DATA_ROOT_PATH + "picture/";
    public static final String FILE_DATA_AUDIO_PATH = FILE_DATA_ROOT_PATH + "audio/";
    public static final String FILE_DATA_AVATAR_PATH = FILE_DATA_ROOT_PATH + "avatar/";
    public static final String ENCODE_TYPE = "UTF-8";
    public static final String HTTP_INPUT_TYPE = "application/json";

    public static final String AVOS_CLOUD_REGISTER = "用户注册";
    public static final String AVOS_CLOUD_CHANGE_PWD = "用户改密";

    public static final int APP_MAX_PICTURE_SIZE = 3;//最大上传图片张数
    public static final int APP_MAX_PICTURE_CROP_WIDTH = 400;//图片裁剪宽度
    public static final int APP_MAX_PICTURE_CROP_HEIGHT = 400;//图片裁剪高度
    public static final int APP_NEWS_FEED_MAX_PICTURE_SIZE = 9;//最大上传图片张数

    public static final int WEI_BO_SHOW_MAX_USER_SIZE = 8;//微博详情最大显示用户点赞数量

    public static final String APP_USER_INFO_SCHEME = "com.doyutown.fishpond.userinfo://";
    public static final String APP_WEB_LINK_SCHEME = "http://";

    public static final int DEFAULT_DURATION_LIMIT = 120;//最大录制视频长度

    public static final String WEIBO_MAP_KEY = "weibo";//微博模型MAP KEY
    public static final String USER_MAP_KEY = "user";//微博模型推荐用户MAP KEY

    // 手机网络类型
    public static final int NETTYPE_WIFI = 0x01;
    public static final int NETTYPE_CMWAP = 0x02;
    public static final int NETTYPE_CMNET = 0x03;
}
