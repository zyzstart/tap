package com.tencent.mm.opensdk.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Log {
    private static com.tencent.mm.opensdk.utils.ILog logImpl;

    public static void d(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.d(str, str2);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.e(str, str2);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.i(str, str2);
        }
    }

    public static void setLogImpl(com.tencent.mm.opensdk.utils.ILog iLog) {
        logImpl = iLog;
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.v(str, str2);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.w(str, str2);
        }
    }
}
