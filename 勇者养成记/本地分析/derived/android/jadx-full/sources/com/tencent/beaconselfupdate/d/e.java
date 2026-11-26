package com.tencent.beaconselfupdate.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e extends com.tencent.beaconselfupdate.d.c {
    private static byte[] k;
    private static java.util.Map l;
    public byte[] e;
    private java.util.Map i;
    private java.util.Map j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f252a = 3;
    private byte f = 0;
    private int g = 0;
    public int b = 0;
    public java.lang.String c = null;
    public java.lang.String d = null;
    private int h = 0;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        try {
            this.f252a = aVar.a(this.f252a, 1, true);
            this.f = aVar.a(this.f, 2, true);
            this.g = aVar.a(this.g, 3, true);
            this.b = aVar.a(this.b, 4, true);
            this.c = aVar.a(5, true);
            this.d = aVar.a(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            this.e = aVar.b(7, true);
            this.h = aVar.a(this.h, 8, true);
            if (l == null) {
                java.util.HashMap map = new java.util.HashMap();
                l = map;
                map.put("", "");
            }
            this.i = (java.util.Map) aVar.a((java.lang.Object) l, 9, true);
            if (l == null) {
                java.util.HashMap map2 = new java.util.HashMap();
                l = map2;
                map2.put("", "");
            }
            this.j = (java.util.Map) aVar.a((java.lang.Object) l, 10, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f252a, 1);
        bVar.a(this.f, 2);
        bVar.a(this.g, 3);
        bVar.a(this.b, 4);
        bVar.a(this.c, 5);
        bVar.a(this.d, 6);
        bVar.a(this.e, 7);
        bVar.a(this.h, 8);
        bVar.a(this.i, 9);
        bVar.a(this.j, 10);
    }
}
