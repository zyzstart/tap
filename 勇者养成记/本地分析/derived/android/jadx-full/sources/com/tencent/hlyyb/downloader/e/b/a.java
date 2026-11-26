package com.tencent.hlyyb.downloader.e.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    private static java.lang.String j = ",";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f618a;
    public int b;
    public int c;
    public volatile long d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public volatile boolean h;
    public com.tencent.hlyyb.downloader.e.g i;

    public a(com.tencent.hlyyb.downloader.e.g gVar, long j2, long j3, long j4, long j5) {
        this.f618a = true;
        this.b = -1;
        this.c = -1;
        this.h = false;
        this.i = gVar;
        this.d = j2;
        this.g = j5;
        this.e = j3;
        this.f = java.lang.Math.max(j3, j4);
    }

    public a(com.tencent.hlyyb.downloader.e.g gVar, java.lang.String str) {
        this.f618a = true;
        this.b = -1;
        this.c = -1;
        this.h = false;
        this.i = gVar;
        java.lang.String[] strArrSplit = str.split(j);
        if (strArrSplit == null || strArrSplit.length != 5) {
            this.f618a = false;
            return;
        }
        this.b = java.lang.Integer.valueOf(strArrSplit[0]).intValue();
        this.c = java.lang.Integer.valueOf(strArrSplit[1]).intValue();
        this.d = java.lang.Long.valueOf(strArrSplit[2]).longValue();
        this.e = java.lang.Long.valueOf(strArrSplit[3]).longValue();
        this.f = this.e;
        this.g = java.lang.Long.valueOf(strArrSplit[4]).longValue();
    }

    public final java.lang.String a() {
        return this.b + j + this.c + j + this.d + j + this.e + j + this.g;
    }

    public final java.lang.String toString() {
        return "[" + this.b + j + this.c + j + this.d + j + this.e + j + this.f + j + this.g + "]";
    }
}
