package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ar extends com.tencent.bugly.proguard.k implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f429a = "";
    private java.lang.String b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        this.f429a = iVar.b(0, true);
        this.b = iVar.b(1, true);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a(this.f429a, 0);
        jVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
