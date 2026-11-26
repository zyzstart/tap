package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {
    private long b;
    private long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1458a = "";
    private java.lang.String c = "";
    private java.lang.String e = "";

    private void b(java.lang.String str) {
        this.c = str;
    }

    private java.lang.String c(long j) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.lang.Long.valueOf(j));
    }

    private void c(java.lang.String str) {
        this.e = str;
    }

    public java.lang.String a() {
        return this.f1458a;
    }

    public void a(long j) {
        this.b = j;
        b(c(j));
        com.unisound.b.i.d("responseHeaderTime = " + j);
    }

    public void a(java.lang.String str) {
        this.f1458a = str;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.d = j;
        c(c(j));
        com.unisound.b.i.d("responseCurrentSystemTime = " + j);
    }

    public java.lang.String c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public java.lang.String e() {
        return this.e;
    }
}
