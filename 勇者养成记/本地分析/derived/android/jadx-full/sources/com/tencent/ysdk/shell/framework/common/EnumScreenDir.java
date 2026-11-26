package com.tencent.ysdk.shell.framework.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum EnumScreenDir {
    SENSOR(0),
    PORTRAIT(1),
    LANDSCAPE(2);

    int value;

    EnumScreenDir(int i) {
        this.value = 0;
        this.value = i;
    }

    public static com.tencent.ysdk.shell.framework.common.EnumScreenDir getEnum(int i) {
        switch (i) {
            case 0:
                return SENSOR;
            case 1:
                return PORTRAIT;
            case 2:
                return LANDSCAPE;
            default:
                com.tencent.ysdk.libware.file.Logger.w("bad screen dir :" + i);
                return SENSOR;
        }
    }

    public static com.tencent.ysdk.shell.framework.common.EnumScreenDir getEnum(android.content.pm.ActivityInfo activityInfo) {
        if (isLandscape(activityInfo)) {
            return LANDSCAPE;
        }
        return isPortrait(activityInfo) ? PORTRAIT : SENSOR;
    }

    public static com.tencent.ysdk.shell.framework.common.EnumScreenDir getEnum(android.content.res.Configuration configuration) {
        if (configuration.orientation == 2) {
            return LANDSCAPE;
        }
        return configuration.orientation == 1 ? PORTRAIT : SENSOR;
    }

    private static boolean isLandscape(android.content.pm.ActivityInfo activityInfo) {
        return activityInfo != null && (activityInfo.screenOrientation == 0 || activityInfo.screenOrientation == 8 || activityInfo.screenOrientation == 6 || activityInfo.screenOrientation == 11);
    }

    private static boolean isPortrait(android.content.pm.ActivityInfo activityInfo) {
        return activityInfo != null && (activityInfo.screenOrientation == 1 || activityInfo.screenOrientation == 7 || activityInfo.screenOrientation == 9 || activityInfo.screenOrientation == 12);
    }

    public int val() {
        return this.value;
    }
}
