package com.tencent.ysdk.libware.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Logger {
    private static final int ASSERT = 7;
    private static final int DEBUG = 3;
    public static final java.lang.String DEFAULT_TAG = "YSDK";
    private static final int ERROR = 6;
    private static java.lang.String FILE_LOG = "YSDK.log";
    private static final int INFO = 4;
    public static final int LOG_BOTH = 3;
    public static final int LOG_CONSOLE = 1;
    public static final int LOG_FILE = 2;
    private static final long LOG_FILE_SIZE = 10485760;
    public static final int LOG_NULL = 0;
    private static final int STACK_TRACE_DEEP = 4;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    public static final java.lang.String YSDK_DOCTOR_TAG = "YSDK_DOCTOR";
    public static final java.lang.String YSDK_LOGIN_TAG = "YSDK_LOGIN";
    private static com.tencent.ysdk.libware.file.Logger.FileLogHandler filelogHandler = null;
    private static int logDevice = 1;

    private static class FileLogHandler extends android.os.Handler {
        private boolean hasSDCard = true;
        private java.io.File logFile;
        private java.io.FileOutputStream logOutput;

        FileLogHandler(android.content.Context context) {
            try {
                java.io.File logFile = com.tencent.ysdk.libware.file.Logger.getLogFile(context);
                this.logFile = logFile;
                if (logFile.exists()) {
                    long length = this.logFile.length();
                    if (length <= com.tencent.ysdk.libware.file.Logger.LOG_FILE_SIZE) {
                        return;
                    }
                    android.util.Log.d("YSDK", "Log size larger than LOG_FILE_SIZE:" + java.lang.String.valueOf(length));
                    this.logFile.delete();
                }
                this.logFile.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            android.util.Log.d("YSDK", "Logger file: " + this.logFile.toString());
        }

        java.io.FileOutputStream getLogOutput() {
            if (this.logOutput == null) {
                this.logOutput = new java.io.FileOutputStream(this.logFile, true);
            }
            return this.logOutput;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (this.hasSDCard) {
                try {
                    java.lang.String str = ((java.lang.String) message.obj) + "\n";
                    if (str != null) {
                        byte[] bytes = str.getBytes();
                        getLogOutput().write(bytes, 0, bytes.length);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void d(android.content.Intent intent) {
        if (logDevice == 0) {
            return;
        }
        d(getTag(null, 4), intent);
    }

    public static void d(android.os.Bundle bundle) {
        java.lang.StringBuilder sb;
        java.lang.String string;
        if (logDevice == 0) {
            return;
        }
        java.lang.String tag = getTag(null, 4);
        if (bundle == null) {
            showLog(3, tag, "empty bundle", logDevice);
            return;
        }
        for (java.lang.String string2 : bundle.keySet()) {
            if (bundle.get(string2) instanceof byte[]) {
                sb = new java.lang.StringBuilder();
                sb.append(string2);
                sb.append(":");
                string = com.tencent.ysdk.libware.encrypt.HexUtils.bytes2HexStr(bundle.getByteArray(string2));
            } else {
                if (bundle.get(string2) instanceof java.lang.String) {
                    sb = new java.lang.StringBuilder();
                    sb.append(string2);
                    sb.append(":");
                    string = bundle.getString(string2);
                } else {
                    if (bundle.get(string2) instanceof java.lang.Long) {
                        sb = new java.lang.StringBuilder();
                        sb.append(string2);
                        sb.append(":");
                        sb.append(bundle.getLong(string2));
                    } else if (bundle.get(string2) instanceof java.lang.Integer) {
                        sb = new java.lang.StringBuilder();
                        sb.append(string2);
                        sb.append(":");
                        sb.append(bundle.getInt(string2));
                    }
                    string2 = sb.toString();
                }
                showLog(3, tag, string2, logDevice);
            }
            sb.append(string);
            string2 = sb.toString();
            showLog(3, tag, string2, logDevice);
        }
    }

    public static void d(java.lang.Object obj) {
        if (logDevice == 0) {
            return;
        }
        d(getTag(null, 4), obj);
    }

    public static void d(java.lang.String str) {
        if (logDevice > 0) {
            showLog(3, getTag(null, 4), " " + str, logDevice);
        }
    }

    public static void d(java.lang.String str, android.content.Intent intent) {
        java.lang.StringBuilder sb;
        java.lang.String string;
        if (logDevice == 0) {
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            d(str, "********************** INTENT START **************************");
            showLog(3, str, "empty Intent", logDevice);
        } else {
            d(str, "********************** INTENT START **************************");
            showLog(3, str, "Action: " + intent.getAction(), logDevice);
            showLog(3, str, "Component: " + intent.getComponent(), logDevice);
            showLog(3, str, "Flags: " + intent.getFlags(), logDevice);
            showLog(3, str, "Scheme: " + intent.getScheme(), logDevice);
            android.os.Bundle extras = intent.getExtras();
            for (java.lang.String string2 : extras.keySet()) {
                if (extras.get(string2) instanceof byte[]) {
                    sb = new java.lang.StringBuilder();
                    sb.append(string2);
                    sb.append(":");
                    string = com.tencent.ysdk.libware.encrypt.HexUtils.bytes2HexStr(extras.getByteArray(string2));
                } else {
                    if (extras.get(string2) instanceof java.lang.String) {
                        sb = new java.lang.StringBuilder();
                        sb.append(string2);
                        sb.append(":");
                        string = extras.getString(string2);
                    } else {
                        if (extras.get(string2) instanceof java.lang.Long) {
                            sb = new java.lang.StringBuilder();
                            sb.append(string2);
                            sb.append(":");
                            sb.append(extras.getLong(string2));
                        } else if (extras.get(string2) instanceof java.lang.Integer) {
                            sb = new java.lang.StringBuilder();
                            sb.append(string2);
                            sb.append(":");
                            sb.append(extras.getInt(string2));
                        }
                        string2 = sb.toString();
                    }
                    showLog(3, str, string2, logDevice);
                }
                sb.append(string);
                string2 = sb.toString();
                showLog(3, str, string2, logDevice);
            }
        }
        d(str, "********************** INTENT END **************************");
    }

    public static void d(java.lang.String str, java.lang.Object obj) {
        java.lang.String string;
        int i = logDevice;
        if (i == 0) {
            return;
        }
        if (obj == null) {
            string = "empty msg";
        } else {
            if (str == null) {
                str = "YSDK";
            }
            string = obj.toString();
            i = logDevice;
        }
        showLog(3, str, string, i);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        int i = logDevice;
        if (i > 0) {
            showLog(3, str, str2, i);
        }
    }

    public static void debug(java.lang.String str, java.lang.String str2) {
        if (com.tencent.ysdk.innerapi.DynamicInnerApi.isDebugVersion()) {
            android.util.Log.d(str, str2);
        }
    }

    public static void e(java.lang.String str) {
        if (logDevice > 0) {
            showLog(6, getTag(null, 4), str, logDevice);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        int i = logDevice;
        if (i > 0) {
            showLog(6, str, str2, i);
        }
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        if (stackTrace.length > 1) {
            showLog(6, str, "class : " + stackTrace[1].getClassName() + "; line : " + stackTrace[1].getLineNumber(), logDevice);
        }
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.File getLogFile(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.ysdk.libware.file.FileUtil.getCommonRootDir(context), FILE_LOG);
        d("YSDK_DOCTOR", "LogFile:" + file.toString());
        return file;
    }

    private static java.lang.String getTag(java.lang.String str, int i) {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        if (i < 0 || i >= stackTrace.length) {
            return "";
        }
        java.lang.String className = stackTrace[i].getClassName();
        java.lang.String methodName = stackTrace[i].getMethodName();
        int iLastIndexOf = className.lastIndexOf(46);
        java.lang.String strSubstring = iLastIndexOf != -1 ? className.substring(iLastIndexOf + 1) : "";
        if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return "YSDK " + strSubstring + "." + methodName;
        }
        return "YSDK>" + str + " " + strSubstring + "." + methodName;
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2) {
        int i;
        int i2;
        try {
            i = java.lang.Integer.parseInt(str2);
        } catch (java.lang.Exception unused) {
            i = 1;
        }
        if (!com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            FILE_LOG = "YSDK-" + str + ".log";
        }
        android.util.Log.d("YSDK", "Logger type: " + i);
        switch (i) {
            case 0:
                i2 = 0;
                logDevice = i2;
                break;
            case 1:
            default:
                logDevice = 1;
                break;
            case 2:
                i2 = 2;
                logDevice = i2;
                break;
            case 3:
                i2 = 3;
                logDevice = i2;
                break;
        }
        if (logDevice <= 1 || filelogHandler != null) {
            return;
        }
        filelogHandler = new com.tencent.ysdk.libware.file.Logger.FileLogHandler(context);
    }

    private static void showInConsole(int i, java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = "NULL MSG";
        }
        switch (i) {
            case 2:
                android.util.Log.v(str, str2);
                break;
            case 3:
                android.util.Log.d(str, str2);
                break;
            case 4:
                android.util.Log.i(str, str2);
                break;
            case 5:
                android.util.Log.w(str, str2);
                break;
            case 6:
                android.util.Log.e(str, str2);
                break;
        }
    }

    private static void showLog(int i, java.lang.String str, java.lang.String str2, int i2) {
        java.lang.StringBuilder sb;
        if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
            str2 = "NULL MSG";
        }
        if (str.length() > 89) {
            showInConsole(6, "YSDK", "tag is longer than 89");
            str = str.substring(0, 86) + "...";
        }
        if (i2 == 1) {
            showInConsole(i, str, str2);
            return;
        }
        if (i2 == 2) {
            sb = new java.lang.StringBuilder();
        } else {
            if (i2 != 3) {
                return;
            }
            showInConsole(i, str, str2);
            sb = new java.lang.StringBuilder();
        }
        sb.append(java.lang.System.currentTimeMillis() / 1000);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(str2);
        writeToLog(sb.toString());
    }

    public static void w(java.lang.String str) {
        if (logDevice > 0) {
            showLog(5, getTag(null, 4), str, logDevice);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        int i = logDevice;
        if (i > 0) {
            showLog(5, str, str2, i);
        }
    }

    private static void writeToLog(java.lang.String str) {
        android.os.Message messageObtainMessage = filelogHandler.obtainMessage();
        messageObtainMessage.obj = str;
        filelogHandler.sendMessage(messageObtainMessage);
    }
}
