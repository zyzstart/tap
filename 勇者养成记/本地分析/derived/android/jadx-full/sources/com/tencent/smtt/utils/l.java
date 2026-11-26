package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f980a = null;
    private static java.lang.String b = "GA";
    private static java.lang.String c = "GE";
    private static java.lang.String d = "9422";
    private static java.lang.String e = "0";
    private static java.lang.String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    private static java.lang.String a() {
        return " " + android.os.Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(f980a)) {
            return f980a;
        }
        java.lang.String strA = a(context, java.lang.String.valueOf(com.tencent.smtt.sdk.WebView.getTbsSDKVersion(context)), "0", b, c, d, e, f, g);
        f980a = strA;
        return strA;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, boolean z) {
        java.lang.String str8;
        java.lang.String str9 = "";
        java.lang.String str10 = "PHONE";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str11 = b(context) + "*" + c(context);
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str9 = applicationInfo.packageName;
            str8 = !android.text.TextUtils.isEmpty(str7) ? str7 : packageInfo.versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str8 = "";
        }
        java.lang.String strA = a(str9);
        if (!"QB".equals(strA) ? d(context) : z) {
            str10 = "PAD";
        }
        sb.append("QV");
        sb.append("=");
        sb.append("3");
        a(sb, "PL", "ADR");
        a(sb, "PR", strA);
        a(sb, "PP", str9);
        a(sb, "PPVN", str8);
        if (!android.text.TextUtils.isEmpty(str)) {
            a(sb, "TBSVC", str);
        }
        a(sb, "CO", "SYS");
        if (!android.text.TextUtils.isEmpty(str2)) {
            a(sb, "COVC", str2);
        }
        a(sb, "PB", str4);
        a(sb, "VE", str3);
        a(sb, "DE", str10);
        a(sb, "CHID", android.text.TextUtils.isEmpty(str6) ? "0" : str6);
        a(sb, "LCID", str5);
        java.lang.String strA2 = a();
        try {
            strA2 = new java.lang.String(strA2.getBytes("UTF-8"), "ISO8859-1");
        } catch (java.lang.Exception unused) {
        }
        if (!android.text.TextUtils.isEmpty(strA2)) {
            a(sb, "MO", strA2);
        }
        a(sb, "RL", str11);
        java.lang.String str12 = android.os.Build.VERSION.RELEASE;
        try {
            str12 = new java.lang.String(str12.getBytes("UTF-8"), "ISO8859-1");
        } catch (java.lang.Exception unused2) {
        }
        if (!android.text.TextUtils.isEmpty(str12)) {
            a(sb, "OS", str12);
        }
        a(sb, "API", android.os.Build.VERSION.SDK_INT + "");
        return sb.toString();
    }

    private static java.lang.String a(java.lang.String str) {
        if ("com.tencent.mm".equals(str)) {
            return "WX";
        }
        if ("com.tencent.mobileqq".equals(str)) {
            return com.tencent.connect.common.Constants.SOURCE_QQ;
        }
        if ("com.qzone".equals(str)) {
            return "QZ";
        }
        return com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    private static void a(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    private static int b(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    private static int c(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    private static boolean d(android.content.Context context) {
        if (h) {
            return i;
        }
        try {
            boolean z = (java.lang.Math.min(b(context), c(context)) * 160) / e(context) >= 700;
            i = z;
            h = true;
            return z;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static int e(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return 160;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
