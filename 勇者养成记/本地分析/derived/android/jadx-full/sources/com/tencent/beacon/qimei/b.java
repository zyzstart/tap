package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.qimei.e f208a;

    b(com.tencent.beacon.qimei.e eVar) {
        this.f208a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.core.e.d.a("[qimei] start query qimei", new java.lang.Object[0]);
        com.tencent.beacon.core.d.k.a(this.f208a.c).a(new com.tencent.beacon.qimei.g(this.f208a.c, com.tencent.beacon.core.info.b.b(this.f208a.c).a(), null));
    }
}
