package com.tencent.bugly.opengame.crashreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CrashReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.content.Context f328a;

    public static class CrashHandleCallback extends com.tencent.bugly.opengame.BuglyStrategy.a {
    }

    public static class UserStrategy extends com.tencent.bugly.opengame.BuglyStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.bugly.opengame.crashreport.CrashReport.CrashHandleCallback f330a;

        public UserStrategy(android.content.Context context) {
        }

        @Override // com.tencent.bugly.opengame.BuglyStrategy
        public synchronized com.tencent.bugly.opengame.crashreport.CrashReport.CrashHandleCallback getCrashHandleCallback() {
            return this.f330a;
        }

        public synchronized void setCrashHandleCallback(com.tencent.bugly.opengame.crashreport.CrashReport.CrashHandleCallback crashHandleCallback) {
            this.f330a = crashHandleCallback;
        }
    }

    public interface WebViewInterface {
        void addJavascriptInterface(com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface h5JavaScriptInterface, java.lang.String str);

        java.lang.CharSequence getContentDescription();

        java.lang.String getUrl();

        void loadUrl(java.lang.String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        java.lang.String str;
        java.lang.String str2;
        if (!com.tencent.bugly.opengame.b.f327a) {
            str = com.tencent.bugly.opengame.proguard.x.f412a;
            str2 = "Can not close bugly because bugly is disable.";
        } else {
            if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
                if (f328a == null) {
                    return;
                }
                com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver buglyBroadcastReceiver = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.getInstance();
                if (buglyBroadcastReceiver != null) {
                    buglyBroadcastReceiver.unregister(f328a);
                }
                closeCrashReport();
                com.tencent.bugly.opengame.crashreport.biz.b.a(f328a);
                com.tencent.bugly.opengame.proguard.w wVarA = com.tencent.bugly.opengame.proguard.w.a();
                if (wVarA != null) {
                    wVarA.b();
                    return;
                }
                return;
            }
            str = com.tencent.bugly.opengame.proguard.x.f412a;
            str2 = "CrashReport has not been initialed! pls to call method 'initCrashReport' first!";
        }
        android.util.Log.w(str, str2);
    }

    public static void closeCrashReport() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not close crash report because bugly is disable.");
        } else if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.crashreport.crash.c.a().d();
        } else {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not close native report because bugly is disable.");
        } else if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.crashreport.crash.c.a().f();
        } else {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z) {
        com.tencent.bugly.opengame.b.f327a = z;
    }

    public static void enableObtainId(android.content.Context context, boolean z) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set DB name because bugly is disable.");
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "enableObtainId args context should not be null");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Enable identification obtaining? " + z);
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).b(z);
    }

    public static java.util.Set getAllUserDataKeys(android.content.Context context) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get all keys of user data because bugly is disable.");
            return new java.util.HashSet();
        }
        if (context != null) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).E();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "getAllUserDataKeys args context should not be null");
        return new java.util.HashSet();
    }

    public static java.lang.String getAppChannel() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get App channel because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(f328a).l;
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String getAppID() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get App ID because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(f328a).f();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String getAppVer() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get app version because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(f328a).j;
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String getBuglyVersion(android.content.Context context) {
        if (context == null) {
            com.tencent.bugly.opengame.proguard.x.d("Please call with context.", new java.lang.Object[0]);
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
        return com.tencent.bugly.opengame.crashreport.common.info.a.c();
    }

    public static java.net.Proxy getHttpProxy() {
        return com.tencent.bugly.opengame.proguard.a.b();
    }

    public static java.util.Map getSdkExtraData() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get SDK extra data because bugly is disable.");
            return new java.util.HashMap();
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(f328a).A;
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return null;
    }

    public static java.util.Map getSdkExtraData(android.content.Context context) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get SDK extra data because bugly is disable.");
            return new java.util.HashMap();
        }
        if (context != null) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).A;
        }
        com.tencent.bugly.opengame.proguard.x.d("Context should not be null.", new java.lang.Object[0]);
        return null;
    }

    public static java.lang.String getUserData(android.content.Context context, java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get user data because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (context == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "getUserDataValue args context should not be null");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.proguard.z.a(str)) {
            return null;
        }
        return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).g(str);
    }

    public static int getUserDatasSize(android.content.Context context) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).D();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "getUserDatasSize args context should not be null");
        return -1;
    }

    public static java.lang.String getUserId() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get user ID because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(f328a).g();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static int getUserSceneTagId(android.content.Context context) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).H();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "getUserSceneTagId args context should not be null");
        return -1;
    }

    public static void initCrashReport(android.content.Context context) {
        f328a = context;
        com.tencent.bugly.opengame.b.a(com.tencent.bugly.opengame.CrashModule.getInstance());
        com.tencent.bugly.opengame.b.a(context);
    }

    public static void initCrashReport(android.content.Context context, com.tencent.bugly.opengame.crashreport.CrashReport.UserStrategy userStrategy) {
        f328a = context;
        com.tencent.bugly.opengame.b.a(com.tencent.bugly.opengame.CrashModule.getInstance());
        com.tencent.bugly.opengame.b.a(context, userStrategy);
    }

    public static void initCrashReport(android.content.Context context, java.lang.String str, boolean z) {
        if (context != null) {
            f328a = context;
            com.tencent.bugly.opengame.b.a(com.tencent.bugly.opengame.CrashModule.getInstance());
            com.tencent.bugly.opengame.b.a(context, str, z, null);
        }
    }

    public static void initCrashReport(android.content.Context context, java.lang.String str, boolean z, com.tencent.bugly.opengame.crashreport.CrashReport.UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f328a = context;
        com.tencent.bugly.opengame.b.a(com.tencent.bugly.opengame.CrashModule.getInstance());
        com.tencent.bugly.opengame.b.a(context, str, z, userStrategy);
    }

    public static boolean isLastSessionCrash() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.opengame.crashreport.crash.c.a().b();
        }
        android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return false;
    }

    public static void postCatchedException(java.lang.Throwable th) {
        postCatchedException(th, java.lang.Thread.currentThread(), false);
    }

    public static void postCatchedException(java.lang.Throwable th, java.lang.Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(java.lang.Throwable th, java.lang.Thread thread, boolean z) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th == null) {
            com.tencent.bugly.opengame.proguard.x.d("throwable is null, just return", new java.lang.Object[0]);
            return;
        }
        if (thread == null) {
            thread = java.lang.Thread.currentThread();
        }
        com.tencent.bugly.opengame.crashreport.crash.c.a().a(thread, th, false, (java.lang.String) null, (byte[]) null, z);
    }

    public static void postException(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        postException(java.lang.Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postException(java.lang.Thread thread, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not post crash caught because bugly is disable.");
        } else if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.crashreport.crash.d.a(thread, i, str, str2, str3, map);
        } else {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null || com.tencent.bugly.opengame.proguard.z.a(str) || com.tencent.bugly.opengame.proguard.z.a(str2)) {
            return;
        }
        java.lang.String strReplace = str.replace("[a-zA-Z[0-9]]+", "");
        if (strReplace.length() > 100) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, java.lang.String.format("putSdkData key length over limit %d, will be cutted.", 50));
            strReplace = strReplace.substring(0, 50);
        }
        if (str2.length() > 500) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, java.lang.String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).c(strReplace, str2);
        com.tencent.bugly.opengame.proguard.x.b(java.lang.String.format("[param] putSdkData data: %s - %s", strReplace, str2), new java.lang.Object[0]);
    }

    public static void putUserData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            java.lang.String str3 = str;
            com.tencent.bugly.opengame.proguard.x.d("putUserData args key should not be null or empty", new java.lang.Object[0]);
            return;
        }
        if (str2 == null) {
            java.lang.String str4 = str2;
            com.tencent.bugly.opengame.proguard.x.d("putUserData args value should not be null", new java.lang.Object[0]);
            return;
        }
        if (!str.matches("[a-zA-Z[0-9]]+")) {
            com.tencent.bugly.opengame.proguard.x.d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new java.lang.Object[0]);
            return;
        }
        if (str2.length() > 200) {
            com.tencent.bugly.opengame.proguard.x.d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.opengame.crashreport.common.info.a aVarA = com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
        if (aVarA.E().contains(str)) {
            com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.opengame.crashreport.common.info.a.a(context).b(str, str2);
            com.tencent.bugly.opengame.proguard.x.c("replace KV %s %s", str, str2);
            return;
        }
        if (aVarA.D() >= 10) {
            com.tencent.bugly.opengame.proguard.x.d("user data size is over limit %d, it will be cutted!", 10);
            return;
        }
        if (str.length() > 50) {
            com.tencent.bugly.opengame.proguard.x.d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler2 = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).b(str, str2);
        com.tencent.bugly.opengame.proguard.x.b("[param] set user data: %s - %s", str, str2);
    }

    public static java.lang.String removeUserData(android.content.Context context, java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not remove user data because bugly is disable.");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (context == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "removeUserData args context should not be null");
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (com.tencent.bugly.opengame.proguard.z.a(str)) {
            return null;
        }
        com.tencent.bugly.opengame.proguard.x.b("[param] remove user data: %s", str);
        return com.tencent.bugly.opengame.crashreport.common.info.a.a(context).f(str);
    }

    public static void setAppChannel(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (!com.tencent.bugly.opengame.b.f327a) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "Can not set App channel because Bugly is disable.";
        } else if (context == null) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "setAppChannel args context should not be null";
        } else {
            if (str != null) {
                com.tencent.bugly.opengame.crashreport.common.info.a.a(context).l = str;
                com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.setNativeAppChannel(str);
                    return;
                }
                return;
            }
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "App channel is null, will not set";
        }
        android.util.Log.w(str2, str3);
    }

    public static void setAppPackage(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (!com.tencent.bugly.opengame.b.f327a) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "Can not set App package because bugly is disable.";
        } else if (context == null) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "setAppPackage args context should not be null";
        } else {
            if (str != null) {
                com.tencent.bugly.opengame.crashreport.common.info.a.a(context).c = str;
                com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.setNativeAppPackage(str);
                    return;
                }
                return;
            }
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "App package is null, will not set";
        }
        android.util.Log.w(str2, str3);
    }

    public static void setAppVersion(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (!com.tencent.bugly.opengame.b.f327a) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "Can not set App version because bugly is disable.";
        } else if (context == null) {
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "setAppVersion args context should not be null";
        } else {
            if (str != null) {
                com.tencent.bugly.opengame.crashreport.common.info.a.a(context).j = str;
                com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.setNativeAppVersion(str);
                    return;
                }
                return;
            }
            str2 = com.tencent.bugly.opengame.proguard.x.f412a;
            str3 = "App version is null, will not set";
        }
        android.util.Log.w(str2, str3);
    }

    public static void setAuditEnable(android.content.Context context, boolean z) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "setAppPackage args context should not be null");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Set audit enable: " + z);
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).B = z;
    }

    public static void setBuglyDbName(java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set DB name because bugly is disable.");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Set Bugly DB name: " + str);
        com.tencent.bugly.opengame.proguard.q.f403a = str;
    }

    public static void setContext(android.content.Context context) {
        f328a = context;
    }

    public static void setCrashFilter(java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set App package because bugly is disable.");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Set crash stack filter: " + str);
        com.tencent.bugly.opengame.crashreport.crash.c.n = str;
    }

    public static void setCrashRegularFilter(java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set App package because bugly is disable.");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Set crash stack filter: " + str);
        com.tencent.bugly.opengame.crashreport.crash.c.o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set App package because bugly is disable.");
            return;
        }
        android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "Should handle native crash in Java profile after handled in native profile: " + z);
        com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(java.lang.String str, int i) {
        com.tencent.bugly.opengame.proguard.a.a(str, i);
    }

    public static void setHttpProxy(java.net.InetAddress inetAddress, int i) {
        com.tencent.bugly.opengame.proguard.a.a(inetAddress, i);
    }

    public static void setIsAppForeground(android.content.Context context, boolean z) {
        java.lang.Object[] objArr;
        java.lang.String str;
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set 'isAppForeground' because bugly is disable.");
            return;
        }
        if (context == null) {
            com.tencent.bugly.opengame.proguard.x.d("Context should not be null.", new java.lang.Object[0]);
            return;
        }
        if (z) {
            objArr = new java.lang.Object[0];
            str = "App is in foreground.";
        } else {
            objArr = new java.lang.Object[0];
            str = "App is in background.";
        }
        com.tencent.bugly.opengame.proguard.x.c(str, objArr);
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).a(z);
    }

    public static void setIsDevelopmentDevice(android.content.Context context, boolean z) {
        java.lang.Object[] objArr;
        java.lang.String str;
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            com.tencent.bugly.opengame.proguard.x.d("Context should not be null.", new java.lang.Object[0]);
            return;
        }
        if (z) {
            objArr = new java.lang.Object[0];
            str = "This is a development device.";
        } else {
            objArr = new java.lang.Object[0];
            str = "This is not a development device.";
        }
        com.tencent.bugly.opengame.proguard.x.c(str, objArr);
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).y = z;
    }

    public static boolean setJavascriptMonitor(android.webkit.WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final android.webkit.WebView webView, boolean z, boolean z2) {
        if (webView != null) {
            return setJavascriptMonitor(new com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface() { // from class: com.tencent.bugly.opengame.crashreport.CrashReport.1
                @Override // com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface
                public final void addJavascriptInterface(com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface h5JavaScriptInterface, java.lang.String str) {
                    webView.addJavascriptInterface(h5JavaScriptInterface, str);
                }

                @Override // com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface
                public final java.lang.CharSequence getContentDescription() {
                    return webView.getContentDescription();
                }

                @Override // com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface
                public final java.lang.String getUrl() {
                    return webView.getUrl();
                }

                @Override // com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface
                public final void loadUrl(java.lang.String str) {
                    webView.loadUrl(str);
                }

                @Override // com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface
                public final void setJavaScriptEnabled(boolean z3) {
                    android.webkit.WebSettings settings = webView.getSettings();
                    if (settings.getJavaScriptEnabled()) {
                        return;
                    }
                    settings.setJavaScriptEnabled(true);
                }
            }, z, z2);
        }
        android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "WebView is null.");
        return false;
    }

    public static boolean setJavascriptMonitor(com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(com.tencent.bugly.opengame.crashreport.CrashReport.WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "WebViewInterface is null.");
            return false;
        }
        if (!com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.proguard.x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.opengame.proguard.x.a("Set Javascript exception monitor of webview.", new java.lang.Object[0]);
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        com.tencent.bugly.opengame.proguard.x.c("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && android.os.Build.VERSION.SDK_INT < 19) {
            com.tencent.bugly.opengame.proguard.x.e("This interface is only available for Android 4.4 or later.", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.opengame.proguard.x.a("Enable the javascript needed by webview monitor.", new java.lang.Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface h5JavaScriptInterface = com.tencent.bugly.opengame.crashreport.crash.h5.H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            com.tencent.bugly.opengame.proguard.x.a("Add a secure javascript interface to the webview.", new java.lang.Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            com.tencent.bugly.opengame.proguard.x.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.opengame.crashreport.crash.h5.b.b());
            java.lang.String strA = com.tencent.bugly.opengame.crashreport.crash.h5.b.a();
            if (strA == null) {
                com.tencent.bugly.opengame.proguard.x.e("Failed to inject Bugly.js.", com.tencent.bugly.opengame.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + strA);
        }
        return true;
    }

    public static void setSdkExtraData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not put SDK extra data because bugly is disable.");
        } else {
            if (context == null || com.tencent.bugly.opengame.proguard.z.a(str) || com.tencent.bugly.opengame.proguard.z.a(str2)) {
                return;
            }
            com.tencent.bugly.opengame.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static void setServerUrl(java.lang.String str) {
        if (com.tencent.bugly.opengame.proguard.z.a(str) || !com.tencent.bugly.opengame.proguard.z.c(str)) {
            android.util.Log.i(com.tencent.bugly.opengame.proguard.x.f412a, "URL is invalid.");
            return;
        }
        com.tencent.bugly.opengame.crashreport.common.strategy.a.a(str);
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.b = str;
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.c = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (com.tencent.bugly.opengame.b.f327a) {
            com.tencent.bugly.opengame.crashreport.biz.b.a(j);
        } else {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(android.content.Context context, java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "Context should not be null when bugly has not been initialed!");
            return;
        }
        if (str == null) {
            com.tencent.bugly.opengame.proguard.x.d("userId should not be null", new java.lang.Object[0]);
            return;
        }
        if (str.length() > 100) {
            java.lang.String strSubstring = str.substring(0, 100);
            com.tencent.bugly.opengame.proguard.x.d("userId %s length is over limit %d substring to %s", str, 100, strSubstring);
            str = strSubstring;
        }
        if (str.equals(com.tencent.bugly.opengame.crashreport.common.info.a.a(context).g())) {
            return;
        }
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).b(str);
        com.tencent.bugly.opengame.proguard.x.b("[user] set userId : %s", str);
        com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = com.tencent.bugly.opengame.crashreport.crash.jni.NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.crashreport.biz.b.a();
        }
    }

    public static void setUserId(java.lang.String str) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set user ID because bugly is disable.");
        } else if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            setUserId(f328a, str);
        } else {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(android.content.Context context, int i) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "setTag args context should not be null");
            return;
        }
        if (i <= 0) {
            com.tencent.bugly.opengame.proguard.x.d("setTag args tagId should > 0", new java.lang.Object[0]);
        }
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).a(i);
        com.tencent.bugly.opengame.proguard.x.b("[param] set user scene tag: %d", java.lang.Integer.valueOf(i));
    }

    public static void startCrashReport() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not start crash report because bugly is disable.");
        } else if (com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.opengame.crashreport.crash.c.a().c();
        } else {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not test ANR crash because bugly is disable.");
        } else if (!com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            com.tencent.bugly.opengame.proguard.x.a("start to create a anr crash for test!", new java.lang.Object[0]);
            com.tencent.bugly.opengame.crashreport.crash.c.a().j();
        }
    }

    public static void testJavaCrash() {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not test Java crash because bugly is disable.");
        } else {
            if (!com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
                android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
            if (aVarB != null) {
                aVarB.b(24096);
            }
            throw new java.lang.RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!com.tencent.bugly.opengame.b.f327a) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "Can not test native crash because bugly is disable.");
        } else if (!com.tencent.bugly.opengame.CrashModule.getInstance().hasInitialized()) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            com.tencent.bugly.opengame.proguard.x.a("start to create a native crash for test!", new java.lang.Object[0]);
            com.tencent.bugly.opengame.crashreport.crash.c.a().a(z, z2, z3);
        }
    }
}
