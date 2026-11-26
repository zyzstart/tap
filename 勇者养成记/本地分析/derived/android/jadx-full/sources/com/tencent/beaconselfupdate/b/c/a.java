package com.tencent.beaconselfupdate.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.beaconselfupdate.d.c {
    private static java.util.ArrayList e;
    private static java.util.Map f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.ArrayList f245a = null;
    public int b = 0;
    public java.lang.String c = "";
    public java.util.Map d = null;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        if (e == null) {
            e = new java.util.ArrayList();
            e.add(new com.tencent.beaconselfupdate.b.c.b());
        }
        this.f245a = (java.util.ArrayList) aVar.a((java.lang.Object) e, 0, true);
        this.b = aVar.a(this.b, 1, true);
        this.c = aVar.a(2, true);
        if (f == null) {
            java.util.HashMap map = new java.util.HashMap();
            f = map;
            map.put("", "");
        }
        this.d = (java.util.Map) aVar.a((java.lang.Object) f, 3, false);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a((java.util.Collection) this.f245a, 0);
        bVar.a(this.b, 1);
        bVar.a(this.c, 2);
        java.util.Map map = this.d;
        if (map != null) {
            bVar.a(map, 3);
        }
    }
}
