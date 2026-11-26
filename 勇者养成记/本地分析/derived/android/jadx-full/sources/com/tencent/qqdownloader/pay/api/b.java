package com.tencent.qqdownloader.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.tencent.qqdownloader.pay.api.b f756a;
    private static java.lang.Object b = new java.lang.Object();
    private com.tencent.qqdownloader.pay.api.IQQDownloaderApi c = null;

    private b() {
    }

    public static com.tencent.qqdownloader.pay.api.b a() {
        if (f756a == null) {
            synchronized (b) {
                f756a = new com.tencent.qqdownloader.pay.api.b();
            }
        }
        return f756a;
    }

    public void a(android.content.Intent intent) {
        com.tencent.qqdownloader.pay.api.IQQDownloaderApi iQQDownloaderApi = this.c;
        if (iQQDownloaderApi != null) {
            iQQDownloaderApi.handler(intent);
        }
    }

    public void a(com.tencent.qqdownloader.pay.api.IQQDownloaderApi iQQDownloaderApi) {
        this.c = iQQDownloaderApi;
    }
}
