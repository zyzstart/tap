package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class al extends com.tencent.bugly.proguard.k implements java.lang.Cloneable {
    private static java.util.ArrayList<java.lang.String> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f423a = "";
    private java.util.ArrayList<java.lang.String> b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        this.f423a = iVar.b(0, true);
        if (c == null) {
            c = new java.util.ArrayList<>();
            c.add("");
        }
        this.b = (java.util.ArrayList) iVar.a(c, 1, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a(this.f423a, 0);
        java.util.ArrayList<java.lang.String> arrayList = this.b;
        if (arrayList != null) {
            jVar.a((java.util.Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
