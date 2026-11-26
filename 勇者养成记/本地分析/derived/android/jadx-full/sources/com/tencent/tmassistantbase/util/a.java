package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            android.net.Uri uriFromFile = android.net.Uri.fromFile(new java.io.File(str));
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriFromFile, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageArchiveInfo;
        return (context == null || str == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) ? "" : packageArchiveInfo.packageName;
    }
}
