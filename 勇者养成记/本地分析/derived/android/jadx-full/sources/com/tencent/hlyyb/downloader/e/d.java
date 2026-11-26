package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f625a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[com.tencent.hlyyb.downloader.e.e.values().length];
        b = iArr;
        try {
            iArr[com.tencent.hlyyb.downloader.e.e.Inform_Pending.ordinal()] = 1;
        } catch (java.lang.NoSuchFieldError unused) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Started.ordinal()] = 2;
        } catch (java.lang.NoSuchFieldError unused2) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Detected.ordinal()] = 3;
        } catch (java.lang.NoSuchFieldError unused3) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Received.ordinal()] = 4;
        } catch (java.lang.NoSuchFieldError unused4) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Paused.ordinal()] = 5;
        } catch (java.lang.NoSuchFieldError unused5) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Failed.ordinal()] = 6;
        } catch (java.lang.NoSuchFieldError unused6) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Succeed.ordinal()] = 7;
        } catch (java.lang.NoSuchFieldError unused7) {
        }
        try {
            b[com.tencent.hlyyb.downloader.e.e.Inform_Deleted.ordinal()] = 8;
        } catch (java.lang.NoSuchFieldError unused8) {
        }
        int[] iArr2 = new int[com.tencent.hlyyb.downloader.DownloaderTaskStatus.values().length];
        f625a = iArr2;
        try {
            iArr2[com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING.ordinal()] = 1;
        } catch (java.lang.NoSuchFieldError unused9) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.STARTED.ordinal()] = 2;
        } catch (java.lang.NoSuchFieldError unused10) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.DOWNLOADING.ordinal()] = 3;
        } catch (java.lang.NoSuchFieldError unused11) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.COMPLETE.ordinal()] = 4;
        } catch (java.lang.NoSuchFieldError unused12) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED.ordinal()] = 5;
        } catch (java.lang.NoSuchFieldError unused13) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.PAUSED.ordinal()] = 6;
        } catch (java.lang.NoSuchFieldError unused14) {
        }
        try {
            f625a[com.tencent.hlyyb.downloader.DownloaderTaskStatus.DELETED.ordinal()] = 7;
        } catch (java.lang.NoSuchFieldError unused15) {
        }
    }
}
