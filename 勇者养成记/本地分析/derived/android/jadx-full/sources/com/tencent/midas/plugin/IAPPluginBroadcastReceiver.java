package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAPPluginBroadcastReceiver {
    void IInit(java.lang.String str, java.lang.String str2, android.content.BroadcastReceiver broadcastReceiver, java.lang.ClassLoader classLoader, android.content.pm.PackageInfo packageInfo, boolean z);

    void IOnReceive(android.content.Context context, android.content.Intent intent);
}
