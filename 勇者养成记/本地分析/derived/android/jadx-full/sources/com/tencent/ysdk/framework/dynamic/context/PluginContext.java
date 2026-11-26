package com.tencent.ysdk.framework.dynamic.context;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginContext extends android.view.ContextThemeWrapper {
    private android.content.Context mHostContext;
    private android.content.pm.ApplicationInfo mPluginApplicationInfo;
    private java.lang.ClassLoader mPluginClassLoader;
    private com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo mPluginFileInfo;
    private android.content.res.Resources mPluginResources;
    private android.content.res.Resources.Theme mPluginTheme;

    public PluginContext(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo, java.lang.ClassLoader classLoader) {
        super(context, 0);
        this.mHostContext = context;
        this.mPluginFileInfo = pluginFileInfo;
        this.mPluginClassLoader = classLoader;
        android.content.res.Resources resourcesCreateResources = createResources(pluginFileInfo.getFilePath(), context);
        this.mPluginResources = resourcesCreateResources;
        this.mPluginTheme = getPluginTheme(resourcesCreateResources);
    }

    private android.content.res.Resources createResources(java.lang.String str, android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 128);
            packageArchiveInfo.applicationInfo.publicSourceDir = str;
            packageArchiveInfo.applicationInfo.sourceDir = str;
            return packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private int getInnerRIdValue(java.lang.String str) {
        try {
            java.lang.String strSubstring = str.substring(0, str.indexOf(".R.") + 2);
            int iLastIndexOf = str.lastIndexOf(".");
            java.lang.String strSubstring2 = str.substring(iLastIndexOf + 1, str.length());
            java.lang.String strSubstring3 = str.substring(0, iLastIndexOf);
            return java.lang.Class.forName(strSubstring + "$" + strSubstring3.substring(strSubstring3.lastIndexOf(".") + 1, strSubstring3.length())).getDeclaredField(strSubstring2).getInt(null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    private android.content.res.Resources.Theme getPluginTheme(android.content.res.Resources resources) {
        if (resources == null) {
            return null;
        }
        android.content.res.Resources.Theme themeNewTheme = resources.newTheme();
        themeNewTheme.applyStyle(getInnerRIdValue("com.android.internal.R.style.Theme"), true);
        return themeNewTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context getApplicationContext() {
        return this.mHostContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.pm.ApplicationInfo getApplicationInfo() {
        android.content.pm.PackageInfo packageArchiveInfo;
        if (this.mPluginApplicationInfo == null && (packageArchiveInfo = this.mHostContext.getPackageManager().getPackageArchiveInfo(this.mPluginFileInfo.getFilePath(), 0)) != null) {
            this.mPluginApplicationInfo = packageArchiveInfo.applicationInfo;
        }
        if (this.mPluginApplicationInfo == null) {
            this.mPluginApplicationInfo = this.mHostContext.getApplicationInfo();
        }
        return this.mPluginApplicationInfo;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return this.mPluginResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getCacheDir() {
        return super.getDir("plugin_cache_com.tencent.ysdkcore", 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.ClassLoader getClassLoader() {
        java.lang.ClassLoader classLoader = this.mPluginClassLoader;
        return classLoader != null ? classLoader : super.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDir(java.lang.String str, int i) {
        return super.getDir("plugin_dir_com.tencent.ysdkcore_" + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getFilesDir() {
        return super.getDir("plugin_files_com.tencent.ysdkcore", 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getOpPackageName() {
        return (java.lang.String) com.tencent.ysdk.framework.dynamic.utils.Reflect.on(this.mHostContext).call("getOpPackageName").get();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getPackageCodePath() {
        return this.mPluginFileInfo.getFilePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getPackageName() {
        return "com.tencent.ysdkcore";
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return this.mPluginResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.SharedPreferences getSharedPreferences(java.lang.String str, int i) {
        return super.getSharedPreferences("plugin_prefs_com.tencent.ysdkcore_" + str, i);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme = this.mPluginTheme;
        return theme != null ? theme : super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.FileOutputStream openFileOutput(java.lang.String str, int i) {
        return super.openFileOutput("plugin_output_" + str, i);
    }
}
