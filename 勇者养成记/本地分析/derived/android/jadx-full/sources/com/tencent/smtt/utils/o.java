package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class o {
    private static com.tencent.smtt.utils.o e;
    private android.content.Context b;
    private java.io.File c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f982a = false;
    private boolean d = false;
    private java.io.File f = null;

    private o(android.content.Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized com.tencent.smtt.utils.o a() {
        return e;
    }

    public static synchronized com.tencent.smtt.utils.o a(android.content.Context context) {
        if (e == null) {
            e = new com.tencent.smtt.utils.o(context);
        }
        return e;
    }

    private java.io.File d() {
        try {
            if (this.c == null) {
                java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(this.b), "core_private");
                this.c = file;
                if (!file.isDirectory()) {
                    return null;
                }
            }
            java.io.File file2 = new java.io.File(this.c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }

    public synchronized void b() {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        try {
            try {
                if (this.f == null) {
                    this.f = d();
                }
                if (this.f == null) {
                    return;
                }
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(this.f));
                try {
                    try {
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(bufferedInputStream);
                        java.lang.String property = properties.getProperty("setting_forceUseSystemWebview", "");
                        if (!"".equals(property)) {
                            this.f982a = java.lang.Boolean.parseBoolean(property);
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                    }
                    bufferedInputStream.close();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            } catch (java.lang.Throwable th3) {
                bufferedInputStream = null;
                th = th3;
            }
            th.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (java.lang.Throwable th4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedInputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public void c() {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedOutputStream bufferedOutputStream = 0;
        bufferedOutputStream = 0;
        try {
            try {
                java.io.File fileD = d();
                try {
                    try {
                        if (fileD == null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (java.lang.Exception e2) {
                                e2.printStackTrace();
                            }
                            try {
                                bufferedOutputStream.close();
                                return;
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                        bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(fileD));
                        try {
                            java.util.Properties properties = new java.util.Properties();
                            properties.load(bufferedInputStream);
                            properties.setProperty("setting_forceUseSystemWebview", java.lang.Boolean.toString(this.f982a));
                            properties.setProperty("result_systemWebviewForceUsed", java.lang.Boolean.toString(this.d));
                            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(fileD));
                            try {
                                properties.store(bufferedOutputStream2, (java.lang.String) null);
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e4) {
                                    e4.printStackTrace();
                                }
                                bufferedOutputStream2.close();
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                th.printStackTrace();
                                bufferedInputStream.close();
                                bufferedOutputStream.close();
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                        bufferedInputStream.close();
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                    th.printStackTrace();
                    bufferedOutputStream.close();
                } finally {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Exception e6) {
                        e6.printStackTrace();
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (java.lang.Exception e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (java.lang.Exception e8) {
        }
    }
}
