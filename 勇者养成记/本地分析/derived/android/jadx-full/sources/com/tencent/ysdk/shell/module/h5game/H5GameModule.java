package com.tencent.ysdk.shell.module.h5game;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5GameModule extends com.tencent.ysdk.shell.module.Module {
    private static final int MSG_ICON_GET_SETTINGS = 1;
    public static final java.lang.String TAG = "YSDK H5GAME";

    public H5GameModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_H5GAME;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_H5GAME_SWITCH, false)) {
            com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().isConfigEnable = true;
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "H5GameModule is closed");
        }
    }
}
