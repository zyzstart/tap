package com.tencent.ydkqmsp.sdk.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.content.Context f1307a;

    public static android.content.Context a() {
        android.content.Context context;
        synchronized (com.tencent.ydkqmsp.sdk.base.f.class) {
            if (f1307a == null) {
                f1307a = b();
            }
            context = f1307a;
        }
        return context;
    }

    public static java.lang.String a(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            return (applicationInfo == null || android.text.TextUtils.isEmpty(applicationInfo.packageName)) ? a().getPackageName() : applicationInfo.packageName;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static android.content.Context b() {
        try {
            return (android.content.Context) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.SecurityException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
