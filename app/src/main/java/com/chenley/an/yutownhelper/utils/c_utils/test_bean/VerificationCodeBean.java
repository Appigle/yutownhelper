package com.chenley.an.yutownhelper.utils.c_utils.test_bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/5/6
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/5/6         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class VerificationCodeBean implements Parcelable {
    @Override
    public String toString() {
        return "VerificationCodeBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    /**
 * success : true
 * code : 100
 * message : success
 */

private boolean success;
private int code;
private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(success ? (byte) 1 : (byte) 0);
        dest.writeInt(this.code);
        dest.writeString(this.message);
    }

    public VerificationCodeBean() {
    }

    protected VerificationCodeBean(Parcel in) {
        this.success = in.readByte() != 0;
        this.code = in.readInt();
        this.message = in.readString();
    }

    public static final Parcelable.Creator<VerificationCodeBean> CREATOR = new Parcelable.Creator<VerificationCodeBean>() {
        @Override
        public VerificationCodeBean createFromParcel(Parcel source) {
            return new VerificationCodeBean(source);
        }

        @Override
        public VerificationCodeBean[] newArray(int size) {
            return new VerificationCodeBean[size];
        }
    };
}
