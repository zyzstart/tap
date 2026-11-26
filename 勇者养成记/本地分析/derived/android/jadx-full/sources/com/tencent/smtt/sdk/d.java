package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f919a = 0;
    static boolean b = false;
    private static com.tencent.smtt.sdk.d e = null;
    private static int h = 0;
    private static int i = 3;
    private static java.lang.String k;
    private com.tencent.smtt.sdk.s c = null;
    private com.tencent.smtt.sdk.s d = null;
    private boolean f = false;
    private boolean g = false;
    private java.io.File j = null;

    private d() {
    }

    public static com.tencent.smtt.sdk.d a(boolean z) {
        if (e == null && z) {
            synchronized (com.tencent.smtt.sdk.d.class) {
                if (e == null) {
                    e = new com.tencent.smtt.sdk.d();
                }
            }
        }
        return e;
    }

    static void a(int i2) {
        h = i2;
    }

    private void b(int i2) {
        java.lang.String strValueOf = java.lang.String.valueOf(i2);
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty(k, strValueOf);
        try {
            properties.store(new java.io.FileOutputStream(new java.io.File(this.j, "count.prop")), (java.lang.String) null);
        } catch (java.io.FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
    }

    public static int d() {
        return h;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0054: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x0054 */
    private int i() throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Exception e2;
        java.io.BufferedInputStream bufferedInputStream2;
        java.io.BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                java.io.File file = new java.io.File(this.j, "count.prop");
                if (!file.exists()) {
                    return 0;
                }
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(bufferedInputStream);
                    int iIntValue = java.lang.Integer.valueOf(properties.getProperty(k, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                    return iIntValue;
                } catch (java.lang.Exception e4) {
                    e2 = e4;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e6) {
            bufferedInputStream = null;
            e2 = e6;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedInputStream3 != null) {
                bufferedInputStream3.close();
            }
            throw th;
        }
        e2.printStackTrace();
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException e7) {
                e7.printStackTrace();
            }
        }
        return 0;
    }

    public com.tencent.smtt.sdk.s a() {
        if (this.f) {
            return this.c;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(android.content.Context context, boolean z, boolean z2) {
        java.io.File fileQ;
        android.content.Context applicationContext;
        java.io.File fileQ2;
        com.tencent.smtt.utils.TbsLog.addLog(999, null, new java.lang.Object[0]);
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        com.tencent.smtt.utils.TbsLog.i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2);
        f919a = f919a + 1;
        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a();
        com.tencent.smtt.sdk.m.a().b(context, f919a == 1);
        com.tencent.smtt.sdk.m.a().k(context);
        com.tencent.smtt.sdk.TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        boolean zA = com.tencent.smtt.sdk.QbSdk.a(context, z, z2);
        boolean z3 = android.os.Build.VERSION.SDK_INT >= 7;
        boolean zG = zA && z3;
        if (zG) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            zG = com.tencent.smtt.sdk.m.a().g(context, d());
            com.tencent.smtt.utils.TbsLog.i("SDKEngine", "isTbsCoreLegal: " + zG + "; cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        if (!zG) {
            java.lang.String str = "can_load_x5=" + zA + "; is_compatible=" + z3;
            com.tencent.smtt.utils.TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
            if (!com.tencent.smtt.sdk.QbSdk.f818a || !this.f) {
                this.f = false;
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_TBS, new java.lang.Throwable(str));
            }
        } else {
            if (this.f) {
                return;
            }
            try {
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                    com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new java.lang.Object[0]);
                    if (!com.tencent.smtt.sdk.TbsShareManager.j(context)) {
                        this.f = false;
                        com.tencent.smtt.sdk.QbSdk.a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                        return;
                    }
                    fileQ = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.c(context));
                    fileQ2 = com.tencent.smtt.sdk.m.a().q(context);
                    applicationContext = com.tencent.smtt.sdk.TbsShareManager.e(context);
                    if (fileQ2 == null) {
                        this.f = false;
                        com.tencent.smtt.sdk.QbSdk.a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                        return;
                    }
                } else {
                    com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new java.lang.Object[0]);
                    fileQ = com.tencent.smtt.sdk.m.a().q(context);
                    applicationContext = h == 25436 || h == 25437 ? context.getApplicationContext() : context;
                    if (fileQ == null) {
                        this.f = false;
                        com.tencent.smtt.sdk.QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        return;
                    }
                    fileQ2 = fileQ;
                }
                android.content.Context context2 = applicationContext;
                java.lang.String[] dexLoaderFileList = com.tencent.smtt.sdk.QbSdk.getDexLoaderFileList(context, context2, fileQ.getAbsolutePath());
                for (int i2 = 0; i2 < dexLoaderFileList.length; i2++) {
                }
                java.lang.String hostCorePathAppDefined = com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null ? com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() : fileQ2.getAbsolutePath();
                com.tencent.smtt.utils.TbsLog.i("SDKEngine", "SDKEngine init optDir is " + hostCorePathAppDefined);
                if (this.d != null) {
                    com.tencent.smtt.sdk.s sVar = this.d;
                    this.c = sVar;
                    sVar.a(context, context2, fileQ.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, com.tencent.smtt.sdk.QbSdk.d);
                } else {
                    this.c = new com.tencent.smtt.sdk.s(context, context2, fileQ.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, com.tencent.smtt.sdk.QbSdk.d);
                }
                this.f = true;
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                this.f = false;
                com.tencent.smtt.sdk.QbSdk.a(context, "SDKEngine::useSystemWebView by exception: " + th);
            }
        }
        this.j = com.tencent.smtt.sdk.m.s(context);
        this.g = true;
    }

    void a(java.lang.String str) {
        k = str;
    }

    public boolean b() {
        return this.f;
    }

    boolean b(boolean z) {
        b = z;
        return z;
    }

    com.tencent.smtt.sdk.s c() {
        return this.c;
    }

    public java.lang.String e() {
        com.tencent.smtt.sdk.s sVar = this.c;
        return (sVar == null || com.tencent.smtt.sdk.QbSdk.f818a) ? "system webview get nothing..." : sVar.a();
    }

    boolean f() throws java.lang.Throwable {
        if (b) {
            if (k == null) {
                return false;
            }
            int i2 = i();
            if (i2 == 0) {
                b(1);
            } else {
                int i3 = i2 + 1;
                if (i3 > i) {
                    return false;
                }
                b(i3);
            }
        }
        return b;
    }

    boolean g() {
        return this.g;
    }

    public boolean h() {
        return com.tencent.smtt.sdk.QbSdk.useSoftWare();
    }
}
