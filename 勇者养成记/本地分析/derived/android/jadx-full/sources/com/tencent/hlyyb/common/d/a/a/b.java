package com.tencent.hlyyb.common.d.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.d.a.a.a f565a;

    b(com.tencent.hlyyb.common.d.a.a.a aVar) {
        this.f565a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String strB = com.tencent.hlyyb.common.a.f.b();
        com.tencent.hlyyb.common.d.a.a.a aVar = this.f565a;
        com.tencent.hlyyb.common.d.a.a.a.a(aVar, aVar.f564a.a(strB), strB);
    }
}
