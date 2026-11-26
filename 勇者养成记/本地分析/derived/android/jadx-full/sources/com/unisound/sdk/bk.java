package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bk extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1535a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.unisound.sdk.bg d;

    bk(com.unisound.sdk.bg bgVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.d = bgVar;
        this.f1535a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.d.az) {
            int iA = this.d.f.a(this.f1535a, this.b, this.c);
            com.unisound.common.y.c("SpeechUnderstanderInterface : insertVocab_ext -> inserVocabResult = ", java.lang.Integer.valueOf(iA));
            if (iA == 0) {
                this.d.aq.sendEmptyMessage(21);
            } else {
                com.unisound.common.y.a("SpeechUnderstanderInterface : insertVocab_ext error ");
                this.d.r(com.unisound.client.ErrorCode.ASR_SDK_FIX_INSERTVOCAB_EXT_ERROR);
            }
        }
    }
}
