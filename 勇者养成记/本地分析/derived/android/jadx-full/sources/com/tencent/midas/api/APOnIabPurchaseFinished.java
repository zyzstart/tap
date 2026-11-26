package com.tencent.midas.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface APOnIabPurchaseFinished {
    void onIabPurchaseFinished(com.tencent.midas.api.request.APIabResult aPIabResult, com.tencent.midas.api.request.APPurchase aPPurchase);

    void onIabyNeedLogin();
}
