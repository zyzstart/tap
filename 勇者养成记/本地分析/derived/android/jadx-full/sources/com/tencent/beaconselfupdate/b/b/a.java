package com.tencent.beaconselfupdate.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.beaconselfupdate.d.c implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f243a = "";
    public java.lang.String b = "";
    public java.lang.String c = "";
    public boolean d = true;
    public long e = 0;
    public long f = 0;
    public java.lang.String g = "";
    public long h = 0;
    private int i = 0;

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.a aVar) {
        this.f243a = aVar.a(0, true);
        this.b = aVar.a(1, true);
        this.c = aVar.a(2, true);
        this.d = aVar.a((byte) 0, 3, true) != 0;
        this.e = aVar.a(this.e, 4, true);
        this.f = aVar.a(this.f, 5, true);
        this.g = aVar.a(6, true);
        this.h = aVar.a(this.h, 7, true);
        this.i = aVar.a(this.i, 8, false);
    }

    @Override // com.tencent.beaconselfupdate.d.c
    public final void a(com.tencent.beaconselfupdate.d.b bVar) {
        bVar.a(this.f243a, 0);
        bVar.a(this.b, 1);
        bVar.a(this.c, 2);
        bVar.a(this.d);
        bVar.a(this.e, 4);
        bVar.a(this.f, 5);
        bVar.a(this.g, 6);
        bVar.a(this.h, 7);
        bVar.a(this.i, 8);
    }
}
