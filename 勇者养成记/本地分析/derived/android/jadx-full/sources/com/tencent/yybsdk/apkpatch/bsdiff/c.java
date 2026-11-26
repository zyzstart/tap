package com.tencent.yybsdk.apkpatch.bsdiff;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1396a;
    private int b;
    private int c;

    public c() {
    }

    public c(java.io.InputStream inputStream) {
        this.f1396a = com.tencent.yybsdk.apkpatch.bsdiff.e.a(inputStream);
        this.b = com.tencent.yybsdk.apkpatch.bsdiff.e.a(inputStream);
        this.c = com.tencent.yybsdk.apkpatch.bsdiff.e.a(inputStream);
    }

    public int a() {
        return this.f1396a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public java.lang.String toString() {
        return this.f1396a + ", " + this.b + ", " + this.c;
    }
}
