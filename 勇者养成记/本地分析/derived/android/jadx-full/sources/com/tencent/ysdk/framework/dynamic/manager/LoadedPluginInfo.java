package com.tencent.ysdk.framework.dynamic.manager;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LoadedPluginInfo {
    private java.lang.ClassLoader mClassLoader;
    private android.content.Context mHostContext;
    public android.content.Context mPluginContext;
    private com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo mPluginFileInfo;

    public LoadedPluginInfo(android.content.Context context, android.content.Context context2, java.lang.ClassLoader classLoader, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        this.mHostContext = context;
        this.mPluginContext = context2;
        this.mClassLoader = classLoader;
        this.mPluginFileInfo = pluginFileInfo;
    }

    public java.lang.ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo getPluginFileInfo() {
        return this.mPluginFileInfo;
    }
}
