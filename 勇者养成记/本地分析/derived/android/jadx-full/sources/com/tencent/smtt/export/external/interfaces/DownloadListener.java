package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface DownloadListener {
    void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j);

    void onDownloadStart(java.lang.String str, java.lang.String str2, byte[] bArr, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j, java.lang.String str6, java.lang.String str7);

    void onDownloadVideo(java.lang.String str, long j, int i);
}
