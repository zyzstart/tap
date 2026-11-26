package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ap implements com.unisound.sdk.ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.ao f1520a;

    ap(com.unisound.sdk.ao aoVar) {
        this.f1520a = aoVar;
    }

    @Override // com.unisound.sdk.ag
    public void a() throws java.lang.Throwable {
        com.unisound.common.y.a("NetRecognizer timeout(" + this.f1520a.q.a() + ")");
        com.unisound.common.y.c("Ontimer:cancelRecognition()");
        this.f1520a.d(true);
        if (this.f1520a.i != null) {
            this.f1520a.i.b(com.unisound.client.ErrorCode.RECOGNITION_TIMEOUT);
        }
    }
}
