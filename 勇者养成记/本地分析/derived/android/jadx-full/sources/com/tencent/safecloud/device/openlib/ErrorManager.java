package com.tencent.safecloud.device.openlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ErrorManager {
    public static final int ERR_ARGUMENTS = -1;
    public static final int ERR_GENERINIT = -3;
    public static final int ERR_GETID = -5;
    public static final int ERR_INIT = -2;
    public static final int ERR_NONE = 0;
    public static final int ERR_TOKEN = -4;
    private static java.util.concurrent.ConcurrentHashMap errorMap = new java.util.concurrent.ConcurrentHashMap();

    public enum eError {
        ERROR_INIT("000"),
        ERROR_LOAD_SO("101"),
        ERROR_LOAD_CORE("102"),
        ERROR_DATA("103"),
        ERROR_GEN_TOKEN("[REDACTED]"),
        ERROR_GEN_TOKEN_NET("[REDACTED]"),
        ERROR_GEN_TOKEN_OTHER("[REDACTED]"),
        ERROR_GEN_TOKEN_PARSER("[REDACTED]"),
        ERROR_GEN_FP("108"),
        ERROR_GEN_FP_PARSER("109"),
        ERROR_GEN_FP_NET("110"),
        ERROR_GEN_FP_OTHER("111"),
        ERROR_T1("200"),
        ERROR_T1_1("201"),
        ERROR_T1_2("202"),
        ERROR_T1_3("203"),
        ERROR_T1_4("204"),
        ERROR_T1_5("205"),
        ERROR_T1_6("206"),
        ERROR_T1_7("207"),
        ERROR_T1_8("208"),
        ERROR_T1_9("209"),
        ERROR_T1_10("210"),
        ERROR_T1_11("211"),
        ERROR_T1_12("212"),
        ERROR_T1_13("213"),
        ERROR_T2("220"),
        ERROR_T2_1("221"),
        ERROR_T2_2("222"),
        ERROR_T2_3("223"),
        ERROR_T2_4("224"),
        ERROR_T2_5("225"),
        ERROR_T2_6("226"),
        ERROR_T2_7("227"),
        ERROR_T2_8("228"),
        ERROR_T2_9("229"),
        ERROR_T2_10("230"),
        ERROR_T3("240"),
        ERROR_T3_1("241"),
        ERROR_T3_2("242"),
        ERROR_T3_3("243"),
        ERROR_T3_4("244"),
        ERROR_T3_5("245"),
        ERROR_T3_6("246"),
        ERROR_T3_7("247"),
        ERROR_T3_8("248"),
        ERROR_T3_9("249"),
        ERROR_DEV_T("250"),
        ERROR_TIMEOUT("300"),
        ERROR_NULL_DATA("400"),
        ERROR_NULL_DATA1("401"),
        ERROR_NULL_DATA2("402"),
        ERROR_TIMEALL("500"),
        ERROR_GETID("600"),
        ERROT_END("10000");

        private java.lang.String code;

        eError(java.lang.String str) {
            this.code = str;
        }

        public final java.lang.String code() {
            return this.code;
        }
    }

    public static void addError(com.tencent.safecloud.device.openlib.ErrorManager.eError eerror, java.lang.String[] strArr) {
        if (errorMap.containsKey(eerror.code())) {
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            errorMap.put(eerror.code(), "");
        } else {
            errorMap.put(eerror.code(), strArr[0]);
        }
    }

    public static void addTime(java.lang.String str) {
        if (errorMap.containsKey(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_TIMEALL.code())) {
            str = ((java.lang.String) errorMap.get(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_TIMEALL.code())) + ";" + str;
        } else if (com.tencent.safecloud.device.openlib.CheckUtils.isNullStr(str)) {
            return;
        }
        errorMap.put(com.tencent.safecloud.device.openlib.ErrorManager.eError.ERROR_TIMEALL.code(), str);
    }

    public static java.lang.String catchMsg(java.lang.Throwable th) {
        if (th == null) {
            return " unknown";
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(" ");
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName().contains("com.tencent.safecloud.device")) {
                    sb.append("{message:");
                    sb.append(stackTrace[i].toString());
                    sb.append(",caused:");
                    sb.append(th.toString() + "}");
                }
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return " unknown";
        }
    }

    public static void clearError() {
        errorMap.clear();
    }

    public static java.util.Map getErrorMap() {
        return errorMap;
    }

    public static java.lang.String getErrorMsgAll() {
        return errorMap.toString();
    }

    public static boolean hasError() {
        return !errorMap.isEmpty();
    }

    public static void remove(com.tencent.safecloud.device.openlib.ErrorManager.eError eerror) {
        errorMap.remove(eerror.code());
    }
}
