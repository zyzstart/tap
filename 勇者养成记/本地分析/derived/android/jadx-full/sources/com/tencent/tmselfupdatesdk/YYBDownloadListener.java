package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface YYBDownloadListener {
    void onCheckDownloadYYBState(java.lang.String str, int i, long j, long j2);

    void onDownloadYYBProgressChanged(java.lang.String str, long j, long j2);

    void onDownloadYYBStateChanged(java.lang.String str, int i, int i2, java.lang.String str2);
}
