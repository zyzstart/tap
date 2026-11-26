package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ak extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f380a = "";
    public java.lang.String b = "";
    public java.lang.String c = "";
    private java.lang.String e = "";
    public java.lang.String d = "";

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f380a = iVar.b(0, true);
        this.b = iVar.b(1, false);
        this.c = iVar.b(2, false);
        this.e = iVar.b(3, false);
        this.d = iVar.b(4, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f380a, 0);
        java.lang.String str = this.b;
        if (str != null) {
            jVar.a(str, 1);
        }
        java.lang.String str2 = this.c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        java.lang.String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        java.lang.String str4 = this.d;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
