package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class as extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {
    private static java.util.Map n;
    private static /* synthetic */ boolean o = !com.tencent.bugly.opengame.proguard.as.class.desiredAssertionStatus();
    private static com.tencent.bugly.opengame.proguard.ar m = new com.tencent.bugly.opengame.proguard.ar();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f388a = true;
    public boolean b = true;
    public boolean c = true;
    public java.lang.String d = "";
    public java.lang.String e = "";
    public com.tencent.bugly.opengame.proguard.ar f = null;
    public java.util.Map g = null;
    public long h = 0;
    private java.lang.String j = "";
    private java.lang.String k = "";
    private int l = 0;
    public int i = 0;

    static {
        java.util.HashMap map = new java.util.HashMap();
        n = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f388a = iVar.a(0, true);
        this.b = iVar.a(1, true);
        this.c = iVar.a(2, true);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = (com.tencent.bugly.opengame.proguard.ar) iVar.a((com.tencent.bugly.opengame.proguard.k) m, 5, false);
        this.g = (java.util.Map) iVar.a((java.lang.Object) n, 6, false);
        this.h = iVar.a(this.h, 7, false);
        this.j = iVar.b(8, false);
        this.k = iVar.b(9, false);
        this.l = iVar.a(this.l, 10, false);
        this.i = iVar.a(this.i, 11, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f388a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        java.lang.String str = this.d;
        if (str != null) {
            jVar.a(str, 3);
        }
        java.lang.String str2 = this.e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        com.tencent.bugly.opengame.proguard.ar arVar = this.f;
        if (arVar != null) {
            jVar.a((com.tencent.bugly.opengame.proguard.k) arVar, 5);
        }
        java.util.Map map = this.g;
        if (map != null) {
            jVar.a(map, 6);
        }
        jVar.a(this.h, 7);
        java.lang.String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        java.lang.String str4 = this.k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.l, 10);
        jVar.a(this.i, 11);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(sb, i);
        hVar.a(this.f388a, "enable");
        hVar.a(this.b, "enableUserInfo");
        hVar.a(this.c, "enableQuery");
        hVar.a(this.d, "url");
        hVar.a(this.e, "expUrl");
        hVar.a((com.tencent.bugly.opengame.proguard.k) this.f, "security");
        hVar.a(this.g, "valueMap");
        hVar.a(this.h, "strategylastUpdateTime");
        hVar.a(this.j, "httpsUrl");
        hVar.a(this.k, "httpsExpUrl");
        hVar.a(this.l, "eventRecordCount");
        hVar.a(this.i, "eventTimeInterval");
    }

    public final java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.bugly.opengame.proguard.as asVar = (com.tencent.bugly.opengame.proguard.as) obj;
        return com.tencent.bugly.opengame.proguard.l.a(this.f388a, asVar.f388a) && com.tencent.bugly.opengame.proguard.l.a(this.b, asVar.b) && com.tencent.bugly.opengame.proguard.l.a(this.c, asVar.c) && com.tencent.bugly.opengame.proguard.l.a(this.d, asVar.d) && com.tencent.bugly.opengame.proguard.l.a(this.e, asVar.e) && com.tencent.bugly.opengame.proguard.l.a(this.f, asVar.f) && com.tencent.bugly.opengame.proguard.l.a(this.g, asVar.g) && com.tencent.bugly.opengame.proguard.l.a(this.h, asVar.h) && com.tencent.bugly.opengame.proguard.l.a(this.j, asVar.j) && com.tencent.bugly.opengame.proguard.l.a(this.k, asVar.k) && com.tencent.bugly.opengame.proguard.l.a(this.l, asVar.l) && com.tencent.bugly.opengame.proguard.l.a(this.i, asVar.i);
    }

    public final int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
