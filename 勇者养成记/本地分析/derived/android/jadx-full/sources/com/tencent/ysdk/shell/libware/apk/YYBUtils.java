package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YYBUtils {
    private static android.content.pm.PackageInfo cache;

    public static android.content.pm.PackageInfo getInstalledYYBInfo() {
        android.content.pm.PackageInfo packageInfo = cache;
        if (packageInfo != null) {
            return packageInfo;
        }
        try {
            cache = com.tencent.ysdk.shell.framework.wrapper.ContextProxy.getPackageManager(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()).getPackageInfo("com.tencent.android.qqdownloader", 0);
            return cache;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
