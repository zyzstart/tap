package com.tencent.ysdk.shell.libware.encrypt;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MD5 {
    public static final java.lang.String TAG = "andygzyu-MD5";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = hexDigits;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public static boolean checkFileMd5(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        try {
            java.lang.String fileMD5 = getFileMD5(file);
            com.tencent.ysdk.shell.libware.file.Logger.d("fileMd5:" + fileMD5 + ";hashValue:" + str);
            return fileMD5.equalsIgnoreCase(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String getEndMd5FromFile(java.lang.String str, int i) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        byte[] bArr;
        java.io.File file = new java.io.File(str);
        long length = file.length();
        ?? r7 = 0;
        r7 = 0;
        r7 = 0;
        r7 = 0;
        r7 = 0;
        try {
            try {
                try {
                    randomAccessFile = new java.io.RandomAccessFile(file, "r");
                    long j = i;
                    int i2 = 0;
                    try {
                        if (length <= j) {
                            bArr = new byte[(int) length];
                            while (true) {
                                long j2 = i2;
                                if (j2 >= length) {
                                    break;
                                }
                                i2 += randomAccessFile.read(bArr, i2, (int) (length - j2));
                            }
                        } else {
                            randomAccessFile.seek(length - j);
                            byte[] bArr2 = new byte[i];
                            while (i2 < i) {
                                i2 += randomAccessFile.read(bArr2, i2, i - i2);
                            }
                            bArr = bArr2;
                        }
                        java.lang.String inputStreamMd5 = getInputStreamMd5(new java.io.ByteArrayInputStream(bArr));
                        randomAccessFile.close();
                        r7 = inputStreamMd5;
                    } catch (java.io.FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return r7;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return r7;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        try {
                            r7.close();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.io.FileNotFoundException e3) {
                e = e3;
                randomAccessFile = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                randomAccessFile = null;
            }
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        return r7;
    }

    public static java.lang.String getEndMd5FromFileForPatch(java.lang.String str) {
        return getEndMd5FromFile(str, 51200);
    }

    public static java.lang.String getFileMD5(java.io.File file) throws java.lang.Throwable {
        java.lang.String inputStreamMd5 = "";
        if (file.exists() && file.length() > 0) {
            java.io.BufferedInputStream bufferedInputStream = null;
            try {
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    inputStreamMd5 = getInputStreamMd5(bufferedInputStream2);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream2);
                } catch (java.io.FileNotFoundException unused) {
                    bufferedInputStream = bufferedInputStream2;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                } catch (java.lang.OutOfMemoryError unused2) {
                    bufferedInputStream = bufferedInputStream2;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                    throw th;
                }
            } catch (java.io.FileNotFoundException | java.lang.OutOfMemoryError unused3) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return inputStreamMd5;
    }

    public static java.lang.String getInputStreamMd5(java.io.InputStream inputStream) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4196];
            int i = 0;
            while (true) {
                int i2 = inputStream.read(bArr, 0, bArr.length);
                if (i2 == -1) {
                    break;
                }
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                    i += i2;
                }
            }
            return i == 0 ? "" : bytesToHexString(messageDigest.digest());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String toMD5(java.lang.String str) {
        return bytesToHexString(toMD5Byte(str));
    }

    public static byte[] toMD5Byte(java.lang.String str) {
        try {
            try {
                return java.security.MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
