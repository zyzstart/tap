package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.k f933a;
    private static android.content.Context b;

    private k() {
    }

    static com.tencent.smtt.sdk.k a(android.content.Context context) {
        if (f933a == null) {
            synchronized (com.tencent.smtt.sdk.k.class) {
                if (f933a == null) {
                    f933a = new com.tencent.smtt.sdk.k();
                }
            }
        }
        b = context.getApplicationContext();
        return f933a;
    }

    private java.util.Properties e() throws java.lang.Throwable {
        java.util.Properties properties;
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.File fileA = a();
                properties = new java.util.Properties();
                if (fileA != null) {
                    try {
                        java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(fileA));
                        try {
                            properties.load(bufferedInputStream2);
                            bufferedInputStream = bufferedInputStream2;
                        } catch (java.lang.Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return properties;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return properties;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            properties = null;
        }
    }

    java.io.File a() {
        com.tencent.smtt.sdk.m.a();
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.m.s(b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    void a(int i) {
        a("dexopt_retry_num", i);
    }

    void a(int i, int i2) {
        a("copy_core_ver", i);
        a("copy_status", i2);
    }

    void a(java.lang.String str) {
        a("install_apk_path", str);
    }

    void a(java.lang.String str, int i) {
        a(str, java.lang.String.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.util.Properties propertiesE = e();
                if (propertiesE != null) {
                    propertiesE.setProperty(str, str2);
                    java.io.File fileA = a();
                    if (fileA != null) {
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(fileA);
                        try {
                            propertiesE.store(fileOutputStream2, "update " + str + " and status!");
                            fileOutputStream = fileOutputStream2;
                        } catch (java.lang.Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream == null) {
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            }
            try {
                fileOutputStream.close();
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    int b() {
        return c("install_core_ver");
    }

    int b(java.lang.String str) {
        java.util.Properties propertiesE = e();
        if (propertiesE == null || propertiesE.getProperty(str) == null) {
            return -1;
        }
        return java.lang.Integer.parseInt(propertiesE.getProperty(str));
    }

    void b(int i) {
        a("unzip_retry_num", i);
    }

    void b(int i, int i2) {
        a("tpatch_ver", i);
        a("tpatch_status", i2);
    }

    int c() {
        return b("install_status");
    }

    int c(java.lang.String str) throws java.lang.Throwable {
        java.util.Properties propertiesE = e();
        if (propertiesE == null || propertiesE.getProperty(str) == null) {
            return 0;
        }
        return java.lang.Integer.parseInt(propertiesE.getProperty(str));
    }

    void c(int i) {
        a("incrupdate_status", i);
    }

    void c(int i, int i2) {
        a("install_core_ver", i);
        a("install_status", i2);
    }

    int d() {
        return b("incrupdate_status");
    }

    java.lang.String d(java.lang.String str) throws java.lang.Throwable {
        java.util.Properties propertiesE = e();
        if (propertiesE == null || propertiesE.getProperty(str) == null) {
            return null;
        }
        return propertiesE.getProperty(str);
    }

    void d(int i) {
        a("unlzma_status", i);
    }
}
