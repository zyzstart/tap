package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ITMSelfUpdateListener {
    void onDownloadAppProgressChanged(long j, long j2);

    void onDownloadAppStateChanged(int i, int i2, java.lang.String str);

    void onUpdateInfoReceived(com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo tMSelfUpdateUpdateInfo);
}
