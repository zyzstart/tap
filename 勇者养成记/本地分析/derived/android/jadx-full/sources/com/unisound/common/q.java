package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class q implements java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.common.l f1499a;
    private final java.lang.String b;
    private final long c;
    private final java.io.InputStream[] d;

    private q(com.unisound.common.l lVar, java.lang.String str, long j, java.io.InputStream[] inputStreamArr) {
        this.f1499a = lVar;
        this.b = str;
        this.c = j;
        this.d = inputStreamArr;
    }

    /* synthetic */ q(com.unisound.common.l lVar, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, com.unisound.common.m mVar) {
        this(lVar, str, j, inputStreamArr);
    }

    public com.unisound.common.n a() {
        return this.f1499a.a(this.b, this.c);
    }

    public java.io.InputStream a(int i) {
        return this.d[i];
    }

    public java.lang.String b(int i) {
        return com.unisound.common.l.c(a(i));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (java.io.InputStream inputStream : this.d) {
            com.unisound.common.l.a((java.io.Closeable) inputStream);
        }
    }
}
