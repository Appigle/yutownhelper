package com.chenley.an.yutownhelper.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/10/16
 * Description: Java 注解类
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/10/16         Chenley             2.0                2.0
 * Why & What is modified:
 */
@Retention(RetentionPolicy.RUNTIME)  //运行时注解
@Inherited //子类继承注解
@Documented
public @interface MyAnnotation {
  String value() default "000";
  String name();
  int age();
  String[] newNames();
}