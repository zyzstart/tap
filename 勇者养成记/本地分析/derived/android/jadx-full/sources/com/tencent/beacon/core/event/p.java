package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class p implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.q f175a;

    p(com.tencent.beacon.core.event.q qVar) {
        this.f175a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f175a.b();
    }
}
