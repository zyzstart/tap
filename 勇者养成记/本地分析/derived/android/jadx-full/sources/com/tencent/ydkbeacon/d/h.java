package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h implements java.lang.Runnable, com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1244a = false;
    private final android.content.Context b = com.tencent.ydkbeacon.a.c.c.d().c();
    private final com.tencent.ydkbeacon.module.StrategyModule c;
    private boolean d;

    public h(com.tencent.ydkbeacon.module.StrategyModule strategyModule) {
        this.c = strategyModule;
    }

    private void a(com.tencent.ydkbeacon.d.d dVar, com.tencent.ydkbeacon.d.b bVar, com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy) {
        if (moduleStrategy.detail != null) {
            com.tencent.ydkbeacon.a.e.c.a("[strategy] mid: %d , detail changed...", java.lang.Byte.valueOf(moduleStrategy.mId));
            dVar.a(moduleStrategy.detail);
            bVar.a(moduleStrategy.detail);
            this.d = true;
        }
    }

    private void a(com.tencent.ydkbeacon.d.d dVar, com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy) {
        boolean z = moduleStrategy.onOff == 1;
        if (dVar.c() != z) {
            com.tencent.ydkbeacon.a.e.c.a("[strategy] mid: %d , isUsable changed: %b ", java.lang.Byte.valueOf(moduleStrategy.mId), java.lang.Boolean.valueOf(z));
            dVar.a(z);
            this.d = true;
        }
    }

    private void a(com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy) {
        java.lang.String strA = com.tencent.ydkbeacon.base.net.c.b.a(moduleStrategy.url);
        if (com.tencent.ydkbeacon.base.net.c.b.a(true).equals(strA)) {
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a("[strategy] mid: %d , url changed: %s", java.lang.Byte.valueOf(moduleStrategy.mId), moduleStrategy.url);
        com.tencent.ydkbeacon.base.net.c.b.b(strA);
        this.d = true;
    }

    private boolean a(java.util.Map map, com.tencent.ydkbeacon.d.a aVar) {
        if (aVar == null || map == null) {
            return false;
        }
        aVar.a(map);
        return true;
    }

    private void b(com.tencent.ydkbeacon.d.d dVar, com.tencent.ydkbeacon.d.b bVar, com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy) {
        java.util.ArrayList arrayList = moduleStrategy.preventEventCode;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a("[strategy] mid: %d , PreventEventCode changed...", java.lang.Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        dVar.a(com.tencent.ydkbeacon.a.e.b.a(moduleStrategy.preventEventCode));
        bVar.a(com.tencent.ydkbeacon.a.e.b.a(moduleStrategy.preventEventCode));
    }

    private void c() {
        f();
        this.f1244a = false;
    }

    private void c(com.tencent.ydkbeacon.d.d dVar, com.tencent.ydkbeacon.d.b bVar, com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy) {
        java.util.ArrayList arrayList = moduleStrategy.sampleEvent;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a("[strategy] mid: %d , SampleEventSet changed...", java.lang.Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        dVar.b(com.tencent.ydkbeacon.a.e.b.a(moduleStrategy.sampleEvent));
        bVar.b(com.tencent.ydkbeacon.a.e.b.a(moduleStrategy.sampleEvent));
    }

    private void d() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("s_e_e", java.lang.Boolean.FALSE);
        com.tencent.ydkbeacon.a.a.b.a().a(new com.tencent.ydkbeacon.a.a.c(7, map));
    }

    private void e() {
        com.tencent.ydkbeacon.a.e.c.a("local strategyQuery finish!", new java.lang.Object[0]);
        com.tencent.ydkbeacon.a.a.b.a().a(new com.tencent.ydkbeacon.a.a.c(10));
    }

    private void f() {
        long jB = ((long) this.c.a().b()) * 60000;
        com.tencent.ydkbeacon.a.b.a.a().a(jB, this);
        com.tencent.ydkbeacon.a.e.c.a("[strategy] next time: %d", java.lang.Long.valueOf(jB));
    }

    private void g() {
        if (com.tencent.ydkbeacon.d.j.b() || com.tencent.ydkbeacon.d.j.c()) {
            com.tencent.ydkbeacon.a.e.c.e("[strategy] query times or query success times arrive max, return!", new java.lang.Object[0]);
            this.c.a(true);
        } else {
            com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
            com.tencent.ydkbeacon.base.net.d.c().a(com.tencent.ydkbeacon.base.net.a.k.a().a(com.tencent.ydkbeacon.base.net.RequestType.STRATEGY).a(100).b(101).a(com.tencent.ydkbeacon.a.c.c.d().f()).b(com.tencent.ydkbeacon.base.net.c.b.b(false)).a(com.tencent.ydkbeacon.base.net.c.b.b(true), 8081).b("A1", com.tencent.ydkbeacon.a.c.c.d().k()).b("A2", fVarP.m()).b("A4", fVarP.o()).b("A6", fVarP.s()).b("A7", fVarP.e()).b("A23", com.tencent.ydkbeacon.a.c.c.d().a()).b("A31", fVarP.v()).b("A19", fVarP.w()).b("A66", com.tencent.ydkbeacon.a.c.b.e(this.b) ? "F" : "B").b("A67", com.tencent.ydkbeacon.a.c.b.c(this.b)).b("A68", java.lang.String.valueOf(com.tencent.ydkbeacon.a.c.b.b(this.b))).b("A85", com.tencent.ydkbeacon.a.c.b.f ? "Y" : "N").a(com.tencent.ydkbeacon.qimei.a.a().b().getQimeiMap()).a()).b(this);
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        c();
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(byte[] bArr) {
        a(bArr, true);
        this.c.a(true);
        c();
    }

    public void a(byte[] bArr, boolean z) {
        try {
            com.tencent.ydkbeacon.pack.CommonStrategy commonStrategy = new com.tencent.ydkbeacon.pack.CommonStrategy();
            commonStrategy.readFrom(new com.tencent.ydkbeacon.pack.a(bArr));
            com.tencent.ydkbeacon.a.e.c.a("[strategy] -> common strategy: %s", commonStrategy);
            if (a(commonStrategy, com.tencent.ydkbeacon.d.a.a()) && z) {
                com.tencent.ydkbeacon.a.d.a.a().edit().putString("strategy_data", android.util.Base64.encodeToString(bArr, 0));
            }
            if (z) {
                com.tencent.ydkbeacon.d.j.d();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.e.c.b("[strategy] error to common strategy!", new java.lang.Object[0]);
        }
    }

    public boolean a() {
        return this.f1244a;
    }

    protected boolean a(com.tencent.ydkbeacon.pack.CommonStrategy commonStrategy, com.tencent.ydkbeacon.d.a aVar) {
        if (commonStrategy == null || aVar == null) {
            return false;
        }
        java.lang.String strA = com.tencent.ydkbeacon.base.net.c.b.a(commonStrategy.url);
        if (!strA.equals(com.tencent.ydkbeacon.base.net.c.b.b(true))) {
            com.tencent.ydkbeacon.a.e.c.a("[strategy] url changed to: %s", commonStrategy.url);
            this.d = true;
            com.tencent.ydkbeacon.base.net.c.b.d(strA);
        }
        if (commonStrategy.queryInterval != aVar.b()) {
            com.tencent.ydkbeacon.a.e.c.a("[strategy] QueryPeriod changed to: %d", java.lang.Integer.valueOf(commonStrategy.queryInterval));
            this.d = true;
            aVar.a(commonStrategy.queryInterval);
        }
        if (a(commonStrategy.moduleList)) {
            this.d = true;
        }
        if (a(commonStrategy.cloudParas, aVar)) {
            this.d = true;
        }
        return this.d;
    }

    boolean a(java.util.ArrayList arrayList) {
        com.tencent.ydkbeacon.d.d dVarD = this.c.a().d();
        if (arrayList == null) {
            dVarD.a(false);
            d();
            return false;
        }
        com.tencent.ydkbeacon.d.b bVarB = this.c.b();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.ydkbeacon.pack.ModuleStrategy moduleStrategy = (com.tencent.ydkbeacon.pack.ModuleStrategy) it.next();
            if (moduleStrategy.mId == dVarD.b()) {
                a(dVarD, moduleStrategy);
                a(moduleStrategy);
                a(dVarD, bVarB, moduleStrategy);
                b(dVarD, bVarB, moduleStrategy);
                c(dVarD, bVarB, moduleStrategy);
            }
        }
        return this.d;
    }

    public void b() {
        byte[] bArrDecode;
        try {
            try {
                java.lang.String string = com.tencent.ydkbeacon.a.d.a.a().getString("strategy_data", "");
                if (android.text.TextUtils.isEmpty(string)) {
                    com.tencent.ydkbeacon.d.i iVarA = com.tencent.ydkbeacon.d.j.a(this.b, 101);
                    bArrDecode = iVarA != null ? iVarA.c : null;
                } else {
                    bArrDecode = android.util.Base64.decode(string, 0);
                }
                if (bArrDecode != null) {
                    a(bArrDecode, false);
                } else {
                    com.tencent.ydkbeacon.a.e.c.a("[strategy] local strategy is null!", new java.lang.Object[0]);
                }
            } catch (java.lang.Exception e) {
                com.tencent.ydkbeacon.a.e.c.a(e);
            }
        } finally {
            e();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1244a = true;
        if (this.c.a().e()) {
            return;
        }
        g();
    }
}
