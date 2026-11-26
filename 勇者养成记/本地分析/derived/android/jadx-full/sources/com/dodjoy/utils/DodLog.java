package com.dodjoy.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodLog {
    public static java.lang.String TAG = "Unity";
    private static java.lang.String Tag = "Unity";
    private static boolean enableLog = false;

    public static void Log(java.lang.String str) {
        if (enableLog) {
            android.util.Log.e(Tag, str);
        }
    }

    public static void d(java.lang.String str, char c) {
        if (enableLog) {
            android.util.Log.d(str, "" + c);
        }
    }

    public static void d(java.lang.String str, int i) {
        if (enableLog) {
            android.util.Log.d(str, "" + i);
        }
    }

    public static void d(java.lang.String str, java.lang.CharSequence charSequence) {
        if (!enableLog || charSequence == null) {
            return;
        }
        android.util.Log.d(str, charSequence.toString());
    }

    public static void d(java.lang.String str, java.lang.Character ch) {
        if (!enableLog || ch == null) {
            return;
        }
        android.util.Log.d(str, ch.toString());
    }

    public static void d(java.lang.String str, boolean z) {
        if (enableLog) {
            android.util.Log.d(str, "" + z);
        }
    }

    public static void d(java.lang.String str, byte[] bArr) {
        if (!enableLog || bArr == null) {
            return;
        }
        android.util.Log.d(str, new java.lang.String(bArr));
    }

    public static void e(java.lang.String str, char c) {
        if (enableLog) {
            android.util.Log.e(str, "" + c);
        }
    }

    public static void e(java.lang.String str, int i) {
        if (enableLog) {
            android.util.Log.e(str, "" + i);
        }
    }

    public static void e(java.lang.String str, java.lang.CharSequence charSequence) {
        if (!enableLog || charSequence == null) {
            return;
        }
        android.util.Log.e(str, charSequence.toString());
    }

    public static void e(java.lang.String str, java.lang.Character ch) {
        if (!enableLog || ch == null) {
            return;
        }
        android.util.Log.e(str, ch.toString());
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!enableLog || str2 == null) {
            return;
        }
        android.util.Log.e(str, str2, th);
    }

    public static void e(java.lang.String str, boolean z) {
        if (enableLog) {
            android.util.Log.e(str, "" + z);
        }
    }

    public static void e(java.lang.String str, byte[] bArr) {
        if (!enableLog || bArr == null) {
            return;
        }
        android.util.Log.e(str, new java.lang.String(bArr));
    }

    public static void enableLog(boolean z) {
        enableLog = z;
    }

    public static void i(java.lang.String str, char c) {
        if (enableLog) {
            android.util.Log.i(str, "" + c);
        }
    }

    public static void i(java.lang.String str, int i) {
        if (enableLog) {
            android.util.Log.i(str, "" + i);
        }
    }

    public static void i(java.lang.String str, java.lang.CharSequence charSequence) {
        if (!enableLog || charSequence == null) {
            return;
        }
        android.util.Log.i(str, charSequence.toString());
    }

    public static void i(java.lang.String str, java.lang.Character ch) {
        if (!enableLog || ch == null) {
            return;
        }
        android.util.Log.i(str, ch.toString());
    }

    public static void i(java.lang.String str, boolean z) {
        if (enableLog) {
            android.util.Log.i(str, "" + z);
        }
    }

    public static void i(java.lang.String str, byte[] bArr) {
        if (!enableLog || bArr == null) {
            return;
        }
        android.util.Log.i(str, new java.lang.String(bArr));
    }

    public static void w(java.lang.String str, char c) {
        if (enableLog) {
            android.util.Log.w(str, "" + c);
        }
    }

    public static void w(java.lang.String str, int i) {
        if (enableLog) {
            android.util.Log.w(str, "" + i);
        }
    }

    public static void w(java.lang.String str, java.lang.CharSequence charSequence) {
        if (!enableLog || charSequence == null) {
            return;
        }
        android.util.Log.w(str, charSequence.toString());
    }

    public static void w(java.lang.String str, java.lang.Character ch) {
        if (!enableLog || ch == null) {
            return;
        }
        android.util.Log.w(str, ch.toString());
    }

    public static void w(java.lang.String str, boolean z) {
        if (enableLog) {
            android.util.Log.w(str, "" + z);
        }
    }

    public static void w(java.lang.String str, byte[] bArr) {
        if (!enableLog || bArr == null) {
            return;
        }
        android.util.Log.w(str, new java.lang.String(bArr));
    }
}
