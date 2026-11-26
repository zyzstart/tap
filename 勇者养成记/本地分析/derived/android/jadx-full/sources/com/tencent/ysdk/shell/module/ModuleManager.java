package com.tencent.ysdk.shell.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ModuleManager {
    private static final java.lang.String LOG_TAG = "ModuleManager";
    public static final java.lang.String YSDK_MODULE_NAME_ANTI_ADDICTION = "antiAddiction";
    public static final java.lang.String YSDK_MODULE_NAME_BUGLY = "bugly";
    public static final java.lang.String YSDK_MODULE_NAME_FREE_LOGIN = "user_free_login";
    public static final java.lang.String YSDK_MODULE_NAME_H5GAME = "h5game";
    public static final java.lang.String YSDK_MODULE_NAME_ICON = "icon";
    public static final java.lang.String YSDK_MODULE_NAME_IMMERSIVE_ICON = "immersiveIcon";
    public static final java.lang.String YSDK_MODULE_NAME_LAUNCH_GIFT = "launchGift";
    public static final java.lang.String YSDK_MODULE_NAME_MSGBOX = "msgBox";
    public static final java.lang.String YSDK_MODULE_NAME_PAY = "pay";
    public static final java.lang.String YSDK_MODULE_NAME_REAL_NAME = "realName";
    public static final java.lang.String YSDK_MODULE_NAME_REPORT = "report";
    public static final java.lang.String YSDK_MODULE_NAME_SHARE = "share";
    public static final java.lang.String YSDK_MODULE_NAME_STAT = "stat";
    public static final java.lang.String YSDK_MODULE_NAME_USER = "user";
    public static final java.lang.String YSDK_MODULE_NAME_USER_GUEST = "user_guest";
    public static final java.lang.String YSDK_MODULE_NAME_USER_QQ = "user_qq";
    public static final java.lang.String YSDK_MODULE_NAME_USER_WX = "user_wx";
    private static volatile com.tencent.ysdk.shell.module.ModuleManager instance;
    private static final java.util.HashMap<java.lang.String, java.lang.Class<?>> name2ClassName = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, com.tencent.ysdk.shell.module.Module> mModules = new java.util.HashMap<>();

    static {
        name2ClassName.put(YSDK_MODULE_NAME_USER_QQ, com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_USER_WX, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_USER_GUEST, com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_FREE_LOGIN, com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_USER, com.tencent.ysdk.shell.module.user.impl.UserModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_STAT, com.tencent.ysdk.shell.module.stat.impl.StatModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_REPORT, com.tencent.ysdk.shell.module.report.impl.HaboReportModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_BUGLY, com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.class);
        name2ClassName.put("pay", com.tencent.ysdk.shell.module.pay.impl.PayModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_REAL_NAME, com.tencent.ysdk.shell.module.realName.RealNameApi.class);
        name2ClassName.put("icon", com.tencent.ysdk.shell.module.icon.impl.IconModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_IMMERSIVE_ICON, com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_LAUNCH_GIFT, com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_MSGBOX, com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_SHARE, com.tencent.ysdk.shell.module.share.impl.ShareModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_H5GAME, com.tencent.ysdk.shell.module.h5game.H5GameModule.class);
        name2ClassName.put(YSDK_MODULE_NAME_ANTI_ADDICTION, com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.class);
    }

    private ModuleManager() {
    }

    private boolean checkModuleIsNeeded(java.lang.String str) {
        if (str.equals(YSDK_MODULE_NAME_USER_QQ) && com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId())) {
            com.tencent.ysdk.shell.framework.verification.UserTips.showQQModuleNotGoodTips();
            return false;
        }
        if (str.equals(YSDK_MODULE_NAME_USER_WX) && com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId())) {
            com.tencent.ysdk.shell.framework.verification.UserTips.showWXModuleNotGoodTips();
            return false;
        }
        if (!str.equals("pay") || !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId())) {
            return true;
        }
        com.tencent.ysdk.shell.framework.verification.UserTips.showPayModuleNotGoodTips();
        return false;
    }

    public static com.tencent.ysdk.shell.module.ModuleManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.ModuleManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.ModuleManager();
                }
            }
        }
        return instance;
    }

    private void loadModuleByClassName(java.lang.String str, java.lang.Class<?> cls) {
        try {
            if (checkModuleIsNeeded(str)) {
                java.lang.Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof com.tencent.ysdk.shell.module.Module) {
                    com.tencent.ysdk.shell.module.Module module = (com.tencent.ysdk.shell.module.Module) objNewInstance;
                    module.init();
                    registerModule(str, module);
                }
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    private void loadModuleByName(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "loadModuleByName " + str);
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.mModules.containsKey(str) || this.mModules.get(str) == null) {
            loadModuleByClassName(str, name2ClassName.get(str));
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "moduleName is exist = " + str);
    }

    private void registerModule(java.lang.String str, com.tencent.ysdk.shell.module.Module module) {
        if (module == null) {
            return;
        }
        if (module.name == null && str == null) {
            return;
        }
        if (str == null) {
            str = module.name;
        }
        this.mModules.put(str, module);
    }

    public void checkModuleConfig() {
        if (!com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK is using release domain");
            return;
        }
        try {
            com.tencent.ysdk.shell.framework.verification.UserTips.showStartSelfCheck();
            com.tencent.ysdk.shell.module.YSDKBasicSelfCheck.checkBasicInfo();
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.tencent.ysdk.shell.module.Module>> it = this.mModules.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().selfCheck();
            }
            com.tencent.ysdk.shell.framework.verification.UserTips.showEndSelfCheck();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public com.tencent.ysdk.shell.module.Module getModuleByName(java.lang.String str) {
        com.tencent.ysdk.shell.module.Module module = this.mModules.get(str);
        if (module != null) {
            return module;
        }
        loadModuleByName(str);
        return this.mModules.get(str);
    }

    public void init() {
        loadModuleByName(YSDK_MODULE_NAME_STAT);
        loadModuleByName(YSDK_MODULE_NAME_MSGBOX);
        loadModuleByName(YSDK_MODULE_NAME_USER_QQ);
        loadModuleByName(YSDK_MODULE_NAME_USER_WX);
        loadModuleByName(YSDK_MODULE_NAME_USER_GUEST);
        loadModuleByName(YSDK_MODULE_NAME_USER);
        loadModuleByName("pay");
        loadModuleByName(YSDK_MODULE_NAME_IMMERSIVE_ICON);
        loadModuleByName(YSDK_MODULE_NAME_H5GAME);
        loadModuleByName("icon");
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    public void onDestroy(android.app.Activity activity) {
    }

    public void onNewIntent(android.content.Intent intent) {
    }

    public void onPause(android.app.Activity activity) {
    }

    public void onRestart(android.app.Activity activity) {
    }

    public void onResume(android.app.Activity activity) {
    }

    public void onStop(android.app.Activity activity) {
    }
}
