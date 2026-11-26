package com.tencent.midas.comm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogUtil {
    private static boolean HAS_INIT_LOG_IN_NEW_PROCESS = false;
    public static boolean IS_IN_NEW_PROCESS = true;

    public static void flushIfNewProcess() {
        if (!IS_IN_NEW_PROCESS || com.tencent.midas.comm.APLog.getLogInfo() == null || com.tencent.midas.comm.APLog.getLogInfo().isAutoFlush()) {
            return;
        }
        com.tencent.midas.comm.APLog.flush();
    }

    public static void initAPLogIfNewProcess(android.content.Context context, boolean z, boolean z2) {
        if (!z || HAS_INIT_LOG_IN_NEW_PROCESS) {
            return;
        }
        IS_IN_NEW_PROCESS = true;
        try {
            com.tencent.midas.comm.APLogInfo aPLogInfo = new com.tencent.midas.comm.APLogInfo();
            com.tencent.midas.comm.log.util.APLogDataReporter.getInstance().setReporter(new com.tencent.midas.comm.log.util.APLogDataReporter.Reporter() { // from class: com.tencent.midas.comm.APLogUtil.1
                @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                public void report(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                    com.tencent.midas.data.APPluginReportManager.getInstance().insertData(str, str2, "", str3);
                }
            });
            aPLogInfo.setContext(context);
            aPLogInfo.setLogEnable(z2);
            aPLogInfo.setAutoFlush(true);
            aPLogInfo.setLogTag("TencentPay");
            com.tencent.midas.comm.APLog.init(aPLogInfo);
            HAS_INIT_LOG_IN_NEW_PROCESS = true;
        } catch (java.lang.Throwable th) {
            com.tencent.midas.comm.APLog.e("APLogUtil init", th.toString());
        }
    }

    public static void initAPLogInPlugin(android.content.Context context, boolean z) {
        try {
            com.tencent.midas.comm.APLogInfo aPLogInfo = new com.tencent.midas.comm.APLogInfo();
            com.tencent.midas.comm.log.util.APLogDataReporter.getInstance().setReporter(new com.tencent.midas.comm.log.util.APLogDataReporter.Reporter() { // from class: com.tencent.midas.comm.APLogUtil.2
                @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                public void report(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                    com.tencent.midas.data.APPluginReportManager.getInstance().insertData(str, str2, "", str3);
                }
            });
            aPLogInfo.setContext(context);
            aPLogInfo.setLogEnable(z);
            aPLogInfo.setAutoFlush(true);
            aPLogInfo.setLogTag("TencentPay");
            com.tencent.midas.comm.APLog.init(aPLogInfo);
        } catch (java.lang.Throwable th) {
            com.tencent.midas.comm.APLog.e("APLogUtil init", th.toString());
        }
    }
}
