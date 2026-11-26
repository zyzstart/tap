package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class k implements com.tencent.yybsdk.apkpatch.c.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.yybsdk.apkpatch.j f1433a;

    k(com.tencent.yybsdk.apkpatch.j jVar) {
        this.f1433a = jVar;
    }

    @Override // com.tencent.yybsdk.apkpatch.c.f
    public void a(int i) {
        this.f1433a.n.m = i;
        if (i == this.f1433a.p.f.o) {
            this.f1433a.n.g = 1;
            this.f1433a.l();
        }
    }

    @Override // com.tencent.yybsdk.apkpatch.c.f
    public void a(int i, java.lang.String str) {
        if (this.f1433a.c() || this.f1433a.h != 0) {
            return;
        }
        this.f1433a.h = i;
        this.f1433a.j = str;
        if (this.f1433a.p.m != null) {
            this.f1433a.p.m.a();
        }
        if (this.f1433a.p.l != null) {
            this.f1433a.p.l.shutdownNow();
        }
        com.tencent.yybsdk.apkpatch.f.a.d(this.f1433a.c, str);
        this.f1433a.e();
    }

    @Override // com.tencent.yybsdk.apkpatch.c.f
    public void b(int i) {
        this.f1433a.n.n = i;
        if (i == this.f1433a.p.f.o) {
            this.f1433a.n.g = 3;
            this.f1433a.q.b(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT);
            if (this.f1433a.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT) != null) {
                com.tencent.yybsdk.apkpatch.f.a.a("cost analysis", "deflate done,cost = " + this.f1433a.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT).c());
            }
            this.f1433a.l();
        }
    }
}
