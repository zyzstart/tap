package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class I extends java.lang.Thread {
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference nb;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference ob;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference pb;
    public final /* synthetic */ java.lang.Object qb;
    public final /* synthetic */ android.content.Context za;

    public I(java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.atomic.AtomicReference atomicReference2, android.content.Context context, java.util.concurrent.atomic.AtomicReference atomicReference3, java.lang.Object obj) {
        this.nb = atomicReference;
        this.ob = atomicReference2;
        this.za = context;
        this.pb = atomicReference3;
        this.qb = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.tencent.turingfd.sdk.ams.ad.K kA;
        try {
            kA = com.tencent.turingfd.sdk.ams.ad.K.a.a((android.os.IBinder) this.nb.get());
        } catch (java.lang.Throwable unused) {
            this.ob.set(-401);
            kA = null;
        }
        if (kA != null) {
            try {
                java.lang.String packageName = this.za.getPackageName();
                com.tencent.turingfd.sdk.ams.ad.J._a = ((com.tencent.turingfd.sdk.ams.ad.K.a.C0040a) kA).a(packageName, com.tencent.turingfd.sdk.ams.ad.C0086b.a(this.za, packageName, "SHA1"), com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.ba));
            } catch (java.lang.Throwable unused2) {
                this.ob.set(-402);
            }
        }
        try {
            this.za.unbindService((android.content.ServiceConnection) this.pb.get());
        } catch (java.lang.Throwable unused3) {
            this.ob.set(-403);
        }
        synchronized (this.qb) {
            try {
                this.qb.notifyAll();
            } catch (java.lang.Throwable unused4) {
            }
        }
    }
}
