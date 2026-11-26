package com.tencent.bugly.crashreport.common.strategy;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f295a = 1000;
    private static com.tencent.bugly.crashreport.common.strategy.a b;
    private static java.lang.String h;
    private final java.util.List<com.tencent.bugly.a> c;
    private android.content.Context g;
    private com.tencent.bugly.crashreport.common.strategy.StrategyBean f = null;
    private final com.tencent.bugly.crashreport.common.strategy.StrategyBean e = new com.tencent.bugly.crashreport.common.strategy.StrategyBean();
    private final com.tencent.bugly.proguard.w d = com.tencent.bugly.proguard.w.a();

    private a(android.content.Context context, java.util.List<com.tencent.bugly.a> list) {
        this.g = context;
        this.c = list;
    }

    public static synchronized com.tencent.bugly.crashreport.common.strategy.a a() {
        return b;
    }

    public static synchronized com.tencent.bugly.crashreport.common.strategy.a a(android.content.Context context, java.util.List<com.tencent.bugly.a> list) {
        if (b == null) {
            b = new com.tencent.bugly.crashreport.common.strategy.a(context, list);
        }
        return b;
    }

    public static void a(java.lang.String str) {
        if (com.tencent.bugly.proguard.z.a(str) || !com.tencent.bugly.proguard.z.c(str)) {
            com.tencent.bugly.proguard.x.d("URL user set is invalid.", new java.lang.Object[0]);
        } else {
            h = str;
        }
    }

    public static com.tencent.bugly.crashreport.common.strategy.StrategyBean d() {
        java.util.List<com.tencent.bugly.proguard.r> listA = com.tencent.bugly.proguard.p.a().a(2);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        com.tencent.bugly.proguard.r rVar = listA.get(0);
        if (rVar.g != null) {
            return (com.tencent.bugly.crashreport.common.strategy.StrategyBean) com.tencent.bugly.proguard.z.a(rVar.g, com.tencent.bugly.crashreport.common.strategy.StrategyBean.CREATOR);
        }
        return null;
    }

    public final void a(long j) {
        this.d.a(new java.lang.Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    java.util.Map<java.lang.String, byte[]> mapA = com.tencent.bugly.proguard.p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f295a, (com.tencent.bugly.proguard.o) null, true);
                    if (mapA != null) {
                        byte[] bArr = mapA.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE);
                        byte[] bArr2 = mapA.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(com.tencent.bugly.crashreport.common.strategy.a.this.g).e(new java.lang.String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(com.tencent.bugly.crashreport.common.strategy.a.this.g).d(new java.lang.String(bArr2));
                        }
                    }
                    com.tencent.bugly.crashreport.common.strategy.a aVar = com.tencent.bugly.crashreport.common.strategy.a.this;
                    com.tencent.bugly.crashreport.common.strategy.a aVar2 = com.tencent.bugly.crashreport.common.strategy.a.this;
                    aVar.f = com.tencent.bugly.crashreport.common.strategy.a.d();
                    if (com.tencent.bugly.crashreport.common.strategy.a.this.f != null && !com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.common.strategy.a.h) && com.tencent.bugly.proguard.z.c(com.tencent.bugly.crashreport.common.strategy.a.h)) {
                        com.tencent.bugly.crashreport.common.strategy.a.this.f.r = com.tencent.bugly.crashreport.common.strategy.a.h;
                        com.tencent.bugly.crashreport.common.strategy.a.this.f.s = com.tencent.bugly.crashreport.common.strategy.a.h;
                    }
                } catch (java.lang.Throwable th) {
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                }
                com.tencent.bugly.crashreport.common.strategy.a aVar3 = com.tencent.bugly.crashreport.common.strategy.a.this;
                aVar3.a(aVar3.f, false);
            }
        }, j);
    }

    protected final void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean, boolean z) {
        com.tencent.bugly.proguard.x.c("[Strategy] Notify %s", com.tencent.bugly.crashreport.biz.b.class.getName());
        com.tencent.bugly.crashreport.biz.b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.c) {
            try {
                com.tencent.bugly.proguard.x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(com.tencent.bugly.proguard.as asVar) {
        if (asVar == null) {
            return;
        }
        if (this.f == null || asVar.h != this.f.p) {
            com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean = new com.tencent.bugly.crashreport.common.strategy.StrategyBean();
            strategyBean.g = asVar.f430a;
            strategyBean.i = asVar.c;
            strategyBean.h = asVar.b;
            if (com.tencent.bugly.proguard.z.a(h) || !com.tencent.bugly.proguard.z.c(h)) {
                if (com.tencent.bugly.proguard.z.c(asVar.d)) {
                    com.tencent.bugly.proguard.x.c("[Strategy] Upload url changes to %s", asVar.d);
                    strategyBean.r = asVar.d;
                }
                if (com.tencent.bugly.proguard.z.c(asVar.e)) {
                    com.tencent.bugly.proguard.x.c("[Strategy] Exception upload url changes to %s", asVar.e);
                    strategyBean.s = asVar.e;
                }
            }
            if (asVar.f != null && !com.tencent.bugly.proguard.z.a(asVar.f.f429a)) {
                strategyBean.u = asVar.f.f429a;
            }
            if (asVar.h != 0) {
                strategyBean.p = asVar.h;
            }
            if (asVar.g != null && asVar.g.size() > 0) {
                strategyBean.v = asVar.g;
                java.lang.String str = asVar.g.get("B11");
                if (str == null || !str.equals("1")) {
                    strategyBean.j = false;
                } else {
                    strategyBean.j = true;
                }
                java.lang.String str2 = asVar.g.get("B3");
                if (str2 != null) {
                    strategyBean.y = java.lang.Long.valueOf(str2).longValue();
                }
                strategyBean.q = asVar.i;
                strategyBean.x = asVar.i;
                java.lang.String str3 = asVar.g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i = java.lang.Integer.parseInt(str3);
                        if (i > 0) {
                            strategyBean.w = i;
                        }
                    } catch (java.lang.Exception e) {
                        if (!com.tencent.bugly.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                java.lang.String str4 = asVar.g.get("B25");
                if (str4 == null || !str4.equals("1")) {
                    strategyBean.l = false;
                } else {
                    strategyBean.l = true;
                }
            }
            com.tencent.bugly.proguard.x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", java.lang.Boolean.valueOf(strategyBean.g), java.lang.Boolean.valueOf(strategyBean.i), java.lang.Boolean.valueOf(strategyBean.h), java.lang.Boolean.valueOf(strategyBean.j), java.lang.Boolean.valueOf(strategyBean.k), java.lang.Boolean.valueOf(strategyBean.n), java.lang.Boolean.valueOf(strategyBean.o), java.lang.Long.valueOf(strategyBean.q), java.lang.Boolean.valueOf(strategyBean.l), java.lang.Long.valueOf(strategyBean.p));
            this.f = strategyBean;
            com.tencent.bugly.proguard.p.a().b(2);
            com.tencent.bugly.proguard.r rVar = new com.tencent.bugly.proguard.r();
            rVar.b = 2;
            rVar.f446a = strategyBean.e;
            rVar.e = strategyBean.f;
            rVar.g = com.tencent.bugly.proguard.z.a(strategyBean);
            com.tencent.bugly.proguard.p.a().a(rVar);
            a(strategyBean, true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean b() {
        return this.f != null;
    }

    public final com.tencent.bugly.crashreport.common.strategy.StrategyBean c() {
        com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean = this.f;
        return strategyBean != null ? strategyBean : this.e;
    }
}
