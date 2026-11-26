package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginInterfaceManager {
    public static final java.lang.String TAG = "APPluginInterfaceManager";

    private static java.lang.Class getObjectClass(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String canonicalPath = "";
        try {
            canonicalPath = com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath();
        } catch (java.lang.Exception unused) {
        }
        try {
            if (((android.content.pm.PackageInfo) com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.get(canonicalPath)) == null) {
                android.content.pm.PackageInfo packageInfo = com.tencent.midas.plugin.APApkFileParser.getPackageInfo(context, canonicalPath, 1);
                if (packageInfo == null) {
                    return null;
                }
                com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.put(canonicalPath, packageInfo);
            }
            return com.tencent.midas.plugin.APPluginLoader.getOrCreateClassLoaderByPath(context, str, canonicalPath).loadClass(str2);
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    private static java.lang.Class[] getParamsType(java.lang.Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        java.lang.Class[] clsArr = new java.lang.Class[length];
        for (int i = 0; i < length; i++) {
            if (objArr[i] != null) {
                if (android.app.Activity.class.isAssignableFrom(objArr[i].getClass())) {
                    clsArr[i] = android.app.Activity.class;
                } else {
                    clsArr[i] = objArr[i].getClass();
                }
            }
        }
        return clsArr;
    }

    public static java.lang.Object initPluginInterface(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object[] objArr) {
        com.tencent.midas.comm.APLog.d(TAG, "Call into initPluginInterface  plugin = " + str + " interfaceClass = " + str2 + " methodName = " + str3 + " " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface objClass param is null");
            return null;
        }
        java.lang.Class objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass != null) {
            java.lang.reflect.Method method = objectClass.getMethod(str3, getParamsType(objArr));
            method.setAccessible(true);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.Object objInvoke = method.invoke(objectClass, objArr);
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface method=" + method + " obj=" + objInvoke + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            return objInvoke;
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
        if (com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_PAY.equals(str3)) {
            com.tencent.midas.comm.APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " we need to jump to pure h5 pay!");
            com.tencent.midas.plugin.APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", true);
        } else {
            com.tencent.midas.comm.APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " no need to jump to pure h5 pay!");
            com.tencent.midas.plugin.APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
        }
        com.tencent.midas.plugin.APPluginStatic.removeAll();
        com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
        return null;
    }

    public static java.lang.Object initPluginInterface(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object[] objArr, java.lang.Class[] clsArr) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=" + str);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=" + str2);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=" + str3);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
            return null;
        }
        java.lang.Class objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass == null) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
            com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
            com.tencent.midas.plugin.APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
            com.tencent.midas.plugin.APPluginStatic.removeAll();
            com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
            return null;
        }
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:" + str3);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:" + objectClass);
        for (java.lang.Class cls : clsArr) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + cls);
        }
        java.lang.reflect.Method method = objectClass.getMethod(str3, clsArr);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:" + method);
        method.setAccessible(true);
        java.lang.Object objInvoke = method.invoke(objectClass, objArr);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=" + objInvoke);
        return objInvoke;
    }

    public static java.lang.Object initPluginInterface2(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object[] objArr) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=" + str);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=" + str2);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=" + str3);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
            return null;
        }
        java.lang.Class objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass == null) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
            com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
            com.tencent.midas.plugin.APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
            com.tencent.midas.plugin.APPluginStatic.removeAll();
            com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
            return null;
        }
        java.lang.Class<?>[] clsArr = {objArr[0].getClass(), objArr[1].getClass(), objArr[2].getClass()};
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:" + str3);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:" + objectClass);
        for (int i = 0; i < 3; i++) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + clsArr[i]);
        }
        java.lang.reflect.Method method = objectClass.getMethod(str3, clsArr);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:" + method);
        method.setAccessible(true);
        java.lang.Object objInvoke = method.invoke(objectClass, objArr);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=" + objInvoke);
        return objInvoke;
    }
}
