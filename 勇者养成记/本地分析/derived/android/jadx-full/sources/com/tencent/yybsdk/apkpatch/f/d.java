package com.tencent.yybsdk.apkpatch.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f1422a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final java.lang.String a(java.io.InputStream inputStream) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int i2 = inputStream.read(bArr, 0, 8192);
                if (i2 == -1) {
                    break;
                }
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                    i += i2;
                }
            }
            return i == 0 ? "" : a(messageDigest.digest());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final java.lang.String a(java.io.InputStream inputStream, long j, long j2) {
        int i;
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            inputStream.skip(j);
            int i2 = 0;
            while (true) {
                long j3 = i2;
                if (j3 >= j2 || (i = inputStream.read(bArr, 0, (int) java.lang.Math.min(8192, j2 - j3))) == -1) {
                    break;
                    break;
                }
                messageDigest.update(bArr, 0, i);
                i2 += i;
            }
            return i2 == 0 ? "" : a(messageDigest.digest());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0046  */
    /* JADX WARN: Code duplicated, block: B:37:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0046, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static final java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        java.io.FileNotFoundException e;
        java.lang.String strA = "";
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            ?? length = file.length();
            if (length > 0) {
                try {
                    try {
                        fileInputStream = new java.io.FileInputStream(file);
                        try {
                            strA = a(fileInputStream);
                            length = fileInputStream;
                        } catch (java.io.FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            length = fileInputStream;
                            if (fileInputStream != null) {
                            }
                            return strA;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.io.FileNotFoundException e4) {
                    fileInputStream = null;
                    e = e4;
                } catch (java.lang.Throwable th3) {
                    length = 0;
                    th = th3;
                    if (length != 0) {
                        length.close();
                    }
                    throw th;
                }
                try {
                    length.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            } else {
                com.tencent.yybsdk.apkpatch.f.a.d(com.tencent.ysdk.shell.libware.encrypt.MD5.TAG, "filePath not exists! " + str);
                java.lang.System.out.println("andygzyu-MD5 E/filePath not exists! " + str);
            }
        } else {
            com.tencent.yybsdk.apkpatch.f.a.d(com.tencent.ysdk.shell.libware.encrypt.MD5.TAG, "filePath not exists! " + str);
            java.lang.System.out.println("andygzyu-MD5 E/filePath not exists! " + str);
        }
        return strA;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x004a, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [long] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static final java.lang.String a(java.lang.String str, long j, long j2) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        java.io.FileNotFoundException e;
        java.lang.String strA = "";
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            ?? length = file.length();
            if (length > 0) {
                a(file, j, j2);
                try {
                    try {
                        fileInputStream = new java.io.FileInputStream(file);
                        try {
                            strA = a(fileInputStream, j, j2 - j);
                            length = fileInputStream;
                        } catch (java.io.FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            length = fileInputStream;
                            if (fileInputStream != null) {
                            }
                            return strA;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.io.FileNotFoundException e4) {
                    fileInputStream = null;
                    e = e4;
                } catch (java.lang.Throwable th3) {
                    length = 0;
                    th = th3;
                    if (length != 0) {
                        length.close();
                    }
                    throw th;
                }
                try {
                    length.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            } else {
                com.tencent.yybsdk.apkpatch.f.a.d(com.tencent.ysdk.shell.libware.encrypt.MD5.TAG, "filePath not exists! " + str);
                java.lang.System.out.println("andygzyu-MD5 E/filePath not exists! " + str);
            }
        } else {
            com.tencent.yybsdk.apkpatch.f.a.d(com.tencent.ysdk.shell.libware.encrypt.MD5.TAG, "filePath not exists! " + str);
            java.lang.System.out.println("andygzyu-MD5 E/filePath not exists! " + str);
        }
        return strA;
    }

    public static final java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = f1422a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    private static final void a(java.io.File file, long j, long j2) {
        if (file.length() < j2 || j2 <= j || j < 0) {
            throw new java.lang.IllegalArgumentException("Must be (length > endPos && endPos > startPos && startPos >= 0)!\t|length:" + file.length() + "|startPos:" + j + "|endPos:" + j2 + "\t|File:" + file.getPath());
        }
    }
}
