package com.tencent.msdk.dns.core.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.msdk.dns.core.a.a {
    @Override // com.tencent.msdk.dns.core.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.msdk.dns.core.a.b.b a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.tencent.msdk.dns.core.a.b.b.a();
        }
        com.tencent.msdk.dns.base.log.DnsLog.d("LocalDns(domain:%s) start.", str);
        try {
            return com.tencent.msdk.dns.core.a.c.b.a(java.net.InetAddress.getAllByName(str));
        } catch (java.lang.Exception unused) {
            return com.tencent.msdk.dns.core.a.b.b.a();
        }
    }

    public java.lang.String toString() {
        return "LocalDnsImpl{}";
    }
}
