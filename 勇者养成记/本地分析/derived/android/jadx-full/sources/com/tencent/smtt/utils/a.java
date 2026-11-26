package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static int a(android.content.Context context, java.io.File file) {
        try {
            return a(context, file, android.os.Build.VERSION.SDK_INT >= 20 ? !com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().canUseFunction(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME) : false);
        } catch (java.lang.Exception unused) {
            com.tencent.smtt.utils.TbsLog.i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    public static int a(android.content.Context context, java.io.File file, boolean z) {
        int iB;
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean zContains = file.getName().contains("tbs.org");
                    boolean zContains2 = file.getName().contains("x5.tbs.decouple");
                    if (zContains || zContains2) {
                        int iA = a(zContains2, file);
                        if (iA > 0) {
                            return iA;
                        }
                        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    boolean z2 = (android.os.Build.VERSION.SDK_INT == 23 || android.os.Build.VERSION.SDK_INT == 25) && android.os.Build.MANUFACTURER.toLowerCase().contains("mi");
                    com.tencent.smtt.sdk.TbsPVConfig.releaseInstance();
                    int readApk = com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z = false;
                        z2 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if ((z || z2) && (iB = b(file)) > 0) {
                        return iB;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    private static int a(boolean z, java.io.File file) {
        try {
            java.io.File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            java.io.File[] fileArrListFiles = parentFile.listFiles();
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(a(z) + "(.*)");
            for (java.io.File file2 : fileArrListFiles) {
                if (patternCompile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return java.lang.Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0068: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:32:0x0068 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        int i;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        java.io.FileInputStream fileInputStream3 = null;
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    byte[] bArrDigest = messageDigest.digest();
                    int i3 = 0;
                    for (i = 0; i < 16; i++) {
                        byte b = bArrDigest[i];
                        int i4 = i3 + 1;
                        cArr2[i3] = cArr[(b >>> 4) & 15];
                        i3 = i4 + 1;
                        cArr2[i4] = cArr[b & 15];
                    }
                    java.lang.String str = new java.lang.String(cArr2);
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            throw th;
        }
    }

    public static final java.lang.String a(boolean z) {
        if (com.tencent.smtt.utils.b.c()) {
            return z ? "x5.64.decouple.backup" : "x5.64.backup";
        }
        return z ? "x5.decouple.backup" : "x5.backup";
    }

    public static boolean a(android.content.Context context, java.io.File file, long j, int i) {
        if (file != null && file.exists()) {
            if (j > 0 && j != file.length()) {
                return false;
            }
            try {
                return i == a(context, file) && "[REDACTED_HEX_CONSTANT]".equals(com.tencent.smtt.utils.b.a(context, true, file));
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x007c A[Catch: all -> 0x0078, Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:43:0x0074, B:47:0x007c), top: B:55:0x0074 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int b(java.io.File file) {
        java.util.jar.JarFile jarFile;
        java.lang.String[] strArrSplit;
        synchronized (com.tencent.smtt.utils.a.class) {
            java.io.BufferedReader bufferedReader = null;
            try {
                try {
                    try {
                        jarFile = new java.util.jar.JarFile(file);
                        try {
                            try {
                                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                                while (true) {
                                    try {
                                        java.lang.String line = bufferedReader2.readLine();
                                        if (line == null) {
                                            bufferedReader2.close();
                                            break;
                                        }
                                        if (line.contains("tbs_core_version") && (strArrSplit = line.split("=")) != null && strArrSplit.length == 2) {
                                            int i = java.lang.Integer.parseInt(strArrSplit[1].trim());
                                            try {
                                                bufferedReader2.close();
                                                jarFile.close();
                                            } catch (java.lang.Exception unused) {
                                            }
                                            return i;
                                        }
                                    } catch (java.lang.Exception e) {
                                        bufferedReader = bufferedReader2;
                                        e = e;
                                        e.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (jarFile != null) {
                                            break;
                                        }
                                        return -1;
                                    } catch (java.lang.Throwable th) {
                                        bufferedReader = bufferedReader2;
                                        th = th;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                                if (jarFile != null) {
                                                    jarFile.close();
                                                }
                                            } catch (java.lang.Exception unused2) {
                                                throw th;
                                            }
                                        } else if (jarFile != null) {
                                            jarFile.close();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } catch (java.lang.Exception unused3) {
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    jarFile = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    jarFile = null;
                }
                jarFile.close();
                return -1;
            } catch (java.lang.Throwable th4) {
                throw th4;
            }
        }
    }
}
