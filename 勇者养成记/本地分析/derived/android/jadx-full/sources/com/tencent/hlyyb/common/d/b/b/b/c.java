package com.tencent.hlyyb.common.d.b.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ java.lang.String f577a;
    private /* synthetic */ byte[] b;
    private /* synthetic */ com.tencent.hlyyb.common.d.b.b.b.b c;

    c(com.tencent.hlyyb.common.d.b.b.b.b bVar, java.lang.String str, byte[] bArr) {
        this.c = bVar;
        this.f577a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String strB = this.f577a;
        byte[] bArrA = this.b;
        if (com.tencent.hlyyb.common.f.c.a(strB) || com.tencent.hlyyb.common.f.c.a(bArrA)) {
            com.tencent.hlyyb.common.a.f.e();
            strB = com.tencent.hlyyb.common.a.f.b();
            bArrA = this.c.f576a.a(strB);
        }
        com.tencent.hlyyb.common.d.b.b.c.c().d().a(strB, bArrA, null);
    }
}
