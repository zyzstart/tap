package com.tencent.msdk.dns;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MSDKDnsResolver {
    public static final java.lang.String TEST_LOG_PREFIX = "[Test]";
    private static volatile com.tencent.msdk.dns.MSDKDnsResolver sInstance;

    public static com.tencent.msdk.dns.MSDKDnsResolver getInstance() {
        if (sInstance == null) {
            synchronized (com.tencent.msdk.dns.MSDKDnsResolver.class) {
                if (sInstance == null) {
                    sInstance = new com.tencent.msdk.dns.MSDKDnsResolver();
                }
            }
        }
        return sInstance;
    }

    public boolean WGSetDnsOpenId(java.lang.String str) {
        com.tencent.msdk.dns.base.log.DnsLog.d("MSDKDnsResolver.WGSetDnsOpenId() called.", new java.lang.Object[0]);
        com.tencent.msdk.dns.core.e.a(str);
        return true;
    }

    public void addLogNode(com.tencent.msdk.dns.base.log.ILogNode iLogNode) {
        com.tencent.msdk.dns.base.log.DnsLog.addLogNode(iLogNode);
    }

    public java.lang.String getAddrByName(java.lang.String str) {
        com.tencent.msdk.dns.base.log.DnsLog.d("MSDKDnsResolver.getAddrByName() called.", new java.lang.Object[0]);
        java.lang.String[] strArrB = com.tencent.msdk.dns.core.e.b(str);
        if (strArrB == null || 2 != strArrB.length) {
            return "0;0";
        }
        return strArrB[0] + ";" + strArrB[1];
    }

    public void init(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, int i) {
        com.tencent.msdk.dns.base.log.DnsLog.d("MSDKDnsResolver.init() called.", new java.lang.Object[0]);
        com.tencent.msdk.dns.core.e.a(context, str, str2, str3, z, i);
    }

    public void init(android.content.Context context, java.lang.String str, boolean z, int i) {
        com.tencent.msdk.dns.base.log.DnsLog.d("MSDKDnsResolver.init() called.", new java.lang.Object[0]);
        com.tencent.msdk.dns.core.e.a(context, str, z, i);
    }

    public void setRemoteConfigProvider(com.tencent.msdk.dns.core.config.IRemoteConfigProvider iRemoteConfigProvider) {
        com.tencent.msdk.dns.core.e.a(iRemoteConfigProvider);
    }
}
