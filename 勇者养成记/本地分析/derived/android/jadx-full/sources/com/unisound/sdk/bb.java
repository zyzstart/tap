package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bb implements com.unisound.sdk.bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.az f1528a;

    bb(com.unisound.sdk.az azVar) {
        this.f1528a = azVar;
    }

    @Override // com.unisound.sdk.bz
    public void a() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 104);
    }

    @Override // com.unisound.sdk.bz
    public void a(int i) {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 107);
        this.f1528a.i = com.unisound.client.SpeechConstants.TTS_STATUS_END;
    }

    @Override // com.unisound.sdk.bz
    public void a(boolean z) {
        if (this.f1528a.c != null) {
            this.f1528a.c.b(z);
        }
    }

    @Override // com.unisound.sdk.bz
    public void b() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 105);
    }

    @Override // com.unisound.sdk.bz
    public void b(int i) {
        com.unisound.sdk.az.sendMsg(this.f1528a.p, 212, com.unisound.client.ErrorCode.toJsonMessage(i));
    }

    @Override // com.unisound.sdk.bz
    public void c() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 106);
        this.f1528a.i = com.unisound.client.SpeechConstants.TTS_STATUS_PLAYING;
    }

    @Override // com.unisound.sdk.bz
    public void d() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 110);
    }

    @Override // com.unisound.sdk.bz
    public void e() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 108);
        this.f1528a.i = com.unisound.client.SpeechConstants.TTS_STATUS_PAUSE;
    }

    @Override // com.unisound.sdk.bz
    public void f() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 109);
    }

    @Override // com.unisound.sdk.bz
    public void g() {
        com.unisound.sdk.az.sendEmptyMsg(this.f1528a.p, 111);
    }
}
