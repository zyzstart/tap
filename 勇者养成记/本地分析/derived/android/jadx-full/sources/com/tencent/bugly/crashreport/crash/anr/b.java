package com.tencent.bugly.crashreport.crash.anr;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements com.tencent.bugly.proguard.ac {
    private final android.content.Context c;
    private final com.tencent.bugly.crashreport.common.info.a d;
    private final com.tencent.bugly.proguard.w e;
    private final com.tencent.bugly.crashreport.common.strategy.a f;
    private final java.lang.String g;
    private final com.tencent.bugly.crashreport.crash.b h;
    private android.os.FileObserver i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.atomic.AtomicInteger f305a = new java.util.concurrent.atomic.AtomicInteger(0);
    private long b = -1;
    private boolean j = true;

    public b(android.content.Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, com.tencent.bugly.proguard.w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.c = com.tencent.bugly.proguard.z.a(context);
        this.g = context.getDir(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY, 0).getAbsolutePath();
        this.d = aVar2;
        this.e = wVar;
        this.f = aVar;
        this.h = bVar;
    }

    private static android.app.ActivityManager.ProcessErrorStateInfo a(android.content.Context context, long j) {
        com.tencent.bugly.proguard.x.c("to find!", new java.lang.Object[0]);
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        int i = 0;
        while (true) {
            com.tencent.bugly.proguard.x.c("waiting!", new java.lang.Object[0]);
            java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        com.tencent.bugly.proguard.x.c("found!", new java.lang.Object[0]);
                        return processErrorStateInfo;
                    }
                }
            }
            com.tencent.bugly.proguard.z.b(500L);
            int i2 = i + 1;
            if (i >= 20) {
                com.tencent.bugly.proguard.x.c("end!", new java.lang.Object[0]);
                return null;
            }
            i = i2;
        }
    }

    private com.tencent.bugly.crashreport.crash.CrashDetailBean a(com.tencent.bugly.crashreport.crash.anr.a aVar) {
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.crashreport.crash.CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
            crashDetailBean.F = this.d.p();
            crashDetailBean.G = this.d.o();
            crashDetailBean.H = this.d.q();
            crashDetailBean.w = com.tencent.bugly.proguard.z.a(this.c, com.tencent.bugly.crashreport.crash.c.e, (java.lang.String) null);
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.j;
            crashDetailBean.g = this.d.w();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.O = new java.util.HashMap();
            crashDetailBean.O.put("BUGLY_CR_01", aVar.e);
            int iIndexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = iIndexOf > 0 ? crashDetailBean.q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = com.tencent.bugly.proguard.z.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.f304a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.J();
            crashDetailBean.v = aVar.d;
            crashDetailBean.L = this.d.n;
            crashDetailBean.M = this.d.f292a;
            crashDetailBean.N = this.d.a();
            crashDetailBean.P = this.d.H();
            crashDetailBean.Q = this.d.I();
            crashDetailBean.R = this.d.B();
            crashDetailBean.S = this.d.G();
            this.h.c(crashDetailBean);
            crashDetailBean.y = com.tencent.bugly.proguard.y.a();
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private boolean a(android.content.Context context, java.lang.String str, android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, java.util.Map<java.lang.String, java.lang.String> map) {
        java.io.File file = new java.io.File(context.getFilesDir(), "bugly/bugly_trace_" + j + ".txt");
        com.tencent.bugly.crashreport.crash.anr.a aVar = new com.tencent.bugly.crashreport.crash.anr.a();
        aVar.c = j;
        aVar.d = file.getAbsolutePath();
        aVar.f304a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    aVar.g = map.get(str2);
                }
            }
        }
        java.lang.Object[] objArr = new java.lang.Object[6];
        objArr[0] = java.lang.Long.valueOf(aVar.c);
        objArr[1] = aVar.d;
        objArr[2] = aVar.f304a;
        objArr[3] = aVar.f;
        objArr[4] = aVar.e;
        objArr[5] = java.lang.Integer.valueOf(aVar.b == null ? 0 : aVar.b.size());
        com.tencent.bugly.proguard.x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        if (!this.f.b()) {
            com.tencent.bugly.proguard.x.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
            com.tencent.bugly.crashreport.crash.b.a("ANR", com.tencent.bugly.proguard.z.a(), aVar.f304a, "main", aVar.e, null);
            return false;
        }
        if (!this.f.c().j) {
            com.tencent.bugly.proguard.x.d("ANR Report is closed!", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.proguard.x.a("found visiable anr , start to upload!", new java.lang.Object[0]);
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanA = a(aVar);
        if (crashDetailBeanA == null) {
            com.tencent.bugly.proguard.x.e("pack anr fail!", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.crashreport.crash.c.a().a(crashDetailBeanA);
        if (crashDetailBeanA.f299a >= 0) {
            com.tencent.bugly.proguard.x.a("backup anr record success!", new java.lang.Object[0]);
        } else {
            com.tencent.bugly.proguard.x.d("backup anr record fail!", new java.lang.Object[0]);
        }
        if (str != null && new java.io.File(str).exists()) {
            this.f305a.set(3);
            if (a(str, aVar.d, aVar.f304a)) {
                com.tencent.bugly.proguard.x.a("backup trace success", new java.lang.Object[0]);
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", com.tencent.bugly.proguard.z.a(), aVar.f304a, "main", aVar.e, crashDetailBeanA);
        if (!this.h.a(crashDetailBeanA)) {
            this.h.a(crashDetailBeanA, 3000L, true);
        }
        this.h.b(crashDetailBeanA);
        return true;
    }

    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.io.BufferedWriter bufferedWriter;
        com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a targetDumpInfo = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo == null || targetDumpInfo.d == null || targetDumpInfo.d.size() <= 0) {
            com.tencent.bugly.proguard.x.e("not found trace dump for %s", str3);
            return false;
        }
        java.io.File file = new java.io.File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                com.tencent.bugly.proguard.x.e("backup file create fail %s", str2);
                return false;
            }
            java.io.BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file, false));
                    try {
                        java.lang.String[] strArr = targetDumpInfo.d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            java.lang.String str4 = strArr[0];
                            java.lang.String str5 = strArr[1];
                            bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter.flush();
                        }
                        for (java.util.Map.Entry<java.lang.String, java.lang.String[]> entry : targetDumpInfo.d.entrySet()) {
                            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                                java.lang.String str6 = entry.getValue()[0];
                                java.lang.String str7 = entry.getValue()[1];
                                bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                bufferedWriter.flush();
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (java.io.IOException e) {
                            if (!com.tencent.bugly.proguard.x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        bufferedWriter2 = bufferedWriter;
                        if (!com.tencent.bugly.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                        com.tencent.bugly.proguard.x.e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (java.io.IOException e3) {
                                if (!com.tencent.bugly.proguard.x.a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.io.IOException e4) {
                                if (!com.tencent.bugly.proguard.x.a(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (java.io.IOException e5) {
                    e = e5;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
            }
        } catch (java.lang.Exception e6) {
            if (!com.tencent.bugly.proguard.x.a(e6)) {
                e6.printStackTrace();
            }
            com.tencent.bugly.proguard.x.e("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str2);
            return false;
        }
    }

    private synchronized void b(boolean z) {
        try {
            if (z) {
                e();
            } else {
                f();
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    private synchronized void c(boolean z) {
        if (this.j != z) {
            com.tencent.bugly.proguard.x.a("user change anr %b", java.lang.Boolean.valueOf(z));
            this.j = z;
        }
    }

    private synchronized void e() {
        if (g()) {
            com.tencent.bugly.proguard.x.d("start when started!", new java.lang.Object[0]);
            return;
        }
        this.i = new android.os.FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, java.lang.String str) {
                if (str == null) {
                    return;
                }
                java.lang.String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    com.tencent.bugly.crashreport.crash.anr.b.this.a(str2);
                } else {
                    com.tencent.bugly.proguard.x.d("not anr file %s", str2);
                }
            }
        };
        try {
            this.i.startWatching();
            com.tencent.bugly.proguard.x.a("start anr monitor!", new java.lang.Object[0]);
            this.e.a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.bugly.crashreport.crash.anr.b.this.b();
                }
            });
        } catch (java.lang.Throwable th) {
            this.i = null;
            com.tencent.bugly.proguard.x.d("start anr monitor failed!", new java.lang.Object[0]);
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void f() {
        if (!g()) {
            com.tencent.bugly.proguard.x.d("close when closed!", new java.lang.Object[0]);
            return;
        }
        try {
            this.i.stopWatching();
            this.i = null;
            com.tencent.bugly.proguard.x.d("close anr monitor!", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.d("stop anr monitor failed!", new java.lang.Object[0]);
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean g() {
        return this.i != null;
    }

    private synchronized boolean h() {
        return this.j;
    }

    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.j != g()) {
            com.tencent.bugly.proguard.x.d("server anr changed to %b", java.lang.Boolean.valueOf(strategyBean.j));
        }
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            boolean z = strategyBean.j && h();
            if (z != g()) {
                com.tencent.bugly.proguard.x.a("anr changed to %b", java.lang.Boolean.valueOf(z));
                b(z);
            }
            return;
        }
        if (strategyBean.j) {
            c();
        } else {
            d();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(java.lang.String str) {
        long jCurrentTimeMillis;
        synchronized (this) {
            if (this.f305a.get() != 0) {
                com.tencent.bugly.proguard.x.c("trace started return ", new java.lang.Object[0]);
                return;
            }
            this.f305a.set(1);
            try {
                try {
                    com.tencent.bugly.proguard.x.c("read trace first dump for create time!", new java.lang.Object[0]);
                    com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a firstDumpInfo = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(str, false);
                    long j = firstDumpInfo != null ? firstDumpInfo.c : -1L;
                    if (j == -1) {
                        com.tencent.bugly.proguard.x.d("trace dump fail could not get time!", new java.lang.Object[0]);
                        jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    } else {
                        jCurrentTimeMillis = j;
                    }
                    if (java.lang.Math.abs(jCurrentTimeMillis - this.b) < 10000) {
                        com.tencent.bugly.proguard.x.d("should not process ANR too Fre in %d", 10000);
                    } else {
                        this.b = jCurrentTimeMillis;
                        this.f305a.set(1);
                        try {
                            java.util.Map<java.lang.String, java.lang.String> mapA = com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.c.f, false);
                            if (mapA == null || mapA.size() <= 0) {
                                com.tencent.bugly.proguard.x.d("can't get all thread skip this anr", new java.lang.Object[0]);
                            } else {
                                android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.c, 10000L);
                                if (processErrorStateInfoA == null) {
                                    com.tencent.bugly.proguard.x.c("proc state is unvisiable!", new java.lang.Object[0]);
                                } else {
                                    if (processErrorStateInfoA.pid == android.os.Process.myPid()) {
                                        com.tencent.bugly.proguard.x.a("found visiable anr , start to process!", new java.lang.Object[0]);
                                        a(this.c, str, processErrorStateInfoA, jCurrentTimeMillis, mapA);
                                        return;
                                    }
                                    com.tencent.bugly.proguard.x.c("not mind proc!", processErrorStateInfoA.processName);
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.tencent.bugly.proguard.x.a(th);
                            com.tencent.bugly.proguard.x.e("get all thread stack fail!", new java.lang.Object[0]);
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    if (!com.tencent.bugly.proguard.x.a(th2)) {
                        th2.printStackTrace();
                    }
                    com.tencent.bugly.proguard.x.e("handle anr error %s", th2.getClass().toString());
                }
            } finally {
                this.f305a.set(0);
            }
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean zH = h();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zH = zH && aVarA.c().g;
        }
        if (zH != g()) {
            com.tencent.bugly.proguard.x.a("anr changed to %b", java.lang.Boolean.valueOf(zH));
            b(zH);
        }
    }

    public final boolean a() {
        return this.f305a.get() != 0;
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(java.lang.Thread thread) {
        new java.util.HashMap();
        if (thread.getName().contains("main")) {
            android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.c, 10000L);
            if (processErrorStateInfoA == null) {
                com.tencent.bugly.proguard.x.c("anr handler onThreadBlock proc state is unvisiable!", new java.lang.Object[0]);
                return false;
            }
            if (processErrorStateInfoA.pid != android.os.Process.myPid()) {
                com.tencent.bugly.proguard.x.c("onThreadBlock not mind proc!", processErrorStateInfoA.processName);
                return false;
            }
            try {
                java.util.Map<java.lang.String, java.lang.String> mapA = com.tencent.bugly.proguard.z.a(200000, false);
                com.tencent.bugly.proguard.x.a("onThreadBlock found visiable anr , start to process!", new java.lang.Object[0]);
                a(this.c, "", processErrorStateInfoA, java.lang.System.currentTimeMillis(), mapA);
            } catch (java.lang.Throwable unused) {
                return false;
            }
        } else {
            com.tencent.bugly.proguard.x.c("anr handler onThreadBlock only care main thread", new java.lang.Object[0]);
        }
        return true;
    }

    protected final void b() {
        long jB = com.tencent.bugly.proguard.z.b() - com.tencent.bugly.crashreport.crash.c.g;
        java.io.File file = new java.io.File(this.g);
        if (file.exists() && file.isDirectory()) {
            try {
                java.io.File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i = 0;
                    for (java.io.File file2 : fileArrListFiles) {
                        java.lang.String name = file2.getName();
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                int iIndexOf = name.indexOf(".txt");
                                if (iIndexOf <= 0 || java.lang.Long.parseLong(name.substring(12, iIndexOf)) < jB) {
                                    if (file2.delete()) {
                                        i++;
                                    }
                                }
                            } catch (java.lang.Throwable unused) {
                                com.tencent.bugly.proguard.x.c("Trace file that has invalid format: " + name, new java.lang.Object[0]);
                            }
                        }
                    }
                    com.tencent.bugly.proguard.x.c("Number of overdue trace files that has deleted: " + i, new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
            }
        }
    }

    public final void c() {
        com.tencent.bugly.proguard.ab.a(this.c).a();
        com.tencent.bugly.proguard.ab.a(this.c).a(this);
        com.tencent.bugly.proguard.ab.a(this.c).d();
    }

    public final void d() {
        com.tencent.bugly.proguard.ab.a(this.c).b();
        com.tencent.bugly.proguard.ab.a(this.c).b(this);
        com.tencent.bugly.proguard.ab.a(this.c).c();
    }
}
