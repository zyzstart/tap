package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static int a(int i) {
        int i2 = (i >> 0) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 16) & 255;
        return (((i >> 24) & 255) << 0) | (i2 << 24) | (i3 << 16) | (i4 << 8);
    }

    public static long a(long j) {
        return (((j >> 0) & 255) << 56) | (((j >> 8) & 255) << 48) | (((j >> 16) & 255) << 40) | (((j >> 24) & 255) << 32) | (((j >> 32) & 255) << 24) | (((j >> 40) & 255) << 16) | (((j >> 48) & 255) << 8) | (((j >> 56) & 255) << 0);
    }

    public static short a(short s) {
        int i = s & 255;
        return (short) ((((s >> 8) & 255) << 0) | (i << 8));
    }
}
