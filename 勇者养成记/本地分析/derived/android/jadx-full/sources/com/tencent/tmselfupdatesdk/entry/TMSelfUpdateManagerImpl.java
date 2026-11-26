package com.tencent.tmselfupdatesdk.entry;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMSelfUpdateManagerImpl {
    public static final int SERVER_MODE_DEBUG = 1;
    public static final int SERVER_MODE_RELEASE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl f1162a;
    protected android.content.Context b = null;
    protected java.lang.String c = null;
    protected byte d = 0;
    protected java.lang.String e = "";
    protected java.lang.String f = "";
    protected java.lang.String g = "";
    private boolean h = false;

    private TMSelfUpdateManagerImpl() {
    }

    private int a(android.content.Context context, java.lang.String str, com.tencent.tmselfupdatesdk.ITMSelfUpdateListener iTMSelfUpdateListener, com.tencent.tmselfupdatesdk.YYBDownloadListener yYBDownloadListener, android.os.Bundle bundle, int i) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "enter");
        if (!(context instanceof android.app.Application)) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMSelfUpdateManagerImpl", "exception: you must input an application context!");
            throw new java.lang.Exception("you must input an application context!");
        }
        this.b = context.getApplicationContext();
        com.tencent.tmassistantbase.util.k.a().a(this.b);
        a(bundle);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "applicationContext: " + context + "; yybchannelId: " + str + "; hostPackageName: " + this.c);
        a(context);
        com.tencent.tmassistantbase.c.a.a.a().b();
        com.tencent.tmselfupdatesdk.a.a().a(this.b, this.e, this.f);
        com.tencent.tmselfupdatesdk.a.a().a(iTMSelfUpdateListener);
        int iA = com.tencent.tmselfupdatesdk.g.a().a(this.b, this.f, this.e, str);
        com.tencent.tmselfupdatesdk.g.a().a(yYBDownloadListener);
        com.tencent.tmselfupdatesdk.g.a().a(iTMSelfUpdateListener);
        switchServerMode(this.b, i);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "exit result = " + iA);
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_init_result", java.lang.String.valueOf(iA));
        return iA;
    }

    private void a(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(this.c, 128);
        android.os.Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            bundle.getString("[REDACTED]");
            java.lang.String string = applicationInfo.metaData.getString("YYB_CHANNEL");
            if (string == null) {
                string = java.lang.String.valueOf(applicationInfo.metaData.getInt("YYB_CHANNEL"));
            }
            if (android.text.TextUtils.isEmpty(string)) {
                this.e = null;
            } else {
                this.e = string;
            }
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "mHostChannelId: " + this.e);
        }
    }

    private void a(android.content.Context context, com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) {
        int iCheckQQDownloaderInstalled;
        java.lang.String str;
        java.lang.String str2;
        try {
            iCheckQQDownloaderInstalled = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            iCheckQQDownloaderInstalled = 1;
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdate_TMSelfUpdateManagerImpl", "jxlhPush YYBinstalledStatus (0为已安装/1为未安装) =" + iCheckQQDownloaderInstalled);
        if (iCheckQQDownloaderInstalled == 0) {
            str = "TMSelfUpdate_TMSelfUpdateManagerImpl";
            str2 = "jxlhPush YYBinstalledStatus 应用宝已安装 and getPushConfig begin";
        } else if (iCheckQQDownloaderInstalled == 1) {
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdate_TMSelfUpdateManagerImpl", "jxlhPush YYBinstalledStatus 应用宝未安装");
            return;
        } else {
            if (iCheckQQDownloaderInstalled != 2) {
                return;
            }
            str = "TMSelfUpdate_TMSelfUpdateManagerImpl";
            str2 = "jxlhPush YYBinstalledStatus 应用宝已安装";
        }
        com.tencent.tmassistantbase.util.x.a(str, str2);
        a(pushGetListener, pushTouchListener);
        c();
    }

    private void a(android.os.Bundle bundle) {
        java.lang.StringBuilder sb;
        java.lang.String string;
        java.lang.String packageName = this.b.getPackageName();
        this.c = packageName;
        java.lang.String strReplace = packageName.toUpperCase().replace(".", "_");
        if (bundle != null) {
            java.lang.String string2 = bundle.getString(com.tencent.tmselfupdatesdk.TMSelfUpdateConst.BUNDLE_KEY_SCENE);
            if (android.text.TextUtils.isEmpty(string2)) {
                sb = new java.lang.StringBuilder();
            } else {
                string = "ANDROIDYYB.UPDATE." + string2.toUpperCase();
            }
            this.f = string;
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "this.mScene: " + this.f);
            com.tencent.tmassistantbase.util.l.a().post(new com.tencent.tmselfupdatesdk.entry.a(this));
        }
        sb = new java.lang.StringBuilder();
        sb.append("ANDROIDYYB.UPDATE.");
        sb.append(strReplace);
        string = sb.toString();
        this.f = string;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "this.mScene: " + this.f);
        com.tencent.tmassistantbase.util.l.a().post(new com.tencent.tmselfupdatesdk.entry.a(this));
    }

    private void a(com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("com.tencent.tmassistantsdk.notification.PushManager").getMethod("setGetPushConfigListener", com.tencent.tmselfupdatesdk.PushGetListener.class, com.tencent.tmselfupdatesdk.PushTouchListener.class);
            if (method != null) {
                method.invoke(null, pushGetListener, pushTouchListener);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean a() {
        int iCheckQQDownloaderInstalled;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "canJumpToYYB enter");
        int iO = com.tencent.tmassistantbase.util.k.a().o();
        java.lang.String str = android.os.Build.MODEL;
        boolean zContains = com.tencent.tmassistantbase.common.e.a().e().contains(str);
        boolean z = true;
        try {
            iCheckQQDownloaderInstalled = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            iCheckQQDownloaderInstalled = 1;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", ">>canJumpToYYB qqDownloaderVersionCode = " + iO + " model = " + str + " isInBlackList = " + zContains);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "canJumpToYYB exit");
        if (iCheckQQDownloaderInstalled != 1 && iO < 7042130 && zContains) {
            z = false;
        }
        if (!z) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_cannot_jump_yyb_update");
        }
        return z;
    }

    private void b() {
        com.tencent.tmselfupdatesdk.a.a().e();
        com.tencent.tmselfupdatesdk.g.a().g();
    }

    private void c() {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("com.tencent.tmassistantsdk.notification.PushManager").getMethod("sendRequest", new java.lang.Class[0]);
            if (method != null) {
                method.invoke(null, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static synchronized com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl getInstance() {
        if (f1162a == null) {
            f1162a = new com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl();
        }
        return f1162a;
    }

    public static int getSDKBuildNo() {
        try {
            return java.lang.Integer.parseInt("33");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 1000;
        }
    }

    public static java.lang.String getSDKName() {
        return "selfUpdate";
    }

    public static int getSDKVersionCode() {
        return 3010;
    }

    public static java.lang.String getSDKVersionName() {
        return "3.0.1";
    }

    public void cancelYYBDownload() {
        com.tencent.tmselfupdatesdk.g.a().c();
    }

    public void checkSelfUpdate() {
        com.tencent.tmselfupdatesdk.a.a().b();
    }

    public void checkYYBDownloaded() {
        com.tencent.tmselfupdatesdk.g.a().i();
    }

    public int checkYYBInstallState() {
        return com.tencent.tmselfupdatesdk.g.a().f();
    }

    public void destroy() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "enter");
        b();
        com.tencent.tmdownloader.TMAssistantDownloadManager.closeAllService(this.b);
        this.h = false;
        com.tencent.tmselfupdatesdk.g.a().b();
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().destory();
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "exit");
    }

    public int init(android.content.Context context, java.lang.String str, com.tencent.tmselfupdatesdk.ITMSelfUpdateListener iTMSelfUpdateListener, com.tencent.tmselfupdatesdk.YYBDownloadListener yYBDownloadListener, android.os.Bundle bundle) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "init enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "init applicationContext: " + context + "; yybchannelId: " + str + "; ITMSelfUpdateListener: " + iTMSelfUpdateListener + "; YYBDownloadListener: " + yYBDownloadListener);
        int iA = a(context, str, iTMSelfUpdateListener, yYBDownloadListener, bundle, 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("init exit ret = ");
        sb.append(iA);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", sb.toString());
        return iA;
    }

    public int initDebug(android.content.Context context, java.lang.String str, com.tencent.tmselfupdatesdk.ITMSelfUpdateListener iTMSelfUpdateListener, com.tencent.tmselfupdatesdk.YYBDownloadListener yYBDownloadListener, android.os.Bundle bundle) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "initDebug enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "applicationContext: " + context + "; yybchannelId: " + str + "; ITMSelfUpdateListener: " + iTMSelfUpdateListener + "; YYBDownloadListener: " + yYBDownloadListener);
        int iA = a(context, str, iTMSelfUpdateListener, yYBDownloadListener, bundle, 1);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "initDebug exit");
        return iA;
    }

    public void initPush(android.content.Context context, com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "enter");
        if (!(context instanceof android.app.Application)) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMSelfUpdateManagerImpl", "exception: you must input an application context!");
            throw new java.lang.Exception("you must input an application context!");
        }
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        switchServerMode(applicationContext, 0);
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().initTMAssistantCallYYBApi(this.b);
        a(this.b, pushGetListener, pushTouchListener);
    }

    public void initPushDebug(android.content.Context context, com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "enter");
        if (!(context instanceof android.app.Application)) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMSelfUpdateManagerImpl", "exception: you must input an application context!");
            throw new java.lang.Exception("you must input an application context!");
        }
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        switchServerMode(applicationContext, 1);
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().initTMAssistantCallYYBApi(this.b);
        a(this.b, pushGetListener, pushTouchListener);
    }

    public void onActivityResume() throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "onActivityResume enter");
        if (this.b == null) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMSelfUpdateManagerImpl", "exception: you must input an application context!");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct();
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "yyb isFromStartUpdate :" + this.h);
        if (this.h) {
            try {
                int iCheckQQDownloaderInstalled = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled();
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "yyb startSaveUpdateToWhere  flag: " + iCheckQQDownloaderInstalled);
                if (iCheckQQDownloaderInstalled == 0) {
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "yyb startSaveUpdateToWhere!!");
                    tMAssistantCallYYBParamStruct.SNGAppId = "";
                    tMAssistantCallYYBParamStruct.taskPackageName = this.c;
                    tMAssistantCallYYBParamStruct.channelId = this.e;
                    tMAssistantCallYYBParamStruct.via = this.f;
                    com.tencent.tmselfupdatesdk.g.a().a(this.b, tMAssistantCallYYBParamStruct, iCheckQQDownloaderInstalled);
                }
                this.h = false;
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "onActivityResume exit");
            } catch (java.lang.Throwable th) {
                try {
                    com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMSelfUpdateManagerImpl", "exception:", th);
                    th.printStackTrace();
                    throw th;
                } catch (java.lang.Throwable th2) {
                    this.h = false;
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "onActivityResume exit");
                    throw th2;
                }
            }
        }
    }

    public void startPreDownloadYYB(boolean z) {
        com.tencent.tmselfupdatesdk.g.a().a(z);
    }

    public int startSelfUpdate(boolean z) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "startSelfUpdate enter");
        if (!z || !a()) {
            com.tencent.tmselfupdatesdk.a.a().c();
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "startSelfUpdate exit");
            return 0;
        }
        this.d = (byte) 2;
        int iE = com.tencent.tmselfupdatesdk.g.a().e();
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "returnValue: " + iE);
        return iE;
    }

    public void startYYBInstallIfDownloaded() {
        com.tencent.tmselfupdatesdk.g.a().d();
    }

    public void switchLog(boolean z) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "switchLog enable=" + z);
        com.tencent.tmassistantbase.common.a.a().a(z);
    }

    public void switchServerMode(android.content.Context context, int i) {
        com.tencent.tmassistantbase.util.k.a().a(context);
        com.tencent.tmassistantbase.common.a.a().a(i);
    }
}
