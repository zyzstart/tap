package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ba implements com.unisound.sdk.ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.az f1527a;

    ba(com.unisound.sdk.az azVar) {
        this.f1527a = azVar;
    }

    @Override // com.unisound.sdk.ca
    public void a() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1527a.p, 102);
        this.f1527a.i = com.unisound.client.SpeechConstants.TTS_STATUS_SYNTHESIZERING;
    }

    @Override // com.unisound.sdk.ca
    public void a(int i) {
        com.unisound.sdk.az.sendMsg(this.f1527a.p, 210, com.unisound.client.ErrorCode.toJsonMessage(i));
    }

    @Override // com.unisound.sdk.ca
    public void a(java.lang.String str) {
        this.f1527a.b(str);
    }

    @Override // com.unisound.sdk.ca
    public void a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        if (this.f1527a.e != null) {
            this.f1527a.e.a(bArr2);
        }
    }

    @Override // com.unisound.sdk.ca
    public void b() {
        this.f1527a.u = false;
        if (this.f1527a.e != null) {
            this.f1527a.e.h();
            com.unisound.sdk.az.sendEmptyMsg(this.f1527a.p, 103);
        }
    }

    @Override // com.unisound.sdk.ca
    public void c() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1527a.p, 112);
    }
}
