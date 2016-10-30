package com.chenley.an.yutownhelper.annotation.annotationuse;

import com.chenley.an.yutownhelper.annotation.Entity;
import com.chenley.an.yutownhelper.annotation.Getter;
import com.chenley.an.yutownhelper.annotation.Optional;
import com.chenley.an.yutownhelper.annotation.Persistent;
import java.util.ArrayList;
import java.util.List;

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
@Entity //类注解
public class Vehicles {
  @Persistent//成员变量注解
  protected String vehicleName;

  @Getter//方法注解
  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(@Optional /*参数注解*/  String vehicleName) {
    this.vehicleName = vehicleName;
  }

  public List addVehicleNameToList(List vehicleNames) {
    @Optional //局部变量注解
    List localTableName = null;
    if (localTableName == null) {
      localTableName = new ArrayList();
    }
    localTableName.add(getVehicleName());
    return localTableName;
  }
}