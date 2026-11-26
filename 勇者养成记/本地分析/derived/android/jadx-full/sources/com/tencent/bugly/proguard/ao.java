package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ao extends com.tencent.bugly.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList<com.tencent.bugly.proguard.an> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.ArrayList<com.tencent.bugly.proguard.an> f426a = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        if (b == null) {
            b = new java.util.ArrayList<>();
            b.add(new com.tencent.bugly.proguard.an());
        }
        this.f426a = (java.util.ArrayList) iVar.a(b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a((java.util.Collection) this.f426a, 0);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
