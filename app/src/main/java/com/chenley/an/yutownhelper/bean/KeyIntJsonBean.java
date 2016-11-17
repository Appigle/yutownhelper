package com.chenley.an.yutownhelper.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/11/4
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/11/4         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class KeyIntJsonBean
{
  /**
   * apistatus : 1
   * result : {"4":[{"endTime":1480031820000,"id":24,"images":[{"height":200,"id":4,"imageId":"750-200-f5cebca194ba0201f3cef84c4616851d","linkUrl":"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636","width":750},{"height":200,"id":5,"imageId":"750-200-f0005d177254573edd741b6ce55ff1ae","linkUrl":"https://www.google.com.hk/search?q=jenkins&oq=jenkins&aqs=chrome..69i57.3322j0j4&sourceid=chrome&ie=UTF-8","width":750}],"startTime":1477958220000,"typeId":4}],"5":[{"endTime":1479297900000,"id":26,"images":[{"height":200,"id":6,"imageId":"750-200-df0d3ae1715706d173b96ce03060b981","linkUrl":"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636","width":750}],"startTime":1478001900000,"typeId":5}],"6":[],"7":[]}
   */

  private int apistatus;
  private ResultBean result;

  public int getApistatus() {
    return apistatus;
  }

  public void setApistatus(int apistatus) {
    this.apistatus = apistatus;
  }

  public ResultBean getResult() {
    return result;
  }

  public void setResult(ResultBean result) {
    this.result = result;
  }

  public static class ResultBean {
    /**
     * endTime : 1480031820000
     * id : 24
     * images : [{"height":200,"id":4,"imageId":"750-200-f5cebca194ba0201f3cef84c4616851d","linkUrl":"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636","width":750},{"height":200,"id":5,"imageId":"750-200-f0005d177254573edd741b6ce55ff1ae","linkUrl":"https://www.google.com.hk/search?q=jenkins&oq=jenkins&aqs=chrome..69i57.3322j0j4&sourceid=chrome&ie=UTF-8","width":750}]
     * startTime : 1477958220000
     * typeId : 4
     */

    @SerializedName("4") private List<AdBean> value4;
    /**
     * endTime : 1479297900000
     * id : 26
     * images : [{"height":200,"id":6,"imageId":"750-200-df0d3ae1715706d173b96ce03060b981","linkUrl":"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636","width":750}]
     * startTime : 1478001900000
     * typeId : 5
     */

    @SerializedName("5") private List<AdBean> value5;
    @SerializedName("6") private List<AdBean> value6;
    @SerializedName("7") private List<AdBean> value7;

    public List<AdBean> getValue4() {
      return value4;
    }

    public void setValue4(List<AdBean> value4) {
      this.value4 = value4;
    }

    public List<AdBean> getValue5() {
      return value5;
    }

    public void setValue5(List<AdBean> value5) {
      this.value5 = value5;
    }

    public List<AdBean> getValue6() {
      return value6;
    }

    public void setValue6(List<AdBean> value6) {
      this.value6 = value6;
    }

    public List<AdBean> getValue7() {
      return value7;
    }

    public void setValue7(List<AdBean> value7) {
      this.value7 = value7;
    }

    public static class AdBean {
      private long endTime;
      private int id;
      private long startTime;
      private int typeId;
      /**
       * height : 200
       * id : 4
       * imageId : 750-200-f5cebca194ba0201f3cef84c4616851d
       * linkUrl : http://wiki.17shihui.com/pages/viewpage.action?pageId=721636
       * width : 750
       */

      private List<ImagesBean> images;

      public long getEndTime() {
        return endTime;
      }

      public void setEndTime(long endTime) {
        this.endTime = endTime;
      }

      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public long getStartTime() {
        return startTime;
      }

      public void setStartTime(long startTime) {
        this.startTime = startTime;
      }

      public int getTypeId() {
        return typeId;
      }

      public void setTypeId(int typeId) {
        this.typeId = typeId;
      }

      public List<ImagesBean> getImages() {
        return images;
      }

      public void setImages(List<ImagesBean> images) {
        this.images = images;
      }

      public static class ImagesBean {
        private int height;
        private int id;
        private String imageId;
        private String linkUrl;
        private int width;

        public int getHeight() {
          return height;
        }

        public void setHeight(int height) {
          this.height = height;
        }

        public int getId() {
          return id;
        }

        public void setId(int id) {
          this.id = id;
        }

        public String getImageId() {
          return imageId;
        }

        public void setImageId(String imageId) {
          this.imageId = imageId;
        }

        public String getLinkUrl() {
          return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
          this.linkUrl = linkUrl;
        }

        public int getWidth() {
          return width;
        }

        public void setWidth(int width) {
          this.width = width;
        }
      }
    }
      public static class ImagesBean {
        private int height;
        private int id;
        private String imageId;
        private String linkUrl;
        private int width;

        public int getHeight() {
          return height;
        }

        public void setHeight(int height) {
          this.height = height;
        }

        public int getId() {
          return id;
        }

        public void setId(int id) {
          this.id = id;
        }

        public String getImageId() {
          return imageId;
        }

        public void setImageId(String imageId) {
          this.imageId = imageId;
        }

        public String getLinkUrl() {
          return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
          this.linkUrl = linkUrl;
        }

        public int getWidth() {
          return width;
        }

        public void setWidth(int width) {
          this.width = width;
        }
      }
    }
  }
