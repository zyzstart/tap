package com.tencent.msdk.dns.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.CountDownLatch f665a;
    private com.tencent.msdk.dns.core.a.a b;
    private java.lang.String c;
    private com.tencent.msdk.dns.core.a.c.a d;

    public c(java.util.concurrent.CountDownLatch countDownLatch, com.tencent.msdk.dns.core.a.a aVar, java.lang.String str) {
        this.f665a = countDownLatch;
        this.b = aVar;
        this.c = str;
    }

    public com.tencent.msdk.dns.core.a.c.a a() {
        return this.d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f665a == null || this.b == null || android.text.TextUtils.isEmpty(this.c)) {
            return;
        }
        com.tencent.msdk.dns.core.a.c.a aVarA = this.b.a(this.c);
        this.d = aVarA;
        com.tencent.msdk.dns.base.log.DnsLog.d("%s resolve %s: %s", this.b, this.c, aVarA);
        com.tencent.msdk.dns.core.a.c.a aVar = this.d;
        if ((aVar instanceof com.tencent.msdk.dns.core.a.a.b) && com.tencent.msdk.dns.core.a.a.b.a((com.tencent.msdk.dns.core.a.a.b) aVar)) {
            com.tencent.msdk.dns.base.log.DnsLog.d("Cache httpDns.", new java.lang.Object[0]);
            com.tencent.msdk.dns.core.d.a(this.c, (com.tencent.msdk.dns.core.a.a.b) this.d);
        }
        this.f665a.countDown();
    }
}
