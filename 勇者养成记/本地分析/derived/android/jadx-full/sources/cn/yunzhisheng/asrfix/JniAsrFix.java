package cn.yunzhisheng.asrfix;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JniAsrFix {
    private static cn.yunzhisheng.asrfix.JniAsrFix D = null;
    private static java.util.List<java.lang.String> E = null;
    private static final int F = 0;
    private static final int G = -1;
    private static final int H = -2;
    private static final int I = -3;
    private static final int J = 100;
    private static final int K = 16;
    private static final int L = 500;
    private static final int M = 502;
    private static java.util.ArrayList<java.lang.Integer> R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static final int f = -2;
    public static final int g = -3;
    public static final int h = -4;
    public static final int i = -5;
    public static final int j = -6;
    public static final int k = -7;
    public static final int l = -8;
    public static final int m = -9;
    public static final int n = -11;
    public static final int o = -12;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 4;
    public static final int u = 5;
    public static final int v = 6;
    public static final int w = 7;
    public static final int x = 8;
    public static final int y = 9;
    public static final int z = 22;
    private java.lang.Object C = new java.lang.Object();
    private boolean N = false;
    private int O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
    private com.unisound.sdk.u P = null;
    private int Q = 1;
    boolean A = false;
    private boolean S = true;
    private boolean T = false;
    protected java.util.concurrent.BlockingQueue<java.lang.String> B = new java.util.concurrent.LinkedBlockingQueue();
    private boolean U = false;

    static {
        java.lang.System.loadLibrary("asrfix");
    }

    private JniAsrFix() {
    }

    public static int a(int i2) {
        return (i2 <= -12 || i2 >= 0) ? i2 : i2 + com.unisound.client.ErrorCode.ASR_FIXENGINE_TRANS_ERROR;
    }

    public static cn.yunzhisheng.asrfix.JniAsrFix a() {
        if (D == null) {
            D = new cn.yunzhisheng.asrfix.JniAsrFix();
            E = new java.util.ArrayList();
            R = new java.util.ArrayList<>();
        }
        return D;
    }

    public static boolean a(java.lang.String str) {
        return crcCheck(str) == 0;
    }

    private native int cancel();

    private native int check_wav_end();

    public static native int compileDecodeNet(java.lang.String str, java.lang.String str2);

    private static native int crcCheck(java.lang.String str);

    private native int getOptionInt(int i2);

    private native java.lang.String getOptionString(int i2, java.lang.String str);

    private native java.lang.String getResult();

    public static native java.lang.String getVersion();

    private native int init(java.lang.String str, java.lang.String str2);

    private native int isEngineIdle();

    private native int isactive(byte[] bArr, int i2);

    private native int recognize(byte[] bArr, int i2);

    private native void release();

    /* JADX INFO: Access modifiers changed from: private */
    public native int reset(java.lang.String str, java.lang.String str2);

    private native java.lang.String search(java.lang.String str, java.lang.String str2);

    private native int setActiveNet(int i2);

    private native int setOptionInt(int i2, int i3);

    private native int setOptionString(int i2, java.lang.String str);

    private native int start(java.lang.String str, int i2);

    private native int stop();

    private native void trackInfo(int i2);

    private void x() {
        if (this.U) {
            return;
        }
        a((byte[]) null, 0);
        g();
    }

    public int a(int i2, int i3) {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int optionInt = setOptionInt(i2, i3);
        return optionInt < 0 ? a(optionInt) : optionInt;
    }

    public int a(int i2, java.lang.String str) {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int optionString = setOptionString(i2, str);
        return optionString < 0 ? a(optionString) : optionString;
    }

    public int a(long j2, int i2) {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int iGrammarCompilerSetOptionInt = grammarCompilerSetOptionInt(j2, 1000, i2);
        return iGrammarCompilerSetOptionInt < 0 ? a(iGrammarCompilerSetOptionInt) : iGrammarCompilerSetOptionInt;
    }

    public int a(long j2, java.lang.String str, java.lang.String str2) {
        if (!E.contains(str)) {
            int iLoadCompiledJsgf = loadCompiledJsgf(j2, str2);
            if (iLoadCompiledJsgf == 0) {
                E.add(str);
            }
            return iLoadCompiledJsgf;
        }
        com.unisound.common.y.a("loadGompiledJsgf failed , the jsgf.dat of this grammarTag is already exists! The grammarTag is " + str);
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int a(long j2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object[] objArr;
        synchronized (D) {
            try {
                this.S = false;
                if (j2 == 0) {
                    com.unisound.common.y.c("compile  compileDynamicUserData fail handle=0");
                    return com.unisound.client.ErrorCode.ASR_SDK_FIX_COMPILE_NO_INIT;
                }
                if (E.contains(str)) {
                    objArr = new java.lang.Object[]{"compileDynamicUserData : grammarDat is loaded so compile directly!"};
                } else {
                    com.unisound.common.y.c("compileDynamicUserData  loadedGrammar = + ", str, " grammarPath= ", str2);
                    int iLoadCompiledJsgf = loadCompiledJsgf(j2, str2);
                    if (iLoadCompiledJsgf != 0) {
                        com.unisound.common.y.a("compileDynamicUserData loadCompileJsgf error!  loadCompiledJsgfResult = " + iLoadCompiledJsgf);
                        return iLoadCompiledJsgf;
                    }
                    E.add(str);
                    objArr = new java.lang.Object[]{"compileDynamicUserData loadCompiledJsgf success!"};
                }
                com.unisound.common.y.c(objArr);
                int i2 = 0;
                while (isEngineIdle() != 1 && i2 < 2000) {
                    try {
                        java.lang.Thread.sleep(50L);
                        i2 += 50;
                    } catch (java.lang.InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                int iCompileDynamicUserData = compileDynamicUserData(j2, str3, str);
                com.unisound.common.y.c(iCompileDynamicUserData == 0 ? new java.lang.Object[]{"compileDynamicUserData : compile success! ", java.lang.Integer.valueOf(i2)} : new java.lang.Object[]{"compileDynamicUserData : compile failed!", java.lang.Integer.valueOf(i2)});
                this.S = true;
                return iCompileDynamicUserData;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public int a(java.lang.String str, int i2) {
        x();
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        com.unisound.common.y.c("JniAsrFix : start_ -> recognizerStatus = ", java.lang.Integer.valueOf(this.O));
        if (this.O != 1501) {
            return com.unisound.client.ErrorCode.ASR_FIXENGINE_UNKNOW_ERROR;
        }
        int iStart = start(str, i2);
        if (iStart == 0) {
            this.N = true;
            this.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_RECOGNIZING;
            this.P.a(this.O);
        }
        return iStart < 0 ? a(iStart) : iStart;
    }

    public int a(java.lang.String str, java.lang.String str2, com.unisound.sdk.w wVar, java.lang.String str3) {
        this.S = false;
        if (this.U) {
            com.unisound.common.y.c("Recognizer.loadModel queue add ", str, " ", str2);
            this.B.add(str);
            this.B.add(str2);
            this.B.add(str3);
            if (!this.T) {
                new cn.yunzhisheng.asrfix.a(this, wVar).start();
            }
        } else {
            com.unisound.common.y.a("Recognizer.loadModel not init Error");
        }
        return 0;
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3, com.unisound.sdk.w wVar) {
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix;
        i();
        this.A = false;
        cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix2 = D;
        if (jniAsrFix2 != null) {
            jniAsrFix2.a(java.lang.Boolean.valueOf(wVar.aw()));
        }
        int iInit = init(str, str2);
        if (iInit == 0) {
            if (wVar.aN() != -1 && (jniAsrFix = D) != null) {
                jniAsrFix.j(wVar.aN());
            }
            this.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
            this.U = true;
            if ("init_asr" == str3) {
                this.Q = getOptionInt(100);
                for (int i2 = 0; i2 < this.Q; i2++) {
                    int optionInt = setOptionInt(16, i2);
                    com.unisound.common.y.c("JniAsrFix ", "modelNum = ", java.lang.Integer.valueOf(this.Q), ", modelId = ", java.lang.Integer.valueOf(optionInt));
                    R.add(java.lang.Integer.valueOf(optionInt));
                }
                wVar.a(R);
                if (this.Q < 2) {
                    int optionInt2 = setOptionInt(16, 0);
                    com.unisound.common.y.c("JniAsrFix :modelNum = ", java.lang.Integer.valueOf(this.Q), ", defaulltModelId = ", java.lang.Integer.valueOf(optionInt2));
                    wVar.E(optionInt2);
                    wVar.D(optionInt2);
                }
                this.P.a(com.unisound.client.SpeechConstants.ASR_EVENT_INIT_DONE, (int) java.lang.System.currentTimeMillis());
            }
        } else {
            this.P.b(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_INIT_ERROR);
        }
        return a(iInit);
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        com.unisound.common.y.c("compile  initUserDataCompiler");
        long jInitUserDataCompiler = initUserDataCompiler(str4);
        if (jInitUserDataCompiler == 0) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_COMPILE_NO_INIT;
        }
        com.unisound.common.y.c("compile  compileUserData ===handle,inPartialFile, jsgf, szContent, netDat,outPartialFile", " = ", java.lang.Long.valueOf(jInitUserDataCompiler), " , ", str, " , ", str2, " , ", str3, " , ", str5, " , ", str6);
        int iPartialCompileUserData = partialCompileUserData(jInitUserDataCompiler, str, str2, str3, str5, str6);
        com.unisound.common.y.c("compile  destroyUserDataCompiler");
        destroyUserDataCompiler(jInitUserDataCompiler);
        if (iPartialCompileUserData == 0) {
            com.unisound.common.y.c("compile  compileUserData ok");
            return iPartialCompileUserData;
        }
        if (iPartialCompileUserData == -10) {
            com.unisound.common.y.a("compile compileUserData partialfile error, autofix ok");
            return 0;
        }
        com.unisound.common.y.a("compile  compileUserData fail code = " + iPartialCompileUserData);
        return a(iPartialCompileUserData);
    }

    public int a(boolean z2) {
        return setOptionInt(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_THROWABLE, z2 ? 0 : 1);
    }

    public int a(byte[] bArr, int i2) {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int iIsactive = isactive(bArr, i2);
        return iIsactive < 0 ? a(iIsactive) : iIsactive;
    }

    public java.lang.String a(long j2) {
        if (this.U) {
            return j2 == 0 ? "handle is 0" : grammarCompilerGetOptionString(j2, 1002);
        }
        return "";
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (this.U) {
            return search(str, str2);
        }
        return null;
    }

    public void a(com.unisound.sdk.u uVar) {
        this.P = uVar;
    }

    public void a(java.lang.Boolean bool) {
        setOptionInt(12, bool.booleanValue() ? 1 : 0);
    }

    public int b(int i2) {
        return setOptionInt(t() ? 108 : 17, i2);
    }

    public int b(long j2, int i2) {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int iGrammarCompilerSetOptionInt = grammarCompilerSetOptionInt(j2, 1001, i2);
        return iGrammarCompilerSetOptionInt < 0 ? a(iGrammarCompilerSetOptionInt) : iGrammarCompilerSetOptionInt;
    }

    public int b(boolean z2) {
        return setOptionInt(com.tencent.smtt.sdk.TbsListener.ErrorCode.PV_UPLOAD_ERROR, z2 ? 0 : 1);
    }

    public int b(byte[] bArr, int i2) {
        return this.U ? recognize(bArr, i2) : com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
    }

    public void b() {
        int iCancel = cancel();
        if (iCancel != 0) {
            com.unisound.common.y.c("JniAsrFix : cancel failed , result code = ", java.lang.Integer.valueOf(iCancel));
        }
    }

    public int c(int i2) {
        return setOptionInt(18, i2 / 10);
    }

    public boolean c() {
        return this.A;
    }

    public native int compileDynamicUserData(long j2, java.lang.String str, java.lang.String str2);

    public native int compileUserData(long j2, java.lang.String str, java.lang.String str2, java.lang.String str3);

    public int d(int i2) {
        return setOptionInt(120, i2);
    }

    public void d() {
        this.A = true;
    }

    public native void destroyUserDataCompiler(long j2);

    public int e() {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int iStop = stop();
        if (iStop == 0) {
            this.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
            this.P.a(this.O);
            this.N = false;
        }
        return iStop < 0 ? a(iStop) : iStop;
    }

    public int e(int i2) {
        return setOptionInt(200, i2);
    }

    public int f(int i2) {
        return setOptionInt(201, i2);
    }

    public java.lang.String f() {
        return this.U ? getResult() : "";
    }

    public int g() {
        if (!this.U) {
            return com.unisound.client.ErrorCode.ASR_SDK_FIX_RECOGNIZER_NO_INIT;
        }
        int iCancel = cancel();
        if (iCancel == 0) {
            this.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
            this.P.a(this.O);
            this.N = false;
        }
        return iCancel < 0 ? a(iCancel) : iCancel;
    }

    public int g(int i2) {
        return setOptionInt(202, i2);
    }

    public native java.lang.String getTagsInfo(long j2);

    public native java.lang.String grammarCompilerGetOptionString(long j2, int i2);

    public native int grammarCompilerSetOptionInt(long j2, int i2, int i3);

    public int h(int i2) {
        return setActiveNet(i2);
    }

    public boolean h() {
        return this.U;
    }

    public int i(int i2) {
        return setOptionInt(22, i2);
    }

    public void i() {
        if (this.U) {
            com.unisound.common.y.c("do Release");
            release();
            E.clear();
            this.U = false;
            this.N = false;
            this.S = true;
        }
    }

    public native long initUserDataCompiler(java.lang.String str);

    public void j(int i2) {
        setOptionInt(500, i2);
        setOptionInt(502, 1);
        com.unisound.common.y.c("JniAsrFix : setThreadNum num = ", java.lang.Integer.valueOf(i2));
    }

    public boolean j() {
        return this.N;
    }

    public int k() {
        return this.Q;
    }

    public int l() {
        return getOptionInt(101);
    }

    public native int loadCompiledJsgf(long j2, java.lang.String str);

    public native int loadGrammarStr(java.lang.String str);

    public java.util.List<java.lang.Integer> m() {
        return R;
    }

    public int n() {
        int optionInt = getOptionInt(103);
        com.unisound.common.y.c("getAuthorizedStaus = ", java.lang.Integer.valueOf(optionInt));
        return optionInt;
    }

    public java.lang.String o() {
        java.lang.String optionString = getOptionString(104, "");
        com.unisound.common.y.c("getExpiryTime = ", optionString);
        return optionString;
    }

    public java.lang.String p() {
        java.lang.String optionString = getOptionString(105, "");
        com.unisound.common.y.c("getLimitPac = ", optionString);
        return optionString;
    }

    public native int partialCompileUserData(long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    public int q() {
        return getOptionInt(102);
    }

    public int r() {
        return getOptionInt(107);
    }

    public int s() {
        return getOptionInt(106);
    }

    public boolean t() {
        return getVersion().contains("V3.");
    }

    public int u() {
        return check_wav_end();
    }

    public native int unloadGrammar(java.lang.String str);

    public void v() {
        E.clear();
    }
}
