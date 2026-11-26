package com.tencent.tmdownloader.internal.downloadservice.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1129a;
    public java.lang.String b;
    public int c = 0;
    public long d = 0;
    public long e = 0;
    public long f = 0;

    public b(java.lang.String str, java.lang.String str2) {
        this.f1129a = null;
        this.b = null;
        this.f1129a = str;
        this.b = str2;
    }

    public boolean a(long j, long j2, long j3) {
        if (j != j2 && ((j3 - this.f < 1000 || j == this.d) && (j2 <= 0 || (((j * 1.0f) - (this.d * 1.0f)) / j2) * 1.0f <= 0.009999999776482582d))) {
            return false;
        }
        this.d = j;
        this.e = j2;
        this.f = j3;
        return true;
    }
}
