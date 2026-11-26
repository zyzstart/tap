package com.tencent.ydkqmsp.sdk.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QmspSDK extends com.tencent.ydkqmsp.sdk.app.a {
    public static java.lang.String getQmspVer() {
        return com.tencent.ydkqmsp.sdk.a.c.d();
    }

    public static boolean getSDKIsAlive() {
        if (com.tencent.ydkqmsp.sdk.app.a.getTaskStatus()) {
            return com.tencent.ydkqmsp.sdk.app.b.e().a();
        }
        return false;
    }

    public static int sendCmdToLib(int i, int i2, int i3, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        return com.tencent.ydkqmsp.sdk.c.f.i().a(i, i2, i3, objArr, objArr2);
    }

    public static void setLogcat(boolean z) {
        com.tencent.ydkqmsp.sdk.f.g.a(z);
    }

    public static int startQmsp(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return com.tencent.ydkqmsp.sdk.app.a.login(context, str, str2, str3, str4);
    }

    public static int startQmsp(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.tencent.ydkqmsp.sdk.b.f fVar) {
        return com.tencent.ydkqmsp.sdk.app.a.login(context, str, str2, str3, str4, fVar);
    }

    public static void stopQmsp() {
        com.tencent.ydkqmsp.sdk.app.a.logout();
    }
}
