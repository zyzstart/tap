package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ boolean[] f536a;
    private /* synthetic */ java.util.concurrent.CountDownLatch b;

    o(boolean[] zArr, java.util.concurrent.CountDownLatch countDownLatch) {
        this.f536a = zArr;
        this.b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f536a[0] = com.tencent.hlyyb.common.a.n.b();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.b.countDown();
    }
}
