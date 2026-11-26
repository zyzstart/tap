package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class au extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList f;
    private static java.util.Map g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f390a = 0;
    public java.lang.String b = "";
    public java.lang.String c = "";
    public java.util.ArrayList d = null;
    public java.util.Map e = null;

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f390a = iVar.a(this.f390a, 0, true);
        this.b = iVar.b(1, false);
        this.c = iVar.b(2, false);
        if (f == null) {
            f = new java.util.ArrayList();
            f.add(new com.tencent.bugly.opengame.proguard.at());
        }
        this.d = (java.util.ArrayList) iVar.a((java.lang.Object) f, 3, false);
        if (g == null) {
            java.util.HashMap map = new java.util.HashMap();
            g = map;
            map.put("", "");
        }
        this.e = (java.util.Map) iVar.a((java.lang.Object) g, 4, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f390a, 0);
        java.lang.String str = this.b;
        if (str != null) {
            jVar.a(str, 1);
        }
        java.lang.String str2 = this.c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        java.util.ArrayList arrayList = this.d;
        if (arrayList != null) {
            jVar.a((java.util.Collection) arrayList, 3);
        }
        java.util.Map map = this.e;
        if (map != null) {
            jVar.a(map, 4);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
