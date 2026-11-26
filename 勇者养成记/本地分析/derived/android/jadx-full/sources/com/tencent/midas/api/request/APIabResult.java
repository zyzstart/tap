package com.tencent.midas.api.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APIabResult {
    java.lang.String mMessage;
    int mResponse;

    public APIabResult(int i, java.lang.String str) {
        java.lang.String responseDesc;
        this.mResponse = i;
        if (str == null || str.trim().length() == 0) {
            responseDesc = getResponseDesc(i);
        } else {
            responseDesc = str + " (response: " + getResponseDesc(i) + ")";
        }
        this.mMessage = responseDesc;
    }

    public static java.lang.String getResponseDesc(int i) {
        return "";
    }

    public java.lang.String getMessage() {
        return this.mMessage;
    }

    public int getResponse() {
        return this.mResponse;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public boolean isPendig() {
        return this.mResponse == 101;
    }

    public boolean isSuccess() {
        return this.mResponse == 0;
    }

    public java.lang.String toString() {
        return "IabResult: " + getMessage();
    }
}
