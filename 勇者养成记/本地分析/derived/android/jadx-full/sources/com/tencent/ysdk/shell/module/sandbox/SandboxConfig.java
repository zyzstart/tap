package com.tencent.ysdk.shell.module.sandbox;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SandboxConfig {
    public static final java.lang.String ENV = "sandbox";
    public static final java.lang.String PIN = "Y@7wmy9$Mj";
    public static final java.lang.String TAG = "sandbox";
    private static boolean isSandboxEnv = false;
    private static boolean sIsLogin = false;
    private static java.lang.String sMidasKey = "";
    private static java.lang.String sOfferId = "";
    private static java.lang.String sPackageName = "";
    private static java.lang.String sSessionId = "";
    private static java.lang.String sSessionType = "";

    public static java.lang.String getMidasKey() {
        return sMidasKey;
    }

    public static java.lang.String getOfferId() {
        return sOfferId;
    }

    public static java.lang.String getPackageName() {
        return sPackageName;
    }

    public static java.lang.String getSessionId() {
        return sSessionId;
    }

    public static java.lang.String getSessionType() {
        return sSessionType;
    }

    public static boolean isLogin() {
        return sIsLogin;
    }

    public static boolean isSandboxEnv() {
        return isSandboxEnv;
    }

    public static void setLogin(boolean z) {
        sIsLogin = z;
    }

    public static void setMidasKey(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d("sandbox", "setMidasKey: " + str);
        sMidasKey = str;
    }

    public static void setOfferId(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d("sandbox", "setOfferId: " + str);
        sOfferId = str;
    }

    public static void setPackageName(java.lang.String str) {
        sPackageName = str;
    }

    public static void setSandBoxEnv() {
        isSandboxEnv = true;
    }

    public static void setSessionId(java.lang.String str) {
        sSessionId = str;
    }

    public static void setSessionType(java.lang.String str) {
        sSessionType = str;
    }
}
