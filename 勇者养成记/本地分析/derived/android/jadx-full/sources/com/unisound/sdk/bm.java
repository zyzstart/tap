package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bm extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1537a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ java.lang.String d;
    final /* synthetic */ java.lang.String e;
    final /* synthetic */ java.lang.String f;
    final /* synthetic */ com.unisound.sdk.bg g;

    bm(com.unisound.sdk.bg bgVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.g = bgVar;
        this.f1537a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.String str;
        synchronized (this.g.az) {
            int iA = this.g.a(this.f1537a, this.b, this.c, this.d);
            boolean z = true;
            if (iA == 0) {
                if (this.e.equals(com.unisound.sdk.cx.f1560a)) {
                    this.g.aq.sendEmptyMessage(23);
                } else {
                    this.g.aq.sendEmptyMessage(22);
                }
                this.g.b(this.d, this.e, this.f);
                z = false;
            } else {
                if (iA == -102) {
                    this.g.b.a(this.f, false);
                    this.g.b(this.d, this.e, this.f);
                    str = "Compile vocab error: " + iA;
                } else {
                    this.g.b.a(this.f, false);
                    str = "Compile vocab error: " + iA;
                }
                com.unisound.common.y.a(str);
            }
            if (z) {
                if (this.e.equals(com.unisound.sdk.cx.f1560a)) {
                    this.g.r(com.unisound.client.ErrorCode.ASR_SDK_WAKEUP_COMPILE_ERROR);
                } else {
                    this.g.r(com.unisound.client.ErrorCode.ASR_SDK_FIX_COMPILE_ERROR);
                }
            }
        }
    }
}
