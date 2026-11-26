package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.logreport.i f1140a;
    protected static final java.lang.Class[] b = {com.tencent.tmdownloader.internal.logreport.c.class, com.tencent.tmdownloader.internal.logreport.g.class, com.tencent.tmdownloader.internal.logreport.d.class};
    private final com.tencent.tmassistantbase.network.d c = new com.tencent.tmdownloader.internal.logreport.j(this);

    private i() {
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().a(this.c);
    }

    public static synchronized com.tencent.tmdownloader.internal.logreport.i a() {
        if (f1140a == null) {
            f1140a = new com.tencent.tmdownloader.internal.logreport.i();
        }
        return f1140a;
    }

    public void b() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.e.class)) {
                    com.tencent.tmdownloader.internal.logreport.c.h().a();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.g.class)) {
                    com.tencent.tmdownloader.internal.logreport.g.h().a();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.d.class)) {
                    com.tencent.tmdownloader.internal.logreport.d.h().a();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.tencent.tmassistantbase.util.TMLog.w("LogReportManager", "exception:", e);
            }
        }
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b(this.c);
    }

    public void c() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.c.class)) {
                    com.tencent.tmdownloader.internal.logreport.c.h().c();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.g.class)) {
                    com.tencent.tmdownloader.internal.logreport.g.h().c();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.tencent.tmassistantbase.util.TMLog.w("LogReportManager", "exception:", e);
            }
        }
    }

    public void d() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.c.class)) {
                    com.tencent.tmdownloader.internal.logreport.c.h().b();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.g.class)) {
                    com.tencent.tmdownloader.internal.logreport.g.h().b();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.d.class)) {
                    com.tencent.tmdownloader.internal.logreport.d.h().b();
                }
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w("LogReportManager", "exception:", e);
                e.printStackTrace();
            }
        }
    }
}
