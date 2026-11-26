package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f455a = true;
    private static java.text.SimpleDateFormat b = null;
    private static int c = 5120;
    private static java.lang.StringBuilder d = null;
    private static java.lang.StringBuilder e = null;
    private static boolean f = false;
    private static com.tencent.bugly.proguard.y.a g = null;
    private static java.lang.String h = null;
    private static java.lang.String i = null;
    private static android.content.Context j = null;
    private static java.lang.String k = null;
    private static boolean l = false;
    private static boolean m = false;
    private static int n;
    private static final java.lang.Object o = new java.lang.Object();

    /* JADX INFO: compiled from: BUGLY */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f456a;
        private java.io.File b;
        private java.lang.String c;
        private long d;
        private long e = 30720;

        public a(java.lang.String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.c = str;
            this.f456a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                this.b = new java.io.File(this.c);
                if (this.b.exists() && !this.b.delete()) {
                    this.f456a = false;
                    return false;
                }
                if (this.b.createNewFile()) {
                    return true;
                }
                this.f456a = false;
                return false;
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
                this.f456a = false;
                return false;
            }
        }

        public final boolean a(java.lang.String str) throws java.lang.Throwable {
            java.io.FileOutputStream fileOutputStream;
            if (!this.f456a) {
                return false;
            }
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(this.b, true);
                    try {
                        byte[] bytes = str.getBytes("UTF-8");
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.d += (long) bytes.length;
                        this.f456a = true;
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                        return true;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }
    }

    static {
        try {
            b = new java.text.SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(int i2) {
        synchronized (o) {
            c = i2;
            if (i2 < 0) {
                c = 0;
            } else if (i2 > 10240) {
                c = 10240;
            }
        }
    }

    public static synchronized void a(android.content.Context context) {
        if (l || context == null || !f455a) {
            return;
        }
        try {
            e = new java.lang.StringBuilder(0);
            d = new java.lang.StringBuilder(0);
            j = context;
            com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
            h = aVarA.d;
            aVarA.getClass();
            i = "";
            k = j.getFilesDir().getPath() + "/buglylog_" + h + "_" + i + ".txt";
            n = android.os.Process.myPid();
        } catch (java.lang.Throwable unused) {
        }
        l = true;
    }

    public static synchronized void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (l && f455a) {
            if (m && b(str, str2, str3)) {
                return;
            }
            long jMyTid = android.os.Process.myTid();
            d.setLength(0);
            if (str3.length() > 30720) {
                str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
            }
            java.util.Date date = new java.util.Date();
            java.lang.String string = b != null ? b.format(date) : date.toString();
            java.lang.StringBuilder sb = d;
            sb.append(string);
            sb.append(" ");
            sb.append(n);
            sb.append(" ");
            sb.append(jMyTid);
            sb.append(" ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str3);
            sb.append("\u0001\r\n");
            java.lang.String string2 = d.toString();
            synchronized (o) {
                e.append(string2);
                if (e.length() <= c) {
                    return;
                }
                if (f) {
                    return;
                }
                f = true;
                com.tencent.bugly.proguard.w.a().a(new java.lang.Runnable() { // from class: com.tencent.bugly.proguard.y.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        synchronized (com.tencent.bugly.proguard.y.o) {
                            try {
                                if (com.tencent.bugly.proguard.y.g == null) {
                                    com.tencent.bugly.proguard.y.a unused = com.tencent.bugly.proguard.y.g = new com.tencent.bugly.proguard.y.a(com.tencent.bugly.proguard.y.k);
                                } else if (com.tencent.bugly.proguard.y.g.b == null || com.tencent.bugly.proguard.y.g.b.length() + ((long) com.tencent.bugly.proguard.y.e.length()) > com.tencent.bugly.proguard.y.g.e) {
                                    com.tencent.bugly.proguard.y.g.a();
                                }
                                if (com.tencent.bugly.proguard.y.g.a(com.tencent.bugly.proguard.y.e.toString())) {
                                    com.tencent.bugly.proguard.y.e.setLength(0);
                                    com.tencent.bugly.proguard.y.b(false);
                                }
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                    }
                });
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        java.lang.String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + com.tencent.bugly.proguard.z.b(th));
    }

    public static void a(boolean z) {
        com.tencent.bugly.proguard.x.a("[LogUtil] Whether can record user log into native: " + z, new java.lang.Object[0]);
        m = z;
    }

    public static byte[] a() {
        if (!f455a) {
            return null;
        }
        if (m) {
            com.tencent.bugly.proguard.x.a("[LogUtil] Get user log from native.", new java.lang.Object[0]);
            java.lang.String strF = f();
            if (strF != null) {
                com.tencent.bugly.proguard.x.a("[LogUtil] Got user log from native: %d bytes", java.lang.Integer.valueOf(strF.length()));
                return com.tencent.bugly.proguard.z.a((java.io.File) null, strF, "BuglyNativeLog.txt");
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (o) {
            if (g != null && g.f456a && g.b != null && g.b.length() > 0) {
                sb.append(com.tencent.bugly.proguard.z.a(g.b, 30720, true));
            }
            if (e != null && e.length() > 0) {
                sb.append(e.toString());
            }
        }
        return com.tencent.bugly.proguard.z.a((java.io.File) null, sb.toString(), "BuglyLog.txt");
    }

    private static boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.D == null) {
                return false;
            }
            return aVarB.D.appendLogToNative(str, str2, str3);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ boolean b(boolean z) {
        f = false;
        return false;
    }

    private static java.lang.String f() {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.D == null) {
                return null;
            }
            return aVarB.D.getLogFromNative();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
