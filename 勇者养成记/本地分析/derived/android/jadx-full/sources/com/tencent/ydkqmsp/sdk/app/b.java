package com.tencent.ydkqmsp.sdk.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static final byte[] d = {20, 96, -116, 77, 47, 50, 121};
    private static final byte[] e = {20, 96, -116, 100, 33, 44, 121, -15, 42, 113, -73};
    private static com.tencent.ydkqmsp.sdk.app.b f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f1291a = new java.util.ArrayList();
    private android.os.Handler b;
    private android.os.Handler c;

    private b() {
        this.b = null;
        this.c = null;
        this.b = a(com.tencent.ydkqmsp.sdk.f.k.a(d));
        this.c = a(com.tencent.ydkqmsp.sdk.f.k.a(e));
    }

    private android.os.Handler a(java.lang.String str) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(str);
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        this.f1291a.add(handlerThread);
        return handler;
    }

    public static com.tencent.ydkqmsp.sdk.app.b e() {
        if (f == null) {
            synchronized (com.tencent.ydkqmsp.sdk.app.b.class) {
                if (f == null) {
                    f = new com.tencent.ydkqmsp.sdk.app.b();
                }
            }
        }
        return f;
    }

    public void a(java.lang.Runnable runnable) {
        this.b.post(runnable);
    }

    public boolean a() {
        for (android.os.HandlerThread handlerThread : this.f1291a) {
            if (handlerThread.getName().equalsIgnoreCase(com.tencent.ydkqmsp.sdk.f.k.a(d))) {
                return handlerThread.isAlive();
            }
        }
        return false;
    }

    public android.os.Looper b() {
        return this.c.getLooper();
    }

    public android.os.Looper c() {
        return this.b.getLooper();
    }

    public void d() {
        android.os.Handler handler = this.b;
        if (handler != null) {
            handler.getLooper().quit();
            this.b = null;
        }
        android.os.Handler handler2 = this.c;
        if (handler2 != null) {
            handler2.getLooper().quit();
            this.c = null;
        }
        if (f != null) {
            f = null;
        }
    }
}
