package com.tencent.ysdk.module.antiaddiction.listener;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface AntiAddictListener {
    void onLoginLimitNotify(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet);

    void onTimeLimitNotify(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet);
}
