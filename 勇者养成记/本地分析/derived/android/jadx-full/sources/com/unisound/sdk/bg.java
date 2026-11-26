package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class bg extends com.unisound.sdk.o {
    private static final int O = 1;
    private static final int P = 5;
    private static final int Q = 6;
    private static final int R = 7;
    private static final int S = 11;
    private static final int T = 12;
    private static final int U = 13;
    private static final int V = 14;
    private static final int W = 15;
    private static final int X = 16;
    private static final int Y = 17;
    private static final int Z = 18;
    private static java.lang.String aD = "[REDACTED_HEX_CONSTANT]";
    private static final int aJ = 0;
    private static final int aK = 1;
    private static final int aL = 2;
    private static final int aM = 3;
    private static final int aa = 20;
    private static final int ab = 21;
    private static final int ac = 22;
    private static final int ad = 23;
    private static final int ae = 24;
    private static final int af = 25;
    private static final int ag = 30;
    private static final int ah = 40;
    private static final int ai = 50;
    private static final int aj = 60;
    private static final int ak = 61;
    private static final int al = 62;
    private com.unisound.sdk.cm A;
    private com.unisound.sdk.y B;
    private boolean C;
    private boolean D;
    private java.lang.String E;
    private int F;
    private int G;
    private com.unisound.sdk.aw H;
    private java.lang.String I;
    private java.lang.String J;
    private int K;
    private boolean L;
    private boolean M;
    private boolean N;
    private com.unisound.sdk.h aA;
    private com.unisound.sdk.g aB;
    private com.unisound.common.ba aC;
    private java.lang.String aE;
    private com.unisound.sdk.ac aF;
    private com.unisound.common.ag aG;
    private boolean aH;
    private com.unisound.sdk.ad aI;
    private com.unisound.b.a.a aN;
    private android.os.Handler aO;
    private java.lang.Runnable aP;
    private java.lang.String aQ;
    private com.unisound.common.ao am;
    private android.content.Context an;
    private android.os.HandlerThread ao;
    private android.os.Handler ap;
    private android.os.Handler aq;
    private int ar;
    private int as;
    private boolean at;
    private java.lang.String au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private java.lang.Object az;
    protected com.unisound.sdk.ao o;
    protected com.unisound.sdk.cx p;
    protected final int q;
    protected final int r;
    protected final int s;
    protected final int t;
    java.util.ArrayList<java.lang.String> u;
    java.util.ArrayList<java.lang.String> v;
    java.util.ArrayList<java.lang.String> w;
    java.lang.String x;
    java.lang.String y;
    private com.unisound.client.SpeechUnderstanderListener z;

    protected bg(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str);
        this.B = null;
        this.C = true;
        this.D = true;
        this.E = "";
        this.F = 1;
        this.G = -1;
        this.H = new com.unisound.sdk.aw();
        this.p = new com.unisound.sdk.cx();
        this.I = "main";
        this.J = com.unisound.sdk.cx.f1560a;
        this.q = 51;
        this.r = 52;
        this.s = 53;
        this.t = 54;
        this.K = 0;
        this.L = false;
        this.M = false;
        this.N = false;
        this.as = 5;
        this.at = false;
        this.au = "";
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = new java.lang.Object();
        this.aE = "";
        this.aF = new com.unisound.sdk.bh(this);
        this.aH = false;
        this.aI = new com.unisound.sdk.bl(this);
        this.aP = new com.unisound.sdk.bo(this);
        this.aQ = "";
        this.aC = com.unisound.common.ba.a();
        this.an = context;
        this.x = str;
        this.y = str2;
        this.aG = new com.unisound.common.ag(context);
        this.p.a(this.f.f1512a);
        this.f.a(this.aF);
        this.A = this.b.aX();
        this.A.b(str);
        this.A.c(str2);
        this.b.o(str);
        this.b.O(1);
        this.o = new com.unisound.sdk.ao(this.b, this.mLooper);
        this.L = false;
        this.u = new java.util.ArrayList<>();
        this.v = new java.util.ArrayList<>();
        this.w = new java.util.ArrayList<>();
        this.am = new com.unisound.common.ao(new com.unisound.sdk.bi(this), this.mLooper);
        this.am.c();
        this.aA = new com.unisound.sdk.h(this);
        this.aB = this.f.h();
    }

    private void D() {
        if (this.aG.a("android.permission.RECORD_AUDIO") != 0) {
            com.unisound.common.y.a("no RECORD_AUDIO permission");
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener = this.z;
            if (speechUnderstanderListener != null) {
                speechUnderstanderListener.onEvent(1159, (int) java.lang.System.currentTimeMillis());
            }
        }
        if (this.aG.a("android.permission.READ_CONTACTS") != 0) {
            com.unisound.common.y.a("no READ_CONTACTS permission");
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener2 = this.z;
            if (speechUnderstanderListener2 != null) {
                speechUnderstanderListener2.onEvent(com.unisound.client.SpeechConstants.GENERAL_EVENT_REQUIRE_READ_CONTACTS_PERMISSION, (int) java.lang.System.currentTimeMillis());
            }
        }
        if (this.aG.a("android.permission.ACCESS_FINE_LOCATION") != 0) {
            com.unisound.common.y.a("no ACCESS_FINE_LOCATION permission");
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener3 = this.z;
            if (speechUnderstanderListener3 != null) {
                speechUnderstanderListener3.onEvent(com.unisound.client.SpeechConstants.GENERAL_EVENT_REQUIRE_ACCESS_FINE_LOCATION_PERMISSION, (int) java.lang.System.currentTimeMillis());
            }
        }
        if (this.aG.a("android.permission.READ_PHONE_STATE") != 0) {
            com.unisound.common.y.a("no READ_PHONE_STATE permission");
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener4 = this.z;
            if (speechUnderstanderListener4 != null) {
                speechUnderstanderListener4.onEvent(1151, (int) java.lang.System.currentTimeMillis());
            }
        }
        if (this.aG.a("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            com.unisound.common.y.a("no WRITE_EXTERNAL_STORAGE permission");
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener5 = this.z;
            if (speechUnderstanderListener5 != null) {
                speechUnderstanderListener5.onEvent(com.unisound.client.SpeechConstants.GENERAL_EVENT_REQUIRE_WRITE_EXTERNAL_STORAGE_PERMISSION, (int) java.lang.System.currentTimeMillis());
            }
        }
    }

    private boolean E() {
        return this.A.y();
    }

    private int F() {
        return this.A.z();
    }

    private boolean G() {
        return this.C;
    }

    private boolean H() {
        return this.D;
    }

    private com.unisound.common.av I() {
        return this.o.p();
    }

    private com.unisound.common.au J() {
        return this.o.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void K() throws java.lang.Throwable {
        android.os.Handler handler;
        java.lang.String strA;
        if (G() && H()) {
            int i = this.F;
            if (i == 0) {
                handler = this.ap;
                strA = com.unisound.common.v.a(this.u, this.v, this.w);
            } else {
                if (i != 2 || this.I.equals(this.J)) {
                    if (this.F == 1) {
                        handler = this.ap;
                        strA = com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) null, this.v, this.w);
                    }
                    this.ax = true;
                    stop();
                    if (this.ay) {
                        this.ap.sendEmptyMessage(5);
                    }
                }
                handler = this.ap;
                strA = com.unisound.common.v.a(this.u, (java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) null);
            }
            handler.obtainMessage(com.unisound.client.SpeechConstants.ASR_RESULT_RECOGNITION, strA).sendToTarget();
            this.ax = true;
            stop();
            if (this.ay) {
                this.ap.sendEmptyMessage(5);
            }
        }
    }

    private void L() {
        if (this.v.size() == 0) {
            this.v.add(com.unisound.common.v.a(this.F, com.unisound.common.v.b, "", "", true, null, null, null, null, null, null));
        }
        if (this.A.w() && this.w.size() == 0) {
            this.w.add(com.unisound.common.v.a(-1, null, "", null, null, null, null, null, null, null, null));
        }
        if (this.u.size() == 0) {
            this.u.add(com.unisound.common.v.a(this.F, com.unisound.common.v.b, "", null, null, java.lang.Float.valueOf(-20.0f), null, null, null, null, null));
        }
    }

    private int M() {
        if (this.L) {
            return 0;
        }
        com.unisound.common.y.a("init error " + com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_INIT_ERROR));
        com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener = this.z;
        if (speechUnderstanderListener == null) {
            return -1;
        }
        speechUnderstanderListener.onError(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_INIT_ERROR));
        return -1;
    }

    private java.lang.String N() {
        int iV = v();
        java.lang.String strW = "";
        switch (iV) {
            case 1:
                strW = w();
                break;
            case 2:
                strW = x();
                break;
            case 3:
                strW = ("" + w() + "|") + x();
                break;
        }
        return "commit=" + g() + ";authorized_status=" + iV + ":" + strW;
    }

    private boolean O() {
        if (this.b.c != null) {
            return this.b.c.a();
        }
        return false;
    }

    private int P() {
        return this.b.ad();
    }

    private int Q() {
        return this.b.ae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.aO = new android.os.Handler(this.mLooper);
        this.aO.removeCallbacks(this.aP);
        this.aO.postDelayed(this.aP, 43200000L);
        com.unisound.common.y.c(com.unisound.common.y.v, "refresh activate timer start");
    }

    private void S() {
        if (this.aA.a()) {
            try {
                com.unisound.common.y.c(com.unisound.common.y.v, "unregiste network broadcastReceiver!");
                this.an.unregisterReceiver(this.aA);
                this.aA.b(false);
            } catch (java.lang.Exception e) {
                com.unisound.common.y.a(com.unisound.common.y.v, "unRegisteBroadcast exception");
                e.printStackTrace();
            }
        }
    }

    private int T() {
        if (this.aB.a()) {
            return 0;
        }
        com.unisound.common.y.a("init error " + com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR));
        com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener = this.z;
        if (speechUnderstanderListener == null) {
            return -1;
        }
        speechUnderstanderListener.onError(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR));
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        cn.yunzhisheng.asr.JniUscClient jniUscClient = new cn.yunzhisheng.asr.JniUscClient();
        com.unisound.common.a aVarBb = this.b.bb();
        long jA = jniUscClient.a(aVarBb.a(), aVarBb.c());
        jniUscClient.a(9, this.x);
        jniUscClient.a(204, this.y);
        com.unisound.common.y.c("SpeechUnderstanderInterface", "server :", aVarBb.a(), " port: ", java.lang.Integer.valueOf(aVarBb.c()));
        com.unisound.common.y.c("SpeechUnderstanderInterface", "juc.create() returns ", java.lang.Long.valueOf(jA));
        a(jniUscClient);
        jniUscClient.a(1015, this.b.aQ());
        jniUscClient.a(207, this.b.bs());
        this.aQ = "";
        int iA = jniUscClient.a();
        this.aQ = jniUscClient.c(21);
        this.b.x(this.aQ);
        if (iA == 0) {
            a(jniUscClient, this.aQ);
            return;
        }
        com.unisound.common.y.a(com.unisound.common.y.D, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iA), (java.lang.String) null);
        com.unisound.common.y.c("NetRecognition --> start error occured! , startCode = ", java.lang.Integer.valueOf(iA), ", sessionId = ", this.aQ);
        this.ap.obtainMessage(60, iA, 0, com.unisound.client.ErrorCode.toJsonMessage(iA)).sendToTarget();
        jniUscClient.e();
        this.b.bc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        return (this.b.aW().g() == 4 || this.b.aW().g() == 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W() {
        return this.b.aQ() >= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        return this.b.aQ() % 2 != 0;
    }

    private void a(android.content.IntentFilter intentFilter) {
        if (this.aA.a()) {
            return;
        }
        try {
            com.unisound.common.y.a(com.unisound.common.y.v, "registe network broadcastReceiver!");
            this.an.registerReceiver(this.aA, intentFilter);
            this.aA.b(true);
        } catch (java.lang.Exception e) {
            com.unisound.common.y.a(com.unisound.common.y.v, "registeBroadcast exception");
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:19:0x013c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0144  */
    /* JADX WARN: Code duplicated, block: B:22:0x0147  */
    /* JADX WARN: Code duplicated, block: B:26:0x0152  */
    /* JADX WARN: Code duplicated, block: B:29:0x0186  */
    /* JADX WARN: Code duplicated, block: B:30:0x018d  */
    /* JADX WARN: Code duplicated, block: B:33:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:36:0x01af  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient) {
        java.lang.String strA;
        java.lang.String strBu;
        java.lang.String str;
        java.lang.String str2;
        com.unisound.sdk.i iVarBa = this.b.ba();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.unisound.sdk.cu cuVarAW = this.b.aW();
        jniUscClient.a(1015, 8);
        jniUscClient.a(1020, 1);
        jniUscClient.a(1019, this.b.bi());
        sb.append("serviceTypeName=");
        if (cuVarAW.g() != 3) {
            str2 = cuVarAW.g() == 4 ? "whetherBind" : "unBindClient";
            sb.append(";");
            sb.append("subSystemId=");
            sb.append(cuVarAW.b());
            sb.append(";");
            sb.append("bindMode=");
            sb.append(cuVarAW.a());
            sb.append(";");
            sb.append("customizedName=");
            sb.append(cuVarAW.d());
            sb.append(";");
            sb.append("inputDataType=");
            sb.append("audio");
            sb.append(";");
            sb.append("returnType=");
            sb.append("json");
            sb.append(";");
            sb.append("scene=");
            sb.append(cuVarAW.c());
            sb.append(";");
            com.unisound.common.y.c("vpr params:  ", sb.toString());
            if (this.b.br() != null) {
                sb.append(";");
                sb.append(this.b.br());
            }
            sb.append(iVarBa.toString());
            jniUscClient.a(34, sb.toString());
            if (this.b.aY() != null && this.b.aY().a()) {
                com.unisound.common.y.a("updateAsrScene " + this.b.aY().c() + " res : " + jniUscClient.a(31, this.b.aY().c()));
                this.b.aY().a(false);
            }
            if (this.b.aG) {
                if (this.b.aJ) {
                    str = cn.yunzhisheng.asr.JniUscClient.r;
                } else {
                    str = cn.yunzhisheng.asr.JniUscClient.s;
                }
                jniUscClient.a(20, str);
            }
            if (this.b.aW != 0) {
                jniUscClient.a(32, this.b.aW);
            }
            jniUscClient.a(this.b.bf());
            jniUscClient.a(9, this.b.aZ());
            jniUscClient.a(8, com.unisound.c.a.q);
            strA = com.unisound.c.a.a(this.b.aZ());
            if (this.b.bu() != null) {
                strBu = this.b.bu();
            } else {
                strBu = strA;
            }
            jniUscClient.a(14, strBu);
            jniUscClient.a(22, strA);
            if (this.b.bh()) {
                jniUscClient.a(17, cn.yunzhisheng.asr.JniUscClient.p);
            }
            if (this.b.br() != null) {
                jniUscClient.a(cn.yunzhisheng.asr.JniUscClient.ac, this.b.br());
            }
        }
        sb.append(str2);
        sb.append(";");
        sb.append("subSystemId=");
        sb.append(cuVarAW.b());
        sb.append(";");
        sb.append("bindMode=");
        sb.append(cuVarAW.a());
        sb.append(";");
        sb.append("customizedName=");
        sb.append(cuVarAW.d());
        sb.append(";");
        sb.append("inputDataType=");
        sb.append("audio");
        sb.append(";");
        sb.append("returnType=");
        sb.append("json");
        sb.append(";");
        sb.append("scene=");
        sb.append(cuVarAW.c());
        sb.append(";");
        com.unisound.common.y.c("vpr params:  ", sb.toString());
        if (this.b.br() != null) {
            sb.append(";");
            sb.append(this.b.br());
        }
        sb.append(iVarBa.toString());
        jniUscClient.a(34, sb.toString());
        if (this.b.aY() != null) {
            com.unisound.common.y.a("updateAsrScene " + this.b.aY().c() + " res : " + jniUscClient.a(31, this.b.aY().c()));
            this.b.aY().a(false);
        }
        if (this.b.aG) {
            if (this.b.aJ) {
                str = cn.yunzhisheng.asr.JniUscClient.r;
            } else {
                str = cn.yunzhisheng.asr.JniUscClient.s;
            }
            jniUscClient.a(20, str);
        }
        if (this.b.aW != 0) {
            jniUscClient.a(32, this.b.aW);
        }
        jniUscClient.a(this.b.bf());
        jniUscClient.a(9, this.b.aZ());
        jniUscClient.a(8, com.unisound.c.a.q);
        strA = com.unisound.c.a.a(this.b.aZ());
        if (this.b.bu() != null) {
            strBu = this.b.bu();
        } else {
            strBu = strA;
        }
        jniUscClient.a(14, strBu);
        jniUscClient.a(22, strA);
        if (this.b.bh()) {
            jniUscClient.a(17, cn.yunzhisheng.asr.JniUscClient.p);
        }
        if (this.b.br() != null) {
            jniUscClient.a(cn.yunzhisheng.asr.JniUscClient.ac, this.b.br());
        }
    }

    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient, java.lang.String str) {
        jniUscClient.a(new byte[0], 0);
        int iB = jniUscClient.b();
        if (iB < 0) {
            com.unisound.common.y.c("NetRecognition --> stop error occured! , stopCode = ", java.lang.Integer.valueOf(iB), ", sessionId = ", str);
            com.unisound.common.y.a(com.unisound.common.y.F, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iB), (java.lang.String) null);
            this.ap.obtainMessage(60, iB, 0, com.unisound.client.ErrorCode.toMessage(iB)).sendToTarget();
            jniUscClient.e();
            return;
        }
        android.util.Log.e("stopcode", iB + " feedBufferStatus:" + jniUscClient.c(60));
        com.unisound.sdk.al alVar = new com.unisound.sdk.al();
        alVar.a(com.unisound.sdk.am.NET);
        alVar.b(str);
        java.lang.String strC = jniUscClient.c(61);
        alVar.a(true);
        alVar.a(strC);
        jniUscClient.e();
        if (android.text.TextUtils.isEmpty(strC)) {
            this.ap.obtainMessage(60, com.unisound.client.ErrorCode.OTHER_ERROR, 0, com.unisound.client.ErrorCode.toMessage(com.unisound.client.ErrorCode.OTHER_ERROR)).sendToTarget();
        } else {
            this.aI.a(alVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.unisound.sdk.al alVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.unisound.sdk.b bVar = new com.unisound.sdk.b();
        bVar.a(alVar);
        bVar.a(this.F);
        bVar.a(false);
        bVar.b(this.b.ao());
        arrayList.add(com.unisound.common.v.a(bVar));
        this.ap.obtainMessage(1201, com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) arrayList, (java.util.ArrayList<java.lang.String>) null)).sendToTarget();
    }

    private void a(java.lang.String str, int i) {
        this.A.a(str, i);
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        new com.unisound.sdk.bm(this, str3, str4, str5, str6, str, str2).start();
    }

    private void a(org.json.JSONObject jSONObject) {
        this.b.n(jSONObject.toString());
        com.unisound.common.y.c(com.unisound.common.y.v, "activate params is ", jSONObject.toString());
        this.aN = com.unisound.b.a.a.a(this.an, this.b.aV());
        this.aN.a(new com.unisound.sdk.bn(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(java.util.List<java.lang.String> list) {
        com.unisound.sdk.cp cpVar = new com.unisound.sdk.cp(this.l, this.x);
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        int size = list.size();
        if (size > this.as) {
            return com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_EXCEED_MAXLIMIT;
        }
        int i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_ERROR;
        if (list != null && size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                if (android.text.TextUtils.isEmpty(list.get(i2))) {
                    return com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_EMPTY_WORD;
                }
                if (com.unisound.sdk.cp.a(list.get(i2))) {
                    return com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_ILLEGAL;
                }
            }
            java.lang.String strA = cpVar.a(com.unisound.c.a.a(this.x), cpVar.a(list));
            if (strA.contains("status")) {
                try {
                    i = java.lang.Integer.parseInt(new org.json.JSONObject(strA).getString("status"));
                } catch (java.lang.NumberFormatException e) {
                    e.printStackTrace();
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (i == 0) {
                java.util.HashSet hashSet = new java.util.HashSet();
                hashSet.addAll(list);
                cpVar.a(hashSet);
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.unisound.sdk.al alVar) {
        java.lang.String strA;
        if (this.A.y() && this.A.w() && (strA = com.unisound.common.v.a(alVar.a(), this.A.y(), this.b).a()) != null) {
            this.w.clear();
            this.w.add(strA);
            this.ap.obtainMessage(1201, com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) null, this.w)).sendToTarget();
        }
        if (alVar.c()) {
            if (this.A.w()) {
                java.lang.String strA2 = com.unisound.common.v.a(alVar.a(), this.A.y(), this.b).a();
                java.util.ArrayList<java.lang.String> arrayList = this.w;
                if (arrayList == null || strA2 == null) {
                    java.util.ArrayList<java.lang.String> arrayList2 = this.w;
                    if (arrayList2 != null && strA2 == null) {
                        arrayList2.clear();
                        q(com.unisound.client.ErrorCode.ASR_SDK_NO_NLURESULT_ERROR);
                    }
                } else {
                    arrayList.clear();
                    this.w.add(strA2);
                    this.ap.obtainMessage(1201, com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) null, this.w)).sendToTarget();
                }
            }
            this.b.k(java.lang.System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.unisound.sdk.al alVar) {
        if (!alVar.c() || this.b.ao() || alVar.d()) {
            return;
        }
        com.unisound.sdk.al alVar2 = new com.unisound.sdk.al();
        alVar2.a(alVar.e());
        alVar2.a(com.unisound.common.v.b());
        alVar2.b(alVar.b());
        alVar2.b(alVar.d());
        alVar2.a(alVar.c());
        com.unisound.sdk.b bVar = new com.unisound.sdk.b();
        bVar.a(alVar2);
        bVar.a(this.F);
        bVar.a(true);
        bVar.b(this.b.ao());
        this.v.add(com.unisound.common.v.a(bVar));
        this.ap.obtainMessage(1201, com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) null, this.v, this.w)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        boolean z;
        java.lang.String string;
        android.content.SharedPreferences sharedPreferences = this.l.getSharedPreferences(aD, 0);
        java.lang.String string2 = sharedPreferences.getString("deviceInfo", "");
        try {
            if (android.text.TextUtils.isEmpty(string2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(com.unisound.sdk.cb.c, str);
                jSONObject2.put("udid", str2);
                jSONObject2.put("[REDACTED]", str3);
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject.put("deviceInfo", jSONArray);
                string = jSONObject.toString();
            } else {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(string2);
                org.json.JSONArray jSONArray2 = jSONObject3.getJSONArray("deviceInfo");
                int i = 0;
                while (true) {
                    if (i >= jSONArray2.length()) {
                        z = false;
                        break;
                    }
                    org.json.JSONObject jSONObject4 = jSONArray2.getJSONObject(i);
                    if (str.equals(jSONObject4.get(com.unisound.sdk.cb.c)) && str2.equals(jSONObject4.get("udid"))) {
                        jSONObject4.put("[REDACTED]", str3);
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    jSONObject5.put(com.unisound.sdk.cb.c, str);
                    jSONObject5.put("udid", str2);
                    jSONObject5.put("[REDACTED]", str3);
                    jSONArray2.put(jSONObject5);
                    jSONObject3.put("deviceInfo", jSONArray2);
                }
                string = jSONObject3.toString();
            }
            com.unisound.common.y.c("[REDACTED]" + string);
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("deviceInfo", string);
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    private void e(boolean z) {
        this.A.a(z);
    }

    private void f(boolean z) {
        this.A.b(z);
    }

    private int g(boolean z) {
        if (!this.f.g && !a(z)) {
            com.unisound.common.y.a("loadModel::isInit=false");
            return -1;
        }
        return b((this.f.f1512a + "wakeup.dat") + "," + (this.f.f1512a + this.f.d + ".dat"), "init_asr");
    }

    private void g(java.lang.String str) {
        this.A.k(str);
    }

    private void g(java.lang.String str, java.lang.String str2) {
        cn.yunzhisheng.asr.JniUscClient jniUscClient = new cn.yunzhisheng.asr.JniUscClient();
        com.unisound.common.a aVarBb = this.b.bb();
        long jA = jniUscClient.a(aVarBb.a(), aVarBb.c());
        jniUscClient.a(9, str);
        jniUscClient.a(204, str2);
        com.unisound.common.y.c("SpeechUnderstanderInterface", "server :", aVarBb.a(), " port: ", java.lang.Integer.valueOf(aVarBb.c()));
        com.unisound.common.y.c("SpeechUnderstanderInterface", "juc.create() returns ", java.lang.Long.valueOf(jA));
    }

    private void h(java.lang.String str) {
        this.A.h(str);
    }

    private void h(boolean z) {
        this.b.o(z);
    }

    private void i(java.lang.String str) {
        this.A.i(str);
    }

    private void i(boolean z) {
        this.b.p(z);
    }

    public static boolean isNetworkAvailable(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.unisound.common.y.a(com.unisound.common.y.v, " isNetworkAvailable cm is null!");
            } else {
                android.net.NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    for (android.net.NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == android.net.NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("SpeechUnderstander isNetworkAvailable error");
        }
        return false;
    }

    private java.lang.String j(boolean z) {
        return this.b.t(true);
    }

    private void j(java.lang.String str) {
        this.A.j(str);
    }

    private void k(java.lang.String str) {
        this.A.e(str);
    }

    private void k(boolean z) {
        this.b.u(z);
    }

    private void l(java.lang.String str) {
        this.A.d(str);
    }

    private boolean l(boolean z) {
        if (this.b.c == null) {
            return false;
        }
        this.b.c.h(z);
        return true;
    }

    private void m(java.lang.String str) {
        this.A.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String n(java.lang.String str) {
        java.lang.String[] strArrSplit;
        if (str.contains("}{")) {
            strArrSplit = str.split("\\}\\{");
            for (int i = 0; i < strArrSplit.length; i++) {
                if (i == 0) {
                    strArrSplit[i] = strArrSplit[i] + "}";
                } else if (i == strArrSplit.length - 1) {
                    strArrSplit[i] = "{" + strArrSplit[i];
                } else {
                    strArrSplit[i] = "{" + strArrSplit[i] + "}";
                }
            }
        } else {
            strArrSplit = new java.lang.String[]{str};
        }
        java.lang.String str2 = strArrSplit[strArrSplit.length - 1];
        com.unisound.common.y.c("SpeechUnderstanderInterface", "rmUselessResult : results = ", strArrSplit.toString(), " , length = ", java.lang.Integer.valueOf(strArrSplit.length), " , result = ", str2);
        return str2;
    }

    private void n(int i) {
        this.A.a(i);
    }

    private void o(int i) {
        this.b.P(i);
    }

    private boolean o(java.lang.String str) {
        if (this.b.r(str)) {
            return true;
        }
        com.unisound.common.y.a("setNetEngine::error: unkown param " + str);
        return false;
    }

    private void p(int i) {
        this.o.c(i);
    }

    private boolean p(java.lang.String str) {
        if (this.b.s(str)) {
            return true;
        }
        com.unisound.common.y.a("setNetEngineSubModel::error: unkown param " + this.F);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        android.os.Message message = new android.os.Message();
        message.what = 54;
        message.obj = java.lang.Integer.valueOf(i);
        this.ap.sendMessage(message);
    }

    private void q(java.lang.String str) {
        this.b.p(str);
    }

    private java.lang.String r(java.lang.String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        java.lang.String str2 = new java.lang.String(android.util.Base64.decode(str, 0));
        com.unisound.common.y.c("SpeechUnderstanderInterface -> getversion : SDK_Version = ", str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i) {
        android.os.Message message = new android.os.Message();
        message.what = 54;
        message.obj = java.lang.Integer.valueOf(i);
        android.os.Handler handler = this.aq;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    private void s(int i) {
        this.b.v(i);
    }

    private boolean s(java.lang.String str) {
        java.lang.String strA = com.unisound.common.aa.a();
        if (str != null && strA != null) {
            if (strA.equals("[REDACTED]")) {
                return true;
            }
            java.lang.String[] strArrSplit = strA.split("#");
            java.lang.String strA2 = com.unisound.common.aa.a(str);
            for (java.lang.String str2 : strArrSplit) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    com.unisound.common.y.c("[REDACTED]" + str2 + "[REDACTED]" + str + "[REDACTED]" + strA2);
                    if (str2.equals(strA2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected int A() {
        int i = this.G;
        if ((i != -1 && i != 2) || this.F != 2) {
            if (this.F != 2) {
                if (s(this.x)) {
                    this.N = true;
                } else {
                    q(com.unisound.client.ErrorCode.ASR_SDK_APPKEY_MD5_CHECK_ERROR);
                }
            }
            if (this.b != null) {
                this.b.G("normal");
            }
        }
        if (this.L) {
            return -1;
        }
        int i2 = this.G;
        if ((i2 == -1 || i2 == 1) && this.F == 1) {
            this.L = true;
            android.os.Handler handler = this.ap;
            if (handler != null) {
                handler.sendEmptyMessage(com.unisound.client.SpeechConstants.ASR_EVENT_INIT_DONE);
            }
            return 0;
        }
        this.L = true;
        s();
        int iG = g(this.b.aJ());
        this.M = true;
        com.unisound.common.y.c("SpeechUnderstanderInterface : loadResult = ", java.lang.Integer.valueOf(iG));
        return iG;
    }

    protected int B() {
        return this.K;
    }

    protected java.lang.String C() {
        return this.p.a();
    }

    protected int a(java.util.List<java.lang.String> list) {
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        if (T() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR;
        }
        if (list == null || list.size() <= 0) {
            return -1;
        }
        this.p.b(list);
        this.p.a(true);
        if (!this.p.c()) {
            return -1;
        }
        a(com.unisound.sdk.cx.f1560a, com.unisound.sdk.cx.f1560a, this.f.b(com.unisound.sdk.cx.f1560a), this.p.b(), this.p.d(), this.p.a());
        this.p.a(false);
        return 0;
    }

    protected int a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.util.List<java.lang.String> listA = this.b.a(map);
        if (listA != null) {
            com.unisound.common.y.c("SpeechUnderstanderInterface: setWakeupWord");
            return a(listA);
        }
        com.unisound.common.y.c("SpeechUnderstanderInterface: setWakeupWord error");
        return -1;
    }

    protected int a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str) {
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        if (T() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR;
        }
        if (map == null || str == "") {
            com.unisound.common.y.a("SpeechUnderstanderInterface : insertVocab parmas error!");
            return -1;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            stringBuffer.append(this.f.a(entry.getKey(), entry.getValue()) + "\n");
        }
        a(com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND, str, this.f.b(str), this.f.f(str), stringBuffer.toString(), this.f.g(str));
        return 0;
    }

    @Override // com.unisound.sdk.o
    protected void a(int i) {
        android.os.Handler handler = this.ap;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    @Override // com.unisound.sdk.o
    protected void a(cn.yunzhisheng.asr.VAD vad) {
        if (this.I.equals(this.J) && this.b.at()) {
            return;
        }
        this.ap.sendEmptyMessage(18);
    }

    protected void a(com.unisound.sdk.ay ayVar) {
        this.o.a(ayVar);
    }

    @Override // com.unisound.sdk.o
    protected void a(java.lang.String str, boolean z, int i, int i2) {
        java.util.ArrayList<java.lang.String> arrayList;
        int i3;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.Object obj;
        java.lang.Float fValueOf;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        java.lang.Integer numValueOf;
        java.lang.Integer numValueOf2;
        this.aH = true;
        if (this.z != null && this.f1569a.a(str, false, this.b.aH()) && this.mSpeechUnderstanderParams.i() != 1) {
            this.u.clear();
            for (int i4 = 0; i4 < this.f1569a.f1567a.size(); i4++) {
                com.unisound.common.y.c("SpeechUnderstanderInterface : recognizeResult.item = ", this.f1569a.f1567a.get(i4), " , times=  ", java.lang.Integer.valueOf(i4));
                if (this.b.aO()) {
                    arrayList = this.u;
                    i3 = this.F;
                    str2 = com.unisound.common.v.b;
                    str3 = this.f1569a.f1567a.get(i4);
                    str4 = null;
                    obj = null;
                    fValueOf = java.lang.Float.valueOf(this.f1569a.e);
                    obj2 = null;
                    obj3 = null;
                    obj4 = null;
                    numValueOf = java.lang.Integer.valueOf(i);
                    numValueOf2 = java.lang.Integer.valueOf(i2);
                } else {
                    arrayList = this.u;
                    i3 = this.F;
                    str2 = com.unisound.common.v.b;
                    str3 = this.f1569a.f1567a.get(i4);
                    str4 = null;
                    obj = null;
                    fValueOf = java.lang.Float.valueOf(this.f1569a.e);
                    obj2 = null;
                    obj3 = null;
                    obj4 = null;
                    numValueOf = null;
                    numValueOf2 = null;
                }
                arrayList.add(com.unisound.common.v.a(i3, str2, str3, str4, obj, fValueOf, obj2, obj3, obj4, numValueOf, numValueOf2));
            }
            this.ap.obtainMessage(1202, com.unisound.common.v.a(this.u, (java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) null)).sendToTarget();
        }
        this.aH = false;
    }

    @Override // com.unisound.sdk.o
    protected void a(java.lang.String str, boolean z, int i, long j, long j2, int i2, int i3) {
        int i4;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.Object obj;
        java.lang.Float fValueOf;
        java.lang.Integer numValueOf;
        java.lang.Long lValueOf;
        java.lang.Long lValueOf2;
        java.lang.Integer numValueOf2;
        java.lang.Integer numValueOf3;
        com.unisound.common.y.c("SpeechUnderstandInterface doWakeupResult => ", str);
        this.aH = true;
        if (this.z != null && this.f1569a.a(str, true, this.b.aH())) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (this.b.aO()) {
                i4 = 1000;
                str2 = com.unisound.common.v.b;
                str3 = this.f1569a.f1567a.get(0);
                str4 = null;
                obj = null;
                fValueOf = java.lang.Float.valueOf(this.f1569a.e);
                numValueOf = java.lang.Integer.valueOf(i);
                lValueOf = java.lang.Long.valueOf(j);
                lValueOf2 = java.lang.Long.valueOf(j2);
                numValueOf2 = java.lang.Integer.valueOf(i2);
                numValueOf3 = java.lang.Integer.valueOf(i3);
            } else {
                i4 = 1000;
                str2 = com.unisound.common.v.b;
                str3 = this.f1569a.f1567a.get(0);
                str4 = null;
                obj = null;
                fValueOf = java.lang.Float.valueOf(this.f1569a.e);
                numValueOf = java.lang.Integer.valueOf(i);
                lValueOf = java.lang.Long.valueOf(j);
                lValueOf2 = java.lang.Long.valueOf(j2);
                numValueOf2 = null;
                numValueOf3 = null;
            }
            arrayList.add(com.unisound.common.v.a(i4, str2, str3, str4, obj, fValueOf, numValueOf, lValueOf, lValueOf2, numValueOf2, numValueOf3));
            this.ap.obtainMessage(3201, com.unisound.common.v.a((java.util.ArrayList<java.lang.String>) arrayList, (java.util.ArrayList<java.lang.String>) null, (java.util.ArrayList<java.lang.String>) null)).sendToTarget();
            this.ap.sendEmptyMessage(1);
        }
        this.aH = false;
    }

    @Override // com.unisound.sdk.o
    protected void a(boolean z, byte[] bArr, int i, int i2) {
        super.a(z, bArr, i, i2);
        if (this.B != null) {
            this.o.b(z, bArr, i, i2);
        }
        this.H.a(z, i2);
    }

    @Override // com.unisound.sdk.o
    protected void b(int i) throws java.lang.Throwable {
        com.unisound.sdk.ao aoVar;
        if (i == -61002 && (aoVar = this.o) != null) {
            aoVar.d();
        }
        this.aH = true;
        if (this.z != null) {
            if (i != 0) {
                q(i);
            }
            this.D = true;
            this.ap.sendEmptyMessage(6);
            K();
        }
        this.aH = false;
    }

    @Override // com.unisound.sdk.o
    protected void b(int i, int i2) {
        android.os.Handler handler = this.aq;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    @Override // com.unisound.sdk.o
    protected void b(java.lang.String str) throws java.lang.Throwable {
        com.unisound.sdk.w wVar;
        int iAy;
        com.unisound.sdk.w wVar2;
        boolean zN;
        int i;
        com.unisound.common.y.c(com.unisound.common.y.v, "start recognition tag is ", str);
        D();
        if (str == null) {
            q(com.unisound.client.ErrorCode.ASR_SDK_START_ERROR);
            return;
        }
        if (this.F != 2 && !this.N) {
            q(com.unisound.client.ErrorCode.ASR_SDK_APPKEY_MD5_CHECK_ERROR);
            return;
        }
        this.av = false;
        this.b.O(false);
        this.b.F(com.unisound.c.a.a(this.x, this.an));
        if (this.mSpeechUnderstanderParams.o()) {
            if (this.b.c.s()) {
                this.b.c.q();
            }
            h(true);
            i(this.mSpeechUnderstanderParams.p());
            k(this.mSpeechUnderstanderParams.q());
        }
        if (z() > 1) {
            e(this.b.Y());
        }
        if (this.b.Y() == 0) {
            if (g().contains("V3.")) {
                h(this.b.aD());
                i(this.b.aE());
                j(this.b.aF());
                k(this.b.aG());
            } else {
                g(this.b.aC());
            }
        }
        b(this.b.aL());
        c(this.b.aM());
        android.os.Handler handler = this.ap;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.unisound.sdk.ao aoVar = this.o;
        if (aoVar != null) {
            aoVar.removeCallbacksAndMessages(null);
        }
        if (this.e != null) {
            this.e.removeCallbacksAndMessages(null);
        }
        if (!this.L) {
            com.unisound.common.y.a("init error " + com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_INIT_ERROR));
            this.z.onError(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_INIT_ERROR));
            return;
        }
        this.u.clear();
        this.v.clear();
        this.w.clear();
        com.unisound.common.v.a();
        this.ax = false;
        this.ay = false;
        com.unisound.common.y.a();
        if (W() && !V()) {
            new com.unisound.sdk.bj(this).start();
            return;
        }
        if (this.b.X() != this.b.v()) {
            setOption(1011, java.lang.Integer.valueOf(this.b.X()));
        }
        if (str.contains("oneshot:")) {
            this.b.j(true);
            str = str.split(":")[1];
        } else {
            this.b.j(false);
        }
        if (str.equals("wakeup:netasr")) {
            this.mSpeechUnderstanderParams.h(true);
            str = str.split(":")[0];
        }
        this.I = str;
        int i2 = this.F;
        if (this.b.A()) {
            this.b.O(true);
            if (this.mSpeechUnderstanderParams.i() != 2) {
                this.F = 0;
            }
            this.b.M(this.mSpeechUnderstanderParams.m());
            if (this.b.Y() == 0) {
                this.b.F(this.b.aA());
                i = 100;
                f(i);
                this.b.h(true);
            }
            this.b.h(true);
            wVar = this.b;
            iAy = this.b.aA();
            wVar.F(iAy);
        } else {
            if (str.equals(this.J)) {
                if (this.mSpeechUnderstanderParams.r()) {
                    this.F = 0;
                    wVar2 = this.b;
                    zN = this.mSpeechUnderstanderParams.n();
                } else {
                    this.F = 2;
                    wVar2 = this.b;
                    zN = this.mSpeechUnderstanderParams.m();
                }
                wVar2.M(zN);
                if (this.b.Y() == 0) {
                    this.b.F(this.b.aA());
                    i = 300;
                    f(i);
                    this.b.h(true);
                }
                this.b.h(true);
                wVar = this.b;
                iAy = this.b.aA();
            } else {
                this.F = this.mSpeechUnderstanderParams.i();
                this.b.d(this.b.k());
                this.b.M(this.mSpeechUnderstanderParams.n());
                this.b.h(false);
                wVar = this.b;
                iAy = this.b.ay();
            }
            wVar.F(iAy);
        }
        this.b.w(this.mSpeechUnderstanderParams.n());
        this.H.a();
        this.E = "";
        this.C = false;
        this.D = false;
        this.B = null;
        switch (this.F) {
            case 0:
                this.B = new com.unisound.sdk.y(this.b, this.o);
                this.e.c(true);
                this.e.d(this.M);
                this.o.a((com.unisound.sdk.z) this.B, false, this.au, (com.unisound.sdk.aa) null);
                break;
            case 1:
                this.D = true;
                this.e.c(false);
                this.B = new com.unisound.sdk.y(this.b, this.o);
                this.o.a((com.unisound.sdk.z) this.B, false, this.au, (com.unisound.sdk.aa) null);
                break;
            default:
                this.C = true;
                this.e.c(true);
                this.e.d(this.M);
                break;
        }
        if (this.b.A()) {
            this.F = i2;
        }
        super.b(str);
    }

    protected int c(java.lang.String str, java.lang.String str2) {
        return 0;
    }

    protected int c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return 0;
    }

    @Override // com.unisound.sdk.o
    protected void c(int i) {
        this.ap.sendEmptyMessage(17);
        this.mSpeechUnderstanderParams.b(i);
    }

    @Override // com.unisound.sdk.o
    protected void c(int i, int i2) {
        super.c(i, i2);
        android.os.Message message = new android.os.Message();
        message.what = i;
        message.obj = java.lang.Integer.valueOf(i2);
        android.os.Handler handler = this.aq;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unisound.sdk.o
    protected void cancel() {
        synchronized (this.mLooper) {
            this.av = true;
            this.C = true;
            this.D = true;
            this.o.c(true);
            super.cancel();
            while (this.aH) {
                try {
                    java.lang.Thread.sleep(1L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.ap.removeCallbacksAndMessages(null);
            if (this.o != null) {
                this.o.removeCallbacksAndMessages(null);
            }
            if (this.e != null) {
                this.e.removeCallbacksAndMessages(null);
            }
            this.z.onEvent(com.unisound.client.SpeechConstants.ASR_EVENT_CANCEL, (int) java.lang.System.currentTimeMillis());
            com.unisound.common.y.c("SpeechunderStanderInterface: cancel called");
        }
    }

    protected java.lang.String convertToArabicNumber(java.lang.String str) {
        try {
            return com.unisound.common.i.b(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected int d(java.lang.String str) {
        return 0;
    }

    protected int d(java.lang.String str, java.lang.String str2) {
        return 0;
    }

    @Override // com.unisound.sdk.o
    protected void d(int i) {
        super.d(i);
        this.K = i;
    }

    protected boolean d(boolean z) {
        this.b.L(z);
        return true;
    }

    public void destoryCompiler() {
        if (this.b.aJ()) {
            return;
        }
        this.aB.b();
    }

    @Override // com.unisound.sdk.o
    protected int e(int i) {
        return super.e(i);
    }

    protected int e(java.lang.String str) {
        return M() != 0 ? com.unisound.client.ErrorCode.GENERAL_INIT_ERROR : this.f.h(str);
    }

    protected int e(java.lang.String str, java.lang.String str2) {
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        b(str2, com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND, str);
        return 0;
    }

    @Override // com.unisound.sdk.o
    protected int f(int i) {
        return super.f(i);
    }

    protected int f(java.lang.String str) {
        return 0;
    }

    protected int f(java.lang.String str, java.lang.String str2) {
        return M() != 0 ? com.unisound.client.ErrorCode.GENERAL_INIT_ERROR : this.f.a(str, str2);
    }

    @Override // com.unisound.sdk.o
    protected java.lang.String g() {
        return this.F != 1 ? super.g() : "";
    }

    @Override // com.unisound.sdk.o
    protected java.lang.Object getOption(int i) {
        switch (i) {
            case 1001:
                return java.lang.Integer.valueOf(this.mSpeechUnderstanderParams.i());
            case 1003:
                return java.lang.Boolean.valueOf(this.mSpeechUnderstanderParams.c());
            case 1004:
                return this.mSpeechUnderstanderParams.b();
            case 1008:
                return this.mSpeechUnderstanderParams.d();
            case 1009:
                return this.mSpeechUnderstanderParams.a();
            case 1010:
                return java.lang.Integer.valueOf(this.b.u());
            case 1011:
                return java.lang.Integer.valueOf(this.b.v());
            case 1012:
                return this.b.bj();
            case 1014:
                return java.lang.Integer.valueOf(this.o.b());
            case 1020:
                return java.lang.Boolean.valueOf(this.A.w());
            case 1021:
                return this.A.n();
            case com.unisound.client.SpeechConstants.NLU_PARAMS /* 1023 */:
                return this.A.x();
            case com.unisound.client.SpeechConstants.GENERAL_HISTORY /* 1030 */:
                return this.A.i();
            case com.unisound.client.SpeechConstants.GENERAL_CITY /* 1031 */:
                return this.A.j();
            case 1032:
                return this.A.m();
            case com.unisound.client.SpeechConstants.GENERAL_UDID /* 1036 */:
                return com.unisound.c.a.a(this.x);
            case com.unisound.client.SpeechConstants.ASR_SAMPLING_RATE /* 1044 */:
                return java.lang.Integer.valueOf(this.b.f());
            case com.unisound.client.SpeechConstants.GENERAL_UPDATE_VOLUME /* 1045 */:
                return java.lang.Integer.valueOf(this.mSpeechUnderstanderParams.h());
            case com.unisound.client.SpeechConstants.ASR_OPT_ONESHOT_CACHE_TIME /* 1069 */:
                return java.lang.Integer.valueOf(this.b.I());
            case com.unisound.client.SpeechConstants.ASR_OPT_TEMP_RESULT_ENABLE /* 1076 */:
                return java.lang.Boolean.valueOf(this.b.aH);
            case com.unisound.client.SpeechConstants.ASR_OPT_LOADGRAMMA_TAG_AND_STATUS /* 1077 */:
                return this.b.ax();
            case com.unisound.client.SpeechConstants.ASR_OPT_TIMEOUT_STATUS /* 1078 */:
                return this.b.K();
            case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNIZE_SCENE /* 1082 */:
                return java.lang.Integer.valueOf(this.b.aQ());
            case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNIZE_MODEL_ID /* 1083 */:
                return java.lang.Integer.valueOf(this.b.ay());
            case com.unisound.client.SpeechConstants.ASR_OPT_WAKEUP_MODEL_ID /* 1084 */:
                return java.lang.Integer.valueOf(this.b.aA());
            case com.unisound.client.SpeechConstants.ASR_OPT_MODEL_LIST /* 1086 */:
                return this.b.az();
            case com.unisound.client.SpeechConstants.ASR_SUBDOMAIN /* 1087 */:
                return this.mSpeechUnderstanderParams.k();
            case com.unisound.client.SpeechConstants.ASR_ENGINE_INFO /* 1088 */:
                return N();
            case com.unisound.client.SpeechConstants.WAKEUP_WORK_ENGINE /* 1090 */:
            case com.unisound.client.SpeechConstants.ASR_OPT_LOCAL_WORK_ENGINE /* 10011 */:
                return java.lang.Integer.valueOf(y());
            case com.unisound.client.SpeechConstants.ASR_OPT_MAX_ONLINE_WAKEUPWORDS_NUM /* 1094 */:
                return java.lang.Integer.valueOf(this.as);
            case com.unisound.client.SpeechConstants.WAKEUP_OPT_THRESHOLD_VALUE /* 3150 */:
                return java.lang.Float.valueOf(this.b.E());
            case com.unisound.client.SpeechConstants.VPR_STOP_TIMEOUT /* 4013 */:
                return java.lang.Integer.valueOf(this.o.b());
            case com.unisound.client.SpeechConstants.VPR_USERNAME /* 4017 */:
                return this.b.aW().d();
            case com.unisound.client.SpeechConstants.VPR_SESSION_ID /* 4020 */:
                return this.b.bj();
            case com.unisound.client.SpeechConstants.VPR_BINDMODE /* 4108 */:
                return this.b.aW().a();
            case com.unisound.client.SpeechConstants.VPR_OPT_ACCESSTOKEN /* 4109 */:
                return this.b.br();
            case com.unisound.client.SpeechConstants.VPR_OPT_SUBSYSTEMID /* 4110 */:
                return java.lang.Integer.valueOf(this.b.aW().b());
            case com.unisound.client.SpeechConstants.VPR_OPT_USERID /* 4111 */:
                return this.b.bu();
            case com.unisound.client.SpeechConstants.ASR_OPT_GET_COMPILE_ERRORINFO /* 10005 */:
                return this.f.g();
            case com.unisound.client.SpeechConstants.ASR_OPT_ACTIVATE_TOKEN /* 10006 */:
                java.lang.String str = this.x;
                return com.unisound.c.a.a(str, com.unisound.c.a.a(str), this.an);
            case com.unisound.client.SpeechConstants.ASR_OPT_USE_PATIAL_NLU /* 10021 */:
                return java.lang.Boolean.valueOf(E());
            case com.unisound.client.SpeechConstants.ASR_OPT_PUNCTUATED /* 10034 */:
                return java.lang.Boolean.valueOf(this.b.bx());
            case com.unisound.client.SpeechConstants.ASR_FOURMIC_DOA_RESULT /* 10196 */:
                return java.lang.Integer.valueOf(P());
            case com.unisound.client.SpeechConstants.ASR_FOURMIC_BOARD_VERSION /* 10197 */:
                return (this.b.c == null || !this.b.c.s()) ? java.lang.Integer.valueOf(Q()) : j(true);
            case com.unisound.client.SpeechConstants.ASR_FOURMIC /* 10199 */:
                return java.lang.Boolean.valueOf(O());
            default:
                return super.getOption(i);
        }
    }

    @Override // com.unisound.sdk.o
    protected java.lang.String getVersion() {
        android.content.res.AssetManager assets = this.l.getAssets();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            java.io.InputStream inputStreamOpen = assets.open("version/data");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    java.lang.String strR = r(stringBuffer.toString());
                    inputStreamOpen.close();
                    bufferedReader.close();
                    return strR;
                }
                stringBuffer.append(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return super.getVersion();
        }
    }

    @Override // com.unisound.sdk.o
    protected void i() {
        this.ap.sendEmptyMessage(13);
    }

    protected void init(java.lang.String str) {
        com.unisound.sdk.bq bqVar;
        D();
        try {
            com.unisound.c.a.a(this.an);
        } catch (java.lang.Exception unused) {
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener = this.z;
            if (speechUnderstanderListener != null) {
                speechUnderstanderListener.onError(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_NO_READ_PHONE_STATE_PERMISSION));
            }
        }
        int i = this.G;
        if ((i != -1 && i != 2) || this.F != 2) {
            try {
                this.o.a(this.an, this.aI);
            } catch (java.lang.Exception unused2) {
                com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener2 = this.z;
                if (speechUnderstanderListener2 != null) {
                    speechUnderstanderListener2.onError(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_NO_READ_PHONE_STATE_PERMISSION));
                }
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.unisound.common.x.f1502a, this.x);
                jSONObject.put("[REDACTED]", this.y);
                if (str != null && str.contains("activate")) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
                    java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        java.lang.String next = itKeys.next();
                        java.lang.String string = jSONObject2.getString(next);
                        jSONObject.put(next, string);
                        if (next.equals("deviceSn") && com.unisound.c.a.b(string) == -1) {
                            q(com.unisound.client.ErrorCode.ILLEGAL_DEVICESN);
                            return;
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            a(jSONObject);
            refreshActivate();
        }
        if (str == null) {
            str = "";
        }
        if (str == "" || str.contains("activate")) {
            com.unisound.common.y.c("SpeechUnderStanderInterface : init json is an empty string!");
        } else {
            java.util.Map<java.lang.Integer, java.lang.Object> mapA = com.unisound.common.v.a(str, this.mSpeechUnderstanderParams.l());
            java.util.Iterator<java.lang.Integer> it = mapA.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (mapA.get(java.lang.Integer.valueOf(iIntValue)) != null) {
                    setOption(iIntValue, mapA.get(java.lang.Integer.valueOf(iIntValue)));
                }
            }
        }
        if (this.at) {
            this.ao = new android.os.HandlerThread("ht_outer");
            this.ao.start();
            this.ap = new com.unisound.sdk.bq(this, this.ao.getLooper());
            bqVar = new com.unisound.sdk.bq(this, this.ao.getLooper());
        } else {
            this.ap = new com.unisound.sdk.bq(this, this.an.getMainLooper());
            bqVar = new com.unisound.sdk.bq(this, this.an.getMainLooper());
        }
        this.aq = bqVar;
        A();
    }

    public void initCompiler() {
        if (this.b.aJ() || this.aB.a()) {
            return;
        }
        new com.unisound.sdk.bp(this).start();
    }

    protected int insertVocab(java.util.List<java.lang.String> list, java.lang.String str) {
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        if (T() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR;
        }
        if (list == null || list.size() < 1) {
            return com.unisound.client.ErrorCode.ASR_INSERT_VOCABCONTENT_ERROR;
        }
        if (str == "" || !str.contains("#") || str.split("#").length != 2) {
            return com.unisound.client.ErrorCode.ASR_INSERT_VOCABNAME_ERROR;
        }
        java.lang.String[] strArrSplit = str.split("#");
        java.lang.String str2 = strArrSplit[0];
        java.lang.String str3 = strArrSplit[1];
        com.unisound.common.y.c("SpeechUnderstanderInterface :", "inserVocab --> modelTag = ", str2, ", tagName = ", str3);
        a(com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND, str2, this.f.b(str2), this.f.f(str2), this.f.a(str3, list), this.f.g(str2));
        return 0;
    }

    protected int insertVocab_ext(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (M() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_INIT_ERROR;
        }
        if (T() != 0) {
            return com.unisound.client.ErrorCode.GENERAL_COMPILER_INIT_ERROR;
        }
        new com.unisound.sdk.bk(this, str, str2, str3).start();
        return 0;
    }

    protected int insertVocab_ext(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        map.entrySet();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            stringBuffer.append(this.f.a(entry.getKey(), entry.getValue()) + "\n");
        }
        java.lang.String string = stringBuffer.toString();
        com.unisound.common.y.c("SpeechUnderstanderInterface --> insertVocab_ext2 : vocabContent = ", string);
        return insertVocab_ext(str, str2, string);
    }

    @Override // com.unisound.sdk.o
    protected void j() {
        this.ap.sendEmptyMessage(20);
    }

    @Override // com.unisound.sdk.o
    protected void k() {
        if (this.F != 2 && this.b.M()) {
            this.b.F(com.unisound.c.a.a(this.x, this.an));
            this.o.c();
        }
        if (this.F == 1 && this.b.M()) {
            super.f();
        }
    }

    protected void l(int i) {
        android.os.Handler handler = this.ap;
        if (handler == null) {
            com.unisound.common.y.a("SpeechUnderstander -> doUploadUserData handler is null");
        } else if (i == 0) {
            handler.sendEmptyMessage(16);
        } else {
            q(i);
        }
    }

    @Override // com.unisound.sdk.o
    protected void m() throws java.lang.Throwable {
        this.o.d();
        this.ap.sendEmptyMessage(12);
    }

    protected void m(int i) {
        if (i == 0) {
            return;
        }
        android.os.Message message = new android.os.Message();
        message.what = 53;
        message.obj = java.lang.Integer.valueOf(i);
        this.ap.sendMessage(message);
    }

    @Override // com.unisound.sdk.o
    protected void o() throws java.lang.Throwable {
        if (!this.D || !this.C) {
            com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener = this.z;
            return;
        }
        this.e.a(false);
        this.o.c(false);
        com.unisound.common.y.a("SpeechUnderstander fixend&netend doRecordingStart cancel");
    }

    @Override // com.unisound.sdk.o
    protected void p() {
    }

    @Override // com.unisound.sdk.o
    public void postRecordingStartStatus() {
        super.postRecordingStartStatus();
        this.ap.sendEmptyMessage(11);
    }

    @Override // com.unisound.sdk.o
    protected void q() {
        this.ap.sendEmptyMessage(14);
    }

    public synchronized void refreshActivate() {
        com.unisound.common.y.c(com.unisound.common.y.v, "refreshActivate called!");
        if (isNetworkAvailable(this.an)) {
            this.aA.a(false);
            S();
            java.lang.String strA = com.unisound.c.a.a(this.x, com.unisound.c.a.a(this.x), this.l);
            if (strA.equals("")) {
                this.aN.a(0);
            } else {
                this.aw = true;
                this.aN.q(strA);
                this.aN.a(1);
            }
        } else {
            com.unisound.common.y.a(com.unisound.common.y.v, "refreshActivate network not available!");
            android.content.IntentFilter intentFilter = new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            this.aA.a(true);
            a(intentFilter);
        }
    }

    protected int release(int i, java.lang.String str) {
        android.os.Handler handler = this.aO;
        if (handler != null) {
            handler.removeCallbacks(this.aP);
        }
        S();
        if (this.n != null) {
            this.n.getLooper().quit();
        }
        if (this.mSpeechUnderstanderParams.o()) {
            this.b.c.r();
        }
        if (i != 1401 || !this.M) {
            return -1;
        }
        this.M = false;
        super.r();
        return 0;
    }

    @Override // com.unisound.sdk.o
    protected int setAudioSource(com.unisound.client.IAudioSource iAudioSource) {
        return super.setAudioSource(iAudioSource);
    }

    protected void setListener(com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener) {
        this.z = speechUnderstanderListener;
    }

    protected java.lang.String setOnlineWakeupWord(java.util.List<java.lang.String> list) {
        new com.unisound.sdk.br(this).execute(list);
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:434:0x0596 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.unisound.sdk.o
    protected void setOption(int i, java.lang.Object obj) {
        java.lang.String str;
        switch (i) {
            case 1003:
                try {
                    boolean zBooleanValue = ((java.lang.Boolean) obj).booleanValue();
                    d(zBooleanValue);
                    this.mSpeechUnderstanderParams.a(zBooleanValue);
                    return;
                } catch (java.lang.Exception unused) {
                    str = "set asr_voice_field Error.";
                }
                break;
            case 1004:
                try {
                    java.lang.String str2 = (java.lang.String) obj;
                    q(str2);
                    this.mSpeechUnderstanderParams.b(str2);
                    return;
                } catch (java.lang.Exception unused2) {
                    str = "set asr_language Error.";
                }
                break;
            default:
                switch (i) {
                    case 1007:
                        try {
                            java.lang.String str3 = (java.lang.String) obj;
                            this.b.u(str3);
                            this.mSpeechUnderstanderParams.f(str3);
                            return;
                        } catch (java.lang.Exception unused3) {
                            str = "set asr_online_oneshot_server_address Error.";
                        }
                        break;
                    case 1008:
                        try {
                            java.lang.String str4 = (java.lang.String) obj;
                            o(str4);
                            this.mSpeechUnderstanderParams.c(str4);
                            return;
                        } catch (java.lang.Exception unused4) {
                            str = "set asr_domain Error.";
                        }
                        break;
                    case 1009:
                        try {
                            java.lang.String str5 = (java.lang.String) obj;
                            if (this.b.t(str5)) {
                                this.mSpeechUnderstanderParams.a(str5);
                            } else {
                                q(com.unisound.client.ErrorCode.ASR_SDK_SET_ASR_SERVER_ADDR_ERROR);
                            }
                            return;
                        } catch (java.lang.Exception unused5) {
                            str = "set asr_server_address Error.";
                        }
                        break;
                    default:
                        switch (i) {
                            case 1017:
                                try {
                                    this.b.l((java.lang.String) obj);
                                    return;
                                } catch (java.lang.Exception unused6) {
                                    str = "set ASR_OPT_SET_POST_PROCESS_PARAMS Error.";
                                }
                                break;
                            case 1018:
                                try {
                                    this.b.b((java.util.List<java.lang.String>) obj);
                                    return;
                                } catch (java.lang.Exception unused7) {
                                    str = "set ASR_OPT_SET_ONESHOT_WAKEUPWORD Error.";
                                }
                                break;
                            case 1019:
                                try {
                                    this.b.k((java.lang.String) obj);
                                    return;
                                } catch (java.lang.Exception unused8) {
                                    str = "set ASR_OPT_ADDITIONAL_SERVICE Error.";
                                }
                                break;
                            case 1020:
                                try {
                                    e(((java.lang.Boolean) obj).booleanValue());
                                    return;
                                } catch (java.lang.Exception unused9) {
                                    str = "set nlu_enable Error.";
                                }
                                break;
                            case 1021:
                                try {
                                    g((java.lang.String) obj);
                                    return;
                                } catch (java.lang.Exception unused10) {
                                    str = "set nlu_scenario Error.";
                                }
                                break;
                            default:
                                switch (i) {
                                    case 1024:
                                        try {
                                            l(java.lang.String.valueOf(obj));
                                            return;
                                        } catch (java.lang.Exception unused11) {
                                            str = "set nlu_ver Error.";
                                        }
                                        break;
                                    case 1025:
                                        try {
                                            m(java.lang.String.valueOf(obj));
                                            return;
                                        } catch (java.lang.Exception unused12) {
                                            str = "set nlu_appver Error.";
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case com.unisound.client.SpeechConstants.GENERAL_HISTORY /* 1030 */:
                                                try {
                                                    h((java.lang.String) obj);
                                                    return;
                                                } catch (java.lang.Exception unused13) {
                                                    str = "set history Error.";
                                                }
                                                break;
                                            case com.unisound.client.SpeechConstants.GENERAL_CITY /* 1031 */:
                                                try {
                                                    i((java.lang.String) obj);
                                                    return;
                                                } catch (java.lang.Exception unused14) {
                                                    str = "set city Error.";
                                                }
                                                break;
                                            case 1032:
                                                try {
                                                    j((java.lang.String) obj);
                                                    return;
                                                } catch (java.lang.Exception unused15) {
                                                    str = "set voiceID Error.";
                                                }
                                                break;
                                            case 1033:
                                                try {
                                                    k((java.lang.String) obj);
                                                    return;
                                                } catch (java.lang.Exception unused16) {
                                                    str = "set gps Error.";
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case com.unisound.client.SpeechConstants.ASR_OPT_FRONT_CACHE_TIME /* 1060 */:
                                                        try {
                                                            this.b.f(((java.lang.Integer) obj).intValue());
                                                            this.mSpeechUnderstanderParams.a(((java.lang.Integer) obj).intValue());
                                                            return;
                                                        } catch (java.lang.Exception unused17) {
                                                            str = "set asr_front_cache_time Error.";
                                                        }
                                                        break;
                                                    case com.unisound.client.SpeechConstants.ASR_OPT_WAKEUP_VAD_ENABLED /* 1061 */:
                                                        try {
                                                            this.mSpeechUnderstanderParams.c(((java.lang.Boolean) obj).booleanValue());
                                                            return;
                                                        } catch (java.lang.Exception unused18) {
                                                            str = "set wakeup_vad_enable Error.";
                                                        }
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_ONESHOT_CACHE_TIME /* 1069 */:
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_FRONT_RESET_CACHE_BYTE_TIME /* 1070 */:
                                                                try {
                                                                    this.b.g(((java.lang.Integer) obj).intValue());
                                                                } catch (java.lang.Exception unused19) {
                                                                    str = "set Front_reset_cache_byte_time Error.";
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_SAVELOG /* 1071 */:
                                                                try {
                                                                    com.unisound.common.y.t = ((java.lang.Boolean) obj).booleanValue();
                                                                } catch (java.lang.Exception unused20) {
                                                                    str = "set DEBUG_SAVELOG Error.";
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_POSTLOG /* 1072 */:
                                                                try {
                                                                    com.unisound.common.y.u = ((java.lang.Boolean) obj).booleanValue();
                                                                    break;
                                                                } catch (java.lang.Exception unused21) {
                                                                    com.unisound.common.y.a("set DEBUG_POSTLOG Error.");
                                                                    break;
                                                                }
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_USE_HANDLERTHREAD /* 1073 */:
                                                                try {
                                                                    this.at = ((java.lang.Boolean) obj).booleanValue();
                                                                } catch (java.lang.Exception unused22) {
                                                                    str = "set USE_HANDLERTHREAD Error.";
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_SAVE_AFTERVAD_RECORDING_DATA /* 1074 */:
                                                                try {
                                                                    this.b.b((java.lang.String) obj);
                                                                } catch (java.lang.Exception unused23) {
                                                                    str = "set SAVE_AFTERVAD_RECORDING_DATA Error.";
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_MARK_VAD /* 1075 */:
                                                                try {
                                                                    this.b.i(((java.lang.Boolean) obj).booleanValue());
                                                                } catch (java.lang.Exception unused24) {
                                                                    str = "set MARK_VAD Error.";
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_OPT_TEMP_RESULT_ENABLE /* 1076 */:
                                                                try {
                                                                    this.b.N(((java.lang.Boolean) obj).booleanValue());
                                                                } catch (java.lang.Exception unused25) {
                                                                    str = "set TEMP_RESULT Error.";
                                                                }
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNITION_FRONT_VAD /* 1079 */:
                                                                        try {
                                                                            this.b.e(((java.lang.Boolean) obj).booleanValue());
                                                                        } catch (java.lang.Exception unused26) {
                                                                            str = "set setRecognizeFrontVADEnable Error.";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_RECORDING_PAC_SIZE /* 1080 */:
                                                                        try {
                                                                            this.b.x(((java.lang.Integer) obj).intValue());
                                                                        } catch (java.lang.Exception unused27) {
                                                                            str = "set ASR_OPT_RECORDING_PAC_SIZE Error";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_ONESHOT_VADBACKSIL_TIME /* 1081 */:
                                                                        try {
                                                                            this.b.h(((java.lang.Integer) obj).intValue());
                                                                        } catch (java.lang.Exception unused28) {
                                                                            str = "set OneShot VAD back sil time Error.";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNIZE_SCENE /* 1082 */:
                                                                        try {
                                                                            this.b.O(((java.lang.Integer) obj).intValue());
                                                                        } catch (java.lang.Exception unused29) {
                                                                            str = "set RECOGNIZE_SCENE Error.";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNIZE_MODEL_ID /* 1083 */:
                                                                        try {
                                                                            this.b.D(((java.lang.Integer) obj).intValue());
                                                                            com.unisound.common.y.c("SpeechUnderstanderInterface", "set recognize modelId ", obj);
                                                                        } catch (java.lang.Exception unused30) {
                                                                            str = "set RECOGNIZE_MODEL_ID Error.";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_WAKEUP_MODEL_ID /* 1084 */:
                                                                        try {
                                                                            this.b.E(((java.lang.Integer) obj).intValue());
                                                                            com.unisound.common.y.c("SpeechUnderstanderInterface", "set wakeup modelId ", obj);
                                                                        } catch (java.lang.Exception unused31) {
                                                                            str = "set WAKEUP_MODEL_ID Error.";
                                                                        }
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_ALREAD_AWPE /* 1085 */:
                                                                        try {
                                                                            this.b.P(((java.lang.Boolean) obj).booleanValue());
                                                                        } catch (java.lang.Exception unused32) {
                                                                            str = "set ALREAD_AWPE Error.";
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_ACTIVATE_MEMO /* 1089 */:
                                                                                try {
                                                                                    this.b.m((java.lang.String) obj);
                                                                                } catch (java.lang.Exception unused33) {
                                                                                    str = "set ASR_OPT_ACTIVATE_MEMO Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.WAKEUP_WORK_ENGINE /* 1090 */:
                                                                                try {
                                                                                    int iIntValue = ((java.lang.Integer) obj).intValue();
                                                                                    this.b.n(iIntValue);
                                                                                    this.b.o(iIntValue);
                                                                                } catch (java.lang.Exception unused34) {
                                                                                    str = "set WAKEUP_WORK_ENGINE Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.WUW_WAKEUP_THRESHOLD /* 1091 */:
                                                                                try {
                                                                                    this.b.G(((java.lang.Integer) obj).intValue());
                                                                                } catch (java.lang.Exception unused35) {
                                                                                    str = "set WUW_WAKEUP_THRESHOLD Error";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_IGNORE_RESULT_TAG /* 1092 */:
                                                                                try {
                                                                                    this.b.i((java.lang.String) obj);
                                                                                } catch (java.lang.Exception unused36) {
                                                                                    str = "set ASR_OPT_IGNORE_RESULT_TAG Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_CONTINUE_RECOGNIZE /* 1093 */:
                                                                                try {
                                                                                    this.b.x(((java.lang.Boolean) obj).booleanValue());
                                                                                } catch (java.lang.Exception unused37) {
                                                                                    str = "set ASR_OPT_CONTINUE_RECOGNIZE Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_MAX_ONLINE_WAKEUPWORDS_NUM /* 1094 */:
                                                                                try {
                                                                                    this.as = ((java.lang.Integer) obj).intValue();
                                                                                } catch (java.lang.Exception unused38) {
                                                                                    str = "set ASR_OPT_MAX_ONLINE_WAKEUPWORDS_NUM Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_WX_SERVICE /* 1095 */:
                                                                                try {
                                                                                    this.b.I(((java.lang.Boolean) obj).booleanValue());
                                                                                } catch (java.lang.Exception unused39) {
                                                                                    str = "set setWxServiceEnabled Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_FILTER_URL /* 1096 */:
                                                                                try {
                                                                                    this.b.D((java.lang.String) obj);
                                                                                } catch (java.lang.Exception unused40) {
                                                                                    str = "set ASR_OPT_FILTERURL Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_SUB_SERVICE_PARAM /* 1097 */:
                                                                                try {
                                                                                    this.b.E((java.lang.String) obj);
                                                                                } catch (java.lang.Exception unused41) {
                                                                                    str = "set ASR_OPT_SUB_SERVICE_PARAM Error.";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_SERVICE_PARAMETER /* 1098 */:
                                                                                try {
                                                                                    this.b.A((java.lang.String) obj);
                                                                                } catch (java.lang.Exception unused42) {
                                                                                    str = "set ASR_OPT_SERVICE_PARAMETER Error";
                                                                                }
                                                                                break;
                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_ONESHOT_WAKEUP_BUFFER_LENGTH /* 1099 */:
                                                                                try {
                                                                                    this.b.y(((java.lang.Integer) obj).intValue());
                                                                                } catch (java.lang.Exception unused43) {
                                                                                    str = "set wakeup buffer length error!";
                                                                                }
                                                                                break;
                                                                            case 1100:
                                                                                try {
                                                                                    this.b.R(((java.lang.Integer) obj).intValue());
                                                                                } catch (java.lang.Exception unused44) {
                                                                                    str = "set ASR_OPT_REQ_NLU_LENGTH Error.";
                                                                                }
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case com.unisound.client.SpeechConstants.ASR_FALSE_ALARM /* 1203 */:
                                                                                        try {
                                                                                            this.b.S(((java.lang.Integer) obj).intValue());
                                                                                        } catch (java.lang.Exception unused45) {
                                                                                            str = "set ASR_FALSE_ALARM Error.";
                                                                                        }
                                                                                        break;
                                                                                    case com.unisound.client.SpeechConstants.ASR_DOMAINS_PENALTY /* 1204 */:
                                                                                        try {
                                                                                            this.b.T(((java.lang.Integer) obj).intValue());
                                                                                        } catch (java.lang.Exception unused46) {
                                                                                            str = "set ASR_DOMAINS_PENALTY Error.";
                                                                                        }
                                                                                        break;
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case com.unisound.client.SpeechConstants.DEBUG_SAVE_PCM /* 1601 */:
                                                                                                com.unisound.common.y.r = ((java.lang.Boolean) obj).booleanValue();
                                                                                                break;
                                                                                            case com.unisound.client.SpeechConstants.DEBUG_SAVE_WAV /* 1602 */:
                                                                                                com.unisound.common.y.s = ((java.lang.Boolean) obj).booleanValue();
                                                                                                break;
                                                                                            default:
                                                                                                switch (i) {
                                                                                                    case com.unisound.client.SpeechConstants.VPR_FRONT_VAD_ENABLED /* 4009 */:
                                                                                                        this.b.d(((java.lang.Boolean) obj).booleanValue());
                                                                                                        break;
                                                                                                    case com.unisound.client.SpeechConstants.VPR_SAMPLE_RATE /* 4010 */:
                                                                                                        this.b.P(((java.lang.Integer) obj).intValue());
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (i) {
                                                                                                            case com.unisound.client.SpeechConstants.VPR_VAD_TIMEOUT /* 4012 */:
                                                                                                                int[] iArr = (int[]) obj;
                                                                                                                this.b.a(iArr[0], iArr[1]);
                                                                                                                break;
                                                                                                            case com.unisound.client.SpeechConstants.VPR_STOP_TIMEOUT /* 4013 */:
                                                                                                                this.o.c(((java.lang.Integer) obj).intValue());
                                                                                                                break;
                                                                                                            case com.unisound.client.SpeechConstants.VPR_FARFILED_ENABLED /* 4014 */:
                                                                                                                this.b.L(((java.lang.Boolean) obj).booleanValue());
                                                                                                                break;
                                                                                                            default:
                                                                                                                switch (i) {
                                                                                                                    case com.unisound.client.SpeechConstants.VPR_TYPE /* 4016 */:
                                                                                                                        this.b.aW().b(((java.lang.Integer) obj).intValue());
                                                                                                                        break;
                                                                                                                    case com.unisound.client.SpeechConstants.VPR_USERNAME /* 4017 */:
                                                                                                                        this.b.aW().b((java.lang.String) obj);
                                                                                                                        break;
                                                                                                                    default:
                                                                                                                        switch (i) {
                                                                                                                            case com.unisound.client.SpeechConstants.VPR_BINDMODE /* 4108 */:
                                                                                                                                this.b.aW().a((java.lang.String) obj);
                                                                                                                                break;
                                                                                                                            case com.unisound.client.SpeechConstants.VPR_OPT_ACCESSTOKEN /* 4109 */:
                                                                                                                                this.b.E((java.lang.String) obj);
                                                                                                                                break;
                                                                                                                            case com.unisound.client.SpeechConstants.VPR_OPT_SUBSYSTEMID /* 4110 */:
                                                                                                                                this.b.aW().a(((java.lang.Integer) obj).intValue());
                                                                                                                                break;
                                                                                                                            case com.unisound.client.SpeechConstants.VPR_OPT_USERID /* 4111 */:
                                                                                                                                this.b.H((java.lang.String) obj);
                                                                                                                                break;
                                                                                                                            default:
                                                                                                                                switch (i) {
                                                                                                                                    case 6000:
                                                                                                                                        try {
                                                                                                                                            this.b.B((java.lang.String) obj);
                                                                                                                                        } catch (java.lang.Exception unused47) {
                                                                                                                                            str = "set UploadUserDataServer Error.";
                                                                                                                                        }
                                                                                                                                        break;
                                                                                                                                    case com.tencent.ysdk.framework.common.eFlag.Certification_No_Found_Error /* 6001 */:
                                                                                                                                        try {
                                                                                                                                            this.b.C((java.lang.String) obj);
                                                                                                                                        } catch (java.lang.Exception unused48) {
                                                                                                                                            str = "set setUploadUserDataServerUrl Error.";
                                                                                                                                        }
                                                                                                                                        break;
                                                                                                                                    default:
                                                                                                                                        switch (i) {
                                                                                                                                            case 9000:
                                                                                                                                                try {
                                                                                                                                                    this.b.n(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                } catch (java.lang.Exception unused49) {
                                                                                                                                                    str = "set ContinueReadData Error.";
                                                                                                                                                }
                                                                                                                                                break;
                                                                                                                                            case 9001:
                                                                                                                                                try {
                                                                                                                                                    this.b.l(((java.lang.Integer) obj).intValue());
                                                                                                                                                } catch (java.lang.Exception unused50) {
                                                                                                                                                    str = "set OneshotRecognitionBacksil Error.";
                                                                                                                                                }
                                                                                                                                                break;
                                                                                                                                            default:
                                                                                                                                                switch (i) {
                                                                                                                                                    case 10001:
                                                                                                                                                        try {
                                                                                                                                                            this.b.z((java.lang.String) obj);
                                                                                                                                                        } catch (java.lang.Exception unused51) {
                                                                                                                                                            str = "set ASR_OPT_SGN_SETTING Error";
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_INIT_MODE /* 10002 */:
                                                                                                                                                        try {
                                                                                                                                                            int iIntValue2 = ((java.lang.Integer) obj).intValue();
                                                                                                                                                            if (iIntValue2 < 0) {
                                                                                                                                                                iIntValue2 = -1;
                                                                                                                                                            } else if (iIntValue2 > 2) {
                                                                                                                                                                iIntValue2 = 1;
                                                                                                                                                            }
                                                                                                                                                            this.G = iIntValue2;
                                                                                                                                                        } catch (java.lang.Exception unused52) {
                                                                                                                                                            str = "set ASR_OPT_INIT_MODE Error.";
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION /* 10003 */:
                                                                                                                                                        try {
                                                                                                                                                            this.f.a(((java.lang.Integer) obj).intValue());
                                                                                                                                                        } catch (java.lang.Exception unused53) {
                                                                                                                                                            str = "set ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION Error.";
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT /* 10004 */:
                                                                                                                                                        try {
                                                                                                                                                            if (this.f.a(((java.lang.Boolean) obj).booleanValue()) != 0) {
                                                                                                                                                                com.unisound.common.y.a("set ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT Error.");
                                                                                                                                                            }
                                                                                                                                                        } catch (java.lang.Exception unused54) {
                                                                                                                                                            str = "set ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT Error.";
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    default:
                                                                                                                                                        switch (i) {
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_WUW_NET0_THRESHOLD /* 10007 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.b.H(((java.lang.Integer) obj).intValue());
                                                                                                                                                                } catch (java.lang.Exception unused55) {
                                                                                                                                                                    str = "set ASR_OPT_WUW_NET0_THRESHOLD Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_WUW_NET1_THRESHOLD /* 10008 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.b.I(((java.lang.Integer) obj).intValue());
                                                                                                                                                                } catch (java.lang.Exception unused56) {
                                                                                                                                                                    str = "set ASR_OPT_WUW_NET1_THRESHOLD Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_WUW_NET2_THRESHOLD /* 10009 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.b.J(((java.lang.Integer) obj).intValue());
                                                                                                                                                                } catch (java.lang.Exception unused57) {
                                                                                                                                                                    str = "set ASR_OPT_WUW_NET2_THRESHOLD Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_WUW_ACTIVE_NET /* 10010 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.b.K(((java.lang.Integer) obj).intValue());
                                                                                                                                                                } catch (java.lang.Exception unused58) {
                                                                                                                                                                    str = "set ASR_OPT_WUW_ACTIVE_NET Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_LOCAL_WORK_ENGINE /* 10011 */:
                                                                                                                                                                int iIntValue3 = ((java.lang.Integer) obj).intValue();
                                                                                                                                                                this.b.n(iIntValue3);
                                                                                                                                                                this.b.o(iIntValue3);
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_LOCAL_CONTINUE_RECOGNIZE /* 10012 */:
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_RECOGNIZE_VAD_ENABLE /* 10013 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.mSpeechUnderstanderParams.d(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                } catch (java.lang.Exception unused59) {
                                                                                                                                                                    str = "set ASR_OPT_RECOGNIZE_VAD_ENABLE Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case com.unisound.client.SpeechConstants.ASR_OPT_USER_ID /* 10014 */:
                                                                                                                                                                try {
                                                                                                                                                                    this.b.H((java.lang.String) obj);
                                                                                                                                                                } catch (java.lang.Exception unused60) {
                                                                                                                                                                    str = "set ASR_OPT_USER_ID Error.";
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            default:
                                                                                                                                                                switch (i) {
                                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_USE_PATIAL_NLU /* 10021 */:
                                                                                                                                                                        try {
                                                                                                                                                                            f(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                        } catch (java.lang.Exception unused61) {
                                                                                                                                                                            str = "set ASR_OPT_USE_PATIAL_NLU Error.";
                                                                                                                                                                        }
                                                                                                                                                                        break;
                                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_APPEND_LENGTH /* 10022 */:
                                                                                                                                                                        try {
                                                                                                                                                                            n(((java.lang.Integer) obj).intValue());
                                                                                                                                                                        } catch (java.lang.Exception unused62) {
                                                                                                                                                                            str = "set ASR_OPT_APPEND_LENGTH Error.";
                                                                                                                                                                        }
                                                                                                                                                                        break;
                                                                                                                                                                    case com.unisound.client.SpeechConstants.ASR_OPT_ADVANCE_INIT_COMPILER /* 10023 */:
                                                                                                                                                                        try {
                                                                                                                                                                            this.b.E(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                        } catch (java.lang.Exception unused63) {
                                                                                                                                                                            str = "set ASR_OPT_ADVANCE_INIT_COMPILER Error.";
                                                                                                                                                                        }
                                                                                                                                                                        break;
                                                                                                                                                                    default:
                                                                                                                                                                        try {
                                                                                                                                                                            switch (i) {
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_AUDIO_FORMAT /* 10030 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.g((java.lang.String) obj);
                                                                                                                                                                                    } catch (java.lang.Exception unused64) {
                                                                                                                                                                                        str = "set ASR_OPT_AUDIO_FORMAT Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_SAVE_SESSION_PCM_ENABLE /* 10031 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.A(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused65) {
                                                                                                                                                                                        str = "set ASR_OPT_SAVE_SESSION_PCM_ENABLE Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_SAVE_SESSION_PCM_DIR /* 10032 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.h((java.lang.String) obj);
                                                                                                                                                                                    } catch (java.lang.Exception unused66) {
                                                                                                                                                                                        str = "set ASR_OPT_SAVE_SESSION_PCM_DIR Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_RECORDING_WAV /* 10033 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.a(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused67) {
                                                                                                                                                                                        str = "set ASR_OPT_RECORDING_WAV Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_PUNCTUATED /* 10034 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.T(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused68) {
                                                                                                                                                                                        str = "set ASR_OPT_PUNCTUATED Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_OPEN_AUDIOURL /* 10035 */:
                                                                                                                                                                                    this.b.U(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_OPEN_FULL_DUPLEX /* 10036 */:
                                                                                                                                                                                    this.b.V(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_MAX_WAKEUP_END /* 10037 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.L(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused69) {
                                                                                                                                                                                        str = "set ASR_OPT_MAX_WAKEUP_END Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_INHIBIT_FRONT_WAKEUP /* 10038 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.F(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused70) {
                                                                                                                                                                                        str = "set ASR_OPT_INHIBIT_FRONT_WAKEUP Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_INHIBIT_BACK_WAKEUP /* 10039 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.G(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused71) {
                                                                                                                                                                                        str = "set ASR_OPT_INHIBIT_BACK_WAKEUP Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_LOCAL_RESULT_CONTAINS_UTTERANCETIME /* 10040 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.H(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused72) {
                                                                                                                                                                                        str = "set ASR_OPT_LOCAL_RESULT_CONTAINS_UTTERANCETIME Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_VAD_AFFECT_ASR /* 10041 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.B(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused73) {
                                                                                                                                                                                        str = "set ASR_OPT_VAD_AFFECT_ASR Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_INPUT_SAMPLE_RATE /* 10042 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.N(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused74) {
                                                                                                                                                                                        str = "set ASR_OPT_INPUT_SAMPLE_RATE Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_OPT_RK_THREAD_NUM /* 10043 */:
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.b.M(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                    } catch (java.lang.Exception unused75) {
                                                                                                                                                                                        str = "set ASR_OPT_RK_THREAD_NUM Error.";
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                                default:
                                                                                                                                                                                    switch (i) {
                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_OPT_MAXWELL_ENABLE /* 10060 */:
                                                                                                                                                                                            try {
                                                                                                                                                                                                this.b.S(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                            } catch (java.lang.Exception unused76) {
                                                                                                                                                                                                str = "set ASR_OPT_MAXWELL_ENABLE Error.";
                                                                                                                                                                                            }
                                                                                                                                                                                            break;
                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_OPT_RET_TYPE /* 10061 */:
                                                                                                                                                                                            try {
                                                                                                                                                                                                this.b.I((java.lang.String) obj);
                                                                                                                                                                                            } catch (java.lang.Exception unused77) {
                                                                                                                                                                                                str = "set ASR_OPT_RET_TYPE Error.";
                                                                                                                                                                                            }
                                                                                                                                                                                            break;
                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_OPT_PRINT_NET_ENGINE_LOG /* 10062 */:
                                                                                                                                                                                            try {
                                                                                                                                                                                                this.b.z(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                            } catch (java.lang.Exception unused78) {
                                                                                                                                                                                                str = "set ASR_OPT_PRINT_NET_ENGINE_LOG Error.";
                                                                                                                                                                                            }
                                                                                                                                                                                            break;
                                                                                                                                                                                        default:
                                                                                                                                                                                            switch (i) {
                                                                                                                                                                                                case 10100:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.mSpeechUnderstanderParams.g(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused79) {
                                                                                                                                                                                                        str = "set ASR_FORMIC_CLOSE_4MICALGORITHM Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_FOURMIC_OUT_SET_4MICWAKEUPFLAG /* 10101 */:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.q(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused80) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICWAKEUPFLAG Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10102:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.s(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused81) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICUTTERANCETIME Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10103:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.u(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused82) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICDELAYTIME Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10104:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.q(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused83) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICWAKEUPSTATUS Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10105:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.r(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused84) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICUTTERANCETIMESTATUS Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10106:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.s(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused85) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_OUT_SET_4MICDELAYTIMESTATUS Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10107:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.c.i(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused86) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_IS_RK_PLATFORM Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                case 10108:
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.b.c.j(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                    } catch (java.lang.Exception unused87) {
                                                                                                                                                                                                        str = "set ASR_FOURMIC_IS_RK_SINGALCHANEL Error.";
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                                default:
                                                                                                                                                                                                    switch (i) {
                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_OPT_FOURMIC_PCM_TEST /* 10192 */:
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                this.b.C(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                            } catch (java.lang.Exception unused88) {
                                                                                                                                                                                                                str = "set ASR_OPT_FOURMIC_PCM_TEST Error.";
                                                                                                                                                                                                            }
                                                                                                                                                                                                            break;
                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_FOURMIC_USE_ASR_AS_VAD /* 10193 */:
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                if (!l(((java.lang.Boolean) obj).booleanValue())) {
                                                                                                                                                                                                                    com.unisound.common.y.a("set ASR_FOURMIC_USE_ASR_AS_VAD Error.");
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (java.lang.Exception unused89) {
                                                                                                                                                                                                                com.unisound.common.y.a("set ASR_FOURMIC_USE_ASR_AS_VAD Error.");
                                                                                                                                                                                                            }
                                                                                                                                                                                                            this.b.H(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                            break;
                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_FOURMIC_CHANGE_CHANNEL /* 10194 */:
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                s(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                            } catch (java.lang.Exception unused90) {
                                                                                                                                                                                                                str = "set ASR_FOURMIC_CHANGE_CHANNAL Error.";
                                                                                                                                                                                                            }
                                                                                                                                                                                                            break;
                                                                                                                                                                                                        default:
                                                                                                                                                                                                            switch (i) {
                                                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_FOURMIC_ISDEBUG /* 10198 */:
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        this.mSpeechUnderstanderParams.f(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                                    } catch (java.lang.Exception unused91) {
                                                                                                                                                                                                                        str = "set ASR_FOURMIC_ISDEBUG Error.";
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                case com.unisound.client.SpeechConstants.ASR_FOURMIC /* 10199 */:
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        this.mSpeechUnderstanderParams.e(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                                    } catch (java.lang.Exception unused92) {
                                                                                                                                                                                                                        str = "set ASR_FOURMIC Error.";
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                default:
                                                                                                                                                                                                                    switch (i) {
                                                                                                                                                                                                                        case 1001:
                                                                                                                                                                                                                            if (this.mSpeechUnderstanderParams.i() == 1) {
                                                                                                                                                                                                                                str = "SpeechUnderstanderInterface: current SDK didn't support local function,Please contanct unisound for more function!";
                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    int iIntValue4 = ((java.lang.Integer) obj).intValue();
                                                                                                                                                                                                                                    switch (iIntValue4) {
                                                                                                                                                                                                                                        case 0:
                                                                                                                                                                                                                                        case 1:
                                                                                                                                                                                                                                        case 2:
                                                                                                                                                                                                                                            if (this.F != iIntValue4) {
                                                                                                                                                                                                                                                if (this.G == -1) {
                                                                                                                                                                                                                                                    this.L = false;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                this.F = iIntValue4;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            this.mSpeechUnderstanderParams.c(iIntValue4);
                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                        default:
                                                                                                                                                                                                                                            com.unisound.common.y.a("USCMixRecognizer.setOption unkown value " + iIntValue4);
                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } catch (java.lang.Exception unused93) {
                                                                                                                                                                                                                                    str = "set asr_service_mode Error.";
                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case 1014:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                p(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                                            } catch (java.lang.Exception unused94) {
                                                                                                                                                                                                                                str = "set asr_net_timeOut Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_SAMPLING_RATE /* 1044 */:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                o(((java.lang.Integer) obj).intValue());
                                                                                                                                                                                                                            } catch (java.lang.Exception unused95) {
                                                                                                                                                                                                                                str = "set asr_sampling_rate Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_SUBDOMAIN /* 1087 */:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                java.lang.String str6 = (java.lang.String) obj;
                                                                                                                                                                                                                                p(str6);
                                                                                                                                                                                                                                this.mSpeechUnderstanderParams.g(str6);
                                                                                                                                                                                                                            } catch (java.lang.Exception unused96) {
                                                                                                                                                                                                                                str = "set asr_subdomain Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case 1200:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                this.b.R(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                                            } catch (java.lang.Exception unused97) {
                                                                                                                                                                                                                                str = "set ASR_BEST_RESULT_RETURN Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.WAKEUP_OPT_THRESHOLD_VALUE /* 3150 */:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                this.b.a(((java.lang.Float) obj).floatValue());
                                                                                                                                                                                                                            } catch (java.lang.Exception unused98) {
                                                                                                                                                                                                                                str = "set wakeup_threshold_value Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.VPR_SERVER_ADDR /* 4003 */:
                                                                                                                                                                                                                            this.b.t((java.lang.String) obj);
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.VPR_LOG_LISTNER /* 4007 */:
                                                                                                                                                                                                                            this.g = (com.unisound.common.ar) obj;
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.VPR_SCENE_ENABLE /* 4021 */:
                                                                                                                                                                                                                            this.b.aW().a(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        case com.unisound.client.SpeechConstants.ASR_OPT_RETURN_ORIGIN_FORMAT /* 10019 */:
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                this.b.y(((java.lang.Boolean) obj).booleanValue());
                                                                                                                                                                                                                            } catch (java.lang.Exception unused99) {
                                                                                                                                                                                                                                str = "set ASR_OPT_RETURN_ORIGIN_FORMAT Error.";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        default:
                                                                                                                                                                                                                            super.setOption(i, obj);
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            break;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    break;
                                                                                                                                                                                            }
                                                                                                                                                                                            break;
                                                                                                                                                                                    }
                                                                                                                                                                                    break;
                                                                                                                                                                            }
                                                                                                                                                                        } catch (java.lang.Exception unused100) {
                                                                                                                                                                            str = "set ASR_OPT_OPEN_FULL_DUPLEX Error.";
                                                                                                                                                                            break;
                                                                                                                                                                        }
                                                                                                                                                                        break;
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                }
                                                                                                                                                break;
                                                                                                                                        }
                                                                                                                                        break;
                                                                                                                                }
                                                                                                                                break;
                                                                                                                        }
                                                                                                                        break;
                                                                                                                }
                                                                                                                break;
                                                                                                        }
                                                                                                        break;
                                                                                                }
                                                                                                break;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        return;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
        com.unisound.common.y.a(str);
    }

    @Override // com.unisound.sdk.o
    protected void start() throws java.lang.Throwable {
        b(this.f.e);
    }

    @Override // com.unisound.sdk.o
    protected void stop() throws java.lang.Throwable {
        super.stop();
        this.B = null;
        this.o.d();
    }

    protected void uploadUserData(java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> map) {
        this.o.a(map);
    }

    @Override // com.unisound.sdk.o
    protected int v() {
        return super.v();
    }

    @Override // com.unisound.sdk.o
    protected java.lang.String w() {
        return super.w();
    }

    @Override // com.unisound.sdk.o
    protected java.lang.String x() {
        return super.x();
    }

    @Override // com.unisound.sdk.o
    protected int y() {
        return super.y();
    }

    @Override // com.unisound.sdk.o
    protected int z() {
        return super.z();
    }
}
