package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j extends java.util.Observable implements com.tencent.beaconselfupdate.a.b.a, com.tencent.beaconselfupdate.a.b.e, com.tencent.beaconselfupdate.a.b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.event.j f266a;
    private com.tencent.beaconselfupdate.event.e b;
    private com.tencent.beaconselfupdate.event.g c;
    private com.tencent.beaconselfupdate.event.g d;
    private boolean e;
    private android.content.Context g;
    private com.tencent.beaconselfupdate.upload.f h;
    private boolean i;
    private java.util.List k;
    private com.tencent.beaconselfupdate.a.g m;
    private boolean f = false;
    private int j = 0;
    private java.lang.Object l = new java.lang.Object();

    private j(android.content.Context context, com.tencent.beaconselfupdate.upload.f fVar, com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = true;
        this.k = null;
        this.m = null;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.c(" the context is null! init UserActionRecord failed!", new java.lang.Object[0]);
            this.g = null;
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.g = applicationContext;
        } else {
            this.g = context;
        }
        if (com.tencent.beaconselfupdate.a.c.m() == null) {
            com.tencent.beaconselfupdate.a.c.a(this.g);
        }
        if (this.k == null) {
            this.k = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
        }
        this.h = fVar;
        if (fVar != null) {
            fVar.a(uploadHandleListener);
        }
        com.tencent.beaconselfupdate.a.b.b bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.g);
        bVarA.a((com.tencent.beaconselfupdate.a.b.a) this);
        bVarA.a((com.tencent.beaconselfupdate.a.b.e) this);
        bVarA.a((com.tencent.beaconselfupdate.a.b.f) this);
        bVarA.a(0, fVar);
        bVarA.a(1, fVar);
        this.b = new com.tencent.beaconselfupdate.event.e();
        this.c = new com.tencent.beaconselfupdate.event.a(context);
        this.d = new com.tencent.beaconselfupdate.event.i(context);
        this.e = true;
        new com.tencent.beaconselfupdate.a.d().a(this.g);
        this.m = new com.tencent.beaconselfupdate.a.g();
    }

    public static synchronized com.tencent.beaconselfupdate.event.j a(android.content.Context context, com.tencent.beaconselfupdate.upload.f fVar, com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener) {
        if (f266a == null) {
            com.tencent.beaconselfupdate.c.a.e(" create ua instance ", new java.lang.Object[0]);
            f266a = new com.tencent.beaconselfupdate.event.j(context, fVar, uploadHandleListener);
        }
        com.tencent.beaconselfupdate.c.a.e(" return ua instance ", new java.lang.Object[0]);
        return f266a;
    }

    public static synchronized com.tencent.beaconselfupdate.upload.f a(android.content.Context context, boolean z) {
        return com.tencent.beaconselfupdate.upload.g.a(context, z);
    }

    private synchronized void a(int i) {
        this.j = i;
    }

    public static boolean a(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        com.tencent.beaconselfupdate.c.a.e(" onUA: %s,%b,%d,%d,%b,%b", str, java.lang.Boolean.valueOf(z), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(z3));
        com.tencent.beaconselfupdate.event.j jVarD = d();
        if (jVarD != null && !jVarD.m()) {
            jVarD.k.add(new com.tencent.beaconselfupdate.event.d(str, z, j, j2, map, z2));
            return true;
        }
        if (!i()) {
            return false;
        }
        if (jVarD.b.a(str)) {
            objArr = new java.lang.Object[]{str};
            str2 = "onUserAction return false, because eventName:[%s] is not allowed in server strategy!";
        } else if (!z || (z && jVarD.b.b(str))) {
            com.tencent.beaconselfupdate.event.g gVarK = z2 ? jVarD.k() : jVarD.j();
            if (gVarK == null) {
                return false;
            }
            com.tencent.beaconselfupdate.event.h hVarA = com.tencent.beaconselfupdate.a.e.a(jVarD.g, str, z, j, j2, map, z3);
            if (hVarA != null) {
                return gVarK.a(hVarA);
            }
            objArr = new java.lang.Object[0];
            str2 = "createdRecordBean bean is null, return false!";
        } else {
            objArr = new java.lang.Object[]{str};
            str2 = "onUserAction return false, because eventName:[%s] is sampled by svr rate!";
        }
        com.tencent.beaconselfupdate.c.a.c(str2, objArr);
        return false;
    }

    public static void c(boolean z) {
        com.tencent.beaconselfupdate.event.j jVarD = d();
        if (jVarD != null) {
            com.tencent.beaconselfupdate.event.g gVarJ = jVarD.j();
            if (gVarJ != null) {
                gVarJ.b(z);
            }
            com.tencent.beaconselfupdate.event.g gVarK = jVarD.k();
            if (gVarK != null) {
                gVarK.b(z);
            }
        }
    }

    public static synchronized com.tencent.beaconselfupdate.event.j d() {
        return f266a;
    }

    public static boolean d(boolean z) {
        com.tencent.beaconselfupdate.event.j jVarD = d();
        if (jVarD == null) {
            com.tencent.beaconselfupdate.c.a.c(" ua module not ready!", new java.lang.Object[0]);
            return false;
        }
        if (i()) {
            return jVarD.e(z);
        }
        return false;
    }

    private synchronized void f(boolean z) {
        if (z != e()) {
            com.tencent.beaconselfupdate.event.g gVarJ = j();
            if (gVarJ != null) {
                gVarJ.a(z);
            }
            com.tencent.beaconselfupdate.event.g gVarK = k();
            if (gVarK != null) {
                gVarK.a(z);
            }
            this.i = z;
        }
    }

    private static boolean i() {
        com.tencent.beaconselfupdate.event.j jVarD = d();
        if (jVarD == null) {
            com.tencent.beaconselfupdate.c.a.d("isModuleAble:not init ua", new java.lang.Object[0]);
            return false;
        }
        boolean zE = jVarD.e();
        return (zE && jVarD.l()) ? jVarD.m() : zE;
    }

    private synchronized com.tencent.beaconselfupdate.event.g j() {
        return this.c;
    }

    private synchronized com.tencent.beaconselfupdate.event.g k() {
        return this.d;
    }

    private synchronized boolean l() {
        return this.e;
    }

    private synchronized boolean m() {
        return this.f;
    }

    private synchronized void n() {
        this.f = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void o() {
        java.util.List list = this.k;
        if (list != null && list.size() > 0) {
            for (com.tencent.beaconselfupdate.event.d dVar : this.k) {
                a(dVar.f258a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, false);
            }
            this.k.clear();
        }
    }

    private void p() {
        com.tencent.beaconselfupdate.a.b.b bVarA;
        com.tencent.beaconselfupdate.a.b.d.a aVarB;
        java.lang.String strB;
        try {
            if ((!e() && !this.b.f()) || (bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.g)) == null || (aVarB = bVarA.e().b(1)) == null || (strB = aVarB.b()) == null || "".equals(strB.trim())) {
                return;
            }
            new com.tencent.beaconselfupdate.event.f(this.g).b();
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.c(" startHeart failed! " + e.getMessage(), new java.lang.Object[0]);
        }
    }

    private void q() {
        boolean z;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        if (this.b.i()) {
            z = true;
            if (!"".equals(com.tencent.beaconselfupdate.a.a.b(this.g, "LAUEVE_DENGTA", ""))) {
                com.tencent.beaconselfupdate.c.a.a("AppLaunchedEvent has been uploaded!", new java.lang.Object[0]);
                return;
            }
        } else {
            z = false;
        }
        if (com.tencent.beaconselfupdate.a.e.a(this.g) == null) {
            com.tencent.beaconselfupdate.c.a.c(" DeviceInfo == null?,return", new java.lang.Object[0]);
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("A33", com.tencent.beaconselfupdate.a.e.g(this.g));
        map.put("A63", "Y");
        if (com.tencent.beaconselfupdate.a.a.b(this.g)) {
            str = "A21";
            str2 = "Y";
        } else {
            str = "A21";
            str2 = "N";
        }
        map.put(str, str2);
        if (com.tencent.beaconselfupdate.a.b.b.a(this.g).g()) {
            str3 = "A45";
            str4 = "Y";
        } else {
            str3 = "A45";
            str4 = "N";
        }
        map.put(str3, str4);
        if (com.tencent.beaconselfupdate.a.a.g(this.g)) {
            str5 = "A66";
            str6 = "F";
        } else {
            str5 = "A66";
            str6 = "B";
        }
        map.put(str5, str6);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.beaconselfupdate.a.a.h(this.g));
        map.put("A68", sb.toString());
        map.put("A85", com.tencent.beaconselfupdate.a.a.b ? "Y" : "N");
        map.put("A9", com.tencent.beaconselfupdate.a.e.d());
        map.put("A14", com.tencent.beaconselfupdate.a.e.e());
        boolean zA = a("rqd_applaunched", true, 0L, 0L, map, true, false);
        if (z && zA) {
            com.tencent.beaconselfupdate.a.a.a(this.g, "LAUEVE_DENGTA", com.tencent.beaconselfupdate.a.e.g());
        }
    }

    @Override // com.tencent.beaconselfupdate.a.b.a
    public final void a() {
        a(h() + 1);
    }

    @Override // com.tencent.beaconselfupdate.a.b.e
    public final void a(com.tencent.beaconselfupdate.a.b.d dVar) {
        com.tencent.beaconselfupdate.a.b.d.a aVarB;
        boolean zA;
        if (dVar == null || (aVarB = dVar.b(1)) == null || e() == (zA = aVarB.a())) {
            return;
        }
        com.tencent.beaconselfupdate.c.a.f("UAR onCommonStrategyChange setUsable:%b ", java.lang.Boolean.valueOf(zA));
        f(zA);
    }

    @Override // com.tencent.beaconselfupdate.a.b.f
    public final void a(java.util.Map map) {
        com.tencent.beaconselfupdate.event.e eVar;
        if (map == null || map.size() <= 0 || (eVar = this.b) == null) {
            return;
        }
        eVar.a(map);
    }

    public final void a(boolean z) {
        com.tencent.beaconselfupdate.a.b.d.a aVarB;
        com.tencent.beaconselfupdate.a.b.b bVarA = com.tencent.beaconselfupdate.a.b.b.a(this.g);
        if (bVarA == null || (aVarB = bVarA.e().b(1)) == null || aVarB.a() == z) {
            return;
        }
        aVarB.a(z);
        if (z != e()) {
            f(z);
        }
    }

    @Override // com.tencent.beaconselfupdate.a.b.a
    public final void b() {
        n();
        try {
            com.tencent.beaconselfupdate.a.b.d dVarE = com.tencent.beaconselfupdate.a.b.b.a(this.g).e();
            if (dVarE != null) {
                com.tencent.beaconselfupdate.a.b.d.a aVarB = dVarE.b(1);
                if (aVarB != null && this.b != null) {
                    java.util.Set setD = aVarB.d();
                    if (setD != null && setD.size() > 0) {
                        this.b.a(setD);
                    }
                    java.util.Set setF = aVarB.f();
                    if (setF != null && setF.size() > 0) {
                        this.b.b(setF);
                    }
                }
                if (!e() || aVarB == null) {
                    com.tencent.beaconselfupdate.c.a.b("event module is disable", new java.lang.Object[0]);
                } else {
                    if ((e() ? com.tencent.beaconselfupdate.a.e.j(this.g) : -1) > 0) {
                        com.tencent.beaconselfupdate.c.a.e(" asyn up module %d", 1);
                        com.tencent.beaconselfupdate.a.b.a().a(new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.j.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.tencent.beaconselfupdate.event.j.this.e(true);
                            }
                        });
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d(" common query end error %s", th.toString());
        }
        o();
        if (h() < 2) {
            com.tencent.beaconselfupdate.upload.g gVarA = com.tencent.beaconselfupdate.upload.g.a(this.g);
            if (gVarA.a() && gVarA.b()) {
                p();
                q();
                if (this.b.j()) {
                    this.m.setChanged();
                    this.m.notifyObservers(this.g);
                }
            }
        }
    }

    public final void b(boolean z) {
        if (com.tencent.beaconselfupdate.upload.g.a(this.g) == null || z == com.tencent.beaconselfupdate.upload.g.a(this.g).b()) {
            return;
        }
        if (z) {
            com.tencent.beaconselfupdate.upload.g.a(this.g).a(true);
            p();
            q();
        } else {
            com.tencent.beaconselfupdate.upload.g.a(this.g).a(false);
            android.content.Context context = this.g;
            com.tencent.beaconselfupdate.a.b.a().a(108);
            com.tencent.beaconselfupdate.a.a.a(context, "HEART_DENGTA", com.tencent.beaconselfupdate.a.e.g());
            com.tencent.beaconselfupdate.c.a.a("heartbeat uploaded sucess!", new java.lang.Object[0]);
        }
    }

    @Override // com.tencent.beaconselfupdate.a.b.a
    public final void c() {
        android.content.Context context = this.g;
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.deleteRecords() start", new java.lang.Object[0]);
        com.tencent.beaconselfupdate.c.a.e(" ua first clean :%d", java.lang.Integer.valueOf(com.tencent.beaconselfupdate.a.a.a.a(context, new int[]{1})));
        com.tencent.beaconselfupdate.c.a.e(" ua remove strategy :%d", java.lang.Integer.valueOf(com.tencent.beaconselfupdate.a.e.i(this.g)));
    }

    public final synchronized boolean e() {
        return this.i;
    }

    public final boolean e(boolean z) {
        synchronized (this.l) {
            if ((e() ? com.tencent.beaconselfupdate.a.e.j(this.g) : -1) > 0) {
                try {
                    if (this.h != null) {
                        com.tencent.beaconselfupdate.event.b bVar = new com.tencent.beaconselfupdate.event.b(this.g);
                        bVar.a(z);
                        this.h.a(bVar);
                    }
                    return true;
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.c(" up common error: %s", th.toString());
                    com.tencent.beaconselfupdate.c.a.a(th);
                }
            }
            return false;
        }
    }

    public final com.tencent.beaconselfupdate.upload.f f() {
        return this.h;
    }

    public final com.tencent.beaconselfupdate.event.e g() {
        return this.b;
    }

    public final synchronized int h() {
        return this.j;
    }
}
