package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {
    private static boolean j = false;
    private android.os.Handler d;
    private com.tencent.ydkqmsp.sdk.c.k e;
    private com.tencent.ydkqmsp.sdk.c.j f;
    private com.tencent.ydkqmsp.sdk.c.e h;
    private static final byte[][] i = {new byte[]{60, 116, -72, 81, 35, 43}, new byte[]{41, 121, -79, 113, 35, 43, 57, -18, 42}};
    private static java.util.concurrent.ConcurrentHashMap k = new java.util.concurrent.ConcurrentHashMap();
    private static android.os.Handler l = null;
    private static volatile com.tencent.ydkqmsp.sdk.c.f m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1312a = -1;
    private boolean b = false;
    private boolean c = false;
    private com.tencent.ydkqmsp.sdk.d.c g = null;

    class a implements com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a {
        a(com.tencent.ydkqmsp.sdk.c.f fVar) {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void a() {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QFW", 1, "Something wrong when load native so.");
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void run() {
            if (com.tencent.ydkqmsp.sdk.c.f.j) {
                return;
            }
            try {
                if (!com.tencent.ydkqmsp.sdk.c.f.k()) {
                    java.lang.System.loadLibrary(com.tencent.ydkqmsp.sdk.c.f.c(0));
                }
                boolean unused = com.tencent.ydkqmsp.sdk.c.f.j = true;
            } catch (java.lang.UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    class b implements com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a {
        b() {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void a() {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QFW", 1, "Something wrong when init native.");
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void run() {
            if (!com.tencent.ydkqmsp.sdk.c.f.j || com.tencent.ydkqmsp.sdk.c.f.this.b) {
                return;
            }
            try {
                java.lang.Object[] objArr = new java.lang.Object[1];
                if (com.tencent.ydkqmsp.sdk.c.f.a(1L, 512L, com.tencent.ydkqmsp.sdk.a.c.f(), 0L, com.tencent.ydkqmsp.sdk.c.f.this.e, com.tencent.ydkqmsp.sdk.app.a.getContext(), null, objArr) == 0 && objArr[0] != null && (objArr[0] instanceof java.lang.Integer)) {
                    com.tencent.ydkqmsp.sdk.c.f.this.f1312a = ((java.lang.Integer) objArr[0]).intValue();
                    int unused = com.tencent.ydkqmsp.sdk.c.f.this.f1312a;
                    com.tencent.ydkqmsp.sdk.c.f.this.b = true;
                }
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QFW", 1, java.lang.String.format("Native ver: %d(%s)", java.lang.Integer.valueOf(com.tencent.ydkqmsp.sdk.c.f.this.f1312a), com.tencent.ydkqmsp.sdk.a.c.a(com.tencent.ydkqmsp.sdk.c.f.this.f1312a)));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c extends android.os.Handler {
        c(com.tencent.ydkqmsp.sdk.c.f fVar, android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                long j = java.lang.Long.parseLong((java.lang.String) message.obj);
                if (message.what != 1 || j == 0) {
                    return;
                }
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QFW", 1, java.lang.String.format("handle native msg for cookie: %08X", java.lang.Long.valueOf(j)));
                com.tencent.ydkqmsp.sdk.c.f.a(6L, j, 0L, 0L, null, null, null, null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d implements com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f {
        d() {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f
        public int a(long j, long j2, long j3, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
            if (j != 0) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QFW", 1, java.lang.String.format("Native msg, cookie: %08X, delay: %d", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
                java.lang.String strValueOf = java.lang.String.valueOf(j);
                if (j2 != 0) {
                    com.tencent.ydkqmsp.sdk.c.f.this.d.sendMessageDelayed(com.tencent.ydkqmsp.sdk.c.f.this.d.obtainMessage(1, strValueOf), j2 * 1000);
                } else {
                    com.tencent.ydkqmsp.sdk.c.f.this.d.sendMessage(com.tencent.ydkqmsp.sdk.c.f.this.d.obtainMessage(1, strValueOf));
                }
            }
            return 0;
        }
    }

    class e implements com.tencent.ydkqmsp.sdk.c.j.e {
        e() {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.j.e
        public void a(int i, int i2) {
            com.tencent.ydkqmsp.sdk.c.f.this.f.b(this);
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.c.f$f, reason: collision with other inner class name */
    public interface InterfaceC0048f {
        int a(long j, long j2, long j3, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2);
    }

    private f() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        if (com.tencent.ydkqmsp.sdk.app.a.getContext() == null) {
            return;
        }
        j();
        com.tencent.ydkqmsp.sdk.c.k kVar = new com.tencent.ydkqmsp.sdk.c.k();
        this.e = kVar;
        kVar.a(com.tencent.ydkqmsp.sdk.c.m.b());
        new com.tencent.ydkqmsp.sdk.c.a(c(0), 86400000L).a(new com.tencent.ydkqmsp.sdk.c.f.b());
        this.h = com.tencent.ydkqmsp.sdk.c.e.d();
        com.tencent.ydkqmsp.sdk.c.j jVarE = com.tencent.ydkqmsp.sdk.c.j.e();
        this.f = jVarE;
        jVarE.a(this.h);
        this.d = new com.tencent.ydkqmsp.sdk.c.f.c(this, com.tencent.ydkqmsp.sdk.app.b.e().c());
        a(2L, new com.tencent.ydkqmsp.sdk.c.f.d());
    }

    public static int a(long j2, long j3, long j4, long j5, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        if (!j) {
            return 27;
        }
        try {
            return goingDownInternal(j2, j3, j4, j5, obj, obj2, objArr, objArr2);
        } catch (java.lang.UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 29;
        }
    }

    public static java.lang.String a(int i2, int i3, int i4, int i5, java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof java.lang.String) && obj != null && j) {
            try {
                return goingDownInternal(i2, i3, i4, i5, obj, obj2);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void a(long j2, com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f interfaceC0048f) {
        if (interfaceC0048f != null) {
            k.put(java.lang.Long.valueOf(j2), interfaceC0048f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String c(int i2) {
        return com.tencent.ydkqmsp.sdk.f.k.a(i[i2]);
    }

    private static native int goingDownInternal(long j2, long j3, long j4, long j5, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2);

    private static native java.lang.String goingDownInternal(long j2, long j3, long j4, long j5, java.lang.Object obj, java.lang.Object obj2);

    private static int goingUp(long j2, long j3, long j4, long j5, java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f interfaceC0048f = (com.tencent.ydkqmsp.sdk.c.f.InterfaceC0048f) k.get(java.lang.Long.valueOf(j2));
        if (interfaceC0048f != null) {
            return interfaceC0048f.a(j3, j4, j5, obj, obj2, objArr, objArr2);
        }
        return 30;
    }

    public static com.tencent.ydkqmsp.sdk.c.f i() {
        if (m == null) {
            synchronized (com.tencent.ydkqmsp.sdk.c.f.class) {
                if (m == null) {
                    m = new com.tencent.ydkqmsp.sdk.c.f();
                }
            }
        }
        return m;
    }

    private void j() {
        new com.tencent.ydkqmsp.sdk.c.a(c(0), 86400000L).a(new com.tencent.ydkqmsp.sdk.c.f.a(this));
        l = new android.os.Handler(com.tencent.ydkqmsp.sdk.app.b.e().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k() {
        if (j) {
            return true;
        }
        java.lang.String str = com.tencent.ydkqmsp.sdk.a.b.b() + java.io.File.separator + c(1);
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !com.tencent.ydkqmsp.sdk.d.e.b(file, null)) {
            return false;
        }
        try {
            java.lang.System.load(str);
            return true;
        } catch (java.lang.UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int a(int i2, int i3, int i4, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        return this.f.a(i2, i3, i4, objArr, objArr2);
    }

    public java.lang.Boolean a(int i2) {
        com.tencent.ydkqmsp.sdk.c.e eVar = this.h;
        return java.lang.Boolean.valueOf(1 == (eVar != null ? eVar.a(i2) : -1));
    }

    public void a() {
        com.tencent.ydkqmsp.sdk.c.e eVar = this.h;
        if (eVar != null) {
            eVar.a();
        }
        com.tencent.ydkqmsp.sdk.c.j jVar = this.f;
        if (jVar != null) {
            jVar.a();
        }
        if (m != null) {
            m = null;
        }
    }

    public void a(com.tencent.ydkqmsp.sdk.d.c cVar) {
        this.g = cVar;
    }

    public com.tencent.ydkqmsp.sdk.c.e b() {
        return this.h;
    }

    public android.os.Handler c() {
        return l;
    }

    public com.tencent.ydkqmsp.sdk.d.c d() {
        return this.g;
    }

    public void e() {
        this.f.b();
    }

    public void f() {
        if (!this.c) {
            this.c = true;
        }
        com.tencent.ydkqmsp.sdk.e.a.a();
        com.tencent.ydkqmsp.sdk.e.c.a();
        com.tencent.ydkqmsp.sdk.e.b.a();
        this.f.a(new com.tencent.ydkqmsp.sdk.c.f.e());
        this.f.c();
    }
}
