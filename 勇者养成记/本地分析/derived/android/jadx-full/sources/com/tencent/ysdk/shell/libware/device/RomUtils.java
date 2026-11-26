package com.tencent.ysdk.shell.libware.device;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RomUtils {
    private static final java.lang.String UNKNOWN = "unknown";
    private static final java.lang.String[] ROM_HUAWEI = {"huawei"};
    private static final java.lang.String[] ROM_VIVO = {"vivo"};
    private static final java.lang.String[] ROM_XIAOMI = {"xiaomi"};
    private static final java.lang.String[] ROM_OPPO = {"oppo"};
    private static final java.lang.String[] ROM_MEIZU = {"meizu"};
    private static java.lang.String mRomInfo = null;

    private RomUtils() {
    }

    private static java.lang.String getBrand() {
        try {
            java.lang.String str = android.os.Build.BRAND;
            return !android.text.TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (java.lang.Throwable unused) {
            return "unknown";
        }
    }

    private static java.lang.String getManufacturer() {
        try {
            java.lang.String str = android.os.Build.MANUFACTURER;
            return !android.text.TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (java.lang.Throwable unused) {
            return "unknown";
        }
    }

    public static java.lang.String getRomInfo() {
        if (!android.text.TextUtils.isEmpty(mRomInfo)) {
            return mRomInfo;
        }
        java.lang.String brand = getBrand();
        java.lang.String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, ROM_HUAWEI)) {
            mRomInfo = ROM_HUAWEI[0];
            return mRomInfo;
        }
        if (isRightRom(brand, manufacturer, ROM_VIVO)) {
            mRomInfo = ROM_VIVO[0];
            return mRomInfo;
        }
        if (isRightRom(brand, manufacturer, ROM_XIAOMI)) {
            mRomInfo = ROM_XIAOMI[0];
            return mRomInfo;
        }
        if (isRightRom(brand, manufacturer, ROM_OPPO)) {
            mRomInfo = ROM_OPPO[0];
            return mRomInfo;
        }
        if (isRightRom(brand, manufacturer, ROM_MEIZU)) {
            mRomInfo = ROM_MEIZU[0];
            return mRomInfo;
        }
        mRomInfo = brand;
        return mRomInfo;
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI[0].equals(getRomInfo());
    }

    public static boolean isMeizu() {
        return ROM_MEIZU[0].equals(getRomInfo());
    }

    public static boolean isOppo() {
        return ROM_OPPO[0].equals(getRomInfo());
    }

    private static boolean isRightRom(java.lang.String str, java.lang.String str2, java.lang.String... strArr) {
        for (java.lang.String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVivo() {
        return ROM_VIVO[0].equals(getRomInfo());
    }

    public static boolean isXiaomi() {
        return ROM_XIAOMI[0].equals(getRomInfo());
    }
}
