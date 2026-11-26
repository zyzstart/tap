package com.tencent.beaconselfupdate.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.beaconselfupdate.d.c {
    private static java.util.Map g;
    private static java.util.ArrayList h;
    private static java.util.ArrayList i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f246a = 0;
    public byte b = 0;
    public java.lang.String c = "";
    public java.util.Map d = null;
    public java.util.ArrayList e = null;
    public java.util.ArrayList f = null;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        this.f246a = aVar.a(this.f246a, 0, true);
        this.b = aVar.a(this.b, 1, true);
        this.c = aVar.a(2, true);
        if (g == null) {
            java.util.HashMap map = new java.util.HashMap();
            g = map;
            map.put("", "");
        }
        this.d = (java.util.Map) aVar.a((java.lang.Object) g, 3, true);
        if (h == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            h = arrayList;
            arrayList.add("");
        }
        this.e = (java.util.ArrayList) aVar.a((java.lang.Object) h, 4, false);
        if (i == null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            i = arrayList2;
            arrayList2.add("");
        }
        this.f = (java.util.ArrayList) aVar.a((java.lang.Object) i, 6, false);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f246a, 0);
        bVar.a(this.b, 1);
        bVar.a(this.c, 2);
        bVar.a(this.d, 3);
        java.util.ArrayList arrayList = this.e;
        if (arrayList != null) {
            bVar.a((java.util.Collection) arrayList, 4);
        }
        java.util.ArrayList arrayList2 = this.f;
        if (arrayList2 != null) {
            bVar.a((java.util.Collection) arrayList2, 6);
        }
    }
}
