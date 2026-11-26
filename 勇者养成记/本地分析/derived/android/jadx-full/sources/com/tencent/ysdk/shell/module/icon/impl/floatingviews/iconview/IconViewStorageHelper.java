package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconViewStorageHelper {
    private static final java.lang.String ICON_TAG = "YSDK_ICON_VIEW";
    private static final java.lang.String LOCATION_X_TAG = "YSDK_ICON_VIEW_X";
    private static final java.lang.String LOCATION_Y_TAG = "YSDK_ICON_VIEW_Y";
    private static final java.lang.String TAG = "IconViewStorageHelper";
    private static final java.lang.String TAG_ICON_CLOSE_COUNT = "YSDK_ICON_CLOSE_COUNT";
    private static final java.lang.String TAG_ICON_NO_MORE_TIPS = "YSDK_ICON_CLOSE_NO_MORE_TIPS";

    private IconViewStorageHelper() {
    }

    public static int getIconCloseCount(java.lang.String str) {
        java.lang.Object obj = com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.read(TAG_ICON_CLOSE_COUNT + str);
        if (obj instanceof java.lang.Integer) {
            return ((java.lang.Integer) obj).intValue();
        }
        return 0;
    }

    public static int getIconCloseTipMode(java.lang.String str) {
        java.lang.Object obj = com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.read(TAG_ICON_NO_MORE_TIPS + str);
        if (obj instanceof java.lang.Integer) {
            return ((java.lang.Integer) obj).intValue();
        }
        return -1;
    }

    public static int getLocationXFromStorage(java.lang.String str) {
        return readLocationFromStorage(LOCATION_X_TAG + str);
    }

    public static int getLocationYFromStorage(java.lang.String str) {
        return readLocationFromStorage(LOCATION_Y_TAG + str);
    }

    private static int readLocationFromStorage(java.lang.String str) {
        java.lang.Object obj = com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.read(str);
        if (obj instanceof java.lang.Integer) {
            return ((java.lang.Integer) obj).intValue();
        }
        return -1;
    }

    public static void saveIconCloseCount(java.lang.String str, int i) {
        com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.save(TAG_ICON_CLOSE_COUNT + str, java.lang.Integer.valueOf(i));
    }

    public static void saveIconTipsMode(java.lang.String str, int i) {
        com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.save(TAG_ICON_NO_MORE_TIPS + str, java.lang.Integer.valueOf(i));
    }

    private static void saveLocationInStorage(java.lang.String str, int i) {
        com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.save(str, java.lang.Integer.valueOf(i));
    }

    public static void updateIconViewLocation(java.lang.String str, int i, int i2) {
        saveLocationInStorage(LOCATION_X_TAG + str, i);
        saveLocationInStorage(LOCATION_Y_TAG + str, i2);
    }
}
