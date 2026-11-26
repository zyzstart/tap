package com.tencent.hlyyb.common.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f529a;
    private java.util.Map b = new java.util.HashMap();

    public a(java.lang.String str) {
        this.f529a = str;
    }

    public final java.lang.String a() {
        return this.f529a;
    }

    public final void a(com.tencent.hlyyb.common.a.c.b bVar) {
        this.b.put(bVar.f530a, bVar);
    }

    public final java.util.Map b() {
        return this.b;
    }
}
