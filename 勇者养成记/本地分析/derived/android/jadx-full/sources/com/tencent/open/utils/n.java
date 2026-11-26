package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f736a;

    public n(int i) {
        this.f736a = i;
    }

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public n(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f736a = i2;
        this.f736a = i2 + (bArr[i] & 255);
    }

    public byte[] a() {
        int i = this.f736a;
        return new byte[]{(byte) (i & 255), (byte) ((i & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f736a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.open.utils.n) && this.f736a == ((com.tencent.open.utils.n) obj).b();
    }

    public int hashCode() {
        return this.f736a;
    }
}
