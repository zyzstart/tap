package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class E implements android.content.ServiceConnection {
    public final /* synthetic */ long bb;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference cb;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference db;
    public final /* synthetic */ java.lang.Object eb;

    public E(long j, java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.atomic.AtomicReference atomicReference2, java.lang.Object obj) {
        this.bb = j;
        this.cb = atomicReference;
        this.db = atomicReference2;
        this.eb = obj;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.tencent.turingfd.sdk.ams.ad.G.fb = java.lang.System.currentTimeMillis() - this.bb;
        this.cb.set(iBinder);
        this.db.set(this);
        synchronized (this.eb) {
            try {
                this.eb.notifyAll();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
    }
}
