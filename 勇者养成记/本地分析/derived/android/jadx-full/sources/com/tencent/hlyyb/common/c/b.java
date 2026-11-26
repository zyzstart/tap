package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.c.a f551a;

    private b(com.tencent.hlyyb.common.c.a aVar) {
        this.f551a = aVar;
    }

    /* synthetic */ b(com.tencent.hlyyb.common.c.a aVar, byte b) {
        this(aVar);
    }

    public final void a(boolean z) {
        if (!z) {
            this.f551a.d.post(this);
        } else {
            if (this.f551a.d.postAtFrontOfQueue(this)) {
                return;
            }
            this.f551a.d.post(this);
        }
    }
}
