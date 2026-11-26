package com.tencent.ysdk.shell.module.user.impl.qq;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserModuleSelfCheck extends com.tencent.ysdk.shell.module.BaseModuleSelfCheck {
    protected static void checkSDKConfig() {
        android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        java.lang.String packageName = applicationContext.getPackageName();
        try {
            android.content.pm.ActivityInfo activityInfo = applicationContext.getPackageManager().getActivityInfo(new android.content.ComponentName(packageName, "com.tencent.tauth.AuthActivity"), 128);
            if (activityInfo.launchMode != 2) {
                printQQConfigError("AndroidMainfest: the launchMode of com.tencent.tauth.AuthActivity should be singleTask, now is:" + activityInfo.launchMode);
            }
            if ((activityInfo.flags & 128) != 128) {
                printQQConfigError("AndroidMainfest: the noHistory of com.tencent.tauth.AuthActivity must be true");
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printQQConfigError("AndroidMainfest: activity: com.tencent.tauth.AuthActivityhas not been declared in AndroidMainfest.xml !");
        }
        try {
            android.content.pm.ActivityInfo activityInfo2 = applicationContext.getPackageManager().getActivityInfo(new android.content.ComponentName(packageName, "com.tencent.connect.common.AssistActivity"), 128);
            if (!checkConfigChanges(activityInfo2, "com.tencent.connect.common.AssistActivity")) {
                showQQConfigTips();
            }
            if (!checkActivityTheme(activityInfo2, "com.tencent.connect.common.AssistActivity")) {
                showQQConfigTips();
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setData(android.net.Uri.parse("tencent" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId() + "://"));
            if (!queryIntentFilter(intent, "com.tencent.tauth.AuthActivity")) {
                printQQConfigError("AndroidMainfest: QQ AppID in ysdkconf.ini  must be the same as configed in AndroidMainfest.xml");
            }
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            if (queryIntentFilter(intent, "com.tencent.tauth.AuthActivity")) {
                return;
            }
            printQQConfigError("AndroidMainfest: AuthActivity Category Error");
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            printQQConfigError("AndroidMainfest: activity: com.tencent.connect.common.AssistActivityhas not been declared in AndroidMainfest.xml !");
        }
    }

    private static void printQQConfigError(java.lang.String str) {
        printConfigErrorInfo(str);
        showQQConfigTips();
    }

    private static void showQQConfigTips() {
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* 注意：YSDK配置检测模块检测到您QQ接入相关配置错误,请通过下面的链接检查确认：");
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* http://wiki.open.qq.com/wiki/%E5%BE%AE%E4%BF%A1%E4%B8%8E%E6%89%8BQ%E6%8E%A5%E5%85%A5");
    }
}
