package com.tencent.midas.comm.log.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogFileUtil {
    private static final java.lang.String DEBUG_CONF = "MidasLogDebug.ini";
    private static final int DEFAULT_MAX_LOG_FILE_NUM = 2;
    private static final int DEFAULT_MAX_LOG_FILE_SIZE_MB = 1;
    private static final int DEFAULT_MAX_LOG_KEEP_DAYS = 15;
    public static final java.lang.String SEPARATOR_LINE = "\r\n";
    public static final java.lang.String SEPARATOR_LOG = " | ";
    private static int maxDirSizeMB = 30;
    public static int maxLogFileNum = 2;
    public static int maxLogFileSizeMB = 1;
    public static int maxLogKeepDays = 15;
    public static int minSDCardSpace = 20;

    public static void deleteFileUpMaxInDir(java.lang.String str, long j, long j2, int i) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists() && !file.isFile()) {
                double fileOrFilesSize = getFileOrFilesSize(str);
                boolean z = fileOrFilesSize >= ((double) j2);
                java.io.File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    for (java.io.File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (!file2.getName().equals("MidasLog.mmap") && file2.isFile() && (z || jCurrentTimeMillis - jLastModified > i * 24 * 3600 * 1000 || (getFileSize(file2) / 1024) / 1024 >= j)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void deleteOldFileToday(java.lang.String str) {
        deleteOldFileToday(str, maxLogFileNum);
    }

    public static void deleteOldFileToday(java.lang.String str, int i) {
        java.util.ArrayList logFiles = getLogFiles(str, getToday() + "_");
        int size = logFiles.size();
        if (size < i || i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            java.io.File file = (java.io.File) logFiles.get(i2);
            if (file != null) {
                android.util.Log.w(com.tencent.midas.comm.APLogInfo.LOG_TAG, "get: " + file.getName());
                if (i2 < size - i) {
                    android.util.Log.w(com.tencent.midas.comm.APLogInfo.LOG_TAG, "delete: " + file.getName());
                    file.delete();
                }
            }
        }
    }

    private static int getConfValue(android.content.SharedPreferences sharedPreferences, java.lang.String str, int i) {
        java.lang.String string = sharedPreferences.getString(str, null);
        if (!android.text.TextUtils.isEmpty(string)) {
            try {
                android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "Read log conf[%s]: %s", str, string));
                int i2 = java.lang.Integer.parseInt(string);
                if (i2 > 0) {
                    return i2;
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "Read log conf[%s] error: %s", str, th.getMessage()));
            }
        }
        return i;
    }

    public static double getFileOrFilesSize(java.lang.String str) {
        long fileSizes;
        java.io.File file = new java.io.File(str);
        try {
            fileSizes = file.isDirectory() ? getFileSizes(file) : getFileSize(file);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            fileSizes = 0;
        }
        return (fileSizes / 1024) / 1024;
    }

    private static long getFileSize(java.io.File file) {
        long jAvailable = 0;
        try {
            if (file.exists()) {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                jAvailable = fileInputStream.available();
                fileInputStream.close();
            } else {
                file.createNewFile();
            }
        } catch (java.lang.Throwable unused) {
        }
        return jAvailable;
    }

    private static long getFileSizes(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        long fileSizes = 0;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            fileSizes += fileArrListFiles[i].isDirectory() ? getFileSizes(fileArrListFiles[i]) : getFileSize(fileArrListFiles[i]);
        }
        return fileSizes;
    }

    public static java.lang.String getLastLogFileName(java.lang.String str) {
        java.util.ArrayList logFiles = getLogFiles(str, getToday());
        return logFiles.size() > 0 ? ((java.io.File) logFiles.get(logFiles.size() - 1)).getName() : "";
    }

    public static java.util.ArrayList getLogFiles(java.lang.String str, final java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        if (!file.isDirectory()) {
            return new java.util.ArrayList();
        }
        java.io.File[] fileArrListFiles = file.listFiles(new java.io.FilenameFilter() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.1
            @Override // java.io.FilenameFilter
            public boolean accept(java.io.File file2, java.lang.String str3) {
                return str3.startsWith(str2);
            }
        });
        java.util.Arrays.sort(fileArrListFiles, new java.util.Comparator() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.2
            private int extractNumber(java.lang.String str3) {
                try {
                    return java.lang.Integer.parseInt(str3.substring(str3.indexOf(95) + 1, str3.lastIndexOf(46)));
                } catch (java.lang.Throwable unused) {
                    return 0;
                }
            }

            @Override // java.util.Comparator
            public int compare(java.io.File file2, java.io.File file3) {
                return extractNumber(file2.getName()) - extractNumber(file3.getName());
            }
        });
        return new java.util.ArrayList(java.util.Arrays.asList(fileArrListFiles));
    }

    public static double getSDCardSpace() {
        long availableBlocks;
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            availableBlocks = ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024;
        } catch (java.lang.Throwable th) {
            android.util.Log.i(com.tencent.midas.comm.APLogInfo.LOG_TAG, "getSDCardSpace: " + th.toString());
            availableBlocks = 0;
        }
        return availableBlocks;
    }

    public static java.lang.String getToday() {
        return new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.CHINA).format(new java.util.Date(java.lang.System.currentTimeMillis()));
    }

    public static boolean initLogDir(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                deleteFileUpMaxInDir(str, maxLogFileSizeMB, maxDirSizeMB, maxLogKeepDays);
                deleteOldFileToday(str, maxLogFileNum);
                return true;
            }
            boolean zMkdirs = file.mkdirs();
            android.util.Log.i(com.tencent.midas.comm.APLogInfo.LOG_TAG, "create log dir result: " + zMkdirs);
            return zMkdirs;
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, "init log dir error: " + th.toString());
            return false;
        }
    }

    public static boolean isDebugMode(java.lang.String str) {
        return new java.io.File(str + DEBUG_CONF).exists();
    }

    public static void readLogKeepConf(android.content.Context context) {
        int i = maxLogFileSizeMB;
        if (i <= 0) {
            i = 1;
        }
        maxLogFileSizeMB = i;
        int i2 = maxLogFileNum;
        if (i2 <= 0) {
            i2 = 2;
        }
        maxLogFileNum = i2;
        int i3 = maxLogKeepDays;
        if (i3 <= 0) {
            i3 = 15;
        }
        maxLogKeepDays = i3;
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * i3;
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "current config: max log size: %d MB, max log num: %d, max keep %d DAYS", java.lang.Integer.valueOf(maxLogFileSizeMB), java.lang.Integer.valueOf(maxLogFileNum), java.lang.Integer.valueOf(maxLogKeepDays)));
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.tencent.midas.data.APPluginDataInterface.SHARE_PREFERENCE_NAME, 4);
        maxLogFileSizeMB = getConfValue(sharedPreferences, "size", maxLogFileSizeMB);
        maxLogFileNum = getConfValue(sharedPreferences, "num", maxLogFileNum);
        int confValue = getConfValue(sharedPreferences, "log_keep_time", maxLogKeepDays);
        maxLogKeepDays = confValue;
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * confValue;
        android.util.Log.d(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "final config: max log size: %d MB, max log num: %d, max keep %d DAYS", java.lang.Integer.valueOf(maxLogFileSizeMB), java.lang.Integer.valueOf(maxLogFileNum), java.lang.Integer.valueOf(maxLogKeepDays)));
    }
}
