package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {
    private static com.tencent.beaconselfupdate.a.c n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f236a = null;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private byte d = -1;
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";
    private java.lang.String i = "";
    private long j = 0;
    private java.lang.String k = "";
    private java.lang.String l = "";
    private java.lang.String m = "";

    private c() {
    }

    public static synchronized void a(android.content.Context context) {
        com.tencent.beaconselfupdate.a.c cVar;
        java.lang.String strO;
        if (context != null) {
            if (n == null) {
                n = new com.tencent.beaconselfupdate.a.c();
            }
            synchronized (n) {
                com.tencent.beaconselfupdate.c.a.e("init cominfo", new java.lang.Object[0]);
                n.f236a = context;
                com.tencent.beaconselfupdate.a.e.a(context);
                n.b = com.tencent.beaconselfupdate.a.e.a();
                com.tencent.beaconselfupdate.a.c cVar2 = n;
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                stringBuffer.append("Android ");
                stringBuffer.append(com.tencent.beaconselfupdate.a.e.b());
                stringBuffer.append(",level ");
                stringBuffer.append(com.tencent.beaconselfupdate.a.e.c());
                cVar2.c = stringBuffer.toString();
                n.n();
                n.d(com.tencent.beaconselfupdate.a.a.d(context));
                if (com.tencent.beaconselfupdate.a.a.f222a != null) {
                    n.a(com.tencent.beaconselfupdate.a.a.f222a);
                }
                n.e("beacon_selfupdate");
                n.f("1.7.2");
                n.b(android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN);
                n.g(com.tencent.beaconselfupdate.a.e.b(context));
                if (com.tencent.beaconselfupdate.event.UserAction.getAppkey() == null || "[REDACTED]".equals(com.tencent.beaconselfupdate.event.UserAction.getAppkey())) {
                    cVar = n;
                    strO = n.o();
                } else {
                    cVar = n;
                    strO = com.tencent.beaconselfupdate.event.UserAction.getAppkey();
                }
                cVar.h(strO);
                n.c(com.tencent.beaconselfupdate.a.e.c(com.tencent.beaconselfupdate.a.a.a(context)));
            }
        }
    }

    private synchronized void d(java.lang.String str) {
        this.e = str;
    }

    private synchronized void e(java.lang.String str) {
        this.g = str;
    }

    private synchronized void f(java.lang.String str) {
        this.h = str;
    }

    private synchronized void g(java.lang.String str) {
        if (!"".equals(str)) {
            try {
                com.tencent.beaconselfupdate.a.a.a(this.f236a, "IMEI_DENGTA", str);
            } catch (java.lang.Exception unused) {
            }
        }
        this.k = str;
    }

    private synchronized void h(java.lang.String str) {
        this.l = str;
    }

    public static synchronized com.tencent.beaconselfupdate.a.c m() {
        return n;
    }

    private synchronized void n() {
        this.d = (byte) 1;
    }

    private synchronized java.lang.String o() {
        return this.e;
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final synchronized void a(long j) {
        this.j = j;
    }

    public final synchronized void a(java.lang.String str) {
        this.f = str;
    }

    public final java.lang.String b() {
        return this.c;
    }

    public final synchronized void b(java.lang.String str) {
        this.i = str;
    }

    public final synchronized byte c() {
        return this.d;
    }

    public final synchronized void c(java.lang.String str) {
        this.m = str;
    }

    public final synchronized java.lang.String d() {
        return this.f;
    }

    public final synchronized java.lang.String e() {
        return this.g;
    }

    public final synchronized java.lang.String f() {
        return this.h;
    }

    public final synchronized java.lang.String g() {
        return this.i;
    }

    public final synchronized long h() {
        return this.j;
    }

    public final synchronized java.lang.String i() {
        if ("".equals(this.k)) {
            try {
                this.k = com.tencent.beaconselfupdate.a.a.b(this.f236a, "IMEI_DENGTA", "");
            } catch (java.lang.Exception unused) {
            }
        }
        return this.k;
    }

    public final synchronized java.lang.String j() {
        return this.l;
    }

    public final synchronized java.lang.String k() {
        return this.m;
    }

    public final synchronized android.content.Context l() {
        return this.f236a;
    }
}
