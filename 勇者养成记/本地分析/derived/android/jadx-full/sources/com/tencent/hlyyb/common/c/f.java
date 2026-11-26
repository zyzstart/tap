package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f implements com.tencent.hlyyb.common.c.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.c.a f555a;

    f(com.tencent.hlyyb.common.c.a aVar) {
        this.f555a = aVar;
    }

    @Override // com.tencent.hlyyb.common.c.k
    public final void a(boolean z, java.lang.Object obj) {
        com.tencent.hlyyb.common.c.e eVar = (com.tencent.hlyyb.common.c.e) obj;
        eVar.d = z;
        new com.tencent.hlyyb.common.c.d(this.f555a, eVar).a(true);
    }
}
