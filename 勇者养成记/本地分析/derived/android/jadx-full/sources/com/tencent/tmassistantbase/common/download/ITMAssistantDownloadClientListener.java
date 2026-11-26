package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ITMAssistantDownloadClientListener {
    void OnDownloadSDKTaskProgressChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, long j, long j2);

    void OnDownloadSDKTaskStateChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, int i, int i2, java.lang.String str2);

    void OnDwonloadSDKServiceInvalid(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient);
}
