package com.tencent.tmassistantsdk.internal.openSDK;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DownloadStateChangedReceiver extends android.content.BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String f1078a = "DownloadStateChangedReceiver";
    protected static com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver b;
    protected android.os.Handler d;
    protected android.os.HandlerThread c = new android.os.HandlerThread("downloadStateChangedThread");
    protected boolean e = false;
    java.util.ArrayList f = new java.util.ArrayList();

    public DownloadStateChangedReceiver() {
        this.d = null;
        this.c.start();
        this.d = new android.os.Handler(this.c.getLooper());
    }

    public static synchronized com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver a() {
        if (b == null) {
            b = new com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver();
        }
        return b;
    }

    public void a(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(f1078a, "context = " + context);
        if (this.e) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("DownloadStateChangedReceiver", "registeReceiver   context" + context + "  receiver:" + this);
        try {
            com.tencent.tmassistantbase.util.TMLog.i("DownloadStateChangedReceiver", "" + context.registerReceiver(this, new android.content.IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action")));
            this.e = true;
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.TMLog.i("DownloadStateChangedReceiver", "registeReceiver exception!!!");
            this.e = false;
            th.printStackTrace();
        }
    }

    public void a(com.tencent.tmassistantsdk.internal.openSDK.b bVar) {
        com.tencent.tmassistantbase.util.TMLog.i(f1078a, "listener = " + bVar);
        if (bVar == null || this.f.contains(bVar)) {
            return;
        }
        this.f.add(bVar);
    }

    public void b(android.content.Context context) {
        if (context == null || b == null) {
            com.tencent.tmassistantbase.util.TMLog.i(f1078a, "unRegisteReceiver fail! context = " + context + ",mInstance = " + b);
            return;
        }
        if (this.e) {
            com.tencent.tmassistantbase.util.TMLog.i("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.e = false;
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.TMLog.i("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!", th);
                this.e = false;
                th.printStackTrace();
            }
        }
    }

    public void b(com.tencent.tmassistantsdk.internal.openSDK.b bVar) {
        com.tencent.tmassistantbase.util.TMLog.i(f1078a, "listener = " + bVar);
        if (bVar != null) {
            this.f.remove(bVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i(f1078a, "context = " + context + ",intent = " + intent);
        android.os.Handler handler = this.d;
        if (handler != null) {
            handler.post(new com.tencent.tmassistantsdk.internal.openSDK.a(this, intent));
        }
    }
}
