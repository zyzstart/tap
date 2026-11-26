package com.tencent.msdk.dns.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f672a = false;
    private static android.content.Context b;

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, int i) {
        if (context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            applicationContext.registerReceiver(new com.tencent.msdk.dns.core.a(), new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (z) {
            com.tencent.msdk.dns.base.log.DnsLog.setLogLevel(3);
        }
        com.tencent.msdk.dns.core.config.b.a(str);
        com.tencent.msdk.dns.core.config.b.b(str2);
        com.tencent.msdk.dns.core.config.b.c(str3);
        com.tencent.msdk.dns.core.config.b.a(i);
        f672a = true;
    }

    public static void a(android.content.Context context, java.lang.String str, boolean z, int i) {
        a(context, str, null, null, z, i);
    }

    public static void a(com.tencent.msdk.dns.core.config.IRemoteConfigProvider iRemoteConfigProvider) {
        com.tencent.msdk.dns.core.config.b.a(iRemoteConfigProvider);
    }

    public static void a(java.lang.String str) {
        com.tencent.msdk.dns.core.config.b.d(str);
    }

    private static void a(java.util.Map map) {
        if (b == null) {
            return;
        }
        if (map == null) {
            map = new java.util.HashMap();
        }
        map.putAll(new com.tencent.msdk.dns.core.b.a(b).a());
        for (java.util.Map.Entry entry : map.entrySet()) {
            com.tencent.msdk.dns.base.log.DnsLog.d("%s: %s", entry.getKey(), entry.getValue());
        }
        com.tencent.msdk.dns.base.b.f.a(2, 3, "HDNSGetHostByName", map);
    }

    public static java.lang.String[] b(java.lang.String str) {
        if (b == null || android.text.TextUtils.isEmpty(str)) {
            return new java.lang.String[]{"0", "0"};
        }
        try {
            com.tencent.msdk.dns.core.b bVar = new com.tencent.msdk.dns.core.b(com.tencent.msdk.dns.core.config.b.g(), str.trim());
            bVar.run();
            a(bVar.a());
            return bVar.b();
        } catch (java.lang.Throwable th) {
            com.tencent.msdk.dns.base.log.DnsLog.w(th, "GetAddrByName failed", new java.lang.Object[0]);
            return new java.lang.String[]{"0", "0"};
        }
    }
}
