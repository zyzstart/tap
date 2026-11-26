package com.tencent.midas.comm.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogFileInfo {
    public static java.lang.String dirName = "";
    public static java.lang.String fileName = "";
    public static java.lang.String mmapName = "";

    private static java.lang.String buildDirName() {
        com.tencent.midas.comm.APLogInfo logInfo = com.tencent.midas.comm.APLog.getLogInfo();
        if (logInfo == null || logInfo.getLogPath() == null) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "log info is null");
            return "";
        }
        java.lang.String logPath = logInfo.getLogPath();
        if (!logPath.endsWith(java.io.File.separator)) {
            logPath = logPath + java.io.File.separator;
        }
        java.lang.String str = logPath + logInfo.getPkgName() + java.io.File.separator;
        if (android.text.TextUtils.isEmpty(logInfo.getProcessName())) {
            return str;
        }
        return str + logInfo.getProcessName() + java.io.File.separator;
    }

    private static java.lang.String buildFileName(boolean z) {
        java.lang.StringBuffer stringBuffer = null;
        try {
            if (!android.text.TextUtils.isEmpty(dirName)) {
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer(dirName);
                try {
                    if (!dirName.endsWith(java.io.File.separator)) {
                        stringBuffer2.append(java.io.File.separator);
                    }
                    java.lang.String lastLogFileName = com.tencent.midas.comm.log.util.APLogFileUtil.getLastLogFileName(dirName);
                    if (z && !android.text.TextUtils.isEmpty(lastLogFileName)) {
                        stringBuffer2.append(lastLogFileName);
                        return stringBuffer2.toString();
                    }
                    stringBuffer2.append(com.tencent.midas.comm.log.util.APLogFileUtil.getToday());
                    stringBuffer2.append("_");
                    stringBuffer2.append(buildFileNumber(lastLogFileName));
                    stringBuffer2.append(".txt");
                    stringBuffer = stringBuffer2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    stringBuffer = stringBuffer2;
                    android.util.Log.i(com.tencent.midas.comm.APLogInfo.LOG_TAG, "create log file name error:" + th.toString());
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return stringBuffer == null ? "" : stringBuffer.toString();
    }

    private static int buildFileNumber(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            java.lang.String[] strArrSplit = str.split(com.tencent.midas.comm.log.util.APLogFileUtil.getToday() + "_");
            if (strArrSplit.length > 1) {
                return 1 + java.lang.Integer.parseInt(strArrSplit[1].split(".txt")[0]);
            }
            return 1;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "build file number error: " + th.getMessage());
            return 1;
        }
    }

    private static java.lang.String buildMmapName() {
        return dirName + java.io.File.separator + "MidasLog.mmap";
    }

    public static void create() {
        try {
            dirName = buildDirName();
            fileName = buildFileName(true);
            mmapName = buildMmapName();
            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "log dir: " + dirName);
            android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "log file: " + fileName);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "file info create error: " + th.toString());
        }
    }

    public static void updateFileName() {
        fileName = buildFileName(false);
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, "update file name: " + fileName);
    }
}
