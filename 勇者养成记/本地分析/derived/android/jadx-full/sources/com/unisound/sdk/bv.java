package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class bv extends com.unisound.sdk.bt {
    byte[] c;
    private com.unisound.sdk.ca d;
    private com.unisound.sdk.bx e;
    private java.lang.String f;

    public bv(java.lang.String str, com.unisound.sdk.bx bxVar) {
        super(bxVar.v().booleanValue(), bxVar.q());
        this.d = null;
        this.f = str;
        this.e = bxVar;
    }

    private java.lang.String a(com.unisound.sdk.bx bxVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (bxVar != null) {
            int iZ = bxVar.z();
            if (iZ != 50) {
                sb.append("pit=");
                sb.append(iZ);
                sb.append(";");
            }
            int iY = bxVar.y();
            if (iY != 50) {
                sb.append("spd=");
                sb.append(iY);
                sb.append(";");
            }
            int iA = bxVar.A();
            if (iA != 50) {
                sb.append("vol=");
                sb.append(iA);
                sb.append(";");
            }
            java.lang.String strX = bxVar.x();
            if (strX != com.unisound.sdk.bx.j) {
                sb.append("vcn=");
                sb.append(strX);
                sb.append(";");
            }
            int iS = bxVar.s();
            if (iS != 100) {
                sb.append("smt=");
                sb.append(iS);
                sb.append(";");
            }
            int iT = bxVar.t();
            if (iT != 100) {
                sb.append("emt=");
                sb.append(iT);
                sb.append(";");
            }
            boolean zBooleanValue = bxVar.r().booleanValue();
            if (zBooleanValue) {
                sb.append("e2c=");
                sb.append(zBooleanValue);
                sb.append(";");
            }
            int iC = bxVar.C();
            if (iC != 22050) {
                sb.append("sampleRate=");
                sb.append(iC);
                sb.append(";");
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return "";
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void a(byte[] bArr) {
        com.unisound.sdk.ca caVar = this.d;
        if (caVar != null) {
            caVar.a(bArr, bArr.length);
        }
    }

    private void b(int i) {
        if (this.e.H().intValue() == 3) {
            l();
            return;
        }
        com.unisound.sdk.ca caVar = this.d;
        if (caVar != null) {
            caVar.a(i);
        }
    }

    private void i() {
        com.unisound.sdk.ca caVar = this.d;
        if (caVar != null) {
            caVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (this.e.H().intValue() != 3) {
            return false;
        }
        l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.unisound.sdk.ca caVar = this.d;
        if (caVar != null) {
            caVar.b();
        }
    }

    private void l() {
        com.unisound.sdk.ca caVar = this.d;
        if (caVar != null) {
            caVar.a(this.f);
        }
    }

    public void a(com.unisound.sdk.ca caVar) {
        this.d = caVar;
    }

    @Override // com.unisound.sdk.bt
    public void b() {
        super.b();
    }

    public void b(com.unisound.sdk.ca caVar) {
        this.d = caVar;
    }

    public void g() {
        this.d = null;
    }

    public java.lang.String h() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unisound.common.f, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("TTSOnlineSynthesizerThread ->run ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        super.run();
        com.unisound.common.y.b("TTSOnlineSynthesizerThread run()：synthesizer start");
        cn.yunzhisheng.tts.JniClient jniClient = new cn.yunzhisheng.tts.JniClient();
        try {
            try {
                com.unisound.common.a aVarF = this.e.f();
                if (!jniClient.a(this.e.F(), aVarF.b(), aVarF.c())) {
                    com.unisound.common.y.a("[REDACTED]" + this.e.F() + "[REDACTED]" + aVarF.b() + "[REDACTED]" + aVarF.a() + "[REDACTED]" + aVarF.c());
                    b(com.unisound.client.ErrorCode.TTS_ERROR_ONLINE_SYNTHESIZER_INIT);
                    jniClient.b();
                    return;
                }
                jniClient.a(8, com.unisound.c.a.q);
                jniClient.a(14, com.unisound.c.a.a(this.e.F()));
                jniClient.a(22, com.unisound.c.a.a(this.e.F()));
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.unisound.c.a.s);
                sb.append(":");
                sb.append(0);
                sb.append(":");
                sb.append(com.unisound.c.a.r);
                sb.append(":");
                sb.append(this.e.f1545a);
                sb.append(":");
                sb.append(com.unisound.c.a.t);
                sb.append(":");
                sb.append(com.unisound.common.an.f1472a);
                sb.append("\t" + com.unisound.common.y.x + ":" + cn.yunzhisheng.tts.JniClient.c + ":" + cn.yunzhisheng.tts.JniClient.d);
                com.unisound.common.y.b("TTSOnlineSynthesizerThread getTTSData: TTS_OPT_CLIENT_INFO: ", sb.toString());
                jniClient.a(15, sb.toString());
                java.lang.String strA = a(this.e);
                if (strA != null) {
                    com.unisound.common.y.b("TTSOnlineSynthesizerThread getTTSData: ParamString(): ", strA);
                    jniClient.a(104, strA);
                }
                if (this.e.o() != null) {
                    jniClient.a(203, this.e.o());
                }
                if (this.e.G() != null) {
                    jniClient.a(204, this.e.G());
                }
                if (this.e.Q() > 0) {
                    jniClient.a(2000, java.lang.String.valueOf(this.e.Q()));
                }
                com.unisound.sdk.c cVarB = this.e.b();
                int iA = jniClient.a(cVarB.b(), cVarB.a());
                if (iA != 0) {
                    com.unisound.common.y.a("TTSOnlineSynthesizerThread getTTSData: jni.start error " + iA + " audioFormat.toParamString(): " + cVarB.b() + " audioFormat.getEncode(): " + cVarB.a());
                    b(iA);
                    jniClient.b();
                    return;
                }
                int iB = jniClient.b(this.f);
                if (iB != 0) {
                    com.unisound.common.y.a("TTSOnlineSynthesizerThread getTTSData: jni.textPut error " + iB);
                    b(iB);
                    jniClient.b();
                    return;
                }
                i();
                loop0: while (true) {
                    int i = 0;
                    while (true) {
                        if (a() || jniClient.n.b == 2 || i >= 10) {
                            break loop0;
                        }
                        com.unisound.common.y.f("TTSOnlineSynthesizerThread run : jni.getResult() before");
                        java.util.Timer timer = null;
                        if (this.e.H().intValue() == 3) {
                            timer = new java.util.Timer();
                            timer.schedule(new com.unisound.sdk.bw(this, jniClient), this.e.P());
                        }
                        this.c = jniClient.d();
                        if (timer != null) {
                            timer.cancel();
                        }
                        com.unisound.common.y.f("TTSOnlineSynthesizerThread run : jni.getResult() after");
                        if (this.c == null) {
                            i++;
                            int i2 = jniClient.n.c;
                            if (i2 != 0) {
                                com.unisound.common.y.a("TTSOnlineSynthesizerThread getTTSData: jni.getResult() error" + i2);
                                if (j()) {
                                    break loop0;
                                }
                            }
                        }
                    }
                    a(this.c);
                }
                jniClient.c();
                k();
                jniClient.b();
                com.unisound.common.y.c("TTSOnlineSynthesizerThread run()：synthesizer end");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            jniClient.b();
            throw th;
        }
    }
}
