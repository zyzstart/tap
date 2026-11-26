package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ao extends com.unisound.common.ab implements com.unisound.sdk.ak, com.unisound.sdk.au, com.unisound.sdk.cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1519a = 0;
    public static int b = 0;
    private static final int r = 40;
    protected com.unisound.common.av c;
    private com.unisound.common.au d;
    private com.unisound.sdk.ay e;
    private com.unisound.sdk.ay f;
    private com.unisound.sdk.an g;
    private com.unisound.sdk.z h;
    private com.unisound.sdk.ad i;
    private com.unisound.sdk.as j;
    private java.lang.String k;
    private boolean l;
    private android.content.Context m;
    private com.unisound.sdk.aa n;
    private android.os.Looper o;
    private com.unisound.sdk.ag p;
    private com.unisound.sdk.af q;

    static {
        java.lang.System.loadLibrary("uscasr");
        f1519a = com.youme.im.CommonConst.SPEECH_DURATION_MAX;
        b = 10000;
    }

    public ao(com.unisound.sdk.as asVar) {
        this.d = new com.unisound.common.au();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = "";
        this.l = true;
        this.n = null;
        this.p = new com.unisound.sdk.ap(this);
        this.c = null;
        this.j = asVar;
    }

    public ao(com.unisound.sdk.as asVar, android.os.Looper looper) {
        super(looper);
        this.d = new com.unisound.common.au();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = "";
        this.l = true;
        this.n = null;
        this.p = new com.unisound.sdk.ap(this);
        this.c = null;
        this.j = asVar;
        this.o = looper;
        this.q = new com.unisound.sdk.af(this.p, looper);
    }

    private void d(java.lang.String str) throws java.lang.Throwable {
        com.unisound.common.y.c("Before startNetRecognition :cancelRecognition()");
        d(false);
        this.j.aW = this.d.a();
        try {
            this.j.aZ = com.unisound.c.a.b();
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("NetRecognizer:: getNetType error");
        }
        this.e = this.f;
        this.c = null;
        this.l = false;
        this.k = "";
        this.g = new com.unisound.sdk.an(this.j, this.m, str);
        this.g.a(this);
        this.g.setPriority(10);
        this.g.setName("usc_net_thread");
        if (!this.j.A()) {
            this.g.start();
        }
        com.unisound.common.y.c("NetRecognizer:: recognitionThread start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) throws java.lang.Throwable {
        com.unisound.sdk.an anVar = this.g;
        if (anVar == null || anVar.d()) {
            return;
        }
        this.g.c();
    }

    private void f(int i) {
        if (i == 0) {
            this.c = new com.unisound.common.av(this.j.aY, this.d.a());
        }
        this.l = true;
        this.k = "";
        com.unisound.sdk.an anVar = this.g;
        if (anVar != null) {
            this.k = anVar.e();
        }
        if (this.q.b()) {
            return;
        }
        this.q.e();
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.b(i);
        }
    }

    private void r() {
        com.unisound.common.y.c("NetRecognizer stopRecording");
        this.l = true;
        com.unisound.sdk.z zVar = this.h;
        if (zVar != null) {
            zVar.d();
        }
    }

    private void s() throws java.lang.Throwable {
        this.l = true;
        com.unisound.sdk.an anVar = this.g;
        if (anVar == null || anVar.a()) {
            return;
        }
        this.g.b();
        this.q.c();
    }

    private void t() {
        com.unisound.sdk.z zVar = this.h;
        if (zVar != null) {
            zVar.g();
        }
    }

    @Override // com.unisound.sdk.ak
    public void A() {
        sendMessage(40);
    }

    public java.lang.String a() {
        return com.unisound.common.an.a();
    }

    @Override // com.unisound.sdk.ak
    public void a(int i) {
        r();
        t();
        f(i);
    }

    @Override // com.unisound.common.ar
    public void a(int i, int i2, java.lang.Object obj) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.a(i, i2, obj);
        }
    }

    public void a(android.content.Context context, com.unisound.sdk.ad adVar) {
        this.m = context;
        a(adVar);
        com.unisound.c.a.a(context);
    }

    public void a(android.util.SparseArray<java.util.List<java.lang.String>> sparseArray) {
        com.unisound.sdk.cq cqVar = new com.unisound.sdk.cq();
        cqVar.a(this);
        cqVar.a(this.j.aZ(), sparseArray);
    }

    @Override // com.unisound.sdk.cs
    public void a(cn.yunzhisheng.asr.VAD vad) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.b();
        }
    }

    public void a(com.unisound.sdk.ad adVar) {
        this.i = adVar;
    }

    @Override // com.unisound.sdk.ak
    public void a(com.unisound.sdk.al alVar) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.a(alVar);
        }
    }

    public void a(com.unisound.sdk.ay ayVar) {
        this.f = ayVar;
        this.e = ayVar;
    }

    public void a(com.unisound.sdk.z zVar, boolean z, java.lang.String str, com.unisound.sdk.aa aaVar) throws java.lang.Throwable {
        this.q.d();
        d(str);
        if (z) {
            this.n = aaVar;
            this.h = zVar;
            this.h.setPriority(10);
            this.h.start();
        }
    }

    public void a(java.lang.String str) {
        com.unisound.sdk.cq cqVar = new com.unisound.sdk.cq();
        cqVar.a(this);
        cqVar.a(this.j.aZ(), str);
    }

    public void a(java.lang.String str, int i) {
        this.j.a(new java.lang.String(str), i);
    }

    @Override // com.unisound.sdk.ak
    public void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
    }

    public void a(java.util.List<byte[]> list, java.lang.String str) throws java.lang.Throwable {
        d(str);
        this.g.a(list);
        this.g.b();
    }

    public void a(java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> map) {
        com.unisound.sdk.cq cqVar = new com.unisound.sdk.cq();
        cqVar.a(this);
        cqVar.a(this.j.aZ(), map);
    }

    public void a(boolean z) {
        this.j.K(z);
    }

    @Override // com.unisound.sdk.au
    public void a(boolean z, byte[] bArr, int i, int i2) {
        com.unisound.sdk.aa aaVar = this.n;
        if (aaVar != null) {
            aaVar.a(bArr);
        }
    }

    @Override // com.unisound.common.ab
    public boolean a(android.os.Message message) {
        return true;
    }

    public int b() {
        return this.q.a();
    }

    @Override // com.unisound.sdk.cs
    public void b(int i) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.a(i);
        }
    }

    @Override // com.unisound.sdk.ak
    public void b(java.lang.String str) {
        c(str);
    }

    @Override // com.unisound.sdk.au
    public void b(boolean z) throws java.lang.Throwable {
        if (!z) {
            f(com.unisound.client.ErrorCode.FAILED_START_RECORDING);
            com.unisound.common.y.c("startRecognition Error:cancelRecognition()");
            d(true);
        } else {
            com.unisound.sdk.ad adVar = this.i;
            if (adVar != null) {
                adVar.d();
            }
        }
    }

    @Override // com.unisound.sdk.cs
    public void b(boolean z, byte[] bArr, int i, int i2) {
        if (!this.j.A() || this.j.B()) {
            com.unisound.sdk.an anVar = this.g;
            if (anVar != null && z) {
                anVar.a(bArr);
            }
            com.unisound.sdk.ad adVar = this.i;
            if (adVar != null) {
                adVar.a(z, bArr, i, i2);
            }
        }
    }

    public void c() {
        com.unisound.sdk.an anVar = this.g;
        if (anVar != null) {
            anVar.start();
        }
    }

    public void c(int i) {
        int i2 = f1519a;
        if (i <= i2 && i >= (i2 = b)) {
            i2 = i;
        }
        this.q.a(i2);
    }

    protected void c(java.lang.String str) {
        com.unisound.sdk.ay ayVar = this.e;
        if (ayVar != null) {
            ayVar.a(str);
        }
    }

    public void c(boolean z) throws java.lang.Throwable {
        this.e = null;
        this.l = true;
        this.q.e();
        t();
        d(z);
        com.unisound.common.y.c("NetRecognizer: cancelRecognition()");
        removeSendMessage();
    }

    public void d() throws java.lang.Throwable {
        r();
        s();
    }

    public void d(int i) {
        this.j.bd = i;
    }

    protected void e() {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.g();
        }
    }

    @Override // com.unisound.sdk.cr
    public void e(int i) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.c(i);
        }
    }

    public java.lang.String f() {
        return this.k;
    }

    public boolean g() {
        return this.l;
    }

    public com.unisound.common.au h() {
        return this.d;
    }

    @Override // com.unisound.sdk.ak
    public void i() {
        f(0);
    }

    @Override // com.unisound.sdk.au
    public void j() throws java.lang.Throwable {
        this.h = null;
        s();
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.f();
        }
    }

    @Override // com.unisound.sdk.au
    public void k() throws java.lang.Throwable {
        d(true);
        f(com.unisound.client.ErrorCode.RECORDING_EXCEPTION);
    }

    @Override // com.unisound.sdk.ak
    public void k(int i) {
        com.unisound.sdk.ad adVar = this.i;
        if (adVar != null) {
            adVar.h();
        }
    }

    @Override // com.unisound.sdk.ak
    public void l() {
    }

    @Override // com.unisound.sdk.ak
    public void m() throws java.lang.Throwable {
        c(true);
        com.unisound.common.y.c("max_speech_timeout cancel()");
        f(com.unisound.client.ErrorCode.ASRCLIENT_MAX_SPEECH_TIMEOUT);
    }

    @Override // com.unisound.sdk.cs
    public void n() {
        e();
    }

    @Override // com.unisound.sdk.cs
    public void o() {
    }

    public com.unisound.common.av p() {
        return this.c;
    }

    public java.lang.String q() {
        com.unisound.sdk.an anVar = this.g;
        return anVar != null ? anVar.h() : "";
    }
}
