package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e implements java.lang.Thread.UncaughtExceptionHandler {
    private static java.lang.String h;
    private static final java.lang.Object i = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f316a;
    private com.tencent.bugly.crashreport.crash.b b;
    private com.tencent.bugly.crashreport.common.strategy.a c;
    private com.tencent.bugly.crashreport.common.info.a d;
    private java.lang.Thread.UncaughtExceptionHandler e;
    private java.lang.Thread.UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(android.content.Context context, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.f316a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    private static java.lang.String a(java.lang.Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (java.lang.StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.proguard.x.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static boolean a(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        java.lang.String name = uncaughtExceptionHandler.getClass().getName();
        for (java.lang.StackTraceElement stackTraceElement : java.lang.Thread.currentThread().getStackTrace()) {
            java.lang.String className = stackTraceElement.getClassName();
            java.lang.String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(java.lang.Thread thread) {
        synchronized (i) {
            if (h != null && thread.getName().equals(h)) {
                return true;
            }
            h = thread.getName();
            return false;
        }
    }

    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread thread, java.lang.Throwable th, boolean z, java.lang.String str, byte[] bArr) {
        java.lang.String strA;
        boolean z2 = false;
        if (th == null) {
            com.tencent.bugly.proguard.x.d("We can do nothing with a null throwable.", new java.lang.Object[0]);
            return null;
        }
        boolean zK = com.tencent.bugly.crashreport.crash.c.a().k();
        java.lang.String str2 = (zK && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (zK && z) {
            com.tencent.bugly.proguard.x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new java.lang.Object[0]);
        }
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.crashreport.crash.CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
        crashDetailBean.F = this.d.p();
        crashDetailBean.G = this.d.o();
        crashDetailBean.H = this.d.q();
        crashDetailBean.w = com.tencent.bugly.proguard.z.a(this.f316a, com.tencent.bugly.crashreport.crash.c.e, (java.lang.String) null);
        crashDetailBean.y = com.tencent.bugly.proguard.y.a();
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = java.lang.Integer.valueOf(crashDetailBean.y == null ? 0 : crashDetailBean.y.length);
        com.tencent.bugly.proguard.x.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        crashDetailBean.f = this.d.j;
        crashDetailBean.g = this.d.w();
        crashDetailBean.m = this.d.g();
        java.lang.String name = th.getClass().getName();
        java.lang.String strB = b(th, 1000);
        if (strB == null) {
            strB = "";
        }
        java.lang.Object[] objArr2 = new java.lang.Object[2];
        objArr2[0] = java.lang.Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = java.lang.Boolean.valueOf(th.getCause() != null);
        com.tencent.bugly.proguard.x.e("stack frame :%d, has cause %b", objArr2);
        java.lang.String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        java.lang.Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause == null || cause == th) {
            crashDetailBean.n = name;
            crashDetailBean.o = strB + str2;
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = string;
            strA = a(th, com.tencent.bugly.crashreport.crash.c.f);
            crashDetailBean.q = strA;
        } else {
            crashDetailBean.n = cause.getClass().getName();
            crashDetailBean.o = b(cause, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.p = cause.getStackTrace()[0].toString();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(strB);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append("\n");
            strA = a(cause, com.tencent.bugly.crashreport.crash.c.f);
            sb.append(strA);
            crashDetailBean.q = sb.toString();
        }
        crashDetailBean.r = java.lang.System.currentTimeMillis();
        crashDetailBean.u = com.tencent.bugly.proguard.z.b(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.c.f, false);
            crashDetailBean.A = this.d.d;
            crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.z.put(crashDetailBean.B, strA);
            crashDetailBean.I = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.J();
            crashDetailBean.M = this.d.f292a;
            crashDetailBean.N = this.d.a();
            crashDetailBean.P = this.d.H();
            crashDetailBean.Q = this.d.I();
            crashDetailBean.R = this.d.B();
            crashDetailBean.S = this.d.G();
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.proguard.x.e("handle crash error %s", th2.toString());
        }
        if (z) {
            this.b.c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.O = new java.util.HashMap(1);
                crashDetailBean.O.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.T = bArr;
            }
        }
        return crashDetailBean;
    }

    private static java.lang.String b(java.lang.Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            com.tencent.bugly.proguard.x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                com.tencent.bugly.proguard.x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f = defaultUncaughtExceptionHandler;
                this.e = defaultUncaughtExceptionHandler;
            } else {
                com.tencent.bugly.proguard.x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.e = defaultUncaughtExceptionHandler;
            }
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        com.tencent.bugly.proguard.x.a("registered java monitor: %s", toString());
    }

    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.g != this.g) {
                com.tencent.bugly.proguard.x.a("java changed to %b", java.lang.Boolean.valueOf(strategyBean.g));
                if (strategyBean.g) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b1, code lost:
    
        if (r8.f != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b5, code lost:
    
        com.tencent.bugly.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
        com.tencent.bugly.proguard.x.e("current process die", new java.lang.Object[0]);
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(1);
        com.tencent.bugly.proguard.x.e("crashreport last handle end!", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f1, code lost:
    
        if (r8.f != null) goto L23;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r9, java.lang.Throwable r10, boolean r11, java.lang.String r12, byte[] r13) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.a(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[]):void");
    }

    public final synchronized void b() {
        this.g = false;
        com.tencent.bugly.proguard.x.a("close java monitor!", new java.lang.Object[0]);
        if (java.lang.Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY)) {
            com.tencent.bugly.proguard.x.a("Java monitor to unregister: %s", toString());
            java.lang.Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        synchronized (i) {
            a(thread, th, true, null, null);
        }
    }
}
