package com.chenley.an.yutownhelper.annotation.annotationuse;

import com.chenley.an.yutownhelper.annotation.MyAnnotation;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/10/16
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/10/16         Chenley             2.0                2.0
 * Why & What is modified:
 */
@MyAnnotation(value = "123"
    , name = "name"
    , age = 22
    , newNames = { "张三", "李四" })
public class MyClass {
  //TODO some
}