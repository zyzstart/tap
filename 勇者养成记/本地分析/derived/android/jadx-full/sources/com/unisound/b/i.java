package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1456a = false;
    private static final java.lang.String b = "USCActivate";

    public static void a(java.lang.String str) {
        if (f1456a) {
            android.util.Log.e(b, str);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (f1456a) {
            android.util.Log.e(str, str2);
        }
    }

    public static void b(java.lang.String str) {
        if (f1456a) {
            android.util.Log.w(b, str);
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (f1456a) {
            android.util.Log.w(str, str2);
        }
    }

    public static void c(java.lang.String str) {
        if (f1456a) {
            android.util.Log.i(b, str);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (f1456a) {
            android.util.Log.i(str, str2);
        }
    }

    public static void d(java.lang.String str) {
        if (f1456a) {
            android.util.Log.d(b, str);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (f1456a) {
            android.util.Log.d(str, str2);
        }
    }
}
