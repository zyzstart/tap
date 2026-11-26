package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class TbsBaseConfig {
    public static final java.lang.String TAG = "TbsBaseConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.Map f853a;
    private android.content.Context b;

    private static java.io.File a(android.content.Context context, java.lang.String str) {
        com.tencent.smtt.sdk.m.a();
        java.io.File fileS = com.tencent.smtt.sdk.m.s(context);
        if (fileS == null) {
            return null;
        }
        java.io.File file = new java.io.File(fileS, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f853a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract java.lang.String getConfigFileName();

    public void init(android.content.Context context) {
        this.f853a = new java.util.HashMap();
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void refreshSyncMap(android.content.Context context) {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        try {
            java.io.File fileA = a(this.b, getConfigFileName());
            try {
                if (fileA == null) {
                    return;
                }
                this.f853a.clear();
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(fileA));
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(bufferedInputStream);
                    for (java.lang.String str : properties.stringPropertyNames()) {
                        this.f853a.put(str, properties.getProperty(str));
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                }
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (java.lang.Throwable th3) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th3;
            }
        } catch (java.lang.Throwable th4) {
            bufferedInputStream = null;
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b1 A[Catch: Exception -> 0x00b5, all -> 0x00d1, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x00b5, blocks: (B:22:0x0095, B:37:0x00b1), top: B:71:0x0009, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void writeTbsDownloadInfo() {
        java.io.BufferedInputStream bufferedInputStream;
        try {
            com.tencent.smtt.utils.TbsLog.i(TAG, "writeTbsDownloadInfo #1");
            java.io.BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    java.io.File fileA = a(this.b, getConfigFileName());
                    try {
                        if (fileA == null) {
                            return;
                        }
                        bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(fileA));
                        try {
                            java.util.Properties properties = new java.util.Properties();
                            properties.load(bufferedInputStream);
                            properties.clear();
                            for (java.lang.String str : this.f853a.keySet()) {
                                java.lang.Object obj = this.f853a.get(str);
                                properties.setProperty(str, "" + obj);
                                com.tencent.smtt.utils.TbsLog.i(TAG, "writeTbsDownloadInfo key is " + str + " value is " + obj);
                            }
                            this.f853a.clear();
                            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(fileA));
                            try {
                                properties.store(bufferedOutputStream2, (java.lang.String) null);
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                                bufferedOutputStream2.close();
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                th.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (java.lang.Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                    } catch (java.lang.Throwable th3) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream == null) {
                            throw th3;
                        }
                        try {
                            bufferedOutputStream.close();
                            throw th3;
                        } catch (java.lang.Exception e4) {
                            e4.printStackTrace();
                            throw th3;
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                }
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
        } catch (java.lang.Throwable th5) {
            throw th5;
        }
    }
}
