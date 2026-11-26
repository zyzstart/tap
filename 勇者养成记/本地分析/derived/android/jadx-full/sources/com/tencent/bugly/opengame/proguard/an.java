package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class an extends com.tencent.bugly.opengame.proguard.k {
    private static java.util.ArrayList A;
    private static java.util.Map B;
    private static java.util.Map C;
    private static java.util.Map v;
    private static com.tencent.bugly.opengame.proguard.al w;
    private static com.tencent.bugly.opengame.proguard.ak x;
    private static java.util.ArrayList y;
    private static java.util.ArrayList z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f383a = "";
    public long b = 0;
    public java.lang.String c = "";
    public java.lang.String d = "";
    public java.lang.String e = "";
    public java.lang.String f = "";
    public java.lang.String g = "";
    public java.util.Map h = null;
    public java.lang.String i = "";
    public com.tencent.bugly.opengame.proguard.al j = null;
    public int k = 0;
    public java.lang.String l = "";
    public java.lang.String m = "";
    public com.tencent.bugly.opengame.proguard.ak n = null;
    public java.util.ArrayList o = null;
    public java.util.ArrayList p = null;
    public java.util.ArrayList q = null;
    public java.util.Map r = null;
    public java.util.Map s = null;
    public java.lang.String t = "";
    private boolean u = true;

    static {
        java.util.HashMap map = new java.util.HashMap();
        v = map;
        map.put("", "");
        w = new com.tencent.bugly.opengame.proguard.al();
        x = new com.tencent.bugly.opengame.proguard.ak();
        y = new java.util.ArrayList();
        y.add(new com.tencent.bugly.opengame.proguard.ak());
        z = new java.util.ArrayList();
        z.add(new com.tencent.bugly.opengame.proguard.ak());
        A = new java.util.ArrayList();
        A.add(new com.tencent.bugly.opengame.proguard.am());
        java.util.HashMap map2 = new java.util.HashMap();
        B = map2;
        map2.put("", "");
        java.util.HashMap map3 = new java.util.HashMap();
        C = map3;
        map3.put("", "");
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f383a = iVar.b(0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, true);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = iVar.b(5, false);
        this.g = iVar.b(6, false);
        this.h = (java.util.Map) iVar.a((java.lang.Object) v, 7, false);
        this.i = iVar.b(8, false);
        this.j = (com.tencent.bugly.opengame.proguard.al) iVar.a((com.tencent.bugly.opengame.proguard.k) w, 9, false);
        this.k = iVar.a(this.k, 10, false);
        this.l = iVar.b(11, false);
        this.m = iVar.b(12, false);
        this.n = (com.tencent.bugly.opengame.proguard.ak) iVar.a((com.tencent.bugly.opengame.proguard.k) x, 13, false);
        this.o = (java.util.ArrayList) iVar.a((java.lang.Object) y, 14, false);
        this.p = (java.util.ArrayList) iVar.a((java.lang.Object) z, 15, false);
        this.q = (java.util.ArrayList) iVar.a((java.lang.Object) A, 16, false);
        this.r = (java.util.Map) iVar.a((java.lang.Object) B, 17, false);
        this.s = (java.util.Map) iVar.a((java.lang.Object) C, 18, false);
        this.t = iVar.b(19, false);
        this.u = iVar.a(20, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f383a, 0);
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
        java.lang.String str3 = this.f;
        if (str3 != null) {
            jVar.a(str3, 5);
        }
        java.lang.String str4 = this.g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        java.util.Map map = this.h;
        if (map != null) {
            jVar.a(map, 7);
        }
        java.lang.String str5 = this.i;
        if (str5 != null) {
            jVar.a(str5, 8);
        }
        com.tencent.bugly.opengame.proguard.al alVar = this.j;
        if (alVar != null) {
            jVar.a((com.tencent.bugly.opengame.proguard.k) alVar, 9);
        }
        jVar.a(this.k, 10);
        java.lang.String str6 = this.l;
        if (str6 != null) {
            jVar.a(str6, 11);
        }
        java.lang.String str7 = this.m;
        if (str7 != null) {
            jVar.a(str7, 12);
        }
        com.tencent.bugly.opengame.proguard.ak akVar = this.n;
        if (akVar != null) {
            jVar.a((com.tencent.bugly.opengame.proguard.k) akVar, 13);
        }
        java.util.ArrayList arrayList = this.o;
        if (arrayList != null) {
            jVar.a((java.util.Collection) arrayList, 14);
        }
        java.util.ArrayList arrayList2 = this.p;
        if (arrayList2 != null) {
            jVar.a((java.util.Collection) arrayList2, 15);
        }
        java.util.ArrayList arrayList3 = this.q;
        if (arrayList3 != null) {
            jVar.a((java.util.Collection) arrayList3, 16);
        }
        java.util.Map map2 = this.r;
        if (map2 != null) {
            jVar.a(map2, 17);
        }
        java.util.Map map3 = this.s;
        if (map3 != null) {
            jVar.a(map3, 18);
        }
        java.lang.String str8 = this.t;
        if (str8 != null) {
            jVar.a(str8, 19);
        }
        jVar.a(this.u, 20);
    }
}
