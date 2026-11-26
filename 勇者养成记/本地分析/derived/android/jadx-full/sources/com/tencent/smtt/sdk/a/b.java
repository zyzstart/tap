package com.tencent.smtt.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f904a;

    static {
        try {
            f904a = "65dRa93L".getBytes(com.unisound.b.f.b);
        } catch (java.io.UnsupportedEncodingException unused) {
        }
    }

    private static java.lang.String a(android.content.Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
                messageDigest.update(byteArray);
                byte[] bArrDigest = messageDigest.digest();
                if (bArrDigest != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("");
                    if (bArrDigest != null && bArrDigest.length > 0) {
                        for (int i = 0; i < bArrDigest.length; i++) {
                            java.lang.String upperCase = java.lang.Integer.toHexString(bArrDigest[i] & 255).toUpperCase();
                            if (i > 0) {
                                sb.append(":");
                            }
                            if (upperCase.length() < 2) {
                                sb.append(0);
                            }
                            sb.append(upperCase);
                        }
                        return sb.toString();
                    }
                    return null;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(final a.a aVar, final android.content.Context context) {
        new java.lang.Thread("HttpUtils") { // from class: com.tencent.smtt.sdk.a.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                java.lang.StringBuilder sb;
                com.tencent.smtt.utils.b.b(context, aVar.f);
                aVar.l = com.tencent.smtt.utils.b.a();
                if (android.os.Build.VERSION.SDK_INT < 8) {
                    return;
                }
                org.json.JSONObject jSONObjectC = null;
                if (com.tencent.smtt.sdk.a.b.f904a == null) {
                    try {
                        com.tencent.smtt.sdk.a.b.f904a = "65dRa93L".getBytes(com.unisound.b.f.b);
                    } catch (java.io.UnsupportedEncodingException unused) {
                        com.tencent.smtt.sdk.a.b.f904a = null;
                        com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (com.tencent.smtt.sdk.a.b.f904a == null) {
                    com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                    return;
                }
                java.lang.String string = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "[REDACTED]");
                java.lang.String strSubstring = "";
                java.lang.String strSubstring2 = "";
                if (!android.text.TextUtils.isEmpty(string)) {
                    strSubstring = string.substring(0, string.indexOf("&"));
                    strSubstring2 = string.substring(string.indexOf("&") + 1, string.length());
                }
                boolean z = android.text.TextUtils.isEmpty(strSubstring) || strSubstring.length() != 96 || android.text.TextUtils.isEmpty(strSubstring2) || strSubstring2.length() != 24;
                try {
                    com.tencent.smtt.utils.n nVarA = com.tencent.smtt.utils.n.a();
                    if (z) {
                        sb = new java.lang.StringBuilder();
                        sb.append(nVarA.b());
                        sb.append(com.tencent.smtt.utils.h.a().b());
                    } else {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(nVarA.f());
                        sb2.append(strSubstring);
                        sb = sb2;
                    }
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(sb.toString()).openConnection();
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(cn.yunzhisheng.asr.a.b);
                    if (android.os.Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty("Connection", cn.yunzhisheng.asr.JniUscClient.s);
                    }
                    try {
                        jSONObjectC = com.tencent.smtt.sdk.a.b.c(aVar, context);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    if (jSONObjectC == null) {
                        com.tencent.smtt.utils.TbsLog.e("sdkreport", "post -- jsonData is null!");
                        return;
                    }
                    try {
                        byte[] bytes = jSONObjectC.toString().getBytes(com.unisound.b.f.b);
                        byte[] bArrA = z ? com.tencent.smtt.utils.h.a().a(bytes) : com.tencent.smtt.utils.h.a(bytes, strSubstring2);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bArrA.length));
                        try {
                            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bArrA);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                com.tencent.smtt.utils.TbsLog.i("sdkreport", "Post successful!");
                                com.tencent.smtt.utils.TbsLog.i("sdkreport", "SIGNATURE is " + jSONObjectC.getString("SIGNATURE"));
                                com.tencent.smtt.sdk.a.b.b(context, com.tencent.smtt.sdk.a.b.b(httpURLConnection, strSubstring2, z));
                                new com.tencent.smtt.sdk.TbsDownloadUpload(context).clearUploadCode();
                                return;
                            }
                            com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.PV_UPLOAD_ERROR);
                            tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        } catch (java.lang.Throwable th) {
                            com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.PV_UPLOAD_ERROR);
                            tbsLogInfo2.setFailDetail(th);
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                        }
                    } catch (java.lang.Throwable unused2) {
                    }
                } catch (java.io.IOException e2) {
                    com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- IOException:" + e2);
                } catch (java.lang.AssertionError e3) {
                    com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e3);
                } catch (java.lang.NoClassDefFoundError e4) {
                    com.tencent.smtt.utils.TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e4);
                }
            }
        }.start();
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if ("reset".equals(str) && com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON.equals(str2)) {
            com.tencent.smtt.sdk.QbSdk.reset(context);
        } else {
            com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).putData(str, str2);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z, long j, boolean z2) {
        if (com.tencent.smtt.sdk.QbSdk.getSettings() != null && com.tencent.smtt.sdk.QbSdk.getSettings().containsKey(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && com.tencent.smtt.sdk.QbSdk.getSettings().get(com.tencent.smtt.sdk.QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            com.tencent.smtt.utils.TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        java.lang.String str4 = "";
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!android.text.TextUtils.isEmpty(com.tencent.smtt.sdk.QbSdk.getQQBuildNumber())) {
                    str4 = str4 + "." + com.tencent.smtt.sdk.QbSdk.getQQBuildNumber();
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            a.a aVar = new a.a();
            aVar.b = context.getApplicationContext().getApplicationInfo().packageName;
            com.tencent.smtt.utils.n.a(context);
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+08"));
            aVar.c = simpleDateFormat.format(java.util.Calendar.getInstance().getTime());
            aVar.k = com.tencent.smtt.utils.b.b(context);
            java.lang.String strA = com.tencent.smtt.utils.b.a(context, com.tencent.smtt.sdk.TbsDownloader.TBS_METADATA);
            if (!android.text.TextUtils.isEmpty(strA)) {
                aVar.j = strA;
            }
            aVar.f = str;
            if (z) {
                aVar.d = str2;
            } else {
                aVar.d = com.tencent.smtt.utils.l.a(context);
            }
            aVar.e = str3;
            java.lang.String strF = com.tencent.smtt.utils.b.f(context);
            java.lang.String strD = com.tencent.smtt.utils.b.d(context);
            java.lang.String strE = com.tencent.smtt.utils.b.e(context);
            java.lang.String strG = com.tencent.smtt.utils.b.g(context);
            if (strD != null && !"".equals(strD)) {
                aVar.g = strD;
            }
            if (strE != null && !"".equals(strE)) {
                aVar.h = strE;
            }
            if (!android.text.TextUtils.isEmpty(strG)) {
                aVar.q = strG;
            }
            if (strF != null && !"".equals(strF)) {
                aVar.i = strF;
            }
            aVar.m = i;
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                aVar.n = z ? 1 : 0;
                if (z && z2) {
                    aVar.n = 3;
                }
            } else if (z) {
                if (com.tencent.smtt.sdk.TbsShareManager.getCoreFormOwn()) {
                    aVar.n = 2;
                } else {
                    aVar.n = 1;
                }
                if (z2) {
                    aVar.n = 3;
                }
            } else {
                aVar.n = 0;
            }
            aVar.o = str4;
            aVar.p = a(context);
            if (!z) {
                aVar.r = j;
                aVar.s = com.tencent.smtt.sdk.QbSdk.getTbsVersion(context);
            }
            a(aVar, context.getApplicationContext());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.InputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String b(java.net.HttpURLConnection httpURLConnection, java.lang.String str, boolean z) throws java.lang.Throwable {
        java.lang.Exception e;
        java.lang.String str2 = "";
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    java.io.InputStream inputStream = httpURLConnection.getInputStream();
                    java.lang.String contentEncoding = httpURLConnection.getContentEncoding();
                    if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                        httpURLConnection = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream : new java.util.zip.InflaterInputStream(inputStream, new java.util.zip.Inflater(true));
                    } else {
                        httpURLConnection = new java.util.zip.GZIPInputStream(inputStream);
                    }
                    try {
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[128];
                            while (true) {
                                int i = httpURLConnection.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                            if (z) {
                                byte[] bArrC = com.tencent.smtt.utils.h.a().c(byteArrayOutputStream.toByteArray());
                                str2 = new java.lang.String(bArrC);
                                r1 = bArrC;
                            } else {
                                java.lang.String str3 = new java.lang.String(com.tencent.smtt.utils.h.b(byteArrayOutputStream.toByteArray(), str));
                                str2 = str3;
                                r1 = str3;
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            if (httpURLConnection != 0) {
                                httpURLConnection.close();
                                str2 = str2;
                                r1 = r1;
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            r1 = byteArrayOutputStream;
                            e.printStackTrace();
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (java.io.IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (httpURLConnection != 0) {
                                httpURLConnection.close();
                                str2 = str2;
                                r1 = r1;
                            }
                            httpURLConnection = "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z;
                            com.tencent.smtt.utils.TbsLog.i("HttpUtils", httpURLConnection);
                            return str2;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            r1 = byteArrayOutputStream;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (java.io.IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (httpURLConnection == 0) {
                                throw th;
                            }
                            try {
                                httpURLConnection.close();
                                throw th;
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception e7) {
                        e = e7;
                    }
                } catch (java.io.IOException e8) {
                    e8.printStackTrace();
                }
            } catch (java.lang.Exception e9) {
                e = e9;
                httpURLConnection = 0;
            } catch (java.lang.Throwable th2) {
                th = th2;
                httpURLConnection = 0;
            }
            httpURLConnection = "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z;
            com.tencent.smtt.utils.TbsLog.i("HttpUtils", httpURLConnection);
            return str2;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, java.lang.String str) {
        try {
            com.tencent.smtt.sdk.TbsPVConfig.releaseInstance();
            com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).clear();
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            for (java.lang.String str2 : str.split(com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.QueryController.QUERY_FIELDS_SPLIT)) {
                try {
                    java.lang.String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        a(context, strArrSplit[0], strArrSplit[1]);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).commit();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static org.json.JSONObject c(a.a aVar, android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("APPNAME", aVar.b);
            jSONObject.put("TIME", aVar.c);
            jSONObject.put("QUA2", aVar.d);
            jSONObject.put("LC", aVar.e);
            jSONObject.put("GUID", aVar.f);
            jSONObject.put("IMEI", aVar.g);
            jSONObject.put("IMSI", aVar.h);
            jSONObject.put("MAC", aVar.i);
            jSONObject.put("PV", aVar.m);
            jSONObject.put("CORETYPE", aVar.n);
            jSONObject.put("APPVN", aVar.o);
            jSONObject.put("APPMETADATA", aVar.j);
            jSONObject.put("VERSION_CODE", aVar.k);
            jSONObject.put("CPU", aVar.l);
            if ("com.tencent.mm".equals(aVar.b) || "com.tencent.mobileqq".equals(aVar.b) || com.tencent.smtt.sdk.TbsConfig.APP_DEMO.equals(aVar.b)) {
                com.tencent.smtt.sdk.TbsDownloadUpload tbsDownloadUpload = new com.tencent.smtt.sdk.TbsDownloadUpload(context);
                tbsDownloadUpload.readTbsDownloadInfo(context);
                jSONObject.put("SIGNATURE", "" + tbsDownloadUpload.getNeedDownloadCode() + ":" + tbsDownloadUpload.getStartDownloadCode() + ":" + tbsDownloadUpload.getNeedDownloadReturn() + ":" + tbsDownloadUpload.getLocalCoreVersion());
            } else {
                if (aVar.p == null) {
                    str = "SIGNATURE";
                    str2 = "0";
                } else {
                    str = "SIGNATURE";
                    str2 = aVar.p;
                }
                jSONObject.put(str, str2);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", aVar.q);
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", com.tencent.smtt.sdk.TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("HOST_COREVERSION", com.tencent.smtt.sdk.TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                jSONObject.put("DECOUPLE_COREVERSION", com.tencent.smtt.sdk.TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
            }
            if (aVar.n == 0) {
                jSONObject.put("WIFICONNECTEDTIME", aVar.r);
                jSONObject.put("CORE_EXIST", aVar.s);
                int i = com.tencent.smtt.sdk.TbsCoreLoadStat.mLoadErrorCode;
                if (aVar.s <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    com.tencent.smtt.utils.TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).uploadDownloadInterruptCodeIfNeeded(context);
            try {
                if (com.tencent.smtt.sdk.QbSdk.getTID() != null && (aVar.b.equals("com.tencent.mobileqq") || aVar.b.equals("com.tencent.mm"))) {
                    java.lang.String str3 = "TID";
                    jSONObject.put(str3, com.tencent.smtt.sdk.QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                }
            } catch (java.lang.Exception unused) {
            }
            return jSONObject;
        } catch (java.lang.Exception unused2) {
            com.tencent.smtt.utils.TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }
}
