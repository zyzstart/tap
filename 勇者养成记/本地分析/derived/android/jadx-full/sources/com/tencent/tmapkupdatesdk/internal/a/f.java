package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f992a;
    private final java.lang.String b;

    public f(java.lang.String str, java.lang.String str2) {
        this.f992a = str;
        this.b = str2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc A[Catch: IOException -> 0x00d0, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x00d0, blocks: (B:49:0x009c, B:71:0x00cc), top: B:103:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x004d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:21:0x004c */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:23:0x0051 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a() throws java.lang.Throwable {
        ?? r1;
        java.lang.Throwable th;
        java.util.zip.ZipFile zipFile;
        java.io.IOException e;
        ?? r2;
        java.util.zip.ZipFile zipFile2;
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th2;
        java.lang.Object obj;
        java.lang.Object obj2;
        java.io.FileOutputStream fileOutputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
         = 0;
        ?? r0 = 0;
        bufferedInputStream = null;
        bufferedInputStream2 = null;
        java.io.BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                java.util.zip.ZipFile zipFile3 = new java.util.zip.ZipFile(this.f992a);
                try {
                    if (!new java.io.File(this.f992a).exists()) {
                        try {
                            zipFile3.close();
                            return;
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    java.util.zip.ZipEntry entry = zipFile3.getEntry("META-INF/MANIFEST.MF");
                    try {
                        try {
                            if (entry != null) {
                                java.io.BufferedInputStream bufferedInputStream4 = new java.io.BufferedInputStream(zipFile3.getInputStream(entry));
                                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(this.b), false);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = bufferedInputStream4.read(bArr, 0, 1024);
                                    r0 = bArr;
                                    bufferedInputStream = bufferedInputStream4;
                                    fileOutputStream = fileOutputStream2;
                                    if (i == -1) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                zipFile3.close();
                            }
                            java.util.zip.ZipEntry entry2 = zipFile3.getEntry("META-INF\\MANIFEST.MF");
                            if (entry2 != null) {
                                java.io.BufferedInputStream bufferedInputStream5 = new java.io.BufferedInputStream(zipFile3.getInputStream(entry2));
                                java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream(new java.io.File(this.b), false);
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int i2 = bufferedInputStream5.read(bArr2, 0, 1024);
                                    r0 = bArr2;
                                    bufferedInputStream = bufferedInputStream5;
                                    fileOutputStream = fileOutputStream3;
                                    if (i2 == -1) {
                                        break;
                                    } else {
                                        fileOutputStream3.write(bArr2, 0, i2);
                                    }
                                }
                            } else {
                                bufferedInputStream = null;
                                fileOutputStream = null;
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            zipFile3.close();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            zipFile3.close();
                        } catch (java.io.IOException e5) {
                            e = e5;
                            zipFile2 = zipFile3;
                            r2 = r0;
                            bufferedInputStream3 = bufferedInputStream;
                            try {
                                e.printStackTrace();
                                if (bufferedInputStream3 != null) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (java.io.IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (r2 != 0) {
                                    try {
                                        r2.close();
                                    } catch (java.io.IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (zipFile2 != null) {
                                } else {
                                    zipFile2.close();
                                }
                            } catch (java.lang.Throwable th3) {
                                th2 = th3;
                                bufferedInputStream = bufferedInputStream3;
                                r0 = r2;
                                zipFile3 = zipFile2;
                                th = th2;
                                zipFile = zipFile3;
                                r1 = r0;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (java.io.IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (r1 != 0) {
                                    try {
                                        r1.close();
                                    } catch (java.io.IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                if (zipFile != null) {
                                    throw th;
                                }
                                try {
                                    zipFile.close();
                                    throw th;
                                } catch (java.io.IOException e10) {
                                    e10.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            th2 = th4;
                            th = th2;
                            zipFile = zipFile3;
                            r1 = r0;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (r1 != 0) {
                                r1.close();
                            }
                            if (zipFile != null) {
                                throw th;
                            }
                            zipFile.close();
                            throw th;
                        }
                    } catch (java.io.IOException e11) {
                        e = e11;
                        r0 = obj2;
                        zipFile2 = zipFile3;
                        r2 = r0;
                        bufferedInputStream3 = bufferedInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream3 != null) {
                            bufferedInputStream3.close();
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                        if (zipFile2 != null) {
                        } else {
                            zipFile2.close();
                        }
                    } catch (java.lang.Throwable th5) {
                        th2 = th5;
                        r0 = obj;
                        th = th2;
                        zipFile = zipFile3;
                        r1 = r0;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (zipFile != null) {
                            throw th;
                        }
                        zipFile.close();
                        throw th;
                    }
                } catch (java.io.IOException e12) {
                    e = e12;
                    zipFile2 = zipFile3;
                    r2 = 0;
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    zipFile = zipFile3;
                    r1 = 0;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (r1 != 0) {
                        r1.close();
                    }
                    if (zipFile != null) {
                        throw th;
                    }
                    zipFile.close();
                    throw th;
                }
            } catch (java.io.IOException e13) {
                e13.printStackTrace();
            }
        } catch (java.io.IOException e14) {
            e = e14;
            r2 = 0;
            zipFile2 = null;
        } catch (java.lang.Throwable th7) {
            r1 = 0;
            th = th7;
            zipFile = null;
        }
    }
}
