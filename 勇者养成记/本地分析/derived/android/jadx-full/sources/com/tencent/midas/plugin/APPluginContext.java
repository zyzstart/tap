package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class APPluginContext extends android.view.ContextThemeWrapper {
    private android.content.res.AssetManager mAsset;
    private java.lang.ClassLoader mClassLoader;
    private android.content.res.Resources mResources;
    private android.content.res.Resources.Theme mTheme;
    private int mThemeResId;

    public APPluginContext(android.content.Context context, int i, java.lang.String str, java.lang.ClassLoader classLoader) {
        this(context, i, str, classLoader, null);
    }

    public APPluginContext(android.content.Context context, int i, java.lang.String str, java.lang.ClassLoader classLoader, android.content.res.Resources resources) {
        super(context, i);
        this.mAsset = null;
        this.mResources = null;
        this.mTheme = null;
        this.mClassLoader = classLoader;
        com.tencent.midas.comm.APLog.i("APPluginContext", "APPluginContext mClassLoader:" + this.mClassLoader + " apkPath:" + str);
        if (resources != null) {
            this.mAsset = resources.getAssets();
            com.tencent.midas.comm.APLog.i("APPluginContext", "APPluginActivity APPluginContext 1 mAsset:" + this.mAsset);
            this.mResources = resources;
        } else {
            android.content.res.AssetManager selfAssets = getSelfAssets(context, str);
            this.mAsset = selfAssets;
            this.mResources = getSelfRes(context, selfAssets);
            com.tencent.midas.comm.APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
        }
        this.mTheme = getSelfTheme(this.mResources);
    }

    private static java.lang.String getApplicationPackageName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? packageManager.getPackageInfo(context.getPackageName(), 0).packageName : "";
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e.toString());
            return "";
        }
    }

    private int getInnerRIdValue(java.lang.String str) {
        int i = -1;
        try {
            java.lang.String strSubstring = str.substring(0, str.indexOf(".R.") + 2);
            int iLastIndexOf = str.lastIndexOf(".");
            java.lang.String strSubstring2 = str.substring(iLastIndexOf + 1, str.length());
            java.lang.String strSubstring3 = str.substring(0, iLastIndexOf);
            java.lang.String str2 = strSubstring + "$" + strSubstring3.substring(strSubstring3.lastIndexOf(".") + 1, strSubstring3.length());
            i = java.lang.Class.forName(str2).getDeclaredField(strSubstring2).getInt(null);
            com.tencent.midas.comm.APLog.i("APPluginContext", "getInnderR rStrnig:" + strSubstring3 + ", className:" + str2 + ", fieldName:" + strSubstring2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    private android.content.res.AssetManager getSelfAssets(android.content.Context context, java.lang.String str) {
        android.content.res.AssetManager assetManager;
        boolean z;
        boolean zEquals;
        try {
            assetManager = (android.content.res.AssetManager) android.content.res.AssetManager.class.newInstance();
            try {
                try {
                    java.lang.Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new java.lang.Class[0]);
                    z = true;
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e.toString());
                    z = false;
                }
                if (!z) {
                    try {
                        java.lang.Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new java.lang.Class[0]);
                        z = true;
                    } catch (java.lang.Exception e2) {
                        com.tencent.midas.comm.APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e2.toString());
                        z = false;
                    }
                }
                try {
                    zEquals = "com.tencent.weread".equals(getApplicationPackageName(context));
                } catch (java.lang.Exception unused) {
                    zEquals = false;
                }
                if (z || zEquals) {
                    java.util.ArrayList midasEmptyPaht = com.tencent.midas.plugin.APPluginUtils.getMidasEmptyPaht(context);
                    com.tencent.midas.comm.APLog.i("APPluginContext", "loadEmptyResAPK emptyList.size:" + midasEmptyPaht.size());
                    for (int i = 0; i < midasEmptyPaht.size(); i++) {
                        java.lang.String str2 = (java.lang.String) midasEmptyPaht.get(i);
                        com.tencent.midas.comm.APLog.i("APPluginContext", "loadEmptyResAPK emptyResFirstPath:" + str2);
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            com.tencent.midas.comm.APLog.i("APPluginContext", "loadEmptyResAPK id:" + ((java.lang.Integer) android.content.res.AssetManager.class.getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assetManager, str2)).intValue());
                        }
                    }
                }
                android.content.res.AssetManager.class.getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assetManager, str);
            } catch (java.lang.Throwable th) {
                th = th;
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            assetManager = null;
        }
        return assetManager;
    }

    private android.content.res.Resources getSelfRes(android.content.Context context, android.content.res.AssetManager assetManager) {
        return new android.content.res.Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    private android.content.res.Resources.Theme getSelfTheme(android.content.res.Resources resources) {
        android.content.res.Resources.Theme themeNewTheme = resources.newTheme();
        int innerRIdValue = getInnerRIdValue("com.android.internal.R.style.Theme");
        this.mThemeResId = innerRIdValue;
        themeNewTheme.applyStyle(innerRIdValue, true);
        return themeNewTheme;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return this.mAsset;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.ClassLoader getClassLoader() {
        java.lang.ClassLoader classLoader = this.mClassLoader;
        return classLoader != null ? classLoader : super.getClassLoader();
    }

    public android.content.res.Resources getRes() {
        return this.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return this.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        return this.mTheme;
    }

    public void setClassLoader(java.lang.ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }
}
