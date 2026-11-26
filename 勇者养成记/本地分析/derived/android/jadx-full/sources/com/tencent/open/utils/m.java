package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class m implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f735a;

    public m(long j) {
        this.f735a = j;
    }

    public byte[] a() {
        long j = this.f735a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f735a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.open.utils.m) && this.f735a == ((com.tencent.open.utils.m) obj).b();
    }

    public int hashCode() {
        return (int) this.f735a;
    }
}
