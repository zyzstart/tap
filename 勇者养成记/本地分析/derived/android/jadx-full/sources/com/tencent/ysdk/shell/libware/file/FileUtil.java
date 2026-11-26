package com.tencent.ysdk.shell.libware.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FileUtil {
    public static final java.lang.String APP_SDCARD_AMOUNT_ROOT_PATH = "/tencent/YSDK";
    public static final java.lang.String APP_SDCARD_UNAMOUNT_ROOT_PATH = "/YSDK";
    private static final java.lang.String TAG = "FileUtils";

    public static void clearInternalCache(java.lang.String str, android.content.Context context) {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(getInternalCachePath(context) + str);
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            file2.delete();
        }
    }

    public static byte[] compressBitmap(android.graphics.Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static boolean copy(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return copyFile(file, new java.io.File(str2), false);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054 A[Catch: IOException -> 0x0057, TRY_LEAVE, TryCatch #0 {IOException -> 0x0057, blocks: (B:28:0x004f, B:30:0x0054), top: B:41:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:35:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0060 A[Catch: IOException -> 0x0063, TRY_LEAVE, TryCatch #2 {IOException -> 0x0063, blocks: (B:34:0x005b, B:36:0x0060), top: B:43:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:43:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean copyFile(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull java.io.File file2, boolean z) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        if (!createDirOrFileIfNotExists(file2, z)) {
            return false;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2.getAbsolutePath());
                try {
                    saveFile(fileInputStream2, fileOutputStream);
                    try {
                        fileInputStream2.close();
                        fileOutputStream.close();
                        return true;
                    } catch (java.io.IOException unused) {
                        return true;
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "copyFile  copy error:" + e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (java.io.IOException unused2) {
                                return false;
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (java.io.IOException unused3) {
                                throw th;
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static boolean createDirOrFileIfNotExists(@androidx.annotation.NonNull java.io.File file, boolean z) {
        if (file.exists()) {
            return true;
        }
        try {
            java.io.File parentFile = file.getParentFile();
            if (!parentFile.exists() || !parentFile.isDirectory()) {
                parentFile.delete();
                parentFile.mkdirs();
            }
            return z ? file.mkdirs() : file.createNewFile();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "createFileIfNotExists error:" + e.getMessage());
            return false;
        }
    }

    public static boolean deleteFile(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static java.lang.String getCommonRootDir(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            java.lang.String commonRootDirOnAndroidQ = getCommonRootDirOnAndroidQ(context);
            if (!android.text.TextUtils.isEmpty(commonRootDirOnAndroidQ)) {
                return commonRootDirOnAndroidQ;
            }
            java.lang.String commonRootDirBelowAndroidQ = getCommonRootDirBelowAndroidQ(context);
            return android.text.TextUtils.isEmpty(commonRootDirBelowAndroidQ) ? "" : commonRootDirBelowAndroidQ;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
            return "";
        }
    }

    private static java.lang.String getCommonRootDirBelowAndroidQ(android.content.Context context) {
        if (!com.tencent.ysdk.shell.libware.file.ExternalStorage.isExternalStorageAvailable(context)) {
            return context.getFilesDir().getAbsolutePath() + "/YSDK";
        }
        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + "/tencent/YSDK");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static java.lang.String getCommonRootDirOnAndroidQ(android.content.Context context) {
        java.io.File externalFilesDir;
        if (android.os.Build.VERSION.SDK_INT < 29 || (externalFilesDir = context.getExternalFilesDir("/tencent/YSDK")) == null) {
            return "";
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static java.lang.String getFileExtension(java.lang.String str) {
        java.lang.String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        if (strSubstring.contains(".")) {
            return strSubstring.substring(strSubstring.indexOf(".") + 1);
        }
        return null;
    }

    public static long getFileLastModified(java.lang.String str) {
        if (str != null) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return file.lastModified();
            }
        }
        return 0L;
    }

    public static java.lang.String getFileName(java.lang.String str) {
        java.lang.String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        return strSubstring.contains(".") ? strSubstring.substring(0, strSubstring.indexOf(".")) : strSubstring;
    }

    public static long getFileSize(java.lang.String str) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return 0L;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public static java.lang.String getInternalCachePath(android.content.Context context) {
        java.lang.String str = context.getCacheDir() + java.io.File.separator;
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static java.lang.String getPath(java.lang.String str, boolean z) {
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            if (z) {
                try {
                    new java.io.File(str + java.io.File.separator + ".nomedia").createNewFile();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file.getAbsolutePath();
    }

    public static boolean isFileExists(java.io.File file) {
        if (file == null) {
            return true;
        }
        return file.exists();
    }

    public static boolean isSDCardExistAndCanRead() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.getExternalStorageDirectory().canRead();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "isSDCardExistAndCanRead error:" + e.getMessage());
            return false;
        }
    }

    public static boolean isSDCardExistAndCanWrite() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.getExternalStorageDirectory().canWrite();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "isSDCardExistAndCanWrite error:" + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003f A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #7 {Exception -> 0x0042, blocks: (B:24:0x003a, B:26:0x003f), top: B:43:0x003a }] */
    public static java.lang.String read(java.lang.String str) throws java.lang.Throwable {
        java.io.FileReader fileReader;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return "";
        }
        java.io.BufferedReader bufferedReader = null;
        try {
            fileReader = new java.io.FileReader(file);
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(fileReader);
                try {
                    java.lang.String line = bufferedReader2.readLine();
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (java.lang.Exception unused) {
                    }
                    return line;
                } catch (java.lang.Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception unused3) {
                            return "";
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                    fileReader.close();
                    return "";
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (java.lang.Exception unused4) {
                            throw th;
                        }
                    } else if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused5) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception unused6) {
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
    }

    public static boolean readFile(java.lang.String str, java.io.ByteArrayOutputStream byteArrayOutputStream, com.tencent.ysdk.shell.libware.file.ByteArrayPool byteArrayPool) throws java.lang.Throwable {
        byte[] bArr;
        java.io.File file = new java.io.File(str);
        if (byteArrayOutputStream == null || file.length() == 0) {
            return false;
        }
        java.io.FileInputStream fileInputStream = null;
        buf = null;
        byte[] buf = null;
        fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                buf = byteArrayPool != null ? byteArrayPool.getBuf(1024) : new byte[1024];
                while (true) {
                    int i = fileInputStream2.read(buf);
                    if (-1 == i) {
                        break;
                    }
                    byteArrayOutputStream.write(buf, 0, i);
                }
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream2);
                if (buf != null && byteArrayPool != null) {
                    byteArrayPool.returnBuf(buf);
                }
            } catch (java.lang.Exception e) {
                e = e;
                bArr = buf;
                fileInputStream = fileInputStream2;
                try {
                    com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "readFile error:" + e.getMessage());
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                    if (bArr != null && byteArrayPool != null) {
                        byteArrayPool.returnBuf(bArr);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                    if (bArr != null && byteArrayPool != null) {
                        byteArrayPool.returnBuf(bArr);
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bArr = buf;
                fileInputStream = fileInputStream2;
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                if (bArr != null) {
                    byteArrayPool.returnBuf(bArr);
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bArr = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bArr = null;
        }
        return byteArrayOutputStream.size() > 0;
    }

    private static boolean saveFile(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    outputStream.flush();
                    return true;
                }
                outputStream.write(bArr, 0, i);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "saveFile error:" + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062 A[Catch: IOException -> 0x0065, TRY_LEAVE, TryCatch #1 {IOException -> 0x0065, blocks: (B:21:0x005d, B:23:0x0062), top: B:35:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006d A[Catch: IOException -> 0x0070, TRY_LEAVE, TryCatch #5 {IOException -> 0x0070, blocks: (B:26:0x0068, B:28:0x006d), top: B:39:0x0068 }] */
    public static boolean saveFileFromStream(java.io.InputStream inputStream, java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.File file2 = new java.io.File(file.getAbsolutePath() + str);
        if (!createDirOrFileIfNotExists(file2, false)) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2.getAbsolutePath());
                try {
                    boolean zSaveFile = saveFile(inputStream, fileOutputStream2);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    fileOutputStream2.close();
                    return zSaveFile;
                } catch (java.lang.Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "saveFileFromStream error:" + e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (java.io.IOException unused2) {
                            return false;
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (java.io.IOException unused3) {
                            throw th;
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean unzipFile(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull java.io.File file2) throws java.lang.Throwable {
        java.util.zip.ZipInputStream zipInputStream;
        java.io.FileInputStream fileInputStream;
        if (!file2.exists()) {
            return false;
        }
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        java.lang.String str = file.getAbsolutePath() + "/";
        java.util.zip.ZipInputStream zipInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file2);
                try {
                    zipInputStream = new java.util.zip.ZipInputStream(fileInputStream);
                    try {
                        byte[] bArr = new byte[512];
                        while (true) {
                            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(zipInputStream);
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                                return true;
                            }
                            java.lang.String name = nextEntry.getName();
                            if (nextEntry.isDirectory()) {
                                new java.io.File(str + name).mkdirs();
                            } else {
                                java.io.File file3 = new java.io.File(str + name);
                                if (!file3.exists()) {
                                    file3.createNewFile();
                                }
                                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str + name);
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                zipInputStream.closeEntry();
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        zipInputStream2 = zipInputStream;
                        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "unzipFile error:" + e.getMessage());
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(zipInputStream2);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(zipInputStream);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(fileInputStream);
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                zipInputStream = zipInputStream2;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            zipInputStream = null;
            fileInputStream = null;
        }
    }
}
