package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1438a = "p";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static int d = 0;
    public static java.lang.String e = "";
    public static java.lang.String f = "";

    private android.content.pm.PackageInfo b(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.tencent.yybsdk.apkpatch.f.a.d(f1438a, e2.getMessage());
            return null;
        }
    }

    public void a(android.content.Context context) {
        com.tencent.yybsdk.apkpatch.f.c.a().a(context);
        android.content.pm.PackageInfo packageInfoB = b(context);
        b = packageInfoB.packageName;
        c = packageInfoB.versionName;
        d = packageInfoB.versionCode;
    }

    public void a(java.lang.String str) {
        e = str;
    }

    public void b(java.lang.String str) {
        f = str;
    }
}
