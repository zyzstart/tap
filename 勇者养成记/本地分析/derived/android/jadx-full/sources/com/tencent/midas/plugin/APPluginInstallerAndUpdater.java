package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginInstallerAndUpdater {
    private static final int BUFFER_LENGTH = 8192;
    private static final int INSTALL_ERR_LOSTZIPFILE = -2;
    private static final int INSTALL_ERR_MD5CHECKFAIL = -3;
    static final int INSTALL_ERR_SYSTEM = -1;
    static final int INSTALL_FROM_ASSETS = 1;
    static final int INSTALL_FROM_LOCAL = 2;
    private static final int INSTALL_SUCC = 0;
    private static final java.lang.String TAG = "APPluginInstallerAndUpdater";
    static java.util.Map sInstallPathMap = new java.util.concurrent.ConcurrentHashMap();
    static java.util.Map sPackageInfoMap = new java.util.concurrent.ConcurrentHashMap();

    public static java.io.File getInstallPath(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = (java.io.File) sInstallPathMap.get(str);
        if (file == null) {
            java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
            if (pluginPath == null) {
                return null;
            }
            for (java.io.File file2 : pluginPath.listFiles()) {
                if (file2.getName().startsWith(str)) {
                    sInstallPathMap.put(str, file2);
                    return file2;
                }
            }
        }
        return file;
    }

    public static java.lang.String getInstallPathString(android.content.Context context, java.lang.String str) {
        try {
            java.io.File installPath = getInstallPath(context, str);
            return installPath != null ? installPath.getCanonicalPath() : "";
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static int installFromAssets(android.content.Context context) {
        com.tencent.midas.plugin.APPluginUtils.copyEmtpyResAPKFromAssets(context);
        if (android.text.TextUtils.isEmpty("MidasPay.zip")) {
            return -2;
        }
        java.io.InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open("MidasPay.zip");
            installFromZipStream(context, inputStreamOpen);
            if (inputStreamOpen == null) {
                return 0;
            }
            try {
                return 0;
            } catch (java.io.IOException e) {
                return 0;
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private static int installFromData(android.content.Context context) throws java.lang.Throwable {
        com.tencent.midas.plugin.APPluginUtils.copyEmtpyResAPKFromAssets(context);
        java.io.File dataZipFile = com.tencent.midas.plugin.APPluginUtils.getDataZipFile(context);
        com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromData zipFile:" + dataZipFile);
        if (dataZipFile == null) {
            return -2;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromData filePath:" + dataZipFile.getCanonicalPath());
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(dataZipFile);
                try {
                    installFromZipStream(context, fileInputStream2);
                    try {
                        fileInputStream2.close();
                        return 0;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return 0;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return -1;
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
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e5) {
            e = e5;
        }
    }

    public static int installFromLocal(android.content.Context context) {
        int iInstallFromLocalByPath;
        com.tencent.midas.comm.APLog.d(TAG, "Calling into installFromLocal " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        com.tencent.midas.plugin.APPluginUtils.deleteBKPlugin(context);
        com.tencent.midas.plugin.APPluginUtils.copyDirect(context, com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context), com.tencent.midas.plugin.APPluginConfig.getPluginBackUpPath(context));
        try {
            java.io.File pluginUpdatePath = com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context);
            iInstallFromLocalByPath = installFromLocalByPath(context, pluginUpdatePath);
            com.tencent.midas.comm.APLog.d(TAG, "Calling into installFromLocal, installFromLocalByPath result state = " + iInstallFromLocalByPath + " install src = " + pluginUpdatePath);
        } catch (java.lang.Exception unused) {
            iInstallFromLocalByPath = -1;
        }
        if (iInstallFromLocalByPath != 0) {
            unInstallPlugin(context);
            iInstallFromLocalByPath = installFromLocalByPath(context, com.tencent.midas.plugin.APPluginConfig.getPluginBackUpPath(context));
            if (iInstallFromLocalByPath != 0) {
                unInstallPlugin(context);
            }
        } else {
            com.tencent.midas.plugin.APPluginUtils.deleteUpdatePlugin(context);
        }
        com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromLocal state:" + iInstallFromLocalByPath);
        return iInstallFromLocalByPath;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[Catch: IOException -> 0x0050, Exception -> 0x018d, TryCatch #9 {IOException -> 0x0050, blocks: (B:17:0x004c, B:21:0x0054, B:23:0x0059), top: B:119:0x004c, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[Catch: IOException -> 0x0050, Exception -> 0x018d, TRY_LEAVE, TryCatch #9 {IOException -> 0x0050, blocks: (B:17:0x004c, B:21:0x0054, B:23:0x0059), top: B:119:0x004c, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0174 A[Catch: Exception -> 0x016e, IOException -> 0x0170, TryCatch #8 {IOException -> 0x0170, blocks: (B:89:0x016a, B:95:0x0174, B:97:0x0179), top: B:110:0x016a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0179 A[Catch: Exception -> 0x016e, IOException -> 0x0170, TRY_LEAVE, TryCatch #8 {IOException -> 0x0170, blocks: (B:89:0x016a, B:95:0x0174, B:97:0x0179), top: B:110:0x016a, outer: #1 }] */
    private static int installFromLocalByPath(android.content.Context context, java.io.File file) throws java.lang.Throwable {
        int i;
        java.io.File[] fileArr;
        java.lang.Throwable th;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileOutputStream fileOutputStream;
        if (file == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot install plugin with null path!");
            return -1;
        }
        char c = 0;
        try {
            java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
            java.io.File[] fileArrListFiles = file.listFiles();
            java.io.BufferedOutputStream bufferedOutputStream2 = null;
            java.io.FileInputStream fileInputStream = null;
            java.io.FileOutputStream fileOutputStream2 = null;
            int i2 = 0;
            while (i2 < fileArrListFiles.length) {
                try {
                    try {
                        java.io.File file2 = fileArrListFiles[i2];
                        java.lang.String name = file2.getName();
                        com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromLocal src fileName:" + name);
                        if (name.endsWith(".apk") || name.endsWith(".ini")) {
                            java.lang.String str = name.split("\\_")[c];
                            com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromLocal name:" + str);
                            if (pluginPath != null) {
                                java.io.File[] fileArrListFiles2 = pluginPath.listFiles();
                                int i3 = 0;
                                while (i3 < fileArrListFiles2.length) {
                                    java.io.File file3 = fileArrListFiles2[i3];
                                    java.lang.String name2 = file3.getName();
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    fileArr = fileArrListFiles;
                                    try {
                                        sb.append("installFromLocal destFileName:");
                                        sb.append(name2);
                                        com.tencent.midas.comm.APLog.i("APPluginUtils", sb.toString());
                                        if (name2.startsWith(str)) {
                                            file3.delete();
                                        }
                                        i3++;
                                        fileArrListFiles = fileArr;
                                    } catch (java.io.IOException unused) {
                                        i = -1;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        if (bufferedOutputStream != null) {
                                            try {
                                                try {
                                                    bufferedOutputStream.close();
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                    }
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } catch (java.lang.Exception e) {
                                                    e = e;
                                                    e.printStackTrace();
                                                    com.tencent.midas.plugin.APPluginUtils.installErrMsg = com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(e);
                                                    com.tencent.midas.comm.APLog.d(TAG, "installFromLocalByPath finish result = " + i + " install src = " + file + " About to clear pluginsTemp dir!");
                                                    com.tencent.midas.plugin.APPluginUtils.clearDirContent(com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context));
                                                    return i;
                                                }
                                            } catch (java.io.IOException e2) {
                                                e2.printStackTrace();
                                                bufferedOutputStream2 = bufferedOutputStream;
                                                fileOutputStream2 = fileOutputStream;
                                                i2++;
                                                fileArrListFiles = fileArr;
                                                c = 0;
                                            }
                                        } else {
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        }
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        i2++;
                                        fileArrListFiles = fileArr;
                                        c = 0;
                                    }
                                }
                            }
                            fileArr = fileArrListFiles;
                            java.io.File file4 = new java.io.File(pluginPath.getCanonicalPath() + java.io.File.separator + name);
                            com.tencent.midas.comm.APLog.i("APPluginUtils", "installFromLocal destfileName:" + name);
                            fileOutputStream = new java.io.FileOutputStream(file4);
                            try {
                                bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                                try {
                                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file2.getCanonicalPath());
                                    try {
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int i4 = fileInputStream2.read(bArr);
                                            i = -1;
                                            if (i4 == -1) {
                                                break;
                                            }
                                            try {
                                                bufferedOutputStream.write(bArr, 0, i4);
                                            } catch (java.io.IOException unused2) {
                                                fileInputStream = fileInputStream2;
                                                if (bufferedOutputStream != null) {
                                                    bufferedOutputStream.close();
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                    }
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } else {
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                    }
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                }
                                                bufferedOutputStream2 = bufferedOutputStream;
                                                fileOutputStream2 = fileOutputStream;
                                                i2++;
                                                fileArrListFiles = fileArr;
                                                c = 0;
                                            } catch (java.lang.Throwable th2) {
                                                th = th2;
                                                th = th;
                                                fileInputStream = fileInputStream2;
                                                if (bufferedOutputStream != null) {
                                                    try {
                                                        bufferedOutputStream.close();
                                                    } catch (java.io.IOException e3) {
                                                        e3.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                if (fileOutputStream == null) {
                                                    throw th;
                                                }
                                                fileOutputStream.close();
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        try {
                                            bufferedOutputStream.close();
                                            fileInputStream2.close();
                                            fileOutputStream.close();
                                        } catch (java.io.IOException e4) {
                                            e4.printStackTrace();
                                        }
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        fileInputStream = fileInputStream2;
                                    } catch (java.io.IOException unused3) {
                                        i = -1;
                                    } catch (java.lang.Throwable th3) {
                                        th = th3;
                                        i = -1;
                                    }
                                } catch (java.io.IOException unused4) {
                                    i = -1;
                                } catch (java.lang.Throwable th4) {
                                    i = -1;
                                    th = th4;
                                }
                            } catch (java.io.IOException unused5) {
                                i = -1;
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (java.lang.Throwable th5) {
                                i = -1;
                                th = th5;
                                bufferedOutputStream = bufferedOutputStream2;
                            }
                        } else {
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                } catch (java.io.IOException e5) {
                                    e5.printStackTrace();
                                }
                            } else {
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                            }
                            fileArr = fileArrListFiles;
                        }
                    } catch (java.lang.Throwable th6) {
                        i = -1;
                        th = th6;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (java.io.IOException unused6) {
                    fileArr = fileArrListFiles;
                }
                i2++;
                fileArrListFiles = fileArr;
                c = 0;
            }
            i = 0;
        } catch (java.lang.Exception e6) {
            e = e6;
            i = -1;
        }
        com.tencent.midas.comm.APLog.d(TAG, "installFromLocalByPath finish result = " + i + " install src = " + file + " About to clear pluginsTemp dir!");
        com.tencent.midas.plugin.APPluginUtils.clearDirContent(com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context));
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00e0 A[Catch: IOException -> 0x00dc, all -> 0x0111, Exception -> 0x0114, TRY_LEAVE, TryCatch #15 {IOException -> 0x00dc, blocks: (B:53:0x00d8, B:57:0x00e0), top: B:120:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00fa A[Catch: IOException -> 0x00f6, all -> 0x0111, Exception -> 0x0114, TRY_LEAVE, TryCatch #2 {IOException -> 0x00f6, blocks: (B:66:0x00f2, B:70:0x00fa), top: B:106:0x00f2 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int installFromZipStream(android.content.Context context, java.io.InputStream inputStream) throws java.lang.Throwable {
        java.lang.String str;
        boolean z;
        java.io.FileOutputStream fileOutputStream;
        com.tencent.midas.plugin.APPluginUtils.copyEmtpyResAPKFromAssets(context);
        if (inputStream == null) {
            return -2;
        }
        java.util.zip.ZipInputStream zipInputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        java.io.BufferedOutputStream bufferedOutputStream = null;
        zipInputStream = null;
        try {
            try {
                java.util.zip.ZipInputStream zipInputStream2 = new java.util.zip.ZipInputStream(inputStream);
                try {
                    java.util.zip.ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    java.lang.String absolutePath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context).getAbsolutePath();
                    while (nextEntry != null) {
                        java.lang.String name = nextEntry.getName();
                        if (nextEntry.isDirectory() || name.contains("../")) {
                            nextEntry = zipInputStream2.getNextEntry();
                        } else {
                            java.lang.String str2 = "";
                            if (name.endsWith(".jar")) {
                                int iLastIndexOf = name.lastIndexOf(".jar");
                                java.lang.String strSubstring = iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
                                java.lang.String str3 = strSubstring.split("_")[3];
                                str = absolutePath + java.io.File.separator + strSubstring + ".apk";
                                str2 = str3;
                                z = true;
                            } else {
                                str = absolutePath + java.io.File.separator + name;
                                z = false;
                            }
                            java.io.File file = new java.io.File(str);
                            try {
                                fileOutputStream = new java.io.FileOutputStream(file);
                                try {
                                    try {
                                        java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(fileOutputStream);
                                        try {
                                            byte[] bArr = new byte[8192];
                                            while (true) {
                                                int i = zipInputStream2.read(bArr);
                                                if (i == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream2.write(bArr, 0, i);
                                            }
                                            bufferedOutputStream2.flush();
                                            com.tencent.midas.plugin.APPluginUtils.backUp(z, name, str2, file.getCanonicalPath());
                                            java.util.zip.ZipEntry nextEntry2 = zipInputStream2.getNextEntry();
                                            try {
                                                bufferedOutputStream2.close();
                                                fileOutputStream.close();
                                            } catch (java.io.IOException e) {
                                                e.printStackTrace();
                                            }
                                            nextEntry = nextEntry2;
                                        } catch (java.lang.Exception e2) {
                                            e = e2;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            e.printStackTrace();
                                            com.tencent.midas.plugin.APPluginUtils.installErrMsg = com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(e);
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } catch (java.io.IOException e3) {
                                                    e3.printStackTrace();
                                                    zipInputStream2.close();
                                                    return -1;
                                                }
                                            } else if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            try {
                                                zipInputStream2.close();
                                            } catch (java.io.IOException e4) {
                                                e4.printStackTrace();
                                            }
                                            return -1;
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } catch (java.io.IOException e5) {
                                                    e5.printStackTrace();
                                                    throw th;
                                                }
                                            } else if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                    }
                                } catch (java.lang.Exception e6) {
                                    e = e6;
                                }
                            } catch (java.lang.Exception e7) {
                                e = e7;
                                fileOutputStream = null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        }
                    }
                    try {
                        zipInputStream2.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                    return 0;
                } catch (java.lang.Exception e9) {
                    e = e9;
                    zipInputStream = zipInputStream2;
                    e.printStackTrace();
                    com.tencent.midas.plugin.APPluginUtils.installErrMsg = com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(e);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (java.io.IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return -1;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    zipInputStream = zipInputStream2;
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (java.io.IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e12) {
                e = e12;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int installPlugin(android.content.Context context, int i) {
        int iInstallFromData;
        com.tencent.midas.comm.APLog.d(TAG, "installPlugin from = " + i);
        int i2 = 0;
        try {
            unInstallPlugin(context);
            if (i != 1) {
                if (i == 2) {
                    iInstallFromData = installFromData(context);
                } else if (i2 != 0) {
                    unInstallPlugin(context);
                }
                return i2;
            }
            iInstallFromData = installFromAssets(context);
            i2 = iInstallFromData;
            if (i2 != 0) {
                unInstallPlugin(context);
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.w("APPluginUtils", "installPlugin Exception:" + e.toString());
            com.tencent.midas.plugin.APPluginUtils.installErrMsg = com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(e);
        }
        return i2;
    }

    public static int isNeedUpdateFromAssets(android.content.Context context) {
        int i;
        int assetsVersionCode;
        java.lang.String canonicalPath = "";
        try {
            canonicalPath = getInstallPath(context, "MidasCore").getCanonicalPath();
        } catch (java.lang.Exception unused) {
        }
        try {
            i = !android.text.TextUtils.isEmpty(canonicalPath) ? com.tencent.midas.plugin.APPluginUtils.getPackageInfo(context, canonicalPath).versionCode : 0;
            try {
                assetsVersionCode = com.tencent.midas.plugin.APPluginUtils.getAssetsVersionCode(context);
            } catch (java.lang.Exception unused2) {
                assetsVersionCode = 0;
            }
        } catch (java.lang.Exception unused3) {
            i = 0;
        }
        com.tencent.midas.comm.APLog.i("APPluginUtils", "isNeedUpdateFromAssets coreVC:" + i + " assetsVC:" + assetsVersionCode);
        if (assetsVersionCode > i) {
            return 1;
        }
        java.io.File dataZipFile = com.tencent.midas.plugin.APPluginUtils.getDataZipFile(context);
        if (dataZipFile != null) {
            int zipVersionCodeWtihFileName = com.tencent.midas.plugin.APPluginUtils.getZipVersionCodeWtihFileName(context, dataZipFile.getAbsolutePath());
            com.tencent.midas.comm.APLog.i("APPluginUtils", "isNeedUpdateFromAssets dataVC:" + zipVersionCodeWtihFileName);
            if (zipVersionCodeWtihFileName > i) {
                return 2;
            }
        }
        return 0;
    }

    public static boolean isNeedUpdateFromLocal(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal");
        java.io.File pluginUpdatePath = com.tencent.midas.plugin.APPluginConfig.getPluginUpdatePath(context);
        try {
            java.io.File file = new java.io.File(pluginUpdatePath, com.tencent.midas.plugin.APPluginConfig.SIGN_FILE_NAME);
            if (!file.exists()) {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, sign file not exist, return false!");
                return false;
            }
            com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, sign file exist!");
            java.util.HashMap map = new java.util.HashMap();
            com.tencent.midas.plugin.APPluginUtils.readSingInfoItems(map, file);
            java.io.File[] fileArrListFiles = pluginUpdatePath.listFiles();
            if (fileArrListFiles == null) {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, cannot get local file list, return false!");
                return false;
            }
            if (fileArrListFiles.length == 0) {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, empty local file list, return false!");
                return false;
            }
            boolean z = false;
            for (java.io.File file2 : fileArrListFiles) {
                java.lang.String name = file2.getName();
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name);
                if (name.startsWith("MidasCore")) {
                    z = true;
                }
                if (name.endsWith(".apk")) {
                    boolean zCheckFileMD5 = com.tencent.midas.plugin.APPluginUtils.checkFileMD5(file2.getCanonicalPath(), ((com.tencent.midas.plugin.APSignIniItem) map.get(name.split("\\_")[0])).md5);
                    com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + " valid = " + zCheckFileMD5);
                    if (!zCheckFileMD5) {
                        com.tencent.midas.plugin.APPluginUtils.clearDirContent(pluginUpdatePath);
                        return false;
                    }
                    map.remove(name.split("\\_")[0]);
                } else {
                    com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + ", not apk file, continue!");
                }
            }
            if (map.size() > 0) {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size = " + map.size());
                java.io.File pluginPath = com.tencent.midas.plugin.APPluginConfig.getPluginPath(context);
                for (com.tencent.midas.plugin.APSignIniItem aPSignIniItem : map.values()) {
                    com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName);
                    if (!new java.io.File(pluginPath, aPSignIniItem.fullName).exists()) {
                        com.tencent.midas.comm.APLog.e(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " missing in midasplugins!");
                        com.tencent.midas.plugin.APPluginUtils.clearDirContent(pluginUpdatePath);
                        return false;
                    }
                    com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " exist in midasplugins!");
                }
            } else {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size is 0");
            }
            if (!z) {
                com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == false!");
                return false;
            }
            com.tencent.midas.comm.APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == true!");
            com.tencent.midas.comm.APLog.e(TAG, "isNeedUpdateFromLocal, return true!");
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.e(TAG, "isNeedUpdateFromLocal, got exception = " + e);
            e.printStackTrace();
            return false;
        }
    }

    public static void unInstallPlugin(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "unInstallPlugin " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        com.tencent.midas.plugin.APPluginUtils.deletePlugin(context);
        com.tencent.midas.plugin.APPluginUtils.deleteDex(context);
        com.tencent.midas.plugin.APPluginUtils.deleteLibs(context);
        sInstallPathMap.clear();
        sPackageInfoMap.clear();
        com.tencent.midas.plugin.APPluginStatic.release();
        com.tencent.midas.plugin.APPluginConfig.libExtend++;
    }
}
