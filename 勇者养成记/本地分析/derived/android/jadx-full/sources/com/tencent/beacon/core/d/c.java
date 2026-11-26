package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.beacon.core.d.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f150a = 0;
    private long b = 0;
    private int c = 0;
    private long d = 0;
    private java.lang.String e = "";

    @Override // com.tencent.beacon.core.d.d
    public void a() {
        com.tencent.beacon.core.e.d.h("[stat] request time out!!!", new java.lang.Object[0]);
    }

    public synchronized void a(int i) {
        this.c = i;
    }

    @Override // com.tencent.beacon.core.d.d
    public synchronized void a(long j, long j2) {
        com.tencent.beacon.core.e.d.h("[stat] received: %d", java.lang.Long.valueOf(j));
        this.b += j;
        this.d = j2;
    }

    @Override // com.tencent.beacon.core.d.d
    public synchronized void a(java.lang.String str, long j, java.lang.String str2, int i) {
        com.tencent.beacon.core.e.d.h("[stat] send: %s sz: %d apn: %s", str, java.lang.Long.valueOf(j), str2);
        this.e = str2;
        this.c++;
        this.f150a += j;
        a(i);
    }

    public synchronized java.lang.String b() {
        return this.e;
    }

    public synchronized long c() {
        return this.d;
    }

    public synchronized long d() {
        return this.b;
    }

    public synchronized int e() {
        return this.c;
    }

    public synchronized long f() {
        return this.f150a;
    }
}
