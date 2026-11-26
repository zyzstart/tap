package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.open.a.g f691a;
    protected android.os.HandlerThread e;
    protected android.os.Handler f;
    protected java.util.Random b = new java.util.Random();
    protected java.util.List d = java.util.Collections.synchronizedList(new java.util.ArrayList());
    protected java.util.List c = java.util.Collections.synchronizedList(new java.util.ArrayList());
    protected java.util.concurrent.Executor g = com.tencent.open.utils.j.b();
    protected java.util.concurrent.Executor h = com.tencent.open.utils.j.b();

    private g() {
        this.e = null;
        if (this.e == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new android.os.Handler(this.e.getLooper()) { // from class: com.tencent.open.a.g.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i = message.what;
                if (i == 1000) {
                    com.tencent.open.a.g.this.b();
                } else if (i == 1001) {
                    com.tencent.open.a.g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized com.tencent.open.a.g a() {
        if (f691a == null) {
            f691a = new com.tencent.open.a.g();
        }
        return f691a;
    }

    protected int a(int i) {
        if (i == 0) {
            int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(final android.os.Bundle bundle, java.lang.String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new java.lang.Runnable() { // from class: com.tencent.open.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        java.lang.String strK = com.tencent.open.utils.l.k(com.tencent.open.a.c.b(com.tencent.open.utils.f.a()));
                        java.lang.String strK2 = com.tencent.open.utils.l.k(com.tencent.open.a.c.c(com.tencent.open.utils.f.a()));
                        java.lang.String strK3 = com.tencent.open.utils.l.k(com.tencent.open.a.c.a());
                        java.lang.String strK4 = com.tencent.open.utils.l.k(com.tencent.open.a.c.d(com.tencent.open.utils.f.a()));
                        android.os.Bundle bundle2 = new android.os.Bundle();
                        bundle2.putString("uin", "1000");
                        bundle2.putString("imei", strK);
                        bundle2.putString("imsi", strK2);
                        bundle2.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE, strK4);
                        bundle2.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_MAC, strK3);
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", android.os.Build.VERSION.RELEASE);
                        bundle2.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_POSITION, "");
                        bundle2.putString("network", com.tencent.open.a.a.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("language", com.tencent.open.a.c.b());
                        bundle2.putString("resolution", com.tencent.open.a.c.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("apn", com.tencent.open.a.a.b(com.tencent.open.utils.f.a()));
                        bundle2.putString("model_name", android.os.Build.MODEL);
                        bundle2.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_TIME_ZONE, java.util.TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", com.tencent.open.utils.l.d(com.tencent.open.utils.f.a(), "com.qzone"));
                        bundle2.putString("qq_ver", com.tencent.open.utils.l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                        bundle2.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.QUA, com.tencent.open.utils.l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.f.b());
                        bundle2.putString("app_ver", com.tencent.open.utils.l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        com.tencent.open.a.g.this.d.add(new com.tencent.open.a.b(bundle2));
                        int size = com.tencent.open.a.g.this.d.size();
                        int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = 10000;
                        }
                        if (!com.tencent.open.a.g.this.a("report_via", size) && !z) {
                            if (com.tencent.open.a.g.this.f.hasMessages(1001)) {
                                return;
                            }
                            android.os.Message messageObtain = android.os.Message.obtain();
                            messageObtain.what = 1001;
                            com.tencent.open.a.g.this.f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        com.tencent.open.a.g.this.e();
                        com.tencent.open.a.g.this.f.removeMessages(1001);
                    } catch (java.lang.Exception e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(java.lang.String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(final java.lang.String str, final long j, final long j2, final long j3, final int i, final java.lang.String str2, final boolean z) {
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new java.lang.Runnable() { // from class: com.tencent.open.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - j;
                        android.os.Bundle bundle = new android.os.Bundle();
                        java.lang.String strA = com.tencent.open.a.a.a(com.tencent.open.utils.f.a());
                        bundle.putString("apn", strA);
                        bundle.putString("appid", "1000067");
                        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.COMMAND_ID, str);
                        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, str2);
                        bundle.putString("deviceInfo", "network=" + strA + "&sdcard=" + (android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0) + "&wifi=" + com.tencent.open.a.a.e(com.tencent.open.utils.f.a()));
                        int i2 = 100;
                        int iA = 100 / com.tencent.open.a.g.this.a(i);
                        if (iA <= 0) {
                            i2 = 1;
                        } else if (iA <= 100) {
                            i2 = iA;
                        }
                        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.FREQUENCY, i2 + "");
                        bundle.putString("reqSize", j2 + "");
                        bundle.putString("resultCode", i + "");
                        bundle.putString("rspSize", j3 + "");
                        bundle.putString("timeCost", jElapsedRealtime + "");
                        bundle.putString("uin", "1000");
                        com.tencent.open.a.g.this.c.add(new com.tencent.open.a.b(bundle));
                        int size = com.tencent.open.a.g.this.c.size();
                        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportTimeInterval");
                        if (iA2 == 0) {
                            iA2 = 10000;
                        }
                        if (com.tencent.open.a.g.this.a("report_cgi", size) || z) {
                            com.tencent.open.a.g.this.b();
                            com.tencent.open.a.g.this.f.removeMessages(1000);
                        } else if (!com.tencent.open.a.g.this.f.hasMessages(1000)) {
                            android.os.Message messageObtain = android.os.Message.obtain();
                            messageObtain.what = 1000;
                            com.tencent.open.a.g.this.f.sendMessageDelayed(messageObtain, iA2);
                        }
                    } catch (java.lang.Exception e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(final java.lang.String str, final java.lang.String str2, final android.os.Bundle bundle, final boolean z) {
        com.tencent.open.utils.j.a(new java.lang.Runnable() { // from class: com.tencent.open.a.g.6
            /* JADX WARN: Code duplicated, block: B:106:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:115:0x013f A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:124:? A[LOOP:0: B:21:0x0096->B:124:?, LOOP_END, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:68:0x011e A[Catch: Exception -> 0x0122, PHI: r5 r7
  0x011e: PHI (r5v13 boolean) = (r5v11 boolean), (r5v14 boolean) binds: [B:77:0x0133, B:67:0x011c] A[DONT_GENERATE, DONT_INLINE]
  0x011e: PHI (r7v6 org.apache.http.HttpEntity) = (r7v5 org.apache.http.HttpEntity), (r7v9 org.apache.http.HttpEntity) binds: [B:77:0x0133, B:67:0x011c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #14 {Exception -> 0x0122, blocks: (B:66:0x0118, B:68:0x011e, B:76:0x012f), top: B:108:0x0118, outer: #0 }] */
            /* JADX WARN: Code duplicated, block: B:82:0x0141  */
            /* JADX WARN: Code duplicated, block: B:84:0x0149  */
            /* JADX WARN: Code duplicated, block: B:89:0x0156 A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #13 {Exception -> 0x015a, blocks: (B:87:0x0150, B:89:0x0156), top: B:106:0x0150, outer: #0 }] */
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                org.apache.http.client.methods.HttpUriRequest httpGet;
                org.apache.http.HttpResponse httpResponseExecute;
                org.apache.http.HttpEntity entity;
                java.lang.String str3;
                java.lang.String str4;
                org.apache.http.HttpEntity entity2;
                org.apache.http.HttpEntity entity3;
                try {
                    if (bundle == null) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                        return;
                    }
                    int iA = com.tencent.open.a.e.a();
                    if (iA == 0) {
                        iA = 3;
                    }
                    com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                    org.apache.http.HttpResponse httpResponse = null;
                    org.apache.http.client.HttpClient httpClient = com.tencent.open.utils.HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, str);
                    java.lang.String strEncodeUrl = com.tencent.open.utils.HttpUtils.encodeUrl(bundle);
                    if (z) {
                        strEncodeUrl = java.net.URLEncoder.encode(strEncodeUrl);
                    }
                    if (str2.toUpperCase().equals(com.tencent.connect.common.Constants.HTTP_GET)) {
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
                        stringBuffer.append(strEncodeUrl);
                        httpGet = new org.apache.http.client.methods.HttpGet(stringBuffer.toString());
                    } else if (!str2.toUpperCase().equals(com.tencent.connect.common.Constants.HTTP_POST)) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                        return;
                    } else {
                        org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(str);
                        httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(com.tencent.open.utils.l.i(strEncodeUrl)));
                        httpGet = httpPost;
                    }
                    httpGet.addHeader("Accept-Encoding", "gzip");
                    httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    int i = 0;
                    boolean z2 = false;
                    while (true) {
                        i++;
                        try {
                            try {
                                try {
                                    httpResponseExecute = httpClient.execute(httpGet);
                                    try {
                                        int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                                        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                                        if (statusCode != 200) {
                                            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                        } else {
                                            try {
                                                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                                                z2 = true;
                                            } catch (java.net.SocketTimeoutException e) {
                                                e = e;
                                                z2 = true;
                                                try {
                                                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                                    if (httpResponseExecute != null) {
                                                        try {
                                                            entity3 = httpResponseExecute.getEntity();
                                                            if (entity3 != null) {
                                                                entity3.consumeContent();
                                                            }
                                                        } catch (java.lang.Exception e2) {
                                                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e2);
                                                        }
                                                    }
                                                    if (i >= iA) {
                                                    }
                                                } catch (java.lang.Throwable th) {
                                                    th = th;
                                                    if (httpResponseExecute != null) {
                                                        try {
                                                            entity = httpResponseExecute.getEntity();
                                                            if (entity != null) {
                                                                entity.consumeContent();
                                                            }
                                                        } catch (java.lang.Exception e3) {
                                                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e3);
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (org.apache.http.conn.ConnectTimeoutException e4) {
                                                e = e4;
                                                z2 = true;
                                                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException:", e);
                                                if (httpResponseExecute != null && (entity3 = httpResponseExecute.getEntity()) != null) {
                                                    entity3.consumeContent();
                                                }
                                                if (i >= iA) {
                                                }
                                            } catch (java.lang.Exception e5) {
                                                e = e5;
                                                httpResponse = httpResponseExecute;
                                                z2 = true;
                                                com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e);
                                                if (httpResponse != null && (entity2 = httpResponse.getEntity()) != null) {
                                                }
                                                if (z2) {
                                                    str3 = "openSDK_LOG.ReportManager";
                                                    str4 = "-->ReportCenter httpRequest Thread request success";
                                                } else {
                                                    str3 = "openSDK_LOG.ReportManager";
                                                    str4 = "-->ReportCenter httpRequest Thread request failed";
                                                }
                                                com.tencent.open.log.SLog.d(str3, str4);
                                                return;
                                            }
                                        }
                                        if (httpResponseExecute != null && (entity2 = httpResponseExecute.getEntity()) != null) {
                                            entity2.consumeContent();
                                        }
                                    } catch (java.net.SocketTimeoutException e6) {
                                        e = e6;
                                    } catch (org.apache.http.conn.ConnectTimeoutException e7) {
                                        e = e7;
                                    } catch (java.lang.Exception e8) {
                                        e = e8;
                                        httpResponse = httpResponseExecute;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    httpResponseExecute = httpResponse;
                                    if (httpResponseExecute != null) {
                                        entity = httpResponseExecute.getEntity();
                                        if (entity != null) {
                                            entity.consumeContent();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (java.net.SocketTimeoutException e9) {
                                e = e9;
                                httpResponseExecute = null;
                            } catch (org.apache.http.conn.ConnectTimeoutException e10) {
                                e = e10;
                                httpResponseExecute = null;
                            } catch (java.lang.Exception e11) {
                                e = e11;
                            }
                        } catch (java.lang.Exception e12) {
                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e12);
                        }
                        if (z2) {
                            str3 = "openSDK_LOG.ReportManager";
                            str4 = "-->ReportCenter httpRequest Thread request success";
                        } else {
                            str3 = "openSDK_LOG.ReportManager";
                            str4 = "-->ReportCenter httpRequest Thread request failed";
                        }
                        com.tencent.open.log.SLog.d(str3, str4);
                        return;
                    }
                } catch (java.lang.Exception e13) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e13);
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0033  */
    protected boolean a(java.lang.String str, int i) {
        int iA;
        if (str.equals("report_cgi")) {
            iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_CGIReportMaxcount");
            if (iA == 0) {
                iA = 5;
            }
        } else if (str.equals("report_via")) {
            iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Agent_ReportBatchCount");
            if (iA == 0) {
                iA = 5;
            }
        } else {
            iA = 0;
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + iA);
        return i >= iA;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0056 A[PHI: r4
  0x0056: PHI (r4v6 int) = (r4v2 int), (r4v8 int) binds: [B:9:0x003e, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x0059 A[PHI: r4
  0x0059: PHI (r4v5 int) = (r4v2 int), (r4v8 int) binds: [B:9:0x003e, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    protected boolean a(java.lang.String str, java.lang.String str2) {
        int iA;
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                iA = a(java.lang.Integer.parseInt(str2));
                if (this.b.nextInt(100) < iA) {
                    i = iA;
                    z = true;
                } else {
                    i = iA;
                }
            } catch (java.lang.Exception unused) {
                return false;
            }
        } else if (str.equals("report_via")) {
            iA = com.tencent.open.a.e.a(str2);
            if (this.b.nextInt(100) < iA) {
                i = iA;
                z = true;
            } else {
                i = iA;
            }
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    protected void b() {
        this.h.execute(new java.lang.Runnable() { // from class: com.tencent.open.a.g.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    android.os.Bundle bundleC = com.tencent.open.a.g.this.c();
                    if (bundleC == null) {
                        return;
                    }
                    int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_HttpRetryCount");
                    if (iA == 0) {
                        iA = 3;
                    }
                    com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + iA);
                    boolean z = false;
                    int i = 0;
                    do {
                        i++;
                        try {
                            org.apache.http.client.HttpClient httpClient = com.tencent.open.utils.HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, com.tencent.ysdk.shell.module.report.impl.HaboReportModule.URL_REPORT_CGI);
                            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.URL_REPORT_CGI);
                            httpPost.addHeader("Accept-Encoding", "gzip");
                            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                            httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(com.tencent.open.utils.l.i(com.tencent.open.utils.HttpUtils.encodeUrl(bundleC))));
                            int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                            if (statusCode != 200) {
                                break;
                            }
                            com.tencent.open.a.f.a().b("report_cgi");
                            z = true;
                            break;
                        } catch (java.net.SocketTimeoutException e) {
                            e = e;
                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                        } catch (org.apache.http.conn.ConnectTimeoutException e2) {
                            e = e2;
                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                        } catch (java.lang.Exception e3) {
                            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                        }
                    } while (i < iA);
                    if (!z) {
                        com.tencent.open.a.f.a().a("report_cgi", com.tencent.open.a.g.this.c);
                    }
                    com.tencent.open.a.g.this.c.clear();
                } catch (java.lang.Exception e4) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e4);
                }
            }
        });
    }

    protected android.os.Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.c.get(0);
        if (bVar == null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        java.lang.String str = (java.lang.String) bVar.f687a.get("appid");
        java.util.List listA = com.tencent.open.a.f.a().a("report_cgi");
        if (listA != null) {
            this.c.addAll(listA);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.SDK_VERSION, com.tencent.connect.common.Constants.SDK_VERSION_REPORT);
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, android.os.Build.DEVICE);
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.QUA, com.tencent.connect.common.Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                com.tencent.open.a.b bVar2 = (com.tencent.open.a.b) this.c.get(i);
                bundle.putString(i + "_1", (java.lang.String) bVar2.f687a.get("apn"));
                bundle.putString(i + "_2", (java.lang.String) bVar2.f687a.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.FREQUENCY));
                bundle.putString(i + "_3", (java.lang.String) bVar2.f687a.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.COMMAND_ID));
                bundle.putString(i + "_4", (java.lang.String) bVar2.f687a.get("resultCode"));
                bundle.putString(i + "_5", (java.lang.String) bVar2.f687a.get("timeCost"));
                bundle.putString(i + "_6", (java.lang.String) bVar2.f687a.get("reqSize"));
                bundle.putString(i + "_7", (java.lang.String) bVar2.f687a.get("rspSize"));
                bundle.putString(i + "_8", (java.lang.String) bVar2.f687a.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL));
                bundle.putString(i + "_9", (java.lang.String) bVar2.f687a.get("uin"));
                bundle.putString(i + "_10", com.tencent.open.a.c.e(com.tencent.open.utils.f.a()) + "&" + ((java.lang.String) bVar2.f687a.get("deviceInfo")));
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected android.os.Bundle d() {
        java.util.List listA = com.tencent.open.a.f.a().a("report_via");
        if (listA != null) {
            this.d.addAll(listA);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (java.io.Serializable serializable : this.d) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.tencent.open.a.b bVar = (com.tencent.open.a.b) serializable;
            for (java.lang.String str : bVar.f687a.keySet()) {
                try {
                    java.lang.String str2 = (java.lang.String) bVar.f687a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (org.json.JSONException e) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        android.os.Bundle bundle = new android.os.Bundle();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, jSONArray);
            bundle.putString(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, jSONObject2.toString());
            return bundle;
        } catch (org.json.JSONException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new java.lang.Runnable() { // from class: com.tencent.open.a.g.5
            @Override // java.lang.Runnable
            public void run() {
                int i;
                try {
                    android.os.Bundle bundleD = com.tencent.open.a.g.this.d();
                    if (bundleD == null) {
                        return;
                    }
                    com.tencent.open.log.SLog.v("openSDK_LOG.ReportManager", "-->doReportVia, params: " + bundleD.toString());
                    int iA = com.tencent.open.a.e.a();
                    long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                    int i2 = 0;
                    boolean z = false;
                    long j = 0;
                    long j2 = 0;
                    int errorCodeFromException = 0;
                    do {
                        int i3 = i2 + 1;
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            com.tencent.open.utils.l.a aVarOpenUrl2 = com.tencent.open.utils.HttpUtils.openUrl2(com.tencent.open.utils.f.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", com.tencent.connect.common.Constants.HTTP_POST, bundleD);
                                            try {
                                                i = com.tencent.open.utils.l.d(aVarOpenUrl2.f734a).getInt("ret");
                                            } catch (org.json.JSONException unused) {
                                                i = -4;
                                            }
                                            if (i == 0 || !android.text.TextUtils.isEmpty(aVarOpenUrl2.f734a)) {
                                                i3 = iA;
                                                z = true;
                                            }
                                            j = aVarOpenUrl2.b;
                                            j2 = aVarOpenUrl2.c;
                                            i2 = i3;
                                        } catch (org.json.JSONException unused2) {
                                            i2 = i3;
                                            j = 0;
                                            j2 = 0;
                                            errorCodeFromException = -4;
                                        }
                                    } catch (org.apache.http.conn.ConnectTimeoutException unused3) {
                                        jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                                        i2 = i3;
                                        j = 0;
                                        j2 = 0;
                                        errorCodeFromException = -7;
                                    }
                                } catch (java.io.IOException e) {
                                    errorCodeFromException = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(e);
                                    i2 = i3;
                                    j = 0;
                                    j2 = 0;
                                }
                            } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e2) {
                                try {
                                    errorCodeFromException = java.lang.Integer.parseInt(e2.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                } catch (java.lang.Exception unused4) {
                                }
                            } catch (java.net.SocketTimeoutException unused5) {
                                jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                                i2 = i3;
                                j = 0;
                                j2 = 0;
                                errorCodeFromException = -8;
                            }
                        } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException unused6) {
                            com.tencent.open.a.g.this.d.clear();
                            com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                            return;
                        } catch (java.lang.Exception unused7) {
                            i2 = iA;
                            j = 0;
                            j2 = 0;
                            errorCodeFromException = -6;
                        }
                    } while (i2 < iA);
                    int i4 = errorCodeFromException;
                    long j3 = j;
                    com.tencent.open.a.g.this.a("mapp_apptrace_sdk", jElapsedRealtime, j3, j2, i4, null, false);
                    if (z) {
                        com.tencent.open.a.f.a().b("report_via");
                    } else {
                        com.tencent.open.a.f.a().a("report_via", com.tencent.open.a.g.this.d);
                    }
                    com.tencent.open.a.g.this.d.clear();
                    com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                } catch (java.lang.Exception e3) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                }
            }
        });
    }
}
