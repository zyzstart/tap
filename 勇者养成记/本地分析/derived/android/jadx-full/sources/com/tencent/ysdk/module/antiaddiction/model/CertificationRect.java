package com.tencent.ysdk.module.antiaddiction.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CertificationRect {
    private int mAdultType;
    private int mErrorCode;
    private int mIsRealName;
    private java.lang.String mMsg;

    public CertificationRect(int i, int i2) {
        this.mErrorCode = -1;
        this.mMsg = "";
        this.mIsRealName = -1;
        this.mAdultType = -1;
        this.mErrorCode = 0;
        this.mIsRealName = i;
        this.mAdultType = i2;
    }

    public CertificationRect(int i, java.lang.String str) {
        this.mErrorCode = -1;
        this.mMsg = "";
        this.mIsRealName = -1;
        this.mAdultType = -1;
        this.mErrorCode = i;
        this.mMsg = str;
    }

    public int getAdultType() {
        return this.mAdultType;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public java.lang.String getMsg() {
        return this.mMsg;
    }

    public int isRealName() {
        return this.mIsRealName;
    }

    public java.lang.String toString() {
        return "CertificationRect{mErrorCode=" + this.mErrorCode + ", mMsg='" + this.mMsg + "', mIsRealName=" + this.mIsRealName + ", mAdultType=" + this.mAdultType + '}';
    }
}
