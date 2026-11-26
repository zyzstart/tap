package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"NewApi"})
public class QbSdk {
    private static java.lang.String A = null;
    private static boolean B = false;
    private static boolean C = true;
    private static com.tencent.smtt.sdk.TbsListener D = null;
    private static com.tencent.smtt.sdk.TbsListener E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    private static boolean F = false;
    public static final java.lang.String FILERADER_MENUDATA = "menuData";
    private static boolean G = false;
    public static final java.lang.String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final java.lang.String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final java.lang.String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final java.lang.String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final java.lang.String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final java.lang.String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final java.lang.String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean b = false;
    static boolean c = true;
    static java.lang.String d = null;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static boolean i = true;
    public static boolean isDefaultDialog = false;
    static boolean j = true;
    static boolean k = false;
    public static boolean mDisableUseHostBackupCore = false;
    private static int o = 0;
    private static java.lang.String p = "";
    private static java.lang.Class q = null;
    private static java.lang.Object r = null;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static java.lang.String[] t = null;
    private static java.lang.String u = "NULL";
    private static java.lang.String v = "UNKNOWN";
    private static boolean w = false;
    private static int x = 0;
    private static int y = 170;
    private static java.lang.String z;
    static java.lang.Object h = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f818a = false;
    static volatile boolean l = f818a;
    static com.tencent.smtt.sdk.TbsListener m = new com.tencent.smtt.sdk.TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.7
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i2) {
            if (com.tencent.smtt.sdk.TbsDownloader.needDownloadDecoupleCore()) {
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                com.tencent.smtt.sdk.TbsDownloader.f858a = true;
                return;
            }
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            com.tencent.smtt.sdk.TbsDownloader.f858a = false;
            if (com.tencent.smtt.sdk.QbSdk.D != null) {
                com.tencent.smtt.sdk.QbSdk.D.onDownloadFinish(i2);
            }
            if (com.tencent.smtt.sdk.QbSdk.E != null) {
                com.tencent.smtt.sdk.QbSdk.E.onDownloadFinish(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i2) {
            if (com.tencent.smtt.sdk.QbSdk.E != null) {
                com.tencent.smtt.sdk.QbSdk.E.onDownloadProgress(i2);
            }
            if (com.tencent.smtt.sdk.QbSdk.D != null) {
                com.tencent.smtt.sdk.QbSdk.D.onDownloadProgress(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i2) {
            com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
            com.tencent.smtt.sdk.TbsDownloader.f858a = false;
            com.tencent.smtt.sdk.TbsDownloader.f858a = com.tencent.smtt.sdk.TbsDownloader.startDecoupleCoreIfNeeded();
            if (com.tencent.smtt.sdk.QbSdk.D != null) {
                com.tencent.smtt.sdk.QbSdk.D.onInstallFinish(i2);
            }
            if (com.tencent.smtt.sdk.QbSdk.E != null) {
                com.tencent.smtt.sdk.QbSdk.E.onInstallFinish(i2);
            }
        }
    };
    public static java.lang.String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    static java.util.Map n = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static android.os.Bundle a(android.content.Context context, android.os.Bundle bundle) {
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        java.lang.String str;
        if (a(context)) {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "incrUpdate", new java.lang.Class[]{android.content.Context.class, android.os.Bundle.class}, context, bundle);
            if (objA != null) {
                return (android.os.Bundle) objA;
            }
            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
            str = "incrUpdate return null!";
        } else {
            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
            str = "initForPatch return false!";
        }
        tbsLogReport.setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_ERROR, str);
        return null;
    }

    private static android.os.Bundle a(android.content.Context context, java.util.Map map) {
        if (map == null) {
            return null;
        }
        try {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : (java.lang.String) map.get("style"));
            try {
                bundle.putInt("topBarBgColor", android.graphics.Color.parseColor((java.lang.String) map.get("topBarBgColor")));
            } catch (java.lang.Exception unused) {
            }
            if (map != null && map.containsKey(FILERADER_MENUDATA)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) map.get(FILERADER_MENUDATA));
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
                    for (int i2 = 0; i2 < jSONArray.length() && i2 < 5; i2++) {
                        try {
                            org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray.get(i2);
                            arrayList.add(i2, android.graphics.BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                            jSONObject2.put("iconResId", i2);
                        } catch (java.lang.Exception unused2) {
                        }
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static java.lang.Object a(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        if (!a(context)) {
            return java.lang.Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "miscCall", new java.lang.Class[]{java.lang.String.class, android.os.Bundle.class}, str, bundle);
        if (objA != null) {
            return objA;
        }
        return null;
    }

    static java.lang.String a() {
        return p;
    }

    static synchronized void a(android.content.Context context, java.lang.String str) {
        if (f818a) {
            return;
        }
        f818a = true;
        v = "forceSysWebViewInner: " + str;
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 401, new java.lang.Throwable(v));
    }

    static boolean a(android.content.Context context) {
        try {
            if (q != null) {
                return true;
            }
            java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
            if (fileQ == null) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            java.io.File file = new java.io.File(fileQ, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            com.tencent.smtt.sdk.u.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, fileQ.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "initExtension sys WebView: " + android.util.Log.getStackTraceString(th));
            return false;
        }
    }

    static boolean a(android.content.Context context, int i2) {
        return a(context, i2, cn.yunzhisheng.asr.a.b);
    }

    static boolean a(android.content.Context context, int i2, int i3) {
        java.util.Map map = n;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        }
        com.tencent.smtt.sdk.m.a().b(context, com.tencent.smtt.sdk.d.f919a == 0);
        if (!c(context)) {
            return true;
        }
        java.lang.Object obj = r;
        java.lang.Class cls = java.lang.Integer.TYPE;
        java.lang.Object objA = com.tencent.smtt.utils.k.a(obj, "isX5Disabled", new java.lang.Class[]{cls, cls, cls}, java.lang.Integer.valueOf(i2), 43903, java.lang.Integer.valueOf(i3));
        if (objA == null) {
            java.lang.Object obj2 = r;
            java.lang.Class cls2 = java.lang.Integer.TYPE;
            objA = com.tencent.smtt.utils.k.a(obj2, "isX5Disabled", new java.lang.Class[]{cls2, cls2}, java.lang.Integer.valueOf(i2), 43903);
            if (objA == null) {
                return true;
            }
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    private static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return isSuportOpenFile(str2, 2);
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static boolean a(android.content.Context context, boolean z2) {
        int iA;
        java.io.File file;
        com.tencent.smtt.sdk.TbsCoreLoadStat tbsCoreLoadStat;
        int i2;
        java.lang.Exception exc;
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43903; SDK_VERSION_NAME: 4.3.0.3");
            sIsVersionPrinted = true;
        }
        if (f818a && !z2) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED, new java.lang.Throwable(v));
            return false;
        }
        if (b) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 402, new java.lang.Throwable(u));
            return false;
        }
        if (!C) {
            d(context);
        }
        try {
            java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
            if (fileQ == null) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new java.lang.Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                return false;
            }
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                if (o != 0 && o != com.tencent.smtt.sdk.TbsShareManager.d(context)) {
                    q = null;
                    r = null;
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 302, new java.lang.Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + com.tencent.smtt.sdk.TbsShareManager.d(context)));
                    return false;
                }
                iA = com.tencent.smtt.sdk.TbsShareManager.d(context);
            } else if (o != 0) {
                iA = com.tencent.smtt.sdk.m.a().a(true, context);
                if (o != iA) {
                    q = null;
                    r = null;
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + iA, true);
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 303, new java.lang.Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + iA));
                    return false;
                }
            } else {
                iA = 0;
            }
            o = iA;
            if (com.tencent.smtt.sdk.TbsDownloader.a(context, o)) {
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "version " + o + " is in blacklist,can not load! return");
                return false;
            }
            if (q != null && r != null) {
                return true;
            }
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                file = new java.io.File(com.tencent.smtt.sdk.m.a().q(context), "tbs_sdk_extension_dex.jar");
            } else {
                if (!com.tencent.smtt.sdk.TbsShareManager.j(context)) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 304, new java.lang.Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                file = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            }
            if (file.exists()) {
                java.lang.String hostCorePathAppDefined = com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null ? com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() : fileQ.getAbsolutePath();
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + hostCorePathAppDefined);
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                com.tencent.smtt.sdk.u.a().b(context);
                com.tencent.smtt.utils.m.a(context);
                q = new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                loadTBSSDKExtension(context, file.getParent());
                com.tencent.smtt.utils.k.a(r, "setClientVersion", new java.lang.Class[]{java.lang.Integer.TYPE}, 1);
                return true;
            }
            try {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                int i3 = com.tencent.smtt.sdk.m.a().i(context);
                if (new java.io.File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                    if (i3 > 0) {
                        tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                        i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE;
                        exc = new java.lang.Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i3);
                    } else {
                        tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                        i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE;
                        exc = new java.lang.Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i3);
                    }
                } else if (i3 > 0) {
                    tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                    i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE;
                    exc = new java.lang.Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i3);
                } else {
                    tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                    i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE;
                    exc = new java.lang.Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i3);
                }
                tbsCoreLoadStat.a(context, i2, exc);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return false;
        } catch (java.lang.Throwable th2) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk init Throwable: " + android.util.Log.getStackTraceString(th2));
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, th2);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x016b  */
    /* JADX WARN: Code duplicated, block: B:65:0x017a  */
    /* JADX WARN: Code duplicated, block: B:73:0x018a  */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x018a, please report this as an issue */
    static boolean a(android.content.Context context, boolean z2, boolean z3) {
        int i2;
        int i3;
        java.lang.String string;
        com.tencent.smtt.sdk.TbsCoreLoadStat tbsCoreLoadStat;
        java.lang.Throwable th;
        int i4;
        com.tencent.smtt.sdk.TbsCoreLoadStat tbsCoreLoadStat2;
        int iIntValue;
        java.lang.Throwable th2;
        int disabledCoreVersion = com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        boolean z4 = false;
        if (disabledCoreVersion != 0 && disabledCoreVersion == com.tencent.smtt.sdk.m.a().i(context)) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "force use sys by remote switch");
            return false;
        }
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) && !com.tencent.smtt.sdk.TbsShareManager.i(context)) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 302);
            return false;
        }
        if (!a(context, z2)) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk.init failure!");
            return false;
        }
        boolean z5 = true;
        java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "canLoadX5Core", new java.lang.Class[]{java.lang.Integer.TYPE}, 43903);
        if (objA == null) {
            java.lang.Object objA2 = com.tencent.smtt.utils.k.a(r, "canLoadX5", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(com.tencent.smtt.sdk.a.a()));
            if (objA2 == null) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
            } else {
                if ((objA2 instanceof java.lang.String) && ((java.lang.String) objA2).equalsIgnoreCase("AuthenticationFail")) {
                    return false;
                }
                if (objA2 instanceof java.lang.Boolean) {
                    o = com.tencent.smtt.sdk.d.d();
                    boolean zA = a(context, com.tencent.smtt.sdk.d.d());
                    java.lang.Boolean bool = (java.lang.Boolean) objA2;
                    z5 = bool.booleanValue() && !zA;
                    if (!z5) {
                        com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsListener.tag_load_error, "318");
                        com.tencent.smtt.utils.TbsLog.w(com.tencent.smtt.sdk.TbsListener.tag_load_error, "isX5Disable:" + zA);
                        com.tencent.smtt.utils.TbsLog.w(com.tencent.smtt.sdk.TbsListener.tag_load_error, "(Boolean) ret:" + bool);
                    }
                    return z5;
                }
            }
        } else {
            if ((objA instanceof java.lang.String) && ((java.lang.String) objA).equalsIgnoreCase("AuthenticationFail")) {
                return false;
            }
            if (!(objA instanceof android.os.Bundle)) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new java.lang.Throwable("" + objA));
                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsListener.tag_load_error, "ret not instance of bundle");
                return false;
            }
            android.os.Bundle bundle = (android.os.Bundle) objA;
            if (bundle.isEmpty()) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new java.lang.Throwable("" + objA));
                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsListener.tag_load_error, "empty bundle");
                return false;
            }
            try {
                i2 = bundle.getInt(android.support.v4.provider.FontsContractCompat.Columns.RESULT_CODE, -1);
            } catch (java.lang.Exception e2) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e2.toString());
                i2 = -1;
            }
            boolean z6 = i2 == 0;
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                com.tencent.smtt.sdk.d.a(com.tencent.smtt.sdk.TbsShareManager.d(context));
                java.lang.String strValueOf = java.lang.String.valueOf(com.tencent.smtt.sdk.TbsShareManager.d(context));
                p = strValueOf;
                if (strValueOf.length() == 5) {
                    p = "0" + p;
                }
                if (p.length() != 6) {
                    p = "";
                }
            } else {
                try {
                    try {
                        if (android.os.Build.VERSION.SDK_INT >= 12) {
                            string = bundle.getString("tbs_core_version", "0");
                        } else {
                            java.lang.String string2 = bundle.getString("tbs_core_version");
                            p = string2;
                            if (string2 == null) {
                                string = "0";
                            }
                            o = java.lang.Integer.parseInt(p);
                            com.tencent.smtt.sdk.d.a(o);
                            i3 = o;
                            if (i3 == 0) {
                                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("sTbsVersion is 0"));
                                return false;
                            }
                            if ((i3 > 0 || i3 > 25442) && o != 25472) {
                            }
                            if (z5) {
                                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + o);
                                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().q(context));
                                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("is_obsolete --> delete old core:" + o));
                                return false;
                            }
                        }
                        p = string;
                    } catch (java.lang.Exception unused) {
                        p = "0";
                    }
                    o = java.lang.Integer.parseInt(p);
                } catch (java.lang.NumberFormatException unused2) {
                    o = 0;
                }
                com.tencent.smtt.sdk.d.a(o);
                i3 = o;
                if (i3 == 0) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("sTbsVersion is 0"));
                    return false;
                }
                z5 = i3 > 0 ? false : false;
                if (z5) {
                    com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + o);
                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().q(context));
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("is_obsolete --> delete old core:" + o));
                    return false;
                }
            }
            try {
                java.lang.String[] stringArray = bundle.getStringArray("tbs_jarfiles");
                t = stringArray;
                if (!(stringArray instanceof java.lang.String[])) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("sJarFiles not instanceof String[]: " + t));
                    return false;
                }
                try {
                    d = bundle.getString("tbs_librarypath");
                    java.lang.Object objA3 = null;
                    if (i2 != 0) {
                        try {
                            objA3 = com.tencent.smtt.utils.k.a(r, "getErrorCodeForLogReport", new java.lang.Class[0], new java.lang.Object[0]);
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (i2 != -2) {
                        if (i2 != -1) {
                            if (i2 != 0) {
                                tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                                th = new java.lang.Throwable("detail: " + objA3 + com.tencent.ysdk.shell.framework.request.HttpResponse.HTTP_RESP_PARAM_CODE + i2);
                                i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT;
                                tbsCoreLoadStat.a(context, i4, th);
                            }
                        } else if (objA3 instanceof java.lang.Integer) {
                            tbsCoreLoadStat2 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                            iIntValue = ((java.lang.Integer) objA3).intValue();
                            th2 = new java.lang.Throwable("detail: " + objA3);
                            tbsCoreLoadStat2.a(context, iIntValue, th2);
                        } else {
                            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new java.lang.Throwable("detail: " + objA3));
                        }
                    } else if (objA3 instanceof java.lang.Integer) {
                        tbsCoreLoadStat2 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                        iIntValue = ((java.lang.Integer) objA3).intValue();
                        th2 = new java.lang.Throwable("detail: " + objA3);
                        tbsCoreLoadStat2.a(context, iIntValue, th2);
                    } else {
                        tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                        th = new java.lang.Throwable("detail: " + objA3);
                        i4 = 404;
                        tbsCoreLoadStat.a(context, i4, th);
                    }
                    z4 = z6;
                } catch (java.lang.Exception unused3) {
                    return false;
                }
            } catch (java.lang.Throwable th3) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th3);
                return false;
            }
        }
        if (!z4) {
            com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsListener.tag_load_error, "319");
        }
        return z4;
    }

    protected static java.lang.String b() {
        java.lang.Object objInvokeStaticMethod;
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b() || (objInvokeStaticMethod = uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new java.lang.Class[0], new java.lang.Object[0])) == null || !(objInvokeStaticMethod instanceof java.lang.String)) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    static boolean b(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "clearPluginConfigFile #1");
            java.lang.String string = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            java.lang.String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                return true;
            }
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.commit();
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    private static boolean c(android.content.Context context) {
        java.io.File file;
        try {
            if (q != null) {
                return true;
            }
            java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
            if (fileQ == null) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                file = new java.io.File(com.tencent.smtt.sdk.m.a().q(context), "tbs_sdk_extension_dex.jar");
            } else {
                if (!com.tencent.smtt.sdk.TbsShareManager.j(context)) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 304);
                    return false;
                }
                file = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            }
            if (!file.exists()) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_OLD, new java.lang.Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            java.lang.String hostCorePathAppDefined = com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null ? com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() : fileQ.getAbsolutePath();
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + hostCorePathAppDefined);
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            com.tencent.smtt.sdk.u.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            com.tencent.smtt.utils.k.a(r, "setClientVersion", new java.lang.Class[]{java.lang.Integer.TYPE}, 1);
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + android.util.Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0036  */
    /* JADX WARN: Code duplicated, block: B:13:? A[RETURN, SYNTHETIC] */
    public static boolean canLoadVideo(android.content.Context context) {
        com.tencent.smtt.sdk.TbsCoreLoadStat tbsCoreLoadStat;
        int i2;
        java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "canLoadVideo", new java.lang.Class[]{java.lang.Integer.TYPE}, 0);
        if (objA != null) {
            if (!((java.lang.Boolean) objA).booleanValue()) {
                tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE;
            }
            if (objA == null) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        }
        tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL;
        tbsCoreLoadStat.a(context, i2);
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public static boolean canLoadX5(android.content.Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(android.content.Context context) {
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && android.os.Build.VERSION.SDK_INT == 19) {
                return true;
            }
            if (q == null) {
                java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
                if (fileQ == null) {
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                java.io.File file = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (!file.exists()) {
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
                java.lang.String hostCorePathAppDefined = com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null ? com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() : fileQ.getAbsolutePath();
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + hostCorePathAppDefined);
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                com.tencent.smtt.sdk.u.a().b(context);
                com.tencent.smtt.utils.m.a(context);
                q = new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (r == null) {
                    if (com.tencent.smtt.sdk.TbsShareManager.e(context) == null && com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() == null) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                        return false;
                    }
                    loadTBSSDKExtension(context, file.getParent());
                }
            }
            java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "canLoadX5CoreForThirdApp", new java.lang.Class[0], new java.lang.Object[0]);
            if (objA == null || !(objA instanceof java.lang.Boolean)) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + android.util.Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(final android.content.Context context, final java.lang.String str, final com.tencent.smtt.sdk.ValueCallback valueCallback) {
        new java.lang.Thread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
                uVarA.a(context);
                final boolean zA = uVarA.b() ? uVarA.c().a(context, str) : false;
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(java.lang.Boolean.valueOf(zA));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(android.content.Context context, java.lang.String str) {
        if (!a(context, false)) {
        }
        return false;
    }

    public static boolean canOpenWebPlus(android.content.Context context) {
        java.io.FileInputStream fileInputStream;
        if (x == 0) {
            x = com.tencent.smtt.sdk.a.a();
        }
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + x);
        boolean z2 = false;
        if (android.os.Build.VERSION.SDK_INT < 7 || x < y || context == null) {
            return false;
        }
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(new java.io.File(com.tencent.smtt.sdk.m.a().q(context), "tbs.conf")));
            try {
                java.util.Properties properties = new java.util.Properties();
                properties.load(bufferedInputStream2);
                java.lang.String property = properties.getProperty("android_sdk_max_supported");
                java.lang.String property2 = properties.getProperty("android_sdk_min_supported");
                int i2 = java.lang.Integer.parseInt(property);
                int i3 = java.lang.Integer.parseInt(property2);
                int i4 = java.lang.Integer.parseInt(android.os.Build.VERSION.SDK);
                if (i4 <= i2 && i4 >= i3) {
                    int i5 = java.lang.Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (java.lang.Exception unused) {
                    }
                    try {
                        fileInputStream = new java.io.FileInputStream(new java.io.File(com.tencent.smtt.sdk.m.s(context), "tbs_extension.conf"));
                        try {
                            java.util.Properties properties2 = new java.util.Properties();
                            properties2.load(fileInputStream);
                            int i6 = java.lang.Integer.parseInt(properties2.getProperty("tbs_local_version"));
                            int i7 = java.lang.Integer.parseInt(properties2.getProperty(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                            if (i5 != 88888888 && i6 != 88888888 && i5 <= i6 && i5 == i6 && ((i7 <= 0 || i7 == com.tencent.smtt.utils.b.b(context)) && java.lang.Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false))) {
                                z2 = true;
                            }
                        } catch (java.lang.Throwable unused2) {
                            try {
                                com.tencent.smtt.utils.TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                                if (fileInputStream == null) {
                                    z2 = true;
                                }
                                return !z2;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.lang.Exception unused3) {
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Throwable unused4) {
                        fileInputStream = null;
                    }
                    return !z2;
                }
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + i4);
                try {
                    bufferedInputStream2.close();
                } catch (java.lang.Exception unused5) {
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    com.tencent.smtt.utils.TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    return false;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Exception unused6) {
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean canUseVideoFeatrue(android.content.Context context, int i2) {
        java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "canUseVideoFeatrue", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i2));
        if (objA == null || !(objA instanceof java.lang.Boolean)) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public static boolean checkApkExist(android.content.Context context, java.lang.String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean checkContentProviderPrivilage(android.content.Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || android.os.Build.VERSION.SDK_INT < 24 || "com.tencent.mobileqq".equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!android.text.TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new android.content.ComponentName(context.getPackageName(), "android.support.v4.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
        if (providerInfoResolveContentProvider == null) {
            android.util.Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        return providerInfoResolveContentProvider != null;
    }

    public static void checkTbsValidity(android.content.Context context) {
        if (context == null || com.tencent.smtt.utils.m.b(context)) {
            return;
        }
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CORE_CHECK_VALIDITY_FALSE);
        forceSysWebView();
    }

    public static void clear(android.content.Context context) {
    }

    public static void clearAllWebViewCache(android.content.Context context, boolean z2) {
        java.lang.Throwable th;
        boolean z3;
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "clearAllWebViewCache(" + context + ", " + z2 + ")");
        boolean z4 = false;
        try {
            if (new com.tencent.smtt.sdk.WebView(context).getWebViewClientExtension() != null) {
                try {
                    com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
                    if (uVarA != null && uVarA.b()) {
                        uVarA.c().a(context, z2);
                    }
                    z4 = true;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    z3 = true;
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + android.util.Log.getStackTraceString(th));
                    z4 = z3;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            z3 = false;
        }
        if (z4) {
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z2) {
                android.webkit.CookieSyncManager.createInstance(context);
                android.webkit.CookieManager.getInstance().removeAllCookie();
            }
            android.webkit.WebViewDatabase.getInstance(context).clearUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearFormData();
            android.webkit.WebStorage.getInstance().deleteAllData();
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } catch (java.lang.Throwable th4) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + android.util.Log.getStackTraceString(th4));
        }
    }

    public static void closeFileReader(android.content.Context context) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        if (uVarA.b()) {
            uVarA.c().p();
        }
    }

    public static void continueLoadSo(android.content.Context context) {
        if ("com.tencent.mm".equals(getCurrentProcessName(context)) && com.tencent.smtt.sdk.WebView.mWebViewCreated) {
            com.tencent.smtt.utils.k.a(r, "continueLoadSo", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(android.content.Context context, java.lang.String str, java.lang.String str2, android.graphics.drawable.Drawable drawable) {
        com.tencent.smtt.sdk.u uVarA;
        if (context != null && !com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) && !isMiniQBShortCutExist(context, str, str2) && (uVarA = com.tencent.smtt.sdk.u.a()) != null && uVarA.b()) {
            android.graphics.Bitmap bitmap = drawable instanceof android.graphics.drawable.BitmapDrawable ? ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap() : null;
            com.tencent.smtt.export.external.DexLoader dexLoaderB = uVarA.c().b();
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            java.lang.Object objInvokeStaticMethod = dexLoaderB.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.String.class, android.graphics.Bitmap.class}, context, str, str2, bitmap);
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + objInvokeStaticMethod);
            if (objInvokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004c A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #1 {all -> 0x005b, blocks: (B:18:0x0037, B:19:0x0044, B:21:0x004c), top: B:64:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007c A[PHI: r3 r5 r7
  0x007c: PHI (r3v3 android.content.SharedPreferences) = (r3v4 android.content.SharedPreferences), (r3v13 android.content.SharedPreferences) binds: [B:30:0x0062, B:20:0x004a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r5v2 int) = (r5v3 int), (r5v7 int) binds: [B:30:0x0062, B:20:0x004a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r7v1 int) = (r7v2 int), (r7v5 int) binds: [B:30:0x0062, B:20:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x008c A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:34:0x0080, B:36:0x008c, B:38:0x00a1, B:40:0x00a6, B:41:0x00b8, B:45:0x00d5, B:44:0x00bf), top: B:62:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1 A[Catch: all -> 0x00e1, TRY_LEAVE, TryCatch #0 {all -> 0x00e1, blocks: (B:34:0x0080, B:36:0x008c, B:38:0x00a1, B:40:0x00a6, B:41:0x00b8, B:45:0x00d5, B:44:0x00bf), top: B:62:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:53:0x0117  */
    /* JADX WARN: Code duplicated, block: B:56:0x0120 A[Catch: all -> 0x012f, TRY_LEAVE, TryCatch #3 {all -> 0x012f, blocks: (B:54:0x0118, B:56:0x0120), top: B:68:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static void d(android.content.Context context) {
        int i2;
        int i3;
        int i4;
        int i5;
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.io.File fileA;
        int i6;
        int i7;
        C = true;
        int i8 = 0;
        android.content.SharedPreferences sharedPreferences = null;
        try {
            sharedPreferences = android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            int i9 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i9 >= 0) {
                i9++;
                if (i9 > 4) {
                    return;
                } else {
                    i2 = i9;
                }
            } else {
                i2 = -1;
            }
            try {
                i3 = com.tencent.smtt.sdk.m.a().i(context);
                if (i3 <= 0) {
                    return;
                }
                if (i9 <= 4) {
                    try {
                        sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i9).commit();
                        i7 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i7 >= 0) {
                            i4 = 1 + i7;
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4).commit();
                        } else {
                            i4 = -1;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.tencent.smtt.utils.TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + android.util.Log.getStackTraceString(th));
                    }
                } else {
                    i7 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i7 >= 0) {
                        i4 = 1 + i7;
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4).commit();
                    } else {
                        i4 = -1;
                    }
                }
                if (i4 > 3) {
                    if (i2 > 0 || i2 > 3) {
                        i8 = -1;
                    } else {
                        com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        com.tencent.smtt.sdk.u.a().a(context);
                        com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                    }
                    try {
                        i6 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i6 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i6 - 1).commit();
                        }
                    } catch (java.lang.Throwable th2) {
                        com.tencent.smtt.utils.TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + android.util.Log.getStackTraceString(th2));
                    }
                    com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i8);
                    return;
                }
                try {
                    i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (i5 == i3) {
                        com.tencent.smtt.utils.f.a(com.tencent.smtt.sdk.m.a().q(context), false);
                        fileA = com.tencent.smtt.sdk.k.a(context).a();
                        if (fileA != null) {
                            com.tencent.smtt.utils.f.a(fileA, false);
                        }
                        str = "QbSdk";
                        sb = new java.lang.StringBuilder();
                        sb.append("QbSdk - preload_x5_check: tbs core ");
                        sb.append(i3);
                        sb.append(" is deleted!");
                    } else {
                        str = "QbSdk";
                        sb = new java.lang.StringBuilder();
                        sb.append("QbSdk - preload_x5_check -- reset exception core_ver:");
                        sb.append(i3);
                        sb.append("; value:");
                        sb.append(i5);
                    }
                    com.tencent.smtt.utils.TbsLog.e(str, sb.toString());
                    editorEdit.putInt("tbs_precheck_disable_version", i5);
                    editorEdit.commit();
                } catch (java.lang.Throwable th3) {
                    com.tencent.smtt.utils.TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + android.util.Log.getStackTraceString(th3));
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                i3 = -1;
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + android.util.Log.getStackTraceString(th));
                i4 = -1;
                if (i4 > 3) {
                    if (i2 > 0) {
                        i8 = -1;
                    } else {
                        i8 = -1;
                    }
                    i6 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i6 > 0) {
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i6 - 1).commit();
                    }
                    com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i8);
                    return;
                }
                i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                android.content.SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                if (i5 == i3) {
                    com.tencent.smtt.utils.f.a(com.tencent.smtt.sdk.m.a().q(context), false);
                    fileA = com.tencent.smtt.sdk.k.a(context).a();
                    if (fileA != null) {
                        com.tencent.smtt.utils.f.a(fileA, false);
                    }
                    str = "QbSdk";
                    sb = new java.lang.StringBuilder();
                    sb.append("QbSdk - preload_x5_check: tbs core ");
                    sb.append(i3);
                    sb.append(" is deleted!");
                } else {
                    str = "QbSdk";
                    sb = new java.lang.StringBuilder();
                    sb.append("QbSdk - preload_x5_check -- reset exception core_ver:");
                    sb.append(i3);
                    sb.append("; value:");
                    sb.append(i5);
                }
                com.tencent.smtt.utils.TbsLog.e(str, sb.toString());
                editorEdit2.putInt("tbs_precheck_disable_version", i5);
                editorEdit2.commit();
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            i2 = -1;
        }
    }

    public static boolean deleteMiniQBShortCut(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.sdk.u uVarA;
        return (context == null || com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) || (uVarA = com.tencent.smtt.sdk.u.a()) == null || !uVarA.b() || uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.String.class}, context, str, str2) == null) ? false : true;
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static void fileInfoDetect(android.content.Context context, java.lang.String str, android.webkit.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            return;
        }
        try {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void forceSysWebView() {
        b = true;
        u = "SysWebViewForcedByOuter: " + android.util.Log.getStackTraceString(new java.lang.Throwable());
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(android.content.Context context) {
        if (context != null) {
            return com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
        }
        return 0L;
    }

    public static java.lang.String getCurrentProcessName(android.content.Context context) {
        try {
            int iMyPid = android.os.Process.myPid();
            java.lang.String str = "";
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String[] getDexLoaderFileList(android.content.Context context, android.content.Context context2, java.lang.String str) {
        java.lang.Object obj;
        java.lang.String[] strArr = t;
        if (!(strArr instanceof java.lang.String[])) {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(r, "getJarFiles", new java.lang.Class[]{android.content.Context.class, android.content.Context.class, java.lang.String.class}, context, context2, str);
            if (!(objA instanceof java.lang.String[])) {
                obj = objA;
                obj = new java.lang.String[]{""};
            }
            obj = objA;
            return (java.lang.String[]) obj;
        }
        int length = strArr.length;
        java.lang.String[] strArr2 = new java.lang.String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = str + t[i2];
        }
        return strArr2;
    }

    public static boolean getDownloadWithoutWifi() {
        return F;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static boolean getJarFilesAndLibraryPath(android.content.Context context) {
        java.lang.Object obj = r;
        if (obj == null) {
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            return false;
        }
        android.os.Bundle bundle = (android.os.Bundle) com.tencent.smtt.utils.k.a(obj, "canLoadX5CoreAndNotLoadSo", new java.lang.Class[]{java.lang.Integer.TYPE}, 43903);
        if (bundle != null) {
            t = bundle.getStringArray("tbs_jarfiles");
            d = bundle.getString("tbs_librarypath");
            return true;
        }
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + com.tencent.smtt.sdk.m.a().a(true, context));
        return false;
    }

    public static java.lang.String getMiniQBVersion(android.content.Context context) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        if (uVarA == null || !uVarA.b()) {
            return null;
        }
        return uVarA.c().f();
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    public static java.lang.String getQQBuildNumber() {
        return A;
    }

    public static java.util.Map getSettings() {
        return n;
    }

    public static boolean getTBSInstalling() {
        return G;
    }

    public static java.lang.String getTID() {
        return z;
    }

    public static java.io.File getTbsFolderDir(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (com.tencent.smtt.utils.b.c()) {
                return context.getDir("tbs_64", 0);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return context.getDir("tbs", 0);
    }

    public static java.lang.String getTbsResourcesPath(android.content.Context context) {
        return com.tencent.smtt.sdk.TbsShareManager.g(context);
    }

    public static int getTbsSdkVersion() {
        return 43903;
    }

    public static int getTbsVersion(android.content.Context context) {
        return com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) ? com.tencent.smtt.sdk.TbsShareManager.a(context, false) : com.tencent.smtt.sdk.m.a().i(context);
    }

    public static int getTbsVersionForCrash(android.content.Context context) {
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            return com.tencent.smtt.sdk.TbsShareManager.a(context, false);
        }
        int iJ = com.tencent.smtt.sdk.m.a().j(context);
        if (iJ == 0 && com.tencent.smtt.sdk.k.a(context).c() == 3) {
            reset(context);
        }
        return iJ;
    }

    public static int getTmpDirTbsVersion(android.content.Context context) {
        if (com.tencent.smtt.sdk.k.a(context).c() == 2) {
            return com.tencent.smtt.sdk.m.a().e(context, 0);
        }
        if (com.tencent.smtt.sdk.k.a(context).b("copy_status") == 1) {
            return com.tencent.smtt.sdk.m.a().e(context, 1);
        }
        return 0;
    }

    public static void initBuglyAsync(boolean z2) {
        i = z2;
    }

    public static void initForinitAndNotLoadSo(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        if (q == null) {
            java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
            if (fileQ == null) {
                str = "QbSdk";
                str2 = "QbSdk initForinitAndNotLoadSo optDir == null";
            } else {
                java.io.File file = new java.io.File(fileQ, "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    java.lang.String absolutePath = fileQ.getAbsolutePath();
                    com.tencent.smtt.sdk.u.a().b(context);
                    com.tencent.smtt.utils.m.a(context);
                    q = new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    return;
                }
                str = "QbSdk";
                str2 = "QbSdk initForinitAndNotLoadSo dexFile.exists()=false";
            }
            android.util.Log.e(str, str2);
        }
    }

    public static void initTbsSettings(java.util.Map map) {
        java.util.Map map2 = n;
        if (map2 == null) {
            n = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void initX5Environment(final android.content.Context context, final com.tencent.smtt.sdk.QbSdk.PreInitCallback preInitCallback) {
        if (context == null) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        b(context);
        E = new com.tencent.smtt.sdk.TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i2) {
                com.tencent.smtt.sdk.QbSdk.preInit(context, preInitCallback);
            }
        };
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            com.tencent.smtt.sdk.m.a().b(context, com.tencent.smtt.sdk.d.f919a == 0);
        }
        com.tencent.smtt.sdk.TbsDownloader.needDownload(context, false, false, true, new com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.6
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z2, int i2) {
                if (com.tencent.smtt.sdk.TbsShareManager.findCoreForThirdPartyApp(context) == 0 && !com.tencent.smtt.sdk.TbsShareManager.getCoreDisabled()) {
                    com.tencent.smtt.sdk.TbsShareManager.forceToLoadX5ForThirdApp(context, false);
                }
                if (com.tencent.smtt.sdk.QbSdk.i && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                    com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                }
                com.tencent.smtt.sdk.QbSdk.preInit(context, preInitCallback);
            }
        });
    }

    public static boolean installLocalQbApk(android.content.Context context, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        com.tencent.smtt.sdk.d dVarA = com.tencent.smtt.sdk.d.a(true);
        dVarA.a(context, false, false);
        if (dVarA == null || !dVarA.b()) {
            return false;
        }
        return dVarA.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(com.tencent.smtt.sdk.WebView webView, android.content.Intent intent, java.lang.String str, java.lang.String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            android.content.Context context = webView.getContext();
            int iIndexOf = str.indexOf("url=");
            str = iIndexOf > 0 ? str.substring(iIndexOf + 4) : null;
            java.util.HashMap map = new java.util.HashMap();
            java.lang.String str3 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            map.put(LOGIN_TYPE_KEY_PARTNER_ID, str3);
            map.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(str) ? "qb://navicard/addCard?cardId=168&cardName=168" : str, map, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
                if (uVarA != null && uVarA.b() && uVarA.c().a(context, str, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(str);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.sdk.u uVarA;
        java.lang.Object objInvokeStaticMethod;
        if (context == null || com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) || (uVarA = com.tencent.smtt.sdk.u.a()) == null || !uVarA.b() || (objInvokeStaticMethod = uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new java.lang.Class[]{android.content.Context.class, java.lang.String.class}, context, str)) == null) {
            return false;
        }
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        if (objInvokeStaticMethod instanceof java.lang.Boolean) {
            bool = (java.lang.Boolean) objInvokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return w;
    }

    public static boolean isSuportOpenFile(java.lang.String str, int i2) {
        java.util.List listAsList;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String[] strArr = {"rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", com.alibaba.idst.util.SpeechSynthesizer.FORMAT_MP3, "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        java.lang.String[] strArr2 = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        if (i2 == 1) {
            listAsList = java.util.Arrays.asList(strArr2);
        } else {
            if (i2 != 2) {
                return false;
            }
            listAsList = java.util.Arrays.asList(strArr);
        }
        return listAsList.contains(str.toLowerCase());
    }

    public static boolean isTbsCoreInited() {
        com.tencent.smtt.sdk.d dVarA = com.tencent.smtt.sdk.d.a(false);
        return dVarA != null && dVarA.g();
    }

    public static boolean isX5DisabledSync(android.content.Context context) throws java.lang.Throwable {
        if (com.tencent.smtt.sdk.k.a(context).c() == 2) {
            return false;
        }
        if (!c(context)) {
            return true;
        }
        int i2 = com.tencent.smtt.sdk.m.a().i(context);
        java.lang.Object obj = r;
        java.lang.Class cls = java.lang.Integer.TYPE;
        java.lang.Object objA = com.tencent.smtt.utils.k.a(obj, "isX5DisabledSync", new java.lang.Class[]{cls, cls}, java.lang.Integer.valueOf(i2), 43903);
        if (objA != null) {
            return ((java.lang.Boolean) objA).booleanValue();
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loadTBSSDKExtension(android.content.Context context, java.lang.String str) throws java.lang.NoSuchMethodException {
        java.lang.reflect.Constructor constructor;
        boolean z2;
        java.lang.Object[] objArr;
        java.lang.reflect.Constructor constructor2;
        java.lang.Object[] objArr2;
        java.lang.Object objNewInstance;
        if (r != null) {
            return;
        }
        synchronized (com.tencent.smtt.sdk.QbSdk.class) {
            if (r != null) {
                return;
            }
            if (q == null) {
                com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
            }
            try {
                constructor = q.getConstructor(android.content.Context.class, android.content.Context.class, java.lang.String.class, java.lang.String.class, java.lang.String.class);
                z2 = true;
            } catch (java.lang.Throwable unused) {
                constructor = null;
                z2 = false;
            }
            try {
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                    android.content.Context contextE = com.tencent.smtt.sdk.TbsShareManager.e(context);
                    if (contextE == null && com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() == null) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                        return;
                    }
                    if (z2) {
                        objArr = new java.lang.Object[]{context, contextE, com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined(), str, null};
                        objNewInstance = constructor.newInstance(objArr);
                    } else if (contextE == null) {
                        objNewInstance = q.getConstructor(android.content.Context.class, android.content.Context.class, java.lang.String.class).newInstance(context, contextE, com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined(), str, null);
                    } else {
                        constructor2 = q.getConstructor(android.content.Context.class, android.content.Context.class);
                        objArr2 = new java.lang.Object[]{context, contextE};
                        objNewInstance = constructor2.newInstance(objArr2);
                    }
                } else if (z2) {
                    java.lang.String str2 = (!"com.tencent.mm".equals(getCurrentProcessName(context)) || com.tencent.smtt.sdk.WebView.mWebViewCreated) ? null : "notLoadSo";
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    objArr = new java.lang.Object[]{context, context, null, str, str2};
                    objNewInstance = constructor.newInstance(objArr);
                } else {
                    constructor2 = q.getConstructor(android.content.Context.class, android.content.Context.class);
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    objArr2 = new java.lang.Object[]{context, context};
                    objNewInstance = constructor2.newInstance(objArr2);
                }
                r = objNewInstance;
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "throwable" + android.util.Log.getStackTraceString(th));
            }
        }
    }

    public static void openBrowserList(android.content.Context context, java.lang.String str, android.os.Bundle bundle, final com.tencent.smtt.sdk.ValueCallback valueCallback) {
        java.lang.String str2;
        if (context == null) {
            return;
        }
        java.lang.String string = bundle != null ? bundle.getString(com.dodjoy.dodlib.DodLibMeta.ChannelId) : "";
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(android.net.Uri.parse(str));
        java.lang.String strC = com.tencent.smtt.sdk.b.a.d.c(str);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, strC, string);
        java.lang.String strA = cVar.a();
        if (strA != null && !android.text.TextUtils.isEmpty(strA)) {
            if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(strA)) {
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
            }
            intent.setPackage(strA);
            intent.putExtra("big_brother_source_key", string);
            context.startActivity(intent);
            if (valueCallback == null) {
                return;
            }
            str2 = "default browser:" + strA;
        } else if (!isDefaultDialog) {
            cVar.show();
            cVar.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.tencent.smtt.sdk.ValueCallback valueCallback2 = valueCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                    }
                }
            });
            return;
        } else {
            new android.app.AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                }
            }).show();
            if (valueCallback == null) {
                return;
            } else {
                str2 = "can not open";
            }
        }
        valueCallback.onReceiveValue(str2);
    }

    public static void openBrowserList(android.content.Context context, java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static int openFileReader(android.content.Context context, java.lang.String str, java.util.HashMap map, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        java.lang.String str2;
        java.lang.String str3;
        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_COUNTS);
        if (!checkContentProviderPrivilage(context)) {
            return -5;
        }
        if (str == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("filepath error");
            }
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL);
            android.util.Log.e("QbSdk", "open openFileReader filepath error ret -1");
            return -1;
        }
        java.lang.String strSubstring = str.substring(str.lastIndexOf(".") + 1, str.length());
        if (strSubstring != null) {
            strSubstring = strSubstring.toLowerCase();
        }
        java.lang.String str4 = strSubstring;
        if ("apk".equalsIgnoreCase(str4)) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            android.net.Uri uriA = com.tencent.smtt.utils.FileProvider.a(context, str);
            if (uriA == null) {
                valueCallback.onReceiveValue("uri failed");
                return -6;
            }
            intent.setDataAndType(uriA, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
            context.startActivity(intent);
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE);
            android.util.Log.e("QbSdk", "open openFileReader ret = 4");
            return 4;
        }
        if (!com.tencent.smtt.sdk.a.c.b(context)) {
            str2 = "QbSdk";
            str3 = "openFileReader QQ browser not installed";
        } else {
            if (!a(context, str, str4)) {
                android.util.Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
                openFileReaderListWithQBDownload(context, str, valueCallback);
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                return 3;
            }
            if (startQBForDoc(context, str, 4, 0, str4, a(context, map))) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("open QB");
                }
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                android.util.Log.e("QbSdk", "open openFileReader open QB ret = 1");
                return 1;
            }
            str2 = "QbSdk";
            str3 = "openFileReader startQBForDoc return false";
        }
        android.util.Log.d(str2, str3);
        if (map == null) {
            map = new java.util.HashMap();
        }
        map.put("local", com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
        com.tencent.smtt.utils.TbsLog.setWriteLogJIT(true);
        int iStartMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, map, valueCallback);
        if (iStartMiniQBToLoadUrl == 0) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            return 2;
        }
        openFileReaderListWithQBDownload(context, str, valueCallback);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setLoadErrorCode(511, "" + iStartMiniQBToLoadUrl);
        return 3;
    }

    public static void openFileReaderListWithQBDownload(android.content.Context context, java.lang.String str, android.os.Bundle bundle, final com.tencent.smtt.sdk.ValueCallback valueCallback) {
        java.lang.String str2;
        if (context == null || context.getApplicationInfo().packageName.equals(com.tencent.connect.common.Constants.PACKAGE_QIM) || context.getApplicationInfo().packageName.equals(com.tencent.connect.common.Constants.PACKAGE_TIM) || context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            return;
        }
        java.lang.String string = bundle != null ? bundle.getString(com.dodjoy.dodlib.DodLibMeta.ChannelId) : "";
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        java.lang.String strC = com.tencent.smtt.sdk.b.a.d.c(str);
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        android.net.Uri uriA = com.tencent.smtt.utils.FileProvider.a(context, str);
        if (uriA == null) {
            valueCallback.onReceiveValue("uri failed");
            return;
        }
        intent.setDataAndType(uriA, strC);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, strC, string);
        java.lang.String strA = cVar.a();
        if (strA != null && !android.text.TextUtils.isEmpty(strA) && checkApkExist(context, strA)) {
            if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(strA)) {
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
            }
            if (!android.text.TextUtils.isEmpty(string)) {
                intent.putExtra("big_brother_source_key", string);
            }
            intent.setPackage(strA);
            context.startActivity(intent);
            if (valueCallback == null) {
                return;
            }
            str2 = "default browser:" + strA;
        } else {
            if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && isDefaultDialog) {
                new android.app.AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                    }
                }).show();
                return;
            }
            if (!isDefaultDialog) {
                try {
                    cVar.show();
                    cVar.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.9
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(android.content.DialogInterface dialogInterface) {
                            com.tencent.smtt.sdk.ValueCallback valueCallback2 = valueCallback;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                            }
                        }
                    });
                    return;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    str2 = "TbsReaderDialogClosed";
                }
            } else if (valueCallback == null) {
                return;
            } else {
                str2 = "can not open";
            }
        }
        valueCallback.onReceiveValue(str2);
    }

    public static void openFileReaderListWithQBDownload(android.content.Context context, java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static synchronized void preInit(android.content.Context context) {
        preInit(context, null);
    }

    public static synchronized void preInit(final android.content.Context context, final com.tencent.smtt.sdk.QbSdk.PreInitCallback preInitCallback) {
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "preInit -- stack: " + android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
        l = f818a;
        if (!s) {
            final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.3
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.tencent.smtt.sdk.QbSdk.PreInitCallback preInitCallback2;
                    com.tencent.smtt.sdk.v vVarC;
                    com.tencent.smtt.sdk.QbSdk.PreInitCallback preInitCallback3;
                    int i2 = message.what;
                    boolean z2 = true;
                    if (i2 == 1) {
                        boolean unused = com.tencent.smtt.sdk.QbSdk.B = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().canUseFunction(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                        if (com.tencent.smtt.sdk.QbSdk.j && (vVarC = com.tencent.smtt.sdk.u.a().c()) != null) {
                            vVarC.a(context);
                        }
                        preInitCallback2 = preInitCallback;
                        if (preInitCallback2 != null) {
                            preInitCallback2.onViewInitFinished(z2);
                        }
                    } else {
                        if (i2 != 2) {
                            if (i2 == 3 && (preInitCallback3 = preInitCallback) != null) {
                                preInitCallback3.onCoreInitFinished();
                                return;
                            }
                            return;
                        }
                        preInitCallback2 = preInitCallback;
                        if (preInitCallback2 != null) {
                            z2 = false;
                            preInitCallback2.onViewInitFinished(z2);
                        }
                    }
                    com.tencent.smtt.utils.TbsLog.writeLogToDisk();
                }
            };
            java.lang.Thread thread = new java.lang.Thread() { // from class: com.tencent.smtt.sdk.QbSdk.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    int iA = com.tencent.smtt.sdk.m.a().a(true, context);
                    com.tencent.smtt.sdk.TbsDownloader.setAppContext(context);
                    com.tencent.smtt.utils.TbsLog.i("QbSdk", "QbSdk preinit ver is " + iA);
                    if (iA == 0) {
                        com.tencent.smtt.sdk.m.a().b(context, true);
                    }
                    com.tencent.smtt.utils.TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
                    com.tencent.smtt.sdk.d.a(true).a(context, false, false);
                    com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
                    uVarA.a(context);
                    boolean zB = uVarA.b();
                    handler.sendEmptyMessage(3);
                    if (zB) {
                        handler.sendEmptyMessage(1);
                    } else {
                        handler.sendEmptyMessage(2);
                    }
                }
            };
            thread.setName("tbs_preinit");
            thread.setPriority(10);
            thread.start();
            s = true;
        }
    }

    public static void reset(android.content.Context context) {
        reset(context, false);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    public static void reset(android.content.Context context, boolean z2) {
        boolean z3;
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            com.tencent.smtt.sdk.TbsDownloader.stopDownload();
            if (!z2 || com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                z3 = false;
            } else {
                int iH = com.tencent.smtt.sdk.m.a().h(context);
                int i2 = com.tencent.smtt.sdk.m.a().i(context);
                if (iH <= 43300 || iH == i2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            com.tencent.smtt.sdk.TbsDownloader.c(context);
            com.tencent.smtt.utils.f.a(getTbsFolderDir(context), false, "core_share_decouple");
            com.tencent.smtt.utils.TbsLog.i("QbSdk", "delete downloaded apk success", true);
            com.tencent.smtt.sdk.m.f935a.set(0);
            java.io.File file = new java.io.File(context.getFilesDir(), com.tencent.smtt.sdk.TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
            if (z3) {
                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(context), com.tencent.smtt.sdk.m.a().f(context, 0));
                com.tencent.smtt.sdk.m.a().b(context);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk reset exception:" + android.util.Log.getStackTraceString(th));
        }
    }

    public static void resetDecoupleCore(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().p(context));
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + android.util.Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(java.lang.String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            java.lang.String strSubstring = str.substring(3);
            z = "0000000000000000".substring(strSubstring.length()) + strSubstring;
        }
    }

    public static void setDisableUnpreinitBySwitch(boolean z2) {
        B = z2;
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z2) {
        mDisableUseHostBackupCore = z2;
        com.tencent.smtt.utils.TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDownloadWithoutWifi(boolean z2) {
        F = z2;
    }

    public static void setNeedInitX5FirstTime(boolean z2) {
        w = z2;
    }

    public static void setOnlyDownload(boolean z2) {
        k = z2;
    }

    public static void setQQBuildNumber(java.lang.String str) {
        A = str;
    }

    public static void setTBSInstallingStatus(boolean z2) {
        G = z2;
    }

    public static void setTbsListener(com.tencent.smtt.sdk.TbsListener tbsListener) {
        D = tbsListener;
    }

    public static void setTbsLogClient(com.tencent.smtt.utils.TbsLogClient tbsLogClient) {
        com.tencent.smtt.utils.TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUploadCode(android.content.Context context, int i2) {
        com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload;
        java.util.Map map;
        java.lang.Integer numValueOf;
        java.lang.String str;
        if (i2 >= 130 && i2 <= 139) {
            tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f857a;
            numValueOf = java.lang.Integer.valueOf(i2);
            str = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
        } else {
            if (i2 < 150 || i2 > 159) {
                return;
            }
            tbsDownloadUpload = com.tencent.smtt.sdk.TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f857a;
            numValueOf = java.lang.Integer.valueOf(i2);
            str = com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
        }
        map.put(str, numValueOf);
        tbsDownloadUpload.commit();
    }

    public static int startMiniQBToLoadUrl(android.content.Context context, java.lang.String str, java.util.HashMap map, android.webkit.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        if (!uVarA.b()) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 502);
            android.util.Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
            return com.tencent.safecloud.device.openlib.DeviceConfig.ERR_ILLEGAL_ARG;
        }
        if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return com.tencent.safecloud.device.openlib.DeviceConfig.ERR_AUTHENTICATION;
        }
        int iA = uVarA.c().a(context, str, map, null, valueCallback);
        if (iA == 0) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 503);
        } else {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setLoadErrorCode(504, "" + iA);
        }
        android.util.Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + iA);
        return iA;
    }

    public static boolean startQBForDoc(android.content.Context context, java.lang.String str, int i2, int i3, java.lang.String str2, android.os.Bundle bundle) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        map.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, java.lang.Integer.toString(i2));
        return com.tencent.smtt.sdk.a.c.a(context, str, i3, str2, map, bundle);
    }

    public static boolean startQBForVideo(android.content.Context context, java.lang.String str, int i2) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        map.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, java.lang.Integer.toString(i2));
        return com.tencent.smtt.sdk.a.c.a(context, str, map);
    }

    public static boolean startQBToLoadurl(android.content.Context context, java.lang.String str, int i2, com.tencent.smtt.sdk.WebView webView) {
        com.tencent.smtt.sdk.u uVarA;
        java.lang.Object objInvokeStaticMethod;
        com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase;
        java.util.HashMap map = new java.util.HashMap();
        map.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        map.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, java.lang.Integer.toString(i2));
        if (webView == null) {
            try {
                java.lang.String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if ((str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") && (uVarA = com.tencent.smtt.sdk.u.a()) != null && uVarA.b() && (objInvokeStaticMethod = uVarA.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new java.lang.Class[0], new java.lang.Object[0])) != null && (iX5WebViewBase = (com.tencent.smtt.export.external.interfaces.IX5WebViewBase) objInvokeStaticMethod) != null) {
                    webView = (com.tencent.smtt.sdk.WebView) iX5WebViewBase.getView().getParent();
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, map, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQBWithBrowserlist(android.content.Context context, java.lang.String str, int i2) {
        boolean zStartQBToLoadurl = startQBToLoadurl(context, str, i2, null);
        if (!zStartQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return zStartQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(android.content.Context context, java.lang.String str, java.util.HashMap map, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        if (context == null) {
            return false;
        }
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        if (map != null && "5".equals(map.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && uVarA.b()) {
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, map, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
            return uVarA.b() && (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && uVarA.c().a(context, str, map, null, valueCallback) == 0;
        }
        return true;
    }

    public static void unForceSysWebView() {
        b = false;
        com.tencent.smtt.utils.TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static synchronized boolean unPreInit(android.content.Context context) {
        return true;
    }

    public static boolean useSoftWare() {
        java.lang.Object obj = r;
        if (obj == null) {
            return false;
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(obj, "useSoftWare", new java.lang.Class[0], new java.lang.Object[0]);
        if (objA == null) {
            objA = com.tencent.smtt.utils.k.a(r, "useSoftWare", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(com.tencent.smtt.sdk.a.a()));
        }
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }
}
