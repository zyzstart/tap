package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AbstractCommonNotch implements com.tencent.ysdk.shell.libware.device.notch.INotch {
    protected static final java.lang.String TAG = "AbstractCommonNotch";
    protected com.tencent.ysdk.shell.libware.device.notch.NotchInfo mNotchInfo;

    protected android.graphics.Rect generateCommonRect(android.content.Context context, int i, int i2) {
        int orientation = com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(context);
        int screenWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(context);
        int screenHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenHeight(context);
        android.graphics.Rect rect = new android.graphics.Rect();
        if (orientation == 1) {
            rect.left = (screenWidth - i) / 2;
            rect.top = 0;
            rect.right = rect.left + i;
            rect.bottom = i2;
        } else if (orientation == 2) {
            rect.left = 0;
            rect.top = (screenHeight - i2) / 2;
            rect.right = i;
            rect.bottom = rect.top + i2;
        }
        return rect;
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.INotch
    public com.tencent.ysdk.shell.libware.device.notch.NotchInfo getNotchInfo(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfo = this.mNotchInfo;
        if (notchInfo != null) {
            return notchInfo;
        }
        try {
            if (hasNotch(context)) {
                this.mNotchInfo = new com.tencent.ysdk.shell.libware.device.notch.NotchInfo(getNotchRect(context));
            } else {
                this.mNotchInfo = new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
            }
            return this.mNotchInfo;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            this.mNotchInfo = new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
            return this.mNotchInfo;
        }
    }

    protected abstract android.graphics.Rect getNotchRect(android.content.Context context) throws java.lang.Exception;

    protected abstract boolean hasNotch(android.content.Context context) throws java.lang.Exception;
}
