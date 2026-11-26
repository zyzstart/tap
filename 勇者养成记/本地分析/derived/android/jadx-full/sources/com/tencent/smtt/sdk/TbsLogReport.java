package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsLogReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.TbsLogReport f862a;
    private android.os.Handler b;
    private android.content.Context c;
    private boolean d = false;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f866a;

        EventType(int i) {
            this.f866a = i;
        }
    }

    public static class TbsLogInfo implements java.lang.Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f867a;
        private long b;
        private java.lang.String c;
        private java.lang.String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private java.lang.String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private java.lang.String o;
        private java.lang.String p;
        private long q;

        private TbsLogInfo() {
            resetArgs();
        }

        protected java.lang.Object clone() {
            try {
                return super.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0L;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            this.j = 0;
            this.k = 2;
            this.l = 0L;
            this.m = 0L;
            this.n = 1;
            this.f867a = 0;
            this.o = null;
            this.p = null;
            this.q = 0L;
        }

        public void setApn(java.lang.String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(java.lang.String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(java.lang.String str) {
            if (this.c != null) {
                str = this.c + ";" + str;
            }
            this.c = str;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f867a = i;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(java.lang.String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.p = str;
        }

        public void setFailDetail(java.lang.Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            java.lang.String stackTraceString = android.util.Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(java.lang.String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final java.lang.String f868a;
        private final java.lang.String b;

        public a(java.lang.String str, java.lang.String str2) {
            this.f868a = str;
            this.b = str2;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003e -> B:29:0x0041). Please report as a decompilation issue!!! */
        private static void a(java.io.File file) throws java.lang.Throwable {
            java.io.RandomAccessFile randomAccessFile = null;
            java.io.RandomAccessFile randomAccessFile2 = null;
            randomAccessFile = null;
            try {
                try {
                    try {
                        java.io.RandomAccessFile randomAccessFile3 = new java.io.RandomAccessFile(file, "rw");
                        try {
                            int i = java.lang.Integer.parseInt("00001000", 2);
                            randomAccessFile3.seek(7L);
                            int i2 = randomAccessFile3.read();
                            if ((i2 & i) > 0) {
                                randomAccessFile3.seek(7L);
                                randomAccessFile3.write((i ^ (-1)) & 255 & i2);
                            }
                            randomAccessFile3.close();
                            randomAccessFile = i2;
                        } catch (java.lang.Exception e) {
                            e = e;
                            randomAccessFile2 = randomAccessFile3;
                            e.printStackTrace();
                            randomAccessFile = randomAccessFile2;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                                randomAccessFile = randomAccessFile2;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile3;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                }
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
                randomAccessFile = randomAccessFile;
            }
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x00cc: MOVE (r9 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:82:0x00cc */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void a() throws java.lang.Throwable {
            java.lang.Throwable th;
            java.io.FileOutputStream fileOutputStream;
            java.util.zip.ZipOutputStream zipOutputStream;
            java.lang.Exception e;
            java.util.zip.ZipOutputStream zipOutputStream2;
            java.io.FileInputStream fileInputStream;
            java.util.zip.ZipOutputStream zipOutputStream3 = null;
            bufferedInputStream = null;
            bufferedInputStream = null;
            bufferedInputStream = null;
            java.io.BufferedInputStream bufferedInputStream = null;
            zipOutputStream3 = null;
            try {
                try {
                    try {
                        fileOutputStream = new java.io.FileOutputStream(this.b);
                        try {
                            zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(fileOutputStream));
                            try {
                                byte[] bArr = new byte[2048];
                                java.lang.String str = this.f868a;
                                try {
                                    try {
                                        try {
                                            fileInputStream = new java.io.FileInputStream(str);
                                            try {
                                                try {
                                                    java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(fileInputStream, 2048);
                                                    try {
                                                        zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                                        while (true) {
                                                            int i = bufferedInputStream2.read(bArr, 0, 2048);
                                                            if (i == -1) {
                                                                break;
                                                            } else {
                                                                zipOutputStream.write(bArr, 0, i);
                                                            }
                                                        }
                                                        zipOutputStream.flush();
                                                        zipOutputStream.closeEntry();
                                                        try {
                                                            bufferedInputStream2.close();
                                                        } catch (java.io.IOException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    } catch (java.lang.Exception e3) {
                                                        e = e3;
                                                        bufferedInputStream = bufferedInputStream2;
                                                        e.printStackTrace();
                                                        if (bufferedInputStream != null) {
                                                            try {
                                                                bufferedInputStream.close();
                                                            } catch (java.io.IOException e4) {
                                                                e4.printStackTrace();
                                                            }
                                                        }
                                                        if (fileInputStream == null) {
                                                            a(new java.io.File(this.b));
                                                            zipOutputStream.close();
                                                        }
                                                        fileOutputStream.close();
                                                    } catch (java.lang.Throwable th2) {
                                                        th = th2;
                                                        bufferedInputStream = bufferedInputStream2;
                                                        if (bufferedInputStream != null) {
                                                            try {
                                                                bufferedInputStream.close();
                                                            } catch (java.io.IOException e5) {
                                                                e5.printStackTrace();
                                                            }
                                                        }
                                                        if (fileInputStream == null) {
                                                            throw th;
                                                        }
                                                        try {
                                                            fileInputStream.close();
                                                            throw th;
                                                        } catch (java.io.IOException e6) {
                                                            e6.printStackTrace();
                                                            throw th;
                                                        }
                                                    }
                                                } catch (java.lang.Exception e7) {
                                                    e = e7;
                                                }
                                            } catch (java.lang.Throwable th3) {
                                                th = th3;
                                            }
                                        } catch (java.lang.Exception e8) {
                                            e = e8;
                                            fileInputStream = null;
                                        } catch (java.lang.Throwable th4) {
                                            th = th4;
                                            fileInputStream = null;
                                        }
                                        zipOutputStream.close();
                                    } catch (java.io.IOException e9) {
                                        e9.printStackTrace();
                                    }
                                    fileInputStream.close();
                                } catch (java.io.IOException e10) {
                                    e10.printStackTrace();
                                }
                                a(new java.io.File(this.b));
                            } catch (java.lang.Exception e11) {
                                e = e11;
                                e.printStackTrace();
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (java.io.IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    return;
                                }
                            }
                        } catch (java.lang.Exception e13) {
                            zipOutputStream = null;
                            e = e13;
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            if (zipOutputStream3 != null) {
                                try {
                                    zipOutputStream3.close();
                                } catch (java.io.IOException e14) {
                                    e14.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (java.io.IOException e15) {
                                e15.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        zipOutputStream3 = zipOutputStream2;
                    }
                } catch (java.lang.Exception e16) {
                    zipOutputStream = null;
                    e = e16;
                    fileOutputStream = null;
                } catch (java.lang.Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
                fileOutputStream.close();
            } catch (java.io.IOException e17) {
                e17.printStackTrace();
            }
        }
    }

    private TbsLogReport(android.content.Context context) {
        this.b = null;
        this.c = context.getApplicationContext();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new android.os.Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i = message.what;
                if (i != 600) {
                    if (i == 601) {
                        com.tencent.smtt.sdk.TbsLogReport.this.b();
                        return;
                    }
                    return;
                }
                java.lang.Object obj = message.obj;
                if (obj instanceof com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo) {
                    try {
                        int i2 = message.arg1;
                        com.tencent.smtt.sdk.TbsLogReport.this.a(i2, (com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo) obj);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private java.lang.String a(int i) {
        return i + "|";
    }

    private java.lang.String a(long j) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("|");
        return sb.toString();
    }

    private org.json.JSONArray a() {
        java.lang.String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            return new org.json.JSONArray();
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(string);
            if (jSONArray.length() > 5) {
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                int length = jSONArray.length() - 1;
                if (length > jSONArray.length() - 5) {
                    jSONArray2.put(jSONArray.get(length));
                    return jSONArray2;
                }
            }
            return jSONArray;
        } catch (java.lang.Exception unused) {
            return new org.json.JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(a(i));
        sb.append(a(com.tencent.smtt.utils.b.d(this.c)));
        sb.append(a(com.tencent.smtt.utils.l.a(this.c)));
        sb.append(a(com.tencent.smtt.sdk.m.a().i(this.c)));
        java.lang.String str = android.os.Build.MODEL;
        try {
            str = new java.lang.String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (java.lang.Exception unused) {
        }
        sb.append(a(str));
        java.lang.String packageName = this.c.getPackageName();
        sb.append(a(packageName));
        sb.append("com.tencent.mm".equals(packageName) ? a(com.tencent.smtt.utils.b.a(this.c, com.tencent.smtt.sdk.TbsDownloader.TBS_METADATA)) : a(com.tencent.smtt.utils.b.b(this.c)));
        sb.append(a(a(tbsLogInfo.b)));
        sb.append(a(tbsLogInfo.c));
        sb.append(a(tbsLogInfo.d));
        sb.append(a(tbsLogInfo.e));
        sb.append(a(tbsLogInfo.f));
        sb.append(a(tbsLogInfo.g));
        sb.append(a(tbsLogInfo.h));
        sb.append(a(tbsLogInfo.i));
        sb.append(a(tbsLogInfo.j));
        sb.append(a(tbsLogInfo.k));
        sb.append(b(tbsLogInfo.q));
        sb.append(b(tbsLogInfo.l));
        sb.append(b(tbsLogInfo.m));
        sb.append(a(tbsLogInfo.n));
        sb.append(a(tbsLogInfo.f867a));
        sb.append(a(tbsLogInfo.o));
        sb.append(a(tbsLogInfo.p));
        sb.append(a(com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.c).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(com.tencent.smtt.utils.b.g(this.c)));
        sb.append(a("4.3.0.3_43903"));
        sb.append(false);
        android.content.SharedPreferences sharedPreferencesD = d();
        org.json.JSONArray jSONArrayA = a();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 >= 1; i2--) {
                try {
                    jSONArray.put(jSONArrayA.get(jSONArray.length() - i2));
                } catch (java.lang.Exception unused2) {
                    com.tencent.smtt.utils.TbsLog.e("upload", "JSONArray transform error!");
                }
            }
            jSONArrayA = jSONArray;
        }
        jSONArrayA.put(sb.toString());
        android.content.SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
        editorEdit.putString("tbs_download_upload", jSONArrayA.toString());
        editorEdit.commit();
        if (this.d || i != com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_LOAD.f866a) {
            b();
        }
    }

    private void a(int i, com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo, com.tencent.smtt.sdk.TbsLogReport.EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(java.lang.System.currentTimeMillis());
        com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    private java.lang.String b(long j) {
        return j + "|";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        java.lang.String str;
        java.lang.String str2;
        java.util.Map map = com.tencent.smtt.sdk.QbSdk.n;
        if (map != null && map.containsKey(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            str = "upload";
            str2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";
        } else {
            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            org.json.JSONArray jSONArrayA = a();
            if (jSONArrayA != null && jSONArrayA.length() != 0) {
                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + jSONArrayA);
                try {
                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + com.tencent.smtt.utils.g.a(com.tencent.smtt.utils.n.a(this.c).c(), jSONArrayA.toString().getBytes(com.unisound.b.f.b), new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.3
                        @Override // com.tencent.smtt.utils.g.a
                        public void a(int i) {
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                            if (i < 300) {
                                com.tencent.smtt.sdk.TbsLogReport.this.c();
                            }
                        }
                    }, true) + " testcase: -1");
                    return;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            str = com.tencent.smtt.sdk.TbsDownloader.LOGTAG;
            str2 = "[TbsApkDownloadStat.reportDownloadStat] no data";
        }
        com.tencent.smtt.utils.TbsLog.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        android.content.SharedPreferences.Editor editorEdit = d().edit();
        editorEdit.remove("tbs_download_upload");
        editorEdit.commit();
    }

    private android.content.SharedPreferences d() {
        return this.c.getSharedPreferences("tbs_download_stat", 4);
    }

    public static com.tencent.smtt.sdk.TbsLogReport getInstance(android.content.Context context) {
        if (f862a == null) {
            synchronized (com.tencent.smtt.sdk.TbsLogReport.class) {
                if (f862a == null) {
                    f862a = new com.tencent.smtt.sdk.TbsLogReport(context);
                }
            }
        }
        return f862a;
    }

    public void clear() {
        try {
            android.content.SharedPreferences.Editor editorEdit = d().edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CONNECT_TIMEOUT);
    }

    public void eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType eventType, com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo) {
        try {
            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo2 = (com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo) tbsLogInfo.clone();
            android.os.Message messageObtainMessage = this.b.obtainMessage();
            messageObtainMessage.what = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED;
            messageObtainMessage.arg1 = eventType.f866a;
            messageObtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(messageObtainMessage);
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0164  */
    /* JADX WARN: Code duplicated, block: B:78:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reportTbsLog() {
        java.lang.String tbsLogFilePath;
        java.lang.Throwable th;
        java.io.File file;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Exception e;
        java.io.File file2;
        java.io.FileInputStream fileInputStream;
        java.lang.Object obj;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.util.Map map = com.tencent.smtt.sdk.QbSdk.n;
        if (map != null && map.containsKey(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            com.tencent.smtt.utils.TbsLog.i("upload", "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        if (com.tencent.smtt.utils.Apn.getApnType(this.c) == 3 && (tbsLogFilePath = com.tencent.smtt.utils.TbsLog.getTbsLogFilePath()) != null) {
            java.lang.String strB = com.tencent.smtt.utils.h.a().b();
            java.lang.String strD = com.tencent.smtt.utils.b.d(this.c);
            java.lang.String strG = com.tencent.smtt.utils.b.g(this.c);
            byte[] bytes = strD.getBytes();
            byte[] bytes2 = strG.getBytes();
            try {
                bytes = com.tencent.smtt.utils.h.a().a(bytes);
                bytes2 = com.tencent.smtt.utils.h.a().a(bytes2);
            } catch (java.lang.Exception unused) {
            }
            java.lang.String str = com.tencent.smtt.utils.n.a(this.c).e() + com.tencent.smtt.utils.h.b(bytes) + "&aid=" + com.tencent.smtt.utils.h.b(bytes2);
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("Content-Type", "application/octet-stream");
            map2.put("Charset", "UTF-8");
            map2.put("QUA2", com.tencent.smtt.utils.l.a(this.c));
            java.io.FileInputStream fileInputStream2 = null;
            bArrA = null;
            byte[] bArrA = null;
            fileInputStream2 = null;
            try {
                try {
                    new java.io.File(com.tencent.smtt.utils.f.f975a);
                    new com.tencent.smtt.sdk.TbsLogReport.a(tbsLogFilePath, com.tencent.smtt.utils.f.f975a + "/tbslog_temp.zip").a();
                    file2 = new java.io.File(com.tencent.smtt.utils.f.f975a, "tbslog_temp.zip");
                    try {
                        fileInputStream = new java.io.FileInputStream(file2);
                        try {
                            byte[] bArr = new byte[8192];
                            byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int i = fileInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (java.lang.Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream2 != 0) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (java.lang.Exception unused3) {
                                        }
                                    }
                                    if (file2 != null) {
                                    }
                                    com.tencent.smtt.utils.g.a(str + "&ek=" + strB, map2, bArrA, new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                                        @Override // com.tencent.smtt.utils.g.a
                                        public void a(int i2) {
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i2);
                                        }
                                    }, false);
                                }
                            }
                            byteArrayOutputStream2.flush();
                            bArrA = com.tencent.smtt.utils.h.a().a(byteArrayOutputStream2.toByteArray());
                            try {
                                fileInputStream.close();
                            } catch (java.lang.Exception unused4) {
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (java.lang.Exception unused5) {
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            byteArrayOutputStream2 = 0;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            obj = file2;
                            fileInputStream2 = fileInputStream;
                            file = obj;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (java.lang.Exception unused6) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception unused7) {
                                }
                            }
                            if (file != 0) {
                                throw th;
                            }
                            file.delete();
                            throw th;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        fileInputStream = null;
                        file2 = file2;
                        byteArrayOutputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream2 != 0) {
                            byteArrayOutputStream2.close();
                        }
                        if (file2 != null) {
                            file2.delete();
                        }
                        com.tencent.smtt.utils.g.a(str + "&ek=" + strB, map2, bArrA, new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                            @Override // com.tencent.smtt.utils.g.a
                            public void a(int i2) {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i2);
                            }
                        }, false);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        file = file2;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file != 0) {
                            throw th;
                        }
                        file.delete();
                        throw th;
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    obj = tbsLogFilePath;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                file2 = null;
                fileInputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                file = 0;
                byteArrayOutputStream = null;
            }
            file2.delete();
            com.tencent.smtt.utils.g.a(str + "&ek=" + strB, map2, bArrA, new com.tencent.smtt.utils.g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                @Override // com.tencent.smtt.utils.g.a
                public void a(int i2) {
                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i2);
                }
            }, false);
        }
    }

    public void setInstallErrorCode(int i, java.lang.String str) {
        setInstallErrorCode(i, str, com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, java.lang.String str, com.tencent.smtt.sdk.TbsLogReport.EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
    }

    public void setInstallErrorCode(int i, java.lang.Throwable th) {
        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, java.lang.String str) {
        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(java.lang.System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_LOAD, tbsLogInfo);
    }

    public void setLoadErrorCode(int i, java.lang.Throwable th) {
        java.lang.String strSubstring = com.tencent.ysdk.shell.framework.constant.ConstantString.CONSTANT_STRING_NULL_CAPITAL;
        if (th != null) {
            strSubstring = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + android.util.Log.getStackTraceString(th.getCause());
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
        }
        setLoadErrorCode(i, strSubstring);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.d = z;
    }

    public com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo() {
        return new com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo();
    }
}
