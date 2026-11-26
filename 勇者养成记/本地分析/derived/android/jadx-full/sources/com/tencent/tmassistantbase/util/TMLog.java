package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMLog {
    protected static final long INTERNAL = 60000;
    public static boolean LOG_CONFIG_CLOUD = false;
    protected static final java.lang.String LOG_CONFIG_FILE_PATH = "/tencent/TMAssistantSDK/Logs/logConfig.properties";
    protected static final java.lang.String LOG_DIR_PATH = "/tencent/TMAssistantSDK/Logs/";
    protected static final long LOG_FILE_LENTH = 512000;
    protected static final java.lang.String LOG_FILE_NAME_SUFFIX = "_tmlog.txt";
    public static final java.lang.String PROP_DIR_PATH = "logDirPath";
    public static final java.lang.String PROP_IS_APPEND_LOG_TIME = "isAppendLogTime";
    public static final java.lang.String PROP_IS_APPEND_METHOD_NAME = "isAppendMethodName";
    public static final java.lang.String PROP_IS_USE_WRITER_CACHE = "isUseWriterCache";
    public static final java.lang.String PROP_IS_WRITE_FILE = "isWriteLogToFile";
    public static final java.lang.String PROP_LOGCAT_LEVEL = "logcatOutputLevel";
    public static final java.lang.String PROP_LOG_FILE_LEVEL = "logfileOutputLevel";
    protected static final java.lang.String TAG = "TMLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.concurrent.LinkedBlockingQueue f1050a = null;
    static long b = 0;
    protected static android.content.Context context = null;
    protected static boolean isAppendLogTime = false;
    protected static boolean isAppendMethodName = false;
    public static final boolean isDebug = true;
    protected static boolean isInited = false;
    protected static boolean isUseWriterCache = true;
    public static boolean isWriteLogToFile = false;
    protected static java.lang.String logDirPath = "";
    protected static int logcatOutputLevel = 2;
    protected static int logfileOutputLevel = 4;
    protected static int myProcessId;
    private static java.lang.reflect.Field stringBuilderValueField;
    protected static java.io.BufferedWriter writer;
    static final java.util.concurrent.locks.ReentrantLock c = new java.util.concurrent.locks.ReentrantLock();
    protected static java.lang.String packageName = "";
    protected static java.lang.String logTime = "";
    protected static long lastLogTime = 0;
    protected static java.text.SimpleDateFormat timeFormatter = new java.text.SimpleDateFormat("yy-MM-dd HH:mm");
    protected static java.util.concurrent.atomic.AtomicBoolean isPreExceptionEnospc = new java.util.concurrent.atomic.AtomicBoolean(false);
    protected static java.util.concurrent.atomic.AtomicBoolean isInitLogFileDone = new java.util.concurrent.atomic.AtomicBoolean(false);
    protected static final int[] INTERVAL_RETRY_INIT = {1, 2, 4, 8, 16, 29};
    protected static java.util.concurrent.atomic.AtomicInteger retryInitTimes = new java.util.concurrent.atomic.AtomicInteger(0);
    protected static android.os.Handler retryInitHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static java.lang.Boolean needGetField = java.lang.Boolean.TRUE;
    private static java.lang.ThreadLocal stringBuilderCharBuffer = new com.tencent.tmassistantbase.util.t();
    protected static java.lang.Runnable acutualInitRunnable = new com.tencent.tmassistantbase.util.u();
    static java.lang.Thread d = new com.tencent.tmassistantbase.util.w();

    private static void addLogItem(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isWriteLogToFile()) {
            long id = java.lang.Thread.currentThread().getId();
            java.lang.StringBuilder sbObtainStringBuilder = obtainStringBuilder();
            if (isAppendLogTime()) {
                sbObtainStringBuilder.append(getLogTime());
                sbObtainStringBuilder.append("|");
            }
            sbObtainStringBuilder.append(getReportLevelString(i));
            sbObtainStringBuilder.append("|pid=");
            sbObtainStringBuilder.append(myProcessId);
            sbObtainStringBuilder.append("|tid=");
            sbObtainStringBuilder.append(java.lang.String.valueOf(id));
            sbObtainStringBuilder.append("|");
            sbObtainStringBuilder.append(str);
            sbObtainStringBuilder.append("|");
            sbObtainStringBuilder.append(str2);
            sbObtainStringBuilder.append("\n");
            if (th != null) {
                sbObtainStringBuilder.append("\n");
                sbObtainStringBuilder.append(android.util.Log.getStackTraceString(th));
                sbObtainStringBuilder.append("\n");
            }
            if (addLogToCache(sbObtainStringBuilder.toString())) {
                return;
            }
            android.util.Log.d(TAG, "addLogToCache failed!");
        }
    }

    private static boolean addLogToCache(java.lang.String str) {
        try {
            f1050a.add(str);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean canPrintLog() {
        return true;
    }

    public static void closeALLLog() {
        setLogcatOutputLevel(7);
        setLogfileOutputLevel(7);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        log(3, str, str2, null);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(3, str, str2, th);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        log(6, str, str2, null);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(6, str, str2, th);
    }

    public static java.lang.String getLogDirPath() {
        java.lang.StringBuilder sb;
        java.io.File filesDir;
        if (android.text.TextUtils.isEmpty(logDirPath)) {
            if (isSDCardExistAndCanWrite()) {
                sb = new java.lang.StringBuilder();
                filesDir = android.os.Environment.getExternalStorageDirectory();
            } else {
                sb = new java.lang.StringBuilder();
                filesDir = context.getFilesDir();
            }
            sb.append(filesDir.getAbsolutePath());
            sb.append(LOG_DIR_PATH);
            logDirPath = sb.toString();
        }
        return logDirPath;
    }

    public static java.lang.String getLogTime() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - lastLogTime > INTERNAL) {
            lastLogTime = jCurrentTimeMillis;
            logTime = timeFormatter.format(java.lang.Long.valueOf(jCurrentTimeMillis));
        }
        return logTime;
    }

    public static int getLogcatOutputLevel() {
        return logcatOutputLevel;
    }

    public static int getLogfileOutputLevel() {
        return logfileOutputLevel;
    }

    private static java.lang.String getReportLevelString(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            default:
                return "D";
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        log(4, str, str2, null);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(4, str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void initLogFile() {
        android.util.Log.d(TAG, "start to init log file!");
        java.io.File file = new java.io.File(getLogDirPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File file2 = new java.io.File(getLogDirPath() + packageName + LOG_FILE_NAME_SUFFIX);
        try {
            if (file2.exists()) {
                if (file2.length() >= LOG_FILE_LENTH) {
                    file2.delete();
                    file2.createNewFile();
                    android.util.Log.d(TAG, "old log file " + file2.getName() + " is deleted");
                }
                writeVersionToFile();
                if (writer != null && isWriteLogToFile()) {
                    writer.write(getLogTime() + "|" + packageName + "|" + android.os.Build.MODEL + " " + android.os.Build.VERSION.RELEASE + "|newLogFile " + file2.getName() + " is existed.\n");
                    writer.flush();
                }
            } else {
                boolean zCreateNewFile = file2.createNewFile();
                writeVersionToFile();
                if (writer != null && isWriteLogToFile()) {
                    writer.write(getLogTime() + "|" + packageName + "|" + android.os.Build.MODEL + " " + android.os.Build.VERSION.RELEASE + " create newLogFile " + file2.getName() + " " + zCreateNewFile + "\n");
                    writer.flush();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        writer = new java.io.BufferedWriter(new java.io.FileWriter(file2, true), 8192);
        writeVersionToFile();
    }

    public static synchronized void initTMLog(android.content.Context context2) {
        if (!isInited) {
            context = context2;
            acutualInitRunnable.run();
            isInited = true;
        }
    }

    public static boolean isAppendLogTime() {
        return isAppendLogTime;
    }

    public static boolean isAppendMethodName() {
        return isAppendMethodName;
    }

    public static boolean isSDCardExistAndCanWrite() {
        return "mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.getExternalStorageDirectory().canWrite();
    }

    public static boolean isUseWriterCache() {
        return isUseWriterCache;
    }

    public static boolean isWriteLogToFile() {
        return isWriteLogToFile;
    }

    private static void log(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (i >= getLogfileOutputLevel() || i >= getLogcatOutputLevel()) {
            if (isAppendMethodName()) {
                str2 = java.lang.Thread.currentThread().getStackTrace()[4].getMethodName() + "|" + str2;
            }
            if (i >= getLogcatOutputLevel()) {
                if (i == 2 && canPrintLog()) {
                    if (th == null) {
                        android.util.Log.v(str, str2);
                    } else {
                        android.util.Log.v(str, str2, th);
                    }
                }
                if (i == 3 && canPrintLog()) {
                    if (th == null) {
                        android.util.Log.d(str, str2);
                    } else {
                        android.util.Log.d(str, str2, th);
                    }
                }
                if (i == 4) {
                    if (th == null) {
                        android.util.Log.i(str, str2);
                    } else {
                        android.util.Log.i(str, str2, th);
                    }
                }
                if (i == 5) {
                    if (th == null) {
                        android.util.Log.w(str, str2);
                    } else {
                        android.util.Log.w(str, str2, th);
                    }
                }
                if (i == 6) {
                    if (th == null) {
                        android.util.Log.e(str, str2);
                    } else {
                        android.util.Log.e(str, str2, th);
                    }
                }
            }
            if (i >= getLogfileOutputLevel()) {
                addLogItem(i, str, str2, th);
            }
        }
    }

    private static java.lang.StringBuilder obtainStringBuilder() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            if (needGetField.booleanValue()) {
                java.lang.reflect.Field declaredField = java.lang.StringBuilder.class.getSuperclass().getDeclaredField(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT);
                stringBuilderValueField = declaredField;
                declaredField.setAccessible(true);
                needGetField = java.lang.Boolean.FALSE;
            }
            if (stringBuilderValueField != null) {
                stringBuilderValueField.set(sb, stringBuilderCharBuffer.get());
            }
        } catch (java.lang.Exception unused) {
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readLocalConfig() {
        if (!isSDCardExistAndCanWrite()) {
            setWriteLogToFile(false);
            return;
        }
        java.util.Properties properties = new java.util.Properties();
        try {
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + LOG_CONFIG_FILE_PATH);
            if (file.exists()) {
                properties.load(new java.io.FileInputStream(file));
                java.lang.String property = properties.getProperty(PROP_IS_WRITE_FILE, "");
                if (property.trim().equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON)) {
                    setWriteLogToFile(true);
                } else {
                    setWriteLogToFile(false);
                }
                java.lang.String property2 = properties.getProperty(PROP_LOG_FILE_LEVEL, "");
                if (!android.text.TextUtils.isEmpty(property2)) {
                    try {
                        setLogfileOutputLevel(java.lang.Integer.valueOf(property2).intValue());
                    } catch (java.lang.NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                java.lang.String property3 = properties.getProperty(PROP_LOGCAT_LEVEL, "");
                if (!android.text.TextUtils.isEmpty(property3)) {
                    try {
                        setLogcatOutputLevel(java.lang.Integer.valueOf(property3).intValue());
                    } catch (java.lang.NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                java.lang.String property4 = properties.getProperty(PROP_DIR_PATH, "");
                setLogDirPath(property4);
                java.lang.String property5 = properties.getProperty(PROP_IS_USE_WRITER_CACHE, "");
                if (property5.trim().equals("false")) {
                    setUseWriterCache(false);
                } else {
                    setUseWriterCache(true);
                }
                if (properties.getProperty(PROP_IS_APPEND_LOG_TIME, "").trim().equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON)) {
                    setAppendLogTime(true);
                } else {
                    setAppendLogTime(false);
                }
                android.util.Log.d(TAG, "Properties Local File : isWriteLogToFile = " + property + ", fileLevel = " + property2 + ", logcatLevel = " + property3 + ", dirPath = " + property4 + ", isUseCache = " + property5 + ", isAppendMethodName = " + isAppendMethodName() + ", isAppendLogTime = " + isAppendLogTime());
                android.util.Log.d(TAG, "Log Configs : isWriteLogToFile = " + isWriteLogToFile() + ", fileLevel = " + getLogfileOutputLevel() + ", logcatLevel = " + getLogcatOutputLevel() + ", dirPath = " + getLogDirPath() + ", isUseCache = " + isUseWriterCache() + ", isAppendMethodName = " + isAppendMethodName() + ", isAppendLogTime = " + isAppendLogTime());
            }
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void setAppendLogTime(boolean z) {
        isAppendLogTime = z;
    }

    public static void setAppendMethodName(boolean z) {
        isAppendMethodName = z;
    }

    public static void setLogDirPath(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && str.startsWith("/") && str.endsWith("/")) {
            logDirPath = str;
        }
    }

    public static void setLogcatOutputLevel(int i) {
        logcatOutputLevel = i;
    }

    public static void setLogfileOutputLevel(int i) {
        logfileOutputLevel = i;
    }

    public static void setUseWriterCache(boolean z) {
        isUseWriterCache = z;
    }

    public static void setWriteLogToFile(boolean z) {
        isWriteLogToFile = z;
    }

    public static synchronized void switchCloudLogConfig(boolean z) {
        LOG_CONFIG_CLOUD = z;
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        log(2, str, str2, null);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(2, str, str2, th);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        log(5, str, str2, null);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(5, str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeLogToFile(java.lang.String str) {
        if (isWriteLogToFile()) {
            if (writer == null) {
                android.util.Log.d(TAG, "can not write log.");
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                long j = b;
                if (j == 0) {
                    b = jCurrentTimeMillis;
                } else if (jCurrentTimeMillis - j > INTERNAL) {
                    try {
                        initLogFile();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    b = jCurrentTimeMillis;
                }
            } else if (c.tryLock()) {
                try {
                    writer.write(str);
                    if (!isUseWriterCache()) {
                        writer.flush();
                    }
                    c.unlock();
                } catch (java.lang.Throwable th) {
                    c.unlock();
                    throw th;
                }
            } else if (!addLogToCache(str)) {
                android.util.Log.d(TAG, "addLogToCache failed!");
            }
            isPreExceptionEnospc.compareAndSet(true, false);
        }
    }

    private static void writeVersionToFile() throws java.io.IOException {
        if (writer == null || !isWriteLogToFile()) {
            return;
        }
        writer.write("SDK_VERSION = 1004|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
        writer.flush();
    }
}
