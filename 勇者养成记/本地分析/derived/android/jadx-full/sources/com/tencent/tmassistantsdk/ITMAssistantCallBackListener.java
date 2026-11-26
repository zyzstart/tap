package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ITMAssistantCallBackListener {
    void OnDownloadTaskProgressChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j, long j2);

    void OnDownloadTaskStateChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i, int i2, java.lang.String str);

    void OnQQDownloaderInvalid();

    void OnServiceFree();
}
