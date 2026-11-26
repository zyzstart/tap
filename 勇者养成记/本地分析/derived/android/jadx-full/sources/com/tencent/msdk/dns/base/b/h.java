package com.tencent.msdk.dns.base.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.Class f654a;
    private static java.lang.reflect.Method b;

    static {
        try {
            f654a = java.lang.Class.forName("com.tencent.beacon.event.UserAction");
        } catch (java.lang.Exception unused) {
            com.tencent.msdk.dns.base.log.DnsLog.d("Can not find UserAction class", new java.lang.Object[0]);
            f654a = null;
        }
    }

    public static boolean a(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        java.lang.Class cls = f654a;
        if (cls == null) {
            return false;
        }
        try {
            try {
                if (b == null) {
                    b = cls.getMethod("onUserAction", java.lang.String.class, java.lang.Boolean.TYPE, java.lang.Long.TYPE, java.lang.Long.TYPE, java.util.Map.class, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE);
                }
                return ((java.lang.Boolean) b.invoke(null, str, java.lang.Boolean.valueOf(z), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), map, java.lang.Boolean.valueOf(z2), java.lang.Boolean.TRUE)).booleanValue();
            } catch (java.lang.Exception e) {
                com.tencent.msdk.dns.base.log.DnsLog.w(e, "Call UserAction.onUserAction() failed", new java.lang.Object[0]);
                return false;
            }
        } catch (java.lang.Exception unused) {
            if (b == null) {
                b = f654a.getMethod("onUserAction", java.lang.String.class, java.lang.Boolean.TYPE, java.lang.Long.TYPE, java.lang.Long.TYPE, java.util.Map.class, java.lang.Boolean.TYPE);
            }
            return ((java.lang.Boolean) b.invoke(null, str, java.lang.Boolean.valueOf(z), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), map, java.lang.Boolean.valueOf(z2))).booleanValue();
        }
    }
}
