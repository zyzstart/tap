package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface l {
    java.lang.String getAppFirstInstallTime();

    java.lang.String getEventSerialNumber(java.lang.String str, java.lang.String str2, boolean z);

    void incCommonEventCalls();

    void incCommonEventWriteSucc(int i);

    void incRealTimeEventCalls();

    void incRealTimeEventUploadSucc(int i);

    void incRealTimeEventWriteSucc(int i);

    void record(int i, boolean z, long j, long j2, int i2, int i3, java.lang.String str, java.lang.String str2, int i4, java.lang.String str3);
}
