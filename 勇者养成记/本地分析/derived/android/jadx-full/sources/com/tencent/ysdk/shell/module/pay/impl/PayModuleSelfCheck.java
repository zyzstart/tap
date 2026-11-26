package com.tencent.ysdk.shell.module.pay.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayModuleSelfCheck extends com.tencent.ysdk.shell.module.BaseModuleSelfCheck {
    private static void checkAPWebJSBridgeActivity(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new android.content.ComponentName(str, "com.tencent.midas.jsbridge.APWebJSBridgeActivity"), 128);
            if (!checkActivityTheme(activityInfo, "com.tencent.midas.jsbridge.APWebJSBridgeActivity")) {
                showPayConfigTips();
            }
            if (activityInfo.softInputMode != 3) {
                printPayConfigError("AndroidMainfest: the windowSoftInputMode of com.tencent.midas.jsbridge.APWebJSBridgeActivity must be :stateAlwaysHidden");
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printPayConfigError("AndroidMainfest: activity: com.tencent.midas.jsbridge.APWebJSBridgeActivityhas not been declared in AndroidMainfest.xml !");
        }
    }

    private static void checkMidasProxyActivity(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new android.content.ComponentName(str, "com.tencent.midas.proxyactivity.APMidasPayProxyActivity"), 128);
            if (!checkConfigChanges(activityInfo, "com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) {
                showPayConfigTips();
            }
            checkScreenOrientation(activityInfo, "com.tencent.midas.proxyactivity.APMidasPayProxyActivity");
            if (checkActivityTheme(activityInfo, "com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) {
                return;
            }
            showPayConfigTips();
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printPayConfigError("AndroidMainfest: activity: com.tencent.midas.proxyactivity.APMidasPayProxyActivityhas not been declared in AndroidMainfest.xml !");
        }
    }

    private static void checkMidasQQWalletActivity(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new android.content.ComponentName(str, "com.tencent.midas.qq.APMidasQQWalletActivity"), 128);
            if (!checkConfigChanges(activityInfo, "com.tencent.midas.qq.APMidasQQWalletActivity")) {
                showPayConfigTips();
            }
            if (!checkActivityTheme(activityInfo, "com.tencent.midas.qq.APMidasQQWalletActivity")) {
                showPayConfigTips();
            }
            if (activityInfo.launchMode != 1) {
                printPayConfigError("AndroidMainfest: the launchMode of com.tencent.midas.qq.APMidasQQWalletActivity must be singleTop");
            }
            if (!activityInfo.exported) {
                printPayConfigError("AndroidMainfest: the exported of com.tencent.midas.qq.APMidasQQWalletActivity must be true");
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setData(android.net.Uri.parse("qwallet100703379://"));
            if (!queryIntentFilter(intent, "com.tencent.midas.qq.APMidasQQWalletActivity")) {
                printPayConfigError("AndroidMainfest: android:scheme of com.tencent.midas.qq.APMidasQQWalletActivity  must be the same as qwallet100703379");
            }
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            if (queryIntentFilter(intent, "com.tencent.midas.qq.APMidasQQWalletActivity")) {
                return;
            }
            printPayConfigError("AndroidMainfest: com.tencent.midas.qq.APMidasQQWalletActivity Category Error");
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printPayConfigError("AndroidMainfest: activity: com.tencent.midas.qq.APMidasQQWalletActivityhas not been declared in AndroidMainfest.xml !");
        }
    }

    private static void checkMidasWXPayActivity(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new android.content.ComponentName(str, "com.tencent.midas.wx.APMidasWXPayActivity"), 128);
            if (!checkActivityTheme(activityInfo, "com.tencent.midas.wx.APMidasWXPayActivity")) {
                showPayConfigTips();
            }
            if (!activityInfo.exported) {
                printPayConfigError("AndroidMainfest: the exported of com.tencent.midas.wx.APMidasWXPayActivity must be true");
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printPayConfigError("AndroidMainfest: activity: com.tencent.midas.wx.APMidasWXPayActivityhas not been declared in AndroidMainfest.xml !");
        }
    }

    protected static void checkPermission() {
        java.lang.String[] strArr = {com.unisound.client.SpeechConstants.PERMISSION_INTERNET, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", com.unisound.client.SpeechConstants.PERMISSION_ACCESS_WIFI_STATE};
        try {
            java.util.List listAsList = java.util.Arrays.asList(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager().getPackageInfo(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName(), 4096).requestedPermissions);
            for (int i = 0; i < strArr.length; i++) {
                if (!listAsList.contains(strArr[i])) {
                    printPayConfigError("Missing Android Permission " + strArr[i]);
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            printPayConfigError("Parse Android Permission error");
        }
    }

    protected static void checkSDKConfig() {
        android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        java.lang.String packageName = applicationContext.getPackageName();
        checkMidasProxyActivity(applicationContext, packageName);
        checkMidasWXPayActivity(applicationContext, packageName);
        checkMidasQQWalletActivity(applicationContext, packageName);
        checkAPWebJSBridgeActivity(applicationContext, packageName);
    }

    private static void printPayConfigError(java.lang.String str) {
        printConfigErrorInfo(str);
        showPayConfigTips();
    }

    private static void showPayConfigTips() {
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* 注意：YSDK配置检测模块检测到您支付接入相关配置错误,请通过下面的链接检查确认：");
        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* http://wiki.open.qq.com/wiki/%E6%94%AF%E4%BB%98%EF%BC%88Midas%EF%BC%89%E6%8E%A5%E5%85%A5");
    }
}
