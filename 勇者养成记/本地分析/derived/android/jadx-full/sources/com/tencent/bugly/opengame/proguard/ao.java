package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ao extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.ArrayList f384a = null;

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        if (b == null) {
            b = new java.util.ArrayList();
            b.add(new com.tencent.bugly.opengame.proguard.an());
        }
        this.f384a = (java.util.ArrayList) iVar.a((java.lang.Object) b, 0, true);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a((java.util.Collection) this.f384a, 0);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
