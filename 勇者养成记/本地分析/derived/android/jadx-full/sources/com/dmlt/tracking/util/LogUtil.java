package com.dmlt.tracking.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LogUtil {
    public static void d(java.lang.String str) {
        if (com.dmlt.tracking.config.ConstConfig.DebugMode) {
            android.util.Log.d(com.dmlt.tracking.config.ConstConfig.TAG, str);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (com.dmlt.tracking.config.ConstConfig.DebugMode) {
            android.util.Log.d(str, str2);
        }
    }

    public static void e(java.lang.String str) {
        android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, str);
    }

    public static void i(java.lang.String str) {
        android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, str);
    }

    public static void w(java.lang.String str) {
        if (com.dmlt.tracking.config.ConstConfig.DebugMode) {
            android.util.Log.w(com.dmlt.tracking.config.ConstConfig.TAG, str);
        }
    }
}
