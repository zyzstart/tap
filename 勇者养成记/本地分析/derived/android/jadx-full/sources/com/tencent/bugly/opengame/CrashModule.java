package com.tencent.bugly.opengame;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CrashModule extends com.tencent.bugly.opengame.a {
    public static final int MODULE_ID = 1004;
    private static int c;
    private static com.tencent.bugly.opengame.CrashModule e = new com.tencent.bugly.opengame.CrashModule();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f326a;
    private com.tencent.bugly.opengame.BuglyStrategy.a b;
    private boolean d = false;

    private synchronized void a(android.content.Context context, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        java.lang.String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!android.text.TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.opengame.crashreport.common.info.a.a(context).m = libBuglySOFilePath;
            com.tencent.bugly.opengame.proguard.x.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.b = buglyStrategy.getCrashHandleCallback();
            com.tencent.bugly.opengame.proguard.x.a("setted CrashHanldeCallback", new java.lang.Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f326a = appReportDelay;
            com.tencent.bugly.opengame.proguard.x.a("setted delay: %d", java.lang.Long.valueOf(appReportDelay));
        }
    }

    public static com.tencent.bugly.opengame.CrashModule getInstance() {
        com.tencent.bugly.opengame.CrashModule crashModule = e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.opengame.a
    public java.lang.String[] getTables() {
        return new java.lang.String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    @Override // com.tencent.bugly.opengame.a
    public synchronized void init(android.content.Context context, boolean z, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.d) {
                com.tencent.bugly.opengame.proguard.x.a("Initializing crash module.", new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.n nVarA = com.tencent.bugly.opengame.proguard.n.a();
                int i = c + 1;
                c = i;
                nVarA.a(1004, i);
                this.d = true;
                com.tencent.bugly.opengame.crashreport.CrashReport.setContext(context);
                a(context, buglyStrategy);
                com.tencent.bugly.opengame.crashreport.crash.c cVarA = com.tencent.bugly.opengame.crashreport.crash.c.a(1004, context, z, this.b, (com.tencent.bugly.opengame.proguard.o) null, (java.lang.String) null);
                cVarA.e();
                cVarA.m();
                if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                    cVarA.g();
                } else {
                    com.tencent.bugly.opengame.proguard.x.a("[crash] Closed native crash monitor!", new java.lang.Object[0]);
                    cVarA.f();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                    cVarA.h();
                } else {
                    com.tencent.bugly.opengame.proguard.x.a("[crash] Closed ANR monitor!", new java.lang.Object[0]);
                    cVarA.i();
                }
                cVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                cVarA.l();
                com.tencent.bugly.opengame.crashreport.crash.d.a(context);
                com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver buglyBroadcastReceiver = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver.register(context);
                com.tencent.bugly.opengame.proguard.n nVarA2 = com.tencent.bugly.opengame.proguard.n.a();
                int i2 = c - 1;
                c = i2;
                nVarA2.a(1004, i2);
            }
        }
    }

    @Override // com.tencent.bugly.opengame.a
    public void onServerStrategyChanged(com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean) {
        com.tencent.bugly.opengame.crashreport.crash.c cVarA;
        if (strategyBean == null || (cVarA = com.tencent.bugly.opengame.crashreport.crash.c.a()) == null) {
            return;
        }
        cVarA.a(strategyBean);
    }
}
