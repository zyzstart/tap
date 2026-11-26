package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ThirdStatisticsImpl {
    void init(android.app.Activity activity, java.lang.String str, java.lang.String str2);

    void onBegin(java.lang.String str);

    void onChargeRequest(java.lang.String str, java.lang.String str2, double d, java.lang.String str3, double d2, java.lang.String str4);

    void onChargeSuccess(java.lang.String str);

    void onCompleted(java.lang.String str);

    void onEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

    void onFailed(java.lang.String str, java.lang.String str2);

    void onPause(android.app.Activity activity);

    void onPurchase(java.lang.String str, int i, double d);

    void onResume(android.app.Activity activity);

    void onReward(double d, java.lang.String str);

    void onUse(java.lang.String str, int i);

    void setAccount(java.lang.String str);

    void setAccountName(java.lang.String str);

    void setAccountType(int i);

    void setAge(int i);

    void setCreateAccount();

    void setGameServer(java.lang.String str);

    void setGender(int i);

    void setLevel(int i);
}
