package com.tencent.ysdk.shell.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKSystem {
    private static final java.lang.String CLOUD_GAME_SCHEME_PREFIX = "tencentysdk";
    private static final boolean IS_TEST_VERSION = false;
    public static final java.lang.String KEY_LOG_LEVEL = "YSDK_LOG_LEVEL";
    public static final java.lang.String KEY_QQ_APPID = "QQ_APP_ID";
    private static final java.lang.String LOG_INIT_TAG = "YSDK_INIT";
    private static final java.lang.String LOG_TAG = "YSDK";
    private static final int STAT_INIT_TIME_ALL = 7;
    private static final int STAT_INIT_TIME_CLOUD = 6;
    private static final int STAT_INIT_TIME_CONFIG = 2;
    private static final int STAT_INIT_TIME_HOT = 1;
    private static final int STAT_INIT_TIME_MODULE = 5;
    private static final int STAT_INIT_TIME_PERMISSION = 4;
    private static final int STAT_INIT_TIME_SERVER_GAME = 3;
    public static final java.lang.String YSDK_CONFIG_FILE = "ysdkconf.ini";
    private static final java.lang.String YSDK_PATCH_SO = "YSDK";
    public static final java.lang.String YSDK_TAG = "Tag_YSDK_1.3.0.11_100";
    public static final java.lang.String YSDK_VERSION = "1.8.1";
    private static volatile com.tencent.ysdk.shell.framework.YSDKSystem instance;
    private static long sInitStartTime;
    private boolean isCheckFreeLoginActivityConfig;
    private java.lang.String mAppPkgName;
    private java.lang.String mHttpDomain;
    private java.lang.String mMainActivityClzName;
    private boolean preInit;
    private boolean isX5Inited = false;
    private boolean mInited = false;
    private boolean mIsDev = false;
    private boolean mIsDdebug = false;
    private boolean mIsHostDebugMode = false;
    private android.app.Activity mActivity = null;
    private android.content.Context mApplicationContext = null;
    private java.lang.String mQQAppId = "";
    private java.lang.String mWXAppId = "";
    private java.lang.String mOfferId = "";
    private int mAntiAddictionSwitch = -1;
    private long mPauseTime = 0;
    private boolean mIsSensitivePermissionOpen = true;
    private boolean autoLoginByYSDK = true;
    private com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo mPluginInfo = null;

    private YSDKSystem() {
    }

    public static com.tencent.ysdk.shell.framework.YSDKSystem getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.YSDKSystem.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.YSDKSystem();
                }
            }
        }
        return instance;
    }

    private void initLogger(android.content.Context context) {
        com.tencent.ysdk.shell.libware.file.Logger.init(context, readConfigFromFile("ysdkconf.ini", "QQ_APP_ID", ""), readConfigFromFile("ysdkconf.ini", "YSDK_LOG_LEVEL", java.lang.String.valueOf(1)));
    }

    private synchronized void initSdk(android.app.Activity activity) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "initSDK");
        final java.util.HashMap map = new java.util.HashMap();
        sInitStartTime = java.lang.System.currentTimeMillis();
        long j = sInitStartTime;
        initLogger(this.mApplicationContext);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - j;
        map.put("init_time_1", java.lang.String.valueOf(j2));
        printInitLog("STAT_INIT_TIME_HOT: " + java.lang.String.valueOf(j2));
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        long j3 = jCurrentTimeMillis2 - jCurrentTimeMillis;
        map.put("init_time_2", java.lang.String.valueOf(j3));
        printInitLog("STAT_INIT_TIME_CONFIG: " + j3);
        com.tencent.ysdk.shell.framework.YSDKGame.getInstance().init(activity);
        long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
        long j4 = jCurrentTimeMillis3 - jCurrentTimeMillis2;
        map.put("init_time_3", java.lang.String.valueOf(j4));
        printInitLog("STAT_INIT_TIME_SERVER_GAME: " + j4);
        long jCurrentTimeMillis4 = java.lang.System.currentTimeMillis();
        long j5 = jCurrentTimeMillis4 - jCurrentTimeMillis3;
        map.put("init_time_4", java.lang.String.valueOf(j5));
        printInitLog("STAT_INIT_TIME_PERMISSION: " + j5);
        com.tencent.ysdk.shell.module.ModuleManager.getInstance().init();
        long jCurrentTimeMillis5 = java.lang.System.currentTimeMillis();
        printInitLog("模块管理初始化: " + (jCurrentTimeMillis5 - jCurrentTimeMillis4));
        com.tencent.ysdk.shell.module.ModuleManager.getInstance().checkModuleConfig();
        long jCurrentTimeMillis6 = java.lang.System.currentTimeMillis();
        long j6 = jCurrentTimeMillis6 - jCurrentTimeMillis5;
        map.put("init_time_5", java.lang.String.valueOf(j6));
        printInitLog("各模块配置检查: " + j6);
        com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl.getInstance().pullCloudSettings(0);
        this.mInited = true;
        if (this.mIsSensitivePermissionOpen) {
            setSensitivePermissionStatus(true);
        }
        com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager.getInstance().report();
        long jCurrentTimeMillis7 = java.lang.System.currentTimeMillis();
        long j7 = jCurrentTimeMillis7 - jCurrentTimeMillis6;
        map.put("init_time_6", java.lang.String.valueOf(j7));
        printInitLog("STAT_INIT_TIME_CLOUD: " + j7);
        map.put("init_time_7", java.lang.String.valueOf(java.lang.System.currentTimeMillis() - sInitStartTime));
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKSystem.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
                com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_SDK_INIT, 0, loginRecord.msg, loginRecord.platform, loginRecord.open_id, map, com.tencent.ysdk.shell.framework.YSDKSystem.sInitStartTime, true);
            }
        });
        long jCurrentTimeMillis8 = java.lang.System.currentTimeMillis();
        printInitLog("data upload: " + (jCurrentTimeMillis8 - jCurrentTimeMillis7));
        com.tencent.ysdk.shell.libware.device.DeviceUtils.getOAID();
        long jCurrentTimeMillis9 = java.lang.System.currentTimeMillis();
        printInitLog("getOAID: " + (jCurrentTimeMillis9 - jCurrentTimeMillis8));
        com.tencent.ysdk.shell.module.ad.ADManager.getInstance().initAD();
        printInitLog("ADManager: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis9));
        reportHotfixEvent();
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKSystem.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, true);
                    com.tencent.smtt.sdk.QbSdk.initTbsSettings(map2);
                    com.tencent.smtt.sdk.QbSdk.initX5Environment(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), new com.tencent.smtt.sdk.QbSdk.PreInitCallback() { // from class: com.tencent.ysdk.shell.framework.YSDKSystem.2.1
                        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
                        public void onCoreInitFinished() {
                        }

                        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
                        public void onViewInitFinished(boolean z) {
                            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "TBS X% init end");
                            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.initPreLoadSW();
                        }
                    });
                    com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "TBS X5 init");
                } catch (java.lang.Exception unused) {
                    com.tencent.ysdk.shell.libware.file.Logger.d("TBS init err");
                }
            }
        });
        com.tencent.ysdk.shell.module.hades.HadesApi.startSCFPSDK();
    }

    private boolean isTestAndDebug() {
        java.lang.String domain = getDomain();
        return !android.text.TextUtils.isEmpty(domain) && domain.contains(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
    }

    private void printInitLog(java.lang.String str) {
        if (isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_INIT", str);
        }
    }

    private java.lang.String readConfigFromFile(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (getApplicationContext() == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK", "readConfigFromFile context is null");
            return str3;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                java.io.InputStream inputStreamOpen = getApplicationContext().getResources().getAssets().open(str);
                java.util.Properties properties = new java.util.Properties();
                properties.load(inputStreamOpen);
                java.lang.String property = properties.getProperty(str2, "");
                if (property != null && property.length() != 0) {
                    java.lang.String strTrim = property.trim();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return strTrim;
                }
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "no key: " + str2);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return "";
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return "";
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private void reportHotfixEvent() {
        java.lang.String strValueOf = java.lang.String.valueOf(com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginVersion());
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_PLUGIN", "reportHotfixEvent ver = " + strValueOf + " , ext = ext");
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLUGIN_VER, strValueOf);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLUGIN_EXT, "ext");
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PLUGIN_REPORT, 0, "report hotfix msg", map);
    }

    private void setTestAndDebug() {
        java.lang.String domain = getDomain();
        if (isTestAndDebug()) {
            com.tencent.ysdk.shell.framework.config.Config.printAllConfig();
            this.mIsDev = true;
            com.tencent.ysdk.shell.framework.verification.UserTips.showTestDomainInfo(domain);
            if (this.mIsDdebug) {
                return;
            }
            this.mIsDdebug = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_DEBUG, false);
        }
    }

    public boolean checkActivityIsMain(android.app.Activity activity) {
        if (activity == null || android.text.TextUtils.isEmpty(this.mMainActivityClzName)) {
            return false;
        }
        return activity.getClass().getName().equals(this.mMainActivityClzName);
    }

    public boolean checkCurActivityIsMain() {
        if (this.mActivity == null || android.text.TextUtils.isEmpty(this.mMainActivityClzName)) {
            return false;
        }
        return this.mActivity.getClass().getName().equals(this.mMainActivityClzName);
    }

    public void checkFreeLoginActivity() {
        if (this.isCheckFreeLoginActivityConfig) {
            return;
        }
        this.isCheckFreeLoginActivityConfig = true;
        try {
            java.lang.String str = java.lang.String.format("tencentysdk%1$s://", this.mApplicationContext.getPackageName());
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.setPackage(this.mApplicationContext.getPackageName());
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = this.mApplicationContext.getPackageManager().queryIntentActivities(intent, 65536);
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "hostDebug " + isHostDebugMode());
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "freeLogin scheme = " + str);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                com.tencent.ysdk.shell.module.BaseModuleSelfCheck.printConfigErrorInfo("需要参照YSDKDEMO在在manifest上配置" + com.tencent.ysdk.module.user.impl.freelogin.FreeLoginInfoActivity.class.getName(), isTestAndDebug());
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK", "checkFreeLoginActivity fail " + e.getLocalizedMessage());
        }
    }

    public boolean checkIsMainActivityValid() {
        if (android.text.TextUtils.isEmpty(this.mMainActivityClzName)) {
            return false;
        }
        if (!this.mInited || !isTestAndDebug()) {
            return true;
        }
        try {
            android.content.pm.ActivityInfo activityInfo = this.mApplicationContext.getPackageManager().getActivityInfo(new android.content.ComponentName(this.mApplicationContext.getPackageName(), this.mMainActivityClzName), 0);
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "activityInfo = " + activityInfo.packageName + " , " + activityInfo.name);
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK", e);
            return false;
        }
    }

    public android.app.Activity getActivity() {
        return this.mActivity;
    }

    public int getAntiAddictionSwitch() {
        return this.mAntiAddictionSwitch;
    }

    public java.lang.String getAppPkgName() {
        return !android.text.TextUtils.isEmpty(this.mAppPkgName) ? this.mAppPkgName : getInstance().getApplicationContext().getPackageName();
    }

    public android.content.Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public java.lang.String getChannelId() {
        return com.tencent.ysdk.shell.framework.YSDKGame.getInstance().getChannelId();
    }

    public java.lang.String getDomain() {
        if (!android.text.TextUtils.isEmpty(this.mHttpDomain)) {
            return this.mHttpDomain;
        }
        java.lang.Object obj = com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.libware.util.AppSharePreferenceKey.KEY_DEBUG_HTTP_DOMAIN, "");
        if (obj instanceof java.lang.String) {
            this.mHttpDomain = (java.lang.String) obj;
        }
        if (!this.mHttpDomain.equals(com.tencent.ysdk.shell.framework.constant.Constant.YSDK_FORMAL_HTTP_DOMAIN) && !this.mHttpDomain.equals(com.tencent.ysdk.shell.framework.constant.Constant.YSDK_TEST_HTTP_DOMAIN)) {
            this.mHttpDomain = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_HTTP_REQ_DOMAIN, "");
        }
        return this.mHttpDomain;
    }

    public com.tencent.ysdk.shell.framework.common.EnumScreenDir getGameScreenDir() {
        return com.tencent.ysdk.shell.framework.YSDKGame.getInstance().getGameScreenDir();
    }

    public int getGameVersionCode() {
        return com.tencent.ysdk.shell.framework.YSDKGame.getInstance().getGameVersionCode();
    }

    public java.lang.String getGameVersionName() {
        return com.tencent.ysdk.shell.framework.YSDKGame.getInstance().getGameVersionName();
    }

    public android.os.Looper getLooper(int i) {
        return com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().getLooper(i);
    }

    public java.lang.String getMainActivityClzName() {
        return this.mMainActivityClzName;
    }

    public java.lang.String getOfferId() {
        return this.mOfferId;
    }

    public long getPauseTime() {
        return this.mPauseTime;
    }

    public java.lang.String getPlatformAppVersion(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        android.content.Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            return com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(applicationContext, "com.tencent.mm");
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            return com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(applicationContext, "com.tencent.mobileqq");
        }
        return eplatform == com.tencent.ysdk.framework.common.ePlatform.MyApp ? com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(applicationContext, "com.tencent.android.qqdownloader") : "";
    }

    public android.content.Context getPluginContext() {
        com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = this.mPluginInfo;
        return (loadedPluginInfo == null || loadedPluginInfo.mPluginContext == null) ? getApplicationContext() : this.mPluginInfo.mPluginContext;
    }

    public java.lang.String getQQAppId() {
        return this.mQQAppId;
    }

    public java.lang.String getTag() {
        return YSDK_TAG;
    }

    public java.lang.String getVersion() {
        return "1.8.1";
    }

    public java.lang.String getWXAppId() {
        return this.mWXAppId;
    }

    public void handleIntent(android.content.Intent intent) {
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "handleIntent");
            if (com.tencent.ysdk.shell.module.share.ShareApiImpl.getInstance().checkWXCallBack(intent)) {
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "handleIntent wx share");
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("handleIntent ");
            sb.append(intent == null);
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", sb.toString());
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().handleIntent(intent);
        }
    }

    public void init(android.app.Application application, com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo) {
        this.mApplicationContext = application;
        com.tencent.ysdk.shell.framework.YSDKLifeCycle.register(application);
        this.mPluginInfo = loadedPluginInfo;
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_PLUGIN", "init信息: com.tencent.ysdk.shell");
    }

    public void init(boolean z) {
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_INIT", "ysdk had init");
            return;
        }
        android.app.Activity activity = this.mActivity;
        if (activity == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "YSDK init : activity is null");
            return;
        }
        this.autoLoginByYSDK = z;
        initSdk(activity);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().addTask(new com.tencent.ysdk.shell.module.user.impl.UserDurationTask());
        if (isDebug()) {
            com.tencent.ysdk.shell.framework.verification.UserTips.showTestVersionInfo();
        }
        com.tencent.ysdk.shell.framework.verification.UserTips.showYSDKInit();
        printInitLog("UserTips : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        this.mAntiAddictionSwitch = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_ANTIADDICTION_SWITCH, false) ? 1 : 0;
        android.util.Log.d("YSDK", "onCreate end");
    }

    public boolean isAutoLoginByYSDK() {
        return this.autoLoginByYSDK;
    }

    public boolean isDebug() {
        return this.mIsDdebug;
    }

    public boolean isDefauleChannel(java.lang.String str) {
        return com.tencent.ysdk.shell.framework.YSDKGame.getInstance().isDefaultChannel(str);
    }

    public boolean isDev() {
        return this.mIsDev;
    }

    public boolean isHostDebugMode() {
        return this.mIsHostDebugMode;
    }

    public boolean isInit() {
        return this.mInited;
    }

    public boolean isPlatformInstalled(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        android.content.Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            return com.tencent.ysdk.shell.libware.apk.PackageUtils.isInstalledApp(applicationContext, "com.tencent.mm");
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            return com.tencent.ysdk.shell.libware.apk.PackageUtils.isInstalledApp(applicationContext, "com.tencent.mobileqq");
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.MyApp) {
            return com.tencent.ysdk.shell.libware.apk.PackageUtils.isInstalledApp(applicationContext, "com.tencent.android.qqdownloader");
        }
        return false;
    }

    public void loadPluginSo(java.lang.String str) throws java.lang.Error {
        java.lang.String str2 = getApplicationContext().getApplicationInfo().nativeLibraryDir + java.io.File.separator + str;
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "soPath = " + str2);
        java.lang.System.load(str2);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "onActivityResult");
    }

    public void onCreate(android.app.Activity activity) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "onCreate start");
        this.mActivity = activity;
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", this.mActivity.toString());
        if (this.preInit) {
            return;
        }
        com.tencent.ysdk.shell.framework.config.Config.init();
        this.mIsHostDebugMode = (this.mApplicationContext.getApplicationInfo().flags & 2) != 0;
        this.mQQAppId = com.tencent.ysdk.shell.framework.config.Config.readConfig("QQ_APP_ID", "");
        this.mWXAppId = com.tencent.ysdk.shell.framework.config.Config.readConfig("WX_APP_ID", "");
        this.mOfferId = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_OFFER_ID, "");
        setTestAndDebug();
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "YSDK Version:" + getVersion());
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "YSDK TAG:" + getTag());
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "YSDK SO:" + com.tencent.ysdk.a.a.e());
        this.preInit = true;
    }

    public void onDestroy(android.app.Activity activity) {
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "YSDK onDestroy:" + activity.toString());
            com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().onDestroy(activity);
        }
    }

    public void onPause(android.app.Activity activity) {
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "onPause:" + activity.toString());
            this.mPauseTime = java.lang.System.currentTimeMillis() / 1000;
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().onPause(activity);
            com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().onPause(activity);
            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.onPause();
        }
    }

    public void onResume(android.app.Activity activity) {
        this.mActivity = activity;
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "onResume:" + activity.toString());
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().onResume(activity);
            com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().onResume(activity);
            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.onResume();
        }
    }

    public void sendConfigRequest() {
        com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl.getInstance().pullCloudSettings(0);
    }

    public void setMainActivity(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "mainActivity " + this.mMainActivityClzName);
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK", "setMainActivity null");
        }
        this.mMainActivityClzName = str;
    }

    public void setSensitivePermissionStatus(boolean z) {
        this.mIsSensitivePermissionOpen = z;
        if (this.mInited) {
            com.tencent.ysdk.shell.libware.device.DeviceUtils.setSensitivePermissionSwitchStatus(z);
            com.tencent.ysdk.shell.module.stat.StatApi.getInstance().switchBeaconStrategy(z);
        }
    }

    public void setupApplicationContext(android.app.Application application) {
        this.mApplicationContext = application;
    }

    public void tearDown() {
        instance = null;
    }
}
