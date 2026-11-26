package com.tencent.bugly.opengame.crashreport.common.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f345a = 1000;
    private static com.tencent.bugly.opengame.crashreport.common.strategy.a b;
    private static java.lang.String h;
    private final java.util.List c;
    private android.content.Context g;
    private com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean f = null;
    private final com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean e = new com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean();
    private final com.tencent.bugly.opengame.proguard.w d = com.tencent.bugly.opengame.proguard.w.a();

    private a(android.content.Context context, java.util.List list) {
        this.g = context;
        this.c = list;
    }

    public static synchronized com.tencent.bugly.opengame.crashreport.common.strategy.a a() {
        return b;
    }

    public static synchronized com.tencent.bugly.opengame.crashreport.common.strategy.a a(android.content.Context context, java.util.List list) {
        if (b == null) {
            b = new com.tencent.bugly.opengame.crashreport.common.strategy.a(context, list);
        }
        return b;
    }

    public static void a(java.lang.String str) {
        if (com.tencent.bugly.opengame.proguard.z.a(str) || !com.tencent.bugly.opengame.proguard.z.c(str)) {
            com.tencent.bugly.opengame.proguard.x.d("URL user set is invalid.", new java.lang.Object[0]);
        } else {
            h = str;
        }
    }

    public static com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean d() {
        byte[] bArr;
        java.util.List listA = com.tencent.bugly.opengame.proguard.p.a().a(2);
        if (listA == null || listA.size() <= 0 || (bArr = ((com.tencent.bugly.opengame.proguard.r) listA.get(0)).g) == null) {
            return null;
        }
        return (com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean) com.tencent.bugly.opengame.proguard.z.a(bArr, com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.CREATOR);
    }

    public final void a(long j) {
        this.d.a(new java.lang.Thread() { // from class: com.tencent.bugly.opengame.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    java.util.Map mapA = com.tencent.bugly.opengame.proguard.p.a().a(com.tencent.bugly.opengame.crashreport.common.strategy.a.f345a, (com.tencent.bugly.opengame.proguard.o) null, true);
                    if (mapA != null) {
                        byte[] bArr = (byte[]) mapA.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE);
                        byte[] bArr2 = (byte[]) mapA.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.opengame.crashreport.common.info.a.a(com.tencent.bugly.opengame.crashreport.common.strategy.a.this.g).e(new java.lang.String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.opengame.crashreport.common.info.a.a(com.tencent.bugly.opengame.crashreport.common.strategy.a.this.g).d(new java.lang.String(bArr2));
                        }
                    }
                    com.tencent.bugly.opengame.crashreport.common.strategy.a.this.f = com.tencent.bugly.opengame.crashreport.common.strategy.a.d();
                    if (com.tencent.bugly.opengame.crashreport.common.strategy.a.this.f != null && !com.tencent.bugly.opengame.proguard.z.a(com.tencent.bugly.opengame.crashreport.common.strategy.a.h) && com.tencent.bugly.opengame.proguard.z.c(com.tencent.bugly.opengame.crashreport.common.strategy.a.h)) {
                        com.tencent.bugly.opengame.crashreport.common.strategy.a.this.f.r = com.tencent.bugly.opengame.crashreport.common.strategy.a.h;
                        com.tencent.bugly.opengame.crashreport.common.strategy.a.this.f.s = com.tencent.bugly.opengame.crashreport.common.strategy.a.h;
                    }
                } catch (java.lang.Throwable th) {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                }
                com.tencent.bugly.opengame.crashreport.common.strategy.a aVar = com.tencent.bugly.opengame.crashreport.common.strategy.a.this;
                aVar.a(aVar.f, false);
            }
        }, j);
    }

    protected final void a(com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean, boolean z) {
        com.tencent.bugly.opengame.proguard.x.c("[Strategy] Notify %s", com.tencent.bugly.opengame.crashreport.biz.b.class.getName());
        com.tencent.bugly.opengame.crashreport.biz.b.a(strategyBean, z);
        for (com.tencent.bugly.opengame.a aVar : this.c) {
            try {
                com.tencent.bugly.opengame.proguard.x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(com.tencent.bugly.opengame.proguard.as asVar) {
        if (asVar == null) {
            return;
        }
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean = this.f;
        if (strategyBean == null || asVar.h != strategyBean.p) {
            com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean2 = new com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean();
            strategyBean2.g = asVar.f388a;
            strategyBean2.i = asVar.c;
            strategyBean2.h = asVar.b;
            if (com.tencent.bugly.opengame.proguard.z.a(h) || !com.tencent.bugly.opengame.proguard.z.c(h)) {
                if (com.tencent.bugly.opengame.proguard.z.c(asVar.d)) {
                    com.tencent.bugly.opengame.proguard.x.c("[Strategy] Upload url changes to %s", asVar.d);
                    strategyBean2.r = asVar.d;
                }
                if (com.tencent.bugly.opengame.proguard.z.c(asVar.e)) {
                    com.tencent.bugly.opengame.proguard.x.c("[Strategy] Exception upload url changes to %s", asVar.e);
                    strategyBean2.s = asVar.e;
                }
            }
            com.tencent.bugly.opengame.proguard.ar arVar = asVar.f;
            if (arVar != null && !com.tencent.bugly.opengame.proguard.z.a(arVar.f387a)) {
                strategyBean2.u = asVar.f.f387a;
            }
            long j = asVar.h;
            if (j != 0) {
                strategyBean2.p = j;
            }
            java.util.Map map = asVar.g;
            if (map != null && map.size() > 0) {
                java.util.Map map2 = asVar.g;
                strategyBean2.v = map2;
                java.lang.String str = (java.lang.String) map2.get("B11");
                if (str == null || !str.equals("1")) {
                    strategyBean2.j = false;
                } else {
                    strategyBean2.j = true;
                }
                java.lang.String str2 = (java.lang.String) asVar.g.get("B3");
                if (str2 != null) {
                    strategyBean2.y = java.lang.Long.valueOf(str2).longValue();
                }
                long j2 = asVar.i;
                strategyBean2.q = j2;
                strategyBean2.x = j2;
                java.lang.String str3 = (java.lang.String) asVar.g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i = java.lang.Integer.parseInt(str3);
                        if (i > 0) {
                            strategyBean2.w = i;
                        }
                    } catch (java.lang.Exception e) {
                        if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                java.lang.String str4 = (java.lang.String) asVar.g.get("B25");
                if (str4 == null || !str4.equals("1")) {
                    strategyBean2.l = false;
                } else {
                    strategyBean2.l = true;
                }
            }
            com.tencent.bugly.opengame.proguard.x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", java.lang.Boolean.valueOf(strategyBean2.g), java.lang.Boolean.valueOf(strategyBean2.i), java.lang.Boolean.valueOf(strategyBean2.h), java.lang.Boolean.valueOf(strategyBean2.j), java.lang.Boolean.valueOf(strategyBean2.k), java.lang.Boolean.valueOf(strategyBean2.n), java.lang.Boolean.valueOf(strategyBean2.o), java.lang.Long.valueOf(strategyBean2.q), java.lang.Boolean.valueOf(strategyBean2.l), java.lang.Long.valueOf(strategyBean2.p));
            this.f = strategyBean2;
            com.tencent.bugly.opengame.proguard.p.a().b(2);
            com.tencent.bugly.opengame.proguard.r rVar = new com.tencent.bugly.opengame.proguard.r();
            rVar.b = 2;
            rVar.f404a = strategyBean2.e;
            rVar.e = strategyBean2.f;
            rVar.g = com.tencent.bugly.opengame.proguard.z.a(strategyBean2);
            com.tencent.bugly.opengame.proguard.p.a().a(rVar);
            a(strategyBean2, true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean b() {
        return this.f != null;
    }

    public final com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean c() {
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean = this.f;
        return strategyBean != null ? strategyBean : this.e;
    }
}
