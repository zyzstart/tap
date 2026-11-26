package com.tencent.bugly.crashreport.crash.jni;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler f320a = null;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean o = true;
    private final android.content.Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final com.tencent.bugly.proguard.w d;
    private com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler e;
    private java.lang.String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.tencent.bugly.crashreport.crash.b n;

    @android.annotation.SuppressLint({"SdCardPath"})
    private NativeCrashHandler(android.content.Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.proguard.w wVar, boolean z, java.lang.String str) {
        this.b = com.tencent.bugly.proguard.z.a(context);
        try {
            if (com.tencent.bugly.proguard.z.a(str)) {
                str = context.getDir(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY, 0).getAbsolutePath();
            }
        } catch (java.lang.Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new com.tencent.bugly.crashreport.crash.jni.a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007f A[Catch: Throwable -> 0x008d, all -> 0x019f, TryCatch #0 {Throwable -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:67:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x008b A[Catch: Throwable -> 0x008d, all -> 0x019f, TRY_LEAVE, TryCatch #0 {Throwable -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:67:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0091 A[Catch: Throwable -> 0x00c0, all -> 0x019f, TryCatch #1 {Throwable -> 0x00c0, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:69:0x0015, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[Catch: Throwable -> 0x00c0, all -> 0x019f, TryCatch #1 {Throwable -> 0x00c0, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:69:0x0015, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a4 A[Catch: Throwable -> 0x00c0, all -> 0x019f, TryCatch #1 {Throwable -> 0x00c0, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:69:0x0015, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac A[Catch: Throwable -> 0x00c0, all -> 0x019f, TryCatch #1 {Throwable -> 0x00c0, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:69:0x0015, outer: #3 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void a(boolean z) {
        java.lang.StringBuilder sb;
        if (this.j) {
            com.tencent.bugly.proguard.x.d("[Native] Native crash report has already registered.", new java.lang.Object[0]);
            return;
        }
        if (this.i) {
            try {
                java.lang.String strRegist = regist(this.f, z, 1);
                if (strRegist != null) {
                    com.tencent.bugly.proguard.x.a("[Native] Native Crash Report enable.", new java.lang.Object[0]);
                    com.tencent.bugly.proguard.x.c("[Native] Check extra jni for Bugly NDK v%s", strRegist);
                    java.lang.String strReplace = "2.1.1".replace(".", "");
                    java.lang.String strReplace2 = "2.3.0".replace(".", "");
                    java.lang.String strReplace3 = strRegist.replace(".", "");
                    try {
                        if (strReplace3.length() != 2) {
                            if (strReplace3.length() == 1) {
                                sb = new java.lang.StringBuilder();
                                sb.append(strReplace3);
                                sb.append("00");
                            }
                            if (java.lang.Integer.parseInt(strReplace3) >= java.lang.Integer.parseInt(strReplace)) {
                                l = true;
                            }
                            if (java.lang.Integer.parseInt(strReplace3) >= java.lang.Integer.parseInt(strReplace2)) {
                                m = true;
                            }
                            if (m) {
                                com.tencent.bugly.proguard.x.a("[Native] Info setting jni can be accessed.", new java.lang.Object[0]);
                            } else {
                                com.tencent.bugly.proguard.x.d("[Native] Info setting jni can not be accessed.", new java.lang.Object[0]);
                            }
                            if (l) {
                                com.tencent.bugly.proguard.x.a("[Native] Extra jni can be accessed.", new java.lang.Object[0]);
                            } else {
                                com.tencent.bugly.proguard.x.d("[Native] Extra jni can not be accessed.", new java.lang.Object[0]);
                            }
                            this.c.n = strRegist;
                            com.tencent.bugly.proguard.y.a(l);
                            this.j = true;
                            return;
                        }
                        sb = new java.lang.StringBuilder();
                        sb.append(strReplace3);
                        sb.append("0");
                        if (java.lang.Integer.parseInt(strReplace3) >= java.lang.Integer.parseInt(strReplace)) {
                            l = true;
                        }
                        if (java.lang.Integer.parseInt(strReplace3) >= java.lang.Integer.parseInt(strReplace2)) {
                            m = true;
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                    strReplace3 = sb.toString();
                    if (m) {
                        com.tencent.bugly.proguard.x.a("[Native] Info setting jni can be accessed.", new java.lang.Object[0]);
                    } else {
                        com.tencent.bugly.proguard.x.d("[Native] Info setting jni can not be accessed.", new java.lang.Object[0]);
                    }
                    if (l) {
                        com.tencent.bugly.proguard.x.a("[Native] Extra jni can be accessed.", new java.lang.Object[0]);
                    } else {
                        com.tencent.bugly.proguard.x.d("[Native] Extra jni can not be accessed.", new java.lang.Object[0]);
                    }
                    this.c.n = strRegist;
                    com.tencent.bugly.proguard.y.a(l);
                    this.j = true;
                    return;
                }
            } catch (java.lang.Throwable unused2) {
                com.tencent.bugly.proguard.x.c("[Native] Failed to load Bugly SO file.", new java.lang.Object[0]);
            }
        } else if (this.h) {
            try {
                java.lang.Class[] clsArr = {java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE, java.lang.Integer.TYPE};
                java.lang.Object[] objArr = new java.lang.Object[4];
                objArr[0] = this.f;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
                objArr[2] = java.lang.Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                java.lang.String str = (java.lang.String) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    java.lang.Class[] clsArr2 = {java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE};
                    com.tencent.bugly.crashreport.common.info.a.b();
                    str = (java.lang.String) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, clsArr2, new java.lang.Object[]{this.f, com.tencent.bugly.crashreport.common.info.b.a(this.b, false), java.lang.Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.K())});
                }
                if (str != null) {
                    this.j = true;
                    com.tencent.bugly.crashreport.common.info.a.b().n = str;
                    java.lang.Boolean bool = (java.lang.Boolean) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{str});
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        l = zBooleanValue;
                        com.tencent.bugly.proguard.y.a(zBooleanValue);
                    }
                    com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new java.lang.Class[]{java.lang.Boolean.TYPE}, new java.lang.Object[]{true});
                    com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new java.lang.Class[]{java.lang.Integer.TYPE}, new java.lang.Object[]{java.lang.Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
        this.i = false;
        this.h = false;
    }

    private boolean a(int i, java.lang.String str) {
        if (!this.i || !m) {
            return false;
        }
        try {
            setNativeInfo(i, str);
            return true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            m = false;
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    static /* synthetic */ boolean a(com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler, int i, java.lang.String str) {
        return nativeCrashHandler.a(999, str);
    }

    private static boolean a(java.lang.String str, boolean z) {
        boolean z2;
        try {
            com.tencent.bugly.proguard.x.a("[Native] Trying to load so: %s", str);
            if (z) {
                java.lang.System.load(str);
            } else {
                java.lang.System.loadLibrary(str);
            }
            try {
                com.tencent.bugly.proguard.x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                z2 = true;
                com.tencent.bugly.proguard.x.d(th.getMessage(), new java.lang.Object[0]);
                com.tencent.bugly.proguard.x.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private synchronized void b(boolean z) {
        try {
            if (z) {
                startNativeMonitor();
            } else {
                c();
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    private synchronized void c() {
        if (!this.j) {
            com.tencent.bugly.proguard.x.d("[Native] Native crash report has already unregistered.", new java.lang.Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                com.tencent.bugly.proguard.x.a("[Native] Successfully closed native crash report.", new java.lang.Object[0]);
                this.j = false;
                return;
            }
            try {
                com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new java.lang.Class[]{java.lang.Boolean.TYPE}, new java.lang.Object[]{false});
                this.j = false;
                com.tencent.bugly.proguard.x.a("[Native] Successfully closed native crash report.", new java.lang.Object[0]);
                return;
            } catch (java.lang.Throwable unused) {
                com.tencent.bugly.proguard.x.c("[Native] Failed to close native crash report.", new java.lang.Object[0]);
                this.i = false;
                this.h = false;
                return;
            }
        } catch (java.lang.Throwable unused2) {
            com.tencent.bugly.proguard.x.c("[Native] Failed to close native crash report.", new java.lang.Object[0]);
        }
        throw th;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            com.tencent.bugly.proguard.x.a("user change native %b", java.lang.Boolean.valueOf(z));
            this.k = z;
        }
    }

    public static synchronized com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler getInstance() {
        return f320a;
    }

    public static synchronized com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler getInstance(android.content.Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, com.tencent.bugly.proguard.w wVar, boolean z, java.lang.String str) {
        if (f320a == null) {
            f320a = new com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler(context, aVar, bVar, wVar, z, str);
        }
        return f320a;
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    public static void setShouldHandleInJava(boolean z) {
        o = z;
        com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler nativeCrashHandler = f320a;
        if (nativeCrashHandler != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    protected final void a() {
        long jB = com.tencent.bugly.proguard.z.b() - com.tencent.bugly.crashreport.crash.c.g;
        long jB2 = com.tencent.bugly.proguard.z.b() + 86400000;
        java.io.File file = new java.io.File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                java.io.File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (java.io.File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (jLastModified < jB || jLastModified >= jB2) {
                            com.tencent.bugly.proguard.x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    com.tencent.bugly.proguard.x.c("[Native] Number of record files overdue: %d, has deleted: %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
                }
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
            }
        }
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean appendLogToNative(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if ((!this.h && !this.i) || !l || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.i) {
                return appendNativeLog(str, str2, str3);
            }
            java.lang.Boolean bool = (java.lang.Boolean) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class}, new java.lang.Object[]{str, str2, str3});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            l = false;
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    protected native boolean appendNativeLog(java.lang.String str, java.lang.String str2, java.lang.String str3);

    protected native boolean appendWholeNativeLog(java.lang.String str);

    public void checkUploadRecordCrash() {
        this.d.a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() throws java.lang.Throwable {
                if (!com.tencent.bugly.proguard.z.a(com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.b, "native_record_lock", 10000L)) {
                    com.tencent.bugly.proguard.x.a("[Native] Failed to lock file for handling native crash record.", new java.lang.Object[0]);
                    return;
                }
                if (!com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.o) {
                    com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this, 999, "false");
                }
                com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanA = com.tencent.bugly.crashreport.crash.jni.b.a(com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.b, com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.f, com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.e);
                if (crashDetailBeanA != null) {
                    com.tencent.bugly.proguard.x.a("[Native] Get crash from native record.", new java.lang.Object[0]);
                    if (!com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.n.a(crashDetailBeanA)) {
                        com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.n.a(crashDetailBeanA, 3000L, false);
                    }
                    com.tencent.bugly.crashreport.crash.jni.b.a(false, com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.f);
                }
                com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.a();
                com.tencent.bugly.proguard.z.b(com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.this.b, "native_record_lock");
            }
        });
    }

    public boolean filterSigabrtSysLog() {
        return a(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
    }

    public synchronized java.lang.String getDumpFilePath() {
        return this.f;
    }

    @Override // com.tencent.bugly.crashreport.a
    public java.lang.String getLogFromNative() {
        if ((!this.h && !this.i) || !l) {
            return null;
        }
        try {
            return this.i ? getNativeLog() : (java.lang.String) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (java.lang.UnsatisfiedLinkError unused) {
            l = false;
            return null;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected native java.lang.String getNativeKeyValueList();

    protected native java.lang.String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0031 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x001a, B:10:0x0026, B:14:0x002d, B:16:0x0031), top: B:22:0x0005 }] */
    public synchronized void onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean) {
        boolean z;
        if (strategyBean != null) {
            if (strategyBean.g != this.j) {
                com.tencent.bugly.proguard.x.d("server native changed to %b", java.lang.Boolean.valueOf(strategyBean.g));
            }
            if (com.tencent.bugly.crashreport.common.strategy.a.a().c().g || !this.k) {
                z = false;
            } else {
                z = true;
            }
            if (z != this.j) {
                com.tencent.bugly.proguard.x.a("native changed to %b", java.lang.Boolean.valueOf(z));
                b(z);
            }
        } else {
            if (com.tencent.bugly.crashreport.common.strategy.a.a().c().g) {
                z = false;
            } else {
                z = false;
            }
            if (z != this.j) {
                com.tencent.bugly.proguard.x.a("native changed to %b", java.lang.Boolean.valueOf(z));
                b(z);
            }
        }
        throw th;
    }

    public boolean putKeyValueToNative(java.lang.String str, java.lang.String str2) {
        if ((!this.h && !this.i) || !l || str == null || str2 == null) {
            return false;
        }
        try {
            if (this.i) {
                return putNativeKeyValue(str, str2);
            }
            java.lang.Boolean bool = (java.lang.Boolean) com.tencent.bugly.proguard.z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new java.lang.Class[]{java.lang.String.class, java.lang.String.class}, new java.lang.Object[]{str, str2});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            l = false;
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    protected native boolean putNativeKeyValue(java.lang.String str, java.lang.String str2);

    protected native java.lang.String regist(java.lang.String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        com.tencent.bugly.crashreport.crash.jni.b.c(this.f);
    }

    protected native java.lang.String removeNativeKeyValue(java.lang.String str);

    public synchronized void setDumpFilePath(java.lang.String str) {
        this.f = str;
    }

    public boolean setNativeAppChannel(java.lang.String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(java.lang.String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(java.lang.String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i, java.lang.String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, java.lang.String.valueOf(j));
        } catch (java.lang.NumberFormatException e) {
            if (com.tencent.bugly.proguard.x.a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(java.lang.String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean zIsUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zIsUserOpened = zIsUserOpened && aVarA.c().g;
        }
        if (zIsUserOpened != this.j) {
            com.tencent.bugly.proguard.x.a("native changed to %b", java.lang.Boolean.valueOf(zIsUserOpened));
            b(zIsUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.i && !this.h) {
            java.lang.String str = "Bugly";
            boolean z = !com.tencent.bugly.proguard.z.a(this.c.m);
            java.lang.String str2 = this.c.m;
            if (z) {
                str = str2;
            } else {
                this.c.getClass();
            }
            this.i = a(str, z);
            if (this.i || this.h) {
                a(this.g);
                if (l) {
                    setNativeAppVersion(this.c.j);
                    setNativeAppChannel(this.c.l);
                    setNativeAppPackage(this.c.c);
                    setNativeUserId(this.c.g());
                    setNativeIsAppForeground(this.c.a());
                    setNativeLaunchTime(this.c.f292a);
                }
                return;
            }
            return;
        }
        a(this.g);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.i) {
            testCrash();
        } else {
            com.tencent.bugly.proguard.x.d("[Native] Bugly SO file has not been load.", new java.lang.Object[0]);
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    protected native java.lang.String unregist();
}
