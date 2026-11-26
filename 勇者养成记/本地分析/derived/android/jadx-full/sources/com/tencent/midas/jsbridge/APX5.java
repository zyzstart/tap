package com.tencent.midas.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APX5 {
    private static java.lang.String getTbsVersion() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.tencent.smtt.sdk.TbsConfig");
            java.lang.reflect.Field field = cls.getField("TBS_SDK_VERSIONNAME");
            field.setAccessible(true);
            return (java.lang.String) field.get(cls);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (java.lang.NoSuchFieldException e3) {
            e3.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private static boolean hasInitX5Method() {
        try {
            return java.lang.Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", android.content.Context.class, java.lang.Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback")) != null;
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean initTbs(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.midas.comm.APLog.e("APX5", "init Tbs Start");
        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_X5_INIT, "", "");
        boolean z = false;
        try {
            java.lang.String tbsVersion = getTbsVersion();
            com.tencent.midas.comm.APLog.e("APX5", "get tbs version: " + tbsVersion);
            if (hasInitX5Method()) {
                com.tencent.midas.comm.APLog.e("APX5", "tbs has initX5 method");
                initX5Environment(context);
                z = true;
                str = "APX5";
                str2 = "init Tbs Success. use X5 instead of Native WebView";
            } else {
                com.tencent.midas.comm.APLog.e("APX5", "tbs has no initX5 method");
                str = "APX5";
                str2 = "unsupported tbs, version: " + tbsVersion;
            }
            com.tencent.midas.comm.APLog.e(str, str2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.midas.comm.APLog.e("APX5", "init tbs failed, use native WebView!");
            com.tencent.midas.comm.APLog.e("APX5", "unsupported tbs: exception: " + th.getMessage());
        }
        com.tencent.midas.comm.APLog.e("APX5", "initTbs End");
        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), z ? com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_X5_INIT_SUCCESS : com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_X5_INIT_FAIL, "", "");
        return z;
    }

    public static void initX5(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.midas.comm.APLog.e("APX5", ">>>>>>> initX5 Start <<<<<<<");
        if (isX5Enabled(context)) {
            str = "APX5";
            str2 = ">>>>>>> initX5 End <<<<<<<";
        } else {
            str = "APX5";
            str2 = ">>>>>>> X5 is missed or disabled, use native WebView";
        }
        com.tencent.midas.comm.APLog.e(str, str2);
    }

    private static void initX5Environment(final android.content.Context context) {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.jsbridge.APX5.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.lang.reflect.Method method = java.lang.Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", android.content.Context.class, java.lang.Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback"));
                    if (method != null) {
                        method.setAccessible(true);
                        method.invoke(null, context.getApplicationContext(), null);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static boolean isX5Enabled(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        java.lang.String string = applicationContext.getSharedPreferences(com.tencent.midas.data.APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).getString("enableX5", "1");
        boolean z = !android.text.TextUtils.isEmpty(string) ? !string.equals("0") : true;
        com.tencent.midas.comm.APLog.e("APX5", "is enable X5: " + string);
        return z && initTbs(applicationContext);
    }

    private static boolean needDownloadTbs(android.content.Context context) {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("com.tencent.smtt.sdk.TbsDownloader").getMethod("needDownload", android.content.Context.class);
            if (method != null) {
                method.setAccessible(true);
                return ((java.lang.Boolean) method.invoke(null, context)).booleanValue();
            }
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private static void preInit(android.content.Context context) {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("preInit", android.content.Context.class);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(null, context);
            }
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}
