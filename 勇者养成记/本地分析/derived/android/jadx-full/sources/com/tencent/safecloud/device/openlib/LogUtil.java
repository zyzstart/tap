package com.tencent.safecloud.device.openlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LogUtil {
    private static final java.lang.String TAG = "FPC_SCFP_LOG";
    public static boolean isDebug = false;
    public static boolean isDebugTime = true;
    public static boolean showError = false;
    public static boolean showInfo = false;

    public static void closeLog() {
        isDebug = false;
        showInfo = false;
        showError = false;
    }

    public static void d(java.lang.String str) {
        if (isDebug) {
            android.util.Log.i(TAG, str);
        }
    }

    public static void debug(boolean z) {
        isDebug = z;
    }

    public static void dev(java.lang.String str) {
    }

    public static void e(java.lang.String str) {
        if (showError) {
            android.util.Log.e(TAG, str);
        }
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        android.util.Log.e(TAG, str);
        if (showError) {
            th.printStackTrace();
        }
    }

    public static void enableLog() {
        isDebug = true;
        showInfo = true;
        showError = true;
    }

    public static void error(boolean z) {
        showError = z;
    }

    public static void i(java.lang.String str) {
        if (showInfo) {
            android.util.Log.i(TAG, str);
        }
    }

    public static void info(java.lang.String str) {
        android.util.Log.i(TAG, str);
    }

    public static void info(boolean z) {
        showInfo = z;
    }
}
