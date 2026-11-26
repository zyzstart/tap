package com.tencent.ydkqmsp.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static int a() {
        try {
            java.lang.String str = com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageManager().getPackageInfo(com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageName(), 0).packageName;
            android.content.pm.ApplicationInfo applicationInfo = com.tencent.ydkqmsp.sdk.app.a.getContext().getApplicationInfo();
            if (applicationInfo.packageName.equals(str)) {
                return java.lang.Integer.valueOf((int) new java.io.File(applicationInfo.publicSourceDir).length()).intValue();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static java.lang.String a(int i) {
        return java.lang.String.format("%d.%d.%d", java.lang.Integer.valueOf(i >> 24), java.lang.Integer.valueOf((16711680 & i) >> 16), java.lang.Integer.valueOf((i & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8));
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.tencent.ydkqmsp.sdk.f.e.a(java.security.MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String b() {
        try {
            java.lang.String packageName = com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageName();
            if (android.text.TextUtils.isEmpty(packageName)) {
                return null;
            }
            return packageName;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String c() {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageManager().getPackageInfo(com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo.versionName;
    }

    public static java.lang.String d() {
        return a(512);
    }

    public static java.lang.String e() {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageManager().getPackageInfo(com.tencent.ydkqmsp.sdk.app.a.getContext().getPackageName(), 64);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        android.content.pm.Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length <= 0) {
            return "";
        }
        try {
            return com.tencent.ydkqmsp.sdk.f.e.a(java.security.MessageDigest.getInstance("MD5").digest(signatureArr[0].toByteArray()));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int f() {
        int i;
        java.lang.String str;
        try {
            java.lang.String[] strArrSplit = c().split("\\.");
            if (strArrSplit.length != 2) {
                if (strArrSplit.length == 3) {
                    i = (java.lang.Integer.parseInt(strArrSplit[0]) << 24) | 0 | (java.lang.Integer.parseInt(strArrSplit[1]) << 16);
                    str = strArrSplit[2];
                }
                return 0;
            }
            i = (java.lang.Integer.parseInt(strArrSplit[0]) << 16) | 0;
            str = strArrSplit[1];
            return (java.lang.Integer.parseInt(str) << 8) | i;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean g() {
        java.lang.String property = java.lang.System.getProperty("os.arch");
        return property != null && property.contains("64");
    }
}
