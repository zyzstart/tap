package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum BodyType {
    JSON("application/json; charset=utf-8"),
    FORM("application/x-www-form-urlencoded"),
    DATA("multipart/form-data");

    public java.lang.String httpType;

    BodyType(java.lang.String str) {
        this.httpType = str;
    }
}
