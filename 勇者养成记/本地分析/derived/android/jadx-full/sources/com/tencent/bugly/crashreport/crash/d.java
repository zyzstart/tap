package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.bugly.crashreport.crash.d f313a;
    private com.tencent.bugly.crashreport.common.strategy.a b;
    private com.tencent.bugly.crashreport.common.info.a c;
    private com.tencent.bugly.crashreport.crash.b d;
    private android.content.Context e;

    private d(android.content.Context context) {
        com.tencent.bugly.crashreport.crash.c cVarA = com.tencent.bugly.crashreport.crash.c.a();
        if (cVarA == null) {
            return;
        }
        this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.d = cVarA.p;
        this.e = context;
        com.tencent.bugly.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.bugly.crashreport.crash.d.a(com.tencent.bugly.crashreport.crash.d.this);
            }
        });
    }

    public static com.tencent.bugly.crashreport.crash.d a(android.content.Context context) {
        if (f313a == null) {
            f313a = new com.tencent.bugly.crashreport.crash.d(context);
        }
        return f313a;
    }

    static /* synthetic */ void a(com.tencent.bugly.crashreport.crash.d dVar) {
        com.tencent.bugly.proguard.x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new java.lang.Object[0]);
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.tencent.bugly.agent.GameAgent");
            java.lang.String str = "com.tencent.bugly";
            dVar.c.getClass();
            if (!"".equals("")) {
                str = "com.tencent.bugly.";
            }
            com.tencent.bugly.proguard.z.a(cls, "sdkPackageName", str, (java.lang.Object) null);
            com.tencent.bugly.proguard.x.c("[ExtraCrashManager] Bugly game agent has been notified.", new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            com.tencent.bugly.proguard.x.a("[ExtraCrashManager] no game agent", new java.lang.Object[0]);
        }
    }

    static /* synthetic */ void a(com.tencent.bugly.crashreport.crash.d dVar, java.lang.Thread thread, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        java.lang.String str4;
        java.lang.String str5;
        if (thread == null) {
            thread = java.lang.Thread.currentThread();
        }
        switch (i) {
            case 4:
                str4 = "Unity";
                break;
            case 5:
            case 6:
                str4 = "Cocos";
                break;
            case 7:
            default:
                com.tencent.bugly.proguard.x.d("[ExtraCrashManager] Unknown extra crash type: %d", java.lang.Integer.valueOf(i));
                return;
            case 8:
                str4 = "H5";
                break;
        }
        java.lang.String str6 = str4;
        com.tencent.bugly.proguard.x.e("[ExtraCrashManager] %s Crash Happen", str6);
        try {
            try {
                if (!dVar.b.b()) {
                    com.tencent.bugly.proguard.x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new java.lang.Object[0]);
                }
                com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = dVar.b.c();
                if (!strategyBeanC.g && dVar.b.b()) {
                    com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
                    com.tencent.bugly.crashreport.crash.b.a(str6, com.tencent.bugly.proguard.z.a(), dVar.c.d, thread.getName(), str + "\n" + str2 + "\n" + str3, null);
                    com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
                    return;
                }
                switch (i) {
                    case 5:
                    case 6:
                        if (!strategyBeanC.l) {
                            com.tencent.bugly.proguard.x.e("[ExtraCrashManager] %s report is disabled.", str6);
                            com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
                            return;
                        }
                        break;
                    case 8:
                        if (!strategyBeanC.m) {
                            com.tencent.bugly.proguard.x.e("[ExtraCrashManager] %s report is disabled.", str6);
                            com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
                            return;
                        }
                        break;
                }
                if (i == 8) {
                    i = 5;
                }
                com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.crashreport.crash.CrashDetailBean();
                crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
                crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
                crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
                crashDetailBean.F = dVar.c.p();
                crashDetailBean.G = dVar.c.o();
                crashDetailBean.H = dVar.c.q();
                crashDetailBean.w = com.tencent.bugly.proguard.z.a(dVar.e, com.tencent.bugly.crashreport.crash.c.e, (java.lang.String) null);
                crashDetailBean.b = i;
                crashDetailBean.e = dVar.c.h();
                crashDetailBean.f = dVar.c.j;
                crashDetailBean.g = dVar.c.w();
                crashDetailBean.m = dVar.c.g();
                crashDetailBean.n = str;
                crashDetailBean.o = str2;
                java.lang.String str7 = "";
                if (str3 != null) {
                    java.lang.String[] strArrSplit = str3.split("\n");
                    str7 = strArrSplit.length > 0 ? strArrSplit[0] : "";
                    str5 = str3;
                } else {
                    str5 = "";
                }
                crashDetailBean.p = str7;
                crashDetailBean.q = str5;
                crashDetailBean.r = java.lang.System.currentTimeMillis();
                crashDetailBean.u = com.tencent.bugly.proguard.z.b(crashDetailBean.q.getBytes());
                crashDetailBean.z = com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.c.f, false);
                crashDetailBean.A = dVar.c.d;
                crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
                crashDetailBean.I = dVar.c.y();
                crashDetailBean.h = dVar.c.v();
                crashDetailBean.M = dVar.c.f292a;
                crashDetailBean.N = dVar.c.a();
                crashDetailBean.P = dVar.c.H();
                crashDetailBean.Q = dVar.c.I();
                crashDetailBean.R = dVar.c.B();
                crashDetailBean.S = dVar.c.G();
                dVar.d.c(crashDetailBean);
                crashDetailBean.y = com.tencent.bugly.proguard.y.a();
                if (crashDetailBean.O == null) {
                    crashDetailBean.O = new java.util.LinkedHashMap();
                }
                if (map != null) {
                    crashDetailBean.O.putAll(map);
                }
                com.tencent.bugly.crashreport.crash.b.a(str6, com.tencent.bugly.proguard.z.a(), dVar.c.d, thread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
                if (!dVar.d.a(crashDetailBean)) {
                    dVar.d.a(crashDetailBean, 3000L, false);
                }
                com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
                    th.printStackTrace();
                }
                com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Successfully handled.", new java.lang.Object[0]);
            throw th2;
        }
    }

    public static void a(final java.lang.Thread thread, final int i, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.bugly.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.tencent.bugly.crashreport.crash.d.f313a == null) {
                        com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new java.lang.Object[0]);
                    } else {
                        com.tencent.bugly.crashreport.crash.d.a(com.tencent.bugly.crashreport.crash.d.f313a, thread, i, str, str2, str3, map);
                    }
                } catch (java.lang.Throwable th) {
                    if (!com.tencent.bugly.proguard.x.b(th)) {
                        th.printStackTrace();
                    }
                    com.tencent.bugly.proguard.x.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
