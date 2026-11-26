package com.tencent.ydkbeacon.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class EventModule implements com.tencent.ydkbeacon.module.BeaconModule, com.tencent.ydkbeacon.a.a.d, com.tencent.ydkbeacon.base.net.c.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Map f1266a = new java.util.concurrent.ConcurrentHashMap(3);
    private static final java.util.Map b = new java.util.concurrent.ConcurrentHashMap(3);
    private final java.util.List c = new java.util.ArrayList(3);
    private java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    private boolean f = true;
    private com.tencent.ydkbeacon.module.StrategyModule g;
    private com.tencent.ydkbeacon.event.f h;
    private volatile boolean i;

    private java.lang.String c(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? com.tencent.ydkbeacon.a.c.c.d().f() : str;
    }

    private void e() {
        this.c.add(new com.tencent.ydkbeacon.event.b.b());
        this.c.add(new com.tencent.ydkbeacon.event.b.a());
        for (int i = 1; i < this.c.size(); i++) {
            ((com.tencent.ydkbeacon.event.b.c) this.c.get(i - 1)).a((com.tencent.ydkbeacon.event.b.c) this.c.get(i));
        }
    }

    private void f() {
        com.tencent.ydkbeacon.a.a.b.a().a(7, this);
        if (this.f) {
            com.tencent.ydkbeacon.event.b bVar = new com.tencent.ydkbeacon.event.b();
            this.h = bVar;
            bVar.a();
        }
    }

    private void g() {
        com.tencent.ydkbeacon.a.a.b.a().a(3, this);
        com.tencent.ydkbeacon.a.a.b.a().a(4, this);
        com.tencent.ydkbeacon.a.a.b.a().a(6, this);
        com.tencent.ydkbeacon.a.a.b.a().a(1, this);
    }

    public com.tencent.ydkbeacon.event.open.EventResult a(@android.support.annotation.NonNull com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        com.tencent.ydkbeacon.module.StrategyModule strategyModule;
        com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 0, "event: %s. go in EventModule", beaconEvent.getCode());
        if (!this.f) {
            com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 1, "event: %s. EventModule is not enable", beaconEvent.getCode());
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(102);
        }
        com.tencent.ydkbeacon.a.e.e.a(beaconEvent.getParams());
        com.tencent.ydkbeacon.module.StrategyModule strategyModule2 = this.g;
        if (strategyModule2 != null && strategyModule2.b().a(beaconEvent.getCode())) {
            com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 1, "event: %s.  is not allowed in strategy (false)", beaconEvent.getCode());
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(100);
        }
        if (beaconEvent.isSucceed() && (strategyModule = this.g) != null && !strategyModule.b().b(beaconEvent.getCode())) {
            com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 1, "event: %s. is sampled by svr rate (false)", beaconEvent.getCode());
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(101);
        }
        beaconEvent.setAppKey(c(beaconEvent.getAppKey()));
        com.tencent.ydkbeacon.event.EventBean eventBeanB = ((com.tencent.ydkbeacon.event.b.c) this.c.get(0)).b(beaconEvent);
        if (eventBeanB == null) {
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(105);
        }
        com.tencent.ydkbeacon.qimei.Qimei qimeiB = com.tencent.ydkbeacon.qimei.a.a().b();
        if (qimeiB == null || qimeiB.isEmpty()) {
            if (this.d.addAndGet(1) > 64) {
                java.lang.String str = java.lang.String.format("[REDACTED]", beaconEvent.getAppKey(), beaconEvent.getCode());
                com.tencent.ydkbeacon.a.e.c.a(str, new java.lang.Object[0]);
                if (this.e.compareAndSet(false, true)) {
                    com.tencent.ydkbeacon.a.b.d.b().a("510", str);
                }
            } else {
                com.tencent.ydkbeacon.a.e.c.a("[REDACTED]", beaconEvent.getAppKey(), beaconEvent.getCode());
                com.tencent.ydkbeacon.event.open.BeaconEvent beaconEventBuild = com.tencent.ydkbeacon.event.open.BeaconEvent.newBuilder(beaconEvent).build();
                java.util.HashMap map = new java.util.HashMap();
                map.put("e_q_e_k", beaconEventBuild);
                com.tencent.ydkbeacon.a.a.b.a().a(new com.tencent.ydkbeacon.a.a.c(12, map));
            }
        }
        return this.h.a((java.lang.String) beaconEvent.getParams().get("A100"), eventBeanB);
    }

    public java.util.Map a(java.lang.String str) {
        return (java.util.Map) f1266a.get(c(str));
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void a() {
        this.h.b();
    }

    @Override // com.tencent.ydkbeacon.module.BeaconModule
    public void a(android.content.Context context) {
        this.g = (com.tencent.ydkbeacon.module.StrategyModule) com.tencent.ydkbeacon.module.BeaconModule.f1265a.get(com.tencent.ydkbeacon.module.ModuleName.STRATEGY);
        e();
        f();
        g();
        com.tencent.ydkbeacon.base.net.c.e.a(context, this);
        this.i = true;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        b.put(c(str), com.tencent.ydkbeacon.event.c.c.d(str2));
    }

    public void a(java.lang.String str, java.util.Map map) {
        if (map == null || map.isEmpty() || map.size() >= 50) {
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = java.lang.Integer.valueOf(map == null ? 0 : map.size());
            com.tencent.ydkbeacon.a.e.c.a("setAdditionalParams error , params.size: %s", objArr);
            return;
        }
        java.lang.String strC = c(str);
        java.util.Map map2 = (java.util.Map) f1266a.get(strC);
        if (map2 == null) {
            f1266a.put(strC, new java.util.HashMap(map));
            return;
        }
        if (map2.size() + map.size() >= 50) {
            com.tencent.ydkbeacon.a.e.c.a("setAdditionalParams error , params.size: can not more than 50", new java.lang.Object[0]);
            return;
        }
        java.util.HashMap map3 = new java.util.HashMap();
        map3.putAll(map2);
        map3.putAll(map);
        f1266a.put(strC, map3);
    }

    public void a(boolean z) {
        com.tencent.ydkbeacon.event.f fVar = this.h;
        if (fVar != null) {
            fVar.a(z);
        }
    }

    @android.support.annotation.NonNull
    public java.lang.String b(java.lang.String str) {
        java.lang.String str2;
        java.lang.String strC = c(str);
        return (android.text.TextUtils.isEmpty(strC) || (str2 = (java.lang.String) b.get(strC)) == null) ? "10000" : str2;
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void b() {
        this.h.c();
    }

    public void b(boolean z) {
        this.f = z;
    }

    public com.tencent.ydkbeacon.event.f c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent;
        int i = cVar.f1177a;
        if (i == 1) {
            com.tencent.ydkbeacon.a.a.b.a().a(12, this);
            return;
        }
        if (i == 12) {
            java.lang.Object obj = cVar.b.get("e_q_e_k");
            if (!(obj instanceof com.tencent.ydkbeacon.event.open.BeaconEvent)) {
                return;
            }
            beaconEvent = (com.tencent.ydkbeacon.event.open.BeaconEvent) obj;
            beaconEvent.getParams().put("A93", "Y");
            com.tencent.ydkbeacon.a.e.c.a("[REDACTED]", beaconEvent.getAppKey(), beaconEvent.getCode());
        } else {
            if (i == 3) {
                a((java.lang.String) cVar.b.get("i_c_ak"), (java.util.HashMap) cVar.b.get("i_c_ad"));
                return;
            }
            if (i == 4) {
                a((java.lang.String) cVar.b.get("i_c_ak"), (java.lang.String) cVar.b.get("i_c_u_i"));
                return;
            }
            if (i != 6) {
                if (i != 7) {
                    return;
                }
                this.f = ((java.lang.Boolean) cVar.b.get("s_e_e")).booleanValue();
                return;
            } else {
                java.lang.Object obj2 = cVar.b.get("b_e");
                if (!(obj2 instanceof com.tencent.ydkbeacon.event.open.BeaconEvent)) {
                    return;
                } else {
                    beaconEvent = (com.tencent.ydkbeacon.event.open.BeaconEvent) obj2;
                }
            }
        }
        a(beaconEvent);
    }
}
