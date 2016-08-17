package com.chenley.an.yutownhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      15/8/16 10:58
 * Description: 基类数据结构
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 15/8/16      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class BaseModel implements Parcelable {
    public String message;//描述信息
    public boolean success;//是否请求成功

    @Override
    public String toString() {
        return "BaseModel{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public BaseModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
    }

    protected BaseModel(Parcel in) {
        this.message = in.readString();
        this.success = in.readByte() != 0;
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel source) {
            return new BaseModel(source);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };
}
