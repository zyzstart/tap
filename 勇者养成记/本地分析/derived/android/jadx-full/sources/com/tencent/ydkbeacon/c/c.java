package com.tencent.ydkbeacon.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final android.content.Context f1237a;
    private final boolean b;
    private boolean c = false;

    public c(android.content.Context context) {
        this.f1237a = context;
        this.b = com.tencent.ydkbeacon.a.c.b.e(context);
    }

    private java.util.Map b() {
        this.c = com.tencent.ydkbeacon.a.c.b.f;
        java.util.HashMap map = new java.util.HashMap(8);
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        map.put("A19", fVarP.w());
        map.put("A66", com.tencent.ydkbeacon.a.c.b.e(this.f1237a) ? "F" : "B");
        map.put("A68", "" + com.tencent.ydkbeacon.a.c.b.b(this.f1237a));
        map.put("A85", this.c ? "Y" : "N");
        map.put("A20", fVarP.J());
        map.put("A69", fVarP.K());
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return ((com.tencent.ydkbeacon.module.StatModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.STAT)).b(b());
    }

    public void a() {
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        if (com.tencent.ydkbeacon.a.e.b.c().equals(aVarA.getString("active_user_date", ""))) {
            com.tencent.ydkbeacon.a.e.c.e("[event] active user event had upload.", new java.lang.Object[0]);
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a("[event] recover a heart beat for active user.", new java.lang.Object[0]);
        if (c()) {
            com.tencent.ydkbeacon.a.e.c.a("[event] rqd_heartbeat A85=Y report success", new java.lang.Object[0]);
            aVarA.edit().putString("active_user_date", com.tencent.ydkbeacon.a.e.b.c()).apply();
        }
    }

    public void a(com.tencent.ydkbeacon.d.b bVar) {
        java.lang.String strC = com.tencent.ydkbeacon.a.e.b.c();
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        java.lang.String string = aVarA.getString("HEART_DENGTA", "");
        java.lang.String string2 = aVarA.getString("active_user_date", "");
        if (strC.equals(string) || string2.equals(strC)) {
            com.tencent.ydkbeacon.a.e.c.e("[event] heartbeat had upload!", new java.lang.Object[0]);
            return;
        }
        if (bVar.a("rqd_heartbeat")) {
            com.tencent.ydkbeacon.a.e.c.e("[event] rqd_heartbeat not allowed in strategy!", new java.lang.Object[0]);
        } else if (bVar.b("rqd_heartbeat")) {
            com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.c.b(this, strC, aVarA));
        } else {
            com.tencent.ydkbeacon.a.e.c.e("[event] rqd_heartbeat is sampled by svr rate!", new java.lang.Object[0]);
        }
    }
}
