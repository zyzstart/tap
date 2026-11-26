package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MeizuNotch extends com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch {
    private int getNotchHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("fringe_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private int getNotchWidth(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("fringe_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected android.graphics.Rect getNotchRect(android.content.Context context) {
        return generateCommonRect(context, getNotchWidth(context), getNotchHeight(context));
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected boolean hasNotch(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException {
        return ((java.lang.Boolean) java.lang.Class.forName("flyme.config.FlymeFeature").getDeclaredField("IS_FRINGE_DEVICE").get(null)).booleanValue();
    }
}
