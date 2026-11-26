package com.tencent.beacon.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f126a;
    public int b;
    public int c;
    public long d;
    public byte[] e;
    public long f;

    public a() {
        this.f126a = -1L;
        this.b = -1;
        this.c = -1;
        this.d = -1L;
        this.e = null;
        this.f = 0L;
    }

    public a(int i, int i2, long j, byte[] bArr) {
        this.f126a = -1L;
        this.b = -1;
        this.c = -1;
        this.d = -1L;
        this.e = null;
        this.f = 0L;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = bArr;
        if (bArr != null) {
            this.f = bArr.length;
        }
    }
}
