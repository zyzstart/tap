package com.tencent.yybsdk.apkpatch.bsdiff;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class InvalidHeaderException extends java.lang.Exception {
    public InvalidHeaderException() {
    }

    public InvalidHeaderException(java.lang.String str) {
        super(str);
    }

    public InvalidHeaderException(java.lang.String str, int i) {
        super("Invalid header field; " + str + " = " + i);
    }
}
