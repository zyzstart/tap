package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class o {
    public static final int OPT_SET_FIX_RESULT_NLU = 5;
    public static final int OPT_SET_FIX_RESULT_NLU_CONFIGPATH = 6;
    public static final int SET_USER_DATA_ERROR = -100;
    public static final int SET_USER_DATA_OK = 0;
    public static final int SET_USER_DATA_WARNING = -200;
    protected com.unisound.sdk.w b;
    protected com.unisound.sdk.m e;
    protected com.unisound.common.ar g;
    protected android.content.Context l;
    public android.os.Looper mLooper;
    public com.unisound.sdk.bs mSpeechUnderstanderParams;
    private com.unisound.sdk.t v;
    private boolean o = false;
    private boolean p = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.unisound.sdk.l f1569a = new com.unisound.sdk.l();
    protected com.unisound.sdk.y c = null;
    protected com.unisound.sdk.aa d = null;
    private com.unisound.common.g q = new com.unisound.common.g();
    protected com.unisound.sdk.ab f = new com.unisound.sdk.ab();
    protected com.unisound.sdk.n h = new com.unisound.sdk.n();
    protected com.unisound.sdk.a i = new com.unisound.sdk.a();
    protected com.unisound.sdk.ct j = new com.unisound.sdk.ct();
    protected com.unisound.sdk.av k = new com.unisound.sdk.av();
    private boolean r = false;
    protected float m = -8.0f;
    private java.lang.String s = "";
    private com.unisound.client.IAudioSource t = null;
    private boolean u = false;
    private com.unisound.common.d w = new com.unisound.sdk.q(this);
    private com.unisound.sdk.aj x = new com.unisound.sdk.r(this);
    protected android.os.HandlerThread n = new android.os.HandlerThread("ht_NetAndFix");

    protected o(android.content.Context context, java.lang.String str) {
        this.b = new com.unisound.sdk.w(context);
        this.n.start();
        this.mLooper = this.n.getLooper();
        this.e = new com.unisound.sdk.m(this.mLooper, context);
        this.i.a(this.w);
        this.l = context;
        this.mSpeechUnderstanderParams = new com.unisound.sdk.bs();
        this.f.a(context.getApplicationContext().getFilesDir() + "/YunZhiSheng/asrfix");
        this.f1569a.c(context.getApplicationContext().getFilesDir() + "/YunZhiSheng/");
        this.q.a(context);
        this.b.f(false);
        this.b.a(3000, 1000);
        this.b.o(str);
        this.e.a(this.b);
        this.v = new com.unisound.sdk.t(this, null);
        this.e.a(this.v);
        com.unisound.sdk.ab.m = 1;
        a(new com.unisound.sdk.p(this));
    }

    protected static boolean c(java.lang.String str) {
        return com.unisound.sdk.ab.d(str);
    }

    protected int a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return this.e.b(str, str2, str3);
    }

    protected int a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (this.f.a(this.l)) {
            return this.f.a(str, str2, str3, str4);
        }
        return -100;
    }

    protected com.unisound.sdk.as a() {
        return this.b;
    }

    protected java.lang.String a(java.lang.String str, java.lang.String str2) {
        return this.e.a(str, str2);
    }

    protected void a(int i) {
    }

    protected void a(int i, int i2) {
        this.b.a(i, i2);
    }

    protected void a(int i, int i2, java.lang.Object obj) {
        com.unisound.common.ar arVar = this.g;
        if (arVar != null) {
            arVar.a(i, i2, obj);
        }
    }

    protected void a(cn.yunzhisheng.asr.VAD vad) {
        this.h.c();
    }

    protected void a(com.unisound.common.ah ahVar) {
        this.k.a(ahVar);
    }

    protected void a(com.unisound.common.b bVar) {
        this.i.a(bVar);
    }

    protected void a(com.unisound.sdk.v vVar) {
        this.h.a(vVar);
    }

    protected void a(java.lang.String str, boolean z, int i, int i2) {
    }

    protected void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
    }

    protected void a(boolean z, byte[] bArr, int i, int i2) {
    }

    protected boolean a(android.content.Context context) {
        return com.unisound.common.h.a(context);
    }

    protected boolean a(android.os.Message message) {
        return false;
    }

    protected boolean a(java.lang.String str) {
        return false;
    }

    protected boolean a(java.lang.String str, boolean z) {
        java.lang.String str2;
        if (str == null || str.length() == 0) {
            str2 = this.l.getApplicationContext().getFilesDir() + "/YunZhiSheng/asrfix";
        } else {
            str2 = str + "/YunZhiSheng/asrfix";
        }
        this.f.a(str2);
        this.f.a(this.l, com.unisound.sdk.ab.f);
        if (this.f.a(this.l, z)) {
            return true;
        }
        com.unisound.common.y.a("USCFixRecognizer.initByModelDir init data fail!");
        return false;
    }

    protected boolean a(boolean z) {
        return a((java.lang.String) null, z);
    }

    protected int b(java.lang.String str, java.lang.String str2) {
        return !this.e.a(this.f.f1512a, str, str2) ? -1 : 0;
    }

    protected int b(boolean z) {
        return this.e.e(z);
    }

    protected void b() {
        this.v = new com.unisound.sdk.t(this, null);
        this.e.a(this.x);
        this.e.a(this.v);
        this.e.a(this.b);
    }

    protected void b(int i) {
        if (i != 0) {
            this.e.a(false);
        }
    }

    protected void b(int i, int i2) {
    }

    protected void b(java.lang.String str) {
        b();
        this.c = null;
        this.d = null;
        if (this.p) {
            com.unisound.sdk.ax.n();
            if (this.t == null) {
                this.t = new com.unisound.common.e(this.b);
            }
            com.unisound.common.y.g("FixRecognizerInterface recognizer start");
            com.unisound.sdk.m mVar = this.e;
            mVar.a(str, new com.unisound.sdk.ax(this.b, mVar, this.t), this.e);
        }
        com.unisound.sdk.w wVar = this.b;
        wVar.b(com.unisound.common.j.a(wVar.c()));
        if (this.b.b()) {
            this.r = com.unisound.common.j.b(this.b.c());
        }
    }

    protected void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.e.a(this.f.f1512a, str, str2, str3);
    }

    protected boolean b(android.content.Context context) {
        return com.unisound.common.h.c(context);
    }

    protected int c(boolean z) {
        return this.e.f(z);
    }

    protected void c(int i) {
        this.h.a(i);
    }

    protected void c(int i, int i2) {
    }

    protected boolean c() {
        return this.e.r();
    }

    protected void cancel() {
        this.v = null;
        this.e.a((com.unisound.sdk.ar) null);
        this.e.a(true);
    }

    protected void d(int i) {
    }

    protected boolean d() {
        return this.e.q();
    }

    protected int e(int i) {
        return this.e.c(i);
    }

    protected boolean e() {
        return this.f.c();
    }

    protected int f(int i) {
        return this.e.d(i);
    }

    protected void f() {
        com.unisound.sdk.m mVar = this.e;
        if (mVar != null) {
            mVar.g();
        }
    }

    protected int g(int i) {
        return this.e.e(i);
    }

    protected java.lang.String g() {
        return cn.yunzhisheng.asrfix.JniAsrFix.getVersion();
    }

    protected java.lang.Object getOption(int i) {
        if (1055 == i) {
            return java.lang.Boolean.valueOf(this.b.y());
        }
        if (1056 == i) {
            return java.lang.Boolean.valueOf(this.b.j());
        }
        if (1010 == i) {
            return java.lang.Integer.valueOf(this.b.u());
        }
        if (1011 == i) {
            return java.lang.Integer.valueOf(this.b.v());
        }
        if (1015 == i) {
            return java.lang.Boolean.valueOf(this.b.P());
        }
        if (1016 == i) {
            return java.lang.Float.valueOf(this.b.Q());
        }
        return null;
    }

    protected java.lang.String getVersion() {
        return com.unisound.common.an.a();
    }

    protected int h() {
        return 0;
    }

    protected int h(int i) {
        return this.e.f(i);
    }

    protected int i(int i) {
        return this.e.g(i);
    }

    protected void i() {
    }

    protected int j(int i) {
        return this.e.h(i);
    }

    protected void j() {
    }

    protected int k(int i) {
        return this.e.i(i);
    }

    protected void k() {
    }

    protected boolean l() {
        return false;
    }

    protected void m() {
    }

    protected void n() {
    }

    protected void o() {
        if (this.b.l()) {
            this.q.a();
        }
        this.h.b();
    }

    protected void p() {
    }

    public void postRecordingStartStatus() {
    }

    protected void q() {
    }

    protected void r() {
        this.f.f();
        this.e.p();
    }

    protected void s() {
        com.unisound.common.y.c("FixRecognizerInterFace : createJniAsrFix");
        this.f.a(this.l, com.unisound.sdk.ab.f);
        this.e.s();
        this.e.a(new com.unisound.sdk.s(this));
    }

    protected int setAudioSource(com.unisound.client.IAudioSource iAudioSource) {
        this.t = iAudioSource;
        if (this.t != null) {
            return 0;
        }
        this.t = new com.unisound.common.e(this.b);
        return 0;
    }

    protected void setOption(int i, java.lang.Object obj) {
        java.lang.String str;
        if (1051 == i) {
            try {
                this.f1569a.b = ((java.lang.Boolean) obj).booleanValue();
                return;
            } catch (java.lang.Exception unused) {
                str = "set asr_result_filter Error.";
            }
        } else if (1053 == i) {
            try {
                this.p = ((java.lang.Boolean) obj).booleanValue();
                return;
            } catch (java.lang.Exception unused2) {
                str = "set asr_recording_enabled Error.";
            }
        } else {
            try {
                if (1054 == i) {
                    com.unisound.common.y.k = ((java.lang.Boolean) obj).booleanValue();
                    com.unisound.c.a.b(((java.lang.Boolean) obj).booleanValue());
                } else if (1063 == i) {
                    com.unisound.common.y.m = ((java.lang.Boolean) obj).booleanValue();
                } else {
                    if (1055 == i) {
                        return;
                    }
                    if (1058 == i) {
                        try {
                            this.b.a((java.lang.String) obj);
                            return;
                        } catch (java.lang.Exception unused3) {
                            str = "set asr_save_recording_data Error.";
                        }
                    } else if (1059 == i) {
                        try {
                            this.f1569a.c = ((java.lang.Boolean) obj).booleanValue();
                            return;
                        } catch (java.lang.Exception unused4) {
                            str = "set asr_result_json Error.";
                        }
                    } else if (1010 == i) {
                        try {
                            this.b.d(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused5) {
                            str = "set asr_vad_timeout_frontsil Error.";
                        }
                    } else if (1011 == i) {
                        try {
                            a(this.b.u(), ((java.lang.Integer) obj).intValue());
                            this.b.m(((java.lang.Integer) obj).intValue());
                            this.b.e(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused6) {
                            str = "set asr_vad_timeout_backsil Error.";
                        }
                    } else if (5 == i) {
                        try {
                            this.f1569a.f = ((java.lang.Boolean) obj).booleanValue();
                            if (this.f1569a.f && this.f1569a.h == null) {
                                this.f1569a.h = new cn.yunzhisheng.nlu.OfflineNlu();
                                return;
                            }
                            return;
                        } catch (java.lang.Exception unused7) {
                            str = "set asr_fix_result_nlu Error.";
                        }
                    } else if (6 == i) {
                        try {
                            this.s = (java.lang.String) obj;
                            this.f1569a.g = (java.lang.String) obj;
                            if (this.f1569a.h == null || this.s.equals("")) {
                                return;
                            }
                            this.f1569a.h.b(this.s, "");
                            return;
                        } catch (java.lang.Exception unused8) {
                            str = "set asr_fix_result_nlu_configpath Error.";
                        }
                    } else if (1062 == i) {
                        try {
                            this.b.D(((java.lang.Boolean) obj).booleanValue());
                            this.e.a((java.lang.Boolean) obj);
                            return;
                        } catch (java.lang.Exception unused9) {
                            str = "set asr_print_engine_log Error.";
                        }
                    } else if (5000 == i) {
                        try {
                            this.b.c(((java.lang.Boolean) obj).booleanValue());
                            return;
                        } catch (java.lang.Exception unused10) {
                            str = "set setFarFeildEnabled Error. 5000 ";
                        }
                    } else if (5001 == i) {
                        try {
                            this.b.y.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused11) {
                            str = "set min back energy Error. 5001 ";
                        }
                    } else if (5002 == i) {
                        try {
                            this.b.z.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused12) {
                            str = "set min back energy higher TH Error. 5002 ";
                        }
                    } else if (5003 == i) {
                        try {
                            this.b.A.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused13) {
                            str = "set pitch threshold Error. 5003 ";
                        }
                    } else if (5004 == i) {
                        try {
                            this.b.B.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused14) {
                            str = "set pitch persist length for start usage Error. 5004 ";
                        }
                    } else if (5005 == i) {
                        try {
                            this.b.C.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused15) {
                            str = "set pitch drop length for end usage Error. 5005 ";
                        }
                    } else if (5006 == i) {
                        try {
                            this.b.D.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused16) {
                            str = "set high freq energy vs low freq energy Error. 5006 ";
                        }
                    } else if (5007 == i) {
                        try {
                            this.b.E.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused17) {
                            str = "set min signal length for speech Error. 5007 ";
                        }
                    } else if (5008 == i) {
                        try {
                            this.b.F.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused18) {
                            str = "set max silence length Error. 5008 ";
                        }
                    } else if (5009 == i) {
                        try {
                            this.b.G.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused19) {
                            str = "set max single point max in spectral Error. 5009 ";
                        }
                    } else if (5010 == i) {
                        try {
                            this.b.H.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused20) {
                            str = "set gloable noise to signal value threshold Error. 5010 ";
                        }
                    } else if (5011 == i) {
                        try {
                            this.b.I.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused21) {
                            str = "set gloable noise to signal value threshold for vowel part Error. 5011 ";
                        }
                    } else if (5012 == i) {
                        try {
                            this.b.J.a(((java.lang.Float) obj).floatValue());
                            return;
                        } catch (java.lang.Exception unused22) {
                            str = "set voice freq domain prob Th Error. 5012 ";
                        }
                    } else if (5013 == i) {
                        try {
                            this.b.K.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused23) {
                            str = "set use pitch or peak Error. 5013 ";
                        }
                    } else if (5014 == i) {
                        try {
                            this.b.L.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused24) {
                            str = "set noise to y ratio, start point in freq domain Error. 5014 ";
                        }
                    } else if (5017 == i) {
                        try {
                            this.b.M.a(((java.lang.Integer) obj).intValue());
                            return;
                        } catch (java.lang.Exception unused25) {
                            str = "set PITCHLASTTH Error. 5017 ";
                        }
                    } else {
                        try {
                            if (5021 == i) {
                                this.b.n((java.lang.String) obj);
                            } else if (1016 == i) {
                                try {
                                    this.b.b(((java.lang.Float) obj).floatValue());
                                    return;
                                } catch (java.lang.Exception unused26) {
                                    str = "set vad musicth info Error!";
                                }
                            } else if (1015 == i) {
                                try {
                                    this.b.m(((java.lang.Boolean) obj).booleanValue());
                                    return;
                                } catch (java.lang.Exception unused27) {
                                    str = "set vad detectMusic Error!";
                                }
                            } else if (20120629 != i) {
                                return;
                            } else {
                                com.unisound.common.y.l = ((java.lang.Boolean) obj).booleanValue();
                            }
                            return;
                        } catch (java.lang.Exception unused28) {
                            str = "set activate info Error.";
                        }
                    }
                }
                return;
            } catch (java.lang.Exception unused29) {
                str = "set asr_print_log Error.";
            }
        }
        com.unisound.common.y.a(str);
    }

    protected void start() {
        b(this.f.e);
    }

    protected void stop() {
        this.c = null;
        this.e.b();
        if (this.p) {
            return;
        }
        this.e.g();
    }

    protected int t() {
        return this.e.t();
    }

    protected java.util.List<java.lang.Integer> u() {
        return this.e.u();
    }

    protected int v() {
        return this.e.v();
    }

    protected java.lang.String w() {
        return this.e.w();
    }

    protected java.lang.String x() {
        return this.e.x();
    }

    protected int y() {
        return this.e.y();
    }

    protected int z() {
        return this.e.z();
    }
}
