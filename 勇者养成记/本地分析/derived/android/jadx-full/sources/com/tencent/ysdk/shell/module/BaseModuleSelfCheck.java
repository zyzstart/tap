package com.tencent.ysdk.shell.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseModuleSelfCheck {
    public static final java.lang.String LOG_TAG = "YSDK_CHECK";

    protected static boolean checkActivityTheme(android.content.pm.ActivityInfo activityInfo, java.lang.String str) {
        if (activityInfo.theme == 16973840) {
            return true;
        }
        printConfigErrorInfo("AndroidMainfest: the theme of " + str + " must be Theme.Translucent.NoTitleBar");
        return false;
    }

    protected static boolean checkConfigChanges(android.content.pm.ActivityInfo activityInfo, java.lang.String str) {
        int i = android.os.Build.VERSION.SDK_INT;
        int i2 = i < 13 ? 160 : 1184;
        if ((activityInfo.configChanges & i2) == i2) {
            return true;
        }
        if (i < 13) {
            printConfigErrorInfo("AndroidMainfest: the configChanges of " + str + " must be orientation|keyboardHidden");
            return false;
        }
        printConfigErrorInfo("AndroidMainfest: the configChanges of " + str + " must be orientation|screenSize|keyboardHidden");
        return false;
    }

    protected static boolean checkScreenOrientation(android.content.pm.ActivityInfo activityInfo, java.lang.String str) {
        return true;
    }

    public static void printConfigErrorInfo(java.lang.String str) {
        printConfigErrorInfo(str, true);
    }

    public static void printConfigErrorInfo(java.lang.String str, boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "YSDK Error: " + str);
        if (z) {
            android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "YSDK配置自检发现配置错误,请结合日志进一步分析 \nYSDK Error: " + str, 1).show();
        }
    }

    public static boolean queryIntentFilter(android.content.Intent intent, java.lang.String str) {
        android.content.pm.PackageManager packageManager = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager();
        boolean z = false;
        if (packageManager == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "PackageManager is null, check fail.");
            return false;
        }
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        java.lang.String packageName = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName();
        for (android.content.pm.ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (packageName.equals(resolveInfo.activityInfo.packageName) && str.equals(resolveInfo.activityInfo.name)) {
                z = true;
                break;
            }
        }
        if (!z) {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "the intent-filter of " + str + " has not be configured correctly");
        }
        return z;
    }
}
