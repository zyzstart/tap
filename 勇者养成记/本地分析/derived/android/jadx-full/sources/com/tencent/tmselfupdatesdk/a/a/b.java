package com.tencent.tmselfupdatesdk.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1147a;

    public b(long j) {
        this.f1147a = j;
    }

    public byte[] a() {
        long j = this.f1147a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f1147a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.tmselfupdatesdk.a.a.b) && this.f1147a == ((com.tencent.tmselfupdatesdk.a.a.b) obj).b();
    }

    public int hashCode() {
        return (int) this.f1147a;
    }
}
