package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.c.a f558a;

    i(com.tencent.hlyyb.common.c.a aVar) {
        this.f558a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f558a.a(false, true);
    }
}
