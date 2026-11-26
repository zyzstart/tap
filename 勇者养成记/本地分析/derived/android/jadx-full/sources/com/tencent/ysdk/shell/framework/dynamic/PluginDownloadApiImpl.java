package com.tencent.ysdk.shell.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginDownloadApiImpl implements com.tencent.ysdk.framework.dynamic.manager.IPluginDownloadApi {
    private static com.tencent.ysdk.framework.dynamic.manager.IPluginDownloadApi instance;

    public static com.tencent.ysdk.framework.dynamic.manager.IPluginDownloadApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.dynamic.PluginDownloadApiImpl.class) {
                instance = new com.tencent.ysdk.shell.framework.dynamic.PluginDownloadApiImpl();
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.framework.dynamic.manager.IPluginDownloadApi
    public void pluginOdex(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.getInstance().pluginOdex(context, pluginFileInfo);
    }
}
