package com.tencent.msdk.dns.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {
    public static int a() {
        int iA = com.tencent.msdk.dns.base.jni.a.a();
        if (iA == 1 || iA == 2 || iA == 3) {
            return iA;
        }
        return 0;
    }

    public static boolean a(int i) {
        return i >= 0 && i <= 3;
    }
}
