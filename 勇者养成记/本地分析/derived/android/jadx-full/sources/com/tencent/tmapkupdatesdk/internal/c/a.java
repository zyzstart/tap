package com.tencent.tmapkupdatesdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.tmapkupdatesdk.internal.c.a f996a = null;
    private static java.lang.String c = "";
    private static int d;
    private static com.tencent.tmassistantbase.jce.Terminal e;
    private android.content.Context b;

    private a() {
    }

    public static int a(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionCode;
            } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                com.tencent.tmassistantbase.util.TMLog.e("ApkUpdateGlobalUtil", "exception: ", e2);
            }
        }
        return 0;
    }

    public static synchronized com.tencent.tmapkupdatesdk.internal.c.a a() {
        if (f996a == null) {
            f996a = new com.tencent.tmapkupdatesdk.internal.c.a();
        }
        return f996a;
    }

    public int a(java.lang.String str) {
        android.content.Context context = this.b;
        if (context == null) {
            return 0;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.GRAY_CODE");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.tencent.tmassistantbase.util.TMLog.e("ApkUpdateGlobalUtil", "exception: ", e2);
            return 0;
        }
    }

    public void a(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i("ApkUpdateGlobalUtil", "enter");
        this.b = context;
        c = new com.tencent.tmassistantbase.util.q(context).a();
        com.tencent.tmassistantbase.util.TMLog.i("ApkUpdateGlobalUtil", "QUA:" + c);
        com.tencent.tmassistantbase.util.TMLog.i("ApkUpdateGlobalUtil", "exit");
    }

    public android.content.Context b() {
        return this.b;
    }
}
