package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f220a;
    private int b;
    private int c;
    private java.util.List d = java.util.Collections.synchronizedList(new java.util.ArrayList());

    public java.util.List a() {
        return this.d;
    }

    public synchronized void a(int i) {
        this.f220a = i;
    }

    public synchronized int b() {
        return this.c;
    }

    public synchronized void b(int i) {
        this.c = i;
    }

    public synchronized int c() {
        return this.b;
    }

    public synchronized void c(int i) {
        this.b = i;
    }
}
