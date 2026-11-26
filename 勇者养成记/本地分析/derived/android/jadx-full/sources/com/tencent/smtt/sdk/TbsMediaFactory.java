package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsMediaFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f869a;
    private com.tencent.smtt.sdk.s b = null;
    private com.tencent.smtt.export.external.DexLoader c = null;

    public TbsMediaFactory(android.content.Context context) {
        this.f869a = null;
        this.f869a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.f869a == null) {
            android.util.Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.b == null) {
            com.tencent.smtt.sdk.d.a(true).a(this.f869a, false, false);
            com.tencent.smtt.sdk.s sVarA = com.tencent.smtt.sdk.d.a(true).a();
            this.b = sVarA;
            if (sVarA != null) {
                this.c = sVarA.b();
            }
        }
        if (this.b == null || this.c == null) {
            throw new java.lang.RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public com.tencent.smtt.sdk.TbsMediaPlayer createPlayer() {
        com.tencent.smtt.export.external.DexLoader dexLoader;
        if (this.b == null || (dexLoader = this.c) == null) {
            throw new java.lang.RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new com.tencent.smtt.sdk.TbsMediaPlayer(new com.tencent.smtt.sdk.n(dexLoader, this.f869a));
    }
}
