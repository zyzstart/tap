package com.tencent.bugly.crashreport.inner;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null || str2 == null || str3 == null) {
            com.tencent.bugly.proguard.x.e("post cocos2d-x fail args null", new java.lang.Object[0]);
        } else if (i != 5 && i != 6) {
            com.tencent.bugly.proguard.x.e("post cocos2d-x fail category illeagle: %d", java.lang.Integer.valueOf(i));
        } else {
            com.tencent.bugly.proguard.x.a("post cocos2d-x crash %s %s", str, str2);
            com.tencent.bugly.crashreport.crash.d.a(java.lang.Thread.currentThread(), i, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(java.lang.Thread thread, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null || str2 == null || str3 == null) {
            com.tencent.bugly.proguard.x.e("post h5 fail args null", new java.lang.Object[0]);
        } else {
            com.tencent.bugly.proguard.x.a("post h5 crash %s %s", str, str2);
            com.tencent.bugly.crashreport.crash.d.a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null || str2 == null || str3 == null) {
            com.tencent.bugly.proguard.x.e("post u3d fail args null", new java.lang.Object[0]);
        }
        com.tencent.bugly.proguard.x.a("post u3d crash %s %s", str, str2);
        com.tencent.bugly.crashreport.crash.d.a(java.lang.Thread.currentThread(), 4, str, str2, str3, null);
    }
}
