package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b implements com.tencent.mm.opensdk.diffdev.OAuthListener {
    final /* synthetic */ com.tencent.mm.opensdk.diffdev.a.a f;

    b(com.tencent.mm.opensdk.diffdev.a.a aVar) {
        this.f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode, java.lang.String str) {
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", java.lang.String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        com.tencent.mm.opensdk.diffdev.a.a.c(this.f);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.f.c);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(java.lang.String str, byte[] bArr) {
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.f.c);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f.handler != null) {
            this.f.handler.post(new com.tencent.mm.opensdk.diffdev.a.c(this));
        }
    }
}
