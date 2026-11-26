package com.tencent.tmassistantbase.kapalai;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MobileIssueSettings {
    public static boolean isHasShortcutUri = true;
    public static boolean isSupportDeleteContactGroup = true;
    public static boolean isSupportDualSimIMEI = true;
    public static boolean isSupportDualSimIMSI = true;
    public static boolean isSupportInsertContactGroup = true;
    public static int[] dualSimIMSISolutionNum = new int[2];
    public static int[] dualSimIMEISolutionNum = new int[2];
    public static int[] IMSISimPos = {-1, 1};
    public static int[] IMEIPos = {-1, 1};
    public static int[] CommonIMEIPos = {-1, 0, 1, 2};

    static {
        java.lang.String lowerCase = android.os.Build.MODEL.toLowerCase();
        java.lang.String lowerCase2 = android.os.Build.MANUFACTURER.toLowerCase();
        if (lowerCase2.indexOf("htc") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateHtcConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("samsung") >= 0 || lowerCase2.indexOf("samsng") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateSamSungConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("motorola") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateMotorolaConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("huawei") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateHuaWeiConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("hisense") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateHisenseConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("xiaomi") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateXiaomiConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("zte") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateZteConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("meizu") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateMeizuConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("alps") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateAlpsConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("oppo") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateOppoConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("k-touch") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateK_TouchConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("yulong") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateYulongConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("coolpad") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateCoolpadConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("lenovo") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateLenovoConfig(lowerCase);
            return;
        }
        if (lowerCase2.indexOf("bbk") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateBBKConfig(lowerCase);
        } else if (lowerCase2.indexOf("gionee") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateGioneeConfig(lowerCase);
        } else if (lowerCase2.indexOf("sony ericsson") >= 0) {
            com.tencent.tmassistantbase.kapalai.MobileModelConfig.getInstance().updateSonyConfig(lowerCase);
        }
    }
}
