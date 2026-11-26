package com.tencent.bugly.crashreport;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuglyLog {
    public static void d(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.d(str, str2);
        }
        com.tencent.bugly.proguard.y.a("D", str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.e(str, str2);
        }
        com.tencent.bugly.proguard.y.a("E", str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.e(str, str2, th);
        }
        com.tencent.bugly.proguard.y.a("E", str, th);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.i(str, str2);
        }
        com.tencent.bugly.proguard.y.a("I", str, str2);
    }

    public static void setCache(int i) {
        com.tencent.bugly.proguard.y.a(i);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.v(str, str2);
        }
        com.tencent.bugly.proguard.y.a("V", str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.c) {
            android.util.Log.w(str, str2);
        }
        com.tencent.bugly.proguard.y.a("W", str, str2);
    }
}
