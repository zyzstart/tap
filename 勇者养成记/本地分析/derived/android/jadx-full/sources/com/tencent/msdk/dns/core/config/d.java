package com.tencent.msdk.dns.core.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f668a = 1;
    private static com.tencent.msdk.dns.core.config.IRemoteConfigProvider b;

    static int a() {
        com.tencent.msdk.dns.core.config.IRemoteConfigProvider iRemoteConfigProvider = b;
        if (iRemoteConfigProvider != null) {
            int i = iRemoteConfigProvider.getInt("useHttpDns", 1);
            f668a = i;
            if (!com.tencent.msdk.dns.core.config.b.b(i)) {
                f668a = 1;
            }
        }
        return f668a;
    }

    static void a(com.tencent.msdk.dns.core.config.IRemoteConfigProvider iRemoteConfigProvider) {
        b = iRemoteConfigProvider;
    }
}
