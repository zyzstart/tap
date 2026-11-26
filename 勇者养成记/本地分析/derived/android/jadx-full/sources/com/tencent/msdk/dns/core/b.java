package com.tencent.msdk.dns.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f662a;
    private java.lang.String b;
    private com.tencent.msdk.dns.core.b.b d;
    private com.tencent.msdk.dns.core.b.b e;
    private com.tencent.msdk.dns.core.b.b f;
    private int c = com.tencent.msdk.dns.base.c.a();
    private com.tencent.msdk.dns.core.a.b.b g = com.tencent.msdk.dns.core.a.b.b.a();
    private com.tencent.msdk.dns.core.a.a.b h = com.tencent.msdk.dns.core.a.a.b.a();
    private com.tencent.msdk.dns.core.a.a.b i = com.tencent.msdk.dns.core.a.a.b.a();
    private com.tencent.msdk.dns.core.a.c.d j = com.tencent.msdk.dns.core.a.c.d.a();
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    public b(int i, java.lang.String str) {
        this.b = "0";
        this.f662a = i;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    private boolean a(boolean z) {
        boolean z2 = !z;
        if (!z) {
            return z2;
        }
        com.tencent.msdk.dns.core.a.a.b bVarA = com.tencent.msdk.dns.core.d.a(this.b);
        this.h = bVarA;
        boolean z3 = bVarA != null;
        if (!z3) {
            return z3;
        }
        com.tencent.msdk.dns.base.log.DnsLog.d("HttpDns cache hit.", new java.lang.Object[0]);
        this.l = true;
        return z3;
    }

    private boolean b(boolean z) {
        boolean z2 = !z;
        if (!z) {
            return z2;
        }
        com.tencent.msdk.dns.core.a.a.b bVarB = com.tencent.msdk.dns.core.d.b(this.b);
        this.i = bVarB;
        boolean z3 = bVarB != null;
        if (!z3) {
            return z3;
        }
        com.tencent.msdk.dns.base.log.DnsLog.d("HttpDns cache for Inet6 hit.", new java.lang.Object[0]);
        this.m = true;
        return z3;
    }

    private java.lang.String c() {
        if ("0".equals(this.g.b()) && "0".equals(this.g.c())) {
            return "";
        }
        return this.g.b() + "," + this.g.c();
    }

    public java.util.Map a() {
        java.util.HashMap map = new java.util.HashMap(24);
        if (!this.k) {
            return map;
        }
        map.put("dns_ips", this.j.b.b);
        map.put("dns_4a_ips", this.j.c.b);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, "http");
        map.put("domain", this.b);
        map.put("net_stack", java.lang.String.valueOf(this.c));
        map.put("ldns_ip", c());
        com.tencent.msdk.dns.core.b.b bVar = this.d;
        map.put("ldns_time", java.lang.String.valueOf(bVar != null ? bVar.f664a : 0));
        map.put("isCache", java.lang.String.valueOf(this.l));
        map.put("hdns_a_err_code", java.lang.String.valueOf(com.tencent.msdk.dns.core.a.a.b.a(this.h) ? 0 : -1));
        map.put("hdns_a_err_msg", "");
        map.put("hdns_ip", this.h.d());
        map.put("ttl", java.lang.String.valueOf(this.h.b()));
        map.put("clientIP", this.h.c());
        com.tencent.msdk.dns.core.b.b bVar2 = this.e;
        map.put("hdns_time", java.lang.String.valueOf(bVar2 != null ? bVar2.f664a : 0));
        map.put("hdns_a_retry", "0");
        map.put("hdns_4a_cache_hit", java.lang.String.valueOf(this.m));
        map.put("hdns_4a_err_code", java.lang.String.valueOf(com.tencent.msdk.dns.core.a.a.b.a(this.h) ? 0 : -1));
        map.put("hdns_4a_err_msg", "");
        map.put("hdns_4a_ips", this.i.d());
        map.put("hdns_4a_ttl", java.lang.String.valueOf(this.i.b()));
        map.put("hdns_4a_client_ip", this.i.c());
        com.tencent.msdk.dns.core.b.b bVar3 = this.f;
        map.put("hdns_4a_time_ms", java.lang.String.valueOf(bVar3 != null ? bVar3.f664a : 0));
        map.put("hdns_4a_retry", "0");
        map.put("useHttpDns", java.lang.String.valueOf(this.f662a));
        return map;
    }

    public java.lang.String[] b() {
        return !this.k ? new java.lang.String[]{"0", "0"} : this.j.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        java.util.concurrent.CountDownLatch countDownLatch;
        com.tencent.msdk.dns.core.c cVar;
        if ("0".equals(this.b) || (i = this.c) == 0) {
            this.k = true;
            return;
        }
        boolean z = false;
        boolean z2 = 1 == (i & 1);
        boolean z3 = 2 == (this.c & 2);
        boolean zA = a(z2);
        boolean zB = b(z3);
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = com.tencent.msdk.dns.MSDKDnsResolver.TEST_LOG_PREFIX;
        objArr[1] = java.lang.Boolean.valueOf(zA && zB);
        com.tencent.msdk.dns.base.log.DnsLog.d("%suseCache: %b", objArr);
        if (!zA || !zB) {
            try {
                this.d = new com.tencent.msdk.dns.core.b.b(new com.tencent.msdk.dns.core.a.b.a());
                if (1 == this.f662a || 2 == this.f662a) {
                    if (z2 && !zA) {
                        this.e = new com.tencent.msdk.dns.core.b.b(new com.tencent.msdk.dns.core.a.a.a());
                    }
                    if (z3 && !zB && 2 != this.c) {
                        this.f = new com.tencent.msdk.dns.core.b.b(new com.tencent.msdk.dns.core.a.a.a(true));
                    }
                }
            } catch (com.tencent.msdk.dns.base.b unused) {
            }
            this.h = com.tencent.msdk.dns.core.a.a.b.a();
            this.i = com.tencent.msdk.dns.core.a.a.b.a();
            if (this.e == null || this.f == null) {
                countDownLatch = (this.e == null && this.f == null) ? new java.util.concurrent.CountDownLatch(1) : new java.util.concurrent.CountDownLatch(2);
            } else {
                countDownLatch = new java.util.concurrent.CountDownLatch(3);
            }
            com.tencent.msdk.dns.core.c cVar2 = new com.tencent.msdk.dns.core.c(countDownLatch, this.d, this.b);
            com.tencent.msdk.dns.base.a.a.b.execute(cVar2);
            com.tencent.msdk.dns.core.b.b bVar = this.e;
            com.tencent.msdk.dns.core.c cVar3 = null;
            if (bVar != null) {
                cVar = new com.tencent.msdk.dns.core.c(countDownLatch, bVar, this.b);
                com.tencent.msdk.dns.base.a.a.b.execute(cVar);
            } else {
                cVar = null;
            }
            com.tencent.msdk.dns.core.b.b bVar2 = this.f;
            if (bVar2 != null) {
                cVar3 = new com.tencent.msdk.dns.core.c(countDownLatch, bVar2, this.b);
                com.tencent.msdk.dns.base.a.a.b.execute(cVar3);
            }
            try {
                z = !countDownLatch.await(com.tencent.msdk.dns.core.config.b.e(), java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException unused2) {
            }
            if (z) {
                this.d.f664a = com.tencent.msdk.dns.core.config.b.e();
                com.tencent.msdk.dns.core.b.b bVar3 = this.e;
                if (bVar3 != null) {
                    bVar3.f664a = com.tencent.msdk.dns.core.config.b.e();
                }
                com.tencent.msdk.dns.core.b.b bVar4 = this.f;
                if (bVar4 != null) {
                    bVar4.f664a = com.tencent.msdk.dns.core.config.b.e();
                }
            }
            com.tencent.msdk.dns.core.a.b.b bVar5 = (com.tencent.msdk.dns.core.a.b.b) cVar2.a();
            if (bVar5 != null) {
                this.g = bVar5;
            }
            if (cVar != null) {
                com.tencent.msdk.dns.core.a.a.b bVar6 = (com.tencent.msdk.dns.core.a.a.b) cVar.a();
                if (com.tencent.msdk.dns.core.a.a.b.a(bVar6) && bVar6.f()) {
                    this.h = bVar6;
                }
            }
            if (cVar3 != null) {
                com.tencent.msdk.dns.core.a.a.b bVar7 = (com.tencent.msdk.dns.core.a.a.b) cVar3.a();
                if (com.tencent.msdk.dns.core.a.a.b.a(bVar7) && bVar7.g()) {
                    this.i = bVar7;
                }
            }
        }
        this.j = com.tencent.msdk.dns.core.a.c.c.a(this.c, this.g, this.h, this.i);
        this.k = true;
    }
}
