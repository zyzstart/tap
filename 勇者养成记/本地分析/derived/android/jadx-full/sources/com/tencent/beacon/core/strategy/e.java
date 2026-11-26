package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f190a;
    final /* synthetic */ com.tencent.beacon.core.strategy.g b;

    e(com.tencent.beacon.core.strategy.g gVar, android.content.Context context) {
        this.b = gVar;
        this.f190a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.content.Context context = this.f190a;
        if (context != null) {
            this.b.a(context);
        }
    }
}
