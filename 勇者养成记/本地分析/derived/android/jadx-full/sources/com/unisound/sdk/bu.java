package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class bu extends com.unisound.sdk.bt {
    private java.lang.String c;
    private cn.yunzhisheng.tts.offline.lib.YzsTts d;
    private com.unisound.sdk.ca e;
    private com.unisound.sdk.bx f;
    private boolean g;

    public bu(java.lang.String str, com.unisound.sdk.bx bxVar) {
        super(bxVar.v().booleanValue(), bxVar.q());
        this.d = cn.yunzhisheng.tts.offline.lib.YzsTts.b();
        this.g = false;
        this.c = str;
        this.f = bxVar;
    }

    private void a(float f) {
        this.d.a(f);
    }

    private void a(java.lang.Boolean bool) {
        this.d.b(bool);
    }

    private void a(byte[] bArr, int i) {
        com.unisound.sdk.ca caVar = this.e;
        if (caVar != null) {
            caVar.a(bArr, i);
        }
    }

    private void b(float f) {
        this.d.b(f);
    }

    private void c(float f) {
        this.d.d(f);
    }

    private void c(int i) {
        com.unisound.sdk.ca caVar = this.e;
        if (caVar != null) {
            caVar.a(i);
        }
    }

    private void d(float f) {
        this.d.c(f);
    }

    private void d(int i) {
        this.d.a(i);
    }

    private void e(int i) {
        this.d.b(i);
    }

    private void f(int i) {
    }

    private boolean g(int i) {
        return this.d.d(i);
    }

    private void h(int i) {
        this.d.f(i);
    }

    private void i() {
        com.unisound.sdk.ca caVar = this.e;
        if (caVar != null) {
            caVar.a();
        }
    }

    private void i(int i) {
        this.d.g(i);
    }

    private void j() {
        com.unisound.sdk.ca caVar = this.e;
        if (caVar != null) {
            caVar.b();
        }
    }

    private void k() {
        com.unisound.sdk.ca caVar = this.e;
        if (caVar != null) {
            caVar.c();
        }
    }

    protected void a(com.unisound.sdk.bx bxVar) {
        this.f = bxVar;
    }

    public void a(com.unisound.sdk.ca caVar) {
        this.e = caVar;
    }

    @Override // com.unisound.sdk.bt
    public void b() {
        super.b();
        cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.d;
        if (yzsTts != null) {
            yzsTts.e();
        }
    }

    public void b(int i) {
        if (isAlive()) {
            cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.d;
            if (yzsTts != null) {
                yzsTts.e();
            }
            try {
                super.join(i);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void g() {
        cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.d;
        if (yzsTts != null) {
            yzsTts.c();
            this.d = null;
        }
        k();
    }

    public void h() {
        a((com.unisound.sdk.ca) null);
    }

    @Override // com.unisound.common.f, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("TTSOfflineSynthesizerThread -> ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        try {
            long j = 0;
            if (this.d.a() == 0) {
                c(com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_NOT_INIT);
                com.unisound.common.y.a("TTSOfflineSynthesizerThread run(): 离线tts引擎未初始化，请确认执行init并接收init回调！ ");
                return;
            }
            int iU = this.f.u();
            if (iU != 0) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _LogLevel=", java.lang.Integer.valueOf(iU));
                a(iU);
            }
            float fY = this.f.y();
            if (fY != 50.0f) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _VoiceSpeed=", java.lang.Float.valueOf(fY));
                b(fY);
            }
            float fZ = this.f.z();
            if (fZ != 50.0f) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _VoicePitch=", java.lang.Float.valueOf(fZ));
                c(fZ);
            }
            float fA = this.f.A();
            if (fA != 50.0f) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _VoiceVolume=", java.lang.Float.valueOf(fA));
                d(fA);
            }
            boolean zBooleanValue = this.f.r().booleanValue();
            if (zBooleanValue) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _ReadEnglishInPinyin=", java.lang.Boolean.valueOf(zBooleanValue));
                a(java.lang.Boolean.valueOf(zBooleanValue));
            }
            int iS = this.f.s();
            if (iS != 100) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _FrontSilence=", java.lang.Integer.valueOf(iS));
                d(iS);
            }
            int iT = this.f.t();
            if (iT != 100) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _BackSilence=", java.lang.Integer.valueOf(iT));
                e(iT);
            }
            if (this.d.setText(this.d.a(), this.c) != 0) {
                c(com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_SYNTHESIZER_SET_TEXT);
                com.unisound.common.y.a("TTSOfflineSynthesizerThread run(): setText error ");
                return;
            }
            int iJ = 6400;
            if (this.f.K()) {
                iJ = this.f.J() * this.f.C() * 2;
                this.d.e(iJ);
                com.unisound.common.y.c("TTSOfflineSynthesizerThread bufferLength = " + iJ);
            }
            int iN = this.f.N();
            if (iN != 50) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _Voiceloud=", java.lang.Integer.valueOf(iN));
                h(iN);
            }
            int iO = this.f.O();
            if (iO != -1) {
                com.unisound.common.y.b("TTSOfflineSynthesizerThread run(): _Domain=", java.lang.Integer.valueOf(iO));
                i(iO);
            }
            byte[] bArr = new byte[iJ];
            this.d.a((java.lang.Boolean) true);
            i();
            long j2 = 0;
            int i = 1;
            while (i != 0 && !a()) {
                com.unisound.common.y.f("TTSOfflineSythesizer run : receiveSamples before");
                com.unisound.common.y.d("TTSOfflineSythesizer run : receiveSamples before");
                if (this.f.K()) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    int iB = this.d.b(this.d.a(), bArr);
                    long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                    if (this.f.M()) {
                        j += jCurrentTimeMillis2 - jCurrentTimeMillis;
                        j2 += (long) iB;
                    }
                    i = iB;
                } else {
                    long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
                    int iA = this.d.a(this.d.a(), bArr);
                    long jCurrentTimeMillis4 = java.lang.System.currentTimeMillis();
                    if (this.f.M()) {
                        j += jCurrentTimeMillis4 - jCurrentTimeMillis3;
                        j2 += (long) iA;
                    }
                    i = iA;
                }
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("TTSOfflineSynthesizerThread -> receiveData handle = ", java.lang.Integer.valueOf(i), " thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
                }
                com.unisound.common.y.d("TTSOfflineSythesizer run : receiveSamples after");
                com.unisound.common.y.f("TTSOfflineSythesizer run : receiveSamples after");
                if (i > 1) {
                    a(bArr, i);
                }
                while (!a() && i != 0 && this.g) {
                    if (com.unisound.common.y.l) {
                        com.unisound.common.y.d("TTSOfflineSynthesizerThread -> pause handle = ", java.lang.Integer.valueOf(i), " thread = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
                    }
                    java.lang.Thread.sleep(50L);
                }
            }
            if (this.f.M()) {
                double d = j;
                double dC = j2 / ((long) ((this.f.C() / 1000) * 2));
                java.lang.Double.isNaN(d);
                java.lang.Double.isNaN(dC);
                com.unisound.common.y.a("TTSOfflineSythesizer", "synthesizerTime = " + j + ",synthesizerBufferLength = " + j2 + ", RTF = " + new java.text.DecimalFormat("#.000").format(d / dC));
            }
            j();
            this.d.a((java.lang.Boolean) false);
            com.unisound.common.y.c("TTSOfflineSynthesizerThread run(): synthesizer end");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.unisound.common.y.a("TTSOfflineSynthesizerThread run(): Exception error");
        }
    }
}
