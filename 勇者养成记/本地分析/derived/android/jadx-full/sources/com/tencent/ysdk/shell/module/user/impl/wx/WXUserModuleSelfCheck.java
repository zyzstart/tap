package com.tencent.ysdk.shell.module.user.impl.wx;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserModuleSelfCheck extends com.tencent.ysdk.shell.module.BaseModuleSelfCheck {
    protected static void checkSDKConfig() {
        android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        java.lang.String packageName = applicationContext.getPackageName();
        java.lang.String str = packageName + com.tencent.mm.opensdk.channel.MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
        try {
            java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            str = "com.tencent.ysdk.module.user.impl.wx.YSDKWXEntryActivity";
        }
        try {
            java.lang.Class.forName(str);
            android.content.pm.ActivityInfo activityInfo = applicationContext.getPackageManager().getActivityInfo(new android.content.ComponentName(packageName, str), 128);
            if ((activityInfo.flags & 32) != 32) {
                printWXConfigError("AndroidMainfest: the excludeFromRecents of WXEntryActivity must be true");
            }
            if (!activityInfo.exported) {
                printWXConfigError("AndroidMainfest: the exported of WXEntryActivity must be true");
            }
            if (activityInfo.launchMode != 1) {
                printWXConfigError("AndroidMainfest: the launchMode of WXEntryActivity must be singleTop");
            }
            java.lang.String str2 = packageName + ".diff";
            if (!activityInfo.taskAffinity.equals(str2)) {
                printWXConfigError("AndroidMainfest: the taskAffinity of WXEntryActivity must be named as: " + str2);
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setData(android.net.Uri.parse(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId() + "://"));
            if (!queryIntentFilter(intent, str)) {
                printWXConfigError("wx appid in ysdkconf.ini must be the same as configed in WXEntryActivity, data android:scheme");
            }
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            if (queryIntentFilter(intent, str)) {
                return;
            }
            printWXConfigError("AndroidMainfest: WXEntryActivity Category Error");
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printWXConfigError("AndroidMainfest: Lack of activity: " + str);
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
            printWXConfigError(" WXEntryActivity.java must be put into package " + applicationContext.getPackageName() + ".wxapi");
        }
    }

    private static void printWXConfigError(java.lang.String str) {
        printConfigErrorInfo(str);
        com.tencent.ysdk.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* 注意：YSDK配置检测模块检测到您微信接入相关配置错误,请通过下面的链接检查确认：");
        com.tencent.ysdk.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* http://wiki.open.qq.com/wiki/%E5%BE%AE%E4%BF%A1%E4%B8%8E%E6%89%8BQ%E6%8E%A5%E5%85%A5");
    }
}
