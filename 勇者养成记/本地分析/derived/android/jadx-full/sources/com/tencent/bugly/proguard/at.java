package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class at extends com.tencent.bugly.proguard.k {
    private static java.util.Map<java.lang.String, java.lang.String> i = new java.util.HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f431a = 0;
    public byte b = 0;
    public java.lang.String c = "";
    public java.lang.String d = "";
    public java.lang.String e = "";
    public java.util.Map<java.lang.String, java.lang.String> f = null;
    public java.lang.String g = "";
    public boolean h = true;

    static {
        i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        this.f431a = iVar.a(this.f431a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, false);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = (java.util.Map) iVar.a(i, 5, false);
        this.g = iVar.b(6, false);
        boolean z = this.h;
        this.h = iVar.a(7, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a(this.f431a, 0);
        jVar.a(this.b, 1);
        java.lang.String str = this.c;
        if (str != null) {
            jVar.a(str, 2);
        }
        java.lang.String str2 = this.d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        java.lang.String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.f;
        if (map != null) {
            jVar.a((java.util.Map) map, 5);
        }
        java.lang.String str4 = this.g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.h, 7);
    }
}
