package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h implements java.io.Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f262a = -1;
    private java.lang.String b;
    private long c;
    private java.lang.String d;
    private java.util.Map e;
    private boolean f;

    public final synchronized long a() {
        return this.f262a;
    }

    public final synchronized void a(long j) {
        this.f262a = j;
    }

    public final synchronized void a(java.lang.String str) {
        this.b = str;
    }

    public final synchronized void a(java.util.Map map) {
        this.e = map;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final synchronized java.lang.String b() {
        return this.b;
    }

    public final synchronized void b(long j) {
        this.c = j;
    }

    public final synchronized void b(java.lang.String str) {
        this.d = str;
    }

    public final synchronized long c() {
        return this.c;
    }

    public final synchronized java.lang.String d() {
        return this.d;
    }

    public final synchronized java.util.Map e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }
}
