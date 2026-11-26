package com.tencent.msdk.dns.core.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f667a = false;

    public static void a(int i) {
        if (i > 0) {
            com.tencent.msdk.dns.core.config.a.c = i;
        }
    }

    public static void a(com.tencent.msdk.dns.core.config.IRemoteConfigProvider iRemoteConfigProvider) {
        com.tencent.msdk.dns.core.config.d.a(iRemoteConfigProvider);
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.msdk.dns.core.config.a.f666a = str.trim();
    }

    public static boolean a() {
        return f667a;
    }

    public static java.lang.String b() {
        return com.tencent.msdk.dns.core.config.a.f666a;
    }

    public static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String strTrim = str.trim();
        com.tencent.msdk.dns.core.config.a.b = strTrim;
        f667a = !"1".equals(strTrim);
    }

    public static boolean b(int i) {
        return i == 0 || 1 == i || 2 == i;
    }

    public static java.lang.String c() {
        return com.tencent.msdk.dns.core.config.a.b;
    }

    public static void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.msdk.dns.core.config.a.a(str.trim());
    }

    public static java.lang.String d() {
        return com.tencent.msdk.dns.core.config.a.a();
    }

    public static void d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.msdk.dns.core.config.a.d = str.trim();
    }

    public static int e() {
        return com.tencent.msdk.dns.core.config.a.c;
    }

    public static java.lang.String e(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.tencent.msdk.dns.core.config.c.a(f667a, str, com.tencent.msdk.dns.core.config.a.b);
    }

    public static java.lang.String f() {
        return com.tencent.msdk.dns.core.config.a.d;
    }

    public static java.lang.String f(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.tencent.msdk.dns.core.config.c.b(f667a, str, com.tencent.msdk.dns.core.config.a.b);
    }

    public static int g() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int iA = com.tencent.msdk.dns.core.config.d.a();
        com.tencent.msdk.dns.base.log.DnsLog.d("Get dnsChannel: %d, cost %d ms", java.lang.Integer.valueOf(iA), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
        return iA;
    }
}
