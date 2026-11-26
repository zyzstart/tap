package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.beacon.core.event.RDBean f173a;
    protected final android.content.Context b;
    private final boolean c;
    private boolean d;
    private int e = cn.yunzhisheng.asr.a.b;
    private int f = 0;
    protected java.lang.Runnable g = new com.tencent.beacon.core.event.l(this);

    public m(android.content.Context context) {
        this.d = false;
        this.b = context;
        this.c = com.tencent.beacon.core.info.a.h(context);
        this.d = com.tencent.beacon.core.info.a.e;
    }

    public static void a(android.content.Context context) {
        com.tencent.beacon.core.a.d.a().a(108, true);
        com.tencent.beacon.core.a.f.a(context).b().a("HEART_DENGTA", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
        com.tencent.beacon.core.e.d.d("[event] heartbeat uploaded success!", new java.lang.Object[0]);
    }

    private java.util.Map d() {
        java.lang.String str;
        java.lang.String str2;
        java.util.HashMap map = new java.util.HashMap(4);
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(this.b);
        map.put("A33", eVarD.k(this.b));
        if (this.c) {
            str = "A66";
            str2 = "F";
        } else {
            str = "A66";
            str2 = "B";
        }
        map.put(str, str2);
        map.put("A68", "" + com.tencent.beacon.core.info.a.b(this.b));
        map.put("A85", this.d ? "Y" : "N");
        map.put("A20", eVarD.p(this.b));
        map.put("A69", eVarD.q(this.b));
        return map;
    }

    private void e() {
        java.util.Map mapD = d();
        android.content.Context context = this.b;
        this.f173a = com.tencent.beacon.core.event.s.a(context, com.tencent.beacon.core.info.b.b(context).a(), "rqd_heartbeat", true, 0L, 0L, mapD, true);
    }

    protected void a() {
        if (com.tencent.beacon.core.e.e.c(this.b)) {
            com.tencent.beacon.core.d.k kVarA = com.tencent.beacon.core.d.k.a(this.b);
            if (kVarA != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList(2);
                arrayList.add(this.f173a);
                java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.b).d().iterator();
                while (it.hasNext()) {
                    ((com.tencent.beacon.core.d.l) it.next()).incRealTimeEventCalls();
                }
                android.content.Context context = this.b;
                kVarA.a(new com.tencent.beacon.core.event.r(context, com.tencent.beacon.core.info.b.b(context).a(), arrayList));
            }
            a(b() + 1);
            if (b() % 10 == 0) {
                com.tencent.beacon.core.a.d.a().a(108, this.g, 600000L, this.e);
                a(0);
            }
            if (this.d) {
                com.tencent.beacon.core.a.f.a(this.b).b().a("active_user_date", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
            }
        }
    }

    public synchronized void a(int i) {
        this.f = i;
    }

    public void a(boolean z) {
        java.lang.String strA = com.tencent.beacon.core.e.b.a();
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.b);
        java.lang.String strA2 = fVarA.a("HEART_DENGTA", "");
        java.lang.String strA3 = fVarA.a("active_user_date", "");
        if (strA.equals(strA2) || strA3.equals(strA)) {
            com.tencent.beacon.core.e.d.i("[event] heartbeat had upload!", new java.lang.Object[0]);
            return;
        }
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        if (eventStrategyBean.isInPreventEventCode("rqd_heartbeat")) {
            com.tencent.beacon.core.e.d.i("[event] rqd_heartbeat not allowed in strategy!", new java.lang.Object[0]);
        } else if (!eventStrategyBean.isUploadByRate("rqd_heartbeat")) {
            com.tencent.beacon.core.e.d.i("[event] rqd_heartbeat is sampled by svr rate!", new java.lang.Object[0]);
        } else {
            e();
            com.tencent.beacon.core.a.d.a().a(108, this.g, z ? com.tencent.beacon.core.e.b.a(1800) * 1000 : 0, this.e);
        }
    }

    public synchronized int b() {
        return this.f;
    }

    public void c() {
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.b);
        if (com.tencent.beacon.core.e.b.a().equals(fVarA.a("active_user_date", ""))) {
            com.tencent.beacon.core.e.d.i("[event] active user event had upload.", new java.lang.Object[0]);
            return;
        }
        com.tencent.beacon.core.e.d.a("[event] recover a heart beat for active user.", new java.lang.Object[0]);
        if (com.tencent.beacon.event.UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, d(), true)) {
            fVarA.b().a("active_user_date", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
        }
    }
}
