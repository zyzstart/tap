package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    public static java.lang.String a(java.lang.String str) {
        try {
            java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().fillInStackTrace().getStackTrace();
            java.lang.String str2 = "<unknown>";
            for (int i = 2; i < stackTrace.length; i++) {
                if (!stackTrace[i].getClass().equals(com.tencent.qqdownloader.pay.utils.i.class)) {
                    java.lang.String className = stackTrace[i].getClassName();
                    try {
                        java.lang.String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                        className = strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                    } catch (java.lang.NoSuchMethodError unused) {
                    }
                    str2 = className + "." + stackTrace[i].getMethodName() + "(" + stackTrace[i].getLineNumber() + ")";
                    break;
                }
            }
            return java.lang.String.format("[%s:%d] %s: %s", java.lang.Thread.currentThread().getName(), java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()), str2, str);
        } catch (java.lang.Throwable unused2) {
            java.lang.System.gc();
            return "";
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (com.tencent.qqdownloader.pay.a.a.a()) {
            android.util.Log.i(str, ", " + a(str2));
        }
    }
}
