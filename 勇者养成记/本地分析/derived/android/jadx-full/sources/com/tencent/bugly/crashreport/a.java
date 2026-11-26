package com.tencent.bugly.crashreport;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface a {
    boolean appendLogToNative(java.lang.String str, java.lang.String str2, java.lang.String str3);

    java.lang.String getLogFromNative();

    boolean setNativeIsAppForeground(boolean z);
}
