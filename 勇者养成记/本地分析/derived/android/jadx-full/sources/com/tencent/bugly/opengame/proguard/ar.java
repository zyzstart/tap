package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ar extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f387a = "";
    private java.lang.String b = "";

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f387a = iVar.b(0, true);
        this.b = iVar.b(1, true);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f387a, 0);
        jVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
