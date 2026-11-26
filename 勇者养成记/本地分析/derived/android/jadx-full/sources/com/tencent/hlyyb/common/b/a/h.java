package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f548a;
    long b;
    long c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;

    private h() {
        this.g = -1L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1L;
        this.k = -1L;
    }

    /* synthetic */ h(byte b) {
        this();
    }

    public final void a() {
        long j = this.b;
        long j2 = j - this.f548a;
        this.g = j2;
        long j3 = this.c;
        this.h = j3 - j;
        long j4 = this.d;
        this.i = j4 - j3;
        long j5 = this.e;
        this.j = j5 - j4;
        this.k = this.f - j5;
        if (j2 < 0) {
            j2 = -1;
        }
        this.g = j2;
        long j6 = this.h;
        if (j6 < 0) {
            j6 = -1;
        }
        this.h = j6;
        long j7 = this.i;
        if (j7 < 0) {
            j7 = -1;
        }
        this.i = j7;
        long j8 = this.j;
        if (j8 < 0) {
            j8 = -1;
        }
        this.j = j8;
        long j9 = this.k;
        this.k = j9 >= 0 ? j9 : -1L;
    }

    public final java.lang.String toString() {
        return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
    }
}
