package com.tencent.ysdk.shell.module.realName;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.0")
public class RealNameApi {
    private static final java.lang.String TAG = "YSDK.RealNameApi";
    private static volatile com.tencent.ysdk.shell.module.realName.RealNameApi instance;
    private com.tencent.ysdk.shell.module.realName.RealNameInterface realNameInterfaceImp = null;

    private RealNameApi() {
    }

    public static com.tencent.ysdk.shell.module.realName.RealNameApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.realName.RealNameApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.realName.RealNameApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.realName.RealNameInterface getOrLoadRealNameInnerInterface() {
        com.tencent.ysdk.shell.module.realName.RealNameInterface realNameInterface = this.realNameInterfaceImp;
        if (realNameInterface != null) {
            return realNameInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REAL_NAME);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.realName.RealNameInterface) {
                this.realNameInterfaceImp = (com.tencent.ysdk.shell.module.realName.RealNameInterface) moduleByName;
            }
        }
        return this.realNameInterfaceImp;
    }

    public com.tencent.ysdk.framework.common.ePlatform getUserLoginPltform() {
        com.tencent.ysdk.shell.module.realName.RealNameInterface orLoadRealNameInnerInterface = getOrLoadRealNameInnerInterface();
        if (orLoadRealNameInnerInterface != null) {
            return orLoadRealNameInnerInterface.getUserLoginPltform();
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getUserLoginPltform"));
        return com.tencent.ysdk.framework.common.ePlatform.None;
    }

    public java.lang.String getUserNickname() {
        com.tencent.ysdk.shell.module.realName.RealNameInterface orLoadRealNameInnerInterface = getOrLoadRealNameInnerInterface();
        if (orLoadRealNameInnerInterface != null) {
            return orLoadRealNameInnerInterface.getUserNickname();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getUserNickname"));
        return "";
    }

    public void notifyRegisterRealName(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        com.tencent.ysdk.shell.module.realName.RealNameInterface orLoadRealNameInnerInterface = getOrLoadRealNameInnerInterface();
        if (orLoadRealNameInnerInterface != null) {
            orLoadRealNameInnerInterface.notifyRegisterRealNameToLoginModule(baseRet);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("notifyRegisterRealName"));
        }
    }

    public void registerRealName(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener) {
        com.tencent.ysdk.shell.module.realName.RealNameInterface orLoadRealNameInnerInterface = getOrLoadRealNameInnerInterface();
        if (orLoadRealNameInnerInterface != null) {
            orLoadRealNameInnerInterface.registerRealName(registerRealNameRequestPara, realNameInnerListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("registerRealName"));
        }
    }

    public void showRegisterPage(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener) {
        com.tencent.ysdk.shell.module.realName.RealNameInterface orLoadRealNameInnerInterface = getOrLoadRealNameInnerInterface();
        if (orLoadRealNameInnerInterface != null) {
            orLoadRealNameInnerInterface.showRegisterPage(eplatform, str, str2, str3, realNameInnerListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("showRegisterPage"));
        }
    }
}
