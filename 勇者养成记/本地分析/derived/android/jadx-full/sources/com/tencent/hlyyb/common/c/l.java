package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f560a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";

    private static java.lang.String a() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Throwable unused) {
            return "null";
        }
    }

    public static void a(android.content.Context context) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(";Android ");
        stringBuffer.append(b());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        f560a = stringBuffer.toString();
        b = b(context);
        context.getPackageName();
        c = d();
        d = a();
    }

    private static java.lang.String b() {
        try {
            return android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Throwable unused) {
            return "null";
        }
    }

    private static java.lang.String b(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            java.lang.String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str != null && str.trim().length() > 0) {
                java.lang.String strReplace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                int i2 = 0;
                for (char c2 : strReplace.toCharArray()) {
                    if (c2 == '.') {
                        i2++;
                    }
                }
                if (i2 >= 3) {
                    return strReplace;
                }
                return strReplace + "." + i;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static java.lang.String c() {
        try {
            return android.os.Build.VERSION.SDK;
        } catch (java.lang.Throwable unused) {
            return "null";
        }
    }

    private static java.lang.String d() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
