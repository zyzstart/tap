package com.tencent.ysdk.shell.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class PluginDownloadInfo {
    private java.lang.String mDownloadUrl;
    private int mMaxHostVersion;
    private int mMinHostVersion;
    private java.lang.String mPluginMd5;
    private int mPluginVersion;
    private int mRandomTime;

    public static class DownloadInfoBuilder {
        java.lang.String downloadUrl;
        int maxHostVersion;
        int minHostVersion;
        java.lang.String pluginMd5;
        int pluginVersion;
        int randomTime;

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo build() {
            return new com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo(this);
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setDownloadUrl(java.lang.String str) {
            this.downloadUrl = str;
            return this;
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setMaxHostVersion(int i) {
            this.maxHostVersion = i;
            return this;
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setMinHostVersion(int i) {
            this.minHostVersion = i;
            return this;
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setPluginMd5(java.lang.String str) {
            this.pluginMd5 = str;
            return this;
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setPluginVersion(int i) {
            this.pluginVersion = i;
            return this;
        }

        public com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder setRandomTime(int i) {
            this.randomTime = i;
            return this;
        }
    }

    public PluginDownloadInfo(com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder downloadInfoBuilder) {
        this.mMaxHostVersion = downloadInfoBuilder.maxHostVersion;
        this.mMinHostVersion = downloadInfoBuilder.minHostVersion;
        this.mPluginVersion = downloadInfoBuilder.pluginVersion;
        this.mPluginMd5 = downloadInfoBuilder.pluginMd5;
        this.mDownloadUrl = downloadInfoBuilder.downloadUrl;
        this.mRandomTime = downloadInfoBuilder.randomTime;
    }

    public boolean checkParam() {
        return (android.text.TextUtils.isEmpty(this.mDownloadUrl) || android.text.TextUtils.isEmpty(this.mPluginMd5)) ? false : true;
    }

    public java.lang.String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public int getMaxHostVersion() {
        return this.mMaxHostVersion;
    }

    public int getMinHostVersion() {
        return this.mMinHostVersion;
    }

    public java.lang.String getPluginMd5() {
        return this.mPluginMd5;
    }

    public int getPluginVersion() {
        return this.mPluginVersion;
    }

    public int getRandomTime() {
        return this.mRandomTime;
    }
}
