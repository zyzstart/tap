package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1131a = "b";

    public static boolean a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.tmassistantbase.util.TMLog.w(f1131a, "localAPKPath is empty, return false");
                return false;
            }
            if (!new java.io.File(str).exists()) {
                com.tencent.tmassistantbase.util.TMLog.w(f1131a, "file not exist, return false");
                return false;
            }
            if (android.text.TextUtils.isEmpty(b(str))) {
                com.tencent.tmassistantbase.util.TMLog.w(f1131a, "package invaild del file, return false");
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(str)), com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
            com.tencent.tmassistantbase.util.k.a().b().startActivity(intent);
            com.tencent.tmassistantbase.util.TMLog.i(f1131a, "sdk installApp success");
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1131a, "installApp>>>", e);
            return false;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            android.content.pm.PackageInfo packageArchiveInfo = com.tencent.tmassistantbase.util.k.a().b().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.applicationInfo.packageName;
            }
            return null;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1131a, "getApkPackageName>>>", e);
            return null;
        }
    }
}
