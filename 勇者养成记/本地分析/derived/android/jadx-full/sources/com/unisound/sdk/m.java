package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m extends com.unisound.common.ab implements com.unisound.sdk.ak, com.unisound.sdk.au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1568a = 50;
    private static com.unisound.sdk.aa d;
    private static com.unisound.sdk.k f;
    private static cn.yunzhisheng.asrfix.JniAsrFix h;
    com.unisound.sdk.ar b;
    private com.unisound.sdk.z c;
    private com.unisound.sdk.aj e;
    private com.unisound.sdk.ai g;
    private com.unisound.sdk.w i;
    private boolean j;
    private boolean k;
    private android.os.Looper l;
    private android.content.Context m;
    private boolean n;

    static {
        java.lang.System.loadLibrary("uscasr");
    }

    public m() {
        this.c = null;
        this.e = null;
        this.g = new com.unisound.sdk.ai();
        this.i = null;
        this.j = true;
        this.k = false;
        this.n = true;
    }

    public m(android.os.Looper looper, android.content.Context context) {
        super(looper);
        this.c = null;
        this.e = null;
        this.g = new com.unisound.sdk.ai();
        this.i = null;
        this.j = true;
        this.k = false;
        this.n = true;
        this.l = looper;
        this.m = context;
    }

    private void B() {
        com.unisound.sdk.z zVar = this.c;
        if (zVar != null) {
            zVar.d();
        }
    }

    private void C() {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.d();
        }
    }

    private void c(java.lang.String str) {
        com.unisound.common.y.a(str);
    }

    private void d(java.lang.String str) {
        com.unisound.common.y.c(str);
    }

    private void g(boolean z) {
        com.unisound.sdk.k kVar = f;
        if (kVar != null) {
            kVar.a(z);
            f = null;
        }
    }

    private void l(int i) {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.a(i);
        }
    }

    @Override // com.unisound.sdk.ak
    public void A() {
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return h.a(str, str2);
    }

    public void a() {
        com.unisound.sdk.z zVar = this.c;
        if (zVar != null) {
            zVar.k();
            this.c = null;
        }
    }

    @Override // com.unisound.sdk.ak
    public void a(int i) {
        com.unisound.sdk.z zVar = this.c;
        if (zVar != null) {
            zVar.d();
        }
        com.unisound.common.y.c("FixRecognizer MSG_RECOGNITION_ERROR");
        l(i);
    }

    @Override // com.unisound.common.ar
    public void a(int i, int i2, java.lang.Object obj) {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.a(i, i2, obj);
        }
    }

    @Override // com.unisound.sdk.cs
    public void a(cn.yunzhisheng.asr.VAD vad) {
        com.unisound.sdk.ar arVar;
        com.unisound.sdk.z zVar = this.c;
        if ((zVar == null || !zVar.e()) && (arVar = this.b) != null) {
            arVar.a(vad);
        }
    }

    public void a(com.unisound.sdk.aj ajVar) {
        this.e = ajVar;
    }

    @Override // com.unisound.sdk.ak
    public void a(com.unisound.sdk.al alVar) {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.a(alVar.a(), alVar.c(), alVar.f(), alVar.g());
        }
    }

    public void a(com.unisound.sdk.ar arVar) {
        synchronized (this.l) {
            this.b = arVar;
            setMessageLisenter(this.b);
        }
    }

    public void a(com.unisound.sdk.u uVar) {
        h.a(uVar);
    }

    public void a(com.unisound.sdk.w wVar) {
        this.i = wVar;
    }

    public void a(java.lang.Boolean bool) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            jniAsrFix.a(bool);
        }
    }

    protected void a(java.lang.String str) {
        com.unisound.common.y.b(str);
    }

    public void a(java.lang.String str, com.unisound.sdk.z zVar, com.unisound.sdk.au auVar) {
        this.n = true;
        com.unisound.sdk.k kVar = f;
        if (kVar != null) {
            kVar.a(true);
            f = null;
        }
        com.unisound.sdk.aa aaVar = d;
        if (aaVar != null) {
            aaVar.f();
            d = null;
        }
        d = new com.unisound.sdk.aa(this.m, this.i, auVar);
        this.g.a();
        if (this.j) {
            if (!this.k) {
                com.unisound.common.y.c("FixRecognizer MSG_RECOGNITION_ERROR");
                l(com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT);
                return;
            }
            if (h.h()) {
                f = new com.unisound.sdk.j(h, str, this.i, d, this.m);
                f.a(this);
                f.a(this.e);
                f.setName("usc_fix_thread");
                f.setPriority(10);
                f.start();
                com.unisound.common.y.f("Recognition Thread Start");
            } else {
                com.unisound.common.y.c("FixRecognizer MSG_RECOGNITION_ERROR");
                l(com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT);
                if (this.b == null) {
                    return;
                }
            }
        }
        d.setName("usc_vad_thread");
        d.setPriority(10);
        d.start();
        this.c = zVar;
        this.c.setName("usc_record_thread");
        this.c.setPriority(10);
        this.c.start();
        com.unisound.common.y.f("Recording Thread Start");
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.e();
        }
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (h.h()) {
            b(str2, str3, str4);
            return;
        }
        com.unisound.common.y.a("FixRecognizer Engine is not init, wrong cmd=" + str3);
        com.unisound.common.y.c("FixRecognizer MSG_RECOGNITION_ERROR");
        l(com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT);
    }

    @Override // com.unisound.sdk.ak
    public void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
        com.unisound.sdk.al alVar = new com.unisound.sdk.al();
        alVar.a(str);
        alVar.a(z);
        alVar.c(i);
        alVar.a(j);
        alVar.b(j2);
        alVar.a(i2);
        alVar.b(i3);
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.a(alVar.a(), alVar.c(), alVar.i(), alVar.j(), alVar.k(), alVar.f(), alVar.g());
        }
    }

    public void a(boolean z) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix;
        if (z && (jniAsrFix = h) != null) {
            jniAsrFix.b();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FixRecognizer Cancel and wait end +");
        sb.append(f == null);
        com.unisound.common.y.a(sb.toString());
        h();
        com.unisound.sdk.aa aaVar = d;
        if (aaVar != null) {
            aaVar.d();
        }
        f();
        removeSendMessage();
    }

    @Override // com.unisound.sdk.au
    public void a(boolean z, byte[] bArr, int i, int i2) {
        com.unisound.sdk.aa aaVar = d;
        if (aaVar != null) {
            aaVar.a(bArr);
        }
    }

    @Override // com.unisound.common.ab
    public boolean a(android.os.Message message) {
        return true;
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if ("init_asr" == str3) {
            int iA = h.a(str, str2, str3, this.i);
            if (iA != 0) {
                c("jac.init path=" + str + ":" + str2 + " error:" + iA);
                return false;
            }
            h.a(0, 1);
            h.a(1, 3000);
            h.a(6, 8);
            h.a(9, this.i.aZ());
        }
        return true;
    }

    public int b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return h.a(str, str2, this.i, str3);
    }

    public void b() {
        com.unisound.sdk.k kVar;
        B();
        if (this.c == null && (kVar = f) != null && !kVar.g()) {
            com.unisound.sdk.ar arVar = this.b;
            if (arVar != null) {
                arVar.a();
            }
            g();
        }
        com.unisound.sdk.aa aaVar = d;
        if (aaVar != null) {
            aaVar.a();
        }
    }

    @Override // com.unisound.sdk.cs
    public void b(int i) {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.b(i);
        }
    }

    @Override // com.unisound.sdk.ak
    public void b(java.lang.String str) {
    }

    @Override // com.unisound.sdk.au
    public void b(boolean z) {
        this.g.a();
        if (!z) {
            f();
            l(com.unisound.client.ErrorCode.FAILED_START_RECORDING);
        } else if (this.b != null) {
            com.unisound.common.y.c("msg onRecordingStart true");
            this.b.c();
        }
    }

    @Override // com.unisound.sdk.cs
    public void b(boolean z, byte[] bArr, int i, int i2) {
        com.unisound.sdk.k kVar;
        if (this.g.a(bArr, i, i2)) {
            C();
        }
        if (z && this.g.b() && (kVar = f) != null && bArr != null && bArr.length > 0) {
            kVar.b(bArr);
        }
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            if (com.unisound.sdk.ai.f1515a) {
                z = this.g.b() && z;
            }
            arVar.b(z, bArr, i, i2);
        }
    }

    public int c(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.b(i);
        }
        return -1;
    }

    protected void c() {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.f();
        }
    }

    public void c(boolean z) {
        this.j = z;
    }

    public int d(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.c(i);
        }
        return -1;
    }

    protected void d() {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.n();
        }
    }

    public void d(boolean z) {
        this.k = z;
    }

    public int e(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.d(i);
        }
        return -1;
    }

    public int e(boolean z) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.a(z);
        }
        return -1;
    }

    protected void e() {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.o();
        }
    }

    public int f(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.e(i);
        }
        return -1;
    }

    public int f(boolean z) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.b(z);
        }
        return -1;
    }

    protected void f() {
        com.unisound.sdk.k kVar = f;
        if (kVar != null) {
            kVar.c();
        }
    }

    public int g(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.f(i);
        }
        return -1;
    }

    public void g() {
        com.unisound.sdk.k kVar = f;
        if (kVar != null) {
            kVar.d();
        }
    }

    public int h(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.g(i);
        }
        return -1;
    }

    protected void h() {
        com.unisound.sdk.z zVar = this.c;
        if (zVar != null) {
            zVar.g();
        }
    }

    public int i(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.h(i);
        }
        return -1;
    }

    @Override // com.unisound.sdk.ak
    public void i() {
        com.unisound.common.y.c("FixRecognizer MSG_RECOGNITION_STOP");
        l(0);
    }

    public int j(int i) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.i(i);
        }
        return -1;
    }

    @Override // com.unisound.sdk.au
    public void j() {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.a();
        }
        g();
    }

    @Override // com.unisound.sdk.au
    public void k() {
        f();
        l(com.unisound.client.ErrorCode.RECORDING_EXCEPTION);
    }

    @Override // com.unisound.sdk.ak
    public void k(int i) {
        com.unisound.sdk.ar arVar = this.b;
        if (arVar != null) {
            arVar.d(i);
        }
    }

    @Override // com.unisound.sdk.ak
    public void l() {
        com.unisound.sdk.z zVar = this.c;
    }

    @Override // com.unisound.sdk.ak
    public void m() {
        f();
        B();
        l(com.unisound.client.ErrorCode.ASR_FIXENGINE_MAX_SPEECH_TIMEOUT);
    }

    @Override // com.unisound.sdk.cs
    public void n() {
        d();
    }

    @Override // com.unisound.sdk.cs
    public void o() {
        e();
    }

    public void p() {
        synchronized (h) {
            if (this.c != null) {
                this.c.d();
            }
            h.d();
            if (this.c != null) {
                this.c.k();
            }
            if (d != null) {
                d.f();
            }
            g(true);
            h.i();
            com.unisound.common.y.c("jac.unLoad();");
        }
    }

    public boolean q() {
        return h.h();
    }

    public boolean r() {
        com.unisound.sdk.k kVar = f;
        if (kVar != null) {
            return kVar.isAlive();
        }
        return false;
    }

    public void s() {
        h = cn.yunzhisheng.asrfix.JniAsrFix.a();
    }

    public int t() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.k();
        }
        return 1;
    }

    public java.util.List<java.lang.Integer> u() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.m();
        }
        return null;
    }

    public int v() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.n();
        }
        return -1;
    }

    public java.lang.String w() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        return jniAsrFix != null ? jniAsrFix.o() : "";
    }

    public java.lang.String x() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        return jniAsrFix != null ? jniAsrFix.p() : "";
    }

    public int y() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.r();
        }
        return -1;
    }

    public int z() {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix = h;
        if (jniAsrFix != null) {
            return jniAsrFix.s();
        }
        return -1;
    }
}
