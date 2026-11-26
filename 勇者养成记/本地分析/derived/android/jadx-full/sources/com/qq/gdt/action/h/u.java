package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile java.lang.Long f123a;

    public static void a(long j) {
        if (j <= 0 || a()) {
            return;
        }
        f123a = java.lang.Long.valueOf(j - android.os.SystemClock.elapsedRealtime());
    }

    public static boolean a() {
        return f123a != null;
    }

    public static long b() {
        if (a()) {
            return android.os.SystemClock.elapsedRealtime() + f123a.longValue();
        }
        return -1L;
    }
}
