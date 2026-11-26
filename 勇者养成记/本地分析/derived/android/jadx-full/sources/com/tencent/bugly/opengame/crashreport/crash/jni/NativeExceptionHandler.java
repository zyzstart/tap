package com.tencent.bugly.opengame.crashreport.crash.jni;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface NativeExceptionHandler {
    void handleNativeException(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, java.lang.String str5, int i4, int i5, int i6, java.lang.String str6, java.lang.String str7);

    void handleNativeException2(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, java.lang.String str5, int i4, int i5, int i6, java.lang.String str6, java.lang.String str7, java.lang.String[] strArr);

    com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean packageCrashDatas(java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, byte[] bArr, java.util.Map map, boolean z, boolean z2);
}
