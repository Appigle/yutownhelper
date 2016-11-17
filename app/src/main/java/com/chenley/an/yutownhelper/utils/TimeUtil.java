package com.chenley.an.yutownhelper.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by darcy  on 2015/10/22
 * Function:时间戳的格式处理
 * Modify by darcy on 2015/10/22
 * Modify Reason:
 */
public class TimeUtil {
    public static String yyyy_MM_dd_HH_mm_FORMAT = "yyyy-MM-dd  HH:mm";
    public static String MM_dd_FORMAT = "MMdd";
    public static String HH_mm_FORMAT = "HH:mm";
    public static Locale china = Locale.CHINA;

    private static long lastClickTime;

    public synchronized static boolean isFastDoubleClick() {
        return isFastDoubleClick(1000);
    }

    public synchronized static boolean isFastDoubleClick(long times) {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < times) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 获取当前日期
     */
    public static String getCurrentDate() {
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(MM_dd_FORMAT, china);
        temp_str = sdf.format(dt);
        return temp_str;
    }

    /**
     * 获取当前小时分钟
     */
    public static String getCurrentHour() {
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(HH_mm_FORMAT, china);
        temp_str = sdf.format(dt);
        return temp_str;
    }

    /**
     * String日期转换为Long
     */
    public static Long transferStringDateToLong(String formatDate, String date) {
        if (TextUtils.isEmpty(formatDate)) {
            formatDate = yyyy_MM_dd_HH_mm_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate, china);
        Date dt = null;
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt != null) {
            return dt.getTime();
        }
        return 0L;
    }

    /**
     * 毫秒-Long日期转换为String
     *
     * @formatDate 时间格式 可为null 使用默认格式 yyyy-MM-dd HH-mm
     */
    public static String transferMs2String(String formatDate, long ms) {
        if (TextUtils.isEmpty(formatDate)) {
            formatDate = yyyy_MM_dd_HH_mm_FORMAT;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formatDate, china);// 初始化Formatter的转换格式。
        Date date = new Date(ms);
        return formatter.format(date);
    }

    /**
     * 秒-Long日期转换为String
     *
     * @formatDate 时间格式 可为null 使用默认格式 yyyy-MM-dd HH-mm
     */
    public static String transferSs2String(String formatDate, long ss) {
        return transferMs2String(formatDate, ss * 1000);
    }

    /**
     * 将时间差值转为天，时，分 , 不足2天显示1天 不足1天显示小时 不足小时显示分钟 不足1分钟显示不到1分钟
     *
     * @param time 秒
     * @return
     */
    public static String transformTime2Period(long time) {
        String result = "";
        long remainTime;
        int DAY = 24 * 60 * 60;
        int HOUR = 60 * 60;
        int MINUTE = 60;
        // 算天
        int day = (int) (time / DAY);
        remainTime = time % DAY;
        // 算小时
        int hour = (int) (remainTime / HOUR);
        remainTime = remainTime % HOUR;
        // 算分钟
        int minute = (int) (remainTime / MINUTE);

        if (day == 0) {// 不足一天算小时
            result = getHourOrMinute(hour, minute);
        } else {
            result = day + "天" + getHourOrMinute(hour, minute);
        }
        return result;
    }

    @NonNull
    private static String getHourOrMinute(int hour, int minute) {
        String result;
        if (hour == 0) {// 不足一小时算分钟
            if (minute == 0) {// 不足一分钟显示不到一分钟
                result = "不到1分钟";
            } else {
                result = (minute + "分钟");
            }
        } else {
            result = hour + "小时";
        }
        return result;
    }

    public static boolean isInOpenTime(String openTime) {
        String[] results = openTime.split("-");
        if (results.length == 0) return false;
        int start = 0, end = 0;
        if (results.length >= 1) {
            start = caculateTime(results[0]);
        }
        if (results.length >= 2) {
            end = caculateTime(results[1]);
        }
        int current = caculateTime(getCurrentHour());
        return current >= start && current <= end;
    }

    private static int caculateTime(String result) {
        if (TextUtils.isEmpty(result)) return 0;
        String[] resS = result.split(":");
        int hour = 0, minute = 0;
        if (resS.length >= 1) {
            hour = Integer.parseInt(resS[0]);
        }
        if (resS.length >= 2) {
            minute = Integer.parseInt(resS[1]);
        }
        return hour * 60 + minute;
    }

    public static Calendar parseStrToCld(String time) {
        Date date = new Date(transferStringDateToLong(null, time));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String[] formatTimer(long sec) {
        String[] s = new String[4];
        long days = sec / (60 * 60 * 24);
        long hours = (sec % (60 * 60 * 24)) / (60 * 60);
        long minutes = (sec % (60 * 60)) / (60);
        long seconds = (sec % (60));
        if (days<10){
            s[0] = "0"+days;
        }else{
            if (days>99){
                s[0] = 99+"";
            }else{
                s[0] = days+"";
            }
        }
        if (hours<10){
            s[1] = "0"+hours;
        }else{
            s[1] = hours+"";
        }
        if (minutes<10){
            s[2] = "0"+minutes;
        }else{
            s[2] = minutes+"";
        }
        if (seconds<10){
            s[3] = "0"+seconds;
        }else{
            s[3] = seconds+"";
        }
        return s;
//        return seconds+"秒/"+minutes + "分钟/"+ hours + "小时/"+days + "天";
    }

    public static long delta = -1;
    public static long getExactlyCurrentTime() {
        return System.currentTimeMillis() - delta;
    }

    public static Date convertTimeToDate(String timestamp) {
        Date date = new Date(Long.parseLong(timestamp));
        return date;
    }

    public static long getCurrentLeftTime(long endTime) {
        Date date = TimeUtil.convertTimeToDate(endTime+"");
//        return date.getTime()-System.currentTimeMillis() - delta;
        return System.currentTimeMillis() - delta-date.getTime();
    }
}
