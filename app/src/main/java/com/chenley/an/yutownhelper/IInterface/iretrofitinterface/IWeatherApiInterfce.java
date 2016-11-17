package com.chenley.an.yutownhelper.iinterface.iretrofitinterface;

import com.chenley.an.yutownhelper.bean.WeatherBeanS;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/11/17
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/11/17         Chenley             2.0                2.0
 * Why & What is odified:
 */
public interface IWeatherApiInterfce {

  @GET("/onebox/weather/query") Observable<WeatherBeanS> getWeatherData(@Query("cityname") String cityName);
}
