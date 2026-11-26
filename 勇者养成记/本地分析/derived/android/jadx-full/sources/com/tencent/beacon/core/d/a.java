package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f148a;
    protected final int b;
    protected android.content.Context c;
    protected java.lang.String d;
    protected int e;
    protected java.lang.String f;
    protected com.tencent.beacon.core.d.a.InterfaceC0018a g;

    /* JADX INFO: renamed from: com.tencent.beacon.core.d.a$a, reason: collision with other inner class name */
    public interface InterfaceC0018a {
        void a(boolean z);
    }

    public a(android.content.Context context, int i, int i2, java.lang.String str) {
        this.c = context;
        this.f148a = i2;
        this.b = i;
        this.f = str;
    }

    public a(android.content.Context context, int i, int i2, java.lang.String str, com.tencent.beacon.core.d.a.InterfaceC0018a interfaceC0018a) {
        this.c = context;
        this.f148a = i2;
        this.b = i;
        this.f = str;
        this.g = interfaceC0018a;
    }

    public void a() {
        com.tencent.beacon.core.e.d.i("[db] encode failed, clear db data", new java.lang.Object[0]);
    }

    public abstract void a(boolean z);

    public synchronized int b() {
        return this.e;
    }

    public int c() {
        return this.f148a;
    }

    public synchronized java.lang.String d() {
        return this.d;
    }

    public java.lang.String e() {
        return com.tencent.beacon.core.strategy.g.b(this.c).a(this.b);
    }

    public abstract com.tencent.beacon.core.protocol.common.RequestPackage f();
}
