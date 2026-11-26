package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAPHttpAns {
    void onError(com.pay.http.APBaseHttpReq aPBaseHttpReq, int i, java.lang.String str);

    void onFinish(com.pay.http.APBaseHttpReq aPBaseHttpReq);

    void onReceive(byte[] bArr, int i, long j, com.pay.http.APBaseHttpReq aPBaseHttpReq);

    void onStart(com.pay.http.APBaseHttpReq aPBaseHttpReq);

    void onStop(com.pay.http.APBaseHttpReq aPBaseHttpReq);
}
