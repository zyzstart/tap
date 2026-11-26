package com.tencent.msdk.dns.base.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.Class f652a;
    private static java.lang.reflect.Method b;

    static {
        try {
            f652a = java.lang.Class.forName("com.tencent.gcloud.httpdns.report.GCloudCoreReporter");
        } catch (java.lang.Exception unused) {
            com.tencent.msdk.dns.base.log.DnsLog.d("Can not find GCloudCoreReporter class", new java.lang.Object[0]);
            f652a = null;
        }
    }

    public static boolean a(int i, java.lang.String str, java.util.Map map) {
        java.lang.Class cls = f652a;
        if (cls == null) {
            return false;
        }
        try {
            if (b == null) {
                b = cls.getMethod("reportEvent", java.lang.Integer.TYPE, java.lang.String.class, java.util.Map.class);
            }
            b.invoke(null, java.lang.Integer.valueOf(i), str, map);
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.msdk.dns.base.log.DnsLog.w(e, "Call GCloudCoreReporter.reportEvent() failed", new java.lang.Object[0]);
            return false;
        }
    }
}
