package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginLoader {
    private static final java.util.HashMap sClassLoaderMap = new java.util.HashMap();
    private static dalvik.system.DexClassLoader parentClassLoader = null;

    public static synchronized java.lang.ClassLoader getClassLoader(java.lang.String str, java.lang.String str2) {
        return (java.lang.ClassLoader) sClassLoaderMap.get(str + "_" + str2);
    }

    public static synchronized java.lang.ClassLoader getOrCreateClassLoader(android.content.Context context, java.lang.String str) {
        dalvik.system.DexClassLoader orCreateClassLoaderByPath;
        orCreateClassLoaderByPath = getOrCreateClassLoaderByPath(context, str, com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath());
        com.tencent.midas.comm.APLog.d("APPluginStatic", "getClassLoader getOrCreateClassLoader midasClassLoader: " + orCreateClassLoaderByPath.hashCode());
        return orCreateClassLoaderByPath;
    }

    static synchronized dalvik.system.DexClassLoader getOrCreateClassLoaderByPath(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String mD5FromPath = com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(str2);
        java.lang.String str3 = str + "_" + mD5FromPath;
        dalvik.system.DexClassLoader dexClassLoader = (dalvik.system.DexClassLoader) sClassLoaderMap.get(str3);
        com.tencent.midas.comm.APLog.d("APPluginStatic", "getOrCreateClassLoader apkFilePath: " + str2 + ", MD5: " + mD5FromPath + ", key: " + str3 + ", dexClassLoader: " + dexClassLoader);
        if (dexClassLoader != null) {
            return dexClassLoader;
        }
        java.lang.String canonicalPath = com.tencent.midas.plugin.APPluginConfig.getOptimizedDexPath(context).getCanonicalPath();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.midas.plugin.APPluginUtils.extractLibs(str2, com.tencent.midas.plugin.APPluginConfig.getLibPath(context).getCanonicalPath());
        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_UNZIP_SO, jCurrentTimeMillis);
        java.lang.String canonicalPath2 = com.tencent.midas.plugin.APPluginConfig.getLibPath(context).getCanonicalPath();
        dalvik.system.DexClassLoader dexClassLoader2 = parentClassLoader != null ? new dalvik.system.DexClassLoader(str2, canonicalPath, canonicalPath2, parentClassLoader) : new dalvik.system.DexClassLoader(str2, canonicalPath, canonicalPath2, context.getClassLoader());
        com.tencent.midas.comm.APLog.d("APPluginStatic", "getOrCreateClassLoader new DexClassLoader cache: " + canonicalPath + " libDir: " + canonicalPath2);
        sClassLoaderMap.put(str3, dexClassLoader2);
        return dexClassLoader2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void preCreateClassLoaderByPath(android.content.Context context) {
        java.lang.String str = "";
        java.lang.String canonicalPath = "";
        java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
        if (pluginPath != null) {
            for (java.io.File file : pluginPath.listFiles()) {
                if (file.getName().startsWith("MidasPay")) {
                    str = "MidasPay";
                    canonicalPath = file.getCanonicalPath();
                    break;
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(canonicalPath)) {
            getOrCreateClassLoaderByPath(context, str, canonicalPath);
        }
    }

    static void release() {
        sClassLoaderMap.clear();
    }

    public static void setParentClassLoader(dalvik.system.DexClassLoader dexClassLoader) {
        parentClassLoader = dexClassLoader;
    }
}
