package com.tencent.bugly.opengame.crashreport.crash.anr;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements com.tencent.bugly.opengame.proguard.ac {
    private final android.content.Context c;
    private final com.tencent.bugly.opengame.crashreport.common.info.a d;
    private final com.tencent.bugly.opengame.proguard.w e;
    private final com.tencent.bugly.opengame.crashreport.common.strategy.a f;
    private final java.lang.String g;
    private final com.tencent.bugly.opengame.crashreport.crash.b h;
    private android.os.FileObserver i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.atomic.AtomicInteger f355a = new java.util.concurrent.atomic.AtomicInteger(0);
    private long b = -1;
    private boolean j = true;

    public b(android.content.Context context, com.tencent.bugly.opengame.crashreport.common.strategy.a aVar, com.tencent.bugly.opengame.crashreport.common.info.a aVar2, com.tencent.bugly.opengame.proguard.w wVar, com.tencent.bugly.opengame.crashreport.crash.b bVar) {
        this.c = com.tencent.bugly.opengame.proguard.z.a(context);
        this.g = context.getDir(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY, 0).getAbsolutePath();
        this.d = aVar2;
        this.e = wVar;
        this.f = aVar;
        this.h = bVar;
    }

    private static android.app.ActivityManager.ProcessErrorStateInfo a(android.content.Context context, long j) {
        com.tencent.bugly.opengame.proguard.x.c("to find!", new java.lang.Object[0]);
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        int i = 0;
        while (true) {
            com.tencent.bugly.opengame.proguard.x.c("waiting!", new java.lang.Object[0]);
            java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        com.tencent.bugly.opengame.proguard.x.c("found!", new java.lang.Object[0]);
                        return processErrorStateInfo;
                    }
                }
            }
            com.tencent.bugly.opengame.proguard.z.b(500L);
            int i2 = i + 1;
            if (i >= 20) {
                com.tencent.bugly.opengame.proguard.x.c("end!", new java.lang.Object[0]);
                return null;
            }
            i = i2;
        }
    }

    private com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean a(com.tencent.bugly.opengame.crashreport.crash.anr.a aVar) {
        com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBean = new com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.opengame.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.opengame.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.opengame.crashreport.common.info.b.m();
            crashDetailBean.F = this.d.p();
            crashDetailBean.G = this.d.o();
            crashDetailBean.H = this.d.q();
            crashDetailBean.w = com.tencent.bugly.opengame.proguard.z.a(this.c, com.tencent.bugly.opengame.crashreport.crash.c.e, (java.lang.String) null);
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.j;
            crashDetailBean.g = this.d.w();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            java.util.HashMap map = new java.util.HashMap();
            crashDetailBean.O = map;
            map.put("BUGLY_CR_01", aVar.e);
            int iIndexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = iIndexOf > 0 ? crashDetailBean.q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = com.tencent.bugly.opengame.proguard.z.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.f354a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.J();
            crashDetailBean.v = aVar.d;
            crashDetailBean.L = this.d.n;
            crashDetailBean.M = this.d.f342a;
            crashDetailBean.N = this.d.a();
            crashDetailBean.P = this.d.H();
            crashDetailBean.Q = this.d.I();
            crashDetailBean.R = this.d.B();
            crashDetailBean.S = this.d.G();
            this.h.c(crashDetailBean);
            crashDetailBean.y = com.tencent.bugly.opengame.proguard.y.a();
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private boolean a(android.content.Context context, java.lang.String str, android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, java.util.Map map) {
        java.io.File file = new java.io.File(context.getFilesDir(), "bugly/bugly_trace_" + j + ".txt");
        com.tencent.bugly.opengame.crashreport.crash.anr.a aVar = new com.tencent.bugly.opengame.crashreport.crash.anr.a();
        aVar.c = j;
        aVar.d = file.getAbsolutePath();
        aVar.f354a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    aVar.g = (java.lang.String) map.get(str2);
                }
            }
        }
        java.lang.Object[] objArr = new java.lang.Object[6];
        objArr[0] = java.lang.Long.valueOf(aVar.c);
        objArr[1] = aVar.d;
        objArr[2] = aVar.f354a;
        objArr[3] = aVar.f;
        objArr[4] = aVar.e;
        java.util.Map map2 = aVar.b;
        objArr[5] = java.lang.Integer.valueOf(map2 == null ? 0 : map2.size());
        com.tencent.bugly.opengame.proguard.x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        if (!this.f.b()) {
            com.tencent.bugly.opengame.proguard.x.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
            com.tencent.bugly.opengame.crashreport.crash.b.a("ANR", com.tencent.bugly.opengame.proguard.z.a(), aVar.f354a, "main", aVar.e, null);
            return false;
        }
        if (!this.f.c().j) {
            com.tencent.bugly.opengame.proguard.x.d("ANR Report is closed!", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.opengame.proguard.x.a("found visiable anr , start to upload!", new java.lang.Object[0]);
        com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanA = a(aVar);
        if (crashDetailBeanA == null) {
            com.tencent.bugly.opengame.proguard.x.e("pack anr fail!", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.opengame.crashreport.crash.c.a().a(crashDetailBeanA);
        if (crashDetailBeanA.f349a >= 0) {
            com.tencent.bugly.opengame.proguard.x.a("backup anr record success!", new java.lang.Object[0]);
        } else {
            com.tencent.bugly.opengame.proguard.x.d("backup anr record fail!", new java.lang.Object[0]);
        }
        if (str != null && new java.io.File(str).exists()) {
            this.f355a.set(3);
            if (a(str, aVar.d, aVar.f354a)) {
                com.tencent.bugly.opengame.proguard.x.a("backup trace success", new java.lang.Object[0]);
            }
        }
        com.tencent.bugly.opengame.crashreport.crash.b.a("ANR", com.tencent.bugly.opengame.proguard.z.a(), aVar.f354a, "main", aVar.e, crashDetailBeanA);
        if (!this.h.a(crashDetailBeanA)) {
            this.h.a(crashDetailBeanA, 3000L, true);
        }
        this.h.b(crashDetailBeanA);
        return true;
    }

    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.util.Map map;
        com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a targetDumpInfo = com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo == null || (map = targetDumpInfo.d) == null || map.size() <= 0) {
            com.tencent.bugly.opengame.proguard.x.e("not found trace dump for %s", str3);
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
                com.tencent.bugly.opengame.proguard.x.e("backup file create fail %s", str2);
                return false;
            }
            java.io.BufferedWriter bufferedWriter = null;
            try {
                try {
                    java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(file, false));
                    try {
                        java.lang.String[] strArr = (java.lang.String[]) targetDumpInfo.d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            java.lang.String str4 = strArr[0];
                            java.lang.String str5 = strArr[1];
                            bufferedWriter2.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter2.flush();
                        }
                        for (java.util.Map.Entry entry : targetDumpInfo.d.entrySet()) {
                            if (!((java.lang.String) entry.getKey()).equals("main") && entry.getValue() != null && ((java.lang.String[]) entry.getValue()).length >= 3) {
                                java.lang.String str6 = ((java.lang.String[]) entry.getValue())[0];
                                java.lang.String str7 = ((java.lang.String[]) entry.getValue())[1];
                                bufferedWriter2.write("\"" + ((java.lang.String) entry.getKey()) + "\" tid=" + ((java.lang.String[]) entry.getValue())[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                bufferedWriter2.flush();
                            }
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (java.io.IOException e) {
                            if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                        com.tencent.bugly.opengame.proguard.x.e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.io.IOException e3) {
                                if (!com.tencent.bugly.opengame.proguard.x.a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.io.IOException e4) {
                                if (!com.tencent.bugly.opengame.proguard.x.a(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.io.IOException e5) {
                e = e5;
            }
        } catch (java.lang.Exception e6) {
            if (!com.tencent.bugly.opengame.proguard.x.a(e6)) {
                e6.printStackTrace();
            }
            com.tencent.bugly.opengame.proguard.x.e("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str2);
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
            com.tencent.bugly.opengame.proguard.x.a("user change anr %b", java.lang.Boolean.valueOf(z));
            this.j = z;
        }
    }

    private synchronized void e() {
        if (g()) {
            com.tencent.bugly.opengame.proguard.x.d("start when started!", new java.lang.Object[0]);
            return;
        }
        android.os.FileObserver fileObserver = new android.os.FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.opengame.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, java.lang.String str) {
                if (str == null) {
                    return;
                }
                java.lang.String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    com.tencent.bugly.opengame.crashreport.crash.anr.b.this.a(str2);
                } else {
                    com.tencent.bugly.opengame.proguard.x.d("not anr file %s", str2);
                }
            }
        };
        this.i = fileObserver;
        try {
            fileObserver.startWatching();
            com.tencent.bugly.opengame.proguard.x.a("start anr monitor!", new java.lang.Object[0]);
            this.e.a(new java.lang.Runnable() { // from class: com.tencent.bugly.opengame.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.bugly.opengame.crashreport.crash.anr.b.this.b();
                }
            });
        } catch (java.lang.Throwable th) {
            this.i = null;
            com.tencent.bugly.opengame.proguard.x.d("start anr monitor failed!", new java.lang.Object[0]);
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void f() {
        if (!g()) {
            com.tencent.bugly.opengame.proguard.x.d("close when closed!", new java.lang.Object[0]);
            return;
        }
        try {
            this.i.stopWatching();
            this.i = null;
            com.tencent.bugly.opengame.proguard.x.d("close anr monitor!", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.d("stop anr monitor failed!", new java.lang.Object[0]);
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
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

    public final synchronized void a(com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.j != g()) {
            com.tencent.bugly.opengame.proguard.x.d("server anr changed to %b", java.lang.Boolean.valueOf(strategyBean.j));
        }
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            boolean z = strategyBean.j && h();
            if (z != g()) {
                com.tencent.bugly.opengame.proguard.x.a("anr changed to %b", java.lang.Boolean.valueOf(z));
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
        java.lang.String str2;
        java.lang.Object[] objArr;
        java.lang.String str3;
        java.lang.Object[] objArr2;
        synchronized (this) {
            if (this.f355a.get() != 0) {
                com.tencent.bugly.opengame.proguard.x.c("trace started return ", new java.lang.Object[0]);
                return;
            }
            this.f355a.set(1);
            try {
                com.tencent.bugly.opengame.proguard.x.c("read trace first dump for create time!", new java.lang.Object[0]);
                com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.a firstDumpInfo = com.tencent.bugly.opengame.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(str, false);
                long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.c : -1L;
                if (jCurrentTimeMillis == -1) {
                    com.tencent.bugly.opengame.proguard.x.d("trace dump fail could not get time!", new java.lang.Object[0]);
                    jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                }
                long j = jCurrentTimeMillis;
                if (java.lang.Math.abs(j - this.b) >= 10000) {
                    this.b = j;
                    this.f355a.set(1);
                    try {
                        java.util.Map mapA = com.tencent.bugly.opengame.proguard.z.a(com.tencent.bugly.opengame.crashreport.crash.c.f, false);
                        if (mapA == null || mapA.size() <= 0) {
                            str2 = "can't get all thread skip this anr";
                            objArr = new java.lang.Object[0];
                        } else {
                            android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.c, 10000L);
                            if (processErrorStateInfoA == null) {
                                str3 = "proc state is unvisiable!";
                                objArr2 = new java.lang.Object[0];
                            } else if (processErrorStateInfoA.pid != android.os.Process.myPid()) {
                                str3 = "not mind proc!";
                                objArr2 = new java.lang.Object[]{processErrorStateInfoA.processName};
                            } else {
                                com.tencent.bugly.opengame.proguard.x.a("found visiable anr , start to process!", new java.lang.Object[0]);
                                a(this.c, str, processErrorStateInfoA, j, mapA);
                            }
                            com.tencent.bugly.opengame.proguard.x.c(str3, objArr2);
                        }
                    } catch (java.lang.Throwable th) {
                        com.tencent.bugly.opengame.proguard.x.a(th);
                        com.tencent.bugly.opengame.proguard.x.e("get all thread stack fail!", new java.lang.Object[0]);
                    }
                }
                str2 = "should not process ANR too Fre in %d";
                objArr = new java.lang.Object[]{10000};
                com.tencent.bugly.opengame.proguard.x.d(str2, objArr);
            } catch (java.lang.Throwable th2) {
                try {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th2)) {
                        th2.printStackTrace();
                    }
                    com.tencent.bugly.opengame.proguard.x.e("handle anr error %s", th2.getClass().toString());
                } finally {
                    this.f355a.set(0);
                }
            }
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean zH = h();
        com.tencent.bugly.opengame.crashreport.common.strategy.a aVarA = com.tencent.bugly.opengame.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zH = zH && aVarA.c().g;
        }
        if (zH != g()) {
            com.tencent.bugly.opengame.proguard.x.a("anr changed to %b", java.lang.Boolean.valueOf(zH));
            b(zH);
        }
    }

    public final boolean a() {
        return this.f355a.get() != 0;
    }

    @Override // com.tencent.bugly.opengame.proguard.ac
    public final boolean a(java.lang.Thread thread) {
        java.lang.Object[] objArr;
        java.lang.String str;
        new java.util.HashMap();
        if (thread.getName().contains("main")) {
            android.app.ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.c, 10000L);
            if (processErrorStateInfoA == null) {
                objArr = new java.lang.Object[0];
                str = "anr handler onThreadBlock proc state is unvisiable!";
            } else if (processErrorStateInfoA.pid != android.os.Process.myPid()) {
                objArr = new java.lang.Object[]{processErrorStateInfoA.processName};
                str = "onThreadBlock not mind proc!";
            } else {
                try {
                    java.util.Map mapA = com.tencent.bugly.opengame.proguard.z.a(200000, false);
                    com.tencent.bugly.opengame.proguard.x.a("onThreadBlock found visiable anr , start to process!", new java.lang.Object[0]);
                    a(this.c, "", processErrorStateInfoA, java.lang.System.currentTimeMillis(), mapA);
                } catch (java.lang.Throwable unused) {
                    return false;
                }
            }
            com.tencent.bugly.opengame.proguard.x.c(str, objArr);
            return false;
        }
        com.tencent.bugly.opengame.proguard.x.c("anr handler onThreadBlock only care main thread", new java.lang.Object[0]);
        return true;
    }

    protected final void b() {
        long jB = com.tencent.bugly.opengame.proguard.z.b() - com.tencent.bugly.opengame.crashreport.crash.c.g;
        java.io.File file = new java.io.File(this.g);
        if (file.exists() && file.isDirectory()) {
            try {
                java.io.File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    return;
                }
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
                            com.tencent.bugly.opengame.proguard.x.c("Trace file that has invalid format: " + name, new java.lang.Object[0]);
                        }
                    }
                }
                com.tencent.bugly.opengame.proguard.x.c("Number of overdue trace files that has deleted: " + i, new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.opengame.proguard.x.a(th);
            }
        }
    }

    public final void c() {
        com.tencent.bugly.opengame.proguard.ab.a(this.c).a();
        com.tencent.bugly.opengame.proguard.ab.a(this.c).a(this);
        com.tencent.bugly.opengame.proguard.ab.a(this.c).d();
    }

    public final void d() {
        com.tencent.bugly.opengame.proguard.ab.a(this.c).b();
        com.tencent.bugly.opengame.proguard.ab.a(this.c).b(this);
        com.tencent.bugly.opengame.proguard.ab.a(this.c).c();
    }
}
