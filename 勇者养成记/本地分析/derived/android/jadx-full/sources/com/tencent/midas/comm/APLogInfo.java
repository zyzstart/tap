package com.tencent.midas.comm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogInfo {
    public static final java.lang.String LOG_TAG = "MidasComm<Log>";
    public static final int LOG_VERSION_CODE = 39;
    public static final java.lang.String LOG_VERSION_NAME = "1.2.19";
    private android.content.Context context = null;
    private java.lang.String logTag = "Midas";
    private boolean logEnable = true;
    private java.lang.String logPath = "";
    private boolean hasWritePermission = false;
    private java.lang.String pkgName = "";
    private java.lang.String processName = "";
    private boolean writeLog = true;
    private boolean printLog = false;
    private boolean compressLog = true;
    private boolean encryptLog = true;
    private boolean autoFlush = true;

    private void initLogPath() {
        try {
            if (!this.hasWritePermission) {
                java.io.File externalFilesDir = this.context.getExternalFilesDir("midas" + java.io.File.separator + "log" + java.io.File.separator);
                this.logPath = externalFilesDir == null ? "" : externalFilesDir.getPath();
            }
            if (android.text.TextUtils.isEmpty(this.logPath) || !new java.io.File(this.logPath).canWrite()) {
                this.logPath = android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "tencent" + java.io.File.separator + "Midas" + java.io.File.separator + "Log" + java.io.File.separator;
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.w(LOG_TAG, "init log path error: " + th.getMessage());
            this.logPath = android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "tencent" + java.io.File.separator + "Midas" + java.io.File.separator + "Log" + java.io.File.separator;
            th.printStackTrace();
        }
    }

    private void initPermission() {
        this.hasWritePermission = this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pkgName) == 0;
        android.util.Log.d(LOG_TAG, "has WRITE_EXTERNAL_STORAGE? : " + this.hasWritePermission);
    }

    private void initPkgName() {
        android.content.Context context = this.context;
        if (context == null) {
            return;
        }
        try {
            this.pkgName = context.getPackageManager().getPackageInfo(this.context.getApplicationContext().getPackageName(), 0).packageName;
        } catch (java.lang.Throwable th) {
            android.util.Log.w(LOG_TAG, "getPackage: " + th.toString());
        }
        android.util.Log.w(LOG_TAG, "get pkgName: " + this.pkgName);
    }

    private void initProcessName() {
        try {
            int iMyPid = android.os.Process.myPid();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) this.context.getSystemService("activity");
            if (activityManager != null) {
                for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        java.lang.String[] strArrSplit = runningAppProcessInfo.processName.split(":");
                        this.processName = strArrSplit.length > 1 ? strArrSplit[1] : "";
                        break;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.w(LOG_TAG, "get process: " + th.toString());
        }
        android.util.Log.w(LOG_TAG, "get process name: " + this.processName);
    }

    private void setPrintLog(boolean z) {
        this.printLog = z;
        android.util.Log.d(LOG_TAG, "set print log: " + z);
    }

    private void setWriteLog(boolean z) {
        this.writeLog = z;
        android.util.Log.d(LOG_TAG, "set write log: " + z);
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public java.lang.String getLogPath() {
        return this.logPath;
    }

    public java.lang.String getLogTag() {
        return this.logTag;
    }

    public java.lang.String getPkgName() {
        return this.pkgName;
    }

    public java.lang.String getProcessName() {
        return this.processName;
    }

    public void init() {
        if (this.context == null) {
            android.util.Log.e(LOG_TAG, "APLogInfo init failed because of null context");
            return;
        }
        initPkgName();
        initPermission();
        initProcessName();
        initLogPath();
        android.util.Log.i(LOG_TAG, "Log lib versionName: 1.2.19 versionCode: 39");
    }

    public boolean isAutoFlush() {
        return this.autoFlush;
    }

    public boolean isCompressLog() {
        return this.compressLog;
    }

    public boolean isEncryptLog() {
        return this.encryptLog;
    }

    public boolean isHasWritePermission() {
        return this.hasWritePermission;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }

    public boolean isPrintLog() {
        return this.printLog;
    }

    public boolean isWriteLog() {
        return this.writeLog;
    }

    public void setAutoFlush(boolean z) {
        this.autoFlush = z;
    }

    public void setCompressLog(boolean z) {
        this.compressLog = z;
        android.util.Log.d(LOG_TAG, "set compress log: " + z);
    }

    public void setContext(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    public void setEncryptKey(java.lang.String str) {
        com.tencent.midas.comm.log.processor.APLogEncryptor.setEncryptKey(str);
    }

    public void setEncryptLog(boolean z) {
        this.encryptLog = z;
        android.util.Log.d(LOG_TAG, "set encrypt log: " + z);
    }

    public void setEncryptProtocolVersion(byte b) {
        com.tencent.midas.comm.log.processor.APLogEncryptor.setProtocolVersion(b);
    }

    public void setLogEnable(boolean z) {
        this.logEnable = z;
    }

    public void setLogFileKeepDays(int i) {
        com.tencent.midas.comm.log.util.APLogFileUtil.maxLogKeepDays = i;
        android.util.Log.d(LOG_TAG, "set log file keep days: " + i);
    }

    public void setLogFileNum(int i) {
        com.tencent.midas.comm.log.util.APLogFileUtil.maxLogFileNum = i;
        android.util.Log.d(LOG_TAG, "set log file num: " + i);
    }

    public void setLogFileSizeMB(int i) {
        com.tencent.midas.comm.log.util.APLogFileUtil.maxLogFileSizeMB = i;
        android.util.Log.d(LOG_TAG, "set log file size: " + i + " MB");
    }

    public void setLogParamFromServer(java.lang.String str) {
        setLogWrite(str);
    }

    public void setLogPath(java.lang.String str) {
        this.logPath = str;
    }

    public void setLogTag(java.lang.String str) {
        this.logTag = str;
    }

    public void setLogWrite(java.lang.String str) {
        int iIntValue;
        try {
            iIntValue = java.lang.Integer.valueOf(str).intValue();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            iIntValue = 3;
        }
        setPrintLog((iIntValue & 1) == 1);
        setWriteLog((iIntValue & 2) == 2);
    }

    public boolean shouldPrintLog() {
        return this.logEnable || this.printLog || com.tencent.midas.comm.log.util.APLogFileUtil.isDebugMode(com.tencent.midas.comm.log.APLogFileInfo.dirName);
    }
}
