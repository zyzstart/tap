package com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DeviceIconViewInterceptor extends com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.AbstractIconViewInterceptor {
    public DeviceIconViewInterceptor(@androidx.annotation.NonNull com.tencent.ysdk.shell.framework.YSDKSystem ySDKSystem) {
        super(ySDKSystem);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.AbstractIconViewInterceptor
    protected com.tencent.ysdk.shell.libware.device.notch.INotch getINotch() {
        return com.tencent.ysdk.shell.libware.device.notch.NotchFactory.getDeviceNotch();
    }
}
