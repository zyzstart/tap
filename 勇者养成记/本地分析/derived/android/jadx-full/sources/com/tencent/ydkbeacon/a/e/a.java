package com.tencent.ydkbeacon.a.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1197a;

    public static java.lang.String a() {
        java.lang.String str = f1197a;
        if (str != null) {
            return str;
        }
        try {
            f1197a = (java.lang.String) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod(android.os.Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            return "";
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return "";
        }
    }
}
