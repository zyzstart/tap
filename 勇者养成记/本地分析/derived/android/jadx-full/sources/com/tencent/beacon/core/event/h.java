package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f169a;
    private java.lang.String b;
    public boolean d;
    private com.tencent.beacon.core.event.n f;
    private com.tencent.beacon.core.event.n g;
    private java.util.Map c = null;
    private final java.lang.Object e = new java.lang.Object();
    private java.lang.String h = "10000";

    public h(android.content.Context context, java.lang.String str) {
        this.f = null;
        this.g = null;
        this.f169a = context;
        this.b = str;
        this.f = new com.tencent.beacon.core.event.C0083c(context, this);
        this.g = new com.tencent.beacon.core.event.q(context, this);
    }

    public java.util.Map a() {
        return this.c;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public void a(java.util.Map map) {
        if (map == null || map.size() > 20) {
            return;
        }
        if (this.c == null) {
            this.c = new java.util.HashMap();
        }
        this.c.putAll(map);
    }

    public void a(boolean z) {
        com.tencent.beacon.core.event.n nVarC = c();
        if (nVarC != null) {
            nVarC.a(z);
        }
        com.tencent.beacon.core.event.n nVarE = e();
        if (nVarE != null) {
            nVarE.a(z);
        }
        this.d = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(boolean z, boolean z2) {
        if (!com.tencent.beacon.core.event.TunnelModule.isModuleAble()) {
            com.tencent.beacon.core.e.d.b("[module] this module not ready!", new java.lang.Object[0]);
            return;
        }
        if (z2) {
            com.tencent.beacon.core.e.d.a("doUploadRecentCommonData, upload all db", new java.lang.Object[0]);
        }
        synchronized (this.e) {
            boolean zA = true;
            int i = 0;
            while (true) {
                int iD = d();
                if (!zA || iD <= 0 || i > 100 || !(z2 || i == 0)) {
                    break;
                }
                try {
                    if (com.tencent.beacon.core.d.k.a(this.f169a) != null) {
                        com.tencent.beacon.core.event.e eVar = new com.tencent.beacon.core.event.e(this.f169a, this.b);
                        eVar.b(z);
                        zA = com.tencent.beacon.core.d.k.a(this.f169a).a(eVar);
                    }
                    i++;
                } catch (java.lang.Throwable th) {
                    com.tencent.beacon.core.e.d.b("[event] up common error: %s", th.toString());
                    com.tencent.beacon.core.e.d.a(th);
                }
            }
        }
    }

    public boolean a(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        java.lang.String strB = com.tencent.beacon.core.e.c.b(str);
        if (strB == null) {
            com.tencent.beacon.core.d.i.a(this.f169a).a("101", str);
            return false;
        }
        com.tencent.beacon.core.e.d.d("[event] UserEvent: %s, %b, %d, %d, %b, %b", strB, java.lang.Boolean.valueOf(z), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(z3));
        if (com.tencent.beacon.core.event.EventStrategyBean.getInstance().isInPreventEventCode(strB)) {
            com.tencent.beacon.core.e.d.b("[event] '%s' is not allowed in strategy (false).", strB);
            return false;
        }
        if (z && !com.tencent.beacon.core.event.EventStrategyBean.getInstance().isUploadByRate(strB)) {
            com.tencent.beacon.core.e.d.b("[event] '%s' is sampled by svr rate (false).", strB);
            return false;
        }
        com.tencent.beacon.core.event.n nVarE = z2 ? e() : c();
        if (nVarE == null) {
            return false;
        }
        com.tencent.beacon.core.event.RDBean rDBeanA = com.tencent.beacon.core.event.s.a(this.f169a, this.b, strB, z, j, j2, map, z2, z3);
        if (rDBeanA != null) {
            return nVarE.a(rDBeanA);
        }
        com.tencent.beacon.core.e.d.b("[event] RDBean:%s is null, return false!", strB);
        return false;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void b(java.lang.String str) {
        this.h = str;
    }

    public com.tencent.beacon.core.event.n c() {
        return this.f;
    }

    public int d() {
        if (this.d) {
            return com.tencent.beacon.core.event.t.a(this.f169a, this.b);
        }
        return -1;
    }

    public com.tencent.beacon.core.event.n e() {
        return this.g;
    }

    public java.lang.String f() {
        return this.h;
    }

    public void g() {
        this.f.a();
        this.g.a();
    }

    public void h() {
        a(false, true);
    }

    public void i() {
        try {
            com.tencent.beacon.core.strategy.c strategy = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f169a).getStrategy();
            if (strategy == null) {
                return;
            }
            com.tencent.beacon.core.strategy.b bVarB = strategy.b(1);
            if (bVarB != null && com.tencent.beacon.core.event.EventStrategyBean.getInstance() != null) {
                java.util.Set setB = bVarB.b();
                if (setB != null && setB.size() > 0) {
                    com.tencent.beacon.core.event.EventStrategyBean.getInstance().setPreventEventCode(setB);
                }
                java.util.Set setC = bVarB.c();
                if (setC != null && setC.size() > 0) {
                    com.tencent.beacon.core.event.EventStrategyBean.getInstance().setSampleEvent(setC);
                }
            }
            if (!this.d || bVarB == null) {
                com.tencent.beacon.core.e.d.b("[event] module is disable", new java.lang.Object[0]);
                return;
            }
            if (d() > 0) {
                com.tencent.beacon.core.e.d.e("[event] asyn up module %d", 1);
                com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.event.g(this));
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[event] common query end error %s", th.toString());
        }
    }
}
