package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQDownloaderInstalled extends android.content.BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String f1079a = "QQDownloaderInstalled";
    protected static com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled b;
    protected boolean c = false;
    protected com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d d = null;

    private QQDownloaderInstalled() {
    }

    public static synchronized com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled a() {
        if (b == null) {
            b = new com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled();
        }
        return b;
    }

    public void a(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(f1079a, "context = " + context);
        if (this.c) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "registeReceiver   context" + context + "  receiver:" + this);
        try {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "" + context.registerReceiver(this, new android.content.IntentFilter(com.tencent.assistant.sdk.remote.SDKConst.QQDOWNLOADER_FIRST_START_ACTION_NAME)));
            this.c = true;
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "registeReceiver exception!!!");
            this.c = false;
            th.printStackTrace();
        }
    }

    public void a(com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d dVar) {
        com.tencent.tmassistantbase.util.TMLog.i(f1079a, "listener = " + dVar);
        this.d = dVar;
    }

    public void b() {
        com.tencent.tmassistantbase.util.TMLog.i(f1079a, "unregisteListener start");
        this.d = null;
    }

    public void b(android.content.Context context) {
        if (context == null || b == null) {
            com.tencent.tmassistantbase.util.TMLog.i(f1079a, "unRegisteReceiver fail! context = " + context + ",mInstance = " + b);
            return;
        }
        if (this.c) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.c = false;
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
                this.c = false;
                th.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderInstalled", "onReceive!");
        new com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.c(this, context).start();
    }
}
