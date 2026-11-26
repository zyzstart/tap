package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f310a = 0;
    public static boolean b = false;
    public static int c = 2;
    public static boolean d = true;
    public static int e = 20480;
    public static int f = 20480;
    public static long g = 604800000;
    public static java.lang.String h = null;
    public static boolean i = false;
    public static java.lang.String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m = false;
    public static java.lang.String n;
    public static java.lang.String o;
    private static com.tencent.bugly.crashreport.crash.c r;
    public final com.tencent.bugly.crashreport.crash.b p;
    private final android.content.Context q;
    private final com.tencent.bugly.crashreport.crash.e s;
    private final com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler t;
    private com.tencent.bugly.crashreport.common.strategy.a u;
    private com.tencent.bugly.proguard.w v;
    private final com.tencent.bugly.crashreport.crash.anr.b w;
    private java.lang.Boolean x;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.crash.c$2, reason: invalid class name */
    /* JADX INFO: compiled from: BUGLY */
    final class AnonymousClass2 extends java.lang.Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws java.lang.Throwable {
            java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> list;
            if (com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.c.this.q, "local_crash_lock", 10000L)) {
                java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> listA = com.tencent.bugly.crashreport.crash.c.this.p.a();
                if (listA != null && listA.size() > 0) {
                    com.tencent.bugly.proguard.x.c("Size of crash list: %s", java.lang.Integer.valueOf(listA.size()));
                    int size = listA.size();
                    if (size > 100) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        java.util.Collections.sort(listA);
                        for (int i = 0; i < 100; i++) {
                            arrayList.add(listA.get((size - 1) - i));
                        }
                        list = arrayList;
                    } else {
                        list = listA;
                    }
                    com.tencent.bugly.crashreport.crash.c.this.p.a(list, 0L, false, false, false);
                }
                com.tencent.bugly.proguard.z.b(com.tencent.bugly.crashreport.crash.c.this.q, "local_crash_lock");
            }
        }
    }

    private c(int i2, android.content.Context context, com.tencent.bugly.proguard.w wVar, boolean z, com.tencent.bugly.BuglyStrategy.a aVar, com.tencent.bugly.proguard.o oVar, java.lang.String str) {
        f310a = i2;
        android.content.Context contextA = com.tencent.bugly.proguard.z.a(context);
        this.q = contextA;
        this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.v = wVar;
        this.p = new com.tencent.bugly.crashreport.crash.b(i2, contextA, com.tencent.bugly.proguard.u.a(), com.tencent.bugly.proguard.p.a(), this.u, aVar, oVar);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        this.s = new com.tencent.bugly.crashreport.crash.e(contextA, this.p, this.u, aVarA);
        this.t = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance(contextA, aVarA, this.p, this.u, wVar, z, str);
        aVarA.D = this.t;
        this.w = new com.tencent.bugly.crashreport.crash.anr.b(contextA, this.u, aVarA, wVar, this.p);
    }

    public static synchronized com.tencent.bugly.crashreport.crash.c a() {
        return r;
    }

    public static synchronized com.tencent.bugly.crashreport.crash.c a(int i2, android.content.Context context, boolean z, com.tencent.bugly.BuglyStrategy.a aVar, com.tencent.bugly.proguard.o oVar, java.lang.String str) {
        if (r == null) {
            r = new com.tencent.bugly.crashreport.crash.c(1004, context, com.tencent.bugly.proguard.w.a(), z, aVar, null, null);
        }
        return r;
    }

    public final void a(long j2) {
        com.tencent.bugly.proguard.w.a().a(new com.tencent.bugly.crashreport.crash.c.AnonymousClass2(), j2);
    }

    public final void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.a(strategyBean);
        com.tencent.bugly.proguard.w.a().a(new com.tencent.bugly.crashreport.crash.c.AnonymousClass2(), 3000L);
    }

    public final void a(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        this.p.d(crashDetailBean);
    }

    public final void a(final java.lang.Thread thread, final java.lang.Throwable th, boolean z, java.lang.String str, byte[] bArr, final boolean z2) {
        final boolean z3 = false;
        final java.lang.String str2 = null;
        final byte[] bArr2 = null;
        this.v.a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.tencent.bugly.proguard.x.c("post a throwable %b", java.lang.Boolean.valueOf(z3));
                    com.tencent.bugly.crashreport.crash.c.this.s.a(thread, th, false, str2, bArr2);
                    if (z2) {
                        com.tencent.bugly.proguard.x.a("clear user datas", new java.lang.Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(com.tencent.bugly.crashreport.crash.c.this.q).C();
                    }
                } catch (java.lang.Throwable th2) {
                    if (!com.tencent.bugly.proguard.x.b(th2)) {
                        th2.printStackTrace();
                    }
                    com.tencent.bugly.proguard.x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public final boolean b() {
        java.lang.Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        java.lang.String str = com.tencent.bugly.crashreport.common.info.a.b().d;
        java.util.List<com.tencent.bugly.proguard.r> listA = com.tencent.bugly.proguard.p.a().a(1);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (listA == null || listA.size() <= 0) {
            this.x = false;
            return false;
        }
        for (com.tencent.bugly.proguard.r rVar : listA) {
            if (str.equals(rVar.c)) {
                this.x = true;
                arrayList.add(rVar);
            }
        }
        if (arrayList.size() > 0) {
            com.tencent.bugly.proguard.p.a().a(arrayList);
        }
        return true;
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            this.w.a(true);
        } else {
            this.w.c();
        }
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        if (android.os.Build.VERSION.SDK_INT < 19) {
            this.w.a(false);
        } else {
            this.w.d();
        }
    }

    public final void e() {
        this.s.a();
    }

    public final void f() {
        this.t.setUserOpened(false);
    }

    public final void g() {
        this.t.setUserOpened(true);
    }

    public final void h() {
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            this.w.a(true);
        } else {
            this.w.c();
        }
    }

    public final void i() {
        if (android.os.Build.VERSION.SDK_INT < 19) {
            this.w.a(false);
        } else {
            this.w.d();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void j() {
        com.tencent.bugly.crashreport.crash.anr.b bVar = this.w;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    com.tencent.bugly.proguard.x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", java.lang.Integer.valueOf(i3));
                    com.tencent.bugly.proguard.z.b(5000L);
                    i2 = i3;
                } catch (java.lang.Throwable th) {
                    if (com.tencent.bugly.proguard.x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean k() {
        return this.w.a();
    }

    public final void l() {
        this.t.checkUploadRecordCrash();
    }

    public final void m() {
        if (com.tencent.bugly.crashreport.common.info.a.b().d.equals(com.tencent.bugly.crashreport.common.info.AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }
}
