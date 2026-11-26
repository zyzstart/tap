package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static long f194a;
    android.content.Context b;
    public volatile boolean c = false;

    public i(android.content.Context context) {
        this.b = null;
        this.b = context;
    }

    public static synchronized long a() {
        return f194a;
    }

    public static synchronized void a(long j) {
        f194a = j;
    }

    private boolean a(android.content.Context context, java.lang.String str) {
        boolean z = true;
        try {
            com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
            int i = java.lang.Integer.parseInt(fVarA.a("querytimes", "0"));
            if (!com.tencent.beacon.core.e.b.a().equals(str)) {
                i = 0;
            }
            if (i <= com.tencent.beacon.core.strategy.c.g().j()) {
                int i2 = i + 1;
                com.tencent.beacon.core.a.f fVarB = fVarA.b();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(i2);
                sb.append("");
                fVarB.a("querytimes", (java.lang.Object) sb.toString()).a();
                return false;
            }
            try {
                com.tencent.beacon.core.e.d.e("[strategy] sdk init max times", new java.lang.Object[0]);
                return true;
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception unused2) {
            z = false;
        }
        com.tencent.beacon.core.e.d.i("[strategy] set init times failed! ", new java.lang.Object[0]);
        return z;
    }

    private boolean b(android.content.Context context, java.lang.String str) {
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        if (eventStrategyBean.isStrategyQuerySuccessDaxMax()) {
            com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long j = ((jCurrentTimeMillis / 60000) + 480) % 1440;
            if (j >= 0 && j <= 30 && jCurrentTimeMillis - fVarA.a(com.tencent.beacon.core.strategy.StrategyQueryModule.LAST_SUCCESS_STRATEGY_QUERY_TIME, 0L) <= 90000000) {
                return true;
            }
            if (!com.tencent.beacon.core.e.b.a().equals(str)) {
                fVarA.b().a(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, (java.lang.Object) 0).a();
            } else if (fVarA.a(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, 0) >= eventStrategyBean.getStrategyQuerySuccessDayMaxTimes()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void e() {
        com.tencent.beacon.core.strategy.StrategyQueryModule strategyQueryModule = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.b);
        if (strategyQueryModule.getCurrentQueryStep() == 0) {
            com.tencent.beacon.core.e.d.e("[strategy] stepCheckApp", new java.lang.Object[0]);
            strategyQueryModule.setCurrentQueryStep(1);
            boolean zG = com.tencent.beacon.core.info.a.g(this.b);
            com.tencent.beacon.core.e.d.e("[strategy] isAppFirstRun : %b", java.lang.Boolean.valueOf(zG));
            if (zG) {
                android.content.Context context = this.b;
                com.tencent.beacon.core.e.d.e("[db] clear all analytics: %d", java.lang.Integer.valueOf(com.tencent.beacon.core.a.a.b.a(context, com.tencent.beacon.core.info.g.b(context).a(), (int[]) null, -1L, Long.MAX_VALUE)));
                synchronized (strategyQueryModule) {
                    strategyQueryModule.setAppFirstRun(true);
                }
                java.util.Iterator it = com.tencent.beacon.event.UserAction.beaconModules.iterator();
                while (it.hasNext()) {
                    ((com.tencent.beacon.core.c) it.next()).onAppFirstRun();
                }
            } else {
                long jA = a();
                if (jA > 0) {
                    com.tencent.beacon.core.e.d.e("[strategy] sleep: %d", java.lang.Long.valueOf(jA));
                    b(jA);
                }
            }
        }
        com.tencent.beacon.core.e.d.e("[strategy] stepStartQuery", new java.lang.Object[0]);
        strategyQueryModule.setCurrentQueryStep(2);
        strategyQueryModule.setCommonQueryTime(strategyQueryModule.getCommonQueryTime() + 1);
        java.util.Iterator it2 = com.tencent.beacon.event.UserAction.beaconModules.iterator();
        while (it2.hasNext()) {
            ((com.tencent.beacon.core.c) it2.next()).onStrategyQueryStarted();
        }
        if (!com.tencent.beacon.core.strategy.c.g().k()) {
            c();
        }
        com.tencent.beacon.core.e.d.h("[strategy] common query end!", new java.lang.Object[0]);
        strategyQueryModule.setCurrentQueryStep(3);
        java.util.Iterator it3 = com.tencent.beacon.event.UserAction.beaconModules.iterator();
        while (it3.hasNext()) {
            ((com.tencent.beacon.core.c) it3.next()).onStrategyQueryFinished();
        }
        b();
    }

    public long b() {
        com.tencent.beacon.core.strategy.c strategy = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.b).getStrategy();
        if (strategy == null) {
            com.tencent.beacon.core.e.d.b("[strategy] currentStrategy is null.", new java.lang.Object[0]);
            return -1L;
        }
        long jI = ((long) strategy.i()) * 60000;
        if (jI <= 0) {
            com.tencent.beacon.core.e.d.h("[strategy] stop loop query", new java.lang.Object[0]);
            return -1L;
        }
        com.tencent.beacon.core.a.d.a().a(this, jI);
        com.tencent.beacon.core.e.d.h("[strategy] next time: %d", java.lang.Long.valueOf(jI));
        com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.b).setCurrentQueryStep(4);
        return jI;
    }

    protected void b(long j) {
        try {
            java.lang.Thread.sleep(j);
        } catch (java.lang.InterruptedException e) {
            com.tencent.beacon.core.e.d.a(e);
        }
    }

    public void c() {
        com.tencent.beacon.core.d.j myUpload = com.tencent.beacon.core.strategy.StrategyQueryModule.getMyUpload();
        int i = 0;
        while (myUpload == null && (i = i + 1) < 5) {
            try {
                java.lang.Thread.sleep(200L);
            } catch (java.lang.InterruptedException e) {
                com.tencent.beacon.core.e.d.a(e);
            }
            myUpload = com.tencent.beacon.core.strategy.StrategyQueryModule.getMyUpload();
        }
        if (myUpload == null) {
            com.tencent.beacon.core.e.d.h("[strategy] uphandler is null", new java.lang.Object[0]);
            return;
        }
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.b);
        java.lang.String strA = fVarA.a("initsdkdate", "");
        if (!com.tencent.beacon.core.e.b.a().equals(strA)) {
            fVarA.b().a("initsdkdate", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
        }
        boolean zA = a(this.b, strA);
        boolean zB = b(this.b, strA);
        if (zA || zB) {
            com.tencent.beacon.core.e.d.i("[strategy] query times or query success times arrive max, return!", new java.lang.Object[0]);
            com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.b).setAtLeastAComQuerySuccess(true);
            return;
        }
        java.lang.String strA2 = com.tencent.beacon.core.info.g.b(this.b).a();
        com.tencent.beacon.core.e.d.a("[REDACTED]" + strA2, new java.lang.Object[0]);
        myUpload.a(new com.tencent.beacon.core.strategy.l(this.b, 0, 100, strA2));
    }

    void d() {
        try {
            com.tencent.beacon.core.strategy.k kVarB = com.tencent.beacon.core.strategy.d.b(this.b, 101);
            if (kVarB == null || kVarB.b != 101 || kVarB.c == null) {
                com.tencent.beacon.core.e.d.b("local strategy data == null", new java.lang.Object[0]);
            } else {
                com.tencent.beacon.core.d.g strategyHandler = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.b).getStrategyHandler();
                if (strategyHandler != null) {
                    strategyHandler.a(101, kVarB.c, false);
                    com.tencent.beacon.core.e.d.e("common strategy setted by local db", new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c = true;
        e();
        this.c = false;
    }
}
