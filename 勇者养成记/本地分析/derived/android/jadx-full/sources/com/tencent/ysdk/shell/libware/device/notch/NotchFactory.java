package com.tencent.ysdk.shell.libware.device.notch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NotchFactory {
    private static java.util.Map<java.lang.String, com.tencent.ysdk.shell.libware.device.notch.INotch> sINotchMap = new java.util.HashMap();
    private static final java.lang.String HW_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.HuaweiNotch.class.getName();
    private static final java.lang.String MZ_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.MeizuNotch.class.getName();
    private static final java.lang.String OP_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.OppoNotch.class.getName();
    private static final java.lang.String VO_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.VivoNotch.class.getName();
    private static final java.lang.String XM_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.XiaomiNotch.class.getName();
    private static final java.lang.String DEFAULT_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.DefaultNotch.class.getName();
    private static final java.lang.String ANDROID_P_NOTCH = com.tencent.ysdk.shell.libware.device.notch.brands.AndroidPNotch.class.getName();

    private NotchFactory() {
    }

    public static com.tencent.ysdk.shell.libware.device.notch.INotch getAndroidPNotch() {
        if (sINotchMap.containsKey(ANDROID_P_NOTCH)) {
            return sINotchMap.get(ANDROID_P_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.AndroidPNotch androidPNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.AndroidPNotch();
        sINotchMap.put(ANDROID_P_NOTCH, androidPNotch);
        return androidPNotch;
    }

    public static com.tencent.ysdk.shell.libware.device.notch.INotch getDeviceNotch() {
        if (com.tencent.ysdk.shell.libware.device.RomUtils.isHuawei()) {
            return getHWNotch();
        }
        if (com.tencent.ysdk.shell.libware.device.RomUtils.isMeizu()) {
            return getMeizuNotch();
        }
        if (com.tencent.ysdk.shell.libware.device.RomUtils.isOppo()) {
            return getOppoNotch();
        }
        if (com.tencent.ysdk.shell.libware.device.RomUtils.isVivo()) {
            return getVivoNotch();
        }
        if (com.tencent.ysdk.shell.libware.device.RomUtils.isXiaomi()) {
            return getXiaomiNotch();
        }
        if (sINotchMap.containsKey(DEFAULT_NOTCH)) {
            return sINotchMap.get(DEFAULT_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.DefaultNotch defaultNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.DefaultNotch();
        sINotchMap.put(DEFAULT_NOTCH, defaultNotch);
        return defaultNotch;
    }

    private static com.tencent.ysdk.shell.libware.device.notch.INotch getHWNotch() {
        if (sINotchMap.containsKey(HW_NOTCH)) {
            return sINotchMap.get(HW_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.HuaweiNotch huaweiNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.HuaweiNotch();
        sINotchMap.put(HW_NOTCH, huaweiNotch);
        return huaweiNotch;
    }

    private static com.tencent.ysdk.shell.libware.device.notch.INotch getMeizuNotch() {
        if (sINotchMap.containsKey(MZ_NOTCH)) {
            return sINotchMap.get(MZ_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.MeizuNotch meizuNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.MeizuNotch();
        sINotchMap.put(MZ_NOTCH, meizuNotch);
        return meizuNotch;
    }

    private static com.tencent.ysdk.shell.libware.device.notch.INotch getOppoNotch() {
        if (sINotchMap.containsKey(OP_NOTCH)) {
            return sINotchMap.get(OP_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.OppoNotch oppoNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.OppoNotch();
        sINotchMap.put(OP_NOTCH, oppoNotch);
        return oppoNotch;
    }

    private static com.tencent.ysdk.shell.libware.device.notch.INotch getVivoNotch() {
        if (sINotchMap.containsKey(VO_NOTCH)) {
            return sINotchMap.get(VO_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.VivoNotch vivoNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.VivoNotch();
        sINotchMap.put(VO_NOTCH, vivoNotch);
        return vivoNotch;
    }

    private static com.tencent.ysdk.shell.libware.device.notch.INotch getXiaomiNotch() {
        if (sINotchMap.containsKey(XM_NOTCH)) {
            return sINotchMap.get(XM_NOTCH);
        }
        com.tencent.ysdk.shell.libware.device.notch.brands.XiaomiNotch xiaomiNotch = new com.tencent.ysdk.shell.libware.device.notch.brands.XiaomiNotch();
        sINotchMap.put(XM_NOTCH, xiaomiNotch);
        return xiaomiNotch;
    }
}
