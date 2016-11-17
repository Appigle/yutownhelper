package com.chenley.an.yutownhelper.bean;

import java.util.List;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/11/17
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/11/17         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class WeatherBeanS {
  /**
   * reason : successed!
   * result : {"data":{"pubdate":"2016-11-17","pubtime":"18:00:00","realtime":{"city_code":"101020100","city_name":"上海","date":"2016-11-17","time":"18:00:00","week":4,"moon":"十月十八","dataUptime":1479379014,"weather":{"temperature":"16","humidity":"96","info":"阵雨","img":"3"},"wind":{"direct":"东风","power":"1级","offset":null,"windspeed":null}},"life":[],"weather":[{"date":"2016-11-17","info":{"day":["7","小雨","18","东风","微风","06:23"],"night":["7","小雨","16","东风","微风","16:55"]},"week":"四","nongli":"十月十八"},{"date":"2016-11-18","info":{"dawn":["7","小雨","16","东风","微风","16:55"],"day":["7","小雨","22","南风","微风","06:24"],"night":["7","小雨","17","南风","微风","16:54"]},"week":"五","nongli":"十月十九"},{"date":"2016-11-19","info":{"dawn":["7","小雨","17","南风","微风","16:54"],"day":["7","小雨","21","","微风","06:25"],"night":["7","小雨","17","北风","微风","16:54"]},"week":"六","nongli":"十月二十"},{"date":"2016-11-20","info":{"dawn":["7","小雨","17","北风","微风","16:54"],"day":["7","小雨","19","东风","微风","06:25"],"night":["7","小雨","16","东风","微风","16:53"]},"week":"日","nongli":"十月廿一"},{"date":"2016-11-21","info":{"dawn":["7","小雨","16","东风","微风","16:53"],"day":["7","小雨","19","东风","微风","06:26"],"night":["3","阵雨","12","北风","微风","16:53"]},"week":"一","nongli":"十月廿二"}],"f3h":{"temperature":[{"jg":"20161117170000","jb":"16"},{"jg":"20161117200000","jb":"17"},{"jg":"20161117230000","jb":"17"},{"jg":"20161118020000","jb":"17"},{"jg":"20161118050000","jb":"17"},{"jg":"20161118080000","jb":"18"},{"jg":"20161118110000","jb":"21"},{"jg":"20161118140000","jb":"22"},{"jg":"20161118170000","jb":"21"}],"precipitation":[{"jg":"20161117170000","jf":"0"},{"jg":"20161117200000","jf":"0.1"},{"jg":"20161117230000","jf":"0.2"},{"jg":"20161118020000","jf":"0.3"},{"jg":"20161118050000","jf":"1.5"},{"jg":"20161118080000","jf":"1.5"},{"jg":"20161118110000","jf":"0.5"},{"jg":"20161118140000","jf":"0"},{"jg":"20161118170000","jf":"0.1"}]},"pm25":{"key":"Shanghai","show_desc":0,"pm25":{"curPm":"37","pm25":"18","pm10":"23","level":1,"quality":"优","des":"可正常活动。"},"dateTime":"2016年11月17日18时","cityName":"上海"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}}
   * error_code : 0
   */

  private String reason;
  private ResultBean result;
  private int error_code;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ResultBean getResult() {
    return result;
  }

  public void setResult(ResultBean result) {
    this.result = result;
  }

  public int getError_code() {
    return error_code;
  }

  public void setError_code(int error_code) {
    this.error_code = error_code;
  }

  public static class ResultBean {
    /**
     * data : {"pubdate":"2016-11-17","pubtime":"18:00:00","realtime":{"city_code":"101020100","city_name":"上海","date":"2016-11-17","time":"18:00:00","week":4,"moon":"十月十八","dataUptime":1479379014,"weather":{"temperature":"16","humidity":"96","info":"阵雨","img":"3"},"wind":{"direct":"东风","power":"1级","offset":null,"windspeed":null}},"life":[],"weather":[{"date":"2016-11-17","info":{"day":["7","小雨","18","东风","微风","06:23"],"night":["7","小雨","16","东风","微风","16:55"]},"week":"四","nongli":"十月十八"},{"date":"2016-11-18","info":{"dawn":["7","小雨","16","东风","微风","16:55"],"day":["7","小雨","22","南风","微风","06:24"],"night":["7","小雨","17","南风","微风","16:54"]},"week":"五","nongli":"十月十九"},{"date":"2016-11-19","info":{"dawn":["7","小雨","17","南风","微风","16:54"],"day":["7","小雨","21","","微风","06:25"],"night":["7","小雨","17","北风","微风","16:54"]},"week":"六","nongli":"十月二十"},{"date":"2016-11-20","info":{"dawn":["7","小雨","17","北风","微风","16:54"],"day":["7","小雨","19","东风","微风","06:25"],"night":["7","小雨","16","东风","微风","16:53"]},"week":"日","nongli":"十月廿一"},{"date":"2016-11-21","info":{"dawn":["7","小雨","16","东风","微风","16:53"],"day":["7","小雨","19","东风","微风","06:26"],"night":["3","阵雨","12","北风","微风","16:53"]},"week":"一","nongli":"十月廿二"}],"f3h":{"temperature":[{"jg":"20161117170000","jb":"16"},{"jg":"20161117200000","jb":"17"},{"jg":"20161117230000","jb":"17"},{"jg":"20161118020000","jb":"17"},{"jg":"20161118050000","jb":"17"},{"jg":"20161118080000","jb":"18"},{"jg":"20161118110000","jb":"21"},{"jg":"20161118140000","jb":"22"},{"jg":"20161118170000","jb":"21"}],"precipitation":[{"jg":"20161117170000","jf":"0"},{"jg":"20161117200000","jf":"0.1"},{"jg":"20161117230000","jf":"0.2"},{"jg":"20161118020000","jf":"0.3"},{"jg":"20161118050000","jf":"1.5"},{"jg":"20161118080000","jf":"1.5"},{"jg":"20161118110000","jf":"0.5"},{"jg":"20161118140000","jf":"0"},{"jg":"20161118170000","jf":"0.1"}]},"pm25":{"key":"Shanghai","show_desc":0,"pm25":{"curPm":"37","pm25":"18","pm10":"23","level":1,"quality":"优","des":"可正常活动。"},"dateTime":"2016年11月17日18时","cityName":"上海"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}
     */

    private DataBean data;

    public DataBean getData() {
      return data;
    }

    public void setData(DataBean data) {
      this.data = data;
    }

    public static class DataBean {
      /**
       * pubdate : 2016-11-17
       * pubtime : 18:00:00
       * realtime : {"city_code":"101020100","city_name":"上海","date":"2016-11-17","time":"18:00:00","week":4,"moon":"十月十八","dataUptime":1479379014,"weather":{"temperature":"16","humidity":"96","info":"阵雨","img":"3"},"wind":{"direct":"东风","power":"1级","offset":null,"windspeed":null}}
       * life : []
       * weather : [{"date":"2016-11-17","info":{"day":["7","小雨","18","东风","微风","06:23"],"night":["7","小雨","16","东风","微风","16:55"]},"week":"四","nongli":"十月十八"},{"date":"2016-11-18","info":{"dawn":["7","小雨","16","东风","微风","16:55"],"day":["7","小雨","22","南风","微风","06:24"],"night":["7","小雨","17","南风","微风","16:54"]},"week":"五","nongli":"十月十九"},{"date":"2016-11-19","info":{"dawn":["7","小雨","17","南风","微风","16:54"],"day":["7","小雨","21","","微风","06:25"],"night":["7","小雨","17","北风","微风","16:54"]},"week":"六","nongli":"十月二十"},{"date":"2016-11-20","info":{"dawn":["7","小雨","17","北风","微风","16:54"],"day":["7","小雨","19","东风","微风","06:25"],"night":["7","小雨","16","东风","微风","16:53"]},"week":"日","nongli":"十月廿一"},{"date":"2016-11-21","info":{"dawn":["7","小雨","16","东风","微风","16:53"],"day":["7","小雨","19","东风","微风","06:26"],"night":["3","阵雨","12","北风","微风","16:53"]},"week":"一","nongli":"十月廿二"}]
       * f3h : {"temperature":[{"jg":"20161117170000","jb":"16"},{"jg":"20161117200000","jb":"17"},{"jg":"20161117230000","jb":"17"},{"jg":"20161118020000","jb":"17"},{"jg":"20161118050000","jb":"17"},{"jg":"20161118080000","jb":"18"},{"jg":"20161118110000","jb":"21"},{"jg":"20161118140000","jb":"22"},{"jg":"20161118170000","jb":"21"}],"precipitation":[{"jg":"20161117170000","jf":"0"},{"jg":"20161117200000","jf":"0.1"},{"jg":"20161117230000","jf":"0.2"},{"jg":"20161118020000","jf":"0.3"},{"jg":"20161118050000","jf":"1.5"},{"jg":"20161118080000","jf":"1.5"},{"jg":"20161118110000","jf":"0.5"},{"jg":"20161118140000","jf":"0"},{"jg":"20161118170000","jf":"0.1"}]}
       * pm25 : {"key":"Shanghai","show_desc":0,"pm25":{"curPm":"37","pm25":"18","pm10":"23","level":1,"quality":"优","des":"可正常活动。"},"dateTime":"2016年11月17日18时","cityName":"上海"}
       * jingqu :
       * jingqutq :
       * date :
       * isForeign : 0
       */

      private String pubdate;
      private String pubtime;
      private RealtimeBean realtime;
      private F3hBean f3h;
      private Pm25BeanX pm25;
      private String jingqu;
      private String jingqutq;
      private String date;
      private String isForeign;
      private List<?> life;
      private List<WeatherBeanX> weather;

      public String getPubdate() {
        return pubdate;
      }

      public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
      }

      public String getPubtime() {
        return pubtime;
      }

      public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
      }

      public RealtimeBean getRealtime() {
        return realtime;
      }

      public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
      }

      public F3hBean getF3h() {
        return f3h;
      }

      public void setF3h(F3hBean f3h) {
        this.f3h = f3h;
      }

      public Pm25BeanX getPm25() {
        return pm25;
      }

      public void setPm25(Pm25BeanX pm25) {
        this.pm25 = pm25;
      }

      public String getJingqu() {
        return jingqu;
      }

      public void setJingqu(String jingqu) {
        this.jingqu = jingqu;
      }

      public String getJingqutq() {
        return jingqutq;
      }

      public void setJingqutq(String jingqutq) {
        this.jingqutq = jingqutq;
      }

      public String getDate() {
        return date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public String getIsForeign() {
        return isForeign;
      }

      public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
      }

      public List<?> getLife() {
        return life;
      }

      public void setLife(List<?> life) {
        this.life = life;
      }

      public List<WeatherBeanX> getWeather() {
        return weather;
      }

      public void setWeather(List<WeatherBeanX> weather) {
        this.weather = weather;
      }

      public static class RealtimeBean {
        /**
         * city_code : 101020100
         * city_name : 上海
         * date : 2016-11-17
         * time : 18:00:00
         * week : 4
         * moon : 十月十八
         * dataUptime : 1479379014
         * weather : {"temperature":"16","humidity":"96","info":"阵雨","img":"3"}
         * wind : {"direct":"东风","power":"1级","offset":null,"windspeed":null}
         */

        private String city_code;
        private String city_name;
        private String date;
        private String time;
        private int week;
        private String moon;
        private int dataUptime;
        private WeatherBean weather;
        private WindBean wind;

        public String getCity_code() {
          return city_code;
        }

        public void setCity_code(String city_code) {
          this.city_code = city_code;
        }

        public String getCity_name() {
          return city_name;
        }

        public void setCity_name(String city_name) {
          this.city_name = city_name;
        }

        public String getDate() {
          return date;
        }

        public void setDate(String date) {
          this.date = date;
        }

        public String getTime() {
          return time;
        }

        public void setTime(String time) {
          this.time = time;
        }

        public int getWeek() {
          return week;
        }

        public void setWeek(int week) {
          this.week = week;
        }

        public String getMoon() {
          return moon;
        }

        public void setMoon(String moon) {
          this.moon = moon;
        }

        public int getDataUptime() {
          return dataUptime;
        }

        public void setDataUptime(int dataUptime) {
          this.dataUptime = dataUptime;
        }

        public WeatherBean getWeather() {
          return weather;
        }

        public void setWeather(WeatherBean weather) {
          this.weather = weather;
        }

        public WindBean getWind() {
          return wind;
        }

        public void setWind(WindBean wind) {
          this.wind = wind;
        }

        public static class WeatherBean {
          /**
           * temperature : 16
           * humidity : 96
           * info : 阵雨
           * img : 3
           */

          private String temperature;
          private String humidity;
          private String info;
          private String img;

          public String getTemperature() {
            return temperature;
          }

          public void setTemperature(String temperature) {
            this.temperature = temperature;
          }

          public String getHumidity() {
            return humidity;
          }

          public void setHumidity(String humidity) {
            this.humidity = humidity;
          }

          public String getInfo() {
            return info;
          }

          public void setInfo(String info) {
            this.info = info;
          }

          public String getImg() {
            return img;
          }

          public void setImg(String img) {
            this.img = img;
          }
        }

        public static class WindBean {
          /**
           * direct : 东风
           * power : 1级
           * offset : null
           * windspeed : null
           */

          private String direct;
          private String power;
          private Object offset;
          private Object windspeed;

          public String getDirect() {
            return direct;
          }

          public void setDirect(String direct) {
            this.direct = direct;
          }

          public String getPower() {
            return power;
          }

          public void setPower(String power) {
            this.power = power;
          }

          public Object getOffset() {
            return offset;
          }

          public void setOffset(Object offset) {
            this.offset = offset;
          }

          public Object getWindspeed() {
            return windspeed;
          }

          public void setWindspeed(Object windspeed) {
            this.windspeed = windspeed;
          }
        }
      }

      public static class F3hBean {
        private List<TemperatureBean> temperature;
        private List<PrecipitationBean> precipitation;

        public List<TemperatureBean> getTemperature() {
          return temperature;
        }

        public void setTemperature(List<TemperatureBean> temperature) {
          this.temperature = temperature;
        }

        public List<PrecipitationBean> getPrecipitation() {
          return precipitation;
        }

        public void setPrecipitation(List<PrecipitationBean> precipitation) {
          this.precipitation = precipitation;
        }

        public static class TemperatureBean {
          /**
           * jg : 20161117170000
           * jb : 16
           */

          private String jg;
          private String jb;

          public String getJg() {
            return jg;
          }

          public void setJg(String jg) {
            this.jg = jg;
          }

          public String getJb() {
            return jb;
          }

          public void setJb(String jb) {
            this.jb = jb;
          }
        }

        public static class PrecipitationBean {
          /**
           * jg : 20161117170000
           * jf : 0
           */

          private String jg;
          private String jf;

          public String getJg() {
            return jg;
          }

          public void setJg(String jg) {
            this.jg = jg;
          }

          public String getJf() {
            return jf;
          }

          public void setJf(String jf) {
            this.jf = jf;
          }
        }
      }

      public static class Pm25BeanX {
        /**
         * key : Shanghai
         * show_desc : 0
         * pm25 : {"curPm":"37","pm25":"18","pm10":"23","level":1,"quality":"优","des":"可正常活动。"}
         * dateTime : 2016年11月17日18时
         * cityName : 上海
         */

        private String key;
        private int show_desc;
        private Pm25Bean pm25;
        private String dateTime;
        private String cityName;

        public String getKey() {
          return key;
        }

        public void setKey(String key) {
          this.key = key;
        }

        public int getShow_desc() {
          return show_desc;
        }

        public void setShow_desc(int show_desc) {
          this.show_desc = show_desc;
        }

        public Pm25Bean getPm25() {
          return pm25;
        }

        public void setPm25(Pm25Bean pm25) {
          this.pm25 = pm25;
        }

        public String getDateTime() {
          return dateTime;
        }

        public void setDateTime(String dateTime) {
          this.dateTime = dateTime;
        }

        public String getCityName() {
          return cityName;
        }

        public void setCityName(String cityName) {
          this.cityName = cityName;
        }

        public static class Pm25Bean {
          /**
           * curPm : 37
           * pm25 : 18
           * pm10 : 23
           * level : 1
           * quality : 优
           * des : 可正常活动。
           */

          private String curPm;
          private String pm25;
          private String pm10;
          private int level;
          private String quality;
          private String des;

          public String getCurPm() {
            return curPm;
          }

          public void setCurPm(String curPm) {
            this.curPm = curPm;
          }

          public String getPm25() {
            return pm25;
          }

          public void setPm25(String pm25) {
            this.pm25 = pm25;
          }

          public String getPm10() {
            return pm10;
          }

          public void setPm10(String pm10) {
            this.pm10 = pm10;
          }

          public int getLevel() {
            return level;
          }

          public void setLevel(int level) {
            this.level = level;
          }

          public String getQuality() {
            return quality;
          }

          public void setQuality(String quality) {
            this.quality = quality;
          }

          public String getDes() {
            return des;
          }

          public void setDes(String des) {
            this.des = des;
          }
        }
      }

      public static class WeatherBeanX {
        /**
         * date : 2016-11-17
         * info : {"day":["7","小雨","18","东风","微风","06:23"],"night":["7","小雨","16","东风","微风","16:55"]}
         * week : 四
         * nongli : 十月十八
         */

        private String date;
        private InfoBean info;
        private String week;
        private String nongli;

        public String getDate() {
          return date;
        }

        public void setDate(String date) {
          this.date = date;
        }

        public InfoBean getInfo() {
          return info;
        }

        public void setInfo(InfoBean info) {
          this.info = info;
        }

        public String getWeek() {
          return week;
        }

        public void setWeek(String week) {
          this.week = week;
        }

        public String getNongli() {
          return nongli;
        }

        public void setNongli(String nongli) {
          this.nongli = nongli;
        }

        public static class InfoBean {
          private List<String> day;
          private List<String> night;

          public List<String> getDay() {
            return day;
          }

          public void setDay(List<String> day) {
            this.day = day;
          }

          public List<String> getNight() {
            return night;
          }

          public void setNight(List<String> night) {
            this.night = night;
          }
        }
      }
    }
  }
}