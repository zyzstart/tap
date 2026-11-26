package com.tencent.ydkqmsp.sdk.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1303a = "2g.outt";
    private static boolean b = false;

    public static void a(java.lang.String str) {
        if (b) {
            android.util.Log.d(f1303a, str);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void b(java.lang.String str) {
        if (b) {
            android.util.Log.e(f1303a, str);
        }
    }

    public static void c(java.lang.String str) {
        if (b) {
            android.util.Log.i(f1303a, str);
        }
    }
}
