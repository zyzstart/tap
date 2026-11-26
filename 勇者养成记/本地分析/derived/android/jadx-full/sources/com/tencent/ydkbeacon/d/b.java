package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.ydkbeacon.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.d.b f1239a;
    protected int b = 48;
    protected int c = 2000;
    protected int d = 48;
    protected int e = 3000;
    protected boolean f = true;
    protected boolean g = true;
    protected java.util.Set h = null;
    protected java.util.Map i = null;
    protected boolean j = false;
    protected boolean k = false;
    protected boolean l = false;
    protected float m = 1.0f;
    protected boolean n = false;
    protected boolean o = false;
    protected boolean p = false;
    protected int q = 1;
    protected long r = 6400;
    protected int s = 20;
    protected int t = 300;
    protected boolean u = true;
    protected boolean v = true;
    protected boolean w = true;
    protected boolean x = true;
    protected boolean y = true;
    protected boolean z = true;
    protected int A = 10000;
    protected boolean B = false;
    protected int C = 1;

    protected b() {
        com.tencent.ydkbeacon.a.a.b.a().a(8, this);
    }

    public static com.tencent.ydkbeacon.d.b a() {
        if (f1239a == null) {
            synchronized (com.tencent.ydkbeacon.d.b.class) {
                if (f1239a == null) {
                    f1239a = new com.tencent.ydkbeacon.d.b();
                }
            }
        }
        return f1239a;
    }

    private void b(java.util.Map map) {
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("d_m", new java.util.HashMap(map));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(2, map2));
    }

    public synchronized void a(java.util.Map map) {
        if (map != null) {
            b(map);
            try {
                this.b = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("realtimeUploadNum"), this.b, 5, 15);
                this.c = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("realtimePollingTime"), this.c, 1000, 10000);
                this.e = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("normalPollingTime"), this.e, 2000, 15000);
                this.d = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("normalUploadNum"), this.d, 1, 15);
                this.g = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("heartOnOff"), this.g);
                this.j = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("tidyEF"), this.j);
                this.k = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("lauEveSim"), this.k);
                this.l = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("zeroPeakOnOff"), this.l);
                java.lang.String str = (java.lang.String) map.get("zeroPeakRate");
                if (str != null) {
                    java.lang.String strTrim = str.trim();
                    if (strTrim.length() > 0) {
                        java.lang.String[] strArrSplit = strTrim.split(",");
                        if (strArrSplit.length == 2) {
                            try {
                                this.m = java.lang.Float.valueOf(strArrSplit[0]).floatValue() / java.lang.Float.valueOf(strArrSplit[1]).floatValue();
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    }
                }
                this.B = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("straOnOff"), this.B);
                this.C = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("straDayMaxCount"), this.C, 1, android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.n = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("acceleEnable"), this.n);
                this.o = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("gyroEnable"), this.o);
                this.p = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("magneticEnable"), this.p);
                this.q = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("gatherCount"), this.q, 1, 50);
                this.r = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("gatherDur"), this.r, 1000L, 20000L);
                this.s = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("hertzCount"), this.s, 20, 100);
                this.t = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("consuming"), this.t, 60, 86400);
                this.u = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("bidEnable"), this.u);
                this.v = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("auditEnable"), this.v);
                this.A = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("maxDBCount"), this.A, 10000, 100000);
                com.tencent.ydkbeacon.base.net.c.b.c((java.lang.String) map.get("eventUrl"));
                com.tencent.ydkbeacon.base.net.c.b.e((java.lang.String) map.get("strategyUrl"));
            } catch (java.lang.Exception e) {
                com.tencent.ydkbeacon.a.e.c.a(e);
            }
        }
    }

    public synchronized void a(java.util.Set set) {
        this.h = set;
    }

    public synchronized boolean a(java.lang.String str) {
        boolean zContains;
        zContains = false;
        java.util.Set set = this.h;
        if (set != null && set.size() > 0) {
            zContains = this.h.contains(str);
        }
        return zContains;
    }

    public int b() {
        return this.A;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(java.util.Set set) {
        if (this.i == null) {
            this.i = new java.util.HashMap();
        }
        if (set == null) {
            return;
        }
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            java.lang.String[] strArrSplit = ((java.lang.String) it.next()).split(",");
            if (strArrSplit.length == 3) {
                try {
                    this.i.put(strArrSplit[0].toLowerCase(), java.lang.Float.valueOf(java.lang.Float.valueOf(strArrSplit[1]).floatValue() / java.lang.Float.valueOf(strArrSplit[2]).floatValue()));
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public synchronized boolean b(java.lang.String str) {
        java.util.Map map = this.i;
        if (map != null && map.get(str.toLowerCase()) != null) {
            return new java.util.Random().nextInt(1000) + 1 <= ((int) (((java.lang.Float) this.i.get(str.toLowerCase())).floatValue() * 1000.0f));
        }
        return true;
    }

    public synchronized int c() {
        return this.C;
    }

    public boolean d() {
        return this.y;
    }

    public boolean e() {
        return this.u;
    }

    public boolean f() {
        return this.x;
    }

    public synchronized boolean g() {
        return this.k;
    }

    public boolean h() {
        return this.w;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.z;
    }

    public synchronized boolean k() {
        return this.B;
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        if (cVar.f1177a != 8) {
            return;
        }
        this.v = cVar.b.containsKey("u_c_a_e") ? ((java.lang.Boolean) cVar.b.get("u_c_a_e")).booleanValue() : this.v;
        this.u = cVar.b.containsKey("u_c_b_e") ? ((java.lang.Boolean) cVar.b.get("u_c_b_e")).booleanValue() : this.u;
        this.w = cVar.b.containsKey("u_c_m_e") ? ((java.lang.Boolean) cVar.b.get("u_c_m_e")).booleanValue() : this.w;
        this.x = cVar.b.containsKey("u_c_i_e") ? ((java.lang.Boolean) cVar.b.get("u_c_i_e")).booleanValue() : this.x;
        this.A = cVar.b.containsKey("u_c_d_s") ? ((java.lang.Integer) cVar.b.get("u_c_d_s")).intValue() : this.A;
        this.f = cVar.b.containsKey("u_c_p_s") ? ((java.lang.Boolean) cVar.b.get("u_c_p_s")).booleanValue() : this.f;
        this.y = cVar.b.containsKey("u_c_a_i_e") ? ((java.lang.Boolean) cVar.b.get("u_c_a_i_e")).booleanValue() : this.y;
        this.z = cVar.b.containsKey("u_c_p_i_e") ? ((java.lang.Boolean) cVar.b.get("u_c_p_i_e")).booleanValue() : this.z;
    }
}
