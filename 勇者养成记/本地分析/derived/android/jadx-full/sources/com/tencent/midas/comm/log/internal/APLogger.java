package com.tencent.midas.comm.log.internal;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogger {
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_SILENT = 6;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    private com.tencent.midas.comm.log.internal.APLogAppender appender = null;

    private APLogger() {
    }

    public static void log(int i, java.lang.String str, java.lang.String str2) {
        int i2 = 0;
        while (i2 < str2.length()) {
            try {
                int i3 = i2 + 3600;
                java.lang.String strSubstring = str2.length() <= i3 ? str2.substring(i2) : str2.substring(i2, i3);
                switch (i) {
                    case 1:
                        android.util.Log.v(str, strSubstring);
                        break;
                    case 2:
                        android.util.Log.d(str, strSubstring);
                        break;
                    case 3:
                        android.util.Log.i(str, strSubstring);
                        break;
                    case 4:
                        android.util.Log.w(str, strSubstring);
                        break;
                    case 5:
                    case 6:
                        android.util.Log.e(str, strSubstring);
                        break;
                }
                i2 = i3;
            } catch (java.lang.Throwable th) {
                android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "print log error: <%s>%s", th.getClass().getName(), th.getMessage()));
                return;
            }
        }
    }

    public static com.tencent.midas.comm.log.internal.APLogger open() {
        com.tencent.midas.comm.log.internal.APLogger aPLogger = new com.tencent.midas.comm.log.internal.APLogger();
        aPLogger.openAppender();
        return aPLogger;
    }

    private void openAppender() {
        this.appender = com.tencent.midas.comm.log.internal.APLogAppender.open();
    }

    public void flush() {
        try {
            if (this.appender != null) {
                this.appender.flushAndWrite();
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.midas.comm.APLogInfo.LOG_TAG, java.lang.String.format(java.util.Locale.CHINA, "flush log error: %s\n, stackTrace: %s", th.toString(), th.getStackTrace()[3]));
        }
    }

    public void write(java.lang.String str) {
        this.appender.append(str);
    }
}
