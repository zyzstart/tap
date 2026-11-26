package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f1081a;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled b;

    c(com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled qQDownloaderInstalled, android.content.Context context) {
        this.b = qQDownloaderInstalled;
        this.f1081a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d dVar = this.b.d;
        if (dVar != null) {
            dVar.onQQDownloaderInstalled(this.f1081a);
        }
    }
}
