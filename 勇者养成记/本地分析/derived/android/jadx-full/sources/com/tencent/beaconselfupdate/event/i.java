package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class i implements com.tencent.beaconselfupdate.event.g {
    private android.content.Context c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f263a = false;
    private java.lang.Runnable d = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.i.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tencent.beaconselfupdate.event.i.this.a();
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
    };
    private java.lang.Runnable e = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.i.2
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.event.i.this.d();
        }
    };
    private java.util.List b = java.util.Collections.synchronizedList(new java.util.ArrayList(25));

    final class a extends com.tencent.beaconselfupdate.upload.a {
        private java.util.List e;
        private android.content.Context f;
        private java.lang.Long[] g;
        private boolean h;

        public a(android.content.Context context, java.util.List list) {
            super(context, 1, 2);
            this.e = null;
            this.g = null;
            this.h = false;
            this.e = list;
            this.f = context;
            list.size();
            if (this.e.size() == 1 && "rqd_heartbeat".equals(((com.tencent.beaconselfupdate.event.h) this.e.get(0)).d())) {
                this.h = true;
            }
            java.lang.String strB = com.tencent.beaconselfupdate.a.e.b(context, 2);
            this.d = strB;
            com.tencent.beaconselfupdate.c.a.a("real rid:%s", strB);
        }

        private static com.tencent.beaconselfupdate.b.a.b a(int i, java.util.List list) {
            byte[] bArrA;
            if (list != null && list.size() > 0) {
                try {
                    com.tencent.beaconselfupdate.c.a.b(" current size:" + list.size(), new java.lang.Object[0]);
                    com.tencent.beaconselfupdate.b.b.b bVarA = a(list);
                    if (bVarA == null || (bArrA = bVarA.a()) == null) {
                        return null;
                    }
                    return com.tencent.beaconselfupdate.upload.a.a(i, bArrA);
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new java.lang.Object[0]);
                }
            }
            return null;
        }

        private static com.tencent.beaconselfupdate.b.b.b a(java.util.List list) {
            if (list != null && list.size() > 0) {
                try {
                    com.tencent.beaconselfupdate.b.b.b bVar = new com.tencent.beaconselfupdate.b.b.b();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        com.tencent.beaconselfupdate.b.b.a aVarA = com.tencent.beaconselfupdate.a.e.a((com.tencent.beaconselfupdate.event.h) it.next());
                        if (aVarA != null) {
                            arrayList.add(aVarA);
                        }
                    }
                    bVar.f244a = arrayList;
                    com.tencent.beaconselfupdate.c.a.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new java.lang.Object[0]);
                    return bVar;
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                }
            }
            return null;
        }

        @Override // com.tencent.beaconselfupdate.upload.a
        public final synchronized com.tencent.beaconselfupdate.b.a.b a() {
            com.tencent.beaconselfupdate.c.a.b(" TUUD.GetUD start", new java.lang.Object[0]);
            java.util.List list = this.e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            try {
                com.tencent.beaconselfupdate.b.a.b bVarA = a(this.f268a, this.e);
                if (bVarA != null) {
                    return bVarA;
                }
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
                com.tencent.beaconselfupdate.c.a.d(" TUUD.GetUD start error", new java.lang.Object[0]);
            }
            return null;
        }

        @Override // com.tencent.beaconselfupdate.upload.a
        public final synchronized void b(boolean z) {
            java.lang.Long[] lArr;
            com.tencent.beaconselfupdate.c.a.b(" TimeUpUploadDatas.done(), result:%b", java.lang.Boolean.valueOf(z));
            if (this.e != null && !z) {
                com.tencent.beaconselfupdate.c.a.f(" upload failed, save to db", new java.lang.Object[0]);
                if (!this.h) {
                    this.g = com.tencent.beaconselfupdate.a.e.a(this.f, this.e);
                    this.e = null;
                }
            }
            if (z && this.h) {
                android.content.Context context = this.f;
                com.tencent.beaconselfupdate.a.b.a().a(108);
                com.tencent.beaconselfupdate.a.a.a(context, "HEART_DENGTA", com.tencent.beaconselfupdate.a.e.g());
                com.tencent.beaconselfupdate.c.a.a("heartbeat uploaded sucess!", new java.lang.Object[0]);
            }
            if (z && (lArr = this.g) != null) {
                com.tencent.beaconselfupdate.a.e.a(this.f, lArr);
            }
            if (z && this.g == null && this.e != null) {
                this.e = null;
            }
        }
    }

    public i(android.content.Context context) {
        this.c = context;
    }

    private synchronized java.util.List b() {
        java.util.List list = this.b;
        if (list != null && list.size() > 0 && c()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(this.b);
            this.b.clear();
            com.tencent.beaconselfupdate.c.a.b(" get realEventCnt in Mem:" + arrayList.size(), new java.lang.Object[0]);
            return arrayList;
        }
        return null;
    }

    private synchronized boolean c() {
        return this.f263a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        java.util.List listB = b();
        if (listB == null || listB.size() <= 0) {
            return;
        }
        com.tencent.beaconselfupdate.c.a.f(" dsb real events 2 db" + listB.size(), new java.lang.Object[0]);
        com.tencent.beaconselfupdate.a.e.a(this.c, listB);
    }

    protected final void a() {
        if (!c()) {
            com.tencent.beaconselfupdate.c.a.c(" err su 1R", new java.lang.Object[0]);
            return;
        }
        java.util.List listB = b();
        if (listB == null || listB.size() <= 0) {
            return;
        }
        com.tencent.beaconselfupdate.upload.f fVarF = com.tencent.beaconselfupdate.event.j.d().f();
        if (!com.tencent.beaconselfupdate.a.e.m(this.c) || fVarF == null) {
            com.tencent.beaconselfupdate.c.a.f(" dsu real events 2 db" + listB.size(), new java.lang.Object[0]);
            com.tencent.beaconselfupdate.a.e.a(this.c, listB);
            return;
        }
        com.tencent.beaconselfupdate.c.a.f(" dsu real events 2 up " + listB.size(), new java.lang.Object[0]);
        fVarF.a(new com.tencent.beaconselfupdate.event.i.a(this.c, listB));
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final synchronized void a(boolean z) {
        if (this.f263a != z) {
            if (z) {
                this.f263a = z;
                com.tencent.beaconselfupdate.a.b.a().a(103, this.d, 5000L, com.tencent.beaconselfupdate.event.j.d().g().b() * 1000);
            } else {
                com.tencent.beaconselfupdate.a.b.a().a(103);
                b(true);
                this.f263a = z;
            }
        }
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final synchronized boolean a(com.tencent.beaconselfupdate.event.h hVar) {
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = hVar == null ? "null" : hVar.d();
        objArr[1] = java.lang.Boolean.TRUE;
        com.tencent.beaconselfupdate.c.a.f(" BF eN:%s   isRT:%b", objArr);
        if (this.c != null && hVar != null) {
            if (!c()) {
                com.tencent.beaconselfupdate.c.a.c("processUA return false, isEnable is false !", new java.lang.Object[0]);
                return false;
            }
            com.tencent.beaconselfupdate.event.e eVarG = com.tencent.beaconselfupdate.event.j.d().g();
            int iA = eVarG.a();
            long jB = eVarG.b() * 1000;
            if (this.b.size() >= iA || hVar.f()) {
                com.tencent.beaconselfupdate.c.a.f(" BF mN!", new java.lang.Object[0]);
                com.tencent.beaconselfupdate.a.b.a().a(this.d);
                com.tencent.beaconselfupdate.a.b.a().a(103, this.d, jB, jB);
            }
            this.b.add(hVar);
            if (this.b.size() >= iA) {
                com.tencent.beaconselfupdate.c.a.c(" err BF 3R! num:" + this.b.size(), new java.lang.Object[0]);
            }
            if ("rqd_applaunched".equals(hVar.d())) {
                com.tencent.beaconselfupdate.a.b.a().a(this.d);
            }
            com.tencent.beaconselfupdate.c.a.a("processUA:true!", new java.lang.Object[0]);
            return true;
        }
        com.tencent.beaconselfupdate.c.a.c("processUA return false, context is null or bean is null !", new java.lang.Object[0]);
        return false;
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final synchronized void b(boolean z) {
        com.tencent.beaconselfupdate.c.a.e("realtime process flush memory objects to db.", new java.lang.Object[0]);
        if (z) {
            d();
        } else {
            com.tencent.beaconselfupdate.a.b.a().a(this.e);
        }
    }
}
