package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"NewApi"})
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f975a = null;
    public static final com.tencent.smtt.utils.f.a b = new com.tencent.smtt.utils.f.a() { // from class: com.tencent.smtt.utils.f.2
        @Override // com.tencent.smtt.utils.f.a
        public boolean a(java.io.File file, java.io.File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };
    private static final int c = 4;
    private static java.io.RandomAccessFile d;

    public interface a {
        boolean a(java.io.File file, java.io.File file2);
    }

    public interface b {
        boolean a(java.io.InputStream inputStream, java.util.zip.ZipEntry zipEntry, java.lang.String str);
    }

    public static java.io.File a(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            com.tencent.smtt.utils.TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
            return null;
        }
        java.io.File file2 = new java.io.File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (java.io.IOException e) {
                com.tencent.smtt.utils.TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: " + e);
                return null;
            }
        }
        return file2;
    }

    public static java.io.File a(android.content.Context context, boolean z, java.lang.String str) {
        java.lang.String strD = z ? d(context) : c(context);
        if (strD == null) {
            return null;
        }
        java.io.File file = new java.io.File(strD);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        java.io.File file2 = new java.io.File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static java.lang.String a(android.content.Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, int i, boolean z) {
        if (context == null) {
            return "";
        }
        java.lang.String str2 = "";
        try {
            str2 = android.os.Environment.getExternalStorageDirectory() + java.io.File.separator;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + java.io.File.separator + "tbs" + java.io.File.separator + str;
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tbs" + java.io.File.separator + "backup" + java.io.File.separator + str;
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + java.io.File.separator + "tbs" + java.io.File.separator + "backup" + java.io.File.separator + str;
            case 4:
                if (str2.equals("")) {
                    return b(context, "backup");
                }
                java.lang.String str3 = str2 + "tencent" + java.io.File.separator + "tbs" + java.io.File.separator + "backup" + java.io.File.separator + str;
                if (!z) {
                    return str3;
                }
                java.io.File file = new java.io.File(str3);
                if (file.exists() && file.canWrite()) {
                    return str3;
                }
                if (!file.exists()) {
                    file.mkdirs();
                    if (file.canWrite()) {
                        return str3;
                    }
                }
                return b(context, "backup");
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + java.io.File.separator + "tbs" + java.io.File.separator + str;
            case 6:
                java.lang.String str4 = f975a;
                if (str4 != null) {
                    return str4;
                }
                java.lang.String strB = b(context, "tbslog");
                f975a = strB;
                return strB;
            case 7:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + java.io.File.separator + "tbs" + java.io.File.separator + "backup" + java.io.File.separator + "core";
            case 8:
                return b(context, "env");
            default:
                return "";
        }
    }

    public static java.nio.channels.FileLock a(android.content.Context context, java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            java.nio.channels.FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock.isValid()) {
                return fileLockTryLock;
            }
            return null;
        } catch (java.nio.channels.OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void a(android.content.Context context, java.nio.channels.FileLock fileLock) {
        com.tencent.smtt.utils.TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
        java.nio.channels.FileChannel fileChannelChannel = fileLock.channel();
        if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
            try {
                fileLock.release();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(java.io.File file, boolean z) {
        com.tencent.smtt.utils.TbsLog.i("FileUtils", "delete file,ignore=" + z + file + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            a(file2, z);
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(java.io.File file, boolean z, java.lang.String str) {
        com.tencent.smtt.utils.TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (!file2.getName().equals(str)) {
                a(file2, z);
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(java.nio.channels.FileLock fileLock, java.io.FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                java.nio.channels.FileChannel fileChannelChannel = fileLock.channel();
                if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
                    fileLock.release();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return context != null && context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean a(java.io.File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static boolean a(java.io.File file, java.io.File file2) {
        return a(file.getPath(), file2.getPath());
    }

    public static boolean a(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter) {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter, com.tencent.smtt.utils.f.a aVar) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        java.io.File[] fileArrListFiles = file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (java.io.File file3 : fileArrListFiles) {
            if (!a(file3, new java.io.File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean a(java.lang.String str, long j, long j2, long j3) throws java.lang.Throwable {
        java.io.File file = new java.io.File(str);
        if (file.length() != j) {
            com.tencent.smtt.utils.TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, i);
                }
                long value = crc32.getValue();
                com.tencent.smtt.utils.TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value != j3) {
                    fileInputStream2.close();
                    return true;
                }
                fileInputStream2.close();
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static boolean a(java.lang.String str, java.lang.String str2) {
        return a(str, str2, android.os.Build.CPU_ABI, android.os.Build.VERSION.SDK_INT >= 8 ? android.os.Build.CPU_ABI2 : null, com.tencent.smtt.utils.j.a("ro.product.cpu.upgradeabi", "armeabi"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.tencent.smtt.utils.f.b bVar) throws java.lang.Throwable {
        java.util.zip.ZipFile zipFile;
        try {
            zipFile = new java.util.zip.ZipFile(str);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                boolean z = false;
                boolean z2 = false;
                while (enumerationEntries.hasMoreElements()) {
                    java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    java.lang.String name = zipEntryNextElement.getName();
                    if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                        java.lang.String strSubstring = name.substring(name.lastIndexOf(47));
                        if (strSubstring.endsWith(".so")) {
                            if (name.regionMatches(c, str2, 0, str2.length()) && name.charAt(c + str2.length()) == '/') {
                                z = true;
                            } else if (str3 != null && name.regionMatches(c, str3, 0, str3.length()) && name.charAt(c + str3.length()) == '/') {
                                if (z) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                            } else if (str4 != null && name.regionMatches(c, str4, 0, str4.length()) && name.charAt(c + str4.length()) == '/' && !z && !z2) {
                            }
                        }
                        java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        try {
                            if (!bVar.a(inputStream, zipEntryNextElement, strSubstring.substring(1))) {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                zipFile.close();
                                return false;
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (java.lang.Throwable th) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    }
                }
                zipFile.close();
                return true;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    private static boolean a(java.lang.String str, final java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return a(str, str3, str4, str5, new com.tencent.smtt.utils.f.b() { // from class: com.tencent.smtt.utils.f.1
            @Override // com.tencent.smtt.utils.f.b
            public boolean a(java.io.InputStream inputStream, java.util.zip.ZipEntry zipEntry, java.lang.String str6) throws java.lang.Exception {
                try {
                    return com.tencent.smtt.utils.f.b(inputStream, zipEntry, str2, str6);
                } catch (java.lang.Exception e) {
                    throw new java.lang.Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    public static java.io.FileOutputStream b(android.content.Context context, boolean z, java.lang.String str) {
        java.io.File fileA = a(context, z, str);
        if (fileA == null) {
            return null;
        }
        try {
            return new java.io.FileOutputStream(fileA);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            try {
                return android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "Android" + java.io.File.separator + com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA + java.io.File.separator + context.getApplicationInfo().packageName + java.io.File.separator + "files" + java.io.File.separator + str;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void b(java.io.File file) {
        a(file, false);
    }

    public static boolean b(android.content.Context context) {
        long jA = com.tencent.smtt.utils.q.a();
        boolean z = jA >= com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + jA);
        }
        return z;
    }

    public static boolean b(java.io.File file, java.io.File file2) {
        return a(file, file2, (java.io.FileFilter) null);
    }

    private static boolean b(java.io.File file, java.io.File file2, java.io.FileFilter fileFilter, com.tencent.smtt.utils.f.a aVar) throws java.lang.Throwable {
        java.nio.channels.FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        java.nio.channels.FileChannel channel = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (aVar != null && aVar.a(file, file2)) {
                        return true;
                    }
                    b(file2);
                }
                java.io.File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    b(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                java.nio.channels.FileChannel channel2 = new java.io.FileInputStream(file).getChannel();
                try {
                    channel = new java.io.FileOutputStream(file2).getChannel();
                    long size = channel2.size();
                    if (channel.transferFrom(channel2, 0L, size) == size) {
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        return true;
                    }
                    b(file2);
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    java.nio.channels.FileChannel fileChannel2 = channel;
                    channel = channel2;
                    th = th;
                    fileChannel = fileChannel2;
                }
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.annotation.SuppressLint({"NewApi"})
    public static boolean b(java.io.InputStream inputStream, java.util.zip.ZipEntry zipEntry, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        a(new java.io.File(str));
        java.lang.String str3 = str + java.io.File.separator + str2;
        java.io.File file = new java.io.File(str3);
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                    fileOutputStream2.close();
                    if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                        com.tencent.smtt.utils.TbsLog.e("FileHelper", "file is different: " + str3);
                        return false;
                    }
                    if (file.setLastModified(zipEntry.getTime())) {
                        return true;
                    }
                    com.tencent.smtt.utils.TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                    return true;
                } catch (java.io.IOException e) {
                    e = e;
                    b(file);
                    throw new java.io.IOException("Couldn't write dst file " + file, e);
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        return android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "tbs" + java.io.File.separator + "file_locks";
    }

    public static boolean c(java.io.File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static java.io.FileOutputStream d(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new java.io.IOException("File '" + file + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new java.io.IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new java.io.IOException("File '" + file + "' cannot be written to");
            }
        }
        return new java.io.FileOutputStream(file);
    }

    static java.lang.String d(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static java.nio.channels.FileLock e(android.content.Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        com.tencent.smtt.utils.TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            tbsCoreLoadRenameFileLockEnable = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (java.lang.Throwable unused) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        java.nio.channels.FileLock fileLockG = null;
        if (!tbsCoreLoadRenameFileLockEnable) {
            java.io.FileOutputStream fileOutputStreamB = b(context, true, "tbs_rename_lock");
            if (fileOutputStreamB == null) {
                str2 = "FileHelper";
                str3 = "init -- failed to get rename fileLock#1!";
            } else {
                fileLockG = a(context, fileOutputStreamB);
                if (fileLockG == null) {
                    str2 = "FileHelper";
                    str3 = "init -- failed to get rename fileLock#2!";
                } else {
                    str2 = "FileHelper";
                    str3 = "init -- get rename fileLock success!";
                }
            }
            com.tencent.smtt.utils.TbsLog.i(str2, str3);
            com.tencent.smtt.utils.TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + fileLockG);
            return fileLockG;
        }
        com.tencent.smtt.utils.TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
        java.io.File fileA = a(context, "tbs_rename_lock");
        com.tencent.smtt.utils.TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + fileA);
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileA.getAbsolutePath(), "r");
            d = randomAccessFile;
            fileLockG = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
        }
        if (fileLockG == null) {
            fileLockG = g(context);
        }
        if (fileLockG == null) {
            sb = new java.lang.StringBuilder();
            str = "getTbsCoreLoadFileLock -- failed: ";
        } else {
            sb = new java.lang.StringBuilder();
            str = "getTbsCoreLoadFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        com.tencent.smtt.utils.TbsLog.i("FileHelper", sb.toString());
        return fileLockG;
    }

    public static java.nio.channels.FileLock f(android.content.Context context) {
        java.nio.channels.FileLock fileLockTryLock;
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.io.File fileA = a(context, "tbs_rename_lock");
        com.tencent.smtt.utils.TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + fileA);
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileA.getAbsolutePath(), "rw");
            d = randomAccessFile;
            fileLockTryLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (java.lang.Throwable unused) {
            com.tencent.smtt.utils.TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLockTryLock = null;
        }
        if (fileLockTryLock == null) {
            sb = new java.lang.StringBuilder();
            str = "getTbsCoreRenameFileLock -- failed: ";
        } else {
            sb = new java.lang.StringBuilder();
            str = "getTbsCoreRenameFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        com.tencent.smtt.utils.TbsLog.i("FileHelper", sb.toString());
        return fileLockTryLock;
    }

    private static java.nio.channels.FileLock g(android.content.Context context) {
        java.nio.channels.FileLock fileLock = null;
        try {
            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            java.io.File fileA = a(context, "tbs_rename_lock");
            if (!com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                return null;
            }
            java.nio.channels.FileLock fileLockTryLock = null;
            int i = 0;
            while (i < 20 && fileLockTryLock == null) {
                try {
                    try {
                        java.lang.Thread.sleep(100L);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileA.getAbsolutePath(), "r");
                    d = randomAccessFile;
                    fileLockTryLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                try {
                    i++;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileLock = fileLockTryLock;
                    e.printStackTrace();
                    return fileLock;
                }
            }
            if (fileLockTryLock != null) {
                tbsLogInfo.setErrorCode(802);
            } else {
                tbsLogInfo.setErrorCode(801);
            }
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getTbsCoreLoadFileLock,retry num=");
            sb.append(i);
            sb.append("success=");
            sb.append(fileLockTryLock == null);
            com.tencent.smtt.utils.TbsLog.i("FileHelper", sb.toString());
            return fileLockTryLock;
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }
}
