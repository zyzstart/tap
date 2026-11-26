package com.tencent.msdk.dns.base.jni;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    static {
        try {
            java.lang.System.loadLibrary("httpdns");
        } catch (java.lang.Throwable unused) {
            com.tencent.msdk.dns.base.log.DnsLog.w("Load httpdns so failed", new java.lang.Object[0]);
        }
    }

    public static int a() {
        try {
            return com.tencent.msdk.dns.base.jni.Jni.getNetworkStack();
        } catch (java.lang.Throwable unused) {
            com.tencent.msdk.dns.base.log.DnsLog.w("Get network stack failed", new java.lang.Object[0]);
            return 0;
        }
    }

    public static void a(java.lang.String str) {
        try {
            com.tencent.msdk.dns.base.jni.Jni.setDnsKey(str);
        } catch (java.lang.Throwable unused) {
            com.tencent.msdk.dns.base.log.DnsLog.w("Set Dns Key failed", new java.lang.Object[0]);
        }
    }

    public static java.lang.String b() {
        try {
            return com.tencent.msdk.dns.base.jni.Jni.getDnsKey();
        } catch (java.lang.Throwable unused) {
            com.tencent.msdk.dns.base.log.DnsLog.w("Get Dns Key failed", new java.lang.Object[0]);
            return "";
        }
    }
}
