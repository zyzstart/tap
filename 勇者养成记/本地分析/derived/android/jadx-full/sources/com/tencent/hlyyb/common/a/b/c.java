package com.tencent.hlyyb.common.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ java.lang.String f527a;
    private /* synthetic */ int b;
    private /* synthetic */ int c;
    private /* synthetic */ java.lang.String d;
    private /* synthetic */ java.util.Map e;
    private /* synthetic */ java.util.Map f;
    private /* synthetic */ boolean g;

    c(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z) {
        this.f527a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = map;
        this.f = map2;
        this.g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.hlyyb.common.a.b.a.a(this.f527a, this.b, this.c, this.d, this.e, this.f, this.g, true);
    }
}
