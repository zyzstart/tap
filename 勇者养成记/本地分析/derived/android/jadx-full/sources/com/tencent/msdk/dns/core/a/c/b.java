package com.tencent.msdk.dns.core.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.regex.Pattern f659a = java.util.regex.Pattern.compile("(.*)\\|(.*),(.*)");
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("(.*),(.*)\\|(.*)");

    private static com.tencent.msdk.dns.core.a.a.b a(java.lang.String str) {
        if (str == null) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
        java.util.regex.Matcher matcher = f659a.matcher(str);
        if (!matcher.matches() || 3 != matcher.groupCount()) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
        try {
            java.lang.String[] strArrSplit = matcher.group(1).split(";");
            long j = java.lang.Long.parseLong(matcher.group(3));
            java.lang.String strGroup = matcher.group(2);
            com.tencent.msdk.dns.base.log.DnsLog.d("HttpDns resolve result: %s", java.util.Arrays.toString(strArrSplit));
            return new com.tencent.msdk.dns.core.a.a.b(strArrSplit, j, strGroup);
        } catch (java.lang.Exception unused) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
    }

    public static com.tencent.msdk.dns.core.a.a.b a(java.lang.String str, boolean z) {
        return z ? b(str) : a(str);
    }

    public static com.tencent.msdk.dns.core.a.b.b a(java.net.InetAddress[] inetAddressArr) {
        if (inetAddressArr == null) {
            return com.tencent.msdk.dns.core.a.b.b.a();
        }
        java.lang.String[] strArr = new java.lang.String[inetAddressArr.length];
        for (int i = 0; i < inetAddressArr.length; i++) {
            if (inetAddressArr[i] != null) {
                strArr[i] = inetAddressArr[i].getHostAddress();
            } else {
                strArr[i] = "";
            }
        }
        com.tencent.msdk.dns.base.log.DnsLog.d("LocalDns resolve result: %s", java.util.Arrays.toString(strArr));
        return new com.tencent.msdk.dns.core.a.b.b(strArr);
    }

    private static com.tencent.msdk.dns.core.a.a.b b(java.lang.String str) {
        if (str == null) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
        java.util.regex.Matcher matcher = b.matcher(str);
        if (!matcher.matches() || 3 != matcher.groupCount()) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
        try {
            java.lang.String[] strArrSplit = matcher.group(1).split(";");
            long j = java.lang.Long.parseLong(matcher.group(2));
            java.lang.String strGroup = matcher.group(3);
            com.tencent.msdk.dns.base.log.DnsLog.d("HttpDns resolve result: %s", java.util.Arrays.toString(strArrSplit));
            return new com.tencent.msdk.dns.core.a.a.b(strArrSplit, j, strGroup);
        } catch (java.lang.Exception unused) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
    }
}
