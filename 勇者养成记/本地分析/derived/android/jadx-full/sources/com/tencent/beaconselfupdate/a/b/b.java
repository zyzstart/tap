package com.tencent.beaconselfupdate.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {
    private static com.tencent.beaconselfupdate.a.b.b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.beaconselfupdate.a.b.d f227a;
    protected android.content.Context b;
    private com.tencent.beaconselfupdate.upload.e f;
    private java.lang.Runnable g;
    private boolean d = false;
    private int e = 0;
    private java.util.List h = new java.util.ArrayList(5);
    private android.util.SparseArray i = new android.util.SparseArray(5);
    private java.util.List j = new java.util.ArrayList(5);
    private android.util.SparseArray k = new android.util.SparseArray(2);
    private boolean l = false;
    private java.lang.Runnable m = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.a.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.a.b.d dVar;
            com.tencent.beaconselfupdate.a.b.b bVar = com.tencent.beaconselfupdate.a.b.b.this;
            android.content.Context context = bVar.b;
            if (context == null || (dVar = bVar.f227a) == null) {
                return;
            }
            dVar.a(context);
        }
    };

    private b(android.content.Context context) {
        this.f227a = null;
        this.b = null;
        this.f = null;
        this.g = null;
        this.b = context;
        this.f227a = com.tencent.beaconselfupdate.a.b.d.a();
        com.tencent.beaconselfupdate.a.b.a().a(this.m);
        this.f = new com.tencent.beaconselfupdate.upload.e(context);
        this.g = new com.tencent.beaconselfupdate.a.b.c(context);
        com.tencent.beaconselfupdate.a.b.a().a(this.g);
    }

    public static synchronized com.tencent.beaconselfupdate.a.b.b a(android.content.Context context) {
        if (c == null && context != null) {
            c = new com.tencent.beaconselfupdate.a.b.b(context);
        }
        return c;
    }

    public static synchronized com.tencent.beaconselfupdate.upload.f c() {
        com.tencent.beaconselfupdate.a.b.b bVar = c;
        if (bVar == null) {
            return null;
        }
        return bVar.k();
    }

    private synchronized com.tencent.beaconselfupdate.upload.f k() {
        android.util.SparseArray sparseArray = this.i;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        return (com.tencent.beaconselfupdate.upload.f) this.i.get(0);
    }

    private synchronized com.tencent.beaconselfupdate.a.b.e[] l() {
        java.util.List list = this.j;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (com.tencent.beaconselfupdate.a.b.e[]) this.j.toArray(new com.tencent.beaconselfupdate.a.b.e[0]);
    }

    private synchronized android.util.SparseArray m() {
        return this.k;
    }

    public final synchronized void a(int i) {
        this.e = i;
        com.tencent.beaconselfupdate.c.a.f("step:%d", java.lang.Integer.valueOf(i));
    }

    public final synchronized void a(int i, com.tencent.beaconselfupdate.upload.f fVar) {
        android.util.SparseArray sparseArray = this.i;
        if (sparseArray != null) {
            if (fVar == null) {
                sparseArray.remove(i);
            } else {
                sparseArray.put(i, fVar);
                fVar.a(f());
            }
        }
    }

    public final void a(int i, java.util.Map map) {
        com.tencent.beaconselfupdate.a.b.f fVar;
        android.util.SparseArray sparseArrayM = m();
        if (sparseArrayM == null || (fVar = (com.tencent.beaconselfupdate.a.b.f) sparseArrayM.get(i)) == null) {
            return;
        }
        fVar.a(map);
    }

    public final synchronized void a(final com.tencent.beaconselfupdate.a.b.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.h == null) {
            this.h = new java.util.ArrayList();
        }
        if (!this.h.contains(aVar)) {
            this.h.add(aVar);
            final int iJ = j();
            if (g()) {
                com.tencent.beaconselfupdate.c.a.e("add listener should notify app first run! %s", aVar.toString());
                com.tencent.beaconselfupdate.a.b.a().a(new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.a.b.b.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.c();
                    }
                });
            }
            if (iJ >= 2) {
                com.tencent.beaconselfupdate.c.a.e("add listener should notify app start query! %s", aVar.toString());
                com.tencent.beaconselfupdate.a.b.a().a(new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.a.b.b.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.a();
                        if (iJ >= 3) {
                            com.tencent.beaconselfupdate.c.a.e("query finished should notify", new java.lang.Object[0]);
                            aVar.b();
                        }
                    }
                });
            }
        }
    }

    public final void a(com.tencent.beaconselfupdate.a.b.d dVar) {
        com.tencent.beaconselfupdate.a.b.e[] eVarArrL = l();
        if (eVarArrL != null) {
            for (com.tencent.beaconselfupdate.a.b.e eVar : eVarArrL) {
                try {
                    eVar.a(dVar);
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d("com strategy changed error %s", th.toString());
                }
            }
        }
    }

    public final synchronized void a(com.tencent.beaconselfupdate.a.b.e eVar) {
        if (eVar != null) {
            java.util.List list = this.j;
            if (list != null && !list.contains(eVar)) {
                this.j.add(eVar);
            }
        }
    }

    public final synchronized void a(com.tencent.beaconselfupdate.a.b.f fVar) {
        if (fVar != null) {
            android.util.SparseArray sparseArray = this.k;
            if (sparseArray != null) {
                sparseArray.put(1, fVar);
            }
        }
    }

    public final synchronized boolean a() {
        return this.l;
    }

    public final synchronized void b() {
        this.l = true;
    }

    public final synchronized java.lang.Runnable d() {
        return this.g;
    }

    public final synchronized com.tencent.beaconselfupdate.a.b.d e() {
        return this.f227a;
    }

    public final synchronized com.tencent.beaconselfupdate.upload.e f() {
        return this.f;
    }

    public final synchronized boolean g() {
        return this.d;
    }

    protected final synchronized void h() {
        this.d = true;
        com.tencent.beaconselfupdate.c.a.f("isFirst }%b", java.lang.Boolean.TRUE);
    }

    public final synchronized com.tencent.beaconselfupdate.a.b.a[] i() {
        java.util.List list = this.h;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (com.tencent.beaconselfupdate.a.b.a[]) this.h.toArray(new com.tencent.beaconselfupdate.a.b.a[0]);
    }

    public final synchronized int j() {
        return this.e;
    }
}
