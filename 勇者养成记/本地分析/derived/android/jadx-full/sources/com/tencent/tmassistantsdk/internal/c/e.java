package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantsdk.internal.c.e f1072a;
    private static final java.lang.Class[] b = {com.tencent.tmassistantsdk.internal.c.b.class};
    private final com.tencent.tmassistantbase.network.d c = new com.tencent.tmassistantsdk.internal.c.f(this);

    private e() {
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().a(this.c);
        c();
    }

    public static synchronized com.tencent.tmassistantsdk.internal.c.e a() {
        if (f1072a == null) {
            f1072a = new com.tencent.tmassistantsdk.internal.c.e();
        }
        return f1072a;
    }

    public void b() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmassistantsdk.internal.c.b.class)) {
                    com.tencent.tmassistantsdk.internal.c.b.h().a();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b(this.c);
    }

    public void c() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmassistantsdk.internal.c.b.class)) {
                    com.tencent.tmassistantsdk.internal.c.b.h().c();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        for (java.lang.Class cls : b) {
            try {
                if (cls.equals(com.tencent.tmassistantsdk.internal.c.b.class)) {
                    com.tencent.tmassistantsdk.internal.c.b.h().b();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
