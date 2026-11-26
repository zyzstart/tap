package com.tencent.ysdk.framework.dynamic.manager;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginFileInfo implements java.io.Serializable {
    public static final java.lang.String PACKAGE_NAME = "com.tencent.ysdkcore";
    public static final java.lang.String PLUGIN_NAME = "ysdkcore-debug";
    private java.lang.String mDexPath;
    private java.lang.String mDownloadUrl;
    private java.lang.String mFileMd5;
    private java.lang.String mFilePath;
    private boolean mHasPreload;
    private java.lang.String mLibPath;
    private int mMaxHostVersion;
    private int mMinHostVersion;
    private int mVersionCode;

    public PluginFileInfo() {
        this.mHasPreload = false;
    }

    PluginFileInfo(com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder pluginFileInfoBuilder) {
        this.mHasPreload = false;
        this.mMaxHostVersion = pluginFileInfoBuilder.getmMaxHostVersion();
        this.mMinHostVersion = pluginFileInfoBuilder.getmMinHostVersion();
        this.mVersionCode = pluginFileInfoBuilder.getVersionCode();
        this.mFileMd5 = pluginFileInfoBuilder.getFileMd5();
        this.mFilePath = pluginFileInfoBuilder.getFilePath();
        this.mLibPath = com.tencent.ysdk.framework.dynamic.manager.PluginManager.makePluginDir(this.mVersionCode, "lib");
        this.mDexPath = com.tencent.ysdk.framework.dynamic.manager.PluginManager.makePluginDir(this.mVersionCode, "dex");
        this.mDownloadUrl = pluginFileInfoBuilder.getDownloadUrl();
        this.mHasPreload = pluginFileInfoBuilder.isHasPreload();
    }

    public java.lang.String getDexPath() {
        return this.mDexPath;
    }

    public java.lang.String getFileMd5() {
        return this.mFileMd5;
    }

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public java.lang.String getLibPath() {
        return this.mLibPath;
    }

    public int getMaxHostVersion() {
        return this.mMaxHostVersion;
    }

    public int getMinHostVersion() {
        return this.mMinHostVersion;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isHasPreload() {
        return this.mHasPreload;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo readFromSp(android.content.SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "readFromSp sp null");
            return null;
        }
        if (!sharedPreferences.contains("com.tencent.ysdkcore")) {
            return null;
        }
        java.lang.String string = sharedPreferences.getString("com.tencent.ysdkcore", "");
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        java.lang.String[] strArrSplit = string.split(";");
        this.mMaxHostVersion = java.lang.Integer.parseInt(strArrSplit[0]);
        this.mMinHostVersion = java.lang.Integer.parseInt(strArrSplit[1]);
        this.mVersionCode = java.lang.Integer.parseInt(strArrSplit[2]);
        this.mFilePath = strArrSplit[3];
        this.mFileMd5 = strArrSplit[4];
        this.mDownloadUrl = strArrSplit[5];
        this.mHasPreload = java.lang.Boolean.parseBoolean(strArrSplit[6]);
        this.mLibPath = strArrSplit[7];
        this.mDexPath = strArrSplit[8];
        return this;
    }

    public void setPreload(boolean z) {
        this.mHasPreload = z;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "PluginInfo{pluginName='ysdkcore-debug', packageName='com.tencent.ysdkcore', versionCode=" + this.mVersionCode + ", filePath='" + this.mFilePath + "', fileMd5='" + this.mFileMd5 + "', downloadUrl='" + this.mDownloadUrl + "', hasPreload=" + this.mHasPreload + '}';
    }

    public void writeToSp(android.content.SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("com.tencent.ysdkcore", this.mMaxHostVersion + ";" + this.mMinHostVersion + ";" + this.mVersionCode + ";" + this.mFilePath + ";" + this.mFileMd5 + ";" + this.mDownloadUrl + ";" + this.mHasPreload + ";" + this.mLibPath + ";" + this.mDexPath).commit();
    }
}
