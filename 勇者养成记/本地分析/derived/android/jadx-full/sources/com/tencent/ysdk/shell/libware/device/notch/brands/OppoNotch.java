package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class OppoNotch extends com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch {
    private static java.lang.String getScreenValue() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
        return (java.lang.String) cls.getMethod("get", java.lang.String.class).invoke(cls.newInstance(), "ro.oppo.screen.heteromorphism");
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected android.graphics.Rect getNotchRect(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.String screenValue = getScreenValue();
        if (android.text.TextUtils.isEmpty(screenValue)) {
            return null;
        }
        java.lang.String[] strArrSplit = screenValue.split(":");
        java.lang.String[] strArrSplit2 = strArrSplit[0].split(",");
        java.lang.String[] strArrSplit3 = strArrSplit[1].split(",");
        android.graphics.Rect rect = new android.graphics.Rect();
        int orientation = com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(context);
        if (orientation == 2) {
            rect.left = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit2[0], 0);
            rect.top = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit2[1], 0);
            rect.right = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit3[0], 0);
            rect.bottom = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit3[1], 0);
        } else if (orientation == 1) {
            rect.left = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit2[1], 0);
            rect.top = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit2[0], 0);
            rect.right = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit3[1], 0);
            rect.bottom = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(strArrSplit3[0], 0);
        }
        return rect;
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected boolean hasNotch(android.content.Context context) throws java.lang.Exception {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
