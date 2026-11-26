package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsExtensionFunctionManager {
    public static final java.lang.String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final java.lang.String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final java.lang.String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final java.lang.String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final java.lang.String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final java.lang.String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final java.lang.String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final java.lang.String USEX5_FILE_NAME = "usex5.txt";
    private static com.tencent.smtt.sdk.TbsExtensionFunctionManager b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f860a;

    private TbsExtensionFunctionManager() {
    }

    public static com.tencent.smtt.sdk.TbsExtensionFunctionManager getInstance() {
        if (b == null) {
            synchronized (com.tencent.smtt.sdk.TbsExtensionFunctionManager.class) {
                if (b == null) {
                    b = new com.tencent.smtt.sdk.TbsExtensionFunctionManager();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean canUseFunction(android.content.Context context, java.lang.String str) {
        java.io.File file;
        file = new java.io.File(context.getFilesDir(), str);
        return file.exists() && file.isFile();
    }

    public synchronized int getRomCookieDBVersion(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(android.content.Context context) {
        java.lang.String absolutePath;
        if (this.f860a) {
            return;
        }
        if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            return;
        }
        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            java.io.File fileQ = com.tencent.smtt.sdk.m.a().q(context);
            if (fileQ == null) {
                com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
            }
            if (fileQ.listFiles() != null && fileQ.listFiles().length > 0) {
                absolutePath = fileQ.getAbsolutePath();
            }
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
            return;
        }
        absolutePath = com.tencent.smtt.sdk.TbsShareManager.c(context);
        if (android.text.TextUtils.isEmpty(absolutePath)) {
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
            return;
        }
        java.io.File fileQ2 = com.tencent.smtt.sdk.m.a().q(context);
        if (fileQ2 == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
            return;
        }
        java.io.File file = new java.io.File(absolutePath, "tbs_bugly_dex.jar");
        try {
            com.tencent.smtt.utils.k.a(new com.tencent.smtt.export.external.DexLoader(file.getParent(), context, new java.lang.String[]{file.getAbsolutePath()}, fileQ2.getAbsolutePath(), com.tencent.smtt.sdk.QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.String.class, java.lang.String.class}, context, absolutePath, java.lang.String.valueOf(com.tencent.smtt.sdk.WebView.getTbsSDKVersion(context)), java.lang.String.valueOf(com.tencent.smtt.sdk.WebView.getTbsCoreVersion(context)));
            this.f860a = true;
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + android.util.Log.getStackTraceString(th));
        }
    }

    public synchronized boolean setFunctionEnable(android.content.Context context, java.lang.String str, boolean z) {
        if (context == null) {
            return false;
        }
        java.io.File file = new java.io.File(context.getFilesDir(), str);
        if (z) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (java.io.IOException e) {
                    com.tencent.smtt.utils.TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            com.tencent.smtt.utils.TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }
}
