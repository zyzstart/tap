package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class t implements com.unisound.sdk.ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.o f1574a;

    private t(com.unisound.sdk.o oVar) {
        this.f1574a = oVar;
    }

    /* synthetic */ t(com.unisound.sdk.o oVar, com.unisound.sdk.p pVar) {
        this(oVar);
    }

    @Override // com.unisound.sdk.ar
    public void a() {
        this.f1574a.i.b();
        this.f1574a.k.c();
        this.f1574a.m();
    }

    @Override // com.unisound.sdk.ar
    public void a(int i) {
        this.f1574a.i.a(i);
        this.f1574a.b(i);
    }

    @Override // com.unisound.common.ar
    public void a(int i, int i2, java.lang.Object obj) {
        this.f1574a.a(i, i2, obj);
    }

    @Override // com.unisound.sdk.cs
    public void a(cn.yunzhisheng.asr.VAD vad) {
        com.unisound.common.y.c("FixRecognizerInterface onVADTimeout");
        this.f1574a.i.e();
        this.f1574a.a(vad);
    }

    @Override // com.unisound.sdk.ar
    public void a(java.lang.String str, boolean z, int i, int i2) {
        this.f1574a.i.a(str, z);
        this.f1574a.a(str, z, i, i2);
    }

    @Override // com.unisound.sdk.ar
    public void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
        this.f1574a.a(str, z, i, j, j2, i2, i3);
    }

    @Override // com.unisound.common.ac
    public boolean a(android.os.Message message) {
        return this.f1574a.a(message);
    }

    @Override // com.unisound.sdk.ar
    public void b() {
        this.f1574a.n();
    }

    @Override // com.unisound.sdk.cs
    public void b(int i) {
        this.f1574a.i.b(i);
        this.f1574a.c(i);
        this.f1574a.k.a(i);
    }

    @Override // com.unisound.sdk.cs
    public void b(boolean z, byte[] bArr, int i, int i2) {
        this.f1574a.a(z, bArr, i, i2);
    }

    @Override // com.unisound.sdk.ar
    public void c() {
        this.f1574a.i.c();
        this.f1574a.k.b();
        this.f1574a.o();
    }

    @Override // com.unisound.sdk.ar
    public void c(int i) {
    }

    @Override // com.unisound.sdk.ar
    public void d() {
        this.f1574a.p();
    }

    @Override // com.unisound.sdk.ar
    public void d(int i) {
        this.f1574a.a(i);
    }

    @Override // com.unisound.sdk.ar
    public void e() {
        this.f1574a.q();
    }

    @Override // com.unisound.sdk.ar
    public void f() {
        this.f1574a.k();
    }

    @Override // com.unisound.sdk.cs
    public void n() {
        this.f1574a.i.d();
        this.f1574a.i();
    }

    @Override // com.unisound.sdk.cs
    public void o() {
        this.f1574a.j();
    }
}
