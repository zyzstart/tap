package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.yybsdk.apkpatch.d.d f1405a;
    private long b;
    private long c;
    private long d;
    private long e;

    public c(com.tencent.yybsdk.apkpatch.d.d dVar) {
        this.f1405a = dVar;
    }

    public long a() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public long b() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public long c() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public long d() {
        return this.e;
    }

    public void d(long j) {
        this.e = j;
    }

    public java.lang.String toString() {
        return "Event [key=" + this.f1405a + ", startTime=" + this.b + ", endTime=" + this.c + ", costTime=" + this.d + ", latestStartTime=" + this.e + "]";
    }
}
