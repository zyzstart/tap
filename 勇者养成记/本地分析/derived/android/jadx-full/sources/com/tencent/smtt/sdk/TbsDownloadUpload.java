package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsDownloadUpload {
    private static com.tencent.smtt.sdk.TbsDownloadUpload b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.Map f857a = new java.util.HashMap();
    private android.content.Context c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    public android.content.SharedPreferences mPreferences;

    public interface TbsUploadKey {
        public static final java.lang.String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final java.lang.String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final java.lang.String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final java.lang.String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final java.lang.String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final java.lang.String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(android.content.Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        android.content.Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        if (applicationContext == null) {
            this.c = context;
        }
    }

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

    public static synchronized void clear() {
        b = null;
    }

    public static synchronized com.tencent.smtt.sdk.TbsDownloadUpload getInstance() {
        return b;
    }

    public static synchronized com.tencent.smtt.sdk.TbsDownloadUpload getInstance(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.smtt.sdk.TbsDownloadUpload(context);
        }
        return b;
    }

    public void clearUploadCode() {
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.f857a.put(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public synchronized int getLocalCoreVersion() {
        return this.i;
    }

    public synchronized int getNeedDownloadCode() {
        if (this.g == 1) {
            return com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_9;
        }
        return this.d;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f;
    }

    public synchronized int getStartDownloadCode() {
        if (this.h == 1) {
            return com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_9;
        }
        return this.e;
    }

    public synchronized void readTbsDownloadInfo(android.content.Context context) {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        try {
            java.io.File fileA = a(this.c, "download_upload");
            try {
                if (fileA == null) {
                    return;
                }
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(fileA));
                try {
                    try {
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(bufferedInputStream);
                        java.lang.String property = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, "");
                        if (!"".equals(property)) {
                            this.d = java.lang.Math.max(java.lang.Integer.parseInt(property), 0);
                        }
                        java.lang.String property2 = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, "");
                        if (!"".equals(property2)) {
                            this.e = java.lang.Math.max(java.lang.Integer.parseInt(property2), 0);
                        }
                        java.lang.String property3 = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, "");
                        if (!"".equals(property3)) {
                            this.f = java.lang.Math.max(java.lang.Integer.parseInt(property3), 0);
                        }
                        java.lang.String property4 = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, "");
                        if (!"".equals(property4)) {
                            this.g = java.lang.Math.max(java.lang.Integer.parseInt(property4), 0);
                        }
                        java.lang.String property5 = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, "");
                        if (!"".equals(property5)) {
                            this.h = java.lang.Math.max(java.lang.Integer.parseInt(property5), 0);
                        }
                        java.lang.String property6 = properties.getProperty(com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, "");
                        if (!"".equals(property6)) {
                            this.i = java.lang.Math.max(java.lang.Integer.parseInt(property6), 0);
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                    }
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

    /* JADX WARN: Code duplicated, block: B:37:0x00ac A[Catch: Exception -> 0x00b0, all -> 0x00cc, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b0, blocks: (B:22:0x0090, B:37:0x00ac), top: B:60:0x0009, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[Catch: all -> 0x00cc, SYNTHETIC, TRY_LEAVE, TryCatch #9 {, blocks: (B:3:0x0001, B:18:0x0088, B:22:0x0090, B:40:0x00b1, B:21:0x008d, B:32:0x00a2, B:37:0x00ac, B:35:0x00a7, B:45:0x00b9, B:50:0x00c3, B:54:0x00cb, B:53:0x00c8, B:48:0x00be, B:30:0x009d), top: B:77:0x0001, inners: #0, #1, #2, #4, #5, #7 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void writeTbsDownloadInfo() {
        java.io.BufferedInputStream bufferedInputStream;
        com.tencent.smtt.utils.TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo #1");
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    java.io.File fileA = a(this.c, "download_upload");
                    if (fileA == null) {
                        return;
                    }
                    bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(fileA));
                    try {
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(bufferedInputStream);
                        for (java.lang.String str : this.f857a.keySet()) {
                            java.lang.Object obj = this.f857a.get(str);
                            properties.setProperty(str, "" + obj);
                            com.tencent.smtt.utils.TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo key is " + str + " value is " + obj);
                        }
                        this.f857a.clear();
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
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
            th.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        } catch (java.lang.Throwable th4) {
            if (bufferedInputStream == null) {
                if (bufferedOutputStream != null) {
                    throw th4;
                }
                bufferedOutputStream.close();
                throw th4;
            }
            try {
                bufferedInputStream.close();
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
            if (bufferedOutputStream != null) {
                throw th4;
            }
            try {
                bufferedOutputStream.close();
                throw th4;
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
                throw th4;
            }
        }
    }
}
