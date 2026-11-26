package com.tencent.ysdk.shell.module.immersiveicon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.2")
public class ImmersiveIconApiImpl implements com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi {
    private static volatile com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl instance;
    protected com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface immersiveIconInterface = null;

    private ImmersiveIconApiImpl() {
    }

    public static com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl immersiveIconApiImpl = new com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_IMMERSIVE_ICON);
                        if (moduleByName == null || !(moduleByName instanceof com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface)) {
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "ImmersiveIconApi module is bad");
                        } else {
                            immersiveIconApiImpl.immersiveIconInterface = (com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface) moduleByName;
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "ImmersiveIconApi");
                        }
                    }
                    instance = immersiveIconApiImpl;
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi
    public java.lang.String getIconVersion() {
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface immersiveIconInterface = this.immersiveIconInterface;
        return immersiveIconInterface != null ? immersiveIconInterface.getImmersiveIconVersion() : "";
    }

    @Override // com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi
    public void performFeature(java.lang.String str) {
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface immersiveIconInterface = this.immersiveIconInterface;
        if (immersiveIconInterface != null) {
            immersiveIconInterface.performImmersiveIconAction(str);
        }
    }

    @Override // com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi
    public void performFeature(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface immersiveIconInterface = this.immersiveIconInterface;
        if (immersiveIconInterface != null) {
            immersiveIconInterface.performImmersiveIconAction(str, map);
        }
    }

    @Override // com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi
    public void regOnStateChangeListener(com.tencent.ysdk.module.immersiveicon.OnStateChangeListener onStateChangeListener) {
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface immersiveIconInterface = this.immersiveIconInterface;
        if (immersiveIconInterface != null) {
            immersiveIconInterface.regOnStateChangeListener(onStateChangeListener);
        }
    }
}
