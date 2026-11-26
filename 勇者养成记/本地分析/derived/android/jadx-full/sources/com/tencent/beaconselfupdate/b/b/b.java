package com.tencent.beaconselfupdate.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.beaconselfupdate.d.c implements java.lang.Cloneable {
    private static java.util.ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.ArrayList f244a = null;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        if (b == null) {
            b = new java.util.ArrayList();
            b.add(new com.tencent.beaconselfupdate.b.b.a());
        }
        this.f244a = (java.util.ArrayList) aVar.a((java.lang.Object) b, 0, true);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a((java.util.Collection) this.f244a, 0);
    }
}
