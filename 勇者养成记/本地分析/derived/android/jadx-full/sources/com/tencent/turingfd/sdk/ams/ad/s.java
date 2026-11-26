package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s extends java.lang.Thread {
    public final /* synthetic */ com.tencent.turingfd.sdk.ams.ad.u this$0;

    public s(com.tencent.turingfd.sdk.ams.ad.u uVar) {
        this.this$0 = uVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            java.lang.Thread.sleep(5000L);
        } catch (java.lang.InterruptedException unused) {
        }
        com.tencent.turingfd.sdk.ams.ad.u uVar = this.this$0;
        uVar.e(uVar.Fa.getContext());
    }
}
