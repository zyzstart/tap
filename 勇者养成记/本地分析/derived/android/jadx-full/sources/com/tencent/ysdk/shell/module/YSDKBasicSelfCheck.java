package com.tencent.ysdk.shell.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKBasicSelfCheck extends com.tencent.ysdk.shell.module.BaseModuleSelfCheck {
    public static void checkBasicInfo() {
        checkPermission();
        checkGlobalConfig();
    }

    private static void checkGlobalConfig() {
        android.content.pm.PackageManager packageManager = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager();
        java.lang.String packageName = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName();
        try {
            java.lang.String className = packageManager.getLaunchIntentForPackage(packageName).getComponent().getClassName();
            android.content.pm.ActivityInfo activityInfo = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager().getActivityInfo(new android.content.ComponentName(packageName, className), 128);
            if (!checkConfigChanges(activityInfo, className)) {
                printConfigErrorInfo("AndroidMainfest: the ScreenOrientation of " + className + " is bad");
            }
            if (activityInfo.launchMode != 1) {
                printConfigErrorInfo("AndroidMainfest: the launchMode of " + className + " should be singleTop, now is:" + activityInfo.launchMode);
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        java.lang.String config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_HTTP_REQ_DOMAIN, "");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(com.tencent.ysdk.shell.framework.constant.Constant.YSDK_TEST_HTTP_DOMAIN);
        arrayList.add(com.tencent.ysdk.shell.framework.constant.Constant.YSDK_FORMAL_HTTP_DOMAIN);
        if (arrayList.contains(config)) {
            return;
        }
        printConfigErrorInfo("ysdkconf.ini: the YSDK_URL config is bad, u are usring:" + config);
    }

    private static void checkPermission() {
        java.lang.String[] strArr = {com.unisound.client.SpeechConstants.PERMISSION_INTERNET, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", com.unisound.client.SpeechConstants.PERMISSION_ACCESS_WIFI_STATE};
        try {
            java.util.List listAsList = java.util.Arrays.asList(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager().getPackageInfo(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName(), 4096).requestedPermissions);
            for (int i = 0; i < strArr.length; i++) {
                if (!listAsList.contains(strArr[i])) {
                    printConfigErrorInfo("Missing Android Permission " + strArr[i]);
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printConfigErrorInfo("Check Permission:PackageManager.NameNotFoundException");
        }
    }
}
