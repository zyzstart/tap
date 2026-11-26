package com.tencent.beaconselfupdate.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f247a = false;
    public static boolean b = false;

    private static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (f247a) {
            if (str2 == null) {
                str2 = "null";
            } else if (objArr != null && objArr.length != 0) {
                str2 = java.lang.String.format(java.util.Locale.US, str2, objArr);
            }
            android.util.Log.d(str, str2);
        }
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        if (f247a) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = java.lang.String.format(java.util.Locale.US, str, objArr);
            }
            android.util.Log.i("beacon", str);
        }
    }

    public static void a(java.lang.Throwable th) {
        if (th == null || !(th instanceof java.lang.Throwable)) {
            return;
        }
        if (f247a) {
            th.printStackTrace();
        } else {
            d(th.getMessage(), new java.lang.Object[0]);
        }
    }

    public static void b(java.lang.String str, java.lang.Object... objArr) {
        if (f247a) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = java.lang.String.format(java.util.Locale.US, str, objArr);
            }
            android.util.Log.d("beacon", str);
        }
    }

    public static void c(java.lang.String str, java.lang.Object... objArr) {
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = java.lang.String.format(java.util.Locale.US, str, objArr);
        }
        android.util.Log.w("beacon", str);
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = java.lang.String.format(java.util.Locale.US, str, objArr);
        }
        android.util.Log.e("beacon", str);
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        a("beacon_step_api", str, objArr);
    }

    public static void f(java.lang.String str, java.lang.Object... objArr) {
        a("beacon_step_buffer", str, objArr);
    }

    public static void g(java.lang.String str, java.lang.Object... objArr) {
        a("beacon_step_db", str, objArr);
    }

    public static void h(java.lang.String str, java.lang.Object... objArr) {
        a("beacon_step_upload", str, objArr);
    }
}
