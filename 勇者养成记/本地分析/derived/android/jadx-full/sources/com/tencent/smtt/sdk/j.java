package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j {
    private static int d = 5;
    private static int e = 1;
    private static final java.lang.String[] f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private java.util.Set A;
    private boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.lang.String f931a;
    private android.content.Context g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.io.File k;
    private long l;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private java.net.HttpURLConnection t;
    private java.lang.String u;
    private com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo v;
    private java.lang.String w;
    private int x;
    private boolean y;
    private android.os.Handler z;
    private int m = 30000;
    private int n = cn.yunzhisheng.asr.a.b;
    private int B = d;
    java.lang.String[] b = null;
    int c = 0;

    public j(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.v = com.tencent.smtt.sdk.TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.A = new java.util.HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        com.tencent.smtt.sdk.m.a();
        java.io.File fileS = com.tencent.smtt.sdk.m.s(this.g);
        this.k = fileS;
        if (fileS == null) {
            throw new java.lang.NullPointerException("TbsCorePrivateDir is null!");
        }
        e();
        this.w = null;
        this.x = -1;
    }

    private long a(long j, long j2) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.v.setDownConsumeTime(jCurrentTimeMillis - j);
        this.v.setDownloadSize(j2);
        return jCurrentTimeMillis;
    }

    @android.annotation.TargetApi(8)
    static java.io.File a(android.content.Context context) {
        try {
            java.io.File file = android.os.Build.VERSION.SDK_INT >= 8 ? new java.io.File(com.tencent.smtt.utils.f.a(context, 4)) : null;
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private static java.io.File a(android.content.Context context, int i) {
        java.io.File file = new java.io.File(com.tencent.smtt.utils.f.a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new java.io.File(file, com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false)).exists()) {
                return file;
            }
        }
        return null;
    }

    private java.lang.String a(java.lang.Throwable th) {
        java.lang.String stackTraceString = android.util.Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private java.lang.String a(java.net.URL url) {
        try {
            return java.net.InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (java.lang.Error e2) {
            e2.printStackTrace();
            return "";
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    private void a(int i, java.lang.String str, boolean z) {
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
    }

    private void a(long j) {
        this.p++;
        if (j <= 0) {
            try {
                j = l();
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        java.lang.Thread.sleep(j);
    }

    private void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(java.io.File file, android.content.Context context) {
        synchronized (com.tencent.smtt.utils.a.class) {
            if (file != null) {
                if (file.exists()) {
                    try {
                        java.io.File fileA = a(context);
                        if (fileA != null) {
                            java.io.File file2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1 ? new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true)) : new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
                            file2.delete();
                            com.tencent.smtt.utils.f.b(file, file2);
                            boolean zContains = file2.getName().contains("tbs.org");
                            boolean zContains2 = file2.getName().contains("x5.tbs.decouple");
                            if (zContains2 || zContains) {
                                java.io.File[] fileArrListFiles = fileA.listFiles();
                                java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(com.tencent.smtt.utils.a.a(zContains2) + "(.*)");
                                for (java.io.File file3 : fileArrListFiles) {
                                    if (patternCompile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                        file3.delete();
                                    }
                                }
                                java.io.File file4 = new java.io.File(fileA, com.tencent.smtt.utils.a.a(zContains2) + "." + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                if (file4.exists()) {
                                    com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    return;
                                }
                                file4.createNewFile();
                            }
                            if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == com.tencent.smtt.utils.a.a(context, file)) {
                                int i = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                                if (i == 5 || i == 3) {
                                    com.tencent.smtt.utils.TbsLog.i("TbsApkDownloader", "response code=" + i + "return backup decouple apk");
                                }
                                java.io.File file5 = new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
                                if (com.tencent.smtt.utils.a.a(context, file) != com.tencent.smtt.utils.a.a(context, file5)) {
                                    file5.delete();
                                    com.tencent.smtt.utils.f.b(file, file5);
                                }
                            }
                        }
                    } catch (java.lang.Exception unused) {
                    }
                }
            }
        }
    }

    private void a(java.lang.String str) throws java.net.ProtocolException {
        java.net.URL url = new java.net.URL(str);
        java.net.HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) url.openConnection();
        this.t = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", com.tencent.smtt.sdk.TbsDownloader.b(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    private boolean a(java.io.File file) {
        int i = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return com.tencent.smtt.utils.a.a(this.g, file, 0L, i);
    }

    @android.annotation.TargetApi(8)
    static java.io.File b(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 8) {
                return null;
            }
            java.io.File fileA = a(context, 4);
            if (fileA == null) {
                fileA = a(context, 3);
            }
            if (fileA == null) {
                fileA = a(context, 2);
            }
            return fileA == null ? a(context, 1) : fileA;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private boolean b(int i) {
        try {
            java.io.File file = new java.io.File(this.k, "x5.tbs");
            java.io.File fileA = a(this.g);
            if (fileA == null) {
                return false;
            }
            java.io.File file2 = new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
            file.delete();
            com.tencent.smtt.utils.f.b(file2, file);
            if (com.tencent.smtt.utils.a.a(this.g, file, 0L, i)) {
                return true;
            }
            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e2.getMessage());
            return false;
        }
    }

    public static void c(android.content.Context context) {
        try {
            com.tencent.smtt.sdk.m.a();
            java.io.File fileS = com.tencent.smtt.sdk.m.s(context);
            new java.io.File(fileS, "x5.tbs").delete();
            new java.io.File(fileS, "x5.tbs.temp").delete();
            java.io.File fileA = a(context);
            if (fileA != null) {
                new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false)).delete();
                new java.io.File(fileA, "x5.oversea.tbs.org").delete();
                java.io.File[] fileArrListFiles = fileA.listFiles();
                java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(com.tencent.smtt.utils.a.a(true) + "(.*)");
                for (java.io.File file : fileArrListFiles) {
                    if (patternCompile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
                java.util.regex.Pattern patternCompile2 = java.util.regex.Pattern.compile(com.tencent.smtt.utils.a.a(false) + "(.*)");
                for (java.io.File file2 : fileArrListFiles) {
                    if (patternCompile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private void c(boolean z) throws java.lang.Throwable {
        android.os.Bundle bundleA;
        com.tencent.smtt.utils.q.a(this.g);
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, java.lang.Boolean.FALSE);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.FALSE);
        tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        tbsDownloadConfig.commit();
        com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(z ? 100 : 120);
        int i = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean zA = com.tencent.smtt.sdk.TbsDownloader.a(this.g);
        if (i == 5) {
            bundleA = a(i, zA);
            if (bundleA == null) {
                return;
            }
        } else {
            if (i != 3 && i <= 10000) {
                com.tencent.smtt.sdk.m.a().a(this.g, new java.io.File(this.k, "x5.tbs").getAbsolutePath(), tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                a(new java.io.File(this.k, "x5.tbs"), this.g);
                return;
            }
            java.io.File fileA = a(this.g);
            if (fileA == null) {
                c();
                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                tbsDownloadConfig.commit();
                return;
            }
            bundleA = a(i, fileA, zA);
        }
        com.tencent.smtt.sdk.m.a().b(this.g, bundleA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        if (r7 != r5) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.c(boolean, boolean):boolean");
    }

    private boolean d(boolean z) {
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        java.io.File file = z ? new java.io.File(this.k, "x5.tbs") : new java.io.File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            com.tencent.smtt.utils.f.b(file);
        }
        return true;
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1L;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void f() {
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        com.tencent.smtt.sdk.TbsLogReport.EventType eventType;
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        java.net.HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            if (!this.r) {
                this.v.setResolveIp(a(httpURLConnection.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = this.v;
        int i = tbsLogInfo.f867a;
        if (this.r || !this.y) {
            com.tencent.smtt.sdk.TbsDownloader.f858a = false;
            return;
        }
        tbsLogInfo.setEventTime(java.lang.System.currentTimeMillis());
        java.lang.String apnInfo = com.tencent.smtt.utils.Apn.getApnInfo(this.g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = com.tencent.smtt.utils.Apn.getApnType(this.g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (apnType != this.x || !apnInfo.equals(this.w)) {
            this.v.setNetworkChange(0);
        }
        int i2 = this.v.f867a;
        if ((i2 == 0 || i2 == 107) && this.v.getDownFinalFlag() == 0 && (!com.tencent.smtt.utils.Apn.isNetworkAvailable(this.g) || !k())) {
            a(101, (java.lang.String) null, true);
        }
        if (com.tencent.smtt.sdk.TbsDownloader.a(this.g)) {
            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
            eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        } else {
            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
            eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        }
        tbsLogReport.eventReport(eventType, this.v);
        this.v.resetArgs();
        if (i != 100) {
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(i);
        }
    }

    private java.io.File g() {
        return com.tencent.smtt.sdk.TbsDownloader.a(this.g) ? new java.io.File(com.tencent.smtt.utils.f.a(this.g, 4), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true)) : new java.io.File(com.tencent.smtt.utils.f.a(this.g, 4), com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
    }

    private void h() {
        try {
            java.io.File fileG = g();
            if (fileG == null || !fileG.exists()) {
                return;
            }
            com.tencent.smtt.utils.f.b(fileG);
            java.io.File[] fileArrListFiles = fileG.getParentFile().listFiles();
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(com.tencent.smtt.utils.a.a(com.tencent.smtt.sdk.TbsDownloader.a(this.g)) + "(.*)");
            for (java.io.File file : fileArrListFiles) {
                if (patternCompile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                    com.tencent.smtt.utils.f.b(file);
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean i() {
        return new java.io.File(this.k, "x5.tbs.temp").exists();
    }

    private long j() {
        java.io.File file = new java.io.File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean k() {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        java.io.InputStreamReader inputStreamReader;
        java.io.BufferedReader bufferedReader;
        boolean z = false;
        try {
            inputStream = java.lang.Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new java.io.InputStreamReader(inputStream);
                try {
                    bufferedReader = new java.io.BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains("TTL") || line.contains("ttl")) {
                                z = true;
                                break;
                            }
                            i++;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                            } finally {
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                            }
                        }
                    } while (i < 5);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStreamReader = null;
                bufferedReader = null;
                th.printStackTrace();
                return z;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = null;
        }
        return z;
    }

    private long l() {
        int i = this.p;
        switch (i) {
            case 1:
            case 2:
                return ((long) i) * 20000;
            case 3:
            case 4:
                return 100000L;
            default:
                return 200000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:44:0x008c A[EXC_TOP_SPLITTER, PHI: r2 r4
  0x008c: PHI (r2v2 boolean) = (r2v0 boolean), (r2v3 boolean) binds: [B:23:0x008a, B:16:0x0080] A[DONT_GENERATE, DONT_INLINE]
  0x008c: PHI (r4v7 java.net.HttpURLConnection) = (r4v6 java.net.HttpURLConnection), (r4v10 java.net.HttpURLConnection) binds: [B:23:0x008a, B:16:0x0080] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public boolean m() {
        java.lang.String wifiSSID;
        java.net.HttpURLConnection httpURLConnection;
        boolean z = false;
        boolean z2 = com.tencent.smtt.utils.Apn.getApnType(this.g) == 3;
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z2);
        if (z2) {
            wifiSSID = com.tencent.smtt.utils.Apn.getWifiSSID(this.g);
            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.getInputStream();
                    int responseCode = httpURLConnection.getResponseCode();
                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    z = responseCode == 204;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (java.lang.Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } else {
            wifiSSID = null;
        }
        if (!z && !android.text.TextUtils.isEmpty(wifiSSID) && !this.A.contains(wifiSSID)) {
            this.A.add(wifiSSID);
            n();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, wifiSSID), 120000L);
        }
        if (z && this.A.contains(wifiSSID)) {
            this.A.remove(wifiSSID);
        }
        return z;
    }

    private void n() {
        if (this.z == null) {
            this.z = new android.os.Handler(com.tencent.smtt.sdk.l.a().getLooper()) { // from class: com.tencent.smtt.sdk.j.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    if (message.what == 150) {
                        com.tencent.smtt.sdk.j.this.m();
                    }
                }
            };
        }
    }

    public android.os.Bundle a(int i, java.io.File file, boolean z) {
        java.io.File file2;
        if (z) {
            file2 = new java.io.File(file, com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new java.io.File(file, com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
        }
        int iA = com.tencent.smtt.utils.a.a(this.g, file2);
        java.io.File file3 = new java.io.File(this.k, "x5.tbs");
        java.lang.String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", iA);
        bundle.putInt("new_core_ver", i2);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    public android.os.Bundle a(int i, boolean z) throws java.lang.Throwable {
        java.io.File fileQ;
        int i2;
        com.tencent.smtt.sdk.m mVarA;
        android.content.Context context;
        int i3;
        if (z) {
            fileQ = com.tencent.smtt.sdk.m.a().p(this.g);
            i2 = com.tencent.smtt.sdk.m.a().h(this.g);
        } else {
            fileQ = com.tencent.smtt.sdk.m.a().q(this.g);
            i2 = com.tencent.smtt.sdk.m.a().i(this.g);
        }
        java.io.File file = new java.io.File(this.k, "x5.tbs");
        java.lang.String absolutePath = file.exists() ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            return null;
        }
        int i4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (z) {
            mVarA = com.tencent.smtt.sdk.m.a();
            context = this.g;
            i3 = 6;
        } else {
            mVarA = com.tencent.smtt.sdk.m.a();
            context = this.g;
            i3 = 5;
        }
        java.io.File fileF = mVarA.f(context, i3);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", i2);
        bundle.putInt("new_core_ver", i4);
        bundle.putString("old_apk_location", fileQ.getAbsolutePath());
        bundle.putString("new_apk_location", fileF.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        java.lang.String strA = com.tencent.smtt.utils.f.a(this.g, 7);
        java.io.File file2 = new java.io.File(strA);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        bundle.putString("backup_apk", new java.io.File(strA, i4 + ".tbs").getAbsolutePath());
        return bundle;
    }

    public void a(int i) {
        if (com.tencent.smtt.sdk.m.a().t(this.g)) {
            com.tencent.smtt.sdk.m.a().b();
            try {
                java.io.File file = new java.io.File(this.k, "x5.tbs");
                int iA = com.tencent.smtt.utils.a.a(this.g, file);
                if (-1 == iA || (i > 0 && i == iA)) {
                    com.tencent.smtt.utils.f.b(file);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public boolean a() {
        com.tencent.smtt.utils.TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            java.io.File file = new java.io.File(com.tencent.smtt.utils.f.a(this.g, 4), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                com.tencent.smtt.utils.TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                java.io.File fileB = com.tencent.smtt.sdk.TbsDownloader.b(com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (fileB != null && fileB.exists()) {
                    com.tencent.smtt.utils.f.b(fileB, file);
                }
            }
            if (!com.tencent.smtt.utils.a.a(this.g, file, 0L, com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                return false;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            return com.tencent.smtt.sdk.m.a().e(this.g);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public boolean a(boolean z) {
        java.lang.String[] strArr;
        int i;
        if ((z && !m() && (!com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi() || !com.tencent.smtt.utils.Apn.isNetworkAvailable(this.g))) || (strArr = this.b) == null || (i = this.c) < 0 || i >= strArr.length) {
            return false;
        }
        this.c = i + 1;
        this.j = strArr[i];
        this.p = 0;
        this.q = 0;
        this.l = -1L;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    public boolean a(boolean z, boolean z2) throws java.lang.Throwable {
        java.lang.String str;
        boolean z3;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        com.tencent.smtt.sdk.TbsLogReport.EventType eventType;
        if (android.os.Build.VERSION.SDK_INT == 23) {
            return false;
        }
        int i = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int i2 = com.tencent.smtt.sdk.m.a().i(this.g);
        if (i == 0) {
            i = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            str = "by default key";
        } else {
            str = "by new key";
        }
        this.f931a = str;
        if (i != 0 && i != i2) {
            if (z2) {
                java.io.File fileA = com.tencent.smtt.sdk.TbsDownloader.a(i);
                if (fileA == null || !fileA.exists()) {
                    z3 = false;
                } else {
                    java.io.File file = new java.io.File(com.tencent.smtt.utils.f.a(this.g, 4), com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
                    try {
                        if (com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                            com.tencent.smtt.utils.f.b(fileA, file);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                java.io.File fileG = g();
                if (fileG == null || !fileG.exists() || !a(fileG)) {
                    h();
                    if (fileA != null && fileA.exists() && !com.tencent.smtt.utils.a.a(this.g, fileA, 0L, i) && fileA != null && fileA.exists()) {
                        com.tencent.smtt.utils.f.b(fileA);
                    }
                } else if (b(i)) {
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                    c(false);
                    if (z3) {
                        a(100, "use local backup apk in startDownload" + this.f931a, true);
                        if (com.tencent.smtt.sdk.TbsDownloader.a(this.g)) {
                            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
                            eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
                        } else {
                            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
                            eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
                        }
                        tbsLogReport.eventReport(eventType, this.v);
                        this.v.resetArgs();
                    }
                    return true;
                }
            }
            if (c(false, z2)) {
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                c(false);
                return true;
            }
            if (!d(true) && !d(true)) {
                com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CLEAR_CACHE);
            }
        }
        return false;
    }

    public int b(boolean z) {
        java.io.File fileA = a(this.g);
        if (z) {
            if (fileA == null) {
                return 0;
            }
            return com.tencent.smtt.utils.a.a(this.g, new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true)));
        }
        if (fileA == null) {
            return 0;
        }
        android.content.Context context = this.g;
        return com.tencent.smtt.utils.a.a(context, new java.io.File(fileA, com.tencent.smtt.sdk.TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false)));
    }

    public void b() {
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        com.tencent.smtt.sdk.TbsLogReport.EventType eventType;
        this.r = true;
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(this.g)) {
            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new java.lang.Exception());
            if (com.tencent.smtt.sdk.TbsDownloader.a(this.g)) {
                tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
                eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
            } else {
                tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(this.g);
                eventType = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
            }
            tbsLogReport.eventReport(eventType, tbsLogInfo);
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:113:0x0319  */
    /* JADX WARN: Code duplicated, block: B:116:0x0325  */
    /* JADX WARN: Code duplicated, block: B:117:0x0327  */
    /* JADX WARN: Code duplicated, block: B:124:0x0343 A[Catch: all -> 0x09b7, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x09b7, blocks: (B:114:0x031d, B:118:0x0328, B:129:0x0357, B:130:0x0359, B:136:0x0367, B:138:0x036f, B:153:0x03bf, B:241:0x0507, B:243:0x0513, B:272:0x05e8, B:124:0x0343, B:128:0x034f), top: B:529:0x031d }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0347 A[Catch: all -> 0x030e, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x035e A[Catch: all -> 0x030e, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x038d A[Catch: all -> 0x030e, TRY_ENTER, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x03b2 A[Catch: all -> 0x030e, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:158:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:160:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:165:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:181:0x0436  */
    /* JADX WARN: Code duplicated, block: B:182:0x0439  */
    /* JADX WARN: Code duplicated, block: B:188:0x0456  */
    /* JADX WARN: Code duplicated, block: B:189:0x0458  */
    /* JADX WARN: Code duplicated, block: B:191:0x045c  */
    /* JADX WARN: Code duplicated, block: B:193:0x0460 A[Catch: all -> 0x030e, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x0475  */
    /* JADX WARN: Code duplicated, block: B:241:0x0507 A[Catch: all -> 0x09b7, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x09b7, blocks: (B:114:0x031d, B:118:0x0328, B:129:0x0357, B:130:0x0359, B:136:0x0367, B:138:0x036f, B:153:0x03bf, B:241:0x0507, B:243:0x0513, B:272:0x05e8, B:124:0x0343, B:128:0x034f), top: B:529:0x031d }] */
    /* JADX WARN: Code duplicated, block: B:246:0x0544 A[Catch: all -> 0x030e, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x030e, blocks: (B:94:0x0295, B:98:0x029d, B:100:0x02b6, B:101:0x02c8, B:107:0x030a, B:120:0x033b, B:122:0x0340, B:133:0x035e, B:135:0x0362, B:141:0x038d, B:143:0x0395, B:145:0x039d, B:147:0x03a5, B:149:0x03ab, B:151:0x03b2, B:152:0x03b7, B:155:0x03c3, B:167:0x03e4, B:169:0x03f2, B:172:0x03fe, B:175:0x0414, B:177:0x0422, B:186:0x0446, B:202:0x047f, B:206:0x0489, B:208:0x049c, B:213:0x04af, B:222:0x04c3, B:224:0x04cc, B:229:0x04df, B:231:0x04e9, B:235:0x04f1, B:238:0x04f8, B:193:0x0460, B:195:0x0468, B:246:0x0544, B:250:0x054c, B:252:0x056d, B:254:0x0573, B:256:0x0579, B:258:0x0581, B:260:0x0585, B:267:0x05a1, B:268:0x05ce, B:126:0x0347, B:104:0x02cf, B:106:0x02f2), top: B:537:0x0295 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x05e5 A[PHI: r12
  0x05e5: PHI (r12v3 boolean) = 
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v57 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
 binds: [B:568:0x05e5, B:54:0x0175, B:156:0x03ce, B:269:0x05e1, B:187:0x0454, B:196:0x0473, B:239:0x0503, B:225:0x04d7, B:209:0x04a7, B:173:0x0410, B:479:0x0a2c, B:69:0x020a, B:74:0x022e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:279:0x0607 A[Catch: all -> 0x060d, IOException -> 0x0615, TryCatch #28 {IOException -> 0x0615, all -> 0x060d, blocks: (B:277:0x05ff, B:279:0x0607, B:285:0x061f, B:287:0x0627), top: B:558:0x05ff }] */
    /* JADX WARN: Code duplicated, block: B:284:0x061d  */
    /* JADX WARN: Code duplicated, block: B:285:0x061f A[Catch: all -> 0x060d, IOException -> 0x0615, TryCatch #28 {IOException -> 0x0615, all -> 0x060d, blocks: (B:277:0x05ff, B:279:0x0607, B:285:0x061f, B:287:0x0627), top: B:558:0x05ff }] */
    /* JADX WARN: Code duplicated, block: B:289:0x0633  */
    /* JADX WARN: Code duplicated, block: B:301:0x0682  */
    /* JADX WARN: Code duplicated, block: B:306:0x0691 A[Catch: all -> 0x06c8, IOException -> 0x06d0, TryCatch #27 {IOException -> 0x06d0, all -> 0x06c8, blocks: (B:304:0x068d, B:306:0x0691, B:309:0x069a, B:313:0x06a6, B:314:0x06b1), top: B:560:0x068d }] */
    /* JADX WARN: Code duplicated, block: B:316:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:317:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:326:0x06d7 A[Catch: all -> 0x0868, IOException -> 0x086e, TRY_ENTER, TRY_LEAVE, TryCatch #32 {IOException -> 0x086e, all -> 0x0868, blocks: (B:302:0x0687, B:326:0x06d7), top: B:550:0x0687 }] */
    /* JADX WARN: Code duplicated, block: B:328:0x06df  */
    /* JADX WARN: Code duplicated, block: B:336:0x0728  */
    /* JADX WARN: Code duplicated, block: B:345:0x0781  */
    /* JADX WARN: Code duplicated, block: B:350:0x079b  */
    /* JADX WARN: Code duplicated, block: B:353:0x07c2 A[Catch: all -> 0x0779, IOException -> 0x077d, TRY_LEAVE, TryCatch #30 {IOException -> 0x077d, all -> 0x0779, blocks: (B:337:0x072e, B:339:0x0736, B:351:0x079d, B:353:0x07c2, B:355:0x07d2, B:357:0x07d9, B:359:0x07e2, B:361:0x07ea, B:363:0x07f3, B:365:0x07fb, B:367:0x0801, B:369:0x0808, B:370:0x080f), top: B:554:0x072e }] */
    /* JADX WARN: Code duplicated, block: B:357:0x07d9 A[Catch: all -> 0x0779, IOException -> 0x077d, TryCatch #30 {IOException -> 0x077d, all -> 0x0779, blocks: (B:337:0x072e, B:339:0x0736, B:351:0x079d, B:353:0x07c2, B:355:0x07d2, B:357:0x07d9, B:359:0x07e2, B:361:0x07ea, B:363:0x07f3, B:365:0x07fb, B:367:0x0801, B:369:0x0808, B:370:0x080f), top: B:554:0x072e }] */
    /* JADX WARN: Code duplicated, block: B:381:0x0848  */
    /* JADX WARN: Code duplicated, block: B:383:0x0852  */
    /* JADX WARN: Code duplicated, block: B:411:0x08bc A[Catch: all -> 0x08cb, TRY_LEAVE, TryCatch #19 {all -> 0x08cb, blocks: (B:409:0x08af, B:411:0x08bc), top: B:535:0x08af }] */
    /* JADX WARN: Code duplicated, block: B:424:0x08ed A[Catch: all -> 0x099d, TryCatch #32 {all -> 0x099d, blocks: (B:422:0x08e6, B:424:0x08ed, B:428:0x08f5, B:430:0x08fd, B:436:0x094a, B:439:0x0955, B:441:0x095e, B:446:0x0970), top: B:544:0x08e6 }] */
    /* JADX WARN: Code duplicated, block: B:445:0x096d  */
    /* JADX WARN: Code duplicated, block: B:469:0x09cc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:476:0x0a0a A[Catch: all -> 0x0b17, TryCatch #27 {all -> 0x0b17, blocks: (B:467:0x09c8, B:470:0x09ce, B:472:0x09d2, B:475:0x09db, B:514:0x0aeb, B:476:0x0a0a, B:478:0x0a21), top: B:540:0x09c8 }] */
    /* JADX WARN: Code duplicated, block: B:480:0x0a2e A[PHI: r7 r12
  0x0a2e: PHI (r7v80 long) = (r7v77 long), (r7v19 long), (r7v81 long) binds: [B:479:0x0a2c, B:70:0x020c, B:74:0x022e] A[DONT_GENERATE, DONT_INLINE]
  0x0a2e: PHI (r12v60 boolean) = (r12v69 boolean), (r12v70 boolean), (r12v71 boolean) binds: [B:479:0x0a2c, B:70:0x020c, B:74:0x022e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:481:0x0a30 A[PHI: r12 r23
  0x0a30: PHI (r12v59 boolean) = 
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v2 boolean)
  (r12v60 boolean)
 binds: [B:157:0x03d0, B:269:0x05e1, B:188:0x0456, B:197:0x0475, B:239:0x0503, B:226:0x04d9, B:210:0x04a9, B:174:0x0412, B:480:0x0a2e] A[DONT_GENERATE, DONT_INLINE]
  0x0a30: PHI (r23v31 long) = 
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v3 long)
  (r23v32 long)
 binds: [B:157:0x03d0, B:269:0x05e1, B:188:0x0456, B:197:0x0475, B:239:0x0503, B:226:0x04d9, B:210:0x04a9, B:174:0x0412, B:480:0x0a2e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:482:0x0a31 A[PHI: r6 r23
  0x0a31: PHI (r6v110 boolean) = (r6v57 boolean), (r6v60 boolean), (r6v96 boolean), (r6v111 boolean) binds: [B:433:0x0940, B:412:0x08c7, B:181:0x0436, B:481:0x0a30] A[DONT_GENERATE, DONT_INLINE]
  0x0a31: PHI (r23v30 long) = (r23v8 long), (r23v11 long), (r23v3 long), (r23v31 long) binds: [B:433:0x0940, B:412:0x08c7, B:181:0x0436, B:481:0x0a30] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:485:0x0a4f  */
    /* JADX WARN: Code duplicated, block: B:487:0x0a53  */
    /* JADX WARN: Code duplicated, block: B:489:0x0a57 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:493:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:495:0x0a69  */
    /* JADX WARN: Code duplicated, block: B:496:0x0a6b  */
    /* JADX WARN: Code duplicated, block: B:497:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:500:0x0a75  */
    /* JADX WARN: Code duplicated, block: B:501:0x0a8c  */
    /* JADX WARN: Code duplicated, block: B:502:0x0a9c A[PHI: r6
  0x0a9c: PHI (r6v3 boolean) = (r6v119 boolean), (r6v120 boolean) binds: [B:486:0x0a51, B:500:0x0a75] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:505:0x0aa5  */
    /* JADX WARN: Code duplicated, block: B:506:0x0abb  */
    /* JADX WARN: Code duplicated, block: B:508:0x0ad6  */
    /* JADX WARN: Code duplicated, block: B:512:0x0ae8  */
    /* JADX WARN: Code duplicated, block: B:516:0x0af8 A[PHI: r7 r9 r12 r13
  0x0af8: PHI (r7v76 long) = (r7v64 long), (r7v77 long) binds: [B:264:0x0590, B:515:0x0af6] A[DONT_GENERATE, DONT_INLINE]
  0x0af8: PHI (r9v46 java.lang.String) = (r9v28 java.lang.String), (r9v48 java.lang.String) binds: [B:264:0x0590, B:515:0x0af6] A[DONT_GENERATE, DONT_INLINE]
  0x0af8: PHI (r12v56 boolean) = (r12v77 boolean), (r12v78 boolean) binds: [B:264:0x0590, B:515:0x0af6] A[DONT_GENERATE, DONT_INLINE]
  0x0af8: PHI (r13v34 long) = (r13v29 long), (r13v36 long) binds: [B:264:0x0590, B:515:0x0af6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:526:0x0825 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x0429 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x0238 A[EXC_TOP_SPLITTER, PHI: r7
  0x0238: PHI (r7v21 long) = (r7v19 long), (r7v81 long) binds: [B:56:0x018d, B:72:0x0214] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x0655 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:0x05ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:0x068d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x06e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:0x05f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:0x0445 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x0992 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x08c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0992 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x0a21 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0422 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x08a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x083a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x098c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x098c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0736 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x023e A[Catch: all -> 0x0232, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0232, blocks: (B:57:0x018f, B:59:0x01a6, B:61:0x01b7, B:63:0x01c8, B:71:0x020e, B:73:0x0216, B:66:0x01dc, B:68:0x01f4, B:81:0x023e, B:87:0x026b), top: B:528:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0241 A[Catch: all -> 0x09c0, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x09c0, blocks: (B:79:0x0238, B:85:0x0245, B:88:0x0270, B:83:0x0241), top: B:533:0x0238 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x026b A[Catch: all -> 0x0232, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0232, blocks: (B:57:0x018f, B:59:0x01a6, B:61:0x01b7, B:63:0x01c8, B:71:0x020e, B:73:0x0216, B:66:0x01dc, B:68:0x01f4, B:81:0x023e, B:87:0x026b), top: B:528:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:97:0x029b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo] */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.tencent.smtt.sdk.j] */
    /* JADX WARN: Type inference failed for: r6v117 */
    /* JADX WARN: Type inference failed for: r6v118 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        int i;
        ?? r6;
        com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig;
        int i2;
        boolean zC;
        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo;
        int i3;
        java.lang.Throwable th;
        java.lang.String str;
        long j;
        long j2;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.String str2;
        java.lang.StringBuilder sb;
        boolean z5;
        int i4;
        int apnType;
        java.lang.String apnInfo;
        int responseCode;
        long j3;
        java.lang.Throwable th2;
        java.io.InputStream inputStream;
        java.io.IOException iOException;
        java.io.FileOutputStream fileOutputStream;
        java.io.InputStream inputStream2;
        java.io.FileOutputStream fileOutputStream2;
        boolean z6;
        boolean z7;
        java.io.InputStream inputStream3;
        boolean z8;
        boolean z9;
        java.lang.Throwable th3;
        boolean z10;
        boolean z11;
        java.lang.String contentEncoding;
        java.io.InputStream gZIPInputStream;
        byte[] bArr;
        boolean z12;
        long jCurrentTimeMillis;
        long j4;
        long j5;
        boolean z13;
        boolean z14;
        boolean z15;
        int i5;
        boolean z16;
        long jCurrentTimeMillis2;
        long j6;
        long j7;
        boolean z17;
        if (com.tencent.smtt.sdk.m.a().c(this.g) && !z) {
            com.tencent.smtt.sdk.TbsDownloader.f858a = false;
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-322);
            return;
        }
        int i6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean z18 = true;
        boolean z19 = i6 == 1 || i6 == 2 || i6 == 4;
        if (!z2 && a(z, z19)) {
            com.tencent.smtt.sdk.TbsDownloader.f858a = false;
            return;
        }
        this.C = z;
        java.lang.String str3 = null;
        this.h = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null);
        java.lang.String string = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "backupUrlStrings:" + string, true);
        this.b = null;
        this.c = 0;
        if (!z && string != null && !"".equals(string.trim())) {
            this.b = string.trim().split(";");
        }
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.h + " backupUrlStrings=" + string + " mLocation=" + this.j + " mCanceled=" + this.r + " mHttpRequest=" + this.t);
        if (this.h == null && this.j == null) {
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-302);
            return;
        }
        if (this.t != null && !this.r) {
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-303);
            return;
        }
        if (!z && this.A.contains(com.tencent.smtt.utils.Apn.getWifiSSID(this.g))) {
            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] WIFI Unavailable");
            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(110);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
            return;
        }
        e();
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
        long downloadMaxflow = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).getDownloadMaxflow();
        long j8 = 0;
        long j9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
        this.B = z ? e : d;
        long j10 = j9;
        boolean z20 = false;
        while (true) {
            if (this.p <= this.B) {
                if (this.q <= 8) {
                    long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
                    if (z) {
                        this.y = z18;
                        if (this.j != null) {
                            str = this.j;
                        } else {
                            str = this.h;
                        }
                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "try url:" + str + ",mRetryTimes:" + this.p, z18);
                        if (!str.equals(this.i)) {
                            this.v.setDownloadUrl(str);
                        }
                        this.i = str;
                        a(str);
                        if (this.o) {
                            j2 = j10;
                            j = 0;
                        } else {
                            j = j();
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=" + j);
                            j2 = j10;
                            if (this.l <= j8) {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current" + j, true);
                                httpURLConnection = this.t;
                                str2 = "Range";
                                sb = new java.lang.StringBuilder();
                                sb.append("bytes=");
                                sb.append(j);
                                sb.append("-");
                            } else {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + j + "/" + this.l, true);
                                httpURLConnection = this.t;
                                str2 = "Range";
                                sb = new java.lang.StringBuilder();
                                sb.append("bytes=");
                                sb.append(j);
                                sb.append("-");
                                sb.append(this.l);
                            }
                            httpURLConnection.setRequestProperty(str2, sb.toString());
                        }
                        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo2 = this.v;
                        if (j == 0) {
                            i4 = 0;
                        } else {
                            i4 = 1;
                        }
                        tbsLogInfo2.setDownloadCancel(i4);
                        apnType = com.tencent.smtt.utils.Apn.getApnType(this.g);
                        apnInfo = com.tencent.smtt.utils.Apn.getApnInfo(this.g);
                        if (this.w == null) {
                            if (apnType == this.x) {
                            }
                            this.v.setNetworkChange(0);
                            this.w = apnInfo;
                            this.x = apnType;
                        } else {
                            if (apnType == this.x) {
                            }
                            this.v.setNetworkChange(0);
                            this.w = apnInfo;
                            this.x = apnType;
                        }
                        if (this.p >= 1) {
                            this.t.addRequestProperty("Referer", this.h);
                        }
                        responseCode = this.t.getResponseCode();
                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                        this.v.setHttpCode(responseCode);
                        if (!z) {
                            b();
                            if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(111);
                            }
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                        }
                        if (this.r) {
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                            if (!z) {
                                z3 = z20;
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                            }
                        } else if (responseCode == 200) {
                            this.l = ((long) this.t.getContentLength()) + j;
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                            this.v.setPkgSize(this.l);
                            j3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                            if (j3 != 0) {
                            }
                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                            inputStream = this.t.getInputStream();
                            if (inputStream != null) {
                                contentEncoding = this.t.getContentEncoding();
                                if (contentEncoding != null) {
                                    if (contentEncoding.contains("gzip")) {
                                        gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream);
                                    } else if (contentEncoding == null) {
                                        gZIPInputStream = inputStream;
                                    } else {
                                        gZIPInputStream = inputStream;
                                    }
                                } else if (contentEncoding == null) {
                                    gZIPInputStream = inputStream;
                                } else {
                                    gZIPInputStream = inputStream;
                                }
                                bArr = new byte[8192];
                                fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(this.k, "x5.tbs.temp"), true);
                                jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                long j11 = j;
                                j4 = jCurrentTimeMillis3;
                                j5 = j11;
                                z20 = z20;
                                while (true) {
                                    if (this.r) {
                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                        z13 = z20;
                                        z9 = z13;
                                        z14 = false;
                                        inputStream2 = gZIPInputStream;
                                    } else {
                                        z9 = z20 ? 1 : 0;
                                        i5 = gZIPInputStream.read(bArr, 0, 8192);
                                        if (i5 <= 0) {
                                            if (this.b != null) {
                                            }
                                            this.s = true;
                                            if (this.b != null) {
                                                z16 = true;
                                            } else {
                                                z16 = z9 ? 1 : 0;
                                            }
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-311);
                                            z13 = z16;
                                            z9 = z13;
                                            z14 = false;
                                            inputStream2 = gZIPInputStream;
                                        } else {
                                            fileOutputStream2.write(bArr, 0, i5);
                                            fileOutputStream2.flush();
                                            if (z) {
                                                inputStream2 = gZIPInputStream;
                                            } else {
                                                inputStream2 = gZIPInputStream;
                                                j7 = j2 + ((long) i5);
                                                if (j7 >= downloadMaxflow) {
                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                    a(112, "downloadFlow=" + j7 + " downloadMaxflow=" + downloadMaxflow, true);
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                                    j2 = j7;
                                                } else {
                                                    j2 = j7;
                                                    if (!com.tencent.smtt.utils.f.b(this.g)) {
                                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                        a(105, "freespace=" + com.tencent.smtt.utils.q.a() + ",and minFreeSpace=" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                    }
                                                }
                                                z14 = false;
                                                z9 = z9;
                                            }
                                            long j12 = i5;
                                            long jA = a(j4, j12);
                                            jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                                            j6 = j5 + j12;
                                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000) {
                                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j6 + "/" + this.l, true);
                                                if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                    double d2 = j6;
                                                    double d3 = this.l;
                                                    java.lang.Double.isNaN(d2);
                                                    java.lang.Double.isNaN(d3);
                                                    com.tencent.smtt.sdk.QbSdk.m.onDownloadProgress((int) ((d2 / d3) * 100.0d));
                                                }
                                                if (z) {
                                                }
                                                jCurrentTimeMillis = jCurrentTimeMillis2;
                                            }
                                            j4 = jA;
                                            j5 = j6;
                                            gZIPInputStream = inputStream2;
                                            z20 = z9 ? 1 : 0;
                                            bArr = bArr;
                                        }
                                    }
                                    if (z14) {
                                        a(fileOutputStream2);
                                        a(inputStream2);
                                        a(inputStream);
                                        if (z) {
                                            j10 = j2;
                                            z20 = z9;
                                            z18 = true;
                                            str3 = null;
                                            j8 = 0;
                                        } else {
                                            j10 = j2;
                                            z11 = z9;
                                            str3 = null;
                                            j8 = 0;
                                            z17 = z11;
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                            z20 = z17;
                                            z18 = true;
                                        }
                                    } else {
                                        z3 = z9 ? 1 : 0;
                                    }
                                }
                            } else {
                                z3 = z20 ? 1 : 0 ? 1 : 0;
                                fileOutputStream2 = null;
                                inputStream2 = null;
                            }
                            a(fileOutputStream2);
                            a(inputStream2);
                            a(inputStream);
                            if (!this.s) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                            }
                            if (!z) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                            }
                        } else {
                            if (responseCode >= 300) {
                            }
                            a(102, java.lang.String.valueOf(responseCode), false);
                            if (responseCode == 416) {
                                if (c(true, z19)) {
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                    if (z) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else {
                                    d(false);
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                    if (!z) {
                                        z3 = z20;
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                }
                            } else if (responseCode != 403) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                if (!z) {
                                    z3 = z20;
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } else {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                if (!z) {
                                    z3 = z20;
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        }
                    } else {
                        try {
                            if (jCurrentTimeMillis3 - com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, j8) > 86400000) {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, java.lang.Long.valueOf(jCurrentTimeMillis3));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j8));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                j10 = j8;
                            } else {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=" + j10);
                                if (j10 >= downloadMaxflow) {
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", z18);
                                    a(112, null, z18);
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                    if (!z) {
                                        z20 = z20;
                                        j2 = j10;
                                        z3 = z20;
                                    }
                                }
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                            }
                            if (com.tencent.smtt.utils.f.b(this.g)) {
                                try {
                                    this.y = z18;
                                    if (this.j != null) {
                                        str = this.j;
                                    } else {
                                        str = this.h;
                                    }
                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "try url:" + str + ",mRetryTimes:" + this.p, z18);
                                    if (!str.equals(this.i)) {
                                        this.v.setDownloadUrl(str);
                                    }
                                    this.i = str;
                                    a(str);
                                    if (this.o) {
                                        try {
                                            j = j();
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=" + j);
                                            j2 = j10;
                                            try {
                                                if (this.l <= j8) {
                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current" + j, true);
                                                    httpURLConnection = this.t;
                                                    str2 = "Range";
                                                    sb = new java.lang.StringBuilder();
                                                    sb.append("bytes=");
                                                    sb.append(j);
                                                    sb.append("-");
                                                } else {
                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + j + "/" + this.l, true);
                                                    httpURLConnection = this.t;
                                                    str2 = "Range";
                                                    sb = new java.lang.StringBuilder();
                                                    sb.append("bytes=");
                                                    sb.append(j);
                                                    sb.append("-");
                                                    sb.append(this.l);
                                                }
                                                httpURLConnection.setRequestProperty(str2, sb.toString());
                                            } catch (java.lang.Throwable th4) {
                                                th = th4;
                                                j10 = j2;
                                                z15 = z20;
                                                z20 = z15;
                                                try {
                                                    if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                        str3 = null;
                                                        th.printStackTrace();
                                                        j8 = 0;
                                                        a(0L);
                                                        a(107, a(th), false);
                                                        if (this.r) {
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                            z20 = z20;
                                                            if (z) {
                                                                z3 = z20;
                                                            } else {
                                                                j2 = j10;
                                                                z3 = z20;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                            if (!this.r) {
                                                                if (this.s) {
                                                                    if (this.b == null) {
                                                                        zC = c(true, z19);
                                                                    }
                                                                    z4 = z3;
                                                                    zC = z3;
                                                                    zC = z3;
                                                                    this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                    if (z19) {
                                                                        tbsLogInfo = this.v;
                                                                        i3 = 0;
                                                                    } else {
                                                                        tbsLogInfo = this.v;
                                                                        if (zC) {
                                                                            i3 = 1;
                                                                        } else {
                                                                            i3 = 2;
                                                                        }
                                                                    }
                                                                    tbsLogInfo.setPatchUpdateFlag(i3);
                                                                    if (zC) {
                                                                        c(true);
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                        a(100, com.unisound.common.y.J, true);
                                                                        z4 = zC;
                                                                        z4 = z3;
                                                                        i = 0;
                                                                        r6 = z4;
                                                                    } else {
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                        i = 0;
                                                                        d(false);
                                                                        r6 = zC;
                                                                    }
                                                                } else {
                                                                    z4 = z3;
                                                                    i = 0;
                                                                    r6 = z4;
                                                                }
                                                                tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                if (r6 != 0) {
                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                } else {
                                                                    i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                    if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                        this.v.setDownloadCancel(2);
                                                                    }
                                                                }
                                                                tbsDownloadConfig.commit();
                                                                this.v.setDownFinalFlag(r6);
                                                            }
                                                            f();
                                                            return;
                                                        }
                                                    } else {
                                                        str3 = null;
                                                        th.printStackTrace();
                                                        j8 = 0;
                                                        a(0L);
                                                        a(107, a(th), false);
                                                        if (this.r) {
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                            z20 = z20;
                                                            if (z) {
                                                                j2 = j10;
                                                                z3 = z20;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            } else {
                                                                z3 = z20;
                                                            }
                                                            if (!this.r) {
                                                                if (this.s) {
                                                                    z4 = z3;
                                                                    i = 0;
                                                                    r6 = z4;
                                                                } else {
                                                                    if (this.b == null) {
                                                                        zC = c(true, z19);
                                                                    }
                                                                    z4 = z3;
                                                                    zC = z3;
                                                                    zC = z3;
                                                                    this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                    if (z19) {
                                                                        tbsLogInfo = this.v;
                                                                        if (zC) {
                                                                            i3 = 1;
                                                                        } else {
                                                                            i3 = 2;
                                                                        }
                                                                    } else {
                                                                        tbsLogInfo = this.v;
                                                                        i3 = 0;
                                                                    }
                                                                    tbsLogInfo.setPatchUpdateFlag(i3);
                                                                    if (zC) {
                                                                        c(true);
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                        a(100, com.unisound.common.y.J, true);
                                                                        z4 = zC;
                                                                        z4 = z3;
                                                                        i = 0;
                                                                        r6 = z4;
                                                                    } else {
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                        i = 0;
                                                                        d(false);
                                                                        r6 = zC;
                                                                    }
                                                                }
                                                                tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                if (r6 != 0) {
                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                } else {
                                                                    i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                    if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                        this.v.setDownloadCancel(2);
                                                                    }
                                                                }
                                                                tbsDownloadConfig.commit();
                                                                this.v.setDownFinalFlag(r6);
                                                            }
                                                            f();
                                                            return;
                                                        }
                                                    }
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                    z17 = z20;
                                                    z20 = z20;
                                                    if (!z) {
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                        z20 = z17;
                                                    }
                                                    z18 = true;
                                                } catch (java.lang.Throwable th5) {
                                                    if (z) {
                                                        throw th5;
                                                    }
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    throw th5;
                                                }
                                            }
                                        } catch (java.lang.Throwable th6) {
                                            th = th6;
                                            th = th;
                                            z15 = z20;
                                            z20 = z15;
                                            if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                str3 = null;
                                                th.printStackTrace();
                                                j8 = 0;
                                                a(0L);
                                                a(107, a(th), false);
                                                if (this.r) {
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                    z20 = z20;
                                                    if (z) {
                                                        j2 = j10;
                                                        z3 = z20;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    } else {
                                                        z3 = z20;
                                                    }
                                                    if (!this.r) {
                                                        if (this.s) {
                                                            z4 = z3;
                                                            i = 0;
                                                            r6 = z4;
                                                        } else {
                                                            if (this.b == null) {
                                                                zC = c(true, z19);
                                                            }
                                                            z4 = z3;
                                                            zC = z3;
                                                            zC = z3;
                                                            this.v.setUnpkgFlag(zC ? 1 : 0);
                                                            if (z19) {
                                                                tbsLogInfo = this.v;
                                                                if (zC) {
                                                                    i3 = 1;
                                                                } else {
                                                                    i3 = 2;
                                                                }
                                                            } else {
                                                                tbsLogInfo = this.v;
                                                                i3 = 0;
                                                            }
                                                            tbsLogInfo.setPatchUpdateFlag(i3);
                                                            if (zC) {
                                                                c(true);
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                a(100, com.unisound.common.y.J, true);
                                                                z4 = zC;
                                                                z4 = z3;
                                                                i = 0;
                                                                r6 = z4;
                                                            } else {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                i = 0;
                                                                d(false);
                                                                r6 = zC;
                                                            }
                                                        }
                                                        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                        if (r6 != 0) {
                                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                        } else {
                                                            i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                            if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                this.v.setDownloadCancel(2);
                                                            }
                                                        }
                                                        tbsDownloadConfig.commit();
                                                        this.v.setDownFinalFlag(r6);
                                                    }
                                                    f();
                                                    return;
                                                }
                                            } else {
                                                str3 = null;
                                                th.printStackTrace();
                                                j8 = 0;
                                                a(0L);
                                                a(107, a(th), false);
                                                if (this.r) {
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                    z20 = z20;
                                                    if (z) {
                                                        j2 = j10;
                                                        z3 = z20;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    } else {
                                                        z3 = z20;
                                                    }
                                                    if (!this.r) {
                                                        if (this.s) {
                                                            z4 = z3;
                                                            i = 0;
                                                            r6 = z4;
                                                        } else {
                                                            if (this.b == null) {
                                                                zC = c(true, z19);
                                                            }
                                                            z4 = z3;
                                                            zC = z3;
                                                            zC = z3;
                                                            this.v.setUnpkgFlag(zC ? 1 : 0);
                                                            if (z19) {
                                                                tbsLogInfo = this.v;
                                                                if (zC) {
                                                                    i3 = 1;
                                                                } else {
                                                                    i3 = 2;
                                                                }
                                                            } else {
                                                                tbsLogInfo = this.v;
                                                                i3 = 0;
                                                            }
                                                            tbsLogInfo.setPatchUpdateFlag(i3);
                                                            if (zC) {
                                                                c(true);
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                a(100, com.unisound.common.y.J, true);
                                                                z4 = zC;
                                                                z4 = z3;
                                                                i = 0;
                                                                r6 = z4;
                                                            } else {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                i = 0;
                                                                d(false);
                                                                r6 = zC;
                                                            }
                                                        }
                                                        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                        if (r6 != 0) {
                                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                        } else {
                                                            i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                            if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                this.v.setDownloadCancel(2);
                                                            }
                                                        }
                                                        tbsDownloadConfig.commit();
                                                        this.v.setDownFinalFlag(r6);
                                                    }
                                                    f();
                                                    return;
                                                }
                                            }
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                            z17 = z20;
                                            z20 = z20;
                                            if (!z) {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                z20 = z17;
                                            }
                                            z18 = true;
                                        }
                                    } else {
                                        j2 = j10;
                                        j = 0;
                                    }
                                    try {
                                        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo3 = this.v;
                                        if (j == 0) {
                                            i4 = 0;
                                        } else {
                                            i4 = 1;
                                        }
                                        tbsLogInfo3.setDownloadCancel(i4);
                                        apnType = com.tencent.smtt.utils.Apn.getApnType(this.g);
                                        apnInfo = com.tencent.smtt.utils.Apn.getApnInfo(this.g);
                                        if (this.w == null || this.x != -1) {
                                            if (apnType == this.x || !apnInfo.equals(this.w)) {
                                                this.v.setNetworkChange(0);
                                                this.w = apnInfo;
                                            }
                                            if (this.p >= 1) {
                                                this.t.addRequestProperty("Referer", this.h);
                                            }
                                            responseCode = this.t.getResponseCode();
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                                            this.v.setHttpCode(responseCode);
                                            if (!z && !com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) && ((com.tencent.smtt.utils.Apn.getApnType(this.g) != 3 || com.tencent.smtt.utils.Apn.getApnType(this.g) == 0) && !com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi())) {
                                                b();
                                                if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                    com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(111);
                                                }
                                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                                            }
                                            if (this.r) {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                if (!z) {
                                                    z3 = z20;
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                }
                                            } else {
                                                if (responseCode == 200 && responseCode != 206) {
                                                    if (responseCode >= 300 || responseCode > 307) {
                                                        a(102, java.lang.String.valueOf(responseCode), false);
                                                        if (responseCode == 416) {
                                                            if (c(true, z19)) {
                                                                try {
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                                                    if (z) {
                                                                        z3 = true;
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                    } else {
                                                                        z3 = true;
                                                                    }
                                                                } catch (java.lang.Throwable th7) {
                                                                    th = th7;
                                                                    j10 = j2;
                                                                    z20 = true;
                                                                    if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                                        str3 = null;
                                                                        th.printStackTrace();
                                                                        j8 = 0;
                                                                        a(0L);
                                                                        a(107, a(th), false);
                                                                        if (this.r) {
                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                            z20 = z20;
                                                                            if (z) {
                                                                                j2 = j10;
                                                                                z3 = z20;
                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                            } else {
                                                                                z3 = z20;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str3 = null;
                                                                        th.printStackTrace();
                                                                        j8 = 0;
                                                                        a(0L);
                                                                        a(107, a(th), false);
                                                                        if (this.r) {
                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                            z20 = z20;
                                                                            if (z) {
                                                                                j2 = j10;
                                                                                z3 = z20;
                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                            } else {
                                                                                z3 = z20;
                                                                            }
                                                                        }
                                                                    }
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                    z17 = z20;
                                                                    z20 = z20;
                                                                    if (!z) {
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                        z20 = z17;
                                                                    }
                                                                    z18 = true;
                                                                }
                                                            } else {
                                                                d(false);
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                                                if (!z) {
                                                                    z3 = z20;
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                }
                                                            }
                                                        } else if ((responseCode != 403 || responseCode == 406) && this.l == -1) {
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                                            if (!z) {
                                                                z3 = z20;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                        } else if (responseCode == 202) {
                                                            if (z) {
                                                                j10 = j2;
                                                                z20 = z20;
                                                                z18 = true;
                                                                str3 = null;
                                                                j8 = 0;
                                                            } else {
                                                                j10 = j2;
                                                                z11 = z20;
                                                                str3 = null;
                                                                j8 = 0;
                                                                z17 = z11;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                        } else if (this.p < this.B && responseCode == 503) {
                                                            a(java.lang.Long.parseLong(this.t.getHeaderField("Retry-After")));
                                                            if (this.r) {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                if (!z) {
                                                                    z3 = z20;
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                }
                                                            } else if (z) {
                                                                j10 = j2;
                                                                z20 = z20;
                                                                z18 = true;
                                                                str3 = null;
                                                                j8 = 0;
                                                            } else {
                                                                j10 = j2;
                                                                z11 = z20;
                                                                str3 = null;
                                                                j8 = 0;
                                                                z17 = z11;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                        } else if (this.p < this.B && (responseCode == 408 || responseCode == 504 || responseCode == 502 || responseCode == 408)) {
                                                            a(0L);
                                                            if (this.r) {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                if (!z) {
                                                                    z3 = z20;
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                }
                                                            } else if (z) {
                                                                j10 = j2;
                                                                z20 = z20;
                                                                z18 = true;
                                                                str3 = null;
                                                                j8 = 0;
                                                            } else {
                                                                j10 = j2;
                                                                z11 = z20;
                                                                str3 = null;
                                                                j8 = 0;
                                                                z17 = z11;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                        } else if (j() > 0 || this.o || responseCode == 410) {
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-315);
                                                            if (!z) {
                                                                z3 = z20;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                        } else {
                                                            this.o = true;
                                                            if (z) {
                                                                j10 = j2;
                                                                z20 = z20;
                                                                z18 = true;
                                                                str3 = null;
                                                                j8 = 0;
                                                            } else {
                                                                j10 = j2;
                                                                z11 = z20;
                                                                str3 = null;
                                                                j8 = 0;
                                                                z17 = z11;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                        }
                                                    } else {
                                                        java.lang.String headerField = this.t.getHeaderField("Location");
                                                        if (android.text.TextUtils.isEmpty(headerField)) {
                                                            a(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_REDIRECT_EMPTY, null, true);
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-312);
                                                            if (!z) {
                                                                z3 = z20;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                        } else {
                                                            this.j = headerField;
                                                            this.q++;
                                                            if (z) {
                                                                j10 = j2;
                                                                z20 = z20;
                                                                z18 = true;
                                                                str3 = null;
                                                                j8 = 0;
                                                            } else {
                                                                j10 = j2;
                                                                z11 = z20;
                                                                str3 = null;
                                                                j8 = 0;
                                                                z17 = z11;
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                        }
                                                    }
                                                    z18 = true;
                                                }
                                                this.l = ((long) this.t.getContentLength()) + j;
                                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                                                this.v.setPkgSize(this.l);
                                                j3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                                                if (j3 != 0 || this.l == j3) {
                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                                    try {
                                                        inputStream = this.t.getInputStream();
                                                        if (inputStream != null) {
                                                            try {
                                                                contentEncoding = this.t.getContentEncoding();
                                                                if (contentEncoding != null) {
                                                                    try {
                                                                        if (contentEncoding.contains("gzip")) {
                                                                            gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream);
                                                                        } else if (contentEncoding == null && contentEncoding.contains("deflate")) {
                                                                            gZIPInputStream = new java.util.zip.InflaterInputStream(inputStream, new java.util.zip.Inflater(true));
                                                                        } else {
                                                                            gZIPInputStream = inputStream;
                                                                        }
                                                                    } catch (java.io.IOException e2) {
                                                                        iOException = e2;
                                                                        fileOutputStream2 = null;
                                                                        inputStream2 = null;
                                                                        z9 = z20;
                                                                        try {
                                                                            iOException.printStackTrace();
                                                                            if (iOException instanceof java.net.SocketTimeoutException) {
                                                                                this.m = 100000;
                                                                                a(0L);
                                                                                a(103, a(iOException), false);
                                                                                a(fileOutputStream2);
                                                                                a(inputStream2);
                                                                                a(inputStream);
                                                                                if (z) {
                                                                                    j10 = j2;
                                                                                    z20 = z9;
                                                                                    z18 = true;
                                                                                    str3 = null;
                                                                                    j8 = 0;
                                                                                } else {
                                                                                    j10 = j2;
                                                                                    z11 = z9;
                                                                                    str3 = null;
                                                                                    j8 = 0;
                                                                                    z17 = z11;
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                    z20 = z17;
                                                                                    z18 = true;
                                                                                }
                                                                            } else {
                                                                                this.m = 100000;
                                                                                a(0L);
                                                                                a(103, a(iOException), false);
                                                                                a(fileOutputStream2);
                                                                                a(inputStream2);
                                                                                a(inputStream);
                                                                                if (z) {
                                                                                    j10 = j2;
                                                                                    z11 = z9;
                                                                                    str3 = null;
                                                                                    j8 = 0;
                                                                                    z17 = z11;
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                    z20 = z17;
                                                                                    z18 = true;
                                                                                } else {
                                                                                    j10 = j2;
                                                                                    z20 = z9;
                                                                                    z18 = true;
                                                                                    str3 = null;
                                                                                    j8 = 0;
                                                                                }
                                                                            }
                                                                        } catch (java.lang.Throwable th8) {
                                                                            th3 = th8;
                                                                            th2 = th3;
                                                                            z8 = z9;
                                                                            inputStream3 = inputStream;
                                                                            z7 = z8;
                                                                            j10 = j2;
                                                                            inputStream = inputStream3;
                                                                            fileOutputStream = fileOutputStream2;
                                                                            z6 = z7;
                                                                            try {
                                                                                a(fileOutputStream);
                                                                                a(inputStream2);
                                                                                a(inputStream);
                                                                                throw th2;
                                                                            } catch (java.lang.Throwable th9) {
                                                                                th = th9;
                                                                                z10 = z6;
                                                                                z20 = z10;
                                                                                if ((th instanceof javax.net.ssl.SSLHandshakeException) || z || this.b == null || !a(false)) {
                                                                                    str3 = null;
                                                                                    th.printStackTrace();
                                                                                    j8 = 0;
                                                                                    a(0L);
                                                                                    a(107, a(th), false);
                                                                                    if (this.r) {
                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                        z20 = z20;
                                                                                        if (z) {
                                                                                            j2 = j10;
                                                                                            z3 = z20;
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                        } else {
                                                                                            z3 = z20;
                                                                                        }
                                                                                        if (!this.r) {
                                                                                            if (this.s) {
                                                                                                z4 = z3;
                                                                                                i = 0;
                                                                                                r6 = z4;
                                                                                            } else {
                                                                                                if (this.b == null) {
                                                                                                    zC = c(true, z19);
                                                                                                }
                                                                                                z4 = z3;
                                                                                                zC = z3;
                                                                                                zC = z3;
                                                                                                this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                                                if (z19) {
                                                                                                    tbsLogInfo = this.v;
                                                                                                    if (zC) {
                                                                                                        i3 = 1;
                                                                                                    } else {
                                                                                                        i3 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    tbsLogInfo = this.v;
                                                                                                    i3 = 0;
                                                                                                }
                                                                                                tbsLogInfo.setPatchUpdateFlag(i3);
                                                                                                if (zC) {
                                                                                                    c(true);
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                                                    a(100, com.unisound.common.y.J, true);
                                                                                                    z4 = zC;
                                                                                                    z4 = z3;
                                                                                                    i = 0;
                                                                                                    r6 = z4;
                                                                                                } else {
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                                                    i = 0;
                                                                                                    d(false);
                                                                                                    r6 = zC;
                                                                                                }
                                                                                            }
                                                                                            tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                                            if (r6 != 0) {
                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                                            } else {
                                                                                                i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                                                if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                                                    this.v.setDownloadCancel(2);
                                                                                                }
                                                                                            }
                                                                                            tbsDownloadConfig.commit();
                                                                                            this.v.setDownFinalFlag(r6);
                                                                                        }
                                                                                        f();
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[startdownload]url:" + this.j + " download exception：" + th.toString());
                                                                                    str3 = null;
                                                                                    a(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_THROWABLE, null, true);
                                                                                    j8 = 0;
                                                                                }
                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                                z17 = z20;
                                                                                z20 = z20;
                                                                                if (!z) {
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                    z20 = z17;
                                                                                }
                                                                                z18 = true;
                                                                            }
                                                                        }
                                                                    } catch (java.lang.Throwable th10) {
                                                                        th2 = th10;
                                                                        j10 = j2;
                                                                        fileOutputStream = null;
                                                                        inputStream2 = null;
                                                                        z6 = z20;
                                                                        a(fileOutputStream);
                                                                        a(inputStream2);
                                                                        a(inputStream);
                                                                        throw th2;
                                                                    }
                                                                } else if (contentEncoding == null) {
                                                                    gZIPInputStream = inputStream;
                                                                } else {
                                                                    gZIPInputStream = inputStream;
                                                                }
                                                                try {
                                                                    bArr = new byte[8192];
                                                                    fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(this.k, "x5.tbs.temp"), true);
                                                                    try {
                                                                        jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                                                        long j13 = j;
                                                                        j4 = jCurrentTimeMillis3;
                                                                        j5 = j13;
                                                                        z20 = z20;
                                                                        while (true) {
                                                                            if (this.r) {
                                                                                try {
                                                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                    z13 = z20;
                                                                                    z9 = z13;
                                                                                    z14 = false;
                                                                                    inputStream2 = gZIPInputStream;
                                                                                } catch (java.io.IOException e3) {
                                                                                    iOException = e3;
                                                                                    z9 = z20 ? 1 : 0;
                                                                                    inputStream2 = gZIPInputStream;
                                                                                    iOException.printStackTrace();
                                                                                    if ((iOException instanceof java.net.SocketTimeoutException) || (iOException instanceof java.net.SocketException)) {
                                                                                        this.m = 100000;
                                                                                        a(0L);
                                                                                        a(103, a(iOException), false);
                                                                                        a(fileOutputStream2);
                                                                                        a(inputStream2);
                                                                                        a(inputStream);
                                                                                        if (z) {
                                                                                            j10 = j2;
                                                                                            z11 = z9;
                                                                                            str3 = null;
                                                                                            j8 = 0;
                                                                                            z17 = z11;
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                            z20 = z17;
                                                                                        } else {
                                                                                            j10 = j2;
                                                                                            z20 = z9;
                                                                                            z18 = true;
                                                                                            str3 = null;
                                                                                            j8 = 0;
                                                                                        }
                                                                                    } else {
                                                                                        if (z || com.tencent.smtt.utils.f.b(this.g)) {
                                                                                            a(0L);
                                                                                            a(!i() ? 106 : 104, a(iOException), false);
                                                                                            try {
                                                                                                a(fileOutputStream2);
                                                                                                a(inputStream2);
                                                                                                a(inputStream);
                                                                                                if (z) {
                                                                                                    j10 = j2;
                                                                                                    z20 = z9;
                                                                                                    z18 = true;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                } else {
                                                                                                    j10 = j2;
                                                                                                    z11 = z9;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                    z17 = z11;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    z20 = z17;
                                                                                                }
                                                                                            } catch (java.lang.Throwable th11) {
                                                                                                th = th11;
                                                                                                j10 = j2;
                                                                                                z10 = z9;
                                                                                                z20 = z10;
                                                                                                if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                                                                    str3 = null;
                                                                                                    th.printStackTrace();
                                                                                                    j8 = 0;
                                                                                                    a(0L);
                                                                                                    a(107, a(th), false);
                                                                                                    if (this.r) {
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                                        z20 = z20;
                                                                                                        if (z) {
                                                                                                            j2 = j10;
                                                                                                            z3 = z20;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                        } else {
                                                                                                            z3 = z20;
                                                                                                        }
                                                                                                        if (!this.r) {
                                                                                                            if (this.s) {
                                                                                                                z4 = z3;
                                                                                                                i = 0;
                                                                                                                r6 = z4;
                                                                                                            } else {
                                                                                                                if (this.b == null) {
                                                                                                                    zC = c(true, z19);
                                                                                                                }
                                                                                                                z4 = z3;
                                                                                                                zC = z3;
                                                                                                                zC = z3;
                                                                                                                this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                                                                if (z19) {
                                                                                                                    tbsLogInfo = this.v;
                                                                                                                    if (zC) {
                                                                                                                        i3 = 1;
                                                                                                                    } else {
                                                                                                                        i3 = 2;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    tbsLogInfo = this.v;
                                                                                                                    i3 = 0;
                                                                                                                }
                                                                                                                tbsLogInfo.setPatchUpdateFlag(i3);
                                                                                                                if (zC) {
                                                                                                                    c(true);
                                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                                                                    a(100, com.unisound.common.y.J, true);
                                                                                                                    z4 = zC;
                                                                                                                    z4 = z3;
                                                                                                                    i = 0;
                                                                                                                    r6 = z4;
                                                                                                                } else {
                                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                                                                    i = 0;
                                                                                                                    d(false);
                                                                                                                    r6 = zC;
                                                                                                                }
                                                                                                            }
                                                                                                            tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                                                            if (r6 != 0) {
                                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                                                            } else {
                                                                                                                i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                                                                if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                                                                    this.v.setDownloadCancel(2);
                                                                                                                }
                                                                                                            }
                                                                                                            tbsDownloadConfig.commit();
                                                                                                            this.v.setDownFinalFlag(r6);
                                                                                                        }
                                                                                                        f();
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    str3 = null;
                                                                                                    th.printStackTrace();
                                                                                                    j8 = 0;
                                                                                                    a(0L);
                                                                                                    a(107, a(th), false);
                                                                                                    if (this.r) {
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                                        z20 = z20;
                                                                                                        if (z) {
                                                                                                            j2 = j10;
                                                                                                            z3 = z20;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                        } else {
                                                                                                            z3 = z20;
                                                                                                        }
                                                                                                        if (!this.r) {
                                                                                                            if (this.s) {
                                                                                                                z4 = z3;
                                                                                                                i = 0;
                                                                                                                r6 = z4;
                                                                                                            } else {
                                                                                                                if (this.b == null) {
                                                                                                                    zC = c(true, z19);
                                                                                                                }
                                                                                                                z4 = z3;
                                                                                                                zC = z3;
                                                                                                                zC = z3;
                                                                                                                this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                                                                if (z19) {
                                                                                                                    tbsLogInfo = this.v;
                                                                                                                    if (zC) {
                                                                                                                        i3 = 1;
                                                                                                                    } else {
                                                                                                                        i3 = 2;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    tbsLogInfo = this.v;
                                                                                                                    i3 = 0;
                                                                                                                }
                                                                                                                tbsLogInfo.setPatchUpdateFlag(i3);
                                                                                                                if (zC) {
                                                                                                                    c(true);
                                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                                                                    a(100, com.unisound.common.y.J, true);
                                                                                                                    z4 = zC;
                                                                                                                    z4 = z3;
                                                                                                                    i = 0;
                                                                                                                    r6 = z4;
                                                                                                                } else {
                                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                                                                    i = 0;
                                                                                                                    d(false);
                                                                                                                    r6 = zC;
                                                                                                                }
                                                                                                            }
                                                                                                            tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                                                            if (r6 != 0) {
                                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                                                            } else {
                                                                                                                i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                                                                tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                                                                if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                                                                    this.v.setDownloadCancel(2);
                                                                                                                }
                                                                                                            }
                                                                                                            tbsDownloadConfig.commit();
                                                                                                            this.v.setDownFinalFlag(r6);
                                                                                                        }
                                                                                                        f();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                                                z17 = z20;
                                                                                                z20 = z20;
                                                                                                if (!z) {
                                                                                                }
                                                                                                z18 = true;
                                                                                            }
                                                                                        } else {
                                                                                            a(105, "freespace=" + com.tencent.smtt.utils.q.a() + ",and minFreeSpace=" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                                            a(fileOutputStream2);
                                                                                            a(inputStream2);
                                                                                            a(inputStream);
                                                                                            if (z) {
                                                                                                z3 = z9 ? 1 : 0;
                                                                                            } else {
                                                                                                z3 = z9 ? 1 : 0;
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                            }
                                                                                        }
                                                                                        th = th11;
                                                                                        j10 = j2;
                                                                                        z10 = z9;
                                                                                        z20 = z10;
                                                                                        if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                                                            str3 = null;
                                                                                            th.printStackTrace();
                                                                                            j8 = 0;
                                                                                            a(0L);
                                                                                            a(107, a(th), false);
                                                                                            if (this.r) {
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                                z20 = z20;
                                                                                                if (z) {
                                                                                                    j2 = j10;
                                                                                                    z3 = z20;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                } else {
                                                                                                    z3 = z20;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            str3 = null;
                                                                                            th.printStackTrace();
                                                                                            j8 = 0;
                                                                                            a(0L);
                                                                                            a(107, a(th), false);
                                                                                            if (this.r) {
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                                z20 = z20;
                                                                                                if (z) {
                                                                                                    j2 = j10;
                                                                                                    z3 = z20;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                } else {
                                                                                                    z3 = z20;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                                        z17 = z20;
                                                                                        z20 = z20;
                                                                                        if (!z) {
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                            z20 = z17;
                                                                                        }
                                                                                    }
                                                                                    z18 = true;
                                                                                } catch (java.lang.Throwable th12) {
                                                                                    th2 = th12;
                                                                                    z8 = z20 ? 1 : 0;
                                                                                    inputStream2 = gZIPInputStream;
                                                                                    inputStream3 = inputStream;
                                                                                    z7 = z8;
                                                                                    j10 = j2;
                                                                                    inputStream = inputStream3;
                                                                                    fileOutputStream = fileOutputStream2;
                                                                                    z6 = z7;
                                                                                    a(fileOutputStream);
                                                                                    a(inputStream2);
                                                                                    a(inputStream);
                                                                                    throw th2;
                                                                                }
                                                                            } else {
                                                                                z9 = z20 ? 1 : 0;
                                                                                try {
                                                                                    i5 = gZIPInputStream.read(bArr, 0, 8192);
                                                                                    if (i5 <= 0) {
                                                                                        try {
                                                                                            if (this.b != null || c(true, z19)) {
                                                                                                this.s = true;
                                                                                                if (this.b != null) {
                                                                                                    z16 = true;
                                                                                                } else {
                                                                                                    z16 = z9 ? 1 : 0;
                                                                                                }
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-311);
                                                                                                z13 = z16;
                                                                                                z9 = z13;
                                                                                                z14 = false;
                                                                                                inputStream2 = gZIPInputStream;
                                                                                            } else if (z || !a(false)) {
                                                                                                this.s = true;
                                                                                                inputStream2 = gZIPInputStream;
                                                                                                z14 = false;
                                                                                                z9 = false;
                                                                                            } else {
                                                                                                inputStream2 = gZIPInputStream;
                                                                                                z14 = true;
                                                                                                z9 = z9;
                                                                                            }
                                                                                        } catch (java.io.IOException e4) {
                                                                                            iOException = e4;
                                                                                            inputStream2 = gZIPInputStream;
                                                                                            z9 = z9;
                                                                                            iOException.printStackTrace();
                                                                                            if (iOException instanceof java.net.SocketTimeoutException) {
                                                                                                this.m = 100000;
                                                                                                a(0L);
                                                                                                a(103, a(iOException), false);
                                                                                                a(fileOutputStream2);
                                                                                                a(inputStream2);
                                                                                                a(inputStream);
                                                                                                if (z) {
                                                                                                    j10 = j2;
                                                                                                    z11 = z9;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                    z17 = z11;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    z20 = z17;
                                                                                                    z18 = true;
                                                                                                } else {
                                                                                                    j10 = j2;
                                                                                                    z20 = z9;
                                                                                                    z18 = true;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                }
                                                                                            } else {
                                                                                                this.m = 100000;
                                                                                                a(0L);
                                                                                                a(103, a(iOException), false);
                                                                                                a(fileOutputStream2);
                                                                                                a(inputStream2);
                                                                                                a(inputStream);
                                                                                                if (z) {
                                                                                                    j10 = j2;
                                                                                                    z11 = z9;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                    z17 = z11;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    z20 = z17;
                                                                                                    z18 = true;
                                                                                                } else {
                                                                                                    j10 = j2;
                                                                                                    z20 = z9;
                                                                                                    z18 = true;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                }
                                                                                            }
                                                                                        } catch (java.lang.Throwable th13) {
                                                                                            th2 = th13;
                                                                                            inputStream2 = gZIPInputStream;
                                                                                            inputStream3 = inputStream;
                                                                                            z7 = z9;
                                                                                            j10 = j2;
                                                                                            inputStream = inputStream3;
                                                                                            fileOutputStream = fileOutputStream2;
                                                                                            z6 = z7;
                                                                                            a(fileOutputStream);
                                                                                            a(inputStream2);
                                                                                            a(inputStream);
                                                                                            throw th2;
                                                                                        }
                                                                                    } else {
                                                                                        fileOutputStream2.write(bArr, 0, i5);
                                                                                        fileOutputStream2.flush();
                                                                                        if (z) {
                                                                                            inputStream2 = gZIPInputStream;
                                                                                            j7 = j2 + ((long) i5);
                                                                                            if (j7 >= downloadMaxflow) {
                                                                                                try {
                                                                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                                                                    a(112, "downloadFlow=" + j7 + " downloadMaxflow=" + downloadMaxflow, true);
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                                                                                    j2 = j7;
                                                                                                } catch (java.io.IOException e5) {
                                                                                                    iOException = e5;
                                                                                                    j2 = j7;
                                                                                                    z9 = z9;
                                                                                                    iOException.printStackTrace();
                                                                                                    if (iOException instanceof java.net.SocketTimeoutException) {
                                                                                                        this.m = 100000;
                                                                                                        a(0L);
                                                                                                        a(103, a(iOException), false);
                                                                                                        a(fileOutputStream2);
                                                                                                        a(inputStream2);
                                                                                                        a(inputStream);
                                                                                                        if (z) {
                                                                                                            j10 = j2;
                                                                                                            z11 = z9;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                            z17 = z11;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                            z20 = z17;
                                                                                                            z18 = true;
                                                                                                        } else {
                                                                                                            j10 = j2;
                                                                                                            z20 = z9;
                                                                                                            z18 = true;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                        }
                                                                                                    } else {
                                                                                                        this.m = 100000;
                                                                                                        a(0L);
                                                                                                        a(103, a(iOException), false);
                                                                                                        a(fileOutputStream2);
                                                                                                        a(inputStream2);
                                                                                                        a(inputStream);
                                                                                                        if (z) {
                                                                                                            j10 = j2;
                                                                                                            z11 = z9;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                            z17 = z11;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                            z20 = z17;
                                                                                                            z18 = true;
                                                                                                        } else {
                                                                                                            j10 = j2;
                                                                                                            z20 = z9;
                                                                                                            z18 = true;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                        }
                                                                                                    }
                                                                                                } catch (java.lang.Throwable th14) {
                                                                                                    th2 = th14;
                                                                                                    j2 = j7;
                                                                                                    inputStream3 = inputStream;
                                                                                                    z7 = z9;
                                                                                                    j10 = j2;
                                                                                                    inputStream = inputStream3;
                                                                                                    fileOutputStream = fileOutputStream2;
                                                                                                    z6 = z7;
                                                                                                    a(fileOutputStream);
                                                                                                    a(inputStream2);
                                                                                                    a(inputStream);
                                                                                                    throw th2;
                                                                                                }
                                                                                            } else {
                                                                                                j2 = j7;
                                                                                                try {
                                                                                                    if (!com.tencent.smtt.utils.f.b(this.g)) {
                                                                                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                                                        a(105, "freespace=" + com.tencent.smtt.utils.q.a() + ",and minFreeSpace=" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                                                    }
                                                                                                } catch (java.io.IOException e6) {
                                                                                                    iOException = e6;
                                                                                                    z9 = z9;
                                                                                                    iOException.printStackTrace();
                                                                                                    if (iOException instanceof java.net.SocketTimeoutException) {
                                                                                                        this.m = 100000;
                                                                                                        a(0L);
                                                                                                        a(103, a(iOException), false);
                                                                                                        a(fileOutputStream2);
                                                                                                        a(inputStream2);
                                                                                                        a(inputStream);
                                                                                                        if (z) {
                                                                                                            j10 = j2;
                                                                                                            z11 = z9;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                            z17 = z11;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                            z20 = z17;
                                                                                                            z18 = true;
                                                                                                        } else {
                                                                                                            j10 = j2;
                                                                                                            z20 = z9;
                                                                                                            z18 = true;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                        }
                                                                                                    } else {
                                                                                                        this.m = 100000;
                                                                                                        a(0L);
                                                                                                        a(103, a(iOException), false);
                                                                                                        a(fileOutputStream2);
                                                                                                        a(inputStream2);
                                                                                                        a(inputStream);
                                                                                                        if (z) {
                                                                                                            j10 = j2;
                                                                                                            z11 = z9;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                            z17 = z11;
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                            z20 = z17;
                                                                                                            z18 = true;
                                                                                                        } else {
                                                                                                            j10 = j2;
                                                                                                            z20 = z9;
                                                                                                            z18 = true;
                                                                                                            str3 = null;
                                                                                                            j8 = 0;
                                                                                                        }
                                                                                                    }
                                                                                                } catch (java.lang.Throwable th15) {
                                                                                                    th2 = th15;
                                                                                                    inputStream3 = inputStream;
                                                                                                    z7 = z9;
                                                                                                    j10 = j2;
                                                                                                    inputStream = inputStream3;
                                                                                                    fileOutputStream = fileOutputStream2;
                                                                                                    z6 = z7;
                                                                                                    a(fileOutputStream);
                                                                                                    a(inputStream2);
                                                                                                    a(inputStream);
                                                                                                    throw th2;
                                                                                                }
                                                                                            }
                                                                                            z14 = false;
                                                                                            z9 = z9;
                                                                                        } else {
                                                                                            inputStream2 = gZIPInputStream;
                                                                                        }
                                                                                        long j14 = i5;
                                                                                        try {
                                                                                            long jA2 = a(j4, j14);
                                                                                            jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                                                                                            j6 = j5 + j14;
                                                                                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000) {
                                                                                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j6 + "/" + this.l, true);
                                                                                                if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                                                                    double d4 = j6;
                                                                                                    double d5 = this.l;
                                                                                                    java.lang.Double.isNaN(d4);
                                                                                                    java.lang.Double.isNaN(d5);
                                                                                                    com.tencent.smtt.sdk.QbSdk.m.onDownloadProgress((int) ((d4 / d5) * 100.0d));
                                                                                                }
                                                                                                if (z && j6 - j13 > android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                                                                                                    if (!com.tencent.smtt.sdk.TbsDownloader.getOverSea(this.g) && ((com.tencent.smtt.utils.Apn.getApnType(this.g) != 3 || com.tencent.smtt.utils.Apn.getApnType(this.g) == 0) && !com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi())) {
                                                                                                        b();
                                                                                                        if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                                                                            com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(111);
                                                                                                        }
                                                                                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                                                                        z14 = false;
                                                                                                        z9 = z9;
                                                                                                    }
                                                                                                    j13 = j6;
                                                                                                }
                                                                                                jCurrentTimeMillis = jCurrentTimeMillis2;
                                                                                            }
                                                                                            j4 = jA2;
                                                                                            j5 = j6;
                                                                                            gZIPInputStream = inputStream2;
                                                                                            z20 = z9 ? 1 : 0;
                                                                                            bArr = bArr;
                                                                                        } catch (java.io.IOException e7) {
                                                                                            e = e7;
                                                                                            z12 = z9;
                                                                                            iOException = e;
                                                                                            z9 = z12;
                                                                                            iOException.printStackTrace();
                                                                                            if (iOException instanceof java.net.SocketTimeoutException) {
                                                                                                this.m = 100000;
                                                                                                a(0L);
                                                                                                a(103, a(iOException), false);
                                                                                                a(fileOutputStream2);
                                                                                                a(inputStream2);
                                                                                                a(inputStream);
                                                                                                if (z) {
                                                                                                    j10 = j2;
                                                                                                    z11 = z9;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                    z17 = z11;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    z20 = z17;
                                                                                                    z18 = true;
                                                                                                } else {
                                                                                                    j10 = j2;
                                                                                                    z20 = z9;
                                                                                                    z18 = true;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                }
                                                                                            } else {
                                                                                                this.m = 100000;
                                                                                                a(0L);
                                                                                                a(103, a(iOException), false);
                                                                                                a(fileOutputStream2);
                                                                                                a(inputStream2);
                                                                                                a(inputStream);
                                                                                                if (z) {
                                                                                                    j10 = j2;
                                                                                                    z11 = z9;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                    z17 = z11;
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    z20 = z17;
                                                                                                    z18 = true;
                                                                                                } else {
                                                                                                    j10 = j2;
                                                                                                    z20 = z9;
                                                                                                    z18 = true;
                                                                                                    str3 = null;
                                                                                                    j8 = 0;
                                                                                                }
                                                                                            }
                                                                                        } catch (java.lang.Throwable th16) {
                                                                                            th3 = th16;
                                                                                            th2 = th3;
                                                                                            z8 = z9;
                                                                                            inputStream3 = inputStream;
                                                                                            z7 = z8;
                                                                                            j10 = j2;
                                                                                            inputStream = inputStream3;
                                                                                            fileOutputStream = fileOutputStream2;
                                                                                            z6 = z7;
                                                                                            a(fileOutputStream);
                                                                                            a(inputStream2);
                                                                                            a(inputStream);
                                                                                            throw th2;
                                                                                        }
                                                                                    }
                                                                                } catch (java.io.IOException e8) {
                                                                                    e = e8;
                                                                                    inputStream2 = gZIPInputStream;
                                                                                } catch (java.lang.Throwable th17) {
                                                                                    th3 = th17;
                                                                                    inputStream2 = gZIPInputStream;
                                                                                }
                                                                            }
                                                                            if (z14) {
                                                                                try {
                                                                                    a(fileOutputStream2);
                                                                                    a(inputStream2);
                                                                                    a(inputStream);
                                                                                    if (z) {
                                                                                        j10 = j2;
                                                                                        z11 = z9;
                                                                                        str3 = null;
                                                                                        j8 = 0;
                                                                                        z17 = z11;
                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                        z20 = z17;
                                                                                        z18 = true;
                                                                                    } else {
                                                                                        j10 = j2;
                                                                                        z20 = z9;
                                                                                        z18 = true;
                                                                                        str3 = null;
                                                                                        j8 = 0;
                                                                                    }
                                                                                } catch (java.lang.Throwable th18) {
                                                                                    th = th18;
                                                                                    j10 = j2;
                                                                                    z15 = z9 ? 1 : 0;
                                                                                    z20 = z15;
                                                                                    if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                                                        str3 = null;
                                                                                        th.printStackTrace();
                                                                                        j8 = 0;
                                                                                        a(0L);
                                                                                        a(107, a(th), false);
                                                                                        if (this.r) {
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                            z20 = z20;
                                                                                            if (z) {
                                                                                                j2 = j10;
                                                                                                z3 = z20;
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                            } else {
                                                                                                z3 = z20;
                                                                                            }
                                                                                            if (!this.r) {
                                                                                                if (this.s) {
                                                                                                    z4 = z3;
                                                                                                    i = 0;
                                                                                                    r6 = z4;
                                                                                                } else {
                                                                                                    if (this.b == null) {
                                                                                                        zC = c(true, z19);
                                                                                                    }
                                                                                                    z4 = z3;
                                                                                                    zC = z3;
                                                                                                    zC = z3;
                                                                                                    this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                                                    if (z19) {
                                                                                                        tbsLogInfo = this.v;
                                                                                                        if (zC) {
                                                                                                            i3 = 1;
                                                                                                        } else {
                                                                                                            i3 = 2;
                                                                                                        }
                                                                                                    } else {
                                                                                                        tbsLogInfo = this.v;
                                                                                                        i3 = 0;
                                                                                                    }
                                                                                                    tbsLogInfo.setPatchUpdateFlag(i3);
                                                                                                    if (zC) {
                                                                                                        c(true);
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                                                        a(100, com.unisound.common.y.J, true);
                                                                                                        z4 = zC;
                                                                                                        z4 = z3;
                                                                                                        i = 0;
                                                                                                        r6 = z4;
                                                                                                    } else {
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                                                        i = 0;
                                                                                                        d(false);
                                                                                                        r6 = zC;
                                                                                                    }
                                                                                                }
                                                                                                tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                                                if (r6 != 0) {
                                                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                                                } else {
                                                                                                    i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                                                    if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                                                        this.v.setDownloadCancel(2);
                                                                                                    }
                                                                                                }
                                                                                                tbsDownloadConfig.commit();
                                                                                                this.v.setDownFinalFlag(r6);
                                                                                            }
                                                                                            f();
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        str3 = null;
                                                                                        th.printStackTrace();
                                                                                        j8 = 0;
                                                                                        a(0L);
                                                                                        a(107, a(th), false);
                                                                                        if (this.r) {
                                                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                            z20 = z20;
                                                                                            if (z) {
                                                                                                j2 = j10;
                                                                                                z3 = z20;
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                                            } else {
                                                                                                z3 = z20;
                                                                                            }
                                                                                            if (!this.r) {
                                                                                                if (this.s) {
                                                                                                    z4 = z3;
                                                                                                    i = 0;
                                                                                                    r6 = z4;
                                                                                                } else {
                                                                                                    if (this.b == null) {
                                                                                                        zC = c(true, z19);
                                                                                                    }
                                                                                                    z4 = z3;
                                                                                                    zC = z3;
                                                                                                    zC = z3;
                                                                                                    this.v.setUnpkgFlag(zC ? 1 : 0);
                                                                                                    if (z19) {
                                                                                                        tbsLogInfo = this.v;
                                                                                                        if (zC) {
                                                                                                            i3 = 1;
                                                                                                        } else {
                                                                                                            i3 = 2;
                                                                                                        }
                                                                                                    } else {
                                                                                                        tbsLogInfo = this.v;
                                                                                                        i3 = 0;
                                                                                                    }
                                                                                                    tbsLogInfo.setPatchUpdateFlag(i3);
                                                                                                    if (zC) {
                                                                                                        c(true);
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                                                        a(100, com.unisound.common.y.J, true);
                                                                                                        z4 = zC;
                                                                                                        z4 = z3;
                                                                                                        i = 0;
                                                                                                        r6 = z4;
                                                                                                    } else {
                                                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                                                        i = 0;
                                                                                                        d(false);
                                                                                                        r6 = zC;
                                                                                                    }
                                                                                                }
                                                                                                tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                                                                                if (r6 != 0) {
                                                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                                                                                } else {
                                                                                                    i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                                                                                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                                                                                    if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                                                                        this.v.setDownloadCancel(2);
                                                                                                    }
                                                                                                }
                                                                                                tbsDownloadConfig.commit();
                                                                                                this.v.setDownFinalFlag(r6);
                                                                                            }
                                                                                            f();
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                                    z17 = z20;
                                                                                    z20 = z20;
                                                                                    if (!z) {
                                                                                    }
                                                                                    z18 = true;
                                                                                }
                                                                            } else {
                                                                                z3 = z9 ? 1 : 0;
                                                                            }
                                                                        }
                                                                    } catch (java.io.IOException e9) {
                                                                        e = e9;
                                                                        z12 = z20;
                                                                        inputStream2 = gZIPInputStream;
                                                                    } catch (java.lang.Throwable th19) {
                                                                        th3 = th19;
                                                                        z9 = z20;
                                                                        inputStream2 = gZIPInputStream;
                                                                    }
                                                                } catch (java.io.IOException e10) {
                                                                    z9 = z20 ? 1 : 0;
                                                                    inputStream2 = gZIPInputStream;
                                                                    iOException = e10;
                                                                    fileOutputStream2 = null;
                                                                } catch (java.lang.Throwable th20) {
                                                                    z6 = z20 ? 1 : 0;
                                                                    inputStream2 = gZIPInputStream;
                                                                    th2 = th20;
                                                                    j10 = j2;
                                                                    fileOutputStream = null;
                                                                    a(fileOutputStream);
                                                                    a(inputStream2);
                                                                    a(inputStream);
                                                                    throw th2;
                                                                }
                                                            } catch (java.io.IOException e11) {
                                                                iOException = e11;
                                                            } catch (java.lang.Throwable th21) {
                                                                th2 = th21;
                                                            }
                                                        } else {
                                                            z3 = z20 ? 1 : 0 ? 1 : 0;
                                                            fileOutputStream2 = null;
                                                            inputStream2 = null;
                                                        }
                                                        try {
                                                            a(fileOutputStream2);
                                                            a(inputStream2);
                                                            a(inputStream);
                                                            if (!this.s) {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                                                            }
                                                            if (!z) {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                        } catch (java.lang.Throwable th22) {
                                                            th = th22;
                                                            z5 = z3 ? 1 : 0;
                                                            j10 = j2;
                                                            z20 = z5;
                                                            if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                                                str3 = null;
                                                                th.printStackTrace();
                                                                j8 = 0;
                                                                a(0L);
                                                                a(107, a(th), false);
                                                                if (this.r) {
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                    z20 = z20;
                                                                    if (z) {
                                                                        j2 = j10;
                                                                        z3 = z20;
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                    } else {
                                                                        z3 = z20;
                                                                    }
                                                                }
                                                            } else {
                                                                str3 = null;
                                                                th.printStackTrace();
                                                                j8 = 0;
                                                                a(0L);
                                                                a(107, a(th), false);
                                                                if (this.r) {
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                    z20 = z20;
                                                                    if (z) {
                                                                        j2 = j10;
                                                                        z3 = z20;
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                    } else {
                                                                        z3 = z20;
                                                                    }
                                                                }
                                                            }
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                            z17 = z20;
                                                            z20 = z20;
                                                            if (!z) {
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                                z20 = z17;
                                                            }
                                                            z18 = true;
                                                        }
                                                    } catch (java.io.IOException e12) {
                                                        iOException = e12;
                                                        inputStream = null;
                                                    } catch (java.lang.Throwable th23) {
                                                        th2 = th23;
                                                        inputStream = null;
                                                    }
                                                } else {
                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j3 + "  but contentLength=" + this.l, true);
                                                    if (z || !(m() || (com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi() && com.tencent.smtt.utils.Apn.isNetworkAvailable(this.g)))) {
                                                        a(101, "WifiNetworkUnAvailable", true);
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                    } else if (this.b == null || !a(false)) {
                                                        a(113, "tbsApkFileSize=" + j3 + "  but contentLength=" + this.l, true);
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-310);
                                                    } else if (z) {
                                                        j10 = j2;
                                                        z20 = z20;
                                                        z18 = true;
                                                        str3 = null;
                                                        j8 = 0;
                                                    } else {
                                                        j10 = j2;
                                                        z11 = z20;
                                                        str3 = null;
                                                        j8 = 0;
                                                        z17 = z11;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                        z20 = z17;
                                                        z18 = true;
                                                    }
                                                    if (!z) {
                                                        z3 = z20;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                }
                                            }
                                        } else {
                                            this.w = apnInfo;
                                        }
                                        this.x = apnType;
                                        if (this.p >= 1) {
                                            this.t.addRequestProperty("Referer", this.h);
                                        }
                                        responseCode = this.t.getResponseCode();
                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                                        this.v.setHttpCode(responseCode);
                                        if (!z) {
                                            b();
                                            if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                com.tencent.smtt.sdk.QbSdk.m.onDownloadFinish(111);
                                            }
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                                        }
                                        if (this.r) {
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                            if (!z) {
                                                z3 = z20;
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                            }
                                        } else if (responseCode == 200) {
                                            this.l = ((long) this.t.getContentLength()) + j;
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                                            this.v.setPkgSize(this.l);
                                            j3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                                            if (j3 != 0) {
                                            }
                                            com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                            inputStream = this.t.getInputStream();
                                            if (inputStream != null) {
                                                contentEncoding = this.t.getContentEncoding();
                                                if (contentEncoding != null) {
                                                    if (contentEncoding.contains("gzip")) {
                                                        gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream);
                                                    } else if (contentEncoding == null) {
                                                        gZIPInputStream = inputStream;
                                                    } else {
                                                        gZIPInputStream = inputStream;
                                                    }
                                                } else if (contentEncoding == null) {
                                                    gZIPInputStream = inputStream;
                                                } else {
                                                    gZIPInputStream = inputStream;
                                                }
                                                bArr = new byte[8192];
                                                fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(this.k, "x5.tbs.temp"), true);
                                                jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                                long j15 = j;
                                                j4 = jCurrentTimeMillis3;
                                                j5 = j15;
                                                z20 = z20;
                                                while (true) {
                                                    if (this.r) {
                                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                        z13 = z20;
                                                        z9 = z13;
                                                        z14 = false;
                                                        inputStream2 = gZIPInputStream;
                                                    } else {
                                                        z9 = z20 ? 1 : 0;
                                                        i5 = gZIPInputStream.read(bArr, 0, 8192);
                                                        if (i5 <= 0) {
                                                            if (this.b != null) {
                                                            }
                                                            this.s = true;
                                                            if (this.b != null) {
                                                                z16 = true;
                                                            } else {
                                                                z16 = z9 ? 1 : 0;
                                                            }
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-311);
                                                            z13 = z16;
                                                            z9 = z13;
                                                            z14 = false;
                                                            inputStream2 = gZIPInputStream;
                                                        } else {
                                                            fileOutputStream2.write(bArr, 0, i5);
                                                            fileOutputStream2.flush();
                                                            if (z) {
                                                                inputStream2 = gZIPInputStream;
                                                                j7 = j2 + ((long) i5);
                                                                if (j7 >= downloadMaxflow) {
                                                                    com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                                    a(112, "downloadFlow=" + j7 + " downloadMaxflow=" + downloadMaxflow, true);
                                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                                                    j2 = j7;
                                                                } else {
                                                                    j2 = j7;
                                                                    if (!com.tencent.smtt.utils.f.b(this.g)) {
                                                                        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                        a(105, "freespace=" + com.tencent.smtt.utils.q.a() + ",and minFreeSpace=" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                    }
                                                                }
                                                                z14 = false;
                                                                z9 = z9;
                                                            } else {
                                                                inputStream2 = gZIPInputStream;
                                                            }
                                                            long j16 = i5;
                                                            long jA3 = a(j4, j16);
                                                            jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                                                            j6 = j5 + j16;
                                                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000) {
                                                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j6 + "/" + this.l, true);
                                                                if (com.tencent.smtt.sdk.QbSdk.m != null) {
                                                                    double d6 = j6;
                                                                    double d7 = this.l;
                                                                    java.lang.Double.isNaN(d6);
                                                                    java.lang.Double.isNaN(d7);
                                                                    com.tencent.smtt.sdk.QbSdk.m.onDownloadProgress((int) ((d6 / d7) * 100.0d));
                                                                }
                                                                if (z) {
                                                                }
                                                                jCurrentTimeMillis = jCurrentTimeMillis2;
                                                            }
                                                            j4 = jA3;
                                                            j5 = j6;
                                                            gZIPInputStream = inputStream2;
                                                            z20 = z9 ? 1 : 0;
                                                            bArr = bArr;
                                                        }
                                                    }
                                                    if (z14) {
                                                        a(fileOutputStream2);
                                                        a(inputStream2);
                                                        a(inputStream);
                                                        if (z) {
                                                            j10 = j2;
                                                            z11 = z9;
                                                            str3 = null;
                                                            j8 = 0;
                                                            z17 = z11;
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                            z20 = z17;
                                                            z18 = true;
                                                        } else {
                                                            j10 = j2;
                                                            z20 = z9;
                                                            z18 = true;
                                                            str3 = null;
                                                            j8 = 0;
                                                        }
                                                    } else {
                                                        z3 = z9 ? 1 : 0;
                                                    }
                                                }
                                            } else {
                                                z3 = z20 ? 1 : 0 ? 1 : 0;
                                                fileOutputStream2 = null;
                                                inputStream2 = null;
                                            }
                                            a(fileOutputStream2);
                                            a(inputStream2);
                                            a(inputStream);
                                            if (!this.s) {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                                            }
                                            if (!z) {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                            }
                                        } else {
                                            if (responseCode >= 300) {
                                            }
                                            a(102, java.lang.String.valueOf(responseCode), false);
                                            if (responseCode == 416) {
                                                if (c(true, z19)) {
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                                    if (z) {
                                                        z3 = true;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    } else {
                                                        z3 = true;
                                                    }
                                                } else {
                                                    d(false);
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                                    if (!z) {
                                                        z3 = z20;
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                }
                                            } else if (responseCode != 403) {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                                if (!z) {
                                                    z3 = z20;
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                }
                                            } else {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                                if (!z) {
                                                    z3 = z20;
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                                }
                                            }
                                        }
                                    } catch (java.lang.Throwable th24) {
                                        boolean z21 = z20 ? 1 : 0;
                                        th = th24;
                                        z5 = z20;
                                    }
                                } catch (java.lang.Throwable th25) {
                                    boolean z22 = z20 ? 1 : 0;
                                    th = th25;
                                    z20 = z20;
                                }
                            } else {
                                com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", z18);
                                a(105, null, z18);
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                z20 = z20;
                                if (!z) {
                                    j2 = j10;
                                    z3 = z20;
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        } catch (java.lang.Throwable th26) {
                            th = th26;
                            th = th;
                            z15 = z20;
                            z20 = z15;
                            if (th instanceof javax.net.ssl.SSLHandshakeException) {
                                str3 = null;
                                th.printStackTrace();
                                j8 = 0;
                                a(0L);
                                a(107, a(th), false);
                                if (this.r) {
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                    z20 = z20;
                                    if (z) {
                                        j2 = j10;
                                        z3 = z20;
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                    } else {
                                        z3 = z20;
                                    }
                                    if (!this.r) {
                                        if (this.s) {
                                            z4 = z3;
                                            i = 0;
                                            r6 = z4;
                                        } else {
                                            if (this.b == null) {
                                                zC = c(true, z19);
                                            }
                                            z4 = z3;
                                            zC = z3;
                                            zC = z3;
                                            this.v.setUnpkgFlag(zC ? 1 : 0);
                                            if (z19) {
                                                tbsLogInfo = this.v;
                                                if (zC) {
                                                    i3 = 1;
                                                } else {
                                                    i3 = 2;
                                                }
                                            } else {
                                                tbsLogInfo = this.v;
                                                i3 = 0;
                                            }
                                            tbsLogInfo.setPatchUpdateFlag(i3);
                                            if (zC) {
                                                c(true);
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                a(100, com.unisound.common.y.J, true);
                                                z4 = zC;
                                                z4 = z3;
                                                i = 0;
                                                r6 = z4;
                                            } else {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                i = 0;
                                                d(false);
                                                r6 = zC;
                                            }
                                        }
                                        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                        if (r6 != 0) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                        } else {
                                            i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                            if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                this.v.setDownloadCancel(2);
                                            }
                                        }
                                        tbsDownloadConfig.commit();
                                        this.v.setDownFinalFlag(r6);
                                    }
                                    f();
                                    return;
                                }
                            } else {
                                str3 = null;
                                th.printStackTrace();
                                j8 = 0;
                                a(0L);
                                a(107, a(th), false);
                                if (this.r) {
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                    z20 = z20;
                                    if (z) {
                                        j2 = j10;
                                        z3 = z20;
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j2));
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                    } else {
                                        z3 = z20;
                                    }
                                    if (!this.r) {
                                        if (this.s) {
                                            z4 = z3;
                                            i = 0;
                                            r6 = z4;
                                        } else {
                                            if (this.b == null) {
                                                zC = c(true, z19);
                                            }
                                            z4 = z3;
                                            zC = z3;
                                            zC = z3;
                                            this.v.setUnpkgFlag(zC ? 1 : 0);
                                            if (z19) {
                                                tbsLogInfo = this.v;
                                                if (zC) {
                                                    i3 = 1;
                                                } else {
                                                    i3 = 2;
                                                }
                                            } else {
                                                tbsLogInfo = this.v;
                                                i3 = 0;
                                            }
                                            tbsLogInfo.setPatchUpdateFlag(i3);
                                            if (zC) {
                                                c(true);
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                a(100, com.unisound.common.y.J, true);
                                                z4 = zC;
                                                z4 = z3;
                                                i = 0;
                                                r6 = z4;
                                            } else {
                                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                i = 0;
                                                d(false);
                                                r6 = zC;
                                            }
                                        }
                                        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                                        if (r6 != 0) {
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                                        } else {
                                            i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                                            if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                                this.v.setDownloadCancel(2);
                                            }
                                        }
                                        tbsDownloadConfig.commit();
                                        this.v.setDownFinalFlag(r6);
                                    }
                                    f();
                                    return;
                                }
                            }
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                            z17 = z20;
                            z20 = z20;
                            if (!z) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(j10));
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).commit();
                                z20 = z17;
                            }
                            z18 = true;
                        }
                    }
                    if (!this.r) {
                        if (this.s) {
                            z4 = z3;
                            i = 0;
                            r6 = z4;
                        } else {
                            if (this.b == null && !z3) {
                                zC = c(true, z19);
                            }
                            z4 = z3;
                            zC = z3;
                            zC = z3;
                            this.v.setUnpkgFlag(zC ? 1 : 0);
                            if (z19) {
                                tbsLogInfo = this.v;
                                if (zC) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                            } else {
                                tbsLogInfo = this.v;
                                i3 = 0;
                            }
                            tbsLogInfo.setPatchUpdateFlag(i3);
                            if (zC) {
                                c(true);
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                a(100, com.unisound.common.y.J, true);
                                z4 = zC;
                                z4 = z3;
                                i = 0;
                                r6 = z4;
                            } else {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                i = 0;
                                d(false);
                                r6 = zC;
                            }
                        }
                        tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                        if (r6 != 0) {
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                        } else {
                            i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                            if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                this.v.setDownloadCancel(2);
                            }
                        }
                        tbsDownloadConfig.commit();
                        this.v.setDownFinalFlag(r6);
                    }
                    f();
                    return;
                }
                a(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, str3, z18);
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-306);
            }
            z3 = z20;
            if (!this.r) {
                if (this.s) {
                    z4 = z3;
                    i = 0;
                    r6 = z4;
                } else {
                    if (this.b == null) {
                        zC = c(true, z19);
                    }
                    z4 = z3;
                    zC = z3;
                    zC = z3;
                    this.v.setUnpkgFlag(zC ? 1 : 0);
                    if (z19) {
                        tbsLogInfo = this.v;
                        if (zC) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                    } else {
                        tbsLogInfo = this.v;
                        i3 = 0;
                    }
                    tbsLogInfo.setPatchUpdateFlag(i3);
                    if (zC) {
                        c(true);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                        a(100, com.unisound.common.y.J, true);
                        z4 = zC;
                        z4 = z3;
                        i = 0;
                        r6 = z4;
                    } else {
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                        i = 0;
                        d(false);
                        r6 = zC;
                    }
                }
                tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(this.g);
                if (r6 != 0) {
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, java.lang.Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                } else {
                    i2 = tbsDownloadConfig.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                    tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, java.lang.Integer.valueOf(i2));
                    if (i2 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                        this.v.setDownloadCancel(2);
                    }
                }
                tbsDownloadConfig.commit();
                this.v.setDownFinalFlag(r6);
            }
            f();
            return;
        }
    }

    public void c() {
        b();
        d(false);
        d(true);
    }

    public boolean d() {
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        return this.C;
    }
}
