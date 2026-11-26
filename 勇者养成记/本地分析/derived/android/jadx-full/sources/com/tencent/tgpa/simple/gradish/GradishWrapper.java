package com.tencent.tgpa.simple.gradish;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GradishWrapper {
    private static final java.lang.String TAG = "TGPA";
    private static boolean isSupportGradishWrapper = false;
    private static java.lang.String uniqueID;
    private static java.lang.String uniqueIDL2;

    static {
        try {
            java.lang.System.loadLibrary("gradishwrapper");
            isSupportGradishWrapper = true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            android.util.Log.e(TAG, "load gradish wrapper lib failed!!!");
        }
    }

    private static native synchronized java.lang.String dbg();

    public static java.lang.String getCommonUniqueID() {
        if (android.os.Build.VERSION.SDK_INT < 21 && qfc.y.a("android.permission.READ_PHONE_STATE")) {
            return getCommonUniqueIDL2();
        }
        if (uniqueID == null) {
            produceIDL1(qfc.v.U);
        }
        return uniqueID;
    }

    public static java.lang.String getCommonUniqueID2WithoutFlag() {
        if (!isGradishEnable()) {
            return "-13";
        }
        java.lang.String commonUniqueIDL2 = getCommonUniqueIDL2();
        if (commonUniqueIDL2 == null) {
            return "-11";
        }
        return commonUniqueIDL2.length() != 66 ? "-12" : commonUniqueIDL2.substring(2);
    }

    public static java.lang.String getCommonUniqueIDL2() {
        if (uniqueIDL2 == null) {
            produceIDL2(qfc.v.U);
        }
        return uniqueIDL2;
    }

    public static java.lang.String getCommonUniqueIDWithoutFlag() {
        if (!isGradishEnable()) {
            return "-13";
        }
        java.lang.String commonUniqueID = getCommonUniqueID();
        if (commonUniqueID == null) {
            return "-11";
        }
        return commonUniqueID.length() != 66 ? "-12" : commonUniqueID.substring(2);
    }

    public static java.lang.String getDebugID() {
        return !isGradishDebugIDEnable() ? "-13" : dbg();
    }

    public static java.lang.String getFlag1() {
        java.lang.String commonUniqueID = getCommonUniqueID();
        return (commonUniqueID == null || commonUniqueID.length() != 66) ? "-1" : commonUniqueID.substring(0, 1);
    }

    public static java.lang.String getFlag2() {
        java.lang.String commonUniqueID = getCommonUniqueID();
        return (commonUniqueID == null || commonUniqueID.length() != 66) ? "-1" : commonUniqueID.substring(1, 2);
    }

    public static java.lang.String getFlagL2() {
        java.lang.String commonUniqueIDL2 = getCommonUniqueIDL2();
        return (commonUniqueIDL2 == null || commonUniqueIDL2.length() != 66) ? "-1" : commonUniqueIDL2.substring(0, 2);
    }

    public static java.lang.String getOAID(int i) {
        return !isGradishEnable() ? "-13" : goa(qfc.v.U, i);
    }

    private static native synchronized java.lang.String goa(android.content.Context context, int i);

    public static boolean isGradishDebugIDEnable() {
        return qfc.d.b().n.s;
    }

    public static boolean isGradishEnable() {
        return qfc.d.b().n.s;
    }

    private static void produceIDL1(android.content.Context context) {
        if (uniqueID == null) {
            uniqueID = yje(context);
        }
    }

    private static void produceIDL2(android.content.Context context) {
        if (uniqueIDL2 == null) {
            uniqueIDL2 = zkf(context);
        }
    }

    private static native synchronized java.lang.String yje(android.content.Context context);

    private static native synchronized java.lang.String zkf(android.content.Context context);
}
