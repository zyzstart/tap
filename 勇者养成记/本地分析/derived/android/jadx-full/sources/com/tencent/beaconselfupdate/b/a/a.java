package com.tencent.beaconselfupdate.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.beaconselfupdate.d.c implements java.lang.Cloneable {
    private static java.util.Map b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.Map f240a = null;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        if (b == null) {
            b = new java.util.HashMap();
            b.put(0, new byte[]{0});
        }
        this.f240a = (java.util.Map) aVar.a((java.lang.Object) b, 0, true);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f240a, 0);
    }
}
