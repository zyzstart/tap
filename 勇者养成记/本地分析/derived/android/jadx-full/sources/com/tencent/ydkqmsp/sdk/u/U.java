package com.tencent.ydkqmsp.sdk.u;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class U {
    public static final java.lang.String BEACON_ID_VERSION = "4.1";
    public static final java.lang.String COMMIT_HASH = "[REDACTED_HEX_CONSTANT]";

    static {
        try {
            java.lang.System.loadLibrary("ydkqmp");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            load_so();
        }
    }

    public static native java.lang.String a(android.content.Context context, int i, android.app.Activity activity, java.lang.String str);

    public static native java.lang.String[] c(int i);

    public static void clearContent(android.content.Context context) {
        com.tencent.ydkqmsp.sdk.base.e.a(context);
    }

    public static void getOAID(com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        new com.tencent.ydkqmsp.sdk.base.e().a(iVendorCallback);
    }

    public static java.lang.String getOAIDSync(android.content.Context context) {
        return com.tencent.ydkqmsp.sdk.base.e.a(context, (java.lang.String) null, 0);
    }

    private static java.lang.String getP() {
        try {
            return (java.lang.String) java.lang.Class.forName("com.tencent.ydkbeacon.event.open.BeaconReport").getDeclaredMethod("getSoPath", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean getSDKIsAlive() {
        return com.tencent.ydkqmsp.sdk.app.QmspSDK.getSDKIsAlive();
    }

    public static void init_o(android.content.Context context, boolean z, boolean z2) {
        com.tencent.ydkqmsp.sdk.base.e.a(context, z, z2);
    }

    private static boolean load_so() {
        java.lang.String p = getP();
        try {
            if (android.text.TextUtils.isEmpty(p)) {
                return false;
            }
            java.lang.System.load(p);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void setUserID(java.lang.String str) {
        com.tencent.ydkqmsp.sdk.app.a.setmUid(str);
    }

    public static int startQ(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z) {
        com.tencent.ydkqmsp.sdk.app.QmspSDK.setLogcat(z);
        return com.tencent.ydkqmsp.sdk.app.QmspSDK.startQmsp(context, str, str2, str3, str4);
    }

    public static void stopQ() {
        com.tencent.ydkqmsp.sdk.app.QmspSDK.stopQmsp();
    }
}
