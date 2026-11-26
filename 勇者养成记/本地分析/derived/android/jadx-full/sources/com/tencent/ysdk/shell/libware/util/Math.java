package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Math {
    public static int getRandNumByLimit(int i, int i2) {
        if (i2 < i) {
            return i2;
        }
        double dRandom = java.lang.Math.random();
        double d = i2 - i;
        java.lang.Double.isNaN(d);
        double d2 = i;
        java.lang.Double.isNaN(d2);
        return (int) java.lang.Math.round((dRandom * d) + d2);
    }
}
