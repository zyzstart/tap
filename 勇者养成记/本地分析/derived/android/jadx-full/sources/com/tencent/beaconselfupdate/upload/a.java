package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f268a;
    protected final int b;
    protected android.content.Context c;
    protected java.lang.String d;

    public a(android.content.Context context, int i, int i2) {
        this.c = context;
        this.f268a = i2;
        this.b = i;
    }

    public static com.tencent.beaconselfupdate.b.a.b a(int i, byte[] bArr) {
        try {
            return com.tencent.beaconselfupdate.a.e.a(i, com.tencent.beaconselfupdate.a.c.m(), bArr, 2, 3);
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.c("imposiable comStrategy error:%s", th.toString());
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }

    public abstract com.tencent.beaconselfupdate.b.a.b a();

    public void b() {
        com.tencent.beaconselfupdate.c.a.c("encode failed, clear db data", new java.lang.Object[0]);
    }

    public abstract void b(boolean z);

    public final int c() {
        return this.f268a;
    }

    public final synchronized java.lang.String d() {
        return this.d;
    }

    public final java.lang.String e() {
        try {
            return this.b == 0 ? com.tencent.beaconselfupdate.a.b.b.a(this.c).e().b() : com.tencent.beaconselfupdate.a.b.b.a(this.c).e().b(this.b).b();
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.c("imposiable comStrategy error:%s", th.toString());
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }
}
