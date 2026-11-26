package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1132a = "c";

    public static synchronized java.lang.String a() {
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            return "";
        }
        try {
            if (contextB.checkCallingOrSelfPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE) != 0) {
                return "";
            }
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) contextB.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            java.lang.String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return "";
            }
            java.lang.String lowerCase = extraInfo.toLowerCase();
            com.tencent.tmassistantbase.util.TMLog.v(f1132a, "netInfo  =  " + lowerCase);
            return lowerCase;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "exception: ", e);
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String strTrim = str.replace("\r", "").replace("\n", "").trim();
        java.lang.String str2 = new java.lang.String(strTrim);
        try {
            android.net.Uri uri = android.net.Uri.parse(strTrim);
            java.lang.String lastPathSegment = uri.getLastPathSegment();
            return (lastPathSegment == null || lastPathSegment.length() <= 0) ? str2 : str2.replace(lastPathSegment, java.net.URLEncoder.encode(uri.getLastPathSegment()).replace("+", "%20"));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "exception: ", e);
            return str2;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String strB = com.tencent.tmassistantbase.util.k.b(str);
        if (android.text.TextUtils.isEmpty(strB)) {
            strB = java.lang.Integer.toString(java.lang.Math.abs(str.hashCode()));
        }
        java.lang.String str3 = "";
        if (!android.text.TextUtils.isEmpty(str2)) {
            if (str2.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK)) {
                str3 = ".apk";
            } else if (str2.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
                str3 = ".diff";
            } else if (str2.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS)) {
                str3 = ".other";
            }
        }
        return strB + str3;
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strA;
        com.tencent.tmassistantbase.util.TMLog.i(f1132a, "genExistedAPKFileNameByUrl url = " + str);
        if (str.contains(".apk")) {
            strA = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (strA.contains(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START)) {
                strA = strA.substring(0, strA.lastIndexOf(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START));
            }
            if (!android.text.TextUtils.isEmpty(strA)) {
                java.lang.String strD = d(c(strA));
                java.lang.String str2 = strD.substring(0, strD.indexOf(".apk")) + "_" + str.hashCode() + ".apk";
                com.tencent.tmassistantbase.util.TMLog.i(f1132a, "genExistedAPKFileNameByUrl url contains apk return fileName = " + str2);
                return str2;
            }
        } else {
            strA = null;
        }
        if (strA == null) {
            strA = a(str, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        }
        com.tencent.tmassistantbase.util.TMLog.i(f1132a, "genExistedAPKFileNameByUrl fileName == null, return fileName = " + strA);
        return strA;
    }

    public static boolean b() {
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) contextB.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (java.lang.SecurityException unused) {
            return false;
        }
    }

    public static boolean b(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted url | " + str + " contentType | " + str2);
        boolean zExists = false;
        try {
            java.lang.String strA = a(str, str2);
            com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted generateFileNameFromURL fileName | " + strA);
            java.lang.String strA2 = com.tencent.tmdownloader.internal.b.b.a(strA);
            com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted generateFileNameFromURL filePath | " + strA2);
            zExists = new java.io.File(strA2).exists();
            com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted generateFileNameFromURL isExisted | " + zExists);
            if (!zExists && (com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK.equals(str2) || str.contains(".apk"))) {
                java.lang.String strB = b(str);
                com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted genAPKFileName fileName | " + strB);
                java.lang.String strA3 = com.tencent.tmdownloader.internal.b.b.a(strB);
                com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted genAPKFileName filePath | " + strA3);
                if (new java.io.File(strA3).exists()) {
                    zExists = true;
                }
            }
            com.tencent.tmassistantbase.util.TMLog.d(f1132a, "halleytest isDownloadFileExisted genAPKFileName isExisted | " + zExists);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "halleytest exception: ", e);
        }
        return zExists;
    }

    public static long c() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        long blockSize = ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
        if (blockSize < 0) {
            return 0L;
        }
        return blockSize;
    }

    public static java.lang.String c(java.lang.String str) {
        if (str != null) {
            return java.net.URLDecoder.decode(str);
        }
        return null;
    }

    public static long d() {
        if (!"mounted".equals(android.os.Environment.getExternalStorageState()) || !android.os.Environment.getExternalStorageDirectory().canWrite()) {
            return 0L;
        }
        android.os.StatFs statFs = new android.os.StatFs(new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath()).getPath());
        long blockSize = ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
        if (blockSize < 0) {
            return 0L;
        }
        return blockSize;
    }

    public static java.lang.String d(java.lang.String str) {
        return str.replace(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START, "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    }

    public static boolean e(java.lang.String str) {
        try {
            new java.net.URI(a(str));
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "exception: ", th);
            th.printStackTrace();
            return false;
        }
    }

    public static boolean f(java.lang.String str) {
        boolean zExists = false;
        if (str == null) {
            return false;
        }
        try {
            zExists = new java.io.File(com.tencent.tmdownloader.internal.b.b.a(str)).exists();
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.w(f1132a, "exception: ", e);
            e.printStackTrace();
        }
        return zExists;
    }
}
