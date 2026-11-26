package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAPHttpAnsObserver {
    void onError(com.pay.http.APBaseHttpAns aPBaseHttpAns);

    void onFinish(com.pay.http.APBaseHttpAns aPBaseHttpAns);

    void onStop(com.pay.http.APBaseHttpAns aPBaseHttpAns);
}
