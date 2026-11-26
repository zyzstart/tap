package com.tencent.tmassistantbase.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1018a = false;
    public static int b = 0;
    private static volatile boolean d = false;
    private static com.tencent.tmassistantbase.common.a e = null;
    private static java.lang.String g = "ANDROIDJXLH.YYB.xx.xx";
    private static final java.lang.Object h = new java.lang.Object();
    private android.content.Context c;
    private volatile int f = 0;

    private a() {
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        this.c = contextB;
        a(contextB);
    }

    public static com.tencent.tmassistantbase.common.a a() {
        if (e == null) {
            synchronized (h) {
                if (e == null) {
                    e = new com.tencent.tmassistantbase.common.a();
                }
            }
        }
        return e;
    }

    private void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        this.f = com.tencent.tmassistantbase.common.e.a().c();
        com.tencent.tmassistantbase.util.TMLog.i("GlobalManager", "<GlobalManager#initServerAddress> mServerType = " + this.f);
    }

    public static boolean b() {
        return f1018a;
    }

    public synchronized void a(int i) {
        com.tencent.tmassistantbase.util.TMLog.i("GlobalManager", "<GlobalManager#setServerTypeDebugMode> server type = " + i);
        if (this.f != i) {
            this.f = i;
            com.tencent.tmassistantbase.util.TMLog.i("GlobalManager", "<GlobalManager#setServerTypeDebugMode> mServerType=" + this.f);
            com.tencent.tmassistantbase.common.e.a().a(this.f);
            com.tencent.tmassistantbase.util.TMLog.i("GlobalManager", "<GlobalManager#setServerTypeDebugMode> Settings.get().setServerAddress(mServerType),mServerType=" + this.f);
        }
    }

    public void a(boolean z) {
        android.util.Log.i("GlobalManager", "switchLog iddev = " + z);
        f1018a = z;
    }

    public synchronized java.lang.String c() {
        java.lang.String str;
        str = com.tencent.tmassistantbase.common.g.c;
        this.f = com.tencent.tmassistantbase.common.e.a().c();
        int i = this.f;
        if (i == 0) {
            str = com.tencent.tmassistantbase.common.g.c;
        } else if (i == 1) {
            str = com.tencent.tmassistantbase.common.g.b;
        } else if (i == 2) {
            str = com.tencent.tmassistantbase.common.g.f1024a;
        }
        com.tencent.tmassistantbase.util.TMLog.i("GlobalManager", "<GlobalManager#getSeverAdress> servelUrl = " + str + ",mServerType = " + this.f);
        return str;
    }
}
