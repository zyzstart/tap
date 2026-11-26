package com.tencent.beacon.core.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f147a = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
    public static java.lang.String b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
    public static java.lang.String c = "oth.eve.mdt.qq.com";
    public static java.lang.String d = "oth.str.mdt.qq.com";

    public static java.lang.String a(java.lang.String str) {
        return "http://" + str + "/analytics/upload";
    }

    public static java.lang.String a(boolean z, java.lang.String str) {
        com.tencent.beacon.core.e.d.a("[event url] getStrategyUrl, isHttpMode: %s, httpUrl: %s", java.lang.Boolean.valueOf(z), str);
        if (com.tencent.beacon.core.e.j.b(str)) {
            return z ? b : d;
        }
        return z ? str : b(str);
    }

    public static java.lang.String a(boolean z, boolean z2, java.lang.String str) {
        com.tencent.beacon.core.e.d.a("[event url] getRequestUrl, isHttpMode: %s, isRealtimeTest: %s, httpUrl: %s", java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2), str);
        if (z2) {
            return z ? "http://183.36.108.226:8080/analytics/upload" : "183.36.108.226";
        }
        if (com.tencent.beacon.core.e.j.b(str)) {
            return z ? f147a : c;
        }
        return z ? str : b(str);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
        java.util.regex.Matcher matcher = patternCompile.matcher(str);
        java.util.regex.Matcher matcher2 = patternCompile.matcher(str2);
        if (!matcher.matches() || !matcher2.matches()) {
            com.tencent.beacon.core.e.i.a("[event url] set report ip is not valid IP address!");
            return;
        }
        d = str;
        b = b.replace("oth.str.mdt.qq.com", str);
        c = str2;
        java.lang.String strReplace = f147a.replace("oth.eve.mdt.qq.com", str2);
        f147a = strReplace;
        com.tencent.beacon.core.e.d.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", d, b, c, strReplace);
    }

    private static java.lang.String b(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        java.lang.String str2 = str.contains("https") ? "https://" : "http://";
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return str;
        }
        return str.substring(iIndexOf + str2.length(), str.indexOf(":", str2.length()));
    }
}
