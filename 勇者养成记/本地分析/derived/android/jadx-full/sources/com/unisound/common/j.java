package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f1492a;

    private static boolean a(android.content.Context context, java.lang.String str, java.io.File file) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpen;
        java.io.FileOutputStream fileOutputStream;
        d(file.getAbsolutePath());
        try {
            inputStreamOpen = context.getAssets().open(str);
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i = inputStreamOpen.read(bArr, 0, 10240);
                        if (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            inputStreamOpen.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (java.lang.Exception unused) {
                                inputStreamOpen = null;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                inputStreamOpen = null;
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (java.io.IOException unused2) {
                                    }
                                }
                                if (fileOutputStream == null) {
                                    throw th;
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (java.io.IOException unused3) {
                                    throw th;
                                }
                            }
                        }
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        return false;
                    }
                } catch (java.lang.Exception unused6) {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception unused7) {
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception unused8) {
            inputStreamOpen = null;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStreamOpen = null;
            fileOutputStream = null;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File file = new java.io.File(str2);
        if (file.exists() && com.unisound.common.aa.a(str3, file)) {
            return true;
        }
        return a(context, str, file);
    }

    public static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return f(str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(java.lang.String str, int i, int i2) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        java.io.IOException e;
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            try {
                randomAccessFile = new java.io.RandomAccessFile(file, "rw");
                try {
                    try {
                        int length = (int) randomAccessFile.length();
                        randomAccessFile.seek(0L);
                        byte[] bArrA = com.unisound.common.be.a(length, i, i2);
                        if (bArrA != null) {
                            randomAccessFile.write(bArrA);
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            return true;
                        }
                        randomAccessFile.close();
                    } catch (java.io.IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return false;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e5) {
                e5.printStackTrace();
            }
        } catch (java.io.IOException e6) {
            randomAccessFile = null;
            e = e6;
        } catch (java.lang.Throwable th3) {
            randomAccessFile = null;
            th = th3;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        return false;
    }

    public static boolean a(boolean z, int i, java.lang.String str) throws java.lang.Throwable {
        if (str == null || "".equals(str) || !a(str)) {
            return false;
        }
        d(str);
        java.io.RandomAccessFile randomAccessFile = null;
        byte[] bArrA = a(z ? (short) i : (short) (-i));
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArrA);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
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

    public static boolean a(boolean z, java.lang.String str) {
        if (str == null || "".equals(str) || !a(str)) {
            return false;
        }
        d(str);
        java.io.RandomAccessFile randomAccessFile = null;
        byte[] bArrA = a(z ? Short.MAX_VALUE : (short) -32767);
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArrA);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
    }

    public static boolean a(byte[] bArr, java.lang.String str) {
        if (str == null || "".equals(str) || !a(str)) {
            return false;
        }
        d(str);
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArr);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
    }

    public static byte[] a(android.content.Context context) {
        if (f1492a == null) {
            f1492a = java.util.Arrays.copyOfRange(a(context, "empty"), 0, 6400);
        }
        return f1492a;
    }

    private static byte[] a(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpen;
        byte[] bArr;
        int i = 0;
        java.io.InputStream inputStream = null;
        byte[] bArr2 = null;
        inputStream = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
                try {
                    bArr2 = new byte[6400];
                    i = inputStreamOpen.read(bArr2, 0, bArr2.length);
                    bArr = bArr2;
                } catch (java.lang.Exception e) {
                    e = e;
                    byte[] bArr3 = bArr2;
                    inputStream = inputStreamOpen;
                    bArr = bArr3;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                bArr = null;
            }
            return i > 0 ? bArr : new byte[6400];
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamOpen = inputStream;
        }
    }

    public static byte[] a(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr[i] = (byte) ((s >>> 8) & 255);
        }
        return bArr;
    }

    public static boolean b(java.lang.String str) {
        return e(str) == com.unisound.common.k.WAV_EXTENSION_NAME;
    }

    public static boolean b(boolean z, java.lang.String str) throws java.lang.Throwable {
        if (str == null || "".equals(str) || !a(str)) {
            return false;
        }
        d(str);
        java.io.RandomAccessFile randomAccessFile = null;
        byte[] bArrA = a(z ? (short) 28000 : (short) -28000);
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArrA);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
    }

    public static boolean b(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        if (str == null || "".equals(str) || !a(str)) {
            return false;
        }
        d(str);
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArr);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
    }

    public static boolean c(java.lang.String str) {
        if (new java.io.File(str).exists()) {
            return f(str);
        }
        return false;
    }

    private static void d(java.lang.String str) {
        int iLastIndexOf;
        if (str != null && (iLastIndexOf = str.lastIndexOf(47)) >= 0) {
            new java.io.File(str.substring(0, iLastIndexOf)).mkdirs();
        }
    }

    private static com.unisound.common.k e(java.lang.String str) {
        int iLastIndexOf;
        if (android.text.TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(".")) <= 0) {
            return null;
        }
        java.lang.String strSubstring = str.substring(iLastIndexOf + 1);
        if (android.text.TextUtils.isEmpty(strSubstring)) {
            return com.unisound.common.k.NO_EXTENSION_NAME;
        }
        if (strSubstring.equalsIgnoreCase("pcm")) {
            return com.unisound.common.k.PCM_EXTENSION_NAME;
        }
        return strSubstring.equalsIgnoreCase("wav") ? com.unisound.common.k.WAV_EXTENSION_NAME : com.unisound.common.k.OTHER_EXTENSION_NAME;
    }

    private static boolean f(java.lang.String str) {
        com.unisound.common.k kVarE = e(str);
        if (kVarE == com.unisound.common.k.PCM_EXTENSION_NAME || kVarE == com.unisound.common.k.WAV_EXTENSION_NAME) {
            return true;
        }
        com.unisound.common.y.a("fileName illegal");
        return false;
    }
}
