package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class bx {
    public static final boolean d = false;
    public static final int e = 0;
    public static final int f = 300;
    public static final int g = 50;
    public static final int h = 50;
    public static final int i = 50;
    public static final java.lang.String j = "xiaoli";
    public static final int k = 22050;
    public static final boolean l = false;
    public static final int m = 100;
    public static final int n = 100;
    public static final int o = 2;
    public static final int p = 15;
    public static final int q = 5;
    public static final int r = 50;
    public static final int s = -1;
    public static final boolean t = false;
    public static final boolean u = false;
    private static com.unisound.sdk.bx w;
    private java.lang.String H;
    private java.lang.String I;
    private java.lang.String y;
    private com.unisound.common.a v = new com.unisound.common.a("ttsv3.hivoice.cn", 80, "117.121.49.41", 80);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1545a = 0;
    public java.lang.String b = null;
    public com.unisound.sdk.c c = new com.unisound.sdk.c();
    private java.lang.Boolean x = false;
    private int z = 300;
    private int A = 50;
    private int B = 50;
    private int C = 50;
    private java.lang.String D = j;
    private int E = k;
    private java.util.List<java.lang.Integer> F = new java.util.ArrayList();
    private int G = 3;
    private java.lang.Integer J = 2;
    private int K = 0;
    private java.lang.Boolean L = false;
    private int M = 100;
    private int N = 100;
    private int O = 15;
    private int P = 5;
    private int Q = 50;
    private int R = -1;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private java.lang.String W = "";
    private java.lang.String X = "";
    private java.lang.String Y = "";
    private java.lang.String Z = "";
    private long aa = 500;
    private long ab = 0;
    private java.io.InputStream ac = null;
    private java.io.InputStream ad = null;
    private java.io.InputStream ae = null;
    private java.io.InputStream af = null;

    private bx() {
    }

    private boolean E(java.lang.Object obj) {
        java.lang.String str;
        if (obj == null) {
            str = "TTSParams object2Boolean: obj is null";
        } else {
            if (obj instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) obj).booleanValue();
            }
            str = "TTSParams object2Boolean: obj is not change to boolean";
        }
        com.unisound.common.y.a(str);
        return false;
    }

    private int a(java.lang.Integer num) {
        int iIntValue = java.lang.Integer.valueOf(num.intValue()).intValue();
        if (iIntValue < 0) {
            com.unisound.common.y.e("TTSParams checkParams: value < 0");
            return 1;
        }
        if (iIntValue <= 100) {
            return iIntValue;
        }
        com.unisound.common.y.e("TTSParams checkParams: value > 100");
        return 100;
    }

    public static com.unisound.sdk.bx a() {
        if (w == null) {
            w = new com.unisound.sdk.bx();
        }
        return w;
    }

    private java.lang.Integer c(int i2) {
        if (i2 > 1000) {
            com.unisound.common.y.e("TTSParams checkSilenceTime: silence > 1000 invoked silence = 1000");
            i2 = 1000;
        }
        if (i2 < 0) {
            com.unisound.common.y.e("TTSParams checkSilenceTime: silence < 0 invoked silence = 0");
            i2 = 0;
        }
        return java.lang.Integer.valueOf(i2);
    }

    private boolean d(java.lang.String str) {
        return this.v.c(str);
    }

    private boolean e(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isDigitsOnly(str)) {
            return true;
        }
        com.unisound.common.y.a("TTSParams isNumberUseable: value is empty or unusable");
        return false;
    }

    private boolean f(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        com.unisound.common.y.a("TTSParams isStringUseable: value is empty");
        return false;
    }

    private boolean g(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            return false;
        }
        if (i(strArrSplit[1])) {
            return true;
        }
        com.unisound.common.y.a("TTSParams checkAddress: port unusable");
        return false;
    }

    private boolean h(java.lang.String str) {
        return java.util.regex.Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private boolean i(java.lang.String str) {
        try {
            int iIntValue = java.lang.Integer.valueOf(str).intValue();
            if (iIntValue > 0 && iIntValue < 65535) {
                return true;
            }
            com.unisound.common.y.a("TTSParams checkPort: port Illegal");
            return false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.unisound.common.y.a("TTSParams checkPort: port changeTo integer exception");
            return false;
        }
    }

    public int A() {
        return this.C;
    }

    public void A(java.lang.Object obj) {
        this.V = E(obj);
    }

    public int B() {
        return this.z;
    }

    public void B(java.lang.Object obj) {
        this.Q = a(v(obj));
    }

    public int C() {
        return this.E;
    }

    public void C(java.lang.Object obj) {
        this.R = a(v(obj));
    }

    public java.util.List<java.lang.Integer> D() {
        return this.F;
    }

    public void D(java.lang.Object obj) {
        int iIntValue = v(obj).intValue();
        if (iIntValue > 1000) {
            iIntValue = 1000;
        } else if (iIntValue < 100) {
            iIntValue = 100;
        }
        this.aa = iIntValue;
    }

    public int E() {
        return this.G;
    }

    public java.lang.String F() {
        return this.H;
    }

    public java.lang.String G() {
        return this.I;
    }

    public java.lang.Integer H() {
        return this.J;
    }

    public java.util.Map<java.lang.String, java.lang.Integer> I() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_VOICE_SPEED_JSONKEY, 2001);
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_VOICE_PITCH_JSONKEY, 2002);
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_VOICE_VOLUME_JSONKEY, 2003);
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_SAMPLE_RATE_JSONKEY, 2004);
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_VOICE_NAME_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_KEY_VOICE_NAME));
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_SERVER_ADDR_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_KEY_SERVER_ADDR));
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_PLAY_START_BUFFER_TIME_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_KEY_PLAY_START_BUFFER_TIME));
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_STREAM_TYPE_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_KEY_STREAM_TYPE));
        map.put(com.unisound.client.SpeechConstants.TTS_KEY_IS_DEBUG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_KEY_IS_DEBUG));
        map.put(com.unisound.client.SpeechConstants.TTS_SERVICE_MODE_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.TTS_SERVICE_MODE));
        return map;
    }

    public int J() {
        return this.O;
    }

    public boolean K() {
        return this.U;
    }

    public int L() {
        return this.P;
    }

    public boolean M() {
        return this.V;
    }

    public int N() {
        return this.Q;
    }

    public int O() {
        return this.R;
    }

    public long P() {
        return this.aa;
    }

    public long Q() {
        return this.ab;
    }

    public java.lang.Object a(int i2) {
        return null;
    }

    public void a(long j2) {
        if (j2 < 1) {
            this.ab = 1L;
        } else {
            this.ab = j2;
        }
    }

    public void a(java.io.InputStream inputStream) {
        this.ac = inputStream;
    }

    public void a(java.lang.Object obj) {
        this.X = r(obj);
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public void a(java.lang.String str, int i2) {
        this.v.a(str);
        this.v.a(i2);
        this.v.b(str);
        this.v.b(i2);
    }

    public boolean a(int i2, java.lang.Object obj) {
        return false;
    }

    public com.unisound.sdk.c b() {
        return this.c;
    }

    public void b(int i2) {
        if (i2 != 8000) {
            if (i2 == 16000 || i2 == 22050 || i2 == 24000 || i2 == 48000) {
                this.E = i2;
            }
        }
    }

    public void b(java.io.InputStream inputStream) {
        this.ad = inputStream;
    }

    public void b(java.lang.Object obj) {
        this.W = r(obj);
    }

    public void b(java.lang.String str) {
        this.H = str;
    }

    public java.lang.String c() {
        return this.v.a();
    }

    public void c(java.io.InputStream inputStream) {
        this.ae = inputStream;
    }

    public void c(java.lang.Object obj) {
        this.Y = r(obj);
    }

    public void c(java.lang.String str) {
        this.I = str;
    }

    public int d() {
        return this.v.c();
    }

    public void d(java.io.InputStream inputStream) {
        this.af = inputStream;
    }

    public void d(java.lang.Object obj) {
        this.Z = r(obj);
    }

    public void e() {
        this.v.e();
    }

    public void e(java.lang.Object obj) {
        this.T = E(obj);
    }

    public com.unisound.common.a f() {
        return this.v;
    }

    public void f(java.lang.Object obj) {
        this.S = E(obj);
    }

    public java.lang.String g() {
        return this.X;
    }

    public void g(java.lang.Object obj) {
        this.L = java.lang.Boolean.valueOf(E(obj));
    }

    public java.lang.String h() {
        return this.W;
    }

    public void h(java.lang.Object obj) {
        this.M = c(v(obj).intValue()).intValue();
    }

    public java.lang.String i() {
        return this.Y;
    }

    public void i(java.lang.Object obj) {
        this.N = c(v(obj).intValue()).intValue();
    }

    public java.lang.String j() {
        return this.Z;
    }

    public void j(java.lang.Object obj) {
        this.K = v(obj).intValue();
    }

    public java.io.InputStream k() {
        return this.ac;
    }

    public void k(java.lang.Object obj) {
        this.x = java.lang.Boolean.valueOf(E(obj));
    }

    public java.io.InputStream l() {
        return this.ad;
    }

    public void l(java.lang.Object obj) {
        java.lang.String strR = r(obj);
        if (strR == null) {
            com.unisound.common.y.a("TTSParams setDebugDir: mDebugDir is null");
        } else {
            this.y = strR;
        }
    }

    public java.io.InputStream m() {
        return this.ae;
    }

    public void m(java.lang.Object obj) {
        java.lang.String str;
        java.lang.String strR = r(obj);
        if (strR == null) {
            str = "TTSParams setVoiceName: voiceName is null";
        } else {
            if (f(strR)) {
                this.D = strR;
                return;
            }
            str = "TTSParams setVoiceName: voiceName unusable";
        }
        com.unisound.common.y.a(str);
    }

    public java.io.InputStream n() {
        return this.af;
    }

    public void n(java.lang.Object obj) {
        this.A = a(v(obj));
    }

    public java.lang.String o() {
        return this.b;
    }

    public void o(java.lang.Object obj) {
        this.B = a(v(obj));
    }

    public void p(java.lang.Object obj) {
        this.C = a(v(obj));
    }

    public boolean p() {
        return this.T;
    }

    public void q(java.lang.Object obj) {
        java.lang.Integer numV = v(obj);
        if (numV.intValue() > 15000) {
            numV = 15000;
            com.unisound.common.y.e("TTSParams setPlayStartBufferTime: playStartBufferTime > 15000 ", java.lang.Integer.valueOf(numV.intValue()));
        }
        if (numV.intValue() <= 0) {
            numV = 1;
            com.unisound.common.y.e("TTSParams setPlayStartBufferTime: playStartBufferTime < 0 ", java.lang.Integer.valueOf(numV.intValue()));
        }
        this.z = numV.intValue();
    }

    public boolean q() {
        return this.S;
    }

    public java.lang.Boolean r() {
        return this.L;
    }

    public java.lang.String r(java.lang.Object obj) {
        java.lang.String str;
        if (obj == null) {
            str = "TTSParams object2String: obj is null";
        } else {
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            str = "TTSParams object2String: obj can not change to String";
        }
        com.unisound.common.y.a(str);
        return null;
    }

    public int s() {
        return this.M;
    }

    public void s(java.lang.Object obj) {
        java.lang.String strR = r(obj);
        if (strR == null) {
            com.unisound.common.y.a("TTSParams addField: value is null");
            return;
        }
        try {
            this.F.add(java.lang.Integer.valueOf(java.lang.Integer.valueOf(strR).intValue()));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.unisound.common.y.a("TTSParams addField: value can not change to integer");
        }
    }

    public int t() {
        return this.N;
    }

    public boolean t(java.lang.Object obj) {
        java.lang.String strR = r(obj);
        if (g(strR)) {
            return d(strR);
        }
        com.unisound.common.y.a("TTSParams setServerAddress: address unusable");
        return false;
    }

    public int u() {
        return this.K;
    }

    public void u(java.lang.Object obj) {
        java.lang.Integer numV = v(obj);
        if (numV.intValue() < 0 || numV.intValue() > 8) {
            com.unisound.common.y.a("TTSParams setStreamType: mStreamType unusable");
        } else {
            this.G = numV.intValue();
        }
    }

    public java.lang.Boolean v() {
        return this.x;
    }

    public java.lang.Integer v(java.lang.Object obj) {
        java.lang.String str;
        if (obj == null) {
            str = "TTSParams object2Integer: obj is null";
        } else {
            if (obj instanceof java.lang.Integer) {
                return (java.lang.Integer) obj;
            }
            str = "TTSParams object2Integer: obj can not change to integer";
        }
        com.unisound.common.y.a(str);
        return 1;
    }

    public java.lang.String w() {
        return this.y;
    }

    public void w(java.lang.Object obj) {
        java.lang.Integer numV = v(obj);
        if (numV.intValue() == 1 || numV.intValue() == 2 || numV.intValue() == 3) {
            this.J = numV;
        } else {
            com.unisound.common.y.a("TTSParams setMode: mMode unusable");
        }
    }

    public java.lang.String x() {
        return this.D;
    }

    public void x(java.lang.Object obj) {
        int iIntValue = v(obj).intValue();
        if (iIntValue > 30) {
            iIntValue = 30;
        } else if (iIntValue <= 0) {
            iIntValue = 1;
        }
        this.O = iIntValue;
    }

    public int y() {
        return this.A;
    }

    public void y(java.lang.Object obj) {
        this.U = E(obj);
    }

    public int z() {
        return this.B;
    }

    public void z(java.lang.Object obj) {
        this.P = v(obj).intValue();
    }
}
