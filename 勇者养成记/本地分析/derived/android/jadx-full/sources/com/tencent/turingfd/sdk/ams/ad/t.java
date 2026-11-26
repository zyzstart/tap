package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class t implements java.lang.Runnable {
    public final /* synthetic */ boolean Aa;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference Ba;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference Ca;
    public final /* synthetic */ java.lang.Object Da;
    public final /* synthetic */ com.tencent.turingfd.sdk.ams.ad.u this$0;
    public final /* synthetic */ android.content.Context za;

    public t(com.tencent.turingfd.sdk.ams.ad.u uVar, android.content.Context context, boolean z, java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.atomic.AtomicReference atomicReference2, java.lang.Object obj) {
        this.this$0 = uVar;
        this.za = context;
        this.Aa = z;
        this.Ba = atomicReference;
        this.Ca = atomicReference2;
        this.Da = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.this$0.Fa.d(); i++) {
            com.tencent.turingfd.sdk.ams.ad.r rVarA = com.tencent.turingfd.sdk.ams.ad.u.a(this.this$0, this.za, this.Aa);
            this.Ba.set(rVarA);
            if (rVarA.sa == 0 || ((java.lang.Boolean) this.Ca.get()).booleanValue()) {
                break;
            }
        }
        synchronized (this.Da) {
            this.Da.notifyAll();
        }
    }
}
