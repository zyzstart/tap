package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f188a;
    private boolean b = false;
    public java.lang.String c = "";
    private java.util.Map d = null;
    private java.util.Set e = null;
    private java.util.Set f = null;
    private java.lang.Object g = null;

    public b(int i) {
        this.f188a = i;
    }

    public java.util.Map a() {
        return this.d;
    }

    public void a(java.lang.Object obj) {
        this.g = obj;
    }

    public void a(java.lang.String str) {
        if (this.f188a == 1 && com.tencent.beacon.core.strategy.c.g().b) {
            com.tencent.beacon.core.e.d.i("[strategy] user event url has defined by api, don't change.", new java.lang.Object[0]);
        } else {
            this.c = str;
        }
    }

    public void a(java.util.Map map) {
        this.d = map;
    }

    public void a(java.util.Set set) {
        this.e = set;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public java.util.Set b() {
        return this.e;
    }

    public void b(java.util.Set set) {
        this.f = set;
    }

    public java.util.Set c() {
        return this.f;
    }

    public java.lang.String d() {
        java.lang.String strA = com.tencent.beacon.core.c.a.b.a(!com.tencent.beacon.core.strategy.c.g().a(), (!com.tencent.beacon.core.strategy.c.g().d()) & com.tencent.beacon.core.e.d.a(), this.c);
        com.tencent.beacon.core.e.d.a("[strategy] module strategy url: %s", strA);
        return strA;
    }

    public int e() {
        return this.f188a;
    }

    public boolean f() {
        return this.b;
    }
}
