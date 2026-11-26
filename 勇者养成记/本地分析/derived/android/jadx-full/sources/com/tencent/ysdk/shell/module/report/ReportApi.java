package com.tencent.ysdk.shell.module.report;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.0")
@java.lang.Deprecated
public class ReportApi {
    public static final java.lang.String LOG_TAG = "ReportApi";
    private static volatile com.tencent.ysdk.shell.module.report.ReportApi instance;
    private com.tencent.ysdk.shell.module.report.ReportInterface userInterfaceImp;

    private ReportApi() {
    }

    public static com.tencent.ysdk.shell.module.report.ReportApi getInstance() {
        java.lang.Object moduleByName;
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.UserApi.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.report.ReportApi reportApi = new com.tencent.ysdk.shell.module.report.ReportApi();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null && (moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REPORT)) != null && (moduleByName instanceof com.tencent.ysdk.shell.module.report.ReportInterface)) {
                        reportApi.userInterfaceImp = (com.tencent.ysdk.shell.module.report.ReportInterface) moduleByName;
                        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", LOG_TAG);
                    }
                    instance = reportApi;
                }
            }
        }
        return instance;
    }

    @java.lang.Deprecated
    public void reportCgiRealTime(java.lang.String str, long j, long j2, long j3, int i) {
        com.tencent.ysdk.shell.module.report.ReportInterface reportInterface = this.userInterfaceImp;
        if (reportInterface != null) {
            reportInterface.reportCgiRealTime(str, j, j2, j3, i);
        }
    }
}
