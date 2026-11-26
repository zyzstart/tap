package com.tencent.ydkbeacon.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatModule implements com.tencent.ydkbeacon.module.BeaconModule, com.tencent.ydkbeacon.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1267a;
    private com.tencent.ydkbeacon.d.b d;
    private boolean b = true;
    private boolean c = true;
    private long e = 0;

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.module.StatModule$4, reason: invalid class name */
    class AnonymousClass4 implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ java.util.Map f1271a;

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withCode("rqd_sensor").withParams(this.f1271a).build());
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.module.StatModule$5, reason: invalid class name */
    class AnonymousClass5 implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ java.util.Map f1272a;

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withCode("rqd_appresumed").withIsSucceed(true).withParams(this.f1272a).withType(com.tencent.ydkbeacon.event.open.EventType.REALTIME).build());
        }
    }

    private void c() {
        ((android.app.Application) this.f1267a).registerActivityLifecycleCallbacks(new com.tencent.ydkbeacon.c.a.d(this));
    }

    private void d() {
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        if (com.tencent.ydkbeacon.a.e.b.c().equals(aVarA.getString("rqd_model", ""))) {
            return;
        }
        com.tencent.ydkbeacon.a.b.a.a().a(50000L, new java.lang.Runnable() { // from class: com.tencent.ydkbeacon.module.StatModule.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
                com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withParams("A9", android.os.Build.BRAND).withParams("A10", android.os.Build.MODEL).withParams("A11", fVarP.h()).withParams("A12", fVarP.r()).withParams("A13", fVarP.G()).withParams("A14", fVarP.D() + "m").withParams("A15", fVarP.A() + "m").withParams("A16", fVarP.i()).withParams("A17", fVarP.B()).withParams("A18", "").withParams("A20", fVarP.J()).withParams("A22", fVarP.L()).withParams("A30", fVarP.E() + "m").withParams("A19", fVarP.w()).withParams("A52", "" + fVarP.F()).withParams("A53", "" + fVarP.f() + "m").withParams("A54", "" + fVarP.x()).withParams("A55", fVarP.g()).withParams("A56", fVarP.N() ? "Y" : "N").withParams("A57", fVarP.H()).withParams("A58", fVarP.q() ? "Y" : "N").withParams("A59", fVarP.l() + "m").withParams("A69", fVarP.K()).withParams("A82", fVarP.C()).withType(com.tencent.ydkbeacon.event.open.EventType.REALTIME).withCode("rqd_model").build());
            }
        });
        aVarA.edit().putString("rqd_model", com.tencent.ydkbeacon.a.e.b.c());
    }

    private void e() {
        if (this.d.g()) {
            if (com.tencent.ydkbeacon.a.e.b.c().equals(com.tencent.ydkbeacon.a.d.a.a().getString("LAUEVE_DENGTA", ""))) {
                com.tencent.ydkbeacon.a.e.c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new java.lang.Object[0]);
                return;
            }
        }
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        java.util.HashMap map = new java.util.HashMap();
        map.put("A19", fVarP.w());
        map.put("A133", fVarP.d());
        map.put("A63", "Y");
        map.put("A21", com.tencent.ydkbeacon.a.c.b.g() ? "Y" : "N");
        map.put("A45", com.tencent.ydkbeacon.a.c.b.d(this.f1267a) ? "Y" : "N");
        map.put("A66", com.tencent.ydkbeacon.a.c.b.e(this.f1267a) ? "F" : "B");
        map.put("A68", "" + com.tencent.ydkbeacon.a.c.b.b(this.f1267a));
        map.put("A85", com.tencent.ydkbeacon.a.c.b.f ? "Y" : "N");
        map.put("A9", android.os.Build.BRAND);
        map.put("A14", fVarP.D());
        map.put("A20", fVarP.J());
        map.put("A69", fVarP.K());
        if (a(map)) {
            com.tencent.ydkbeacon.a.d.a.a().edit().putString("LAUEVE_DENGTA", com.tencent.ydkbeacon.a.e.b.c());
        }
    }

    public void a() {
    }

    @Override // com.tencent.ydkbeacon.module.BeaconModule
    public void a(android.content.Context context) {
        this.f1267a = context;
        if (!com.tencent.ydkbeacon.a.c.b.g(context)) {
            com.tencent.ydkbeacon.a.e.c.a("non-main process. do not report rqd event", new java.lang.Object[0]);
            return;
        }
        com.tencent.ydkbeacon.d.b bVarB = ((com.tencent.ydkbeacon.module.StrategyModule) com.tencent.ydkbeacon.module.BeaconModule.f1265a.get(com.tencent.ydkbeacon.module.ModuleName.STRATEGY)).b();
        this.d = bVarB;
        this.c = bVarB.i();
        ((android.app.Application) this.f1267a).registerActivityLifecycleCallbacks(new com.tencent.ydkbeacon.c.a.c(this));
        com.tencent.ydkbeacon.a.a.b.a().a(2, this);
        com.tencent.ydkbeacon.a.a.b.a().a(10, this);
    }

    public void a(final java.lang.String str, final long j, final long j2) {
        com.tencent.ydkbeacon.a.b.a.a().a(new java.lang.Runnable() { // from class: com.tencent.ydkbeacon.module.StatModule.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withParams("A110", java.lang.String.valueOf(j2)).withParams("A111", str).withParams("A112", java.lang.String.valueOf(j)).withCode("rqd_page_fgt").withType(com.tencent.ydkbeacon.event.open.EventType.REALTIME).build());
            }
        });
    }

    public boolean a(java.util.Map map) {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withCode("rqd_applaunched").withParams(map).withType(com.tencent.ydkbeacon.event.open.EventType.REALTIME).build()).isSuccess();
    }

    public void b() {
    }

    public void b(final java.lang.String str, final long j, final long j2) {
        com.tencent.ydkbeacon.a.b.a.a().a(new java.lang.Runnable() { // from class: com.tencent.ydkbeacon.module.StatModule.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withParams("A110", java.lang.String.valueOf(j2)).withParams("A111", str).withParams("A112", java.lang.String.valueOf(j)).withCode("rqd_page").withType(com.tencent.ydkbeacon.event.open.EventType.NORMAL).build());
                com.tencent.ydkbeacon.module.StatModule.this.e += j;
                if (com.tencent.ydkbeacon.module.StatModule.this.e >= 15000) {
                    com.tencent.ydkbeacon.module.StatModule.this.e = 0L;
                }
            }
        });
    }

    public boolean b(java.util.Map map) {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withParams(map).withCode("rqd_heartbeat").withType(com.tencent.ydkbeacon.event.open.EventType.REALTIME).build()).isSuccess();
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        int i = cVar.f1177a;
        if (i == 2) {
            java.util.Map map = (java.util.Map) cVar.b.get("d_m");
            if (map != null) {
                this.b = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("modelEventUsable"), this.b);
                this.c = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("isPagePath"), this.c);
                return;
            }
            return;
        }
        if (i != 10) {
            return;
        }
        e();
        if (com.tencent.ydkbeacon.a.c.b.g(this.f1267a)) {
            new com.tencent.ydkbeacon.c.c(this.f1267a).a(this.d);
        }
        if (this.b) {
            d();
        }
        if (this.c) {
            c();
        }
    }
}
