package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginUtils {
    private static final int BUFFER_LENGTH = 8192;
    private static final java.lang.String TAG = "PluginUtils";
    private static java.util.ArrayList emptyResList;
    private static java.lang.String[] fileList;
    static java.lang.String installErrMsg;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static java.lang.Object copyFileObject = new java.lang.Object();

    static void backUp(final boolean z, final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        java.lang.String canonicalPath;
        try {
            canonicalPath = android.os.Environment.getExternalStorageDirectory().getCanonicalPath();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            canonicalPath = null;
        }
        if (android.text.TextUtils.isEmpty(canonicalPath)) {
            return;
        }
        final java.lang.String str4 = canonicalPath + "/Tencent/MidasPay/";
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.plugin.APPluginUtils.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.tencent.midas.plugin.APPluginUtils.copyFileObject) {
                    if (z) {
                        java.lang.String strReplace = str;
                        if (strReplace.endsWith(".jar")) {
                            strReplace = strReplace.replace(".jar", ".apk");
                        }
                        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                        com.tencent.midas.plugin.APPluginUtils.copyFile(str3, str4, strReplace, str2);
                        com.tencent.midas.comm.APLog.i("Times", "File" + strReplace + "backup times:" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                }
            }
        }).start();
    }

    private static void callbackInMidasPluginWhenRunningInNewProcess(android.content.Context context, int i, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("EXTRA_CALLBACK_RESULT_CODE", i);
            intent.putExtra("EXTRA_CALLBACK_RESULT_MSG", str);
            com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(context, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY, new java.lang.Object[]{context, intent});
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.e("PluginProxyActivity", "openPlugin error:" + e.toString());
        }
    }

    public static void callbackInMidasPluginWithoutCaringAboutNewProcess(android.content.Context context, int i, java.lang.String str) {
        if (context == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Call back in plugin without caring process fail, null context!");
            return;
        }
        com.tencent.midas.comm.APLog.d(TAG, "Call back in plugin without caring process, context ok!");
        if (com.tencent.midas.control.APMidasPayHelper.isNewProcess(context)) {
            com.tencent.midas.comm.APLog.d(TAG, "Call back in plugin without caring process, is new process!");
            callbackInMidasPluginWhenRunningInNewProcess(context, i, str);
            return;
        }
        com.tencent.midas.comm.APLog.d(TAG, "Call back in plugin without caring process, not new process!");
        com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
        aPMidasResponse.resultCode = i;
        aPMidasResponse.resultMsg = str;
        com.tencent.midas.control.APMidasPayHelper.midasCallBack(aPMidasResponse);
    }

    public static boolean checkFileMD5(java.lang.String str, java.lang.String str2) {
        java.io.FileInputStream fileInputStream;
        java.lang.String hexString = "";
        try {
            if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str)) {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                    fileInputStream.close();
                    hexString = toHexString(messageDigest.digest());
                } catch (java.lang.Exception e) {
                    e = e;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    e.printStackTrace();
                }
                return hexString.equalsIgnoreCase(str2);
            }
            return false;
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream = null;
        }
    }

    public static void clearDirContent(java.io.File file) {
        if (file == null || (!file.exists() || !file.isDirectory())) {
            com.tencent.midas.comm.APLog.e(TAG, "call clear dir content, but parameter error!");
            return;
        }
        com.tencent.midas.comm.APLog.d(TAG, "About to clear dir, path = " + file.getAbsolutePath());
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
        }
    }

    static void copyDirect(android.content.Context context, java.io.File file, java.io.File file2) throws java.lang.Throwable {
        java.io.File[] fileArrListFiles;
        if (file == null || file2 == null || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (java.io.File file3 : fileArrListFiles) {
            copyFile(file3.getAbsolutePath(), file2.getAbsolutePath(), file3.getName());
        }
    }

    static void copyEmtpyResAPKFromAssets(android.content.Context context) {
        java.lang.String[] assetFileList;
        if (isHasBSL() && (assetFileList = getAssetFileList(context)) != null) {
            for (java.lang.String str : assetFileList) {
                if (str.startsWith("MidasEmptyRes") && str.endsWith(".apk")) {
                    java.lang.String str2 = com.tencent.midas.plugin.APPluginConfig.getPluginEmptyResPath(context).getAbsolutePath() + java.io.File.separator + str;
                    com.tencent.midas.comm.APLog.i("APPluginUtils", "copyEmtpyResAPKFromAssets meptyResPath:" + str2);
                    try {
                        java.io.InputStream inputStreamOpen = context.getAssets().open(str);
                        java.io.File file = new java.io.File(str2);
                        file.createNewFile();
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamOpen.read(bArr);
                            if (i <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStreamOpen.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[Catch: IOException -> 0x00ba, TRY_LEAVE, TryCatch #1 {IOException -> 0x00ba, blocks: (B:58:0x00b6, B:62:0x00be), top: B:85:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00db A[Catch: IOException -> 0x00d7, TRY_LEAVE, TryCatch #3 {IOException -> 0x00d7, blocks: (B:71:0x00d3, B:75:0x00db), top: B:89:0x00d3 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void copyFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.File file;
        java.lang.String str5 = "";
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    java.io.File file2 = new java.io.File(str2);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    file = new java.io.File(str2 + str3);
                    try {
                        if (file.exists()) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                            if ("".compareToIgnoreCase(str4) != 0) {
                                file.delete();
                                return;
                            }
                            return;
                        }
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        file.createNewFile();
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int i = fileInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                                messageDigest.update(bArr, 0, i);
                                fileOutputStream = fileOutputStream2;
                            }
                            java.lang.String hexString = toHexString(messageDigest.digest());
                            try {
                                fileOutputStream2.flush();
                                try {
                                    fileInputStream.close();
                                    fileOutputStream2.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                                if (hexString.compareToIgnoreCase(str4) == 0) {
                                    return;
                                }
                            } catch (java.lang.Exception e3) {
                                str5 = hexString;
                                e = e3;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (java.io.IOException e4) {
                                        e4.printStackTrace();
                                    }
                                } else if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (str5.compareToIgnoreCase(str4) != 0) {
                                    return;
                                } else {
                                    return;
                                }
                            } catch (java.lang.Throwable th) {
                                str5 = hexString;
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (java.io.IOException e5) {
                                        e5.printStackTrace();
                                        if (str5.compareToIgnoreCase(str4) == 0 || file == null) {
                                            throw th;
                                        }
                                        file.delete();
                                        throw th;
                                    }
                                } else if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (str5.compareToIgnoreCase(str4) == 0) {
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (java.lang.Exception e6) {
                            e = e6;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                        }
                        file.delete();
                    } catch (java.lang.Exception e7) {
                        e = e7;
                    }
                } catch (java.lang.Exception e8) {
                    e = e8;
                    file = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    file = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } catch (java.lang.Exception e9) {
            e = e9;
            fileInputStream = null;
            file = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream = null;
            file = null;
        }
        e.printStackTrace();
        if (fileInputStream != null) {
            fileInputStream.close();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } else if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (str5.compareToIgnoreCase(str4) != 0 || file == null) {
            return;
        }
        file.delete();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0069 A[Catch: IOException -> 0x0065, TRY_LEAVE, TryCatch #4 {IOException -> 0x0065, blocks: (B:41:0x0061, B:45:0x0069), top: B:64:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x007b A[Catch: IOException -> 0x0077, TRY_LEAVE, TryCatch #1 {IOException -> 0x0077, blocks: (B:50:0x0073, B:54:0x007b), top: B:59:0x0073 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean copyFile(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    java.io.File file = new java.io.File(str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    java.io.File file2 = new java.io.File(str2, str3);
                    if (file2.exists()) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileInputStream.close();
                            fileOutputStream2.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        return true;
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        e.printStackTrace();
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (java.io.IOException e7) {
                e7.printStackTrace();
            }
        } else if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return false;
    }

    static void deleteBKPlugin(android.content.Context context) {
        com.tencent.midas.comm.APLog.i("APPluginUtils", "deleteUpdatePlugin");
        deleteFiles(com.tencent.midas.plugin.APPluginConfig.getPluginBackUpPath(context));
    }

    public static void deleteDex(android.content.Context context) {
        com.tencent.midas.comm.APLog.i("APPluginUtils", "deleteDex");
        deleteFiles(com.tencent.midas.plugin.APPluginConfig.getOptimizedDexPath(context));
    }

    public static void deleteFiles(java.io.File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static void deleteLibs(android.content.Context context) {
        com.tencent.midas.comm.APLog.i("APPluginUtils", "deleteLibs");
        deleteFiles(com.tencent.midas.plugin.APPluginConfig.getLibPath(context));
    }

    public static void deletePlugin(android.content.Context context) {
        com.tencent.midas.comm.APLog.i("APPluginUtils", "deletePlugin");
        deleteFiles(com.tencent.midas.plugin.APPluginConfig.getPluginPath(context));
    }

    public static void deleteUpdatePlugin(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "Calling into deleteUpdatePlugin " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        deleteFiles(com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0187 A[EDGE_INSN: B:113:0x0187->B:88:0x0187 BREAK  A[LOOP:0: B:17:0x0072->B:114:0x0072], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x016d A[Catch: IOException -> 0x0169, TRY_LEAVE, TryCatch #0 {IOException -> 0x0169, blocks: (B:71:0x0165, B:75:0x016d), top: B:92:0x0165 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int extractLibs(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String str3;
        boolean z;
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.IOException e;
        if (android.os.Build.CPU_ABI.startsWith("arm64-v8a")) {
            str3 = "arm64-v8a";
        } else {
            str3 = (!android.os.Build.CPU_ABI.startsWith("arm") && android.os.Build.CPU_ABI.startsWith(com.bun.miitmdid.core.Utils.CPU_ABI_X86)) ? com.bun.miitmdid.core.Utils.CPU_ABI_X86 : "armeabi";
        }
        com.tencent.midas.comm.APLog.i("APPluginUtils", "extractLibs end to dirToExtract:" + str3 + " extractLibs ABI:" + android.os.Build.CPU_ABI);
        if (!str2.endsWith(java.io.File.separator)) {
            str2 = str2 + java.io.File.separator;
        }
        installErrMsg = null;
        try {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str);
            byte[] bArr = new byte[4096];
            java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                java.lang.String name = zipEntryNextElement.getName();
                if (!name.endsWith(java.io.File.separator) && !name.contains("../") && (name.contains("lib") || name.endsWith(".so"))) {
                    com.tencent.midas.comm.APLog.i("APPluginUtils", "fileName:" + name);
                    java.io.File file = new java.io.File(str2 + name);
                    int iLastIndexOf = name.lastIndexOf(java.io.File.separator);
                    if (iLastIndexOf != -1) {
                        name = name.substring(iLastIndexOf + 1);
                    }
                    java.io.File file2 = new java.io.File(str2 + name);
                    while (true) {
                        if (file == null) {
                            z = false;
                            break;
                        }
                        if (file.getName().equals(str3)) {
                            z = true;
                            break;
                        }
                        file = file.getParentFile();
                    }
                    if (z) {
                        file2.getParentFile().mkdirs();
                        try {
                            inputStream = zipFile.getInputStream(zipEntryNextElement);
                            try {
                                fileOutputStream = new java.io.FileOutputStream(file2);
                                while (true) {
                                    try {
                                        try {
                                            int i = inputStream.read(bArr);
                                            if (i <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i);
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (java.io.IOException e2) {
                                                    e2.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (java.io.IOException e3) {
                                        e = e3;
                                        com.tencent.midas.comm.APLog.w("extra libs", "extra lbis error:" + e.toString());
                                        installErrMsg = getFullExceptionStacktrace(e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (java.io.IOException e4) {
                                                e = e4;
                                                e.printStackTrace();
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    }
                                }
                                fileOutputStream.flush();
                                try {
                                    fileOutputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (java.io.IOException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                }
                            } catch (java.io.IOException e6) {
                                e = e6;
                                fileOutputStream = null;
                                com.tencent.midas.comm.APLog.w("extra libs", "extra lbis error:" + e.toString());
                                installErrMsg = getFullExceptionStacktrace(e);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (installErrMsg != null) {
                                    break;
                                    return 0;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        } catch (java.io.IOException e7) {
                            e = e7;
                            inputStream = null;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            inputStream = null;
                            fileOutputStream = null;
                        }
                        if (installErrMsg != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return 0;
        } catch (java.io.IOException e8) {
            e8.printStackTrace();
            installErrMsg = getFullExceptionStacktrace(e8);
            return -1;
        }
    }

    private static java.lang.String[] getAssetFileList(android.content.Context context) {
        try {
            if (fileList == null) {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                fileList = context.getAssets().list("");
                com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS, jCurrentTimeMillis);
            }
        } catch (java.io.IOException e) {
            com.tencent.midas.comm.APLog.w("APPLuginUtils", "getPluginNameFromAssets e:" + e.getMessage());
        }
        return fileList;
    }

    static int getAssetsVersionCode(android.content.Context context) {
        java.io.InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open("MidasPay.zip");
                int zipVersionCodeWtihStream = getZipVersionCodeWtihStream(context, inputStreamOpen);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
                return zipVersionCodeWtihStream;
            } catch (java.lang.Exception e2) {
                installErrMsg = getFullExceptionStacktrace(e2);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                com.tencent.midas.comm.APLog.i("assets 目录下内核版本号：", "versionCode:0");
                return 0;
            }
        } catch (java.lang.Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static java.io.File getDataZipFile(android.content.Context context) {
        java.lang.String path = com.tencent.midas.api.APMidasPayAPI.getPath();
        if (android.text.TextUtils.isEmpty(path)) {
            return null;
        }
        com.tencent.midas.comm.APLog.i("APPluginUtils", "getDataZipFile sPath:" + path);
        java.io.File file = new java.io.File(path);
        if (file.getName().startsWith("MidasPay") && file.getName().endsWith(".zip")) {
            return file;
        }
        return null;
    }

    public static java.lang.String getExceptionInfo(java.lang.Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter((java.io.Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002f A[Catch: IOException -> 0x002b, TRY_LEAVE, TryCatch #3 {IOException -> 0x002b, blocks: (B:18:0x0027, B:22:0x002f), top: B:32:0x0027 }] */
    public static java.lang.String getFullExceptionStacktrace(java.lang.Throwable th) throws java.lang.Throwable {
        java.io.StringWriter stringWriter;
        java.io.PrintWriter printWriter = null;
        try {
            stringWriter = new java.io.StringWriter();
            try {
                java.io.PrintWriter printWriter2 = new java.io.PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    java.lang.String string = stringWriter.toString();
                    try {
                        stringWriter.close();
                        printWriter2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return string;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                            if (printWriter != null) {
                                printWriter.close();
                            }
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    } else if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            stringWriter = null;
        }
    }

    public static java.lang.String getInitErrorMsg() {
        return installErrMsg;
    }

    public static java.io.File getInstallPath(android.content.Context context, java.lang.String str) {
        return com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(context, str);
    }

    public static java.lang.String getInstallPathString(android.content.Context context, java.lang.String str) {
        return com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPathString(context, str);
    }

    public static java.io.File getLibPath(android.content.Context context) {
        return com.tencent.midas.plugin.APPluginConfig.getLibPath(context);
    }

    public static java.lang.String getMD5FromPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(".apk");
        int iLastIndexOf2 = str.lastIndexOf("_");
        if (iLastIndexOf == -1 || iLastIndexOf2 == -1) {
            return "";
        }
        try {
            return str.substring(iLastIndexOf2 + 1, iLastIndexOf);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getMidasCoreVersionName(android.content.Context context) {
        java.lang.String canonicalPath = "";
        java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
        if (pluginPath != null) {
            for (java.io.File file : pluginPath.listFiles()) {
                if (file.getName().startsWith("MidasCore")) {
                    try {
                        canonicalPath = file.getCanonicalPath();
                        break;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        android.content.pm.PackageInfo packageInfo = getPackageInfo(context, canonicalPath);
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public static java.util.ArrayList getMidasEmptyPaht(android.content.Context context) {
        if (emptyResList == null) {
            emptyResList = new java.util.ArrayList();
            java.io.File pluginEmptyResPath = com.tencent.midas.plugin.APPluginConfig.getPluginEmptyResPath(context);
            if (pluginEmptyResPath != null) {
                for (java.io.File file : pluginEmptyResPath.listFiles()) {
                    if (file.getName().startsWith("MidasEmptyRes") && file.getName().endsWith(".apk")) {
                        try {
                            emptyResList.add(file.getCanonicalPath());
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return emptyResList;
    }

    public static android.content.pm.PackageInfo getPackageInfo(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        android.content.pm.PackageInfo packageArchiveInfo = (android.content.pm.PackageInfo) com.tencent.midas.plugin.APPluginInstallerAndUpdater.sPackageInfoMap.get(str);
        if (packageArchiveInfo == null && (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 128)) != null) {
            com.tencent.midas.plugin.APPluginInstallerAndUpdater.sPackageInfoMap.put(str, packageArchiveInfo);
        }
        return packageArchiveInfo;
    }

    static int getZipVersionCodeWtihFileName(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        com.tencent.midas.comm.APLog.i("getAssetsVersionCodeWtihFileName", "sUnzipMidasPayFile:" + str);
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
                try {
                    int zipVersionCodeWtihStream = getZipVersionCodeWtihStream(context, fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return zipVersionCodeWtihStream;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    installErrMsg = getFullExceptionStacktrace(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    com.tencent.midas.comm.APLog.i("special data direct", "versionCode:0");
                    return 0;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getZipVersionCodeWtihStream(android.content.Context context, java.io.InputStream inputStream) throws java.lang.Throwable {
        int i = 0;
        ?? r0 = 0;
        java.util.zip.ZipInputStream zipInputStream = null;
        try {
            try {
                try {
                    java.util.zip.ZipInputStream zipInputStream2 = new java.util.zip.ZipInputStream(inputStream);
                    try {
                        java.util.zip.ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        com.tencent.midas.comm.APLog.i("getAssetsVersionCodeWtihFileName", "zipEntry:" + nextEntry);
                        while (nextEntry != null) {
                            java.lang.String name = nextEntry.getName();
                            com.tencent.midas.comm.APLog.i("getAssetsVersionCodeWtihFileName", "fileName:" + name);
                            if (!nextEntry.isDirectory() && !name.contains("../") && name.startsWith("MidasCore") && name.endsWith(".jar")) {
                                i = java.lang.Integer.parseInt(name.substring(0, name.lastIndexOf(".jar")).split("_")[2]);
                                break;
                            }
                            nextEntry = zipInputStream2.getNextEntry();
                        }
                        zipInputStream2.close();
                    } catch (java.lang.Exception e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        installErrMsg = getFullExceptionStacktrace(e);
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        r0 = "special data direct";
                        com.tencent.midas.comm.APLog.i("special data direct", "versionCode:" + i);
                        return i;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r0 = zipInputStream2;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (java.lang.Exception e2) {
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
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        r0 = "special data direct";
        com.tencent.midas.comm.APLog.i("special data direct", "versionCode:" + i);
        return i;
    }

    private static boolean isHasBSL() {
        boolean z;
        try {
            java.lang.Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new java.lang.Class[0]);
            z = true;
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e.toString());
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            java.lang.Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new java.lang.Class[0]);
            return true;
        } catch (java.lang.Exception e2) {
            com.tencent.midas.comm.APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e2.toString());
            return false;
        }
    }

    static void readSingInfo(java.util.HashMap map, java.io.File file) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file.getCanonicalPath()));
            com.tencent.midas.comm.APMidasRSATools aPMidasRSATools = new com.tencent.midas.comm.APMidasRSATools();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null || android.text.TextUtils.isEmpty(line)) {
                    break;
                    break;
                }
                java.lang.String[] strArrSplit = line.split("\\:");
                java.lang.String str = strArrSplit[0];
                java.lang.String strDeCodeKey = aPMidasRSATools.deCodeKey(strArrSplit[1]);
                map.put(str.split("\\_")[0], strDeCodeKey.substring(strDeCodeKey.length() - 32));
            }
            bufferedReader.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    static void readSingInfoItems(java.util.HashMap map, java.io.File file) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file.getCanonicalPath()));
            com.tencent.midas.comm.APMidasRSATools aPMidasRSATools = new com.tencent.midas.comm.APMidasRSATools();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null || android.text.TextUtils.isEmpty(line)) {
                    break;
                    break;
                }
                java.lang.String[] strArrSplit = line.split("\\:");
                java.lang.String str = strArrSplit[0];
                java.lang.String strDeCodeKey = aPMidasRSATools.deCodeKey(strArrSplit[1]);
                java.lang.String strSubstring = strDeCodeKey.substring(strDeCodeKey.length() - 32);
                java.lang.String str2 = str.split("\\_")[0];
                com.tencent.midas.plugin.APSignIniItem aPSignIniItem = new com.tencent.midas.plugin.APSignIniItem();
                aPSignIniItem.name = str2;
                aPSignIniItem.md5 = strSubstring;
                aPSignIniItem.fullName = strArrSplit[0];
                map.put(str2, aPSignIniItem);
            }
            bufferedReader.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void release() {
        com.tencent.midas.plugin.APPluginInstallerAndUpdater.sInstallPathMap.clear();
        com.tencent.midas.plugin.APPluginInstallerAndUpdater.sPackageInfoMap.clear();
    }

    static void showLaunchPluginFail(android.content.Context context, java.lang.String str, boolean z) {
        java.lang.String str2;
        com.tencent.midas.comm.APLog.d(TAG, "Calling into showLaunchPluginFail, needToPureH5Pay = " + z + " caller = " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        if (!android.text.TextUtils.isEmpty(str)) {
            com.tencent.midas.data.APPluginReportManager.getInstance().reportImmediatelyOneRecord(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_NAME_LAUNCH_ERROR, str);
        }
        if (!z || com.tencent.midas.jsbridge.APWebJSBridgeActivity.startPureH5Pay(context, str, "showLaunchPluginFail")) {
            return;
        }
        if (str == null || !(str.contains("空间") || str.contains("Space"))) {
            str2 = (android.text.TextUtils.isEmpty(str) || !(str.contains("webview") || str.contains("Webview"))) ? "系统繁忙，请退出重试" : "系统组件缺失，请退出重试";
        } else {
            str2 = "系统可用内存不足，请退出重试";
        }
        android.widget.Toast.makeText(context, str2, 0).show();
        callbackInMidasPluginWithoutCaringAboutNewProcess(context, 100, "Unexpected error!");
    }

    public static java.lang.String toHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static void unInstallPlugin(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "unInstallPlugin " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
    }

    public static void updateLibExtendNum() {
        com.tencent.midas.plugin.APPluginConfig.libExtend++;
        com.tencent.midas.comm.APLog.i("APPluginUtils", "updateLibExtendNum libExtend:" + com.tencent.midas.plugin.APPluginConfig.libExtend);
    }

    public static java.util.HashMap url2Map(java.lang.String str) {
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String[] strArrSplit = str.split("\\?");
        if (strArrSplit == null) {
            return null;
        }
        if (strArrSplit.length == 1) {
            str = strArrSplit[0];
        } else if (strArrSplit.length == 2) {
            str = strArrSplit[1];
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.midas.comm.APLog.i("url2Map", "url后参数为空");
            } else {
                java.lang.String[] strArrSplit2 = str.split("\\&");
                java.lang.String str2 = "";
                java.lang.String str3 = "";
                for (int i = 0; i < strArrSplit2.length; i++) {
                    try {
                        str3 = strArrSplit2[i].split("\\=")[0];
                        str2 = strArrSplit2[i].split("\\=")[1];
                    } catch (java.lang.Exception unused) {
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        map.put(str3, str2);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.w("url2Map", e.toString());
        }
        return map;
    }
}
