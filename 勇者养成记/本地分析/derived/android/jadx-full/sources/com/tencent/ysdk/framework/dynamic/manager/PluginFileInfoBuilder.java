package com.tencent.ysdk.framework.dynamic.manager;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginFileInfoBuilder {
    private java.lang.String mDownloadUrl;
    private java.lang.String mFileMd5;
    private java.lang.String mFilePath;
    private boolean mHasPreload = false;
    private int mMaxHostVersion;
    private int mMinHostVersion;
    private int mVersionCode;

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo build() {
        return new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo(this);
    }

    public java.lang.String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public java.lang.String getFileMd5() {
        return this.mFileMd5;
    }

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int getmMaxHostVersion() {
        return this.mMaxHostVersion;
    }

    public int getmMinHostVersion() {
        return this.mMinHostVersion;
    }

    public boolean isHasPreload() {
        return this.mHasPreload;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setDownloadUrl(java.lang.String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setFilePath(java.lang.String str) {
        this.mFilePath = str;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setHasPreload(boolean z) {
        this.mHasPreload = z;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setMaxHostVersion(int i) {
        this.mMaxHostVersion = i;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setMinHostVersion(int i) {
        this.mMinHostVersion = i;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setPluginMd5(java.lang.String str) {
        this.mFileMd5 = str;
        return this;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfoBuilder setPluginVersion(int i) {
        this.mVersionCode = i;
        return this;
    }
}
