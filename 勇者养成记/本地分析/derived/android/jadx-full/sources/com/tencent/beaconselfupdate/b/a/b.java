package com.tencent.beaconselfupdate.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.beaconselfupdate.d.c {
    private static byte[] m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f241a = 0;
    public java.lang.String b = "";
    public java.lang.String c = "";
    public java.lang.String d = "";
    public java.lang.String e = "";
    public int f = 0;
    public byte[] g = null;
    public byte h = 0;
    public byte i = 0;
    public java.lang.String j = "";
    public java.lang.String k = "";
    public java.lang.String l = "";

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        this.f241a = aVar.a(this.f241a, 0, true);
        this.b = aVar.a(1, true);
        this.c = aVar.a(2, true);
        this.d = aVar.a(3, true);
        this.e = aVar.a(4, true);
        this.f = aVar.a(this.f, 5, true);
        if (m == null) {
            m = new byte[]{0};
        }
        this.g = aVar.b(6, true);
        this.h = aVar.a(this.h, 7, true);
        this.i = aVar.a(this.i, 8, true);
        this.j = aVar.a(9, false);
        this.k = aVar.a(10, false);
        this.l = aVar.a(11, false);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f241a, 0);
        bVar.a(this.b, 1);
        bVar.a(this.c, 2);
        bVar.a(this.d, 3);
        bVar.a(this.e, 4);
        bVar.a(this.f, 5);
        bVar.a(this.g, 6);
        bVar.a(this.h, 7);
        bVar.a(this.i, 8);
        java.lang.String str = this.j;
        if (str != null) {
            bVar.a(str, 9);
        }
        java.lang.String str2 = this.k;
        if (str2 != null) {
            bVar.a(str2, 10);
        }
        java.lang.String str3 = this.l;
        if (str3 != null) {
            bVar.a(str3, 11);
        }
    }
}
