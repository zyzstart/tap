package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static int a(int i) {
        int i2 = (i >> 0) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 16) & 255;
        return (((i >> 24) & 255) << 0) | (i2 << 24) | (i3 << 16) | (i4 << 8);
    }

    public static short a(short s) {
        int i = s & 255;
        return (short) ((((s >> 8) & 255) << 0) | (i << 8));
    }
}
