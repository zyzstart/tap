package com.tencent.ydkqmsp.sdk.g.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1368a;
    public long b;
    public java.lang.String c;
    public java.lang.String d;

    public b(java.lang.String str) {
        this.c = str;
    }

    public void a(int i) {
        this.f1368a = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(java.lang.String str) {
        this.d = str;
    }

    public boolean a() {
        return this.b > java.lang.System.currentTimeMillis();
    }

    public void b() {
        this.b = 0L;
    }
}
