package com.tencent.ysdk.shell.module.bugly;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
public class BuglyApi {
    private static final java.lang.String TAG = "YSDK.BuglyApi";
    private static volatile com.tencent.ysdk.shell.module.bugly.BuglyApi instance;
    private com.tencent.ysdk.shell.module.bugly.BuglyInterface buglyInterfaceImp = null;

    private BuglyApi() {
    }

    public static com.tencent.ysdk.shell.module.bugly.BuglyApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.bugly.BuglyApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.bugly.BuglyApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.bugly.BuglyInterface getOrLoadBuglyInnerInterface() {
        com.tencent.ysdk.shell.module.bugly.BuglyInterface buglyInterface = this.buglyInterfaceImp;
        if (buglyInterface != null) {
            return buglyInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.bugly.BuglyInterface) {
                this.buglyInterfaceImp = (com.tencent.ysdk.shell.module.bugly.BuglyInterface) moduleByName;
            }
        }
        return this.buglyInterfaceImp;
    }

    public void setBuglyListener(com.tencent.ysdk.module.bugly.BuglyListener buglyListener) {
        com.tencent.ysdk.shell.module.bugly.BuglyInterface orLoadBuglyInnerInterface = getOrLoadBuglyInnerInterface();
        if (orLoadBuglyInnerInterface != null) {
            orLoadBuglyInnerInterface.setBuglyListener(buglyListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setBuglyListener"));
        }
    }
}
