package com.tencent.open.web.security;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JniInterface {
    public static boolean isJniOk = false;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native java.lang.String d1(java.lang.String str);

    public static native java.lang.String d2(java.lang.String str);

    public static native java.lang.String getPWDKeyToMD5(java.lang.String str);

    public static native boolean insetTextToArray(int i, java.lang.String str, int i2);

    public static void loadSo() {
        java.lang.String str;
        java.lang.StringBuilder sb;
        if (isJniOk) {
            return;
        }
        try {
            android.content.Context contextA = com.tencent.open.utils.f.a();
            if (contextA != null) {
                if (new java.io.File(contextA.getFilesDir().toString() + "/" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME).exists()) {
                    java.lang.System.load(contextA.getFilesDir().toString() + "/" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    str = "openSDK_LOG.JniInterface";
                    sb = new java.lang.StringBuilder();
                    sb.append("-->load lib success:");
                    sb.append(com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                } else {
                    str = "openSDK_LOG.JniInterface";
                    sb = new java.lang.StringBuilder();
                    sb.append("-->fail, because so is not exists:");
                    sb.append(com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                str = "openSDK_LOG.JniInterface";
                sb = new java.lang.StringBuilder();
                sb.append("-->load lib fail, because context is null:");
                sb.append(com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
            }
            com.tencent.open.log.SLog.i(str, sb.toString());
        } catch (java.lang.Throwable th) {
            com.tencent.open.log.SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
