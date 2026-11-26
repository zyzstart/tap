package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class al extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f381a = "";
    private java.util.ArrayList b = null;

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f381a = iVar.b(0, true);
        if (c == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            c = arrayList;
            arrayList.add("");
        }
        this.b = (java.util.ArrayList) iVar.a((java.lang.Object) c, 1, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f381a, 0);
        java.util.ArrayList arrayList = this.b;
        if (arrayList != null) {
            jVar.a((java.util.Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
