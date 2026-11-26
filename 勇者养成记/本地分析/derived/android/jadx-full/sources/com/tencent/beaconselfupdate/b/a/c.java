package com.tencent.beaconselfupdate.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c extends com.tencent.beaconselfupdate.d.c {
    private static byte[] j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f242a = 0;
    public int b = 0;
    public byte[] c = null;
    public java.lang.String d = "";
    private byte f = 0;
    private byte g = 0;
    public long e = 0;
    private java.lang.String h = "";
    private java.lang.String i = "";

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        this.f242a = aVar.a(this.f242a, 0, true);
        this.b = aVar.a(this.b, 1, true);
        if (j == null) {
            j = new byte[]{0};
        }
        this.c = aVar.b(2, true);
        this.d = aVar.a(3, true);
        this.f = aVar.a(this.f, 4, true);
        this.g = aVar.a(this.g, 5, true);
        this.e = aVar.a(this.e, 6, true);
        this.h = aVar.a(7, false);
        this.i = aVar.a(8, false);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f242a, 0);
        bVar.a(this.b, 1);
        bVar.a(this.c, 2);
        bVar.a(this.d, 3);
        bVar.a(this.f, 4);
        bVar.a(this.g, 5);
        bVar.a(this.e, 6);
        java.lang.String str = this.h;
        if (str != null) {
            bVar.a(str, 7);
        }
        java.lang.String str2 = this.i;
        if (str2 != null) {
            bVar.a(str2, 8);
        }
    }
}
