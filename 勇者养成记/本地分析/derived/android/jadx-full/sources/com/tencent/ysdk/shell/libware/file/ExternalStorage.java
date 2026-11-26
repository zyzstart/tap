package com.tencent.ysdk.shell.libware.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ExternalStorage {
    public static final java.lang.String EXTERNAL_SD_CARD = "externalSdCard";
    public static final java.lang.String SD_CARD = "sdCard";

    private static void appendExtraStoragePath(java.lang.String str, java.util.List<java.lang.String> list, java.lang.String str2, java.lang.String str3) {
        if (str3.contains("fat")) {
            java.lang.String[] strArrSplit = str3.split(" ");
            if (strArrSplit.length <= 1 || str2.equals(strArrSplit[1]) || str.length() <= 0 || !strArrSplit[1].contains(str)) {
                return;
            }
            list.add(strArrSplit[1]);
        }
    }

    public static long getAvailableExternalSdCardSize() throws java.lang.Throwable {
        java.util.List<java.lang.String> externalSDCardPaths = getExternalSDCardPaths();
        long availableBlocks = 0;
        for (int i = 0; i < externalSDCardPaths.size(); i++) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(externalSDCardPaths.get(i));
                availableBlocks += ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (java.lang.IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return availableBlocks;
    }

    public static java.io.File getExternalSDCardDirectory() {
        java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
        java.io.File[] fileArrListFiles = externalStorageDirectory.getParentFile().listFiles();
        if (fileArrListFiles == null) {
            return externalStorageDirectory;
        }
        for (java.io.File file : fileArrListFiles) {
            if (file.compareTo(externalStorageDirectory) != 0) {
                return file;
            }
        }
        return externalStorageDirectory;
    }

    public static java.util.List<java.lang.String> getExternalSDCardPaths() throws java.lang.Throwable {
        java.lang.String parent;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String parent2 = android.os.Environment.getExternalStorageDirectory().getParent();
        java.lang.String[] strArrSplit = !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(parent2) ? parent2.split("/") : null;
        if (strArrSplit == null || strArrSplit.length <= 1) {
            parent = android.os.Environment.getExternalStorageDirectory().getParent();
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(parent)) {
                parent = "";
            }
        } else {
            parent = "/" + strArrSplit[1];
        }
        getExtraStoragePath(parent, arrayList);
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0047 A[Catch: Exception -> 0x0077, PHI: r1 r2 r3 r4
  0x0047: PHI (r1v9 ??) = (r1v11 ??), (r1v12 ??) binds: [B:42:0x0074, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]
  0x0047: PHI (r2v5 java.io.BufferedReader) = (r2v14 java.io.BufferedReader), (r2v15 java.io.BufferedReader) binds: [B:42:0x0074, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]
  0x0047: PHI (r3v8 java.io.InputStream) = (r3v6 java.io.InputStream), (r3v12 java.io.InputStream) binds: [B:42:0x0074, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]
  0x0047: PHI (r4v6 ??) = (r4v10 ??), (r4v11 ??) binds: [B:42:0x0074, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {Exception -> 0x0077, blocks: (B:16:0x003c, B:18:0x0047, B:41:0x006b), top: B:60:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0084 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #5 {Exception -> 0x0087, blocks: (B:46:0x0079, B:48:0x0084), top: B:58:0x0079 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Runtime] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void getExtraStoragePath(java.lang.String str, java.util.List<java.lang.String> list) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        ?? inputStreamReader;
        ?? r4;
        java.io.BufferedReader bufferedReader;
        ?? r1;
        java.lang.String line;
        java.lang.String absolutePath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        ?? runtime = java.lang.Runtime.getRuntime();
        java.io.BufferedReader bufferedReader2 = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader2 = null;
        java.io.BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        try {
            try {
                runtime = runtime.exec("mount");
                try {
                    inputStream = runtime.getInputStream();
                    try {
                        inputStreamReader = new java.io.InputStreamReader(inputStream);
                        try {
                            java.io.BufferedReader bufferedReader4 = new java.io.BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    line = bufferedReader4.readLine();
                                    if (line == null) {
                                        break;
                                    } else if (!line.contains("secure") && !line.contains("asec")) {
                                        appendExtraStoragePath(str, list, absolutePath, line);
                                    }
                                } catch (java.io.IOException e) {
                                    e = e;
                                    bufferedReader3 = bufferedReader4;
                                    e.printStackTrace();
                                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader3);
                                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStreamReader);
                                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                                    r1 = runtime;
                                    bufferedReader = bufferedReader3;
                                    r4 = inputStreamReader;
                                    runtime = runtime;
                                    bufferedReader2 = bufferedReader3;
                                    inputStreamReader = inputStreamReader;
                                    if (runtime != 0) {
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader4;
                                    try {
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader2);
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStreamReader);
                                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                                        if (runtime != 0) {
                                            runtime.destroy();
                                        }
                                    } catch (java.lang.Exception unused) {
                                    }
                                    throw th;
                                }
                            }
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader4);
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStreamReader);
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                            r1 = runtime;
                            bufferedReader = line;
                            r4 = inputStreamReader;
                            runtime = runtime;
                            bufferedReader2 = line;
                            inputStreamReader = inputStreamReader;
                            if (runtime != 0) {
                                r1.destroy();
                                runtime = r1;
                                bufferedReader2 = bufferedReader;
                                inputStreamReader = r4;
                            }
                        } catch (java.io.IOException e2) {
                            e = e2;
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        inputStreamReader = 0;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStreamReader = 0;
                    }
                } catch (java.io.IOException e4) {
                    e = e4;
                    inputStream = null;
                    runtime = runtime;
                    inputStreamReader = inputStream;
                    e.printStackTrace();
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader3);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStreamReader);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                    r1 = runtime;
                    bufferedReader = bufferedReader3;
                    r4 = inputStreamReader;
                    runtime = runtime;
                    bufferedReader2 = bufferedReader3;
                    inputStreamReader = inputStreamReader;
                    if (runtime != 0) {
                        r1.destroy();
                        runtime = r1;
                        bufferedReader2 = bufferedReader;
                        inputStreamReader = r4;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    inputStream = null;
                    runtime = runtime;
                    inputStreamReader = inputStream;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader2);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStreamReader);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                    if (runtime != 0) {
                        runtime.destroy();
                    }
                    throw th;
                }
            } catch (java.io.IOException e5) {
                e = e5;
                runtime = 0;
                inputStream = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                runtime = 0;
                inputStream = null;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    public static java.lang.String getSdCardPath() {
        return android.os.Environment.getExternalStorageDirectory().getPath() + "/";
    }

    public static long getTotalExternalSdCardSize() throws java.lang.Throwable {
        java.util.List<java.lang.String> externalSDCardPaths = getExternalSDCardPaths();
        long blockCount = 0;
        for (int i = 0; i < externalSDCardPaths.size(); i++) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(externalSDCardPaths.get(i));
                blockCount += ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (java.lang.IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return blockCount;
    }

    public static boolean isAvailable() {
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean isExternalStorageAvailable(android.content.Context context) {
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadWriteExternalPermission(context)) {
            return false;
        }
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
        return "mounted".equals(externalStorageState) && externalStorageDirectory.exists() && externalStorageDirectory.canWrite() && externalStorageDirectory.canRead();
    }
}
