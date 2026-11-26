package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DefaultNotch implements com.tencent.ysdk.shell.libware.device.notch.INotch {
    private static final java.lang.String TAG = "DefaultNotch";
    private com.tencent.ysdk.shell.libware.device.notch.NotchInfo mNotchInfo;

    @Override // com.tencent.ysdk.shell.libware.device.notch.INotch
    public com.tencent.ysdk.shell.libware.device.notch.NotchInfo getNotchInfo(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfo = this.mNotchInfo;
        if (notchInfo != null) {
            return notchInfo;
        }
        this.mNotchInfo = new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
        return this.mNotchInfo;
    }
}
