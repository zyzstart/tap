package com.tencent.tmselfupdatesdk.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1148a;

    public c(int i) {
        this.f1148a = i;
    }

    public c(byte[] bArr) {
        this(bArr, 0);
    }

    public c(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f1148a = i2;
        this.f1148a = i2 + (bArr[i] & 255);
    }

    public byte[] a() {
        int i = this.f1148a;
        return new byte[]{(byte) (i & 255), (byte) ((i & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f1148a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.tmselfupdatesdk.a.a.c) && this.f1148a == ((com.tencent.tmselfupdatesdk.a.a.c) obj).b();
    }

    public int hashCode() {
        return this.f1148a;
    }
}
