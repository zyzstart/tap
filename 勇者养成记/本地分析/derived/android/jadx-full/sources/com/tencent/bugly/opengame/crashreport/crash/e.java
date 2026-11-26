package com.tencent.bugly.opengame.crashreport.crash;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e implements java.lang.Thread.UncaughtExceptionHandler {
    private static java.lang.String h;
    private static final java.lang.Object i = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f366a;
    private com.tencent.bugly.opengame.crashreport.crash.b b;
    private com.tencent.bugly.opengame.crashreport.common.strategy.a c;
    private com.tencent.bugly.opengame.crashreport.common.info.a d;
    private java.lang.Thread.UncaughtExceptionHandler e;
    private java.lang.Thread.UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(android.content.Context context, com.tencent.bugly.opengame.crashreport.crash.b bVar, com.tencent.bugly.opengame.crashreport.common.strategy.a aVar, com.tencent.bugly.opengame.crashreport.common.info.a aVar2) {
        this.f366a = context;
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
            com.tencent.bugly.opengame.proguard.x.e("gen stack error %s", th2.toString());
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

    private com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean b(java.lang.Thread thread, java.lang.Throwable th, boolean z, java.lang.String str, byte[] bArr) {
        java.lang.String strA;
        boolean z2 = false;
        if (th == null) {
            com.tencent.bugly.opengame.proguard.x.d("We can do nothing with a null throwable.", new java.lang.Object[0]);
            return null;
        }
        boolean zK = com.tencent.bugly.opengame.crashreport.crash.c.a().k();
        java.lang.String str2 = (zK && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (zK && z) {
            com.tencent.bugly.opengame.proguard.x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new java.lang.Object[0]);
        }
        com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.opengame.crashreport.common.info.b.k();
        crashDetailBean.D = com.tencent.bugly.opengame.crashreport.common.info.b.i();
        crashDetailBean.E = com.tencent.bugly.opengame.crashreport.common.info.b.m();
        crashDetailBean.F = this.d.p();
        crashDetailBean.G = this.d.o();
        crashDetailBean.H = this.d.q();
        crashDetailBean.w = com.tencent.bugly.opengame.proguard.z.a(this.f366a, com.tencent.bugly.opengame.crashreport.crash.c.e, (java.lang.String) null);
        byte[] bArrA = com.tencent.bugly.opengame.proguard.y.a();
        crashDetailBean.y = bArrA;
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = java.lang.Integer.valueOf(bArrA == null ? 0 : bArrA.length);
        com.tencent.bugly.opengame.proguard.x.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        com.tencent.bugly.opengame.crashreport.common.info.a aVar = this.d;
        crashDetailBean.f = aVar.j;
        crashDetailBean.g = aVar.w();
        crashDetailBean.m = this.d.g();
        java.lang.String name = th.getClass().getName();
        java.lang.String strB = b(th, 1000);
        if (strB == null) {
            strB = "";
        }
        java.lang.Object[] objArr2 = new java.lang.Object[2];
        objArr2[0] = java.lang.Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = java.lang.Boolean.valueOf(th.getCause() != null);
        com.tencent.bugly.opengame.proguard.x.e("stack frame :%d, has cause %b", objArr2);
        java.lang.String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        java.lang.Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause == null || cause == th) {
            crashDetailBean.n = name;
            java.lang.String str3 = strB + str2;
            crashDetailBean.o = str3;
            if (str3 == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = string;
            strA = a(th, com.tencent.bugly.opengame.crashreport.crash.c.f);
            crashDetailBean.q = strA;
        } else {
            crashDetailBean.n = cause.getClass().getName();
            java.lang.String strB2 = b(cause, 1000);
            crashDetailBean.o = strB2;
            if (strB2 == null) {
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
            strA = a(cause, com.tencent.bugly.opengame.crashreport.crash.c.f);
            sb.append(strA);
            crashDetailBean.q = sb.toString();
        }
        crashDetailBean.r = java.lang.System.currentTimeMillis();
        crashDetailBean.u = com.tencent.bugly.opengame.proguard.z.b(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = com.tencent.bugly.opengame.proguard.z.a(com.tencent.bugly.opengame.crashreport.crash.c.f, false);
            crashDetailBean.A = this.d.d;
            java.lang.String str4 = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.B = str4;
            crashDetailBean.z.put(str4, strA);
            crashDetailBean.I = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.J();
            crashDetailBean.M = this.d.f342a;
            crashDetailBean.N = this.d.a();
            crashDetailBean.P = this.d.H();
            crashDetailBean.Q = this.d.I();
            crashDetailBean.R = this.d.B();
            crashDetailBean.S = this.d.G();
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.opengame.proguard.x.e("handle crash error %s", th2.toString());
        }
        if (z) {
            this.b.c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                java.util.HashMap map = new java.util.HashMap(1);
                crashDetailBean.O = map;
                map.put("UserData", str);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a() {
        if (this.j >= 10) {
            com.tencent.bugly.opengame.proguard.x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (com.tencent.bugly.opengame.crashreport.crash.e.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                com.tencent.bugly.opengame.proguard.x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f = defaultUncaughtExceptionHandler;
            } else {
                com.tencent.bugly.opengame.proguard.x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
            }
            this.e = defaultUncaughtExceptionHandler;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        com.tencent.bugly.opengame.proguard.x.a("registered java monitor: %s", toString());
    }

    public final synchronized void a(com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.g;
            if (z != this.g) {
                com.tencent.bugly.opengame.proguard.x.a("java changed to %b", java.lang.Boolean.valueOf(z));
                if (strategyBean.g) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b2  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(Unknown Source)
    	at java.base/java.util.HashMap.getNode(Unknown Source)
    	at java.base/java.util.HashMap.containsKey(Unknown Source)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:158)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(java.lang.Thread thread, java.lang.Throwable th, boolean z, java.lang.String str, byte[] bArr) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        java.lang.Object[] objArr2;
        java.lang.String str3;
        if (z) {
            com.tencent.bugly.opengame.proguard.x.e("Java Crash Happen cause by %s(%d)", thread.getName(), java.lang.Long.valueOf(thread.getId()));
            if (a(thread)) {
                com.tencent.bugly.opengame.proguard.x.a("this class has handled this exception", new java.lang.Object[0]);
                if (this.f != null) {
                    com.tencent.bugly.opengame.proguard.x.a("call system handler", new java.lang.Object[0]);
                    this.f.uncaughtException(thread, th);
                } else {
                    com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    java.lang.System.exit(1);
                }
            }
        } else {
            com.tencent.bugly.opengame.proguard.x.e("Java Catch Happen", new java.lang.Object[0]);
        }
        try {
            if (this.g) {
                if (!this.c.b()) {
                    com.tencent.bugly.opengame.proguard.x.d("no remote but still store!", new java.lang.Object[0]);
                }
                if (this.c.c().g || !this.c.b()) {
                    com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanB = b(thread, th, z, str, bArr);
                    if (crashDetailBeanB == null) {
                        com.tencent.bugly.opengame.proguard.x.e("pkg crash datas fail!", new java.lang.Object[0]);
                        if (!z) {
                            return;
                        }
                        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.e;
                        if (uncaughtExceptionHandler == null || !a(uncaughtExceptionHandler)) {
                            if (this.f == null) {
                                com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                                com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                java.lang.System.exit(1);
                                com.tencent.bugly.opengame.proguard.x.e("crashreport last handle end!", new java.lang.Object[0]);
                                return;
                            }
                            com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                            this.f.uncaughtException(thread, th);
                            objArr2 = new java.lang.Object[0];
                            str3 = "system handle end!";
                        } else {
                            com.tencent.bugly.opengame.proguard.x.e("sys default last handle start!", new java.lang.Object[0]);
                            this.e.uncaughtException(thread, th);
                            objArr2 = new java.lang.Object[0];
                            str3 = "sys default last handle end!";
                        }
                    } else {
                        com.tencent.bugly.opengame.crashreport.crash.b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", com.tencent.bugly.opengame.proguard.z.a(), this.d.d, thread.getName(), com.tencent.bugly.opengame.proguard.z.a(th), crashDetailBeanB);
                        if (!this.b.a(crashDetailBeanB)) {
                            this.b.a(crashDetailBeanB, 3000L, z);
                        }
                        if (z) {
                            this.b.b(crashDetailBeanB);
                        }
                        if (!z) {
                            return;
                        }
                        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.e;
                        if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                            com.tencent.bugly.opengame.proguard.x.e("sys default last handle start!", new java.lang.Object[0]);
                            this.e.uncaughtException(thread, th);
                            objArr2 = new java.lang.Object[0];
                            str3 = "sys default last handle end!";
                        } else if (this.f != null) {
                            com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                            this.f.uncaughtException(thread, th);
                            objArr2 = new java.lang.Object[0];
                            str3 = "system handle end!";
                        } else {
                            com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                            com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            java.lang.System.exit(1);
                            objArr2 = new java.lang.Object[0];
                            str3 = "crashreport last handle end!";
                        }
                    }
                } else {
                    com.tencent.bugly.opengame.proguard.x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
                    com.tencent.bugly.opengame.crashreport.crash.b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", com.tencent.bugly.opengame.proguard.z.a(), this.d.d, thread.getName(), com.tencent.bugly.opengame.proguard.z.a(th), null);
                    if (!z) {
                        return;
                    }
                    java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.e;
                    if (uncaughtExceptionHandler3 == null || !a(uncaughtExceptionHandler3)) {
                        if (this.f == null) {
                            com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                            com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            java.lang.System.exit(1);
                            com.tencent.bugly.opengame.proguard.x.e("crashreport last handle end!", new java.lang.Object[0]);
                            return;
                        }
                        com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                        this.f.uncaughtException(thread, th);
                        objArr2 = new java.lang.Object[0];
                        str3 = "system handle end!";
                    } else {
                        com.tencent.bugly.opengame.proguard.x.e("sys default last handle start!", new java.lang.Object[0]);
                        this.e.uncaughtException(thread, th);
                        objArr2 = new java.lang.Object[0];
                        str3 = "sys default last handle end!";
                    }
                }
            } else {
                com.tencent.bugly.opengame.proguard.x.c("Java crash handler is disable. Just return.", new java.lang.Object[0]);
                if (!z) {
                    return;
                }
                java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.e;
                if (uncaughtExceptionHandler4 == null || !a(uncaughtExceptionHandler4)) {
                    if (this.f == null) {
                        com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                        com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        java.lang.System.exit(1);
                        com.tencent.bugly.opengame.proguard.x.e("crashreport last handle end!", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                    this.f.uncaughtException(thread, th);
                    objArr2 = new java.lang.Object[0];
                    str3 = "system handle end!";
                } else {
                    com.tencent.bugly.opengame.proguard.x.e("sys default last handle start!", new java.lang.Object[0]);
                    this.e.uncaughtException(thread, th);
                    objArr2 = new java.lang.Object[0];
                    str3 = "sys default last handle end!";
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                if (!com.tencent.bugly.opengame.proguard.x.a(th2)) {
                    th2.printStackTrace();
                }
                if (!z) {
                    return;
                }
                java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.e;
                if (uncaughtExceptionHandler5 == null || !a(uncaughtExceptionHandler5)) {
                    if (this.f != null) {
                        com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                        this.f.uncaughtException(thread, th);
                        objArr2 = new java.lang.Object[0];
                        str3 = "system handle end!";
                    } else {
                        com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                        com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        java.lang.System.exit(1);
                        objArr2 = new java.lang.Object[0];
                        str3 = "crashreport last handle end!";
                    }
                }
            } catch (java.lang.Throwable th3) {
                if (z) {
                    java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        com.tencent.bugly.opengame.proguard.x.e("sys default last handle start!", new java.lang.Object[0]);
                        this.e.uncaughtException(thread, th);
                        objArr = new java.lang.Object[0];
                        str2 = "sys default last handle end!";
                    } else if (this.f != null) {
                        com.tencent.bugly.opengame.proguard.x.e("system handle start!", new java.lang.Object[0]);
                        this.f.uncaughtException(thread, th);
                        objArr = new java.lang.Object[0];
                        str2 = "system handle end!";
                    } else {
                        com.tencent.bugly.opengame.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
                        com.tencent.bugly.opengame.proguard.x.e("current process die", new java.lang.Object[0]);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        java.lang.System.exit(1);
                        objArr = new java.lang.Object[0];
                        str2 = "crashreport last handle end!";
                    }
                    com.tencent.bugly.opengame.proguard.x.e(str2, objArr);
                }
                throw th3;
            }
        }
        com.tencent.bugly.opengame.proguard.x.e(str3, objArr2);
    }

    public final synchronized void b() {
        this.g = false;
        com.tencent.bugly.opengame.proguard.x.a("close java monitor!", new java.lang.Object[0]);
        if (java.lang.Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY)) {
            com.tencent.bugly.opengame.proguard.x.a("Java monitor to unregister: %s", toString());
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
