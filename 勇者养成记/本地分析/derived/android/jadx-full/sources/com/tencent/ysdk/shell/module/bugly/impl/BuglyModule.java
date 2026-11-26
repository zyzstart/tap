package com.tencent.ysdk.shell.module.bugly.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuglyModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.bugly.BuglyInterface {
    private com.tencent.ysdk.module.bugly.BuglyListener mBuglyListener = null;

    public BuglyModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getCrashExtMessage() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-OnCrashExtMessageNotify");
        if (this.mBuglyListener != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "mBuglyListener.OnCrashExtMessageNotify");
            return this.mBuglyListener.OnCrashExtMessageNotify();
        }
        try {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "BuglyNativeListener.OnCrashExtMessageNotify");
            return com.tencent.ysdk.shell.module.bugly.BuglyNativeListener.OnCrashExtMessageNotify();
        } catch (java.lang.UnsatisfiedLinkError unused) {
            com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-BuglyListener not set");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCrash(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        switch (i) {
            case 0:
                str4 = "JAVA_CRASH";
                break;
            case 1:
                str4 = "JAVA_CATCH";
                break;
            case 2:
                str4 = "JAVA_NATIVE";
                break;
            case 3:
                str4 = "JAVA_U3D";
                break;
            default:
                str4 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                break;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "Crash Happen Type:" + i + " TypeName:" + str4);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("errorType:");
        sb.append(str);
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, sb.toString());
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "errorMessage:" + str2);
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "errorStack:" + str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] onCrashExtDataNotify() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-OnCrashExtDataNotify");
        if (this.mBuglyListener != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "mBuglyListener.OnCrashExtDataNotify");
            return this.mBuglyListener.OnCrashExtDataNotify();
        }
        try {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "BuglyNativeListener.OnCrashExtDataNotify");
            return com.tencent.ysdk.shell.module.bugly.BuglyNativeListener.OnCrashExtDataNotify();
        } catch (java.lang.UnsatisfiedLinkError unused) {
            byte[] bytes = "".getBytes();
            com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-BuglyListener not set");
            return bytes;
        }
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_STAT_BUGLY_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.bugly.BuglyInterface.LOG_TAG, "bugly module is closed!");
            return;
        }
        com.tencent.bugly.opengame.crashreport.CrashReport.UserStrategy userStrategy = new com.tencent.bugly.opengame.crashreport.CrashReport.UserStrategy(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        userStrategy.setAppPackageName(com.tencent.ysdk.BuildConfig.LIBRARY_PACKAGE_NAME);
        userStrategy.setAppVersion(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        userStrategy.setAppChannel(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        userStrategy.setAppReportDelay(5000L);
        userStrategy.setCrashHandleCallback(new com.tencent.bugly.opengame.crashreport.CrashReport.CrashHandleCallback() { // from class: com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.1
            @Override // com.tencent.bugly.opengame.BuglyStrategy.a
            public synchronized java.util.Map<java.lang.String, java.lang.String> onCrashHandleStart(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
                java.util.Map<java.lang.String, java.lang.String> mapOnCrashHandleStart;
                com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.this.logCrash(i, str, str2, str3);
                mapOnCrashHandleStart = super.onCrashHandleStart(i, str, str2, str3);
                if (mapOnCrashHandleStart == null) {
                    mapOnCrashHandleStart = new java.util.HashMap<>();
                }
                mapOnCrashHandleStart.put("ysdkver", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
                mapOnCrashHandleStart.put("extmsg", com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.this.getCrashExtMessage());
                return mapOnCrashHandleStart;
            }

            @Override // com.tencent.bugly.opengame.BuglyStrategy.a
            public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
                com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.this.logCrash(i, str, str2, str3);
                return com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.this.onCrashExtDataNotify();
            }
        });
        com.tencent.bugly.opengame.crashreport.CrashReport.initCrashReport(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId(), false, userStrategy);
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.user.UserInnerLoginListener() { // from class: com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.2
            @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
            public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
                com.tencent.bugly.opengame.crashreport.CrashReport.setUserId(userLoginRet.open_id);
            }
        });
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.bugly.impl.BuglyModule.3
            @Override // java.lang.Runnable
            public void run() {
                android.content.SharedPreferences.Editor editorEdit = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
                editorEdit.putString("900016566", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
                editorEdit.commit();
            }
        });
    }

    @Override // com.tencent.ysdk.shell.module.bugly.BuglyInterface
    public void setBuglyListener(com.tencent.ysdk.module.bugly.BuglyListener buglyListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-setBuglyListener");
        this.mBuglyListener = buglyListener;
    }
}
