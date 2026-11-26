package com.tencent.msdk.dns.core.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IRemoteConfigProvider {
    boolean getBool(java.lang.String str, boolean z);

    double getDouble(java.lang.String str, double d);

    int getInt(java.lang.String str, int i);

    long getLong(java.lang.String str, long j);

    java.lang.String getString(java.lang.String str, java.lang.String str2);
}
