package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static int a() {
        return 7272130;
    }

    public static final void a(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("tmast://pay?package_name=" + context.getPackageName()));
        intent.addFlags(872415232);
        try {
            android.app.PendingIntent.getActivity(context, 0, intent, 0).send();
        } catch (android.app.PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    public static final java.lang.String b() {
        return "com.tencent.android.qqdownloader";
    }

    public static boolean b(android.content.Context context) {
        android.content.pm.ApplicationInfo applicationInfo;
        android.os.Bundle bundle;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(b(), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("PAY_GRAY_VERSION");
    }
}
