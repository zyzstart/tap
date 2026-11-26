package com.tencent.midas.comm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLog {
    private static com.tencent.midas.comm.log.internal.APLogger logger;

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static com.tencent.midas.comm.APLogInfo logInfo = new com.tencent.midas.comm.APLogInfo();
    private static boolean shouldWriteLog = false;
    private static boolean shouldPrintLog = true;

    private APLog() {
    }

    public static void closeLog() {
        flush();
    }

    private static java.lang.String composeLogMsg(java.lang.String str, java.lang.String str2) {
        return str + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LOG + java.lang.Thread.currentThread().getName() + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LOG + str2 + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            com.tencent.midas.comm.log.internal.APLogger.log(2, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        d(str, java.lang.String.format(str2, objArr));
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            com.tencent.midas.comm.log.internal.APLogger.log(5, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        e(str, java.lang.String.format(str2, objArr));
    }

    public static void flush() {
        try {
            if (logger != null) {
                logger.flush();
                android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "Log flushing...!!!");
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.i(com.tencent.midas.comm.APLogInfo.LOG_TAG, "flush log error: " + th.toString());
        }
    }

    public static com.tencent.midas.comm.APLogInfo getLogInfo() {
        return logInfo;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            com.tencent.midas.comm.log.internal.APLogger.log(3, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        i(str, java.lang.String.format(str2, objArr));
    }

    public static void init(com.tencent.midas.comm.APLogInfo aPLogInfo) {
        try {
            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "Log init");
            if (aPLogInfo == null) {
                android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "Log init failed: info null");
                return;
            }
            com.tencent.midas.comm.log.util.APLogDataReporter.getInstance().report("init", com.tencent.midas.comm.log.util.APLogDataReporter.MIDAS_LOG_INIT, "");
            logInfo = aPLogInfo;
            aPLogInfo.init();
            com.tencent.midas.comm.log.APLogFileInfo.create();
            com.tencent.midas.comm.log.util.APLogFileUtil.readLogKeepConf(logInfo.getContext());
            shouldPrintLog = logInfo.shouldPrintLog();
            if (com.tencent.midas.comm.log.util.APLogFileUtil.initLogDir(com.tencent.midas.comm.log.APLogFileInfo.dirName)) {
                shouldWriteLog = logInfo.isWriteLog();
                logger = com.tencent.midas.comm.log.internal.APLogger.open();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.midas.comm.log.util.APLogDataReporter.getInstance().report("init", com.tencent.midas.comm.log.util.APLogDataReporter.MIDAS_LOG_ERROR_INIT, th.getClass().getName() + th.getMessage());
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "Log init failed: " + th.toString());
        }
    }

    public static void s(java.lang.String str, java.lang.String str2) {
        writeLog(composeLogMsg(str, str2));
    }

    public static void s(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        s(str, java.lang.String.format(str2, objArr));
    }

    public static void s(boolean z, java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog && !z) {
            com.tencent.midas.comm.log.internal.APLogger.log(6, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void s(boolean z, java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        s(z, str, java.lang.String.format(str2, objArr));
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            com.tencent.midas.comm.log.internal.APLogger.log(1, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        v(str, java.lang.String.format(str2, objArr));
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        java.lang.String strComposeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            com.tencent.midas.comm.log.internal.APLogger.log(4, logInfo.getLogTag(), strComposeLogMsg);
        }
        writeLog(strComposeLogMsg);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        w(str, java.lang.String.format(str2, objArr));
    }

    private static void write(java.lang.String str) {
        try {
            if (logger != null) {
                logger.write(str);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "Log write error: " + th.toString());
        }
    }

    private static void writeLog(java.lang.String str) {
        if (shouldWriteLog) {
            write(str);
        }
    }
}
