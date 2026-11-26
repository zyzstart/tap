package com.tencent.bugly.opengame.crashreport.biz;

import com.tencent.bugly.opengame.crashreport.biz.a.AnonymousClass2;
import com.tencent.bugly.opengame.crashreport.biz.a.RunnableC0022a;
import com.tencent.bugly.opengame.crashreport.biz.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.tencent.bugly.opengame.crashreport.biz.a f338a = null;
    private static boolean b = false;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static android.app.Application.ActivityLifecycleCallbacks k = null;
    private static java.lang.Class l = null;
    private static boolean m = true;

    static /* synthetic */ java.lang.String a(java.lang.String str, java.lang.String str2) {
        return com.tencent.bugly.opengame.proguard.z.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        com.tencent.bugly.opengame.crashreport.biz.a aVar = f338a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.opengame.crashreport.common.strategy.a.a().c().q;
        }
        f = j2;
    }

    public static void a(android.content.Context context) {
        if (!b || context == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            android.app.Application application = context.getApplicationContext() instanceof android.app.Application ? (android.app.Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k != null) {
                        application.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (java.lang.Exception e2) {
                    if (!com.tencent.bugly.opengame.proguard.x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        b = false;
    }

    public static void a(final android.content.Context context, final com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (b) {
            return;
        }
        boolean z = com.tencent.bugly.opengame.crashreport.common.info.a.a(context).e;
        m = z;
        f338a = new com.tencent.bugly.opengame.crashreport.biz.a(context, z);
        b = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            c(context, buglyStrategy);
        } else {
            com.tencent.bugly.opengame.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.opengame.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.bugly.opengame.crashreport.biz.b.c(context, buglyStrategy);
                }
            }, appReportDelay);
        }
    }

    public static void a(com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean, boolean z) {
        com.tencent.bugly.opengame.proguard.w wVarA;
        com.tencent.bugly.opengame.crashreport.biz.a aVar = f338a;
        if (aVar != null && !z && (wVarA = com.tencent.bugly.opengame.proguard.w.a()) != null) {
            wVarA.a(aVar.new AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.q;
        if (j2 > 0) {
            e = j2;
        }
        int i2 = strategyBean.w;
        if (i2 > 0) {
            c = i2;
        }
        long j3 = strategyBean.x;
        if (j3 > 0) {
            d = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        boolean z;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (zRecordUserInfoOnceADay) {
            com.tencent.bugly.opengame.crashreport.common.info.a aVarA = com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
            java.util.List listA = f338a.a(aVarA.d);
            if (listA == null) {
                z = true;
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 < listA.size()) {
                    com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) listA.get(i2);
                    if (userInfoBean.n.equals(aVarA.j) && userInfoBean.b == 1) {
                        long jB = com.tencent.bugly.opengame.proguard.z.b();
                        if (jB > 0) {
                            if (userInfoBean.e >= jB) {
                                if (userInfoBean.f <= 0) {
                                    com.tencent.bugly.opengame.crashreport.biz.a aVar = f338a;
                                    com.tencent.bugly.opengame.proguard.w wVarA = com.tencent.bugly.opengame.proguard.w.a();
                                    if (wVarA != null) {
                                        wVarA.a(aVar.new AnonymousClass2());
                                    }
                                }
                                z = false;
                                break;
                            }
                        }
                    }
                    i2++;
                }
                z = true;
                break;
            }
            if (!z) {
                return;
            } else {
                zIsEnableUserInfo = false;
            }
        }
        com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
        if (aVarB != null) {
            java.lang.String className = null;
            boolean z2 = false;
            for (java.lang.StackTraceElement stackTraceElement : java.lang.Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    className = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z2 = true;
                }
            }
            if (className == null) {
                className = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            } else if (z2) {
                aVarB.a(true);
            } else {
                className = "background";
            }
            aVarB.p = className;
        }
        if (zIsEnableUserInfo && android.os.Build.VERSION.SDK_INT >= 14) {
            android.app.Application application = context.getApplicationContext() instanceof android.app.Application ? (android.app.Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k == null) {
                        k = new android.app.Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.opengame.crashreport.biz.b.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
                                java.lang.String name = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                if (activity != null) {
                                    name = activity.getClass().getName();
                                }
                                if (com.tencent.bugly.opengame.crashreport.biz.b.l == null || com.tencent.bugly.opengame.crashreport.biz.b.l.getName().equals(name)) {
                                    com.tencent.bugly.opengame.proguard.x.c(">>> %s onCreated <<<", name);
                                    com.tencent.bugly.opengame.crashreport.common.info.a aVarB2 = com.tencent.bugly.opengame.crashreport.common.info.a.b();
                                    if (aVarB2 != null) {
                                        aVarB2.C.add(com.tencent.bugly.opengame.crashreport.biz.b.a(name, "onCreated"));
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityDestroyed(android.app.Activity activity) {
                                java.lang.String name = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                if (activity != null) {
                                    name = activity.getClass().getName();
                                }
                                if (com.tencent.bugly.opengame.crashreport.biz.b.l == null || com.tencent.bugly.opengame.crashreport.biz.b.l.getName().equals(name)) {
                                    com.tencent.bugly.opengame.proguard.x.c(">>> %s onDestroyed <<<", name);
                                    com.tencent.bugly.opengame.crashreport.common.info.a aVarB2 = com.tencent.bugly.opengame.crashreport.common.info.a.b();
                                    if (aVarB2 != null) {
                                        aVarB2.C.add(com.tencent.bugly.opengame.crashreport.biz.b.a(name, "onDestroyed"));
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityPaused(android.app.Activity activity) {
                                java.lang.String name = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                if (activity != null) {
                                    name = activity.getClass().getName();
                                }
                                if (com.tencent.bugly.opengame.crashreport.biz.b.l == null || com.tencent.bugly.opengame.crashreport.biz.b.l.getName().equals(name)) {
                                    com.tencent.bugly.opengame.proguard.x.c(">>> %s onPaused <<<", name);
                                    com.tencent.bugly.opengame.crashreport.common.info.a aVarB2 = com.tencent.bugly.opengame.crashreport.common.info.a.b();
                                    if (aVarB2 == null) {
                                        return;
                                    }
                                    aVarB2.C.add(com.tencent.bugly.opengame.crashreport.biz.b.a(name, "onPaused"));
                                    aVarB2.a(false);
                                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                    aVarB2.r = jCurrentTimeMillis;
                                    aVarB2.s = jCurrentTimeMillis - aVarB2.q;
                                    long unused = com.tencent.bugly.opengame.crashreport.biz.b.h = jCurrentTimeMillis;
                                    if (aVarB2.s < 0) {
                                        aVarB2.s = 0L;
                                    }
                                    aVarB2.p = activity != null ? "background" : android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityResumed(android.app.Activity activity) {
                                java.lang.String name = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                if (activity != null) {
                                    name = activity.getClass().getName();
                                }
                                if (com.tencent.bugly.opengame.crashreport.biz.b.l == null || com.tencent.bugly.opengame.crashreport.biz.b.l.getName().equals(name)) {
                                    com.tencent.bugly.opengame.proguard.x.c(">>> %s onResumed <<<", name);
                                    com.tencent.bugly.opengame.crashreport.common.info.a aVarB2 = com.tencent.bugly.opengame.crashreport.common.info.a.b();
                                    if (aVarB2 == null) {
                                        return;
                                    }
                                    aVarB2.C.add(com.tencent.bugly.opengame.crashreport.biz.b.a(name, "onResumed"));
                                    aVarB2.a(true);
                                    aVarB2.p = name;
                                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                    aVarB2.q = jCurrentTimeMillis;
                                    aVarB2.t = jCurrentTimeMillis - com.tencent.bugly.opengame.crashreport.biz.b.i;
                                    long j2 = aVarB2.q - com.tencent.bugly.opengame.crashreport.biz.b.h;
                                    if (j2 > (com.tencent.bugly.opengame.crashreport.biz.b.f > 0 ? com.tencent.bugly.opengame.crashreport.biz.b.f : com.tencent.bugly.opengame.crashreport.biz.b.e)) {
                                        aVarB2.d();
                                        com.tencent.bugly.opengame.crashreport.biz.b.g();
                                        com.tencent.bugly.opengame.proguard.x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", java.lang.Long.valueOf(j2 / 1000), java.lang.Long.valueOf(com.tencent.bugly.opengame.crashreport.biz.b.e / 1000));
                                        if (com.tencent.bugly.opengame.crashreport.biz.b.g % com.tencent.bugly.opengame.crashreport.biz.b.c == 0) {
                                            com.tencent.bugly.opengame.crashreport.biz.b.f338a.a(4, com.tencent.bugly.opengame.crashreport.biz.b.m, 0L);
                                            return;
                                        }
                                        com.tencent.bugly.opengame.crashreport.biz.b.f338a.a(4, false, 0L);
                                        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                                        if (jCurrentTimeMillis2 - com.tencent.bugly.opengame.crashreport.biz.b.j > com.tencent.bugly.opengame.crashreport.biz.b.d) {
                                            long unused = com.tencent.bugly.opengame.crashreport.biz.b.j = jCurrentTimeMillis2;
                                            com.tencent.bugly.opengame.proguard.x.a("add a timer to upload hot start user info", new java.lang.Object[0]);
                                            if (com.tencent.bugly.opengame.crashreport.biz.b.m) {
                                                com.tencent.bugly.opengame.proguard.w.a().a(com.tencent.bugly.opengame.crashreport.biz.b.f338a.new RunnableC0022a(null, true), com.tencent.bugly.opengame.crashreport.biz.b.d);
                                            }
                                        }
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStarted(android.app.Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStopped(android.app.Activity activity) {
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(k);
                } catch (java.lang.Exception e2) {
                    if (!com.tencent.bugly.opengame.proguard.x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (m) {
            i = java.lang.System.currentTimeMillis();
            f338a.a(1, false, 0L);
            com.tencent.bugly.opengame.proguard.x.a("[session] launch app, new start", new java.lang.Object[0]);
            f338a.a();
            com.tencent.bugly.opengame.proguard.w.a().a(f338a.new c(21600000L), 21600000L);
        }
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }
}
