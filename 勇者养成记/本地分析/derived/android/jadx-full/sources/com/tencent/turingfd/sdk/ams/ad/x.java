package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class x {
    public static final byte[] ya = new byte[0];
    public byte[] Na;
    public int sa;

    public x(int i, byte[] bArr) {
        this.sa = i;
        this.Na = bArr;
    }

    public static com.tencent.turingfd.sdk.ams.ad.x a(int i) {
        return new com.tencent.turingfd.sdk.ams.ad.x(i, ya);
    }

    public int getErrorCode() {
        return this.sa;
    }
}
