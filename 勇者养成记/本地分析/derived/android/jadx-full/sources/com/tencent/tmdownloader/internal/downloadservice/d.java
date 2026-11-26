package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public java.lang.String A;
    public java.lang.String B;
    public java.lang.String C;
    public int D;
    public java.lang.String E;
    public java.lang.String F;
    public java.lang.String G;
    public boolean H;
    public boolean I;
    public long J;
    public java.lang.String K;
    public int L;
    final java.lang.Object M;
    public com.tencent.hlyyb.downloader.DownloaderTaskListener N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1133a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    boolean e;
    public int f;
    public int g;
    public long h;
    public long i;
    public java.lang.String j;
    protected java.lang.String k;
    public int l;
    public int m;
    public java.lang.String n;
    public long o;
    protected java.util.HashMap p;
    protected java.lang.String q;
    public long r;
    public java.lang.String s;
    public java.lang.String t;
    public java.lang.String u;
    public long v;
    public long w;
    public long x;
    public java.lang.String y;
    public java.lang.String z;

    public d() {
        this.r = 0L;
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = false;
        this.L = 0;
        this.M = new java.lang.Object();
        this.N = new com.tencent.tmdownloader.internal.downloadservice.e(this);
        this.e = false;
    }

    public d(java.lang.String str, int i, java.lang.String str2) {
        this.r = 0L;
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = false;
        this.L = 0;
        this.M = new java.lang.Object();
        this.N = new com.tencent.tmdownloader.internal.downloadservice.e(this);
        this.b = str;
        this.c = com.tencent.tmdownloader.internal.downloadservice.c.a(str);
        this.d = java.util.UUID.randomUUID().toString();
        this.l = i;
        this.g = 0;
        this.m = 0;
        this.e = false;
        this.f1133a = str2;
        this.n = com.tencent.tmdownloader.internal.downloadservice.c.a();
        this.o = 0L;
        this.u = "";
    }

    public static com.tencent.tmdownloader.internal.downloadservice.d a(android.database.Cursor cursor) {
        com.tencent.tmdownloader.internal.downloadservice.d dVar = new com.tencent.tmdownloader.internal.downloadservice.d();
        dVar.f = cursor.getInt(cursor.getColumnIndex("taskId"));
        dVar.d = cursor.getString(cursor.getColumnIndex("uId"));
        dVar.c = cursor.getString(cursor.getColumnIndex("finalUrl"));
        dVar.b = cursor.getString(cursor.getColumnIndex("taskUrl"));
        dVar.K = cursor.getString(cursor.getColumnIndex("bakUrl"));
        dVar.j = cursor.getString(cursor.getColumnIndex("fileName"));
        dVar.f1133a = cursor.getString(cursor.getColumnIndex("contentType"));
        dVar.i = cursor.getLong(cursor.getColumnIndex("totalBytes"));
        dVar.g = cursor.getInt(cursor.getColumnIndex("status"));
        dVar.h = cursor.getLong(cursor.getColumnIndex("receivedBytes"));
        dVar.l = cursor.getInt(cursor.getColumnIndex("priority"));
        dVar.n = cursor.getString(cursor.getColumnIndex("netType"));
        dVar.m = cursor.getInt(cursor.getColumnIndex("downloadFailedErrCode"));
        dVar.o = cursor.getLong(cursor.getColumnIndex("downloadFailedTime"));
        dVar.q = cursor.getString(cursor.getColumnIndex("headerParams"));
        dVar.r = cursor.getLong(cursor.getColumnIndex("appId"));
        dVar.s = cursor.getString(cursor.getColumnIndex("taskPakcageName"));
        dVar.t = cursor.getString(cursor.getColumnIndex("taskVersioncode"));
        dVar.u = cursor.getString(cursor.getColumnIndex("clientIp"));
        dVar.v = cursor.getLong(cursor.getColumnIndex("startTime"));
        dVar.w = cursor.getLong(cursor.getColumnIndex("endTime"));
        dVar.D = cursor.getInt(cursor.getColumnIndex("downloadType"));
        dVar.x = cursor.getLong(cursor.getColumnIndex("uin"));
        dVar.y = cursor.getString(cursor.getColumnIndex("uintype"));
        dVar.z = cursor.getString(cursor.getColumnIndex("via"));
        dVar.A = cursor.getString(cursor.getColumnIndex(com.tencent.ysdk.shell.framework.channel.ApkChannelTool.CHANNEL_ID));
        dVar.B = cursor.getString(cursor.getColumnIndex("traceId"));
        dVar.C = cursor.getString(cursor.getColumnIndex("extraData"));
        dVar.J = cursor.getLong(cursor.getColumnIndex("fileSize"));
        return dVar;
    }

    public static void a(android.content.ContentValues contentValues, com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        if (dVar == null || contentValues == null) {
            return;
        }
        contentValues.put("taskId", java.lang.Integer.valueOf(dVar.f));
        contentValues.put("uId", dVar.d);
        contentValues.put("finalUrl", dVar.c);
        contentValues.put("taskUrl", dVar.b);
        contentValues.put("bakUrl", dVar.K);
        contentValues.put("fileName", dVar.j);
        contentValues.put("contentType", dVar.f1133a);
        contentValues.put("totalBytes", java.lang.Long.valueOf(dVar.i));
        contentValues.put("status", java.lang.Integer.valueOf(dVar.g));
        contentValues.put("receivedBytes", java.lang.Long.valueOf(dVar.h));
        contentValues.put("priority", java.lang.Integer.valueOf(dVar.l));
        contentValues.put("netType", dVar.n);
        contentValues.put("downloadFailedErrCode", java.lang.Integer.valueOf(dVar.m));
        contentValues.put("downloadFailedTime", java.lang.Long.valueOf(dVar.o));
        contentValues.put("headerParams", dVar.q);
        contentValues.put("appId", java.lang.Long.valueOf(dVar.r));
        contentValues.put("taskPakcageName", dVar.s);
        contentValues.put("taskVersioncode", dVar.t);
        contentValues.put("clientIp", dVar.u);
        contentValues.put("startTime", java.lang.Long.valueOf(dVar.v));
        contentValues.put("endTime", java.lang.Long.valueOf(dVar.w));
        contentValues.put("downloadType", java.lang.Integer.valueOf(dVar.D));
        contentValues.put("uin", java.lang.Long.valueOf(dVar.x));
        contentValues.put("uintype", dVar.y);
        contentValues.put("via", dVar.z);
        contentValues.put(com.tencent.ysdk.shell.framework.channel.ApkChannelTool.CHANNEL_ID, dVar.A);
        contentValues.put("traceId", dVar.B);
        contentValues.put("extraData", dVar.C);
        contentValues.put("fileSize", java.lang.Long.valueOf(dVar.J));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a(8, this.r, this.D, this.s, this.t, 103, downloaderTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:70:0x0098  */
    public void b(int i) {
        int i2;
        if (i >= 0) {
            i2 = i;
        } else if (i == -23) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CONNECT_TIMEOUT;
        } else if (i == -25) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_TIMEOUT;
        } else if (i == -29) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_UNKNOWN_HOST;
        } else if (i == -26) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION;
        } else if (i == -27) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_IO_EXCEPTION;
        } else if (i == -51) {
            i2 = 700;
        } else if (i == -41) {
            i2 = 701;
        } else if (i == -58) {
            i2 = 702;
        } else if (i == -14 || i == -47 || i == -49 || i == -50 || i == -72) {
            i2 = 703;
        } else if (i == -11) {
            i2 = 704;
        } else if (i == -43) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_TOTAL_SIZE_NOT_SAME;
        } else if (i == -42) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_RANGE_NOT_MATCH;
        } else if (i == -53 || i == -65 || i == -59) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SET_RANGE_FAILED;
        } else if (i == -57) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
        } else if (i == -12 || i == -40) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_WRITE_FILE_NO_ENOUGH_SPACE;
        } else if (i == -13 || i == -46) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_WRITE_FILE_SDCARD_EXCEPTION;
        } else if (i == -15) {
            i2 = com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION;
        } else {
            i2 = (i == -76 || i == -10) ? 712 : com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_UNKNOWN_EXCEPTION;
        }
        this.m = i2;
        com.tencent.tmassistantbase.util.TMLog.e("_DownloadInfo", "halleytest convertHalleyFailCodeToDownloadFailedErrCode halley failCode = " + i + ",mDownloadFailedErrCode = " + this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a(8, this.r, this.D, this.s, this.t, 102, downloaderTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a(8, this.r, this.D, this.s, this.t, 101, downloaderTask);
    }

    public synchronized void a(int i) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleytest updateStatus status=" + i + ", mStatus = " + this.g);
        if (b()) {
            return;
        }
        this.g = i;
        if (i == 6 || i == 6) {
            com.tencent.tmdownloader.internal.b.a.a().a(this.b);
        } else {
            if (i == 5) {
                this.o = java.lang.System.currentTimeMillis();
            }
            com.tencent.tmdownloader.internal.b.a.a().a(this);
            com.tencent.tmdownloader.internal.downloadservice.f.a().a(this.b, this.g, this.m, "");
            if (this.g == 4 && this.H) {
                com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "Download status is succeed, start to install");
                com.tencent.tmdownloader.internal.downloadservice.b.a(com.tencent.tmdownloader.internal.b.b.a(this.j));
            }
        }
        if (this.g == 4) {
            com.tencent.tmdownloader.internal.protocol.jce.DownloadStatLogInfo downloadStatLogInfoA = com.tencent.tmdownloader.internal.logreport.c.a(this);
            downloadStatLogInfoA.endTime = java.lang.System.currentTimeMillis();
            com.tencent.tmdownloader.internal.logreport.c.h().a(downloadStatLogInfoA);
            com.tencent.tmdownloader.internal.logreport.c.h().c();
        }
        int i2 = this.g;
        if (i2 == 4 || i2 == 6 || i2 == 5) {
            com.tencent.tmdownloader.internal.protocol.jce.DownloadQualityLogInfo downloadQualityLogInfoA = com.tencent.tmdownloader.internal.logreport.d.a(this);
            if (0 == this.w) {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                this.w = jCurrentTimeMillis;
                downloadQualityLogInfoA.endTime = jCurrentTimeMillis;
            }
            com.tencent.tmdownloader.internal.logreport.d.h().a(downloadQualityLogInfoA);
            com.tencent.tmdownloader.internal.logreport.d.h().c();
            com.tencent.tmdownloader.internal.logreport.d.a(this.d);
        }
    }

    public void a(int i, long j, int i2, java.lang.String str, java.lang.String str2, int i3, com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        java.lang.String uniqueKey = downloaderTask.getUniqueKey();
        java.lang.String url = downloaderTask.getUrl();
        int i4 = !downloaderTask.isPausedOnMobile() ? 1 : 0;
        int failCode = downloaderTask.getFailCode();
        if (i3 != 101) {
            i4 = -1;
        }
        java.lang.String str3 = jCurrentTimeMillis + "|" + j + "|" + str2 + "|" + str + "|" + i2 + "|" + i3 + "|" + uniqueKey + "|" + url + "|" + i4 + "|" + failCode + "|";
        com.tencent.tmassistantbase.util.TMLog.d("_DownloadInfo", "reportLog type=" + i + ",yybInstallReport.data: " + str3);
        com.tencent.tmassistantbase.c.b.b().a(i, str3);
    }

    public void a(long j) {
        if (0 == j) {
            this.h = 0L;
        }
        this.i = j;
        com.tencent.tmdownloader.internal.b.a.a().a(this);
    }

    public void a(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(str, "--------dump DownloadInfo-----------");
        com.tencent.tmassistantbase.util.TMLog.i(str, "mContentType: " + this.f1133a);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mURL: " + this.b);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mBakUrl: " + this.K);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mTotalBytes: " + this.i);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mUUID: " + this.d);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mStatus: " + this.g);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mReceivedBytes: " + this.h);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mFileName: " + this.j);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mFileSize:" + this.J);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mDownloadFailedErrCode: " + this.m);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mNetType:" + this.n);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mDownloadFailedTime:" + this.o);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mHeaderParamString:" + this.q);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mAppid:" + this.r + " mpackageName:" + this.s + " mVersioncode:" + this.t + " via:" + this.z);
        com.tencent.tmassistantbase.util.TMLog.i(str, "mChannelid:" + this.A + " traceId:" + this.B + " extraData:" + this.C + " downloadType:" + this.D);
    }

    public void a(java.util.HashMap map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.p = map;
        this.q = new org.json.JSONObject(map).toString();
    }

    boolean a() {
        long j = this.i;
        return j != 0 && this.h == j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.tencent.hlyyb.downloader.DownloaderTask b(java.lang.String str) {
        java.util.List<com.tencent.hlyyb.downloader.DownloaderTask> incompleteTasks = com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).getIncompleteTasks();
        synchronized (this.M) {
            for (com.tencent.hlyyb.downloader.DownloaderTask downloaderTask : incompleteTasks) {
                if (downloaderTask.getId().equals(str)) {
                    return downloaderTask;
                }
            }
            return null;
        }
    }

    public void b(long j) {
        this.h = j;
        com.tencent.tmdownloader.internal.downloadservice.f.a().a(this.b, this.h, this.i);
    }

    boolean b() {
        int i = this.g;
        return (i <= 3 || i == 6 || i == 5) ? false : true;
    }

    public int c() {
        com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory;
        java.util.HashMap map;
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "url: " + this.b);
        if (!android.text.TextUtils.isEmpty(this.q) && ((map = this.p) == null || map.size() <= 0)) {
            java.util.HashMap map2 = new java.util.HashMap();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(this.q);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    map2.put(next, jSONObject.getString(next));
                }
                if (map2.size() > 0) {
                    this.p = map2;
                }
            } catch (org.json.JSONException e) {
                com.tencent.tmassistantbase.util.TMLog.w("_DownloadInfo", "exception: ", e);
                e.printStackTrace();
            }
        }
        if (this.e) {
            return 5;
        }
        if (this.j == null) {
            this.j = com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK.equals(this.f1133a) ? com.tencent.tmdownloader.internal.downloadservice.c.b(this.b) : com.tencent.tmdownloader.internal.downloadservice.c.a(this.b, this.f1133a);
        }
        if (this.k == null) {
            this.k = com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK.equals(this.f1133a) ? com.tencent.tmdownloader.internal.downloadservice.c.b(this.b) : com.tencent.tmdownloader.internal.downloadservice.c.a(this.b, this.f1133a);
        }
        if (this.i == 0) {
            new com.tencent.tmdownloader.internal.b.b(this.k, this.j).b();
        }
        if (this.g == 5) {
            this.c = this.b;
        }
        if (!android.text.TextUtils.isEmpty(this.j)) {
            com.tencent.tmdownloader.internal.b.b bVar = new com.tencent.tmdownloader.internal.b.b(this.k, this.j);
            long jC = bVar.c();
            com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "FileLen: " + jC + " filename: " + this.j);
            if (jC > this.i) {
                bVar.b();
                this.h = 0L;
            } else {
                this.h = jC;
            }
            if (a()) {
                bVar.e();
                a(4);
                return 4;
            }
        }
        if (this.g == 5) {
            this.g = 0;
            this.m = 0;
        }
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "startDownloadIfReady...");
        a("_DownloadInfo");
        com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskB = b(this.b);
        if (downloaderTaskB != null) {
            com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest getIncompleteTask dt = " + downloaderTaskB + ",download %=" + downloaderTaskB.getPercentage());
            com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest getIncompleteTask dt = " + downloaderTaskB + ",download length=" + downloaderTaskB.getReceivedLength());
        } else {
            com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskC = c(this.b);
            if (downloaderTaskC != null) {
                java.io.File file = new java.io.File(downloaderTaskC.getRealSaveName());
                if (!com.tencent.tmdownloader.internal.downloadservice.c.b(this.b, this.f1133a) && !file.exists()) {
                    f();
                }
            }
        }
        if (downloaderTaskB == null) {
            try {
                com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskCreateNewTask = this.J > 0 ? com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).createNewTask(this.b, com.tencent.tmdownloader.internal.b.b.b(this.j), this.j, this.N, this.J, null) : com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).createNewTask(this.b, com.tencent.tmdownloader.internal.b.b.b(this.j), this.j, this.N);
                downloaderTaskCreateNewTask.setAppId(this.r + "");
                downloaderTaskCreateNewTask.setPauseTaskOnMobile(false);
                downloaderTaskCreateNewTask.setId(this.b);
                if (this.z != null && !android.text.TextUtils.isEmpty(this.z) && this.z.contains("ANDROIDQQ.GAME.DETAIL")) {
                    java.lang.String strJ = com.tencent.tmassistantbase.util.k.a().j();
                    java.lang.String str = "_" + com.tencent.tmassistantbase.util.k.a().i() + "_" + strJ;
                    com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).setQua1(this.z + str);
                }
                if (this.z == null || android.text.TextUtils.isEmpty(this.z)) {
                    downloaderTaskCategory = com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultEase;
                } else {
                    downloaderTaskCreateNewTask.setAppScene(this.z);
                    downloaderTaskCategory = com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultMass;
                }
                downloaderTaskCreateNewTask.setCategory(downloaderTaskCategory);
                com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).addNewTask(downloaderTaskCreateNewTask);
                com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest createNewTask mURL=" + this.b + ",saveFilePath=" + com.tencent.tmdownloader.internal.b.b.a(this.j) + ",fileName=" + this.j + ",mFileSize=" + this.J);
            } catch (java.lang.Exception e2) {
                com.tencent.tmassistantbase.util.TMLog.e("_DownloadInfo", "startDownloadIfReady HalleyAgent createNewTask Exception", e2);
            }
            a(1);
        } else {
            try {
                downloaderTaskB.setPauseTaskOnMobile(false);
                downloaderTaskB.resume();
                a(1);
            } catch (com.tencent.hlyyb.common.HalleyException e3) {
                e3.printStackTrace();
            }
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.tencent.hlyyb.downloader.DownloaderTask c(java.lang.String str) {
        java.util.List<com.tencent.hlyyb.downloader.DownloaderTask> allTasks = com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).getAllTasks();
        synchronized (this.M) {
            for (com.tencent.hlyyb.downloader.DownloaderTask downloaderTask : allTasks) {
                if (downloaderTask.getId().equals(str)) {
                    return downloaderTask;
                }
            }
            return null;
        }
    }

    public void d() {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "DownloadInfo::pauseDownload url: " + this.b);
        com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskB = b(this.b);
        if (downloaderTaskB == null) {
            com.tencent.tmassistantbase.util.TMLog.w("_DownloadInfo", "DownloadInfo::pauseDownload task == null");
        } else {
            downloaderTaskB.pause();
            a(3);
        }
    }

    public void e() {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "DownloadInfo::stopDownload url: " + this.b);
        com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskB = b(this.b);
        if (downloaderTaskB == null) {
            com.tencent.tmassistantbase.util.TMLog.w("_DownloadInfo", "DownloadInfo::stopDownload task == null");
        } else {
            com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).deleteTask(downloaderTaskB, false);
            a(6);
        }
    }

    public void f() {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "DownloadInfo::deleteDownload url: " + this.b + ",mFileName: " + this.j);
        com.tencent.hlyyb.downloader.DownloaderTask downloaderTaskC = c(this.b);
        java.lang.String realSaveName = downloaderTaskC.getRealSaveName();
        java.lang.String strA = com.tencent.tmdownloader.internal.b.b.a(realSaveName);
        if (strA != null) {
            java.io.File file = new java.io.File(strA);
            if (file.exists()) {
                file.delete();
            }
        }
        java.lang.String str = this.j;
        if (str != null && realSaveName != str) {
            new com.tencent.tmdownloader.internal.b.b(this.k, str).a();
        }
        com.tencent.hlyyb.HalleyAgent.getDownloader(com.tencent.tmdownloader.internal.downloadservice.a.e).deleteTask(downloaderTaskC, true);
        a(6);
    }
}
