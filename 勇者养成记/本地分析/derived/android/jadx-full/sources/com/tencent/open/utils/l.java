package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f732a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static int e = -1;
    private static java.lang.String f = "0123456789ABCDEF";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public java.lang.String f734a;
        public long b;
        public long c;

        public a(java.lang.String str, int i) {
            this.f734a = str;
            this.b = i;
            if (str != null) {
                this.c = str.length();
            }
        }
    }

    private static char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static android.graphics.drawable.Drawable a(java.lang.String str, android.content.Context context) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpen;
        java.lang.StringBuilder sb;
        android.graphics.drawable.Drawable drawableCreateFromStream = null;
        if (context == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStreamOpen = context.getAssets().open(str);
            try {
                try {
                    drawableCreateFromStream = android.graphics.drawable.Drawable.createFromStream(inputStreamOpen, str);
                    try {
                        inputStreamOpen.close();
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        sb = new java.lang.StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStreamOpen.close();
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        sb = new java.lang.StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    inputStreamOpen.close();
                } catch (java.lang.Exception e5) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
                }
                throw th;
            }
        } catch (java.io.IOException e6) {
            e = e6;
            inputStreamOpen = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamOpen = null;
            inputStreamOpen.close();
            throw th;
        }
        return drawableCreateFromStream;
    }

    public static android.os.Bundle a(java.lang.String str) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (java.lang.String str2 : str.split("&")) {
                java.lang.String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    bundle.putString(java.net.URLDecoder.decode(strArrSplit[0]), java.net.URLDecoder.decode(strArrSplit[1]));
                }
            }
            return bundle;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.TIME_COST, str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, str9);
        bundle.putString("os_ver", android.os.Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.a.a.a(com.tencent.open.utils.f.a()));
        bundle.putString("apn", com.tencent.open.a.a.b(com.tencent.open.utils.f.a()));
        bundle.putString("model_name", android.os.Build.MODEL);
        bundle.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("packagename", com.tencent.open.utils.f.b());
        bundle.putString("app_ver", d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
        return bundle;
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("openid", str);
        bundle.putString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_REPORT_TYPE, str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString(com.tencent.open.SocialConstants.PARAM_TYPE, str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static final java.lang.String a(android.content.Context context) {
        java.lang.CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static java.lang.String a(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2;
        if (uri == null) {
            return null;
        }
        if (!(android.os.Build.VERSION.SDK_INT >= 19) || !android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            java.lang.String scheme = uri.getScheme();
            if ("content".equals(scheme)) {
                return b(context, uri);
            }
            if ("file".equals(scheme)) {
                return uri.getPath();
            }
            return null;
        }
        java.lang.String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
            java.lang.String str = strArrSplit[0];
            return "primary".equals(str) ? android.os.Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(strArrSplit[1]) : "/storage/".concat(str).concat("/").concat(strArrSplit[1]);
        }
        if ("com.android.providers.downloads.documents".equals(authority)) {
            java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
            return documentId.startsWith("raw:") ? documentId.replaceFirst("raw:", "") : b(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.parseLong(documentId)));
        }
        if ("com.android.providers.media.documents".equals(authority)) {
            java.lang.String[] strArrSplit2 = android.provider.DocumentsContract.getDocumentId(uri).split(":");
            java.lang.String str2 = strArrSplit2[0];
            if ("image".equals(str2)) {
                uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
                uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str2)) {
                uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return b(context, android.content.ContentUris.withAppendedId(uri2, java.lang.Long.parseLong(strArrSplit2[1])));
        }
        return null;
    }

    public static final java.lang.String a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int length = 0;
            while (i2 < str.length()) {
                int i3 = i2 + 1;
                length += str.substring(i2, i3).getBytes(str2).length;
                if (length > i) {
                    java.lang.String strSubstring = str.substring(0, i2);
                    if (android.text.TextUtils.isEmpty(str3)) {
                        return strSubstring;
                    }
                    return strSubstring + str3;
                }
                i2 = i3;
            }
            return str;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static java.lang.String a(java.lang.String str, android.app.Activity activity, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb;
        java.lang.String str3;
        try {
            boolean zN = n(str2);
            com.tencent.open.log.SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + zN + ",hasSDPermission=" + c());
            if (!zN) {
                java.io.File fileA = com.tencent.open.utils.f.a("Images");
                if (fileA != null) {
                    sb = new java.lang.StringBuilder();
                    sb.append(fileA.getAbsolutePath());
                    sb.append(java.io.File.separator);
                    str3 = com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    java.io.File cacheDir = com.tencent.open.utils.f.a().getCacheDir();
                    if (cacheDir == null) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    sb = new java.lang.StringBuilder();
                    sb.append(cacheDir.getAbsolutePath());
                    sb.append(java.io.File.separator);
                    str3 = com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                }
                sb.append(str3);
                java.lang.String string = sb.toString();
                java.io.File file = new java.io.File(str2);
                java.lang.String absolutePath = file.getAbsolutePath();
                java.lang.String str4 = string + java.io.File.separator + file.getName();
                str2 = a(absolutePath, str4) ? str4 : null;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, destAppSpecific is null");
                return null;
            }
            java.io.File file2 = new java.io.File(str2);
            java.lang.String authorities = com.tencent.tauth.Tencent.getAuthorities(str);
            if (!android.text.TextUtils.isEmpty(authorities)) {
                android.net.Uri uriForFile = android.support.v4.content.FileProvider.getUriForFile(activity, authorities, file2);
                activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                return uriForFile.toString();
            }
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, authorities is null");
            if (iUiListener != null) {
                iUiListener.onWarning(-19);
            }
            return null;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    public static java.lang.String a(java.util.Map map, java.lang.String str, java.lang.String str2) {
        if (map == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (map.containsKey(str)) {
            java.lang.Object obj = map.get(str);
            return obj instanceof java.lang.String ? (java.lang.String) obj : str2;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
        return str2;
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            java.lang.String string = java.lang.Integer.toString(b2 & 255, 16);
            if (string.length() == 1) {
                string = "0" + string;
            }
            sb.append(string);
        }
        return sb.toString();
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        if (str != null) {
            for (java.lang.String str2 : str.split("&")) {
                java.lang.String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    try {
                        strArrSplit[0] = java.net.URLDecoder.decode(strArrSplit[0]);
                        strArrSplit[1] = java.net.URLDecoder.decode(strArrSplit[1]);
                    } catch (java.lang.Exception unused) {
                    }
                    try {
                        jSONObject.put(strArrSplit[0], strArrSplit[1]);
                    } catch (org.json.JSONException e2) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a(final android.content.Context context, java.lang.String str, long j, java.lang.String str2) {
        final android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", com.tencent.connect.common.Constants.SDK_VERSION);
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new java.lang.Thread() { // from class: com.tencent.open.utils.l.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.utils.HttpUtils.openUrl2(context, "https://cgi.qplus.com/report/report", com.tencent.connect.common.Constants.HTTP_GET, bundle);
                } catch (java.lang.Exception e2) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "reportBernoulli has exception: " + e2.getMessage());
                }
            }
        }.start();
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(android.net.Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (android.os.Environment.getExternalStorageState().equals("mounted") ? android.os.Environment.getExternalStorageDirectory() : null) != null;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        boolean zG;
        java.lang.String str2;
        java.lang.String str3;
        try {
            zG = g(context);
            if (zG) {
                str2 = com.tencent.smtt.sdk.TbsConfig.APP_QB;
                str3 = "com.tencent.mtt.MainActivity";
            } else {
                str2 = "com.android.browser";
                str3 = "com.android.browser.BrowserActivity";
            }
            try {
                a(context, str2, str3, str);
                return true;
            } catch (java.lang.Exception unused) {
                if (!zG) {
                    try {
                        try {
                            a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        } catch (java.lang.Exception unused2) {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (java.lang.Exception unused3) {
                        return false;
                    }
                }
                try {
                    try {
                        try {
                            a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        } catch (java.lang.Exception unused4) {
                            return false;
                        }
                    } catch (java.lang.Exception unused5) {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    }
                } catch (java.lang.Exception unused6) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            }
        } catch (java.lang.Exception unused7) {
            zG = false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        boolean zA = (android.os.Build.VERSION.SDK_INT >= 19 || context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0) ? a(str, str2) : false;
        com.tencent.open.log.SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + zA);
        return zA;
    }

    public static boolean a(android.content.Context context, boolean z) {
        return (c(context) && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) || com.tencent.open.utils.i.c(context, com.tencent.ydkqmsp.sdk.u.U.BEACON_ID_VERSION) >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007e, code lost:
    
        if (r1 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0098, code lost:
    
        if (r1 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009a, code lost:
    
        r1.close();
        r1 = r1;
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.io.File r4, java.io.File r5) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            if (r2 == 0) goto Lb
            r5.delete()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
        Lb:
            java.io.File r2 = r5.getParentFile()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            if (r2 == 0) goto L22
            java.io.File r2 = r5.getParentFile()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            if (r2 != 0) goto L22
            java.io.File r2 = r5.getParentFile()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            r2.mkdirs()     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
        L22:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L64 java.lang.OutOfMemoryError -> L67 java.io.IOException -> L81
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L60 java.io.IOException -> L62
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L60 java.io.IOException -> L62
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L60 java.io.IOException -> L62
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L60 java.io.IOException -> L62
            r4 = 102400(0x19000, float:1.43493E-40)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L55 java.lang.OutOfMemoryError -> L58 java.io.IOException -> L5b
        L36:
            int r1 = r5.read(r4)     // Catch: java.lang.Throwable -> L55 java.lang.OutOfMemoryError -> L58 java.io.IOException -> L5b
            r3 = -1
            if (r1 == r3) goto L44
            r2.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L55 java.lang.OutOfMemoryError -> L58 java.io.IOException -> L5b
            r2.flush()     // Catch: java.lang.Throwable -> L55 java.lang.OutOfMemoryError -> L58 java.io.IOException -> L5b
            goto L36
        L44:
            r0 = 1
            r2.close()     // Catch: java.io.IOException -> L49
            goto L51
        L49:
            r4 = move-exception
            java.lang.String r1 = "openSDK_LOG.Util"
            java.lang.String r2 = "copyFile error, "
            com.tencent.open.log.SLog.e(r1, r2, r4)
        L51:
            r5.close()     // Catch: java.io.IOException -> L9e
            goto La6
        L55:
            r4 = move-exception
            r1 = r5
            goto La7
        L58:
            r4 = move-exception
            r1 = r5
            goto L69
        L5b:
            r4 = move-exception
            r1 = r5
            goto L83
        L5e:
            r4 = move-exception
            goto La7
        L60:
            r4 = move-exception
            goto L69
        L62:
            r4 = move-exception
            goto L83
        L64:
            r4 = move-exception
            r2 = r1
            goto La7
        L67:
            r4 = move-exception
            r2 = r1
        L69:
            java.lang.String r5 = "openSDK_LOG.Util"
            java.lang.String r3 = "copyFile error, "
            com.tencent.open.log.SLog.e(r5, r3, r4)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.io.IOException -> L76
            goto L7e
        L76:
            r4 = move-exception
            java.lang.String r5 = "openSDK_LOG.Util"
            java.lang.String r2 = "copyFile error, "
            com.tencent.open.log.SLog.e(r5, r2, r4)
        L7e:
            if (r1 == 0) goto La6
            goto L9a
        L81:
            r4 = move-exception
            r2 = r1
        L83:
            java.lang.String r5 = "openSDK_LOG.Util"
            java.lang.String r3 = "copyFile error, "
            com.tencent.open.log.SLog.e(r5, r3, r4)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L98
            r2.close()     // Catch: java.io.IOException -> L90
            goto L98
        L90:
            r4 = move-exception
            java.lang.String r5 = "openSDK_LOG.Util"
            java.lang.String r2 = "copyFile error, "
            com.tencent.open.log.SLog.e(r5, r2, r4)
        L98:
            if (r1 == 0) goto La6
        L9a:
            r1.close()     // Catch: java.io.IOException -> L9e
            goto La6
        L9e:
            r4 = move-exception
            java.lang.String r5 = "openSDK_LOG.Util"
            java.lang.String r1 = "copyFile error, "
            com.tencent.open.log.SLog.e(r5, r1, r4)
        La6:
            return r0
        La7:
            if (r2 == 0) goto Lb5
            r2.close()     // Catch: java.io.IOException -> Lad
            goto Lb5
        Lad:
            r5 = move-exception
            java.lang.String r0 = "openSDK_LOG.Util"
            java.lang.String r2 = "copyFile error, "
            com.tencent.open.log.SLog.e(r0, r2, r5)
        Lb5:
            if (r1 == 0) goto Lc3
            r1.close()     // Catch: java.io.IOException -> Lbb
            goto Lc3
        Lbb:
            r5 = move-exception
            java.lang.String r0 = "openSDK_LOG.Util"
            java.lang.String r1 = "copyFile error, "
            com.tencent.open.log.SLog.e(r0, r1, r5)
        Lc3:
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.l.a(java.io.File, java.io.File):boolean");
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            try {
                return a(file, m(str2));
            } catch (java.io.IOException e2) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
            }
        }
        return false;
    }

    public static boolean a(java.util.Map map, java.lang.String str, boolean z) {
        if (map == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        }
        if (map.containsKey(str)) {
            java.lang.Object obj = map.get(str);
            return obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : z;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
        return z;
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                }
                return bArr2;
            } catch (java.lang.Throwable th) {
                com.tencent.open.log.SLog.e("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static android.os.Bundle b(java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str.replace("auth://", "http://"));
            android.os.Bundle bundleA = a(url.getQuery());
            bundleA.putAll(a(url.getRef()));
            return bundleA;
        } catch (java.net.MalformedURLException unused) {
            return new android.os.Bundle();
        }
    }

    public static java.lang.String b() {
        java.io.File fileE = com.tencent.open.utils.f.e();
        if (fileE == null) {
            return null;
        }
        if (!fileE.exists()) {
            fileE.mkdirs();
        }
        return fileE.toString();
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0225 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String b(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    try {
                        parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                        try {
                            fileInputStream = new java.io.FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            try {
                                java.io.File fileH = h(context, "Images");
                                if (fileH == null) {
                                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e3) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e3.getMessage());
                                    }
                                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                                        try {
                                            parcelFileDescriptorOpenFileDescriptor.close();
                                        } catch (java.io.IOException e4) {
                                            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e4.getMessage());
                                        }
                                    }
                                    return null;
                                }
                                if (!fileH.exists()) {
                                    fileH.mkdirs();
                                }
                                java.io.File file = new java.io.File(fileH, uri.getLastPathSegment());
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int i = fileInputStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, i);
                                    }
                                    fileOutputStream3.flush();
                                    java.lang.String absolutePath = file.getAbsolutePath();
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e5) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e5.getMessage());
                                    }
                                    try {
                                        fileOutputStream3.close();
                                    } catch (java.io.IOException e6) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e6.getMessage());
                                    }
                                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                                        try {
                                            parcelFileDescriptorOpenFileDescriptor.close();
                                        } catch (java.io.IOException e7) {
                                            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e7.getMessage());
                                        }
                                    }
                                    return absolutePath;
                                } catch (java.lang.Exception e8) {
                                    fileOutputStream = fileOutputStream3;
                                    e = e8;
                                    try {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (java.io.IOException e9) {
                                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e9.getMessage());
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (java.io.IOException e10) {
                                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e10.getMessage());
                                            }
                                        }
                                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                                            try {
                                                parcelFileDescriptorOpenFileDescriptor.close();
                                            } catch (java.io.IOException e11) {
                                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e11.getMessage());
                                            }
                                        }
                                        return null;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        fileOutputStream2 = fileOutputStream;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (java.io.IOException e12) {
                                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e12.getMessage());
                                            }
                                        }
                                        if (fileOutputStream2 != null) {
                                            try {
                                                fileOutputStream2.close();
                                            } catch (java.io.IOException e13) {
                                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e13.getMessage());
                                            }
                                        }
                                        if (parcelFileDescriptorOpenFileDescriptor == null) {
                                            throw th;
                                        }
                                        try {
                                            parcelFileDescriptorOpenFileDescriptor.close();
                                            throw th;
                                        } catch (java.io.IOException e14) {
                                            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e14.getMessage());
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    fileOutputStream2 = fileOutputStream3;
                                    th = th2;
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                                        throw th;
                                    }
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                    throw th;
                                }
                            } catch (java.lang.Exception e15) {
                                e = e15;
                                fileOutputStream = null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                        } catch (java.lang.Exception e16) {
                            e = e16;
                            fileOutputStream = null;
                            fileInputStream = null;
                            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            }
                            return null;
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            fileInputStream = null;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (parcelFileDescriptorOpenFileDescriptor == null) {
                                throw th;
                            }
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw th;
                        }
                    } catch (java.lang.Exception e17) {
                        e = e17;
                        parcelFileDescriptorOpenFileDescriptor = null;
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        parcelFileDescriptorOpenFileDescriptor = null;
                    }
                }
            }
            return null;
        } catch (java.lang.Exception e18) {
            e = e18;
            cursorQuery = null;
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String message;
        if (context == null) {
            return;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            java.lang.String str2 = packageInfo.versionName;
            b = str2;
            f732a = str2.substring(0, str2.lastIndexOf(46));
            d = b.substring(b.lastIndexOf(46) + 1, b.length());
            e = packageInfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            sb = new java.lang.StringBuilder();
            sb.append("getPackageInfo has exception: ");
            message = e2.getMessage();
            sb.append(message);
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
        } catch (java.lang.Exception e3) {
            sb = new java.lang.StringBuilder();
            sb.append("getPackageInfo has exception: ");
            message = e3.getMessage();
            sb.append(message);
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
        }
    }

    public static boolean b(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        android.net.NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (android.net.NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static org.json.JSONObject c(java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str.replace("auth://", "http://"));
            org.json.JSONObject jSONObjectA = a((org.json.JSONObject) null, url.getQuery());
            a(jSONObjectA, url.getRef());
            return jSONObjectA;
        } catch (java.net.MalformedURLException unused) {
            return new org.json.JSONObject();
        }
    }

    public static boolean c() {
        android.content.Context contextA = com.tencent.open.utils.f.a();
        return contextA != null && contextA.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", contextA.getPackageName()) == 0;
    }

    public static boolean c(android.content.Context context) {
        double dSqrt;
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            dSqrt = java.lang.Math.sqrt(java.lang.Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + java.lang.Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (java.lang.Throwable unused) {
            dSqrt = 0.0d;
        }
        return dSqrt > 6.5d;
    }

    public static java.lang.String d(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f732a;
    }

    public static org.json.JSONObject d(java.lang.String str) {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON)) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new org.json.JSONObject(str);
    }

    public static boolean d(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "8.1.5") >= 0;
    }

    public static java.lang.String e(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        java.lang.String strD = d(context, str);
        c = strD;
        return strD;
    }

    public static boolean e(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "8.1.8") >= 0;
    }

    public static boolean e(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    public static java.lang.String f(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(i(str));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest == null) {
                return str;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(a(b2 >>> 4));
                sb.append(a(b2));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean f(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "5.9.5") >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    public static boolean f(android.content.Context context, java.lang.String str) {
        boolean z = !c(context) || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return com.tencent.open.utils.i.c(context, str) < 0;
        }
        return z;
    }

    private static boolean g(android.content.Context context) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(com.tencent.smtt.sdk.TbsConfig.APP_QB, 64);
            java.lang.String str = packageInfo.versionName;
            if (com.tencent.open.utils.i.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    java.lang.String strA = a(messageDigest.digest());
                    messageDigest.reset();
                    if (strA.equals("[REDACTED_HEX_CONSTANT]")) {
                        return true;
                    }
                } catch (java.security.NoSuchAlgorithmException e2) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean g(android.content.Context context, java.lang.String str) {
        boolean z = !c(context) || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return com.tencent.open.utils.i.c(context, str) < 0;
        }
        return z;
    }

    public static final boolean g(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static java.io.File h(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 19) {
            return context.getExternalFilesDir(str);
        }
        java.io.File[] externalFilesDirs = context.getExternalFilesDirs(str);
        if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    public static boolean h(java.lang.String str) {
        return str != null && new java.io.File(str).exists();
    }

    public static byte[] i(java.lang.String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static long j(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return 0L;
            }
            fileInputStream = new java.io.FileInputStream(file);
            try {
                long jAvailable = fileInputStream.available();
                try {
                    fileInputStream.close();
                } catch (java.io.IOException unused) {
                }
                return jAvailable;
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (java.io.IOException unused5) {
            }
        }
        return 0L;
    }

    public static java.lang.String k(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return android.util.Base64.encodeToString(a(str.getBytes(), "JCPTZXEZ"), 3);
    }

    public static java.lang.String l(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return android.util.Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (java.io.UnsupportedEncodingException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            return "";
        }
    }

    public static java.io.File m(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            if (file.getParentFile() == null || file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                file.createNewFile();
            } else {
                com.tencent.open.log.SLog.d("openSDK_LOG.Util", "createFile failed" + str);
            }
        }
        return file;
    }

    public static boolean n(java.lang.String str) {
        java.lang.String strB = b();
        return (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(strB) || !str.contains(strB)) ? false : true;
    }
}
