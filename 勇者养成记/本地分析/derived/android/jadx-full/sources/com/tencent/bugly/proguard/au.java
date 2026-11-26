package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class au extends com.tencent.bugly.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList<com.tencent.bugly.proguard.at> f;
    private static java.util.Map<java.lang.String, java.lang.String> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f432a = 0;
    public java.lang.String b = "";
    public java.lang.String c = "";
    public java.util.ArrayList<com.tencent.bugly.proguard.at> d = null;
    public java.util.Map<java.lang.String, java.lang.String> e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        this.f432a = iVar.a(this.f432a, 0, true);
        this.b = iVar.b(1, false);
        this.c = iVar.b(2, false);
        if (f == null) {
            f = new java.util.ArrayList<>();
            f.add(new com.tencent.bugly.proguard.at());
        }
        this.d = (java.util.ArrayList) iVar.a(f, 3, false);
        if (g == null) {
            g = new java.util.HashMap();
            g.put("", "");
        }
        this.e = (java.util.Map) iVar.a(g, 4, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a(this.f432a, 0);
        java.lang.String str = this.b;
        if (str != null) {
            jVar.a(str, 1);
        }
        java.lang.String str2 = this.c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        java.util.ArrayList<com.tencent.bugly.proguard.at> arrayList = this.d;
        if (arrayList != null) {
            jVar.a((java.util.Collection) arrayList, 3);
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.e;
        if (map != null) {
            jVar.a((java.util.Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
