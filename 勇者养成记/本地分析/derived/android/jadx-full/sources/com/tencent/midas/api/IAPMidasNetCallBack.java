package com.tencent.midas.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAPMidasNetCallBack {
    void MidasNetError(java.lang.String str, int i, java.lang.String str2);

    void MidasNetFinish(java.lang.String str, java.lang.String str2);

    void MidasNetStop(java.lang.String str);
}
