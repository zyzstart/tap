package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class TbsLinuxToolsJni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f861a = false;
    private static boolean b = false;

    public TbsLinuxToolsJni(android.content.Context context) {
        a(context);
    }

    private native int ChmodInner(java.lang.String str, java.lang.String str2);

    private void a(android.content.Context context) {
        java.io.File fileQ;
        synchronized (com.tencent.smtt.sdk.TbsLinuxToolsJni.class) {
            com.tencent.smtt.utils.TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
            if (b) {
                return;
            }
            b = true;
            try {
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                    java.lang.String strA = com.tencent.smtt.sdk.TbsShareManager.a();
                    if (strA == null) {
                        strA = com.tencent.smtt.sdk.TbsShareManager.c(context);
                    }
                    fileQ = new java.io.File(strA);
                } else {
                    fileQ = com.tencent.smtt.sdk.m.a().q(context);
                }
                if (fileQ != null) {
                    if (!new java.io.File(fileQ.getAbsolutePath() + java.io.File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() && !com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                        fileQ = com.tencent.smtt.sdk.m.a().p(context);
                    }
                    if (fileQ != null) {
                        com.tencent.smtt.utils.TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + fileQ.getAbsolutePath());
                        java.lang.System.load(fileQ.getAbsolutePath() + java.io.File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        f861a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                f861a = false;
                com.tencent.smtt.utils.TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + th.getMessage() + " ## " + th.getCause());
            }
        }
    }

    public int a(java.lang.String str, java.lang.String str2) {
        if (f861a) {
            return ChmodInner(str, str2);
        }
        com.tencent.smtt.utils.TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
