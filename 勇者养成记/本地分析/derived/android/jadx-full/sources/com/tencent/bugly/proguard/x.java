package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f454a = "CrashReport";
    public static boolean b = false;
    private static java.lang.String c = "CrashReportInfo";

    private static boolean a(int i, java.lang.String str, java.lang.Object... objArr) {
        if (!b) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = java.lang.String.format(java.util.Locale.US, str, objArr);
        }
        if (i == 5) {
            android.util.Log.i(c, str);
            return true;
        }
        switch (i) {
            case 0:
                android.util.Log.i(f454a, str);
                return true;
            case 1:
                android.util.Log.d(f454a, str);
                return true;
            case 2:
                android.util.Log.w(f454a, str);
                return true;
            case 3:
                android.util.Log.e(f454a, str);
                return true;
            default:
                return false;
        }
    }

    public static boolean a(java.lang.Class cls, java.lang.String str, java.lang.Object... objArr) {
        return a(0, java.lang.String.format(java.util.Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(java.lang.String str, java.lang.Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(java.lang.Throwable th) {
        if (b) {
            return a(2, com.tencent.bugly.proguard.z.a(th), new java.lang.Object[0]);
        }
        return false;
    }

    public static boolean b(java.lang.Class cls, java.lang.String str, java.lang.Object... objArr) {
        return a(1, java.lang.String.format(java.util.Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(java.lang.String str, java.lang.Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean b(java.lang.Throwable th) {
        if (b) {
            return a(3, com.tencent.bugly.proguard.z.a(th), new java.lang.Object[0]);
        }
        return false;
    }

    public static boolean c(java.lang.String str, java.lang.Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(java.lang.String str, java.lang.Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(java.lang.String str, java.lang.Object... objArr) {
        return a(3, str, objArr);
    }
}
