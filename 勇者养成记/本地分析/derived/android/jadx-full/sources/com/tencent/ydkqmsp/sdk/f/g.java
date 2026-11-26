package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1347a = "Qp.Log";
    private static boolean b = false;

    public static void a(java.lang.String str, int i, java.lang.String str2) {
        if (b) {
            android.util.Log.d(str, str2);
        }
    }

    public static void a(boolean z) {
        b = true;
    }

    public static void b(java.lang.String str, int i, java.lang.String str2) {
        if (b) {
            android.util.Log.e(str, str2);
        }
    }

    public static void c(java.lang.String str, int i, java.lang.String str2) {
        if (b) {
            android.util.Log.v(str, str2);
        }
    }

    public static void d(java.lang.String str, int i, java.lang.String str2) {
        if (b) {
            android.util.Log.w(str, str2);
        }
    }
}
