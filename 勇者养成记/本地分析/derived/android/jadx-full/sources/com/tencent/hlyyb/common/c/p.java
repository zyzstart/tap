package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p implements java.io.Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f563a;
    private java.lang.String b;
    private java.util.Map c;
    private java.lang.String d;
    private java.lang.String e;

    public final java.lang.String a() {
        return this.e;
    }

    public final void a(long j) {
        this.f563a = j;
    }

    public final void a(java.lang.String str) {
        this.e = str;
    }

    public final synchronized void a(java.util.Map map) {
        this.c = map;
    }

    public final java.lang.String b() {
        return this.d;
    }

    public final void b(java.lang.String str) {
        this.d = str;
    }

    public final long c() {
        return this.f563a;
    }

    public final synchronized void c(java.lang.String str) {
        this.b = str;
    }

    public final synchronized java.lang.String d() {
        return this.b;
    }

    public final synchronized java.util.Map e() {
        return this.c;
    }
}
