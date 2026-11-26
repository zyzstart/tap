package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.info.c f185a = null;
    public static java.lang.String b = null;
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    private final android.content.Context e;
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private java.lang.String n;
    private java.lang.String o;
    private java.lang.String p;

    private c(android.content.Context context) {
        java.lang.String str;
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] create detail user info failed.", new java.lang.Object[0]);
        }
        this.e = context;
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        this.m = eVarD.b(context);
        java.lang.String strI = eVarD.i(context);
        this.k = strI;
        if (com.tencent.beacon.core.e.j.b(strI)) {
            this.k = eVarD.e(context);
        }
        this.l = eVarD.h(context);
        this.o = eVarD.d();
        this.p = eVarD.q() + "m";
        if (com.tencent.beacon.core.d.k.a(context).f()) {
            str = "" + eVarD.l();
        } else {
            str = "";
        }
        this.n = str;
        b(context);
        this.h = eVarD.g(context);
        this.i = eVarD.j(context);
        this.j = eVarD.k();
    }

    public static synchronized com.tencent.beacon.core.info.c a(android.content.Context context) {
        if (f185a == null) {
            f185a = new com.tencent.beacon.core.info.c(context);
        }
        return f185a;
    }

    private void b(android.content.Context context) {
        com.tencent.beacon.core.a.f fVarB;
        java.lang.String strF = com.tencent.beacon.core.info.e.d(context).f(context);
        this.g = strF;
        if (!com.tencent.beacon.core.e.j.b(strF)) {
            try {
                com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
                if (com.tencent.beacon.core.info.f.a() != 1) {
                    if (com.tencent.beacon.core.e.j.b(fVarA.a("IMEI_DENGTA", ""))) {
                        fVarB = fVarA.b().a("IMEI_DENGTA", (java.lang.Object) this.g);
                        fVarB.a();
                    }
                } else if (com.tencent.beacon.core.e.j.b(fVarA.a("IMEI_DENGTA", "imei_v2", ""))) {
                    fVarB = fVarA.b().b("imei_v2", this.g);
                    fVarB.a();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.tencent.beacon.core.e.d.d("[core] imei: " + this.g, new java.lang.Object[0]);
    }

    public synchronized java.lang.String a() {
        return this.m;
    }

    public java.lang.String b() {
        return this.n;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.lang.String c() {
        if (com.tencent.beacon.core.e.j.b(this.g)) {
            this.g = com.tencent.beacon.core.info.f.a() != 1 ? com.tencent.beacon.core.a.f.a(this.e).a("IMEI_DENGTA", "") : com.tencent.beacon.core.a.f.a(this.e).a("IMEI_DENGTA", "imei_v2", "");
        }
        return this.g;
    }

    public java.lang.String d() {
        return this.h;
    }

    public synchronized java.lang.String e() {
        return this.l;
    }

    public synchronized java.lang.String f() {
        return this.k;
    }

    public java.lang.String g() {
        return this.j;
    }

    public java.lang.String h() {
        return this.i;
    }

    public synchronized java.lang.String i() {
        return b;
    }

    public synchronized java.lang.String j() {
        return c;
    }

    public synchronized java.lang.String k() {
        return d;
    }

    public synchronized java.lang.String l() {
        if (com.tencent.beacon.core.e.j.b(this.f)) {
            this.f = "" + this.e.getApplicationInfo().targetSdkVersion;
        }
        return this.f;
    }
}
