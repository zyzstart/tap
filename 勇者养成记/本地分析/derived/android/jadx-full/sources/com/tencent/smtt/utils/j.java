package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.Class f979a;
    private static java.lang.reflect.Method b;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            f979a = cls;
            b = cls.getDeclaredMethod("get", java.lang.String.class, java.lang.String.class);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.isEmpty(str) ? str2 : b(str, str2);
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.reflect.Method method;
        java.lang.Class cls = f979a;
        if (cls == null || (method = b) == null) {
            return str2;
        }
        try {
            return (java.lang.String) method.invoke(cls, str, str2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
