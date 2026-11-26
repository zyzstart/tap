package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.a.c.c f1187a;
    private android.content.Context b;
    private byte c;
    private java.lang.String d;
    private java.lang.String f;
    private long g;
    private java.lang.String e = "";
    private java.lang.String h = "";
    private java.lang.String i = "";
    private java.lang.String j = "";
    private java.lang.String k = "";
    private boolean l = true;

    public c() {
        this.c = (byte) -1;
        this.d = "";
        this.f = "";
        this.c = (byte) 1;
        this.d = "ydkbeacon";
        this.f = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static com.tencent.ydkbeacon.a.c.c d() {
        if (f1187a == null) {
            synchronized (com.tencent.ydkbeacon.a.c.c.class) {
                if (f1187a == null) {
                    f1187a = new com.tencent.ydkbeacon.a.c.c();
                }
            }
        }
        return f1187a;
    }

    public com.tencent.ydkbeacon.module.BeaconModule a(com.tencent.ydkbeacon.module.ModuleName moduleName) {
        return (com.tencent.ydkbeacon.module.BeaconModule) com.tencent.ydkbeacon.module.BeaconModule.f1265a.get(moduleName);
    }

    public java.lang.String a() {
        return this.i;
    }

    public synchronized void a(long j) {
        this.g = j;
    }

    public synchronized void a(android.content.Context context) {
        if (this.b == null) {
            this.b = context.getApplicationContext();
        }
    }

    public void a(java.lang.String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public synchronized java.lang.String b() {
        return this.f;
    }

    public void b(java.lang.String str) {
        this.f = str;
    }

    public synchronized android.content.Context c() {
        return this.b;
    }

    public void c(java.lang.String str) {
        this.h = str;
    }

    public java.lang.String e() {
        return this.k;
    }

    @android.support.annotation.NonNull
    public java.lang.String f() {
        return this.h;
    }

    public synchronized byte g() {
        return this.c;
    }

    public synchronized java.lang.String h() {
        return this.d;
    }

    public java.lang.String i() {
        return "4.1.18";
    }

    public synchronized long j() {
        return this.g;
    }

    public java.lang.String k() {
        return this.j;
    }
}
