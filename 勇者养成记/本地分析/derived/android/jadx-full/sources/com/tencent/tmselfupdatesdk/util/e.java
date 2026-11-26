package com.tencent.tmselfupdatesdk.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static void a(java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:77:0x013d A[PHI: r0 r3 r4 r6
  0x013d: PHI (r0v5 'th' java.lang.Throwable) = (r0v4 'th' java.lang.Throwable), (r0v9 'th' java.lang.Throwable) binds: [B:76:0x013b, B:51:0x010b] A[DONT_GENERATE, DONT_INLINE]
  0x013d: PHI (r3v1 boolean) = (r3v0 boolean), (r3v4 boolean) binds: [B:76:0x013b, B:51:0x010b] A[DONT_GENERATE, DONT_INLINE]
  0x013d: PHI (r4v4 java.io.FileOutputStream) = (r4v3 java.io.FileOutputStream), (r4v8 java.io.FileOutputStream) binds: [B:76:0x013b, B:51:0x010b] A[DONT_GENERATE, DONT_INLINE]
  0x013d: PHI (r6v4 java.io.InputStream) = (r6v3 java.io.InputStream), (r6v11 java.io.InputStream) binds: [B:76:0x013b, B:51:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.util.zip.ZipFile zipFile;
        java.io.InputStream inputStream;
        java.io.File file = new java.io.File(str2);
        boolean z = false;
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            zipFile = new java.util.zip.ZipFile(new java.io.File(str));
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                inputStream = null;
                while (true) {
                    try {
                        if (!enumerationEntries.hasMoreElements()) {
                            z = true;
                            break;
                        }
                        java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        java.lang.String name = zipEntryNextElement.getName();
                        if (name != null) {
                            name = name.replace("\\", java.io.File.separator);
                        }
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            name = str3;
                        }
                        if (zipEntryNextElement.isDirectory()) {
                            java.io.File file2 = new java.io.File(str2 + java.io.File.separator + name);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                        } else {
                            inputStream = zipFile.getInputStream(zipEntryNextElement);
                            java.util.zip.CheckedInputStream checkedInputStream = new java.util.zip.CheckedInputStream(inputStream, new java.util.zip.CRC32());
                            java.io.File file3 = new java.io.File(new java.lang.String((str2 + java.io.File.separator + name).getBytes("8859_1"), "GB2312"));
                            if (!file3.exists()) {
                                java.io.File parentFile = file3.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                file3.createNewFile();
                            }
                            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file3);
                            try {
                                byte[] bArr = new byte[4096];
                                long size = zipEntryNextElement.getSize();
                                while (size > 0) {
                                    int i = checkedInputStream.read(bArr, 0, 4096);
                                    fileOutputStream2.write(bArr, 0, i);
                                    size -= (long) i;
                                }
                                if (zipEntryNextElement.getCrc() != checkedInputStream.getChecksum().getValue()) {
                                    a(fileOutputStream2);
                                    a(inputStream);
                                    fileOutputStream = fileOutputStream2;
                                    break;
                                }
                                a(fileOutputStream2);
                                a(inputStream);
                                fileOutputStream = fileOutputStream2;
                            } catch (java.lang.Exception unused) {
                                fileOutputStream = fileOutputStream2;
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        if (com.tencent.tmassistantbase.common.a.f1018a) {
                                            th.printStackTrace();
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (java.lang.Throwable th4) {
                                        if (com.tencent.tmassistantbase.common.a.f1018a) {
                                            th4.printStackTrace();
                                        }
                                    }
                                }
                                a(fileOutputStream);
                                a(inputStream);
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception unused2) {
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        th = th;
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        a(fileOutputStream);
                        a(inputStream);
                        throw th;
                    }
                }
                try {
                    zipFile.close();
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    if (com.tencent.tmassistantbase.common.a.f1018a) {
                        th.printStackTrace();
                    }
                }
            } catch (java.lang.Exception unused3) {
                inputStream = null;
            } catch (java.lang.Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (java.lang.Exception unused4) {
            zipFile = null;
            inputStream = null;
        } catch (java.lang.Throwable th8) {
            th = th8;
            zipFile = null;
            inputStream = null;
        }
        a(fileOutputStream);
        a(inputStream);
        return z;
    }
}
