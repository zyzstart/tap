package com.tencent.msdk.dns.base.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DnsLog {
    private static final java.lang.String TAG = "WGGetHostByName";
    private static int sLogLevel;

    static {
        int i = 7;
        for (int i2 = 6; i2 >= 2 && android.util.Log.isLoggable(TAG, i2); i2--) {
            i = i2;
        }
        sLogLevel = i;
    }

    public static void addLogNode(com.tencent.msdk.dns.base.log.ILogNode iLogNode) {
        com.tencent.msdk.dns.base.log.b.a(iLogNode);
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        d(null, str, objArr);
    }

    public static void d(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        tryLog(3, th, str, objArr);
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        e(null, str, objArr);
    }

    public static void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        tryLog(6, th, str, objArr);
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        i(null, str, objArr);
    }

    public static void i(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        tryLog(4, th, str, objArr);
    }

    public static void setLogLevel(int i) {
        sLogLevel = java.lang.Math.min(i, sLogLevel);
    }

    private static void tryLog(int i, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (i >= sLogLevel) {
            com.tencent.msdk.dns.base.log.b.a(i, TAG, java.lang.String.format(java.util.Locale.US, str, objArr), th);
        }
    }

    public static void v(java.lang.String str, java.lang.Object... objArr) {
        v(null, str, objArr);
    }

    public static void v(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        tryLog(2, th, str, objArr);
    }

    public static void w(java.lang.String str, java.lang.Object... objArr) {
        w(null, str, objArr);
    }

    public static void w(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        tryLog(5, th, str, objArr);
    }
}
