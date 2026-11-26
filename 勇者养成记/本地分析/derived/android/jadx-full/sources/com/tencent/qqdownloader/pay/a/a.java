package com.tencent.qqdownloader.pay.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f739a = false;
    private static com.tencent.qqdownloader.pay.c.b b;

    public static final android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(android.content.Context context) {
        if (b != null) {
            return;
        }
        b = new com.tencent.qqdownloader.pay.c.b(context);
    }

    public static void a(boolean z) {
        f739a = z;
    }

    public static boolean a() {
        return f739a;
    }

    public static final boolean a(android.content.Context context, java.lang.String str) {
        if (c(context, d(context, str))) {
            return a(context, com.tencent.qqdownloader.pay.a.b.b, str);
        }
        return false;
    }

    public static final boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return c(context).edit().putString(str, str2).commit();
    }

    public static final java.lang.String b() {
        return a() ? "https://app-paid-auth.sparta.html5.qq.com/paid-auth/ajax/verify" : "https://api.app.qq.com/paid-auth/ajax/verify";
    }

    public static final java.lang.String b(android.content.Context context) {
        return context.getPackageName();
    }

    public static final boolean b(android.content.Context context, java.lang.String str) {
        return a(context, com.tencent.qqdownloader.pay.a.b.f740a, str);
    }

    public static final android.content.SharedPreferences c(android.content.Context context) {
        return context.getSharedPreferences("qqdownloader_sdk_preferences", 0);
    }

    public static final boolean c(android.content.Context context, java.lang.String str) {
        return a(context, com.tencent.qqdownloader.pay.a.b.c, str);
    }

    public static java.lang.String d(android.content.Context context) {
        return c(context).getString(com.tencent.qqdownloader.pay.a.b.b, "");
    }

    public static final java.lang.String d(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return com.tencent.qqdownloader.pay.utils.d.b(str + f(context));
    }

    public static java.lang.String e(android.content.Context context) {
        return c(context).getString(com.tencent.qqdownloader.pay.a.b.f740a, "");
    }

    public static final java.lang.String f(android.content.Context context) {
        a(context);
        return b.toString();
    }

    public static com.tencent.qqdownloader.pay.c.b g(android.content.Context context) {
        a(context);
        return b;
    }

    public static final java.lang.String h(android.content.Context context) {
        return c(context).getString(com.tencent.qqdownloader.pay.a.b.c, "");
    }
}
