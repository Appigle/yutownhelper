package com.chenley.an.yutownhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/5/23
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/5/23         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class PayId_bean implements Parcelable {
    /**
     * return_code : SUCCESS
     * return_msg : OK
     * appid : wxb2f356b839e48470
     * mch_id : 1342847001
     * nonce_str : ksO0WXW7TBHqENhv
     * sign : F71FF65E3830D1D3A49C1F11D026845A
     * result_code : SUCCESS
     * prepay_id : wx20160523131341ee362f9d8e0369570834
     * trade_type : APP
     * order_no : YT201605201604194558
     */
    public boolean success;//是否请求成功
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements android.os.Parcelable {
        private String return_code;
        private String return_msg;
        private String appid;
        private String mch_id;
        private String nonce_str;
        private String sign;
        private String result_code;
        private String prepay_id;
        private String trade_type;
        private String order_no;

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.return_code);
            dest.writeString(this.return_msg);
            dest.writeString(this.appid);
            dest.writeString(this.mch_id);
            dest.writeString(this.nonce_str);
            dest.writeString(this.sign);
            dest.writeString(this.result_code);
            dest.writeString(this.prepay_id);
            dest.writeString(this.trade_type);
            dest.writeString(this.order_no);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.return_code = in.readString();
            this.return_msg = in.readString();
            this.appid = in.readString();
            this.mch_id = in.readString();
            this.nonce_str = in.readString();
            this.sign = in.readString();
            this.result_code = in.readString();
            this.prepay_id = in.readString();
            this.trade_type = in.readString();
            this.order_no = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    public PayId_bean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.data, flags);
    }

    protected PayId_bean(Parcel in) {
        this.success = in.readByte() != 0;
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<PayId_bean> CREATOR = new Parcelable.Creator<PayId_bean>() {
        @Override
        public PayId_bean createFromParcel(Parcel source) {
            return new PayId_bean(source);
        }

        @Override
        public PayId_bean[] newArray(int size) {
            return new PayId_bean[size];
        }
    };
}
