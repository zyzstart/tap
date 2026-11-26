package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class m implements com.tencent.yybsdk.apkpatch.bsdiff.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1435a = -1;
    int b = 0;
    final /* synthetic */ com.tencent.yybsdk.apkpatch.j c;

    m(com.tencent.yybsdk.apkpatch.j jVar) {
        this.c = jVar;
    }

    @Override // com.tencent.yybsdk.apkpatch.bsdiff.b
    public void a(int i) {
        if (this.f1435a == -1) {
            this.c.q.a(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT);
            com.tencent.yybsdk.apkpatch.f.a.a("cost analysis", "deflate begin,time = " + this.c.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT).a());
        }
        int i2 = this.f1435a + 1;
        while (i2 <= i) {
            com.tencent.yybsdk.apkpatch.e eVar = (com.tencent.yybsdk.apkpatch.e) this.c.p.k.get(i2);
            int i3 = eVar.c;
            i2++;
            if (i2 > this.c.n.n) {
                com.tencent.yybsdk.apkpatch.c.a aVar = new com.tencent.yybsdk.apkpatch.c.a(this.b, eVar.f1411a, eVar.b, i3, eVar.d);
                aVar.a(this.c.p.n);
                aVar.a(this.c.r);
                try {
                    this.c.p.l.execute(aVar);
                } catch (java.lang.OutOfMemoryError e) {
                    this.c.r.a(-60, "deflate OOM," + com.tencent.yybsdk.apkpatch.f.a.a(e));
                }
            } else {
                this.c.p.l.c();
            }
            this.b += i3;
        }
        this.f1435a = i;
    }

    @Override // com.tencent.yybsdk.apkpatch.bsdiff.b
    public boolean a(int i, int i2, int i3, int i4) {
        this.c.n.j = i;
        this.c.n.k = i3;
        this.c.n.l = i4;
        int i5 = i2 / 3;
        if (i != i5 && i != i5 * 2) {
            if (i != i2) {
                return true;
            }
            this.c.n.g = 2;
            this.c.q.b(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION);
            this.c.b.s = (int) new java.io.File(this.c.o.d()).length();
            com.tencent.yybsdk.apkpatch.f.b.a(this.c.o.c());
            com.tencent.yybsdk.apkpatch.f.a.a("cost analysis", "bspatch done,cost = " + this.c.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION).c());
        }
        return this.c.l();
    }
}
