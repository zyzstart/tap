package com.tencent.midas.comm.log.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogDataReporter {
    public static final java.lang.String MIDAS_LOG_ERROR_APPEND = "sdk.log.error.append";
    public static final java.lang.String MIDAS_LOG_ERROR_CLOSE = "sdk.log.error.close";
    public static final java.lang.String MIDAS_LOG_ERROR_FLUSH = "sdk.log.error.flush";
    public static final java.lang.String MIDAS_LOG_ERROR_INIT = "sdk.log.error.init";
    public static final java.lang.String MIDAS_LOG_ERROR_MMAP_OPEN = "sdk.log.error.mmap.open";
    public static final java.lang.String MIDAS_LOG_ERROR_PRINT = "sdk.log.error.print";
    public static final java.lang.String MIDAS_LOG_ERROR_PROCESS = "sdk.log.error.process";
    public static final java.lang.String MIDAS_LOG_ERROR_WRITE = "sdk.log.error.write";
    public static final java.lang.String MIDAS_LOG_INIT = "sdk.log.init";
    private com.tencent.midas.comm.log.util.APLogDataReporter.Reporter reporter;

    private static class Holder {
        private static final com.tencent.midas.comm.log.util.APLogDataReporter INSTANCE = new com.tencent.midas.comm.log.util.APLogDataReporter();

        private Holder() {
        }
    }

    public interface Reporter {
        void report(java.lang.String str, java.lang.String str2, java.lang.String str3);
    }

    private APLogDataReporter() {
    }

    public static com.tencent.midas.comm.log.util.APLogDataReporter getInstance() {
        return com.tencent.midas.comm.log.util.APLogDataReporter.Holder.INSTANCE;
    }

    public com.tencent.midas.comm.log.util.APLogDataReporter.Reporter getReporter() {
        return this.reporter;
    }

    public void report(java.lang.String str, java.lang.String str2) {
        report(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, str, str2);
    }

    public void report(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (this.reporter != null) {
                this.reporter.report(str, str2, str3);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "report error: " + th.getMessage());
            th.printStackTrace();
        }
    }

    public void reportTimeEx(java.lang.String str, long j) {
        report(str, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - j));
    }

    public void setReporter(com.tencent.midas.comm.log.util.APLogDataReporter.Reporter reporter) {
        this.reporter = reporter;
    }
}
