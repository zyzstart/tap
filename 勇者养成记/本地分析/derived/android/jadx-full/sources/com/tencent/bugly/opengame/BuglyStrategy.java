package com.tencent.bugly.opengame;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuglyStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f325a;
    private java.lang.String b;
    private java.lang.String c;
    private long d;
    private java.lang.String e;
    private java.lang.String f;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private java.lang.Class j = null;
    private boolean k = true;
    private boolean l = true;
    private boolean m = true;
    private boolean n = false;
    private com.tencent.bugly.opengame.BuglyStrategy.a o;

    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized java.util.Map onCrashHandleStart(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            return null;
        }
    }

    public synchronized java.lang.String getAppChannel() {
        java.lang.String str = this.b;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.opengame.crashreport.common.info.a.b().l;
    }

    public synchronized java.lang.String getAppPackageName() {
        java.lang.String str = this.c;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.opengame.crashreport.common.info.a.b().c;
    }

    public synchronized long getAppReportDelay() {
        return this.d;
    }

    public synchronized java.lang.String getAppVersion() {
        java.lang.String str = this.f325a;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.opengame.crashreport.common.info.a.b().j;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy.a getCrashHandleCallback() {
        return this.o;
    }

    public synchronized java.lang.String getDeviceID() {
        return this.f;
    }

    public synchronized java.lang.String getLibBuglySOFilePath() {
        return this.e;
    }

    public synchronized java.lang.Class getUserInfoActivity() {
        return this.j;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.k;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.h;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.g;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.i;
    }

    public boolean isReplaceOldChannel() {
        return this.l;
    }

    public synchronized boolean isUploadProcess() {
        return this.m;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.n;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setAppChannel(java.lang.String str) {
        this.b = str;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setAppPackageName(java.lang.String str) {
        this.c = str;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setAppReportDelay(long j) {
        this.d = j;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setAppVersion(java.lang.String str) {
        this.f325a = str;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setBuglyLogUpload(boolean z) {
        this.k = z;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setCrashHandleCallback(com.tencent.bugly.opengame.BuglyStrategy.a aVar) {
        this.o = aVar;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setDeviceID(java.lang.String str) {
        this.f = str;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.h = z;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.g = z;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setEnableUserInfo(boolean z) {
        this.i = z;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setLibBuglySOFilePath(java.lang.String str) {
        this.e = str;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.n = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.l = z;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setUploadProcess(boolean z) {
        this.m = z;
        return this;
    }

    public synchronized com.tencent.bugly.opengame.BuglyStrategy setUserInfoActivity(java.lang.Class cls) {
        this.j = cls;
        return this;
    }
}
