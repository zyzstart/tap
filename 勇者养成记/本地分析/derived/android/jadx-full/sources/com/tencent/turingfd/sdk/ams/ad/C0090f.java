package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class C0090f implements com.tencent.turingfd.sdk.ams.ad.ITuringDID {
    public final /* synthetic */ com.tencent.turingfd.sdk.ams.ad.InterfaceC0085a s;

    public C0090f(com.tencent.turingfd.sdk.ams.ad.InterfaceC0085a interfaceC0085a) {
        this.s = interfaceC0085a;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public java.lang.String getAIDTicket() {
        return ((com.tencent.turingfd.sdk.ams.ad.r) this.s).xa;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public int getErrorCode() {
        return ((com.tencent.turingfd.sdk.ams.ad.r) this.s).sa;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public java.lang.String getTAID() {
        return ((com.tencent.turingfd.sdk.ams.ad.r) this.s).va;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public java.lang.String getTAIDTicket() {
        return ((com.tencent.turingfd.sdk.ams.ad.r) this.s).wa;
    }
}
