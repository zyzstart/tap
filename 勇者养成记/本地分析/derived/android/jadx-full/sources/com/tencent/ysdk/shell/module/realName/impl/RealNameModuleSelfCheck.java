package com.tencent.ysdk.shell.module.realName.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RealNameModuleSelfCheck extends com.tencent.ysdk.shell.module.BaseModuleSelfCheck {
    protected static void checkSDKConfig() {
        android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        java.lang.String packageName = applicationContext.getPackageName();
        try {
            java.lang.Class.forName("com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity");
            android.content.pm.ActivityInfo activityInfo = applicationContext.getPackageManager().getActivityInfo(new android.content.ComponentName(packageName, "com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity"), 128);
            if (!checkConfigChanges(activityInfo, "com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity")) {
                showRealNameConfigTips();
            }
            checkScreenOrientation(activityInfo, "com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity");
            if (checkActivityTheme(activityInfo, "com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity")) {
                return;
            }
            showRealNameConfigTips();
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printRealNameConfigError("AndroidMainfest: Lack of activity: com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity");
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private static void printRealNameConfigError(java.lang.String str) {
        printConfigErrorInfo(str);
        showRealNameConfigTips();
    }

    private static void showRealNameConfigTips() {
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* 注意：YSDK配置检测模块检测到您实名接入相关配置错误,请通过下面的链接检查确认：");
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* http://wiki.open.qq.com/wiki/%E5%BE%AE%E4%BF%A1%E4%B8%8E%E6%89%8BQ%E6%8E%A5%E5%85%A5");
    }
}
