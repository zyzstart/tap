package com.tencent.ydkbeacon.base.net.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1226a = "https://otheve.beacon.qq.com/analytics/upload";
    public static java.lang.String b = "https://othstr.beacon.qq.com/analytics/upload";
    public static java.lang.String c = "oth.eve.mdt.qq.com";
    public static java.lang.String d = "oth.str.mdt.qq.com";
    private static boolean e = false;

    public static java.lang.String a(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        java.lang.String str2 = str.contains("https") ? "https://" : "http://";
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return str;
        }
        java.lang.String strSubstring = str.substring(iIndexOf + str2.length(), str.indexOf("/", str2.length()));
        int iIndexOf2 = strSubstring.indexOf(":");
        return iIndexOf2 != -1 ? strSubstring.substring(0, iIndexOf2) : strSubstring;
    }

    public static java.lang.String a(boolean z) {
        return z ? c : f1226a;
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str)) {
            d = str;
            b = b.replace("othstr.beacon.qq.com", str);
            e = true;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c = str2;
        f1226a = f1226a.replace("otheve.beacon.qq.com", str2);
        e = true;
    }

    public static java.lang.String b(boolean z) {
        return z ? d : b;
    }

    public static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || e) {
            return;
        }
        c = str;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
        java.util.regex.Matcher matcher = patternCompile.matcher(str);
        java.util.regex.Matcher matcher2 = patternCompile.matcher(str2);
        if (!matcher.matches() || !matcher2.matches()) {
            com.tencent.ydkbeacon.a.e.e.a("[event url] set report ip is not valid IP address!");
            return;
        }
        d = str;
        b = b.replace("othstr.beacon.qq.com", str);
        c = str2;
        java.lang.String strReplace = f1226a.replace("otheve.beacon.qq.com", str2);
        f1226a = strReplace;
        com.tencent.ydkbeacon.a.e.c.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", d, b, c, strReplace);
    }

    public static void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || e) {
            return;
        }
        f1226a = str;
    }

    public static void d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || e) {
            return;
        }
        d = str;
    }

    public static void e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || e) {
            return;
        }
        b = str;
    }
}
