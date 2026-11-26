package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginProxyBroadcastReceiver extends android.content.BroadcastReceiver {
    public static void sendBroadcastReceiver(android.content.Context context, java.lang.String str, java.lang.String str2, android.content.Intent intent) {
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME, str);
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_RECEIVER_CLASS_NAME, str2);
        try {
            context.sendBroadcast(intent);
        } catch (java.lang.Throwable unused) {
        }
    }

    private com.tencent.midas.plugin.IAPPluginBroadcastReceiver startPluginIfNeccessary(android.content.Context context, android.content.Intent intent) throws java.io.IOException {
        java.lang.String canonicalPath;
        if (intent == null) {
            return null;
        }
        java.lang.String stringExtra = intent.getStringExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME);
        java.lang.String stringExtra2 = intent.getStringExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_RECEIVER_CLASS_NAME);
        if (android.text.TextUtils.isEmpty(null)) {
            try {
                canonicalPath = com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(context, stringExtra).getCanonicalPath();
            } catch (java.io.IOException unused) {
                canonicalPath = null;
            }
        } else {
            canonicalPath = null;
        }
        com.tencent.midas.comm.APLog.i("APPLuginProxyBroadcastReciver", "startPluginIfNeccessary Params:" + stringExtra + ", " + stringExtra2);
        if (stringExtra == null || stringExtra.length() <= 0) {
            return null;
        }
        java.io.File file = new java.io.File(canonicalPath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.get(canonicalPath);
        if (packageInfo == null) {
            packageInfo = com.tencent.midas.plugin.APApkFileParser.getPackageInfo(context, canonicalPath, 1);
            com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.put(canonicalPath, packageInfo);
        }
        android.content.pm.PackageInfo packageInfo2 = packageInfo;
        try {
            dalvik.system.DexClassLoader orCreateClassLoaderByPath = com.tencent.midas.plugin.APPluginLoader.getOrCreateClassLoaderByPath(context, stringExtra, canonicalPath);
            com.tencent.midas.plugin.IAPPluginBroadcastReceiver iAPPluginBroadcastReceiver = (com.tencent.midas.plugin.IAPPluginBroadcastReceiver) orCreateClassLoaderByPath.loadClass(stringExtra2).newInstance();
            try {
                iAPPluginBroadcastReceiver.IInit(stringExtra, canonicalPath, this, orCreateClassLoaderByPath, packageInfo2, false);
            } catch (java.lang.Exception unused2) {
            }
            return iAPPluginBroadcastReceiver;
        } catch (java.lang.Exception unused3) {
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) throws java.io.IOException {
        com.tencent.midas.plugin.IAPPluginBroadcastReceiver iAPPluginBroadcastReceiverStartPluginIfNeccessary = startPluginIfNeccessary(context, intent);
        com.tencent.midas.comm.APLog.i("APPLuginProxyBroadcastReciver", "onReceive startPluginIfNeccessary: " + iAPPluginBroadcastReceiverStartPluginIfNeccessary);
        if (iAPPluginBroadcastReceiverStartPluginIfNeccessary != null) {
            iAPPluginBroadcastReceiverStartPluginIfNeccessary.IOnReceive(context, intent);
        }
    }
}
