package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class B extends java.lang.Thread {
    public final /* synthetic */ com.tencent.turingfd.sdk.ams.ad.C.a mb;
    public final /* synthetic */ android.content.Context za;

    public B(com.tencent.turingfd.sdk.ams.ad.C.a aVar, android.content.Context context) {
        this.mb = aVar;
        this.za = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mb.Xa.b(this.za);
    }
}
