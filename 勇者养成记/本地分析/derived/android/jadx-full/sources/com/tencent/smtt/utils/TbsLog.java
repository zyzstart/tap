package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final java.lang.String X5LOGTAG = "x5logtag";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f956a = false;
    private static boolean b = true;
    private static com.tencent.smtt.utils.TbsLogClient c;
    public static java.util.List sTbsLogList = new java.util.LinkedList();
    public static int sLogMaxCount = 10;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void addLog(int i, java.lang.String str, java.lang.Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                java.lang.String str2 = null;
                if (str != null) {
                    try {
                        str2 = java.lang.String.format(str, objArr);
                    } catch (java.lang.Exception unused) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(java.lang.String.format("[%d][%d][%c][%d]%s", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()), 1, '0', java.lang.Integer.valueOf(i), str2));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void app_extra(java.lang.String str, android.content.Context context) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            int i = 0;
            java.lang.String[] strArr = {com.tencent.smtt.sdk.TbsConfig.APP_DEMO, com.tencent.smtt.sdk.TbsConfig.APP_QB, "com.tencent.mm", "com.tencent.mobileqq", com.tencent.smtt.sdk.TbsConfig.APP_DEMO_TEST, "com.qzone"};
            java.lang.String[] strArr2 = {"DEMO", "QB", "WX", com.tencent.connect.common.Constants.SOURCE_QQ, "TEST", "QZ"};
            while (i < 6) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    i(str, "app_extra pid:" + android.os.Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == 6) {
                i(str, "app_extra pid:" + android.os.Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (java.lang.Throwable th) {
            w(str, "app_extra exception:" + android.util.Log.getStackTraceString(th));
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.d(str, "TBS:" + str2);
    }

    public static void d(java.lang.String str, java.lang.String str2, boolean z) {
        d(str, str2);
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f956a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.e(str, "TBS:" + str2);
        c.writeLog("(E)-" + str + "-TBS:" + str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, boolean z) {
        e(str, str2);
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f956a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static java.lang.String getTbsLogFilePath() {
        java.io.File file = com.tencent.smtt.utils.TbsLogClient.c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.i(str, "TBS:" + str2);
        c.writeLog("(I)-" + str + "-TBS:" + str2);
    }

    public static void i(java.lang.String str, java.lang.String str2, boolean z) {
        i(str, str2);
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f956a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static synchronized void initIfNeed(android.content.Context context) {
        if (c == null) {
            setTbsLogClient(new com.tencent.smtt.utils.TbsLogClient(context));
        }
    }

    public static void setLogView(android.widget.TextView textView) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient;
        if (textView == null || (tbsLogClient = c) == null) {
            return;
        }
        tbsLogClient.setLogView(textView);
    }

    public static boolean setTbsLogClient(com.tencent.smtt.utils.TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        c = tbsLogClient;
        com.tencent.smtt.utils.TbsLogClient.setWriteLogJIT(b);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        b = z;
        if (c == null) {
            return;
        }
        com.tencent.smtt.utils.TbsLogClient.setWriteLogJIT(z);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.v(str, "TBS:" + str2);
    }

    public static void v(java.lang.String str, java.lang.String str2, boolean z) {
        v(str, str2);
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f956a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.w(str, "TBS:" + str2);
        c.writeLog("(W)-" + str + "-TBS:" + str2);
    }

    public static void w(java.lang.String str, java.lang.String str2, boolean z) {
        w(str, str2);
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f956a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static synchronized void writeLogToDisk() {
        com.tencent.smtt.utils.TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null) {
            tbsLogClient.writeLogToDisk();
        }
    }
}
