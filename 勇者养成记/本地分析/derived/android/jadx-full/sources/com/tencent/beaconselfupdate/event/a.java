package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements com.tencent.beaconselfupdate.event.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f254a;
    private boolean b = false;
    private java.lang.Object c = new java.lang.Object();
    private java.lang.Object d = new java.lang.Object();
    private java.lang.Object e = new java.lang.Object();
    private long g = 60000;
    private java.lang.Runnable h = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.a.1
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.event.a.this.a();
        }
    };
    private java.lang.Runnable i = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.a.2
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.event.a.this.c();
        }
    };
    private java.lang.Runnable j = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.a.3
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.c.a.f(" db events to up", new java.lang.Object[0]);
            try {
                com.tencent.beaconselfupdate.event.j.d(false);
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
    };
    private java.util.List f = new java.util.ArrayList(25);

    public a(android.content.Context context) {
        this.f254a = context;
    }

    private synchronized java.util.List b() {
        java.util.List list = this.f;
        if (list != null && list.size() > 0 && d()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(this.f);
            this.f.clear();
            com.tencent.beaconselfupdate.c.a.b(" get MN:" + arrayList.size(), new java.lang.Object[0]);
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.e) {
            if (!d()) {
                com.tencent.beaconselfupdate.c.a.c(" err su 1R", new java.lang.Object[0]);
                return;
            }
            java.util.List listB = b();
            if (listB != null && listB.size() > 0) {
                com.tencent.beaconselfupdate.a.e.a(this.f254a, listB);
            }
        }
    }

    private synchronized boolean d() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void a() {
        java.lang.String str;
        java.lang.Object[] objArr;
        synchronized (this.d) {
            if (!d()) {
                com.tencent.beaconselfupdate.c.a.c(" err su 1R", new java.lang.Object[0]);
                return;
            }
            java.util.List listB = b();
            if (listB == null || listB.size() <= 0) {
                com.tencent.beaconselfupdate.event.e eVarG = com.tencent.beaconselfupdate.event.j.d().g();
                if (eVarG != null ? eVarG.g() : false) {
                    this.j.run();
                    str = " common polling up";
                    objArr = new java.lang.Object[0];
                    com.tencent.beaconselfupdate.c.a.e(str, objArr);
                }
            } else {
                java.lang.Long[] lArrA = com.tencent.beaconselfupdate.a.e.a(this.f254a, listB);
                com.tencent.beaconselfupdate.upload.g gVarA = com.tencent.beaconselfupdate.upload.g.a(this.f254a);
                if (lArrA != null) {
                    long jE = com.tencent.beaconselfupdate.event.j.d().g().e();
                    if (com.tencent.beaconselfupdate.a.e.l(this.f254a)) {
                        com.tencent.beaconselfupdate.c.a.e(" onwifi, so half mSZ " + jE, new java.lang.Object[0]);
                        jE /= 2;
                    }
                    int iJ = com.tencent.beaconselfupdate.a.e.j(this.f254a);
                    com.tencent.beaconselfupdate.c.a.b("countCommomRecordNum: " + iJ, new java.lang.Object[0]);
                    if ((((long) iJ) >= jE) && gVarA.a() && gVarA.b()) {
                        this.j.run();
                        str = " common max up";
                        objArr = new java.lang.Object[0];
                        com.tencent.beaconselfupdate.c.a.e(str, objArr);
                    }
                }
            }
        }
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final synchronized void a(boolean z) {
        if (this.b != z) {
            if (z) {
                this.b = z;
                this.g = com.tencent.beaconselfupdate.event.j.d().g().d() * 1000;
                com.tencent.beaconselfupdate.a.b bVarA = com.tencent.beaconselfupdate.a.b.a();
                java.lang.Runnable runnable = this.h;
                long j = this.g;
                bVarA.a(102, runnable, j, j);
                return;
            }
            com.tencent.beaconselfupdate.a.b.a().a(102);
            com.tencent.beaconselfupdate.a.b.a().a(112);
            b(true);
            this.b = z;
        }
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final boolean a(com.tencent.beaconselfupdate.event.h hVar) {
        synchronized (this.c) {
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = hVar == null ? "null" : hVar.d();
            objArr[1] = java.lang.Boolean.FALSE;
            com.tencent.beaconselfupdate.c.a.f(" BF eN:%s   isRT:%b ", objArr);
            if (this.f254a != null && hVar != null && this.b) {
                if (!d()) {
                    com.tencent.beaconselfupdate.c.a.d(" CommonProcess processUA return false, isEnable is false !", new java.lang.Object[0]);
                    return false;
                }
                com.tencent.beaconselfupdate.event.e eVarG = com.tencent.beaconselfupdate.event.j.d().g();
                int iC = eVarG.c();
                this.g = eVarG.d() * 1000;
                int size = this.f.size();
                if (size >= iC) {
                    com.tencent.beaconselfupdate.c.a.f(" BF mN!", new java.lang.Object[0]);
                    com.tencent.beaconselfupdate.a.b.a().a(this.h);
                    com.tencent.beaconselfupdate.a.b.a().a(102, this.h, this.g, this.g);
                }
                this.f.add(hVar);
                if (this.f.size() >= iC) {
                    com.tencent.beaconselfupdate.c.a.c(" err BF 3R! list size:" + size, new java.lang.Object[0]);
                }
                com.tencent.beaconselfupdate.c.a.a("CommonprocessUA:true!", new java.lang.Object[0]);
                return true;
            }
            com.tencent.beaconselfupdate.c.a.d(" err BF 1R", new java.lang.Object[0]);
            return false;
        }
    }

    @Override // com.tencent.beaconselfupdate.event.g
    public final synchronized void b(boolean z) {
        com.tencent.beaconselfupdate.c.a.e("common process flush memory objects to db.", new java.lang.Object[0]);
        if (z) {
            c();
        } else {
            com.tencent.beaconselfupdate.a.b.a().a(this.i);
        }
    }
}
