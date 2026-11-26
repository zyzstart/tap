package com.tencent.msdk.dns.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements com.tencent.msdk.dns.core.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f664a = 0;
    private com.tencent.msdk.dns.core.a.a b;

    public b(com.tencent.msdk.dns.core.a.a aVar) throws com.tencent.msdk.dns.base.b {
        if (aVar == null) {
            throw new com.tencent.msdk.dns.base.b("realDns == null");
        }
        this.b = aVar;
    }

    @Override // com.tencent.msdk.dns.core.a.a
    public com.tencent.msdk.dns.core.a.c.a a(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.msdk.dns.core.a.c.a aVarA = this.b.a(str);
        this.f664a = (int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        return aVarA;
    }

    public java.lang.String toString() {
        return "DnsStatWrapper{dnsDelay=" + this.f664a + ", mRealDns=" + this.b + '}';
    }
}
