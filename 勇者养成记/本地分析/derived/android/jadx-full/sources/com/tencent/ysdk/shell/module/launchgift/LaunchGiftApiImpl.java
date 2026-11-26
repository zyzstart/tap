package com.tencent.ysdk.shell.module.launchgift;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LaunchGiftApiImpl implements com.tencent.ysdk.module.launchgift.ILaunchGiftApi {
    private static volatile com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl instance;
    protected com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface launchGiftInterface = null;

    public static com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl launchGiftApiImpl = new com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_LAUNCH_GIFT);
                        if (moduleByName == null || !(moduleByName instanceof com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface)) {
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "LaunchGiftApi module is bad");
                        } else {
                            launchGiftApiImpl.launchGiftInterface = (com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface) moduleByName;
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "LaunchGiftApi");
                        }
                    }
                    instance = launchGiftApiImpl;
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.launchgift.ILaunchGiftApi
    public boolean checkLaunchGift() {
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface launchGiftInterface = this.launchGiftInterface;
        if (launchGiftInterface != null) {
            return launchGiftInterface.checkLaunchGift();
        }
        return false;
    }

    @Override // com.tencent.ysdk.module.launchgift.ILaunchGiftApi
    public void regOnLaunchGiftListener(com.tencent.ysdk.module.launchgift.OnLaunchGiftListener onLaunchGiftListener) {
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface launchGiftInterface = this.launchGiftInterface;
        if (launchGiftInterface != null) {
            launchGiftInterface.regOnLaunchGiftListener(onLaunchGiftListener);
        }
    }

    @Override // com.tencent.ysdk.module.launchgift.ILaunchGiftApi
    public void setGameUID(java.lang.String str) {
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface launchGiftInterface = this.launchGiftInterface;
        if (launchGiftInterface != null) {
            launchGiftInterface.setGameUID(str);
        }
    }

    @Override // com.tencent.ysdk.module.launchgift.ILaunchGiftApi
    public void showLaunchGiftView() {
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface launchGiftInterface = this.launchGiftInterface;
        if (launchGiftInterface != null) {
            launchGiftInterface.showLaunchGiftView();
        }
    }
}
