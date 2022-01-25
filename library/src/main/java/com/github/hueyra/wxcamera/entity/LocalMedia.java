package com.github.hueyra.wxcamera.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhujun
 * Date : 2022-01-22
 * Desc : _
 */
public class LocalMedia implements Parcelable {
    private String realPath;
    private String mimeType;
    private String cutPath;

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCutPath() {
        return cutPath;
    }

    public void setCutPath(String cutPath) {
        this.cutPath = cutPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.realPath);
        dest.writeString(this.mimeType);
        dest.writeString(this.cutPath);
    }

    public void readFromParcel(Parcel source) {
        this.realPath = source.readString();
        this.mimeType = source.readString();
        this.cutPath = source.readString();
    }

    public LocalMedia() {
    }

    protected LocalMedia(Parcel in) {
        this.realPath = in.readString();
        this.mimeType = in.readString();
        this.cutPath = in.readString();
    }

    public static final Parcelable.Creator<LocalMedia> CREATOR = new Parcelable.Creator<LocalMedia>() {
        @Override
        public LocalMedia createFromParcel(Parcel source) {
            return new LocalMedia(source);
        }

        @Override
        public LocalMedia[] newArray(int size) {
            return new LocalMedia[size];
        }
    };
}
