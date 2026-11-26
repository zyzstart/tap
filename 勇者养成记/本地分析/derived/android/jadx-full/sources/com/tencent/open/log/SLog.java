package com.tencent.open.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SLog implements com.tencent.open.log.TraceLevel {
    public static final java.lang.String TAG = "openSDK_LOG";
    private static boolean c = false;
    public static com.tencent.open.log.SLog instance;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.open.log.a f706a = new com.tencent.open.log.a(new com.tencent.open.log.b(a(), com.tencent.open.log.c.m, com.tencent.open.log.c.g, com.tencent.open.log.c.h, com.tencent.open.log.c.c, com.tencent.open.log.c.i, 10, com.tencent.open.log.c.e, com.tencent.open.log.c.n));
    private com.tencent.open.log.Tracer b;

    private SLog() {
    }

    protected static java.io.File a() {
        java.lang.String str = com.tencent.open.log.c.d;
        try {
            com.tencent.open.log.d.c cVarB = com.tencent.open.log.d.b.b();
            return cVarB != null && (cVarB.c() > com.tencent.open.log.c.f ? 1 : (cVarB.c() == com.tencent.open.log.c.f ? 0 : -1)) > 0 ? new java.io.File(android.os.Environment.getExternalStorageDirectory(), str) : new java.io.File(com.tencent.open.utils.f.c(), str);
        } catch (java.lang.Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }

    private java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return com.tencent.open.log.d.a(str) ? "xxxxxx" : str;
    }

    public static final void d(java.lang.String str, java.lang.String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    public static final void e(java.lang.String str, java.lang.String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static final void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static com.tencent.open.log.SLog getInstance() {
        if (instance == null) {
            synchronized (com.tencent.open.log.SLog.class) {
                if (instance == null) {
                    instance = new com.tencent.open.log.SLog();
                    c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(java.lang.String str, java.lang.String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static final void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static void release() {
        synchronized (com.tencent.open.log.SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(java.lang.String str, java.lang.String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void u(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(java.lang.String str, java.lang.String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(java.lang.String str, java.lang.String str2) {
        getInstance().a(8, str, str2, null);
    }

    public static final void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    protected void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (c) {
            java.lang.String strB = com.tencent.open.utils.f.b();
            if (!android.text.TextUtils.isEmpty(strB)) {
                java.lang.String str3 = strB + " SDK_VERSION:" + com.tencent.connect.common.Constants.SDK_VERSION;
                if (this.f706a == null) {
                    return;
                }
                com.tencent.open.log.e.f712a.a(32, java.lang.Thread.currentThread(), java.lang.System.currentTimeMillis(), TAG, str3, null);
                this.f706a.a(32, java.lang.Thread.currentThread(), java.lang.System.currentTimeMillis(), TAG, str3, null);
                c = false;
            }
        }
        com.tencent.open.log.e.f712a.a(i, java.lang.Thread.currentThread(), java.lang.System.currentTimeMillis(), str, str2, th);
        if (com.tencent.open.log.d.a.a(com.tencent.open.log.c.b, i)) {
            com.tencent.open.log.a aVar = this.f706a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i, java.lang.Thread.currentThread(), java.lang.System.currentTimeMillis(), str, str2, th);
            }
        }
        com.tencent.open.log.Tracer tracer = this.b;
        if (tracer != null) {
            try {
                tracer.a(i, java.lang.Thread.currentThread(), java.lang.System.currentTimeMillis(), str, a(str2), th);
            } catch (java.lang.Exception e) {
                android.util.Log.e(str, "Exception", e);
            }
        }
    }

    protected void b() {
        com.tencent.open.log.a aVar = this.f706a;
        if (aVar != null) {
            aVar.a();
            this.f706a.b();
            this.f706a = null;
        }
    }

    protected void c() {
        com.tencent.open.log.a aVar = this.f706a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(com.tencent.open.log.Tracer tracer) {
        this.b = tracer;
    }
}
